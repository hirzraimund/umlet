package com.baselet.element.elementnew;

import java.util.List;

import com.baselet.control.enums.ElementId;
import com.baselet.element.NewGridElement;
import com.baselet.element.facet.Facet;
import com.baselet.element.facet.Settings;
import com.baselet.element.facet.common.BackgroundColorFacet;
import com.baselet.element.facet.common.ForegroundColorFacet;
import com.baselet.element.facet.common.GroupFacet;
import com.baselet.element.facet.common.LayerFacet;
import com.baselet.element.facet.common.LineWidthFacet;
import com.baselet.element.settings.SettingsManualResizeTop;

// the class is abstract since different implementations are needed for the desktop and GWT platform
public abstract class CustomElement extends NewGridElement {

	@Override
	public ElementId getId() {
		return ElementId.CustomJsElem;
	}

	@Override
	protected Settings createSettings() {
		return new SettingsManualResizeTop() {
			@Override
			protected List<Facet> createFacets() {
				return listOf(super.createFacets(), BackgroundColorFacet.INSTANCE, ForegroundColorFacet.INSTANCE, LayerFacet.INSTANCE, LineWidthFacet.INSTANCE, GroupFacet.INSTANCE);
			}
		};
	}
}
