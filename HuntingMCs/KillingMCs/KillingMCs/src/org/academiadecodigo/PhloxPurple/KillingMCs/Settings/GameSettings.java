package org.academiadecodigo.PhloxPurple.KillingMCs.Settings;

public class GameSettings {


    public static final int PADDING = 10;
    public static final int width = 884;
    public static final int height = 646;

    public static final int imgPixelSize = 34;

    public static final int arrayBackgroundWidthLength = width/imgPixelSize;
    public static final int arrayBackgroundHeightLength = height/imgPixelSize;


    public static int pixel2cell(int pixel){
        return pixel/34;
    }

    public static int cell2pixell(int cell){
        return cell*34;
    }
}