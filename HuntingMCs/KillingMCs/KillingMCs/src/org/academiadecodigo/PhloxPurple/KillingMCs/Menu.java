package org.academiadecodigo.PhloxPurple.KillingMCs;

import org.academiadecodigo.PhloxPurple.KillingMCs.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Menu implements KeyboardHandler {

    private Game game;

    public Menu() {
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
                    game.startGame();
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


