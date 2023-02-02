package com.SistemZaPracenjeLokalnihDogadjaja.myutils;

import java.util.Base64;

public class ImageUtil {
    public String getImageData(byte[] byteData) {
        return Base64.getMimeEncoder().encodeToString(byteData);
    }

}
