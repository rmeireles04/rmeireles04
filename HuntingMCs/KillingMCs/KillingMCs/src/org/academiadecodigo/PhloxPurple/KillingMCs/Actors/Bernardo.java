package org.academiadecodigo.PhloxPurple.KillingMCs.Actors;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.PhloxPurple.KillingMCs.Settings.GameSettings;

public class Bernardo extends AbsCharacter{



        @Override
        public void body() {
            int x = 306 + GameSettings.PADDING;;
            int y = 442 + GameSettings.PADDING;

            pic = new Picture(x, y, "Bernardo1.png");
            xX = pic.getX() / GameSettings.imgPixelSize;
            yY = pic.getY() / GameSettings.imgPixelSize;


            //currentDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
            pic.draw();
        }
}
