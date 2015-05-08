package com.baselet.element.facet.common;

import static com.baselet.element.facet.common.CustomDrawingFacet.DrawMethod.ParameterType.ALIGNMENT;
import static com.baselet.element.facet.common.CustomDrawingFacet.DrawMethod.ParameterType.BOOL;
import static com.baselet.element.facet.common.CustomDrawingFacet.DrawMethod.ParameterType.DOUBLE;
import static com.baselet.element.facet.common.CustomDrawingFacet.DrawMethod.ParameterType.STRING;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.baselet.control.enums.AlignHorizontal;
import com.baselet.control.enums.FormatLabels;
import com.baselet.control.enums.LineType;
import com.baselet.control.enums.Priority;
import com.baselet.diagram.draw.DrawHandler;
import com.baselet.diagram.draw.helper.ColorOwn;
import com.baselet.diagram.draw.helper.ColorOwn.Transparency;
import com.baselet.element.facet.Facet;
import com.baselet.element.facet.PropertiesParserState;
import com.baselet.gui.AutocompletionText;

public class CustomDrawingFacet extends Facet {

	public static final CustomDrawingFacet INSTANCE = new CustomDrawingFacet();
	public static final Logger logger = Logger.getLogger(CustomDrawingFacet.class);
	public static final String CODE_SEP_START = "customelement=";
	public static final String CODE_START_INFO = "indicates the start of custom drawing commands, has no close command.";

