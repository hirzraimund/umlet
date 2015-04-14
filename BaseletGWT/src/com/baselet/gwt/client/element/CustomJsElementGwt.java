package com.baselet.gwt.client.element;

import org.apache.log4j.Logger;

import com.baselet.diagram.draw.DrawHandler;
import com.baselet.element.elementnew.CustomElement;
import com.baselet.element.facet.PropertiesParserState;

public class CustomJsElementGwt extends CustomElement {

	private static final Logger log = Logger.getLogger(CustomJsElementGwt.class);

	// private final String properties = "das sind\n3 Zeilen\nzum Testen";
	private final String myTestProperties = "das eine Zeile zum Testen\\nasdf";
	private final String js = "" +
								// "console.log('propertiesString');" +
								// "console.log(propertiesString);" +
								// "console.log('$wnd.drawRect');" +
								// "console.log($wnd.drawRect);" +
								"var lines = propertiesString.split('\\n');" +
								// "var lines = ['das ist ein', 'Test', 'ueber 3 zeilen'];" +
								"var startX = 10;" +
								"var startY = 10;" +
								"var width = 15;" +
								"var height = 15;" +
								"var gapX = 10;" +
								"var gapY = 10;" +
								"for(var i = 0; i < lines.length; i++)" +
								"{" +
								// "console.log('x: ' + (startX + (width + gapX) * i) + '; y: ' + (startY + (height + gapY) * i) + '; width: ' + width + '; height: ' + height);" +
								"$wnd.drawRect(startX + (width + gapX) * i, startY + (height + gapY) * i, width, height);" +
								"};" +
								"";

	@Override
	protected void drawCommonContent(PropertiesParserState state) {
		getHandler();// false Handler this is NOT the Draw Handler!!!
		// myDraw5(myTestProperties, js);
		StringBuilder strBuilder = new StringBuilder();
		for (String e : getPanelAttributesAsList())
		{
			strBuilder.append(e);
			strBuilder.append("\\n");
		}
		myDraw5(strBuilder.substring(0, strBuilder.length() - 2), js);
	}

	/* private native void myDraw(PropertiesParserState state, String properties2, String js2) /*-{ var drawHandler = this .@com.baselet.gwt.client.element.CustomJsElementGwt::getHandler(); var propertiesString = properties2; eval(js2); }-*; */

	private native void myDraw1(String properties2, String js2) /*-{
		var that = this
				.@com.baselet.gwt.client.element.CustomJsElementGwt::getHandler();
		$wnd.drawRect = $entry(function(x, y, width, height) {
			that.@com.baselet.gwt.client.element.DrawHandlerGwt::drawRectangle(DDDD)(x, y, width, height);
		});
		console.log('that');
		console.log(that);
		console.log('$wnd');
		console.log($wnd);
		console.log('$wnd.drawRect');
		console.log($wnd.drawRect);

		eval("var propertiesString = '" + properties2 + "'; " + js2);
	}-*/;

	private native void myDraw2(String myproperties2, String js2) /*-{
		var that = this;
		var drawHandler = that
				.@com.baselet.gwt.client.element.CustomJsElementGwt::getHandler();

		var propertiesString = myproperties2;
		$wnd.drawRect = drawHandler.drawRectangle;

		console.log('drawHandler');
		console.log(drawHandler);
		console.log('$wnd');
		console.log($wnd);
		console.log('$wnd.drawRect');
		console.log($wnd.drawRect);

		eval("var propertiesString = '" + myproperties2 + "'; " + js2);
	}-*/;

	private native void myDraw3(String myproperties2, String js2) /*-{
		var that = this;
		var drawHandler = that
				.@com.baselet.gwt.client.element.CustomJsElementGwt::getHandler();
		$wnd.drawRect = $entry(function(x, y, width, height) {
			drawHandler.@com.baselet.gwt.client.element.DrawHandlerGwt::drawRectangle(DDDD)(drawHandler, x, y, width, height);
		});

		console.log('drawHandler');
		console.log(drawHandler);
		console.log('$wnd');
		console.log($wnd);
		console.log('$wnd.drawRect');
		console.log($wnd.drawRect);

		eval("var propertiesString = '" + myproperties2 + "'; " + js2);
	}-*/;

	private native void myDraw4(String myproperties2, String js2) /*-{
		var that = this;
		var drawHandler = that
				.@com.baselet.gwt.client.element.CustomJsElementGwt::getHandler();
		$wnd.drawRect = $entry(function(x, y, width, height) {
			@com.baselet.gwt.client.element.CustomJsElementGwt.MyJsDrawHandler::drawRectangle(Lcom/baselet/diagram/draw/DrawHandler;DDDD)(drawHandler, x, y, width, height);
		});
		//$wnd.drawRect = drawHandler.drawRectangle;

		console.log('drawHandler');
		console.log(drawHandler);
		console.log('$wnd');
		console.log($wnd);
		console.log('$wnd.drawRect');
		console.log($wnd.drawRect);

		eval("var propertiesString = '" + myproperties2 + "'; " + js2);
	}-*/;

	private native void myDraw5(String myproperties2, String js2) /*-{
		var that = this;
		//var comp = that
		//.@com.baselet.gwt.client.element.CustomJsElementGwt::getComponent()();
		//var drawHandler = that
		//.@com.baselet.gwt.client.element.CustomJsElementGwt::getDrawHandler();
		var drawHandler = that.@com.baselet.gwt.client.element.CustomJsElementGwt::getDrawHandler()();
		$wnd.drawRect = $entry(function(x, y, width, height) {
			drawHandler.@com.baselet.gwt.client.element.DrawHandlerGwt::drawRectangle(DDDD)(x, y, width, height);
		});

		//console.log('drawHandler');
		//console.log(drawHandler);
		//console.log('$wnd');
		//console.log($wnd);
		//console.log('$wnd.drawRect');
		//console.log($wnd.drawRect);

		eval("'use strict'; var propertiesString = '" + myproperties2 + "'; "
				+ js2);
	}-*/;

	public DrawHandler getDrawHandler()
	{
		return getComponent().getDrawHandler();
	}

	public void drawRectangle(double x, double y, double width, double height)
	{
		// getHandler().
	}

	public static class MyJsDrawHandler
	{
		public static void drawRectangle(DrawHandler dh, double x, double y, double width, double height)
		{
			// only visible in dev mode (which is broken in chrome)
			// GWT.log("x: " + x + "; y: " + y + "; width: " + width + "; height: " + height);
			// Logger logger = Logger.getLogger(CustomJsElementGwt.class);
			// logger.fatal("x: " + x + "; y: " + y + "; width: " + width + "; height: " + height);
			log.fatal("x: " + x + "; y: " + y + "; width: " + width + "; height: " + height);
			dh.drawRectangle(x, y, width, height);
		}
	}
}
