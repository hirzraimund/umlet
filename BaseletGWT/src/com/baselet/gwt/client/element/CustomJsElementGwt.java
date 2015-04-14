package com.baselet.gwt.client.element;

import org.apache.log4j.Logger;

import com.baselet.diagram.draw.DrawHandler;
import com.baselet.element.elementnew.CustomElement;
import com.baselet.element.facet.PropertiesParserState;

// GWT implementations of the javascript Custom element
// all the drawing is done in drawCommonContent, it calls a JSNI (native javascript) function
// (myDraw5), this function exports the drawing function from the drawhandler so it can
// be called from custom JS (for this demo only drawRectangle is exported as $wnd.drawRect(...) )
// then eval with the properties text and a javascript (both strings) is called
// this javascript is now able to access the drawing functions with $wnd.drawRect
public class CustomJsElementGwt extends CustomElement {

	private static final Logger log = Logger.getLogger(CustomJsElementGwt.class);

	// in further versions this should be written by the user (some gui is needed)
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
		// getPanelAttributes is not working since the javascript function myDraw5 can't be called with strings which contain \n.
		// Therefore it is necessary to build an extra string with \\n, which can be parsed
		StringBuilder strBuilder = new StringBuilder();
		for (String e : getPanelAttributesAsList())
		{
			strBuilder.append(e);
			strBuilder.append("\\n");
		}
		myDraw5(strBuilder.substring(0, strBuilder.length() - 2), js);
	}

	private native void myDraw5(String myproperties2, String js2) /*-{
		var that = this;
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

		//use strict, to limit the sideefects of eval
		//with out it there was a problem with for(var i = 0; ...) overriding an i variable from GWT (obfuscated output)
		eval("'use strict'; var propertiesString = '" + myproperties2 + "'; "
				+ js2);
	}-*/;

	public DrawHandler getDrawHandler()
	{
		return getComponent().getDrawHandler();
	}

}
