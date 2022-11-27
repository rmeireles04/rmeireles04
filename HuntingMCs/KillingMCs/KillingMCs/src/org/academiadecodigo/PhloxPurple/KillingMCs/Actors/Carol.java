package org.academiadecodigo.PhloxPurple.KillingMCs.Actors;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.PhloxPurple.KillingMCs.Settings.GameSettings;

public class Carol extends AbsCharacter{



        @Override
        public void body() {
            int x = 136 + GameSettings.PADDING;;
            int y = 340 + GameSettings.PADDING;;

            pic = new Picture(x, y, "Carol1.png");
            xX = pic.getX() / GameSettings.imgPixelSize;
            yY = pic.getY() / GameSettings.imgPixelSize;


            //currentDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
            pic.draw();
        }
}
