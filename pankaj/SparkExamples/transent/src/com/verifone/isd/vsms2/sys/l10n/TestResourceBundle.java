package com.verifone.isd.vsms2.sys.l10n;

import java.util.ResourceBundle;
import java.util.Locale;


public class TestResourceBundle
{
   public static void main(String arg[])
   {
      ResourceBundle rb1 = LocalizedRB.getResourceBundle(LocalizedRB.TOPAZ_RESOURCE,
                                              new Locale("en","US"));
      System.out.println(rb1.getString(TopazRes.SYSTEM_MSGS));

      ResourceBundle rb2 = LocalizedRB.getResourceBundle(LocalizedRB.OVERLY_RESOURCE,
                                              null);
      System.out.println(rb2.getString(OverlayRes.ASSOCIATED_RESTRICTION));
    
      ResourceBundle rb3 = LocalizedRB.getResourceBundle(LocalizedRB.OVERLY_RESOURCE,
                                              new Locale("fr","FR"));
      System.out.println(rb3.getString(OverlayRes.ASSOCIATED_RESTRICTION));

      ResourceBundle rb4 = LocalizedRB.getResourceBundle(LocalizedRB.OVERLY_RESOURCE,
                                              new Locale("en","US"));
      System.out.println(rb4.getString(OverlayRes.ASSOCIATED_RESTRICTION));
      
   }
}