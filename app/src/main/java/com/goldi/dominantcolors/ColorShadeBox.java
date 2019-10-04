package com.goldi.dominantcolors;

// Holds data about dominant color on camera view

import android.util.Log;


public class ColorShadeBox {


    int population;
    float percentage; //population in percentage
    int r;
    int g;
    int b;
    int rank; //from 1-5, 1 is the most populated color
    int rgb;
    public static int pixelsInImage;


    public ColorShadeBox(int rgbVal, int population, int rank) {
        updateSwatch(rgbVal, population, rank);

    }


    // https://stackoverflow.com/a/2615534
    private void getRGBfromColor(int colorInt) {
        b = rgb & 0xFF;
        g = (rgb >> 8) & 0xFF;
        r = (rgb >> 16) & 0xFF;
    }

    public void updateSwatch(int rgb, int population, int rank) {

        this.rgb = rgb;
        getRGBfromColor(rgb);
        this.rank = rank;
        this.population = population;
        this.percentage = calculatePopulationPercenttage();


    }

    private float calculatePopulationPercenttage() {
        int n = population;
        int v = pixelsInImage;
        return n * 100f / v;
    }


    public static void setPixelsInImage(int pixelsInImage) {
        ColorShadeBox.pixelsInImage = pixelsInImage;
    }
}
