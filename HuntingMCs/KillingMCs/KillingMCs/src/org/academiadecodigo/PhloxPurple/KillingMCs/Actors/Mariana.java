package org.academiadecodigo.PhloxPurple.KillingMCs.Actors;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.PhloxPurple.KillingMCs.Settings.GameSettings;

public class Mariana extends AbsCharacter {

    @Override
    public void body() {
        int x = 816 + GameSettings.PADDING;;
        int y = 578 + GameSettings.PADDING;;

        pic = new Picture(x, y, "Mariana1.png");

        xX = pic.getX() / GameSettings.imgPixelSize;
        yY = pic.getY() / GameSettings.imgPixelSize;


        pic.draw();

    }



}
