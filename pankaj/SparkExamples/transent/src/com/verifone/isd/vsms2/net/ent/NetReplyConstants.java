/*-
 * Copyright (C) 2005 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * ADS version
 * Created January 17, 2005                            Aaron Sorgius
 *
 */

package com.verifone.isd.vsms2.net.ent;

public class NetReplyConstants {
    public static final int APPROVED = 0;           /* network approval stored in status */
    public static final int REJECTED = 1;           /* network reject stored in status */
    
    public static final int     RSP_APPROVE	= 0;    /* 00 - Approval response */
    public static final int     RSP_PC_01    	= 1;	/* 01 - Proprietary card */
    public static final int	RSP_PC_02    	= 2;	/* 02 - Proprietary card */
    public static final int	RSP_PC_03    	= 3;	/* 03 - Proprietary card */
    public static final int	RSP_PC_04    	= 4;	/* 04 - Proprietary card */
    public static final int	RSP_PC_05    	= 5;	/* 05 - Proprietary card */
    public static final int	RSP_PC_06    	= 6;	/* 06 - Proprietary card */
    public static final int	RSP_PC_07	= 7;	/* 07 - Proprietary card */
    public static final int	RSP_PC_09	= 9;	/* 09 - Proprietary card */
    public static final int	RSP_PC_11	= 11;	/* 11 - Proprietary card */
    
    public static final int     RSP_CREDIT_ADJ	= 8;	/* 08 - Credit adjustment */
    public static final int	RSP_BC_REJ	= 10;   /* 10 - bank card reject */
    public static final int     RSP_BAL_LOCKED  = 11;   /* 11 - prepaid card balance locked */
    public static final int     RSP_PP_SPLT     = 15;	/* 15 - Prepaid split tender and amount remaining */
    public static final int	RSP_BC_FREQ	= 16;	/* 16 - bank card frequent card use */
    public static final int	RSP_TERM_DOWN	= 17;	/* 17 - terminal down */
    public static final int	RSP_NO_STORE	= 17;	/* 17 - store not setup for prepaid */
    public static final int     RSP_OVER_LIMIT	= 18;	/* 18 - over prepaid card limit */
    public static final int     RSP_ALREADY_ACT	= 19;	/* 19 - prepaid card already active */
    public static final int	RSP_BC_PICKUP	= 20;	/* 20 - bank card pickup */
    public static final int     RSP_NOT_ASSIGNED= 21;	/* 21 - prepaid card not assigned */
    public static final int     RSP_PC_25   	= 25;	/* 25 - Prepaid already active */
    public static final int	RSP_BC_REF	= 30;	/* 30 - bank card referral */
    public static final int     RSP_NOT_ACTIVE	= 30;	/* 30 - prepaid card not active */
    public static final int	RSP_HOST_DOWN	= 37;	/* 37 - no answer from host */
    public static final int	RSP_NO_RSP	= 38;	/* 38 - no response received */
    public static final int	RSP_HOST_FAIL	= 40;	/* 40 - host failure */
    public static final int     RSP_NET_TIMEOUT	= 41;	/* 41 - denial - network timeout */
    public static final int	RSP_DC_FAIL	= 48;	/* 48 - send as DC code for host fail */
    public static final int	RSP_BC_BAD	= 50;	/* 50 - bank card bad card data */
    public static final int	RSP_PIN_ERROR 	= 55;	/* 55 - Debit card invalid PIN retry */
    public static final int	RSP_PHONE_DOWN	= 57;	/* 57 - no phone line */
    public static final int	RSP_LEASE_DOWN	= 58;	/* 58 - no leased line poll */
    public static final int	RSP_BC_EXP	= 60;	/* 60 - bank card expired */
    public static final int	RSP_NO_ACK	= 67;	/* 67 - no ACK received */
    public static final int	RSP_NAKS	= 68;	/* 68 - too many NAKs received */
    public static final int	RSP_INVDATA	= 70;	/* 70 - invalid data */
    public static final int	RSP_DISC	= 77;	/* 77 - received disconnect */
    public static final int	RSP_LEASE_NAK 	= 78;	/* 78 - no ACK from leased line node */
    public static final int	RSP_79_DISC	= 79;	/* 79 - logic terminator */
    public static final int	RSP_HOST_TO	= 80;	/* 80 - host timeout */
    public static final int	RSP_NET_ERR	= 81;	/* 81 - debit card network error */
    public static final int	RSP_NO_BAL	= 83;	/* 83 - inquiry balance not available */
    public static final int	RSP_UNEXP	= 84;	/* 84 - unexpected interchange response */
    public static final int	RSP_DUP		= 85;	/* 85 - duplicate auth request */
    public static final int	RSP_VEL_REJ	= 86;	/* 86 - velocity entry not found, denial */
    public static final int	RSP_TIMEOUT	= 87;	/* 87 - timeout no response received */
    public static final int	RSP_DC_TO	= 88;	/* 88 - send as DC code for host timeout */
    public static final int     RSP_EX_USAGE	= 89;	/* 89 - exceed usage limit, denial */
    public static final int	RSP_NO_HOST	= 90;	/* 90 - host unavailable */
    public static final int     RSP_EX_FLOOR	= 91;	/* 91 - exceed floor limit, denial */
    public static final int	RSP_SF_AUTH	= 92;	/* 92 - store and forward auth */
    public static final int     RSP_93		= 93;
    public static final int     RSP_94		= 94;
    public static final int     RSP_95		= 95;
    public static final int     RSP_96		= 96;
    public static final int     RSP_97		= 97;
    public static final int	RSP_DC_NO_HOST	= 98;	/* 98 - send as DC for host unavailable */
    public static final int     RSP_99		= 99;   /* 99 - Citfleet2 approval use imprinter */

