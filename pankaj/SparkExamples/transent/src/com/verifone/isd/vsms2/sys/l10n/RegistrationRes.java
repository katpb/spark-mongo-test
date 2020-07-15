package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

public class RegistrationRes extends ListResourceBundle {

    public static final String kRegInfo        = "kRegInfo";
    public static final String kRegStatus      = "kRegStatus";
    public static final String kRegistered     = "kRegistered";
    public static final String kNotReg         = "kNotReg";

    public static final String kFeatureRef     = "kFeatureRef";
    public static final String kHeaderDash     = "kHeaderDash";

    public static final String kBaseSystem     = "kBaseSystem";
    public static final String kAppName        = "kAppName";
    public static final String kAppVersion     = "kAppVersion";
    public static final String kShifts         = "kShifts";
    public static final String kOSVersion      = "kOSVersion";
    public static final String kSRAMsize       = "kSRAMsize";
    public static final String kDRAMsize       = "kDRAMsize";
    public static final String kEID            = "kEID";
    public static final String kInstalledBy    = "kInstalledBy";
    public static final String kUnknown        = "kUnknown";
    public static final String kSitePhoneNbr   = "kSitePhoneNbr";
    public static final String kPostalCode     = "kPostalCode";
    public static final String kFeatCard       = "kFeatCard";
    public static final String kNone           = "kNone";
    public static final String kFCW            = "kFCW";
    public static final String kEnd            = "kEnd";
	
	@Override
	protected Object[][] getContents() {
				return contents;
	}
	static private final Object[][] contents = {
        { kRegInfo        , "REGISTRATION INFORMATION LISTING"             },
        { kRegStatus      , "Registration Status: %s"                      },
        { kRegistered     , "REGISTERED %s"                                },
        { kNotReg         , "NOT REGISTERED"                               },

        { kFeatureRef     , "FEATURE                           (REF#)"     },
        { kHeaderDash     , "----------------------------------------"     },

        { kBaseSystem     , "BASE SYSTEM (GemReg 2.0)"                     },
        { kAppName        , "       App Name: %-8.8s"                      },
        { kAppVersion     , "    App Version: %x.%02x.%02x"                },
        { kShifts         , "         Shifts: %02d                (%s)"    },
        { kOSVersion      , "    O/S Version: %x.%x.%x"                    },
        { kSRAMsize       , "Flash Disk Size: %d"                          },
        { kDRAMsize       , "      DRAM Size: %d"                          },
        { kEID            , "            EID: %-12.12s      (%s)"          },
        { kInstalledBy    , "   Installed by: %s"                          },
        { kUnknown        , "(UNKNOWN)"                                    },
        { kSitePhoneNbr   , " Site Phone Nbr: %s"                          },
        { kPostalCode     , "    Postal Code: %s"                          },
        { kFeatCard       , "   Feature card: %s"                          },
        { kNone           , "(NONE)"                                       },
        { kFCW            , "            FCW: %-2.2s                (%s)"  },
        { kEnd            , "--- end ---"                                  },
   };
}
