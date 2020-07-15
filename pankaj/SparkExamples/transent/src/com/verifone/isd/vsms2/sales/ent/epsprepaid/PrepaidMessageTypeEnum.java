/**
 *
 */
package com.verifone.isd.vsms2.sales.ent.epsprepaid;


/**
 * @author t_shivrajs1
 *
 */
public enum PrepaidMessageTypeEnum {

	GUIDELINE_MSG("GUIDELINE_MSG"),
	PURCHASE_MSG("PURCHASE_MSG"),
	CANCEL_MSG("CANCEL_MSG");

	private final String msgType;

	PrepaidMessageTypeEnum(String type){
		this.msgType = type;
	}

    public String value() {
        return msgType;
    }

    public static PrepaidMessageTypeEnum fromValue(String v) {
        for (PrepaidMessageTypeEnum c: PrepaidMessageTypeEnum.values()) {
            if (c.msgType.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
