package com.goldi.dominantcolors;

// Holds data about dominant color on camera view
//Swatch is a single rgb colour. it contains all the values needed for presenting in the UI views


public class Swatch {


    int population; // num of pixels for this RGB SWATCH
    float percentage; //percentgae from tottal pixels
    int r; // r value of RGB
    int g; // g value of RGB
    int b;// b value of RGB
    int rank; //from 1-5, 1 is the most populated color
    int rgb; // rgb value of swatch. represented in int
    public static int pixelsInImage; //tottal pixels in image (static and shared for all swaches)


    //constructor for Swatch
    public Swatch(int rgbVal, int population, int rank) {
        updateSwatch(rgbVal, population, rank);

    }

    // converts int representation of rgb into seperated values for red green and blue
    // https://stackoverflow.com/a/2615534
    private void getRGBfromColor(int colorInt) {
        b = rgb & 0xFF; //blue
        g = (rgb >> 8) & 0xFF; //green
        r = (rgb >> 16) & 0xFF; //red
    }

    //Updates the Swatch data if needed
    public void updateSwatch(int rgb, int population, int rank) {
        this.rgb = rgb;
        getRGBfromColor(rgb);
        this.rank = rank;
        this.population = population;
        this.percentage = calculatePopulationPercenttage();


    }

    // calculates percentage of Swatch from tottal input image pixels
    private float calculatePopulationPercenttage() {
        int x = population;
        int y = pixelsInImage;
        return x * 100f / y;
    }


    // tottal pixels in the input image (probably camera preview input)
    public static void setPixelsInImage(int pixelsInImage) {
        Swatch.pixelsInImage = pixelsInImage;
    }
}
