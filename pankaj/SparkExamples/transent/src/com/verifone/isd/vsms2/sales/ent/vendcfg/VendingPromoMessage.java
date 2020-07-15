package com.verifone.isd.vsms2.sales.ent.vendcfg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VadirajaC1
 * 
 */
public class VendingPromoMessage implements Serializable {

	private static int MAX_PROMO_MESSAGE_LINES = 4;

	private List<String> graphic;
	private List<String> nonGraphic;

	public VendingPromoMessage() {
		nonGraphic = new ArrayList<String>(MAX_PROMO_MESSAGE_LINES);
		graphic = new ArrayList<String>(MAX_PROMO_MESSAGE_LINES);
	}

	public List<String> getGraphic() {
		return graphic;
	}

	public List<String> getNonGraphic() {
		return nonGraphic;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (String graphicLine : getGraphic()) {
			sb.append(" | graphicLine = " + graphicLine);
		}

		for (String nonGraphicLine : getNonGraphic()) {
			sb.append(" | nonGraphicLine = " + nonGraphicLine);
		}

		return sb.toString();
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 47 * hash + (this.graphic != null ? this.graphic.hashCode() : 0);
		hash = 47 * hash + (this.nonGraphic != null ? this.nonGraphic.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VendingPromoMessage other = (VendingPromoMessage) obj;
		if (this.graphic != other.graphic && (this.graphic == null || !this.graphic.equals(other.graphic))) {
			return false;
		}
		if (this.nonGraphic != other.nonGraphic && (this.nonGraphic == null || !this.nonGraphic.equals(other.nonGraphic))) {
			return false;
		}
		return true;
	}
}