    /* 
    ** this responses will be returned when using the prepaid card!
    ** most of the reason codes returned from the prepaid host are assigned
    ** a new response value below, but a few are the same as existing 
    ** response codes.  these are listed as follows:
    ** reason code 13 is the same as response 50 - "bank card bad card data"
    ** reason code 16 is the same as response 40 - "host failure"
    ** reason code 20 is the same as response 60 - "bank card expired"
    ** if possible, would like to reserve the #define values
    ** 201 thru 255 for future use with the prepaid card.
    **                         response      value     reason  reason for response
    **                                                  code
    **                         ------------- -----     ------  -------------------------
    */
    public static final int RSP_INS_FUNDS   = 201;  /*     01   denial, insufficient funds */
    public static final int RSP_CARD_CLSD   = 202;  /*     02   denial, card closed */
    public static final int RSP_UNKN_CARD   = 203;  /*     03   denial, unknown card */
    public static final int RSP_INACT_CRD   = 204;  /*     04   denial, inactive card */
    public static final int RSP_CARD_LCKD   = 205;  /*     05   denial, card locked */
    public static final int RSP_INV_TRANS   = 209;  /*     09   denial, invalid transaction code */
    public static final int RSP_ACT_CARD    = 211;  /*     11   denial, active card */
    public static final int RSP_INV_AMNT    = 212;  /*     12   denial, invalid amount */
    public static final int RSP_PPBAD_MAG   = 213;  /*     13   denial, bad magnetic stripe (rwb-970115) */
    public static final int RSP_INV_REV     = 214;  /*     14   denial, invalid reversal */
    public static final int RSP_INV_ACTIV   = 215;  /*     15   denial, invalid activation */
    public static final int RSP_PPHOST_FAIL = 216;  /*     16   denial, host failure (rwb-970115) */
    public static final int RSP_DECLINE_17  = 217;  /*     17   decline code 17 call prepaid help desk */
    public static final int RSP_DECLINE_18  = 218;  /*     18   decline code 18 call prepaid help desk */
    public static final int RSP_DECLINE_19  = 219;  /*     19   decline code 19 call prepaid help desk */
    public static final int RSP_PPEXP_CARD  = 220;  /*     20   denial, expired card (rwb-970115) */
    public static final int RSP_DECLINE_21  = 221;  /*     21   decline code 21 call prepaid help desk */
    public static final int RSP_DECLINE_22  = 222;  /*     22   decline code 22 call prepaid help desk */
    public static final int RSP_DECLINE_23  = 223;  /*     23   decline code 23 call prepaid help desk */
    public static final int RSP_DECLINE_24  = 224;  /*     24   decline code 24 call prepaid help desk */
    public static final int RSP_DECLINE_25  = 225;  /*     25   decline code 25 call prepaid help desk */
    public static final int RSP_DECLINE_26  = 226;  /*     26   decline code 26 call prepaid help desk */
    public static final int RSP_DECLINE_27  = 227;  /*     27   decline code 27 call prepaid help desk */
    public static final int RSP_UNKNOWN_PP  = 255;  /*     --   received unknown prepaid reason code */
    /* end of prepaid response definitions */

    public static final int RSP_INVDRIVER   = 11;      /* 11 - Fleet - invalid driver id */
    public static final int RSP_INVVEHICLE  = 12;      /* 12 - Fleet - invalid vehicle no. */
    public static final int RSP_INVACCOUNT  = 13;      /* 13 - Fleet - invalid account */
    public static final int RSP_INVFUEL     = 14;      /* 14 - Fleet - unauthorized fuel type */
    public static final int RSP_NOSVC       = 15;      /* 15 - Fleet - not authorized for service */
    public static final int RSP_MON_OTHLIM  = 21;      /* 21 - Fleet - over monthly other limit */
    public static final int RSP_MON_FUELLIM = 22;      /* 22 - Fleet - over monthly fuel limit */
    public static final int RSP_MON_MDSELIM = 23;      /* 23 - Fleet - over monthly mdse limit */
    public static final int RSP_MON_SVCLIM  = 24;      /* 24 - Fleet - over monthly service limit */
    public static final int RSP_NOOTHER     = 25;      /* 25 - Fleet - not authorized for other */
    public static final int RSP_DAY_FUELLIM = 26;      /* 26 - Fleet - over daily fuel limit */
    public static final int RSP_INVFUNC     = 27;      /* 27 - Fleet - invalid function */
    public static final int RSP_INVPIN      = 28;      /* 28 - Fleet - invalid pin */
    public static final int RSP_DAY_OTHLIM  = 29;      /* 29 - Fleet - over daily other limit */
    public static final int RSP_DAY_MDSELIM = 31;      /* 31 - Fleet - over daily mdse limit */
    public static final int RSP_DAY_SVCLIM  = 32;      /* 32 - Fleet - over daily service limit */
    public static final int RSP_NOMDSE      = 33;      /* 33 - Fleet - not authorized for mdse */
    public static final int RSP_INVPIN_RTY  = 34;      /* 34 - Fleet - invalid pin retry */
    public static final int RSP_INVPROD     = 35;      /* 35 - Fleet - invalid product */
    public static final int RSP_INVIDNUMBER = 36;      /* 35 - Fleet - invalid id number */
    
    public NetReplyConstants() {
    }
}
