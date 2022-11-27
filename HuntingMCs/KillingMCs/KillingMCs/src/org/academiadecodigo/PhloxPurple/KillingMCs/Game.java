package org.academiadecodigo.PhloxPurple.KillingMCs;

import org.academiadecodigo.PhloxPurple.KillingMCs.Actors.*;
import org.academiadecodigo.PhloxPurple.KillingMCs.Map.Map;
import org.academiadecodigo.PhloxPurple.KillingMCs.Settings.GameSettings;
import org.academiadecodigo.PhloxPurple.KillingMCs.Sounds.SoundHandler;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game implements KeyboardHandler{

    public static Map map;

    private Picture miguel;
    public static PacMan pacman;
    private Guga guga;
    private Mariana mariana;
    private Baljeet baljeet;
    private Beatriz beatriz;
    private Bernardo bernardo;
    private Carol carol;
    private Sara sara;

    private Picture gameStarts;
    private Picture instructions;
    private Picture one;
    private Picture two;
    private Picture three;

    private Menu menu;


    private boolean gameOver = false;

    public Game() throws InterruptedException {


        mainFrame();

        map = new Map();
        pacman = new PacMan();
        guga = new Guga();
        mariana = new Mariana();
        baljeet = new Baljeet();
        beatriz = new Beatriz();
        bernardo = new Bernardo();
        carol = new Carol();
        sara = new Sara();
        menu = new Menu();


    }

    private void mainFrame() throws InterruptedException {
        Rectangle mainFrame = new Rectangle(GameSettings.PADDING, GameSettings.PADDING, GameSettings.width, GameSettings.height);
        mainFrame.setColor(Color.BLACK);
        mainFrame.fill();

        Frame.getFrames()[0].setTitle("Hunting @ AC_");

        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        Frame.getFrames()[0].setCursor(blankCursor);

        Frame.getFrames()[0].pack();
        //Frame.getFrames()[0].setLocationRelativeTo(null);
        Frame.getFrames()[0].setVisible(true);


        gameStarts = new Picture(GameSettings.PADDING, GameSettings.PADDING, "gameStart.png");
        instructions = new Picture(GameSettings.PADDING, GameSettings.PADDING, "Instructions.png");
        one = new Picture(GameSettings.PADDING, GameSettings.PADDING, "one.png");
        two = new Picture(GameSettings.PADDING, GameSettings.PADDING, "two.png");
        three = new Picture(GameSettings.PADDING, GameSettings.PADDING, "three.png");

        gameStarts.draw();
        Thread.sleep(2000);
        gameStarts.delete();
        SoundHandler.RunMusic("KillingMCs/KillingMCs/resources/Sounds/openingSound.wav");
        instructions.draw();
        Thread.sleep(1500);
        instructions.delete();
        three.draw();
        Thread.sleep(1000);
        three.delete();
        two.draw();
        Thread.sleep(1000);
        two.delete();
        one.draw();
        Thread.sleep(1000);
        one.delete();
    }


    public void startGame() throws InterruptedException {

        pacman.initPlayerKeyboard();


        while (!gameOver) {

            mariana.move();
            mariana.isCollided(pacman);
            guga.move();
            guga.isCollided(pacman);
            baljeet.move();
            baljeet.isCollided(pacman);
            beatriz.move();
            beatriz.isCollided(pacman);
            bernardo.move();
            bernardo.isCollided(pacman);
            carol.move();
            carol.isCollided(pacman);
            sara.move();
            sara.isCollided(pacman);

            checkGameOver();

            if (gameOver) {
                miguel = new Picture(GameSettings.PADDING, GameSettings.PADDING, "end.png");
                miguel.draw();
                Thread.sleep(3000);


                //Runtime.getRuntime().exit(1000);


                }

            }

        KeyboardEvent keyboardEvent = new KeyboardEvent();

        switch (keyboardEvent.getKey()) {
            // WALK TO TOP
            case KeyboardEvent.KEY_R:

                    startGame();

                break;

            // WALKT TO LEFT
            case KeyboardEvent.KEY_Q:
                Runtime.getRuntime().exit(10);
                break;

        }

menu.initPlayerKeyboard();

    }

    private void checkGameOver() {
        if (guga.isDead() && mariana.isDead() && baljeet.isDead() && beatriz.isDead()
                && bernardo.isDead() && carol.isDead() && sara.isDead()) {
            gameOver = true;

        }
    }

    public void initPlayerKeyboard() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent keyboardEvent;

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_Q);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);


        }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            // WALK TO TOP
            case KeyboardEvent.KEY_R:
                try {
                    startGame();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                break;

            // WALKT TO LEFT
            case KeyboardEvent.KEY_Q:
                Runtime.getRuntime().exit(10);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
            //Runtime.getRuntime().exit(0);
    // }






