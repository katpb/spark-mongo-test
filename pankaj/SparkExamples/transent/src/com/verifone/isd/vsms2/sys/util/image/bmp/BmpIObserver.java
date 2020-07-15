package com.verifone.isd.vsms2.sys.util.image.bmp;

import java.awt.image.ImageObserver;
import java.awt.Image;

public class BmpIObserver implements ImageObserver {

    public boolean imageUpdate (Image img, int infoflags, 
                     int x, int y, int width, int height) {
        return true;
    }

}
