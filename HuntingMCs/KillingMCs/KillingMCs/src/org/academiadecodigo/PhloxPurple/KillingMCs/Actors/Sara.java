package org.academiadecodigo.PhloxPurple.KillingMCs.Actors;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.PhloxPurple.KillingMCs.Settings.GameSettings;


public class Sara extends AbsCharacter{


    @Override
    public void body() {
        int x = 68 + GameSettings.PADDING;
        int y = 544 + GameSettings.PADDING;

        pic = new Picture(x, y, "Sara1.png");
        xX = pic.getX() / GameSettings.imgPixelSize;
        yY = pic.getY() / GameSettings.imgPixelSize;


        //currentDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
        pic.draw();
    }

}
