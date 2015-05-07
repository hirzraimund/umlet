package com.baselet.element.facet.common;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;

import com.baselet.control.enums.FormatLabels;
import com.baselet.control.enums.Priority;
import com.baselet.element.facet.Facet;
import com.baselet.element.facet.PropertiesParserState;
import com.baselet.element.facet.common.CustomDrawingParser.CustomDrawingParserImpl;
import com.baselet.element.facet.common.CustomDrawingParser.CustomDrawingParserLexer;
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
			try {
				System.out.println(String.format("Parsing string: '%s'", line));
				CustomDrawingParserLexer lexer = new CustomDrawingParserLexer(new ANTLRInputStream(line));
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				new CustomDrawingParserImpl(tokens, state.getGridElementSize().getWidth(), state.getGridElementSize().getHeight(), state.getDrawer()).parse();
			} catch (Exception e) {
				System.out.println("error while parsing");
				// throw new RuntimeException(e);
			}
		}
	}

	@Override
	public List<AutocompletionText> getAutocompletionStrings() {
		List<AutocompletionText> autocompletionList = new LinkedList<AutocompletionText>();
		autocompletionList.add(new AutocompletionText(CODE_SEP_START, CODE_START_INFO));
		// TODO auto completion for the drawing methods
		/* for (DrawMethod dm : supportedDrawingMethods) { autocompletionList.add(new AutocompletionText(dm.name, "")); } */
		return autocompletionList;
	}

	@Override
	public Priority getPriority() {
		return Priority.HIGHEST;
	}
}
