package com.umlet.element.experimental;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.baselet.control.Constants;
import com.baselet.control.Constants.AlignHorizontal;
import com.baselet.control.Constants.AlignVertical;
import com.baselet.control.Utils;
import com.baselet.diagram.draw.BaseDrawHandler;
import com.umlet.element.experimental.settings.Settings;
import com.umlet.element.experimental.settings.SettingsClass;
import com.umlet.element.experimental.settings.SettingsUseCase;
import com.umlet.element.experimental.settings.text.Facet;

public class Properties {

	public enum SettingKey {
		ForegroundColor("fg", "red"),
		BackgroundColor("bg", "#0A37D3"),
		LineType("lt", "."),
		AutoResize("autoresize", "true"),
		NotResizable("notresizable", "true"),
		WordWrap("wordwrap", "true"),
		VerticalAlign("valign", AlignVertical.values()),
		HorizontalAlign("halign", AlignHorizontal.values());

		private String key;
		private Object[] autocompletionValues;

		SettingKey(String key, String ... autocompletionValues) {
			this.key = key;
			this.autocompletionValues = autocompletionValues;
		}

		SettingKey(String key, Object[] autocompletionValues) {
			this.key = key;
			this.autocompletionValues = autocompletionValues;
		}

		public String getKey() {
			return key;
		}

		@Override
		public String toString() {
			return key;
		}

		public Object[] autocompletionValues() {
			return autocompletionValues;
		}

	}

	public static final String SEPARATOR = "=";

	protected String panelAttributes = "";
	protected String panelAttributesAdditional = "";

	private BaseDrawHandler drawer;

	protected HashMap<String, String> settings = new HashMap<String, String>();

	private int gridElementWidth;
	private int gridElementHeight;

	private List<String> propertiesTextToDraw;

	private PropertiesConfig propCfg;

	public Properties(String panelAttributes, String panelAttributesAdditional, BaseDrawHandler drawer) {
		this.panelAttributes = panelAttributes;
		this.panelAttributesAdditional = panelAttributesAdditional;
		this.drawer = drawer;
	}

	public String getPanelAttributes() {
		return panelAttributes;
	}

	public String getPanelAttributesAdditional() {
		return panelAttributesAdditional;
	}

	public void setPanelAttributes(String panelAttributes) {
		this.panelAttributes = panelAttributes;
	}

	public void setPanelAttributesAdditional(String panelAttributesAdditional) {
		this.panelAttributesAdditional = panelAttributesAdditional;
	}

	private static String filterRegex;
	static {
		filterRegex = "(";
		for (SettingKey key : SettingKey.values()) {
			filterRegex = filterRegex + "(" + key + Properties.SEPARATOR + ")|";
		}
		filterRegex += "(//)).*";
	}

	private Vector<String> getPropertiesText() {
		return decomposePropertiesText(this.getPanelAttributes(), Constants.NEWLINE, false, true);
	}

	public Vector<String> getPropertiesTextFiltered() {
		return decomposePropertiesText(this.getPanelAttributes(), Constants.NEWLINE, true, false);
	}

	private Vector<String> decomposePropertiesText(String fullString, String delimiter, boolean filterComments, boolean filterNewLines) {
		Vector<String> returnVector = new Vector<String>();
		String compatibleFullString = fullString.replaceAll("\r\n", delimiter); // compatibility to windows \r\n

		for (String line : compatibleFullString.split("\\" + delimiter)) {
			if (filterComments && (line.matches(filterRegex))) continue;
			else if (filterNewLines && line.isEmpty()) continue;
			else returnVector.add(line);
		}

		return returnVector;
	}

	private void applyProperties() {
		Color fgColor = Utils.getColor(getSetting(SettingKey.ForegroundColor));
		if (fgColor == null) { // if fg is not set or invalid
			fgColor = Constants.DEFAULT_FOREGROUND_COLOR;
		}
		drawer.setForegroundColor(fgColor);

		float bgAlpha = Constants.ALPHA_MIDDLE_TRANSPARENCY;
		Color bgColor = Utils.getColor(getSetting(SettingKey.BackgroundColor));
		if (bgColor == null) { // if bg is not set or invalid, the background is white at full transparency
			bgColor = Constants.DEFAULT_BACKGROUND_COLOR;
			bgAlpha = Constants.ALPHA_FULL_TRANSPARENCY;
		}
		drawer.setBackground(bgColor, bgAlpha);

		drawer.setLineType(getSetting(SettingKey.LineType));
	}

	public void initSettingsFromText(int gridElementWidth, int gridElementHeight) {
		this.gridElementWidth = gridElementWidth;
		this.gridElementHeight = gridElementHeight;
		settings.clear();
		for (String line : getPropertiesText()) {
			if (line.contains(SEPARATOR)) {
				String[] split = line.split(SEPARATOR, 2);
				settings.put(split[0], split[1]);
			}
		}
		applyProperties();

		propertiesTextToDraw = getPropertiesTextAndApplyWordWrapIfSet();
	}

	public String getSetting(SettingKey key) {
		return settings.get(key.toString());
	}

