package org.academiadecodigo.PhloxPurple.KillingMCs.Actors;

import org.academiadecodigo.PhloxPurple.KillingMCs.Game;
import org.academiadecodigo.PhloxPurple.KillingMCs.Settings.GameSettings;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PacMan implements KeyboardHandler {

    private Picture pacman;
    private int pacmanLogicalX;
    private int pacmanLogicalY;

    public PacMan() {
        int x = GameSettings.width / 2 + GameSettings.PADDING;
        // TODO: Se houver problema, pode ser esta divisao.
        int y = ((GameSettings.height / 2) - (GameSettings.imgPixelSize / 2)) + GameSettings.PADDING;



        pacman = new Picture(x, y, "Reaper.png");

        pacmanLogicalX = (pacman.getX() + GameSettings.PADDING) / GameSettings.imgPixelSize;
        pacmanLogicalY = (pacman.getY() + GameSettings.PADDING) / GameSettings.imgPixelSize;

        pacman.draw();
    }

    public void setNewPosition(int x, int y, String path) {
        pacman.delete();
        pacman = new Picture(x, y, path);
        pacman.draw();
    }

    public void translate(int x, int y) {
        pacman.translate(x, y);
    }

    public int getX() {
        return pacman.getX();
    }

    public int getY() {
        return pacman.getY();
    }

    public void initPlayerKeyboard() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent keyboardEvent;

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_UP);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            // WALK TO TOP
            case KeyboardEvent.KEY_UP:
                Game.pacman.setNewPosition(this.getX(), this.getY(), "Reaper.png");

                if ((pacmanLogicalY != 0) && (Game.map.itemsOfMap[pacmanLogicalX][pacmanLogicalY - 1].getCanStep())) {
                        pacmanLogicalY--;
                        Game.pacman.translate(0, -GameSettings.imgPixelSize);
                }

                break;

            // WALKT TO LEFT
            case KeyboardEvent.KEY_LEFT:
                Game.pacman.setNewPosition(this.getX(), this.getY(), "Reaper.png");

                if ((pacmanLogicalX != 0) && (Game.map.itemsOfMap[pacmanLogicalX - 1][pacmanLogicalY].getCanStep())) {
                        pacmanLogicalX--;
                        Game.pacman.translate(-GameSettings.imgPixelSize, 0);
                }

                break;

            // WALKT TO RIGHT
            case KeyboardEvent.KEY_RIGHT:
                Game.pacman.setNewPosition(this.getX(), this.getY(), "Reaper.png");

                if ((pacmanLogicalX != GameSettings.arrayBackgroundWidthLength) && (Game.map.itemsOfMap[pacmanLogicalX + 1][pacmanLogicalY].getCanStep())) {
                        pacmanLogicalX++;
                        Game.pacman.translate(GameSettings.imgPixelSize, 0);
                }

                break;

            // WALK TO BOTTOM
            case KeyboardEvent.KEY_DOWN:
                Game.pacman.setNewPosition(this.getX(), this.getY(), "Reaper.png");

                if ((pacmanLogicalY != GameSettings.arrayBackgroundHeightLength) && (Game.map.itemsOfMap[pacmanLogicalX][pacmanLogicalY + 1].getCanStep())) {
                        pacmanLogicalY++;
                        Game.pacman.translate(0, GameSettings.imgPixelSize);
                }

                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}
}