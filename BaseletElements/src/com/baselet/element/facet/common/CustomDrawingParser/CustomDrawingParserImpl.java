package com.baselet.element.facet.common.CustomDrawingParser;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.TokenStream;

import com.baselet.diagram.draw.DrawHandler;

public class CustomDrawingParserImpl extends CustomDrawingParserParser {

	private final double width;
	private final double height;
	private final DrawHandler drawHandler;

	public CustomDrawingParserImpl(TokenStream input, double width, double height, DrawHandler drawHandler) {
		super(input);
		this.width = width;
		this.height = height;
		this.drawHandler = drawHandler;
		setErrorHandler(new BailErrorStrategy());
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public DrawHandler getDrawHandler() {
		// System.out.println(">>>getDrawHandler<<<");
		return drawHandler;
	}

}
