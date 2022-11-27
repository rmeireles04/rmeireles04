package org.academiadecodigo.PhloxPurple.KillingMCs;

public class Main {
    public static void main(String[] args) {
        try {
            Game pacman = new Game();
            pacman.startGame();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }





    }
}