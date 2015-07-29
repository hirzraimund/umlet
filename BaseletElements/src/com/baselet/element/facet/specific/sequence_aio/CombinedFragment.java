package com.baselet.element.facet.specific.sequence_aio;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import com.baselet.control.basics.Line1D;
import com.baselet.control.basics.geom.PointDouble;
import com.baselet.control.enums.AlignHorizontal;
import com.baselet.control.enums.AlignVertical;
import com.baselet.control.enums.LineType;
import com.baselet.diagram.draw.AdvancedTextSplitter;
import com.baselet.diagram.draw.DrawHandler;

public class CombinedFragment implements LifelineSpanningTickSpanningOccurrence {

	/** how much space is between the header and the constraint if they horizontally overlap */
	private static final double HEADER_CONSTRAINT_PADDING = 5;

	private final Lifeline[] coveredLifelines;
	// private final Lifeline intervalStart;// interval
	// private final Lifeline intervalEnd;
	/** first tick which is in the combined fragment, contains the operator and the InteractionConstraint of the first operand */
	private final int startTick;
	/** the last tick which lies in the combined fragment */
	private int endTick;
	private final String[] operatorLines;
	private final Deque<Operand> operands;

	/**
	 *
	 * @param intervalStart
	 * @param intervalEnd
	 * @param startTick
	 * @param operator can be multiple lines (but only \n is allowed)
	 */
	public CombinedFragment(Lifeline[] coveredLifelines, int startTick, String operator) {
		super();
		this.coveredLifelines = coveredLifelines;
		this.startTick = startTick;
		operatorLines = operator.split("\n");
		operands = new LinkedList<CombinedFragment.Operand>();
	}

	@Override
	public Lifeline getFirstLifeline() {
		return coveredLifelines[0];
	}

	@Override
	public Lifeline getLastLifeline() {
		return coveredLifelines[coveredLifelines.length - 1];
	}

	public void setEndTick(int endTick) {
		this.endTick = endTick;
	}

	public void addOperand(int startTick, int endTick, String text, Lifeline constraintLifeline) throws SequenceDiagramCheckedException {
		operands.add(new Operand(startTick, endTick, text, constraintLifeline));
	}

	@Override
	public Map<Integer, Line1D[]> draw(DrawHandler drawHandler, double topY, Line1D[] lifelinesHorizontalSpanning,
			double tickHeight, double[] accumulativeAddiontalHeightOffsets) {
		// draw operand lines, the pentagon and the first operand
		Map<Integer, Line1D[]> ret = new HashMap<Integer, Line1D[]>();
		drawOperandLines(drawHandler, topY, lifelinesHorizontalSpanning, tickHeight, accumulativeAddiontalHeightOffsets);
		PointDouble[] rectangle = new PointDouble[] {
				new PointDouble(lifelinesHorizontalSpanning[getFirstLifeline().getIndex()].getLow(),
						topY + startTick * tickHeight + accumulativeAddiontalHeightOffsets[startTick]),
				new PointDouble(lifelinesHorizontalSpanning[getLastLifeline().getIndex()].getHigh(),
						topY + startTick * tickHeight + accumulativeAddiontalHeightOffsets[startTick]),
				new PointDouble(lifelinesHorizontalSpanning[getLastLifeline().getIndex()].getHigh(),
						topY + (endTick + 1) * tickHeight + accumulativeAddiontalHeightOffsets[endTick + 1]),
				new PointDouble(lifelinesHorizontalSpanning[getFirstLifeline().getIndex()].getLow(),
						topY + (endTick + 1) * tickHeight + accumulativeAddiontalHeightOffsets[endTick + 1]),
				null
		};
		rectangle[4] = rectangle[0];
		drawHandler.drawLines(rectangle);
		PointDouble headerSize = PentagonDrawingHelper.draw(drawHandler, operatorLines,
				lifelinesHorizontalSpanning[getLastLifeline().getIndex()].getHigh()
						- lifelinesHorizontalSpanning[getFirstLifeline().getIndex()].getLow(), rectangle[0]);
		// add interruptions for all affected lifelines
		for (Lifeline ll : coveredLifelines) {
			if (lifelinesHorizontalSpanning[ll.getIndex()].getCenter() - ll.getLifelineLeftPartWidth(startTick)
			<= lifelinesHorizontalSpanning[getFirstLifeline().getIndex()].getLow() + headerSize.x) {
				ret.put(ll.getIndex(), new Line1D[] { new Line1D(rectangle[0].y, rectangle[0].y + headerSize.y) });
			}
			else {
				// we traverse the lifelines from left to right, therfore after the first ll which is not covered we can stop
				break;
			}
		}
		// draw operand and add the interrupted area
		if (operands.size() > 0 && operands.getFirst().constraint != null) {
			Operand firstOperand = operands.getFirst();
			Operand.InteractionConstraint firstIntConst = firstOperand.constraint;
			double constraintTopY = topY + firstOperand.startTick * tickHeight
									+ accumulativeAddiontalHeightOffsets[firstOperand.startTick];
			double constraintBottomY = topY + (firstOperand.startTick + 1) * tickHeight
										+ accumulativeAddiontalHeightOffsets[firstOperand.startTick + 1];
			constraintTopY += headerSize.y + HEADER_CONSTRAINT_PADDING;
			double textHeight = AdvancedTextSplitter.getSplitStringHeight(firstIntConst.textLines,
					lifelinesHorizontalSpanning[firstIntConst.affectedLifeline.getIndex()].getSpace(), drawHandler);
			constraintTopY += (constraintBottomY - constraintTopY - textHeight) / 2;
			AdvancedTextSplitter.drawText(drawHandler, firstIntConst.textLines,
					lifelinesHorizontalSpanning[firstIntConst.affectedLifeline.getIndex()].getLow(),
					constraintTopY,
					lifelinesHorizontalSpanning[firstIntConst.affectedLifeline.getIndex()].getSpace(),
					textHeight, AlignHorizontal.CENTER, AlignVertical.CENTER);
			if (!ret.containsKey(firstIntConst.affectedLifeline.getIndex())) {
				ret.put(firstIntConst.affectedLifeline.getIndex(),
						new Line1D[] { new Line1D(constraintTopY, constraintTopY + textHeight) });
			}
			else {
				Line1D[] tmp = ret.get(firstIntConst.affectedLifeline.getIndex());
				tmp = Arrays.copyOfRange(tmp, 0, tmp.length + 1);
				tmp[tmp.length - 1] = new Line1D(constraintTopY, constraintTopY + textHeight);
				ret.put(firstIntConst.affectedLifeline.getIndex(), tmp);
			}
		}
		return ret;
	}

	private void drawOperandLines(DrawHandler drawHandler, double topY, Line1D[] lifelinesHorizontalSpanning,
			double tickHeight, double[] accumulativeAddiontalHeightOffsets) {
		Iterator<Operand> operandIter = operands.iterator();
		if (operandIter.hasNext()) {
			operandIter.next(); // skip first operand
		}
		drawHandler.setLineType(LineType.DASHED);
		while (operandIter.hasNext()) {
			Operand op = operandIter.next();
			drawHandler.drawLine(lifelinesHorizontalSpanning[getFirstLifeline().getIndex()].getLow(),
					topY + op.startTick * tickHeight + accumulativeAddiontalHeightOffsets[op.startTick],
					lifelinesHorizontalSpanning[getLastLifeline().getIndex()].getHigh(),
					topY + op.startTick * tickHeight + accumulativeAddiontalHeightOffsets[op.startTick]);
		}
		drawHandler.setLineType(LineType.SOLID);
	}

	@Override
	public double getOverallMinWidth(DrawHandler drawHandler, double lifelineHorizontalPadding) {
		// we only need to calculate the minimum width of the pentagon, operands are handled as LifelineOccurrence
		return PentagonDrawingHelper.getMinimumWidth(drawHandler, operatorLines);
	}

	@Override
	public Map<Integer, Double> getEveryAdditionalYHeight(DrawHandler drawHandler,
			Line1D[] lifelinesHorizontalSpanning, double tickHeight) {
		Map<Integer, Double> ret = new HashMap<Integer, Double>();
		// we only need to calculate the pentagon + the first operand/InteractionConstrain because
		// the separating lines are too thin to make a difference and the other operands are
		// handled as LifelineOccurrence
		double headerHeight = PentagonDrawingHelper.getHeight(drawHandler, operatorLines,
				lifelinesHorizontalSpanning[getLastLifeline().getIndex()].getHigh()
						- lifelinesHorizontalSpanning[getFirstLifeline().getIndex()].getLow());
		headerHeight += HEADER_CONSTRAINT_PADDING;
		headerHeight += AdvancedTextSplitter.getSplitStringHeight(operands.getFirst().constraint.textLines,
				lifelinesHorizontalSpanning[operands.getFirst().constraint.affectedLifeline.getIndex()].getSpace(), drawHandler);
		if (headerHeight > tickHeight) {
			ret.put(startTick, headerHeight - tickHeight);
		}
		return ret;
	}

	private class Operand {
		private final int startTick;
		private final int endTick;

		private final InteractionConstraint constraint;

		public Operand(int startTick, int endTick, String text, Lifeline constraintLifeline) throws SequenceDiagramCheckedException {
			super();
			this.startTick = startTick;
			this.endTick = endTick;
			constraint = new InteractionConstraint(text, constraintLifeline);
		}

		public boolean isFirstOperand() {
			return operands.getFirst() == this;
		}

		public boolean isLastOperand() {
			return operands.getLast() == this;
		}

		/**
		 * Represents an interaction constraint of an operand of a combined fragment.
		 * The drawing and calculation of the height for the interaction constraint
		 * of the first operand is handled by the combined fragment because the
		 * positioning of it is tightly coupled with the operator drawing.
		 *
		 */
		private class InteractionConstraint implements LifelineOccurrence {

			private final String[] textLines;
			private final Lifeline affectedLifeline;

			/**
			 * @param constraintText the constraint without the square brackets
			 * @param affectedLifeline the lifeline on which the constraint should be placed
			 * @throws SequenceDiagramCheckedException
			 */
			public InteractionConstraint(String constraintText, Lifeline affectedLifeline) throws SequenceDiagramCheckedException {
				super();
				textLines = ('[' + constraintText + ']').split("\n");
				this.affectedLifeline = affectedLifeline;
				affectedLifeline.addLifelineOccurrenceAtTick(this, startTick);
			}

			@Override
			public Line1D draw(DrawHandler drawHandler, PointDouble topLeft, PointDouble size) {
				if (isFirstOperand()) {
					// first operand is handled by the combined fragment
					return null;
				}
				else {
					double textHeight = AdvancedTextSplitter.getSplitStringHeight(textLines, size.x, drawHandler);
					Line1D interruptedArea = new Line1D(topLeft.y + (size.y - textHeight) / 2,
							topLeft.y + (size.y - textHeight) / 2 + textHeight);
					AdvancedTextSplitter.drawText(drawHandler, textLines, topLeft.x, interruptedArea.getLow(),
							size.x, textHeight, AlignHorizontal.CENTER, AlignVertical.CENTER);
					return interruptedArea;
				}
			}

			@Override
			public double getMinWidth(DrawHandler drawHandler) {
				return AdvancedTextSplitter.getTextMinWidth(textLines, drawHandler);
			}

			@Override
			public double getAdditionalYHeight(DrawHandler drawHandler, PointDouble size) {
				if (isFirstOperand()) {
					// first operand is handled by the combined fragment
					return -1;
				}
				else {
					return AdvancedTextSplitter.getSplitStringHeight(textLines, size.x, drawHandler) - size.y;
				}
			}

		}
	}

}