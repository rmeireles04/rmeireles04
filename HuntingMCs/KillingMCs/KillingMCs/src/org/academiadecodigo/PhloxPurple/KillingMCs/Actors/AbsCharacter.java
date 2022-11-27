package org.academiadecodigo.PhloxPurple.KillingMCs.Actors;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.PhloxPurple.KillingMCs.Game;
import org.academiadecodigo.PhloxPurple.KillingMCs.Settings.GameSettings;
import org.academiadecodigo.PhloxPurple.KillingMCs.Sounds.SoundHandler;

public abstract class AbsCharacter implements Characters {


    protected Picture pic;
    protected int xX;
    protected int yY;
    protected boolean isDead = false;

    Picture deadPic = new Picture();




    public AbsCharacter() {
        body();
    }




    public void translate(int x, int y) {
        pic.translate(x, y);
    }


    public int getX() {
        return pic.getX();
    }

    public int getY() {
        return pic.getY();
    }


    public void move() throws InterruptedException {

        if (isDead()) {

           // pic.delete();
            return;
        }

        Thread.sleep(70);
        int random = (int) Math.ceil(Math.random() * 4);


        switch (random) {

            case 1:
                //UP
                if ((yY != 0) && (Game.map.itemsOfMap[xX][yY - 1].getCanStep())) {
                    yY--;
                    translate(0, -GameSettings.imgPixelSize);
                }
                break;

            case 2:
                // WALK TO LEFT

                if ((xX != 0) && (Game.map.itemsOfMap[xX - 1][yY].getCanStep())) {
                    xX--;
                    translate(-GameSettings.imgPixelSize, 0);
                }
                break;

            case 3:
                // WALK TO RIGHT

                if ((xX != GameSettings.arrayBackgroundWidthLength) && (Game.map.itemsOfMap[xX + 1][yY].getCanStep())) {

                    xX++;
                    translate(GameSettings.imgPixelSize, 0);
                }
                break;

            case 4:
                // WALK TO BOTTOM

                if ((yY != GameSettings.arrayBackgroundHeightLength) && (Game.map.itemsOfMap[xX][yY + 1].getCanStep())) {

                    yY++;
                    translate(0, GameSettings.imgPixelSize);
                }
                break;

            default:
                break;


        }


    }

    public void isCollided(PacMan pacMan) {
        if (pic.getX() == pacMan.getX() && pic.getY() == pacMan.getY()) {
            if(!isDead) {
            SoundHandler.RunMusic("KillingMCs/KillingMCs/resources/Sounds/pacmanDeath.wav");
            }
            isDead = true;
            //setNewPosition(getX(),getY(),"shape.png");
            setDeadPic();
        }

    }

    public boolean isDead() {
        return isDead;
    }

    public void setDeadPic() {
        pic.delete();
        Picture deadPic = new Picture(getX(),getY(),"KillingMCs/KillingMCs/resources/dead.png");
        deadPic.draw();
    }
}
