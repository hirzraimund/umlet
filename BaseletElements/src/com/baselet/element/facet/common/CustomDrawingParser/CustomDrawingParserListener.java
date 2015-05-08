// Generated from CustomDrawingParser.g4 by ANTLR 4.5

	package com.baselet.element.facet.common.CustomDrawingParser;

	import com.baselet.control.enums.AlignHorizontal;
	import com.baselet.control.enums.LineType;
	import com.baselet.diagram.draw.DrawHandler;
	import com.baselet.diagram.draw.helper.ColorOwn;
	import com.baselet.diagram.draw.helper.ColorOwn.Transparency;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CustomDrawingParserParser}.
 */
public interface CustomDrawingParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(CustomDrawingParserParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(CustomDrawingParserParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#drawLine}.
	 * @param ctx the parse tree
	 */
	void enterDrawLine(CustomDrawingParserParser.DrawLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#drawLine}.
	 * @param ctx the parse tree
	 */
	void exitDrawLine(CustomDrawingParserParser.DrawLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#drawRectangle}.
	 * @param ctx the parse tree
	 */
	void enterDrawRectangle(CustomDrawingParserParser.DrawRectangleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#drawRectangle}.
	 * @param ctx the parse tree
	 */
	void exitDrawRectangle(CustomDrawingParserParser.DrawRectangleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#drawRectangleRound}.
	 * @param ctx the parse tree
	 */
	void enterDrawRectangleRound(CustomDrawingParserParser.DrawRectangleRoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#drawRectangleRound}.
	 * @param ctx the parse tree
	 */
	void exitDrawRectangleRound(CustomDrawingParserParser.DrawRectangleRoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#drawCircle}.
	 * @param ctx the parse tree
	 */
	void enterDrawCircle(CustomDrawingParserParser.DrawCircleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#drawCircle}.
	 * @param ctx the parse tree
	 */
	void exitDrawCircle(CustomDrawingParserParser.DrawCircleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#drawEllipse}.
	 * @param ctx the parse tree
	 */
	void enterDrawEllipse(CustomDrawingParserParser.DrawEllipseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#drawEllipse}.
	 * @param ctx the parse tree
	 */
	void exitDrawEllipse(CustomDrawingParserParser.DrawEllipseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#drawArc}.
	 * @param ctx the parse tree
	 */
	void enterDrawArc(CustomDrawingParserParser.DrawArcContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#drawArc}.
	 * @param ctx the parse tree
	 */
	void exitDrawArc(CustomDrawingParserParser.DrawArcContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#drawText}.
	 * @param ctx the parse tree
	 */
	void enterDrawText(CustomDrawingParserParser.DrawTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#drawText}.
	 * @param ctx the parse tree
	 */
	void exitDrawText(CustomDrawingParserParser.DrawTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#fg}.
	 * @param ctx the parse tree
	 */
	void enterFg(CustomDrawingParserParser.FgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#fg}.
	 * @param ctx the parse tree
	 */
	void exitFg(CustomDrawingParserParser.FgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#bg}.
	 * @param ctx the parse tree
	 */
	void enterBg(CustomDrawingParserParser.BgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#bg}.
	 * @param ctx the parse tree
	 */
	void exitBg(CustomDrawingParserParser.BgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#colorOwn}.
	 * @param ctx the parse tree
	 */
	void enterColorOwn(CustomDrawingParserParser.ColorOwnContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#colorOwn}.
	 * @param ctx the parse tree
	 */
	void exitColorOwn(CustomDrawingParserParser.ColorOwnContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#lt}.
	 * @param ctx the parse tree
	 */
	void enterLt(CustomDrawingParserParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#lt}.
	 * @param ctx the parse tree
	 */
	void exitLt(CustomDrawingParserParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#lineType}.
	 * @param ctx the parse tree
	 */
	void enterLineType(CustomDrawingParserParser.LineTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#lineType}.
	 * @param ctx the parse tree
	 */
	void exitLineType(CustomDrawingParserParser.LineTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#lw}.
	 * @param ctx the parse tree
	 */
	void enterLw(CustomDrawingParserParser.LwContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#lw}.
	 * @param ctx the parse tree
	 */
	void exitLw(CustomDrawingParserParser.LwContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#simpleString}.
	 * @param ctx the parse tree
	 */
	void enterSimpleString(CustomDrawingParserParser.SimpleStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#simpleString}.
	 * @param ctx the parse tree
	 */
	void exitSimpleString(CustomDrawingParserParser.SimpleStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#booleanConstant}.
	 * @param ctx the parse tree
	 */
	void enterBooleanConstant(CustomDrawingParserParser.BooleanConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#booleanConstant}.
	 * @param ctx the parse tree
	 */
	void exitBooleanConstant(CustomDrawingParserParser.BooleanConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#horizontalAlignment}.
	 * @param ctx the parse tree
	 */
	void enterHorizontalAlignment(CustomDrawingParserParser.HorizontalAlignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#horizontalAlignment}.
	 * @param ctx the parse tree
	 */
	void exitHorizontalAlignment(CustomDrawingParserParser.HorizontalAlignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#doubleTerm}.
	 * @param ctx the parse tree
	 */
	void enterDoubleTerm(CustomDrawingParserParser.DoubleTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#doubleTerm}.
	 * @param ctx the parse tree
	 */
	void exitDoubleTerm(CustomDrawingParserParser.DoubleTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#doubleProduct}.
	 * @param ctx the parse tree
	 */
	void enterDoubleProduct(CustomDrawingParserParser.DoubleProductContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#doubleProduct}.
	 * @param ctx the parse tree
	 */
	void exitDoubleProduct(CustomDrawingParserParser.DoubleProductContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#doubleValue}.
	 * @param ctx the parse tree
	 */
	void enterDoubleValue(CustomDrawingParserParser.DoubleValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#doubleValue}.
	 * @param ctx the parse tree
	 */
	void exitDoubleValue(CustomDrawingParserParser.DoubleValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomDrawingParserParser#unsignedDoubleConstant}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedDoubleConstant(CustomDrawingParserParser.UnsignedDoubleConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomDrawingParserParser#unsignedDoubleConstant}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedDoubleConstant(CustomDrawingParserParser.UnsignedDoubleConstantContext ctx);
}