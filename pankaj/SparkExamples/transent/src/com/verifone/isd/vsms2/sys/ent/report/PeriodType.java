package com.verifone.isd.vsms2.sys.ent.report;

public enum PeriodType {
	
	DAYPART("daypart") {
		@Override
		public boolean isSmaller(PeriodType periodType) {
			boolean isSmallerOrEqual = false;
			if(periodType.equals(DAY) || periodType.equals(WEEK) || periodType.equals(MONTH) || periodType.equals(YEAR)) {
				isSmallerOrEqual = true;
			}
			return isSmallerOrEqual;
		}

		@Override
		public boolean isPreserveRawTxnsAllowed() {
			return true;
		}
	},
	DAY("day") {
		@Override
		public boolean isSmaller(PeriodType periodType) {
			boolean isSmallerOrEqual = false;
			if(periodType.equals(WEEK) || periodType.equals(MONTH) || periodType.equals(YEAR)) {
				isSmallerOrEqual = true;
			}
			return isSmallerOrEqual;		
		}

		@Override
		public boolean isPreserveRawTxnsAllowed() {
			return true;
		}
	},
	WEEK("week") {
		@Override
		public boolean isSmaller(PeriodType periodType) {
			boolean isSmallerOrEqual = false;
			if(periodType.equals(MONTH) || periodType.equals(YEAR)) {
				isSmallerOrEqual = true;
			}
			return isSmallerOrEqual;		
		}

		@Override
		public boolean isPreserveRawTxnsAllowed() {
			return false;
		}
	},
	MONTH("month") {
		@Override
		public boolean isSmaller(PeriodType periodType) {
			boolean isSmallerOrEqual = false;
			if(periodType.equals(YEAR)) {
				isSmallerOrEqual = true;
			}
			return isSmallerOrEqual;	
		}

		@Override
		public boolean isPreserveRawTxnsAllowed() {
			return false;
		}
	},
	YEAR("year") {
		@Override
		public boolean isSmaller(PeriodType periodType) {
			return false;
		}

		@Override
		public boolean isPreserveRawTxnsAllowed() {
			return false;
		}
	};
	
	private String periodType;
	
	PeriodType(String periodType) {
		this.periodType = periodType;
	}
	/**
	 * This method returns Period Type
	 * @return
	 */
	public String getPeriodType() {
		return this.periodType;
	}
	
	/**
	 * This method returns Period Type enum depending on the Period Type
	 * @param periodTypeName
	 * 			Name of the period type
	 * @return periodType
	 */
	public static PeriodType getPeriodTypeEnum(String periodTypeName) {
		PeriodType [] periodTypes = PeriodType.values();
		PeriodType periodType = null;
		for(int i = 0; i < periodTypes.length; i++) {
			if(periodTypeName.equals(periodTypes[i].getPeriodType())) {
				periodType = periodTypes[i];
				break;
			}
		}
		return periodType;
	}

	public abstract boolean isSmaller(PeriodType periodType);
	
	public abstract boolean isPreserveRawTxnsAllowed();
}