	@Override
	public boolean checkStart(String line, PropertiesParserState state) {
		Object objIsActive = state.getFacetResponse(CustomDrawingFacet.class, false);
		if (objIsActive instanceof Boolean && (Boolean) objIsActive) {
			return true;
		}
		else if (CODE_SEP_START.equals(line)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void handleLine(String line, PropertiesParserState state) {
		if (CODE_SEP_START.equals(line)) {
			Object objIsActive = state.getFacetResponse(CustomDrawingFacet.class, false);
			if (objIsActive instanceof Boolean && (Boolean) objIsActive) {
				// custom commands are already turned on -> error
				throw new RuntimeException(FormatLabels.BOLD.getValue() + "Invalid value: " + FormatLabels.BOLD.getValue() + CODE_SEP_START + "\nDuplicate command. This command may only occur once.");
			}
			state.setFacetResponse(CustomDrawingFacet.class, true);
		}
		else {
			line = line.trim();
			if (!line.startsWith("//") && !line.isEmpty())
			{
				boolean found = false;
				for (DrawMethod drawMethod : supportedDrawingMethods)
				{
					if (line.startsWith(drawMethod.name + '(') && line.contains(")"))
					{
						found = true;
						drawMethod.parseLine(state.getDrawer(), line);
						break;
					}
				}
				if (!found) {
					throw new RuntimeException(FormatLabels.BOLD.getValue() + "Invalid value:" + FormatLabels.BOLD.getValue() + " '" + line + "'\nNo custom drawing command with this name was found.");
				}
			}
		}
	}

	@Override
	public List<AutocompletionText> getAutocompletionStrings() {
		List<AutocompletionText> autocompletionList = new LinkedList<AutocompletionText>();
		autocompletionList.add(new AutocompletionText(CODE_SEP_START, CODE_START_INFO));
		for (DrawMethod dm : supportedDrawingMethods) {
			autocompletionList.add(new AutocompletionText(dm.name, ""));
		}
		return autocompletionList;
	}

	@Override
	public Priority getPriority() {
		return Priority.HIGHEST;
	}

	DrawMethod[] supportedDrawingMethods = {
			new DrawMethod("drawRectangle", new DrawMethod.ParameterType[] { DOUBLE, DOUBLE, DOUBLE, DOUBLE }, new DrawMethod.Setting[] { DrawMethod.fg, DrawMethod.bg, DrawMethod.lt, DrawMethod.lw })
			{

				@Override
				protected void draw(DrawHandler drawHandler, Object[] parameters) {
					drawHandler.drawRectangle((Double) parameters[0], (Double) parameters[1], (Double) parameters[2], (Double) parameters[3]);
				}

			},
			new DrawMethod("drawLine", new DrawMethod.ParameterType[] { DOUBLE, DOUBLE, DOUBLE, DOUBLE }, new DrawMethod.Setting[] { DrawMethod.fg, DrawMethod.lt, DrawMethod.lw })
			{

				@Override
				protected void draw(DrawHandler drawHandler, Object[] parameters) {
					drawHandler.drawLine((Double) parameters[0], (Double) parameters[1], (Double) parameters[2], (Double) parameters[3]);
				}

			},
			new DrawMethod("drawArc", new DrawMethod.ParameterType[] { DOUBLE, DOUBLE, DOUBLE, DOUBLE, DOUBLE, DOUBLE, BOOL }, new DrawMethod.Setting[] { DrawMethod.fg, DrawMethod.bg, DrawMethod.lt, DrawMethod.lw })
			{

				@Override
				protected void draw(DrawHandler drawHandler, Object[] parameters) {
					drawHandler.drawArc((Double) parameters[0], (Double) parameters[1], (Double) parameters[2], (Double) parameters[3], (Double) parameters[4], (Double) parameters[5], (Boolean) parameters[6]);
				}

			},
			new DrawMethod("drawCircle", new DrawMethod.ParameterType[] { DOUBLE, DOUBLE, DOUBLE }, new DrawMethod.Setting[] { DrawMethod.fg, DrawMethod.bg, DrawMethod.lt, DrawMethod.lw })
			{

				@Override
				protected void draw(DrawHandler drawHandler, Object[] parameters) {
					drawHandler.drawCircle((Double) parameters[0], (Double) parameters[1], (Double) parameters[2]);
				}

			},
			new DrawMethod("drawEllipse", new DrawMethod.ParameterType[] { DOUBLE, DOUBLE, DOUBLE, DOUBLE }, new DrawMethod.Setting[] { DrawMethod.fg, DrawMethod.bg, DrawMethod.lt, DrawMethod.lw })
			{

				@Override
				protected void draw(DrawHandler drawHandler, Object[] parameters) {
					drawHandler.drawEllipse((Double) parameters[0], (Double) parameters[1], (Double) parameters[2], (Double) parameters[3]);
				}

			},
			new DrawMethod("drawRectangleRound", new DrawMethod.ParameterType[] { DOUBLE, DOUBLE, DOUBLE, DOUBLE, DOUBLE }, new DrawMethod.Setting[] { DrawMethod.fg, DrawMethod.bg, DrawMethod.lt, DrawMethod.lw })
			{

				@Override
				protected void draw(DrawHandler drawHandler, Object[] parameters) {
					drawHandler.drawRectangleRound((Double) parameters[0], (Double) parameters[1], (Double) parameters[2], (Double) parameters[3], (Double) parameters[4]);
				}

			},
			new DrawMethod("drawText", new DrawMethod.ParameterType[] { STRING, DOUBLE, DOUBLE, ALIGNMENT }, new DrawMethod.Setting[] { DrawMethod.fg }) {

				@Override
				protected void draw(DrawHandler drawHandler, Object[] parameters) {
					drawHandler.print((String) parameters[0], (Double) parameters[1], (Double) parameters[2], (AlignHorizontal) parameters[3]);
				}

			}
	};

	/**
	 *
	 * Method(drawing parameters, foregroundColor, backgroundColor)
	 *
	 */
	abstract static class DrawMethod {

		enum ParameterType {
			DOUBLE, BOOL, STRING, ALIGNMENT
		}

		static final Setting fg = new Setting("fg=") {

			@Override
			RecRunnable parseValue(String value, final DrawHandler drawHandler, final RecRunnable inner) {

				final ColorOwn newColor = ColorOwn.forString(value, Transparency.FOREGROUND);

				// TODO Auto-generated method stub
				return new RecRunnable(inner) {

					@Override
					public void run() {
						ColorOwn oldColor = drawHandler.getForegroundColor();
						drawHandler.setForegroundColor(newColor);
						runInner();
						drawHandler.setForegroundColor(oldColor);
					}
				};
			}
		};
		static final Setting bg = new Setting("bg=") {

			@Override
			RecRunnable parseValue(String value, final DrawHandler drawHandler, final RecRunnable inner) {

				final ColorOwn newColor = ColorOwn.forString(value, Transparency.BACKGROUND);

				// TODO Auto-generated method stub
				return new RecRunnable(inner) {

					@Override
					public void run() {
						ColorOwn oldColor = drawHandler.getBackgroundColor();
						drawHandler.setBackgroundColor(newColor);
						runInner();
						drawHandler.setBackgroundColor(oldColor);
					}
				};
			}
		};
		static final Setting lt = new Setting("lt=") {

			@Override
			RecRunnable parseValue(String value, final DrawHandler drawHandler, final RecRunnable inner) {
				final LineType newLineType;

				if (value.equals("-")) {
					newLineType = LineType.SOLID;
				}
				else if (value.equals(".")) {
					newLineType = LineType.DASHED;
				}
				else if (value.equals("..")) {
					newLineType = LineType.DOTTED;
				}
				else if (value.equals("=")) {
					newLineType = LineType.DOUBLE;
				}
				else if (value.equals(":")) {
					newLineType = LineType.DOUBLE_DASHED;
				}
				else if (value.equals("::")) {
					newLineType = LineType.DOUBLE_DOTTED;
				}
				else {
					throw new RuntimeException("Line type can only be one of SOLID(\"-\"), DASHED(\".\"), DOTTED(\"..\"), DOUBLE(\"=\"), DOUBLE_DASHED(\":\"), DOUBLE_DOTTED(\"::\")");
				}
				// TODO Auto-generated method stub
				return new RecRunnable(inner) {

					@Override
					public void run() {
						LineType oldLineType = drawHandler.getLineType();
						drawHandler.setLineType(newLineType);
						runInner();
						drawHandler.setLineType(oldLineType);
					}
				};
			}
		};
		static final Setting lw = new Setting("lw=") {

			@Override
			RecRunnable parseValue(String value, final DrawHandler drawHandler, final RecRunnable inner) {
				final double newLw;
				try {
					newLw = Double.parseDouble(value);
				} catch (NumberFormatException e) {
					throw new RuntimeException("Line width must be a number. '" + value + "' couldn't be parsed.");
				}

				// TODO Auto-generated method stub
				return new RecRunnable(inner) {

					@Override
					public void run() {
						double oldLw = drawHandler.getLineWidth();
						drawHandler.setLineWidth(newLw);
						runInner();
						drawHandler.setLineWidth(oldLw);
					}
				};
			}
		};

		final String name;
		/**
		 * without background- or foregroundcolor
		 */
		final ParameterType[] parameterList;
		final Setting[] supportedSettings;

		public DrawMethod(String name, ParameterType[] parameterList, Setting[] supportedSettings) {
			super();
			this.name = name;
			this.parameterList = parameterList;
			this.supportedSettings = supportedSettings;
		}

		void parseLine(DrawHandler drawHandler, String line)
		{
			if (line.startsWith(name))
			{
				int lastClosingBracket = line.lastIndexOf(')');
				// remove method name an parentheses
				String[] parameters = splitAtComma(line.substring(name.length() + 1, lastClosingBracket));
				if (parameters.length == parameterList.length)
				{
					parseSettings(drawHandler, line.substring(lastClosingBracket + 1).trim(), parseCommand(drawHandler, parameters));
				}
				else
				{
					// parameters count is mismatching
					throw new RuntimeException("The drawing command '" + name + "' expectes exactly " + parameterList.length + " parameters.");
				}
			}
			else
			{
				// should never happen
			}
		}

		private String[] splitAtComma(String str) {
			LinkedList<String> ret = new LinkedList<String>();
			boolean quotes = false;
			boolean prevEscapeChar = false;
			boolean escapeChar = false;
			int start = 0;
			int i;
			for (i = 0; i < str.length(); i++) {
				escapeChar = false;
				if (str.charAt(i) == '\\') {
					// only if the previous char wasn't \ it is an escape char
					if (!prevEscapeChar) {
						escapeChar = true;
					}
				}
				else {
					if (!quotes) {
						if (str.charAt(i) == ',') {
							ret.add(str.substring(start, i));
							start = i + 1;
						}
						else if (str.charAt(i) == '"' && !prevEscapeChar) {
							quotes = true;
						}
					}
					else {
						if (str.charAt(i) == '"' && !prevEscapeChar) {
							quotes = false;
						}
					}
				}
				prevEscapeChar = escapeChar;
			}
			if (i > start) {
				ret.add(str.substring(start, i));
			}
			return ret.toArray(new String[0]);
		}

		private RecRunnable parseCommand(final DrawHandler drawHandler, String[] parameters) {
			final Object[] parsedParameters = new Object[parameters.length];
			int i;
			for (i = 0; i < parameterList.length; i++)
			{
				parsedParameters[i] = parse(parameterList[i], parameters[i].trim());
			}
			return new RecRunnable(null) {
				@Override
				public void run() {
					draw(drawHandler, parsedParameters);
				}
			};
		}

		private void parseSettings(DrawHandler drawHandler, String settingsStrList, RecRunnable drawCmd) {
			// TODO
			if (!settingsStrList.isEmpty()) {
				String[] settingsList = settingsStrList.split("\\s+");
				for (String setting : settingsList) {
					boolean found = false;
					for (Setting s : supportedSettings) {
						if (setting.startsWith(s.key)) {
							drawCmd = s.parse(setting, drawHandler, drawCmd);
							found = true;
							break;
						}
					}
					if (!found) {
						throw new RuntimeException("Drawing command '" + name + "' doesn't support the setting: '" + setting + "'.");
					}
				}
			}
			drawCmd.run();
		}

		private Object parse(ParameterType type, String str)
		{
			// TODO proper value/exception handling
			switch (type) {
				case DOUBLE:
					return Double.parseDouble(str);
				case BOOL:
					return Boolean.parseBoolean(str);
				case STRING:
					return str;
				case ALIGNMENT:
					String upper = str.toUpperCase();
					return AlignHorizontal.valueOf(upper);
				default:
					// TODO throw exception
					return null;
			}
		}

		private void drawWithFg(DrawHandler drawHandler, ColorOwn fg, Object[] parameters)
		{
			ColorOwn oldFg = drawHandler.getForegroundColor();
			drawHandler.setForegroundColor(fg);
			draw(drawHandler, parameters);
			drawHandler.setForegroundColor(oldFg);
		}

		private void drawWithBg(DrawHandler drawHandler, ColorOwn bg, Object[] parameters)
		{
			ColorOwn oldBg = drawHandler.getBackgroundColor();
			drawHandler.setBackgroundColor(bg);
			draw(drawHandler, parameters);
			drawHandler.setBackgroundColor(oldBg);
		}

		private void drawWithFgBg(DrawHandler drawHandler, ColorOwn fg, ColorOwn bg, Object[] parameters)
		{
			ColorOwn oldBg = drawHandler.getBackgroundColor();
			drawHandler.setBackgroundColor(bg);
			drawWithFg(drawHandler, fg, parameters);
			drawHandler.setBackgroundColor(oldBg);
		}

		protected abstract void draw(DrawHandler drawHandler, Object[] parameters);

		private static abstract class RecRunnable {
			private final RecRunnable inner;

			public RecRunnable(RecRunnable inner) {
				this.inner = inner;
			}

			public abstract void run();

			protected void runInner() {
				if (inner != null) {
					inner.run();
				}
			}
		}

		public static abstract class Setting {
			protected String key;

			public Setting(String key) {
				super();
				this.key = key;
			}

			RecRunnable parse(String keyValue, DrawHandler drawHandler, final RecRunnable inner) {
				return parseValue(keyValue.substring(key.length()), drawHandler, inner);
			}

			abstract RecRunnable parseValue(String value, DrawHandler drawHandler, final RecRunnable inner);
		}
	}
}