	public boolean containsSetting(SettingKey key, String checkValue) {
		String realValue = settings.get(key.toString());
		if (realValue == null && checkValue == null) return true;
		return realValue != null && realValue.equals(checkValue);
	}

	public void updateSetting(String key, String newValue) {
		String newState = "";
		for (String line : Utils.decomposeStringsWithComments(this.getPanelAttributes())) {
			if (!line.startsWith(key)) newState += line + "\n";
		}
		newState = newState.substring(0, newState.length()-1); //remove last linebreak
		if (newValue != null) newState += "\n" + key + SEPARATOR + newValue; // null will not be added as a value
		this.setPanelAttributes(newState);
	}

	public void drawPropertiesText(Settings elementSettings) {
		propCfg = new PropertiesConfig(this, elementSettings, gridElementHeight, gridElementWidth);
		propCfg.addToYPos(calcStartPos(elementSettings));

		for (String line : propertiesTextToDraw) {
			boolean drawText = true;
			for (Facet facet : elementSettings.getFacets()) {
				if (facet.checkStart(line)) {
					facet.handleLine(line, drawer, propCfg);
					if (facet.replacesText(line)) drawText = false;
				}
			}
			if (drawText) {
				drawer.print(line, calcXToPrintText(), propCfg.getyPos(), propCfg.gethAlign());
				propCfg.addToYPos(drawer.textHeightWithSpace());
			}
		}
	}

	private float calcXToPrintText() {
		float[] xLimitsTop = propCfg.getXLimits(propCfg.getyPos());
		float[] xLimitsBottom = propCfg.getXLimits(propCfg.getyPos() - drawer.textHeight());
		float leftTextLimit = Math.max(xLimitsTop[0], xLimitsBottom[0]);
		float rightTextLimit = Math.min(xLimitsTop[1], xLimitsBottom[1]);
		float x;
		if (propCfg.gethAlign() == AlignHorizontal.LEFT) {
			x = leftTextLimit + drawer.getDistanceBetweenTexts();
		} else if (propCfg.gethAlign() == AlignHorizontal.CENTER) {
			x = propCfg.getGridElementWidth() / 2;
		} else /*if (propCfg.gethAlign() == AlignHorizontal.RIGHT)*/ {
			x = rightTextLimit - drawer.getDistanceBetweenTexts();
		}
		return x;
	}

	private List<String> getPropertiesTextAndApplyWordWrapIfSet() {
		List<String> propertiesTextFiltered = new ArrayList<String>();
		if (Boolean.valueOf(getSetting(SettingKey.WordWrap))) {
			Vector<String> oneLine = getPropertiesTextFiltered();
			for (String line : oneLine) {
				propertiesTextFiltered.addAll(Utils.splitString(line, gridElementWidth, drawer));
			}
		}
		else propertiesTextFiltered.addAll(getPropertiesTextFiltered());
		return propertiesTextFiltered;
	}

	public float getTextBlockHeight(Settings elementSettings) {
		float textBlockHeight = 0;
		for (String line : propertiesTextToDraw) {
			boolean drawText = true;
			for (Facet facet : elementSettings.getFacets()) {
				if (facet.checkStart(line)) {
					textBlockHeight += facet.getHorizontalSpace();
					if (facet.replacesText(line)) drawText = false;
				}
			}
			if (drawText) {
				textBlockHeight += drawer.textHeightWithSpace();
			}
		}
		return textBlockHeight;
	}

	private float calcStartPos(Settings calc) {
		float textWidth = 0;
		if (!propertiesTextToDraw.isEmpty()) {
			textWidth = drawer.textWidth(propertiesTextToDraw.get(0));
		}
		float textHeight = getTextBlockHeight(calc);
		if (propCfg.getvAlign() == AlignVertical.TOP) {
			return calcNotInterferingStartPoint(textWidth, gridElementWidth, gridElementHeight, drawer.textHeight()/2, -drawer.textHeight(), drawer.textHeightWithSpace(), calc);
		}
		else if (propCfg.getvAlign() == AlignVertical.CENTER) {
			float startPoint = Math.max((gridElementHeight - textHeight)/2 + (drawer.textHeight() * 0.9f), drawer.textHeightWithSpace());
			return calcNotInterferingStartPoint(textWidth, gridElementWidth, gridElementHeight, drawer.textHeight()/2, -drawer.textHeight(), startPoint, calc);
		}
		else /*if (propCfg.getvAlign() == AlignVertical.BOTTOM)*/ {
			return Math.max(gridElementHeight - textHeight, drawer.textHeightWithSpace());
		}
	}

	private float calcNotInterferingStartPoint(float textWidth, int width, int height, float increment, float relevantDisplacement, float start, Settings calc) {
		float yPos = start - increment;
		float[] xVals;
		float availableSpace;
		do {
			yPos += increment;
			xVals = calc.getXValues(yPos+relevantDisplacement, height, width);
			availableSpace = xVals[1]-xVals[0];
		} while (availableSpace <= textWidth && yPos < height/2);
		return yPos;
	}

}