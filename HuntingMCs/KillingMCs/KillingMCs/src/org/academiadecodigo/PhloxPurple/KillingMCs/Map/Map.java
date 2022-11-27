package org.academiadecodigo.PhloxPurple.KillingMCs.Map;

import org.academiadecodigo.PhloxPurple.KillingMCs.Map.Items.ItemOfMap;
import org.academiadecodigo.PhloxPurple.KillingMCs.Map.Items.Shape;
import org.academiadecodigo.PhloxPurple.KillingMCs.Map.Items.blankSpace;
import org.academiadecodigo.PhloxPurple.KillingMCs.Settings.GameSettings;

public class Map {

    public ItemOfMap[][] itemsOfMap;

    public Map() {
        itemsOfMap = new ItemOfMap[GameSettings.arrayBackgroundWidthLength][GameSettings.arrayBackgroundHeightLength];

        for (int x = 0; x < GameSettings.arrayBackgroundWidthLength; x++) {
            for (int y = 0; y < GameSettings.arrayBackgroundHeightLength; y++) {
                itemsOfMap[x][y] = new blankSpace();
            }
        }

        makeBorder();
        makeMap();
        //SoundHandler.RunMusic("PacmanFINAL/src/org/academiadecodigo/teamgreen/pacman/Sounds/openingSound.wav");
    }

    /*
     *** TO DRAW MAP HERE (makeMap)  ***
     */
    private void makeMap() {

        makeRectangleAndSquare(68 + GameSettings.PADDING, 68 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(306 + GameSettings.PADDING, 68 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(612 + GameSettings.PADDING, 68 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(68 + GameSettings.PADDING, 68 + GameSettings.PADDING, 1, 5);
        makeRectangleAndSquare(782 + GameSettings.PADDING, 68 + GameSettings.PADDING, 1, 4);
        makeRectangleAndSquare(102 + GameSettings.PADDING, 544 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(306 + GameSettings.PADDING, 544 + GameSettings.PADDING, 3, 1);
        makeRectangleAndSquare(612 + GameSettings.PADDING, 544 + GameSettings.PADDING, 5, 1);
        makeRectangleAndSquare(68 + GameSettings.PADDING, 340 + GameSettings.PADDING, 1, 3);
        makeRectangleAndSquare(782 + GameSettings.PADDING, 340 + GameSettings.PADDING, 1, 4);
        makeRectangleAndSquare(238 + GameSettings.PADDING, 34 + GameSettings.PADDING, 1, 4);
        //makeRectangleAndSquare(136,136,2,1);
        makeRectangleAndSquare(136 + GameSettings.PADDING, 204 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(34 + GameSettings.PADDING, 272 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(34 + GameSettings.PADDING, 476 + GameSettings.PADDING, 2, 1);
        makeRectangleAndSquare(102 + GameSettings.PADDING, 340 + GameSettings.PADDING, 1, 1);
        makeRectangleAndSquare(204 + GameSettings.PADDING, 272 + GameSettings.PADDING, 1, 5);
        makeRectangleAndSquare(136 + GameSettings.PADDING, 408 + GameSettings.PADDING, 1, 3);
        makeRectangleAndSquare(204 + GameSettings.PADDING, 476 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(306 + GameSettings.PADDING, 136 + GameSettings.PADDING, 1, 4);
        makeRectangleAndSquare(272 + GameSettings.PADDING, 272 + GameSettings.PADDING, 5, 1);
        makeRectangleAndSquare(374 + GameSettings.PADDING, 136 + GameSettings.PADDING, 2, 3);
        makeRectangleAndSquare(272 + GameSettings.PADDING, 340 + GameSettings.PADDING, 3, 3);
        //makeRectangleAndSquare(408,306,1,2);
        makeRectangleAndSquare(374 + GameSettings.PADDING, 476 + GameSettings.PADDING, 1, 2);
        makeRectangleAndSquare(408 + GameSettings.PADDING, 408 + GameSettings.PADDING, 3, 1);
        makeRectangleAndSquare(442 + GameSettings.PADDING, 544 + GameSettings.PADDING, 2, 2);
        makeRectangleAndSquare(442 + GameSettings.PADDING, 476 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(544 + GameSettings.PADDING, 510 + GameSettings.PADDING, 1, 2);
        makeRectangleAndSquare(476 + GameSettings.PADDING, 34 + GameSettings.PADDING, 1, 4);
        makeRectangleAndSquare(544 + GameSettings.PADDING, 68 + GameSettings.PADDING, 1, 2);
        makeRectangleAndSquare(544 + GameSettings.PADDING, 136 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(714 + GameSettings.PADDING, 170 + GameSettings.PADDING, 1, 3); //
        makeRectangleAndSquare(782 + GameSettings.PADDING, 238 + GameSettings.PADDING, 2, 2);
        makeRectangleAndSquare(476 + GameSettings.PADDING, 204 + GameSettings.PADDING, 4, 1);
        makeRectangleAndSquare(476 + GameSettings.PADDING, 238 + GameSettings.PADDING, 1, 4);
        makeRectangleAndSquare(544 + GameSettings.PADDING, 408 + GameSettings.PADDING, 1, 3);
        makeRectangleAndSquare(612 + GameSettings.PADDING, 442 + GameSettings.PADDING, 4, 2);
        makeRectangleAndSquare(714 + GameSettings.PADDING, 340 + GameSettings.PADDING, 1, 2);
        makeRectangleAndSquare(646 + GameSettings.PADDING, 204 + GameSettings.PADDING, 1, 4);
        makeRectangleAndSquare(578 + GameSettings.PADDING, 306 + GameSettings.PADDING, 1, 1);
        makeRectangleAndSquare(544 + GameSettings.PADDING, 272 + GameSettings.PADDING, 1, 2);
        makeRectangleAndSquare(612 + GameSettings.PADDING, 374 + GameSettings.PADDING, 3, 1);


    }

    // <Makers>
    private void makeBorder() {
        // Top and Bottom
        for (int i = 0; i < GameSettings.arrayBackgroundWidthLength; i++) {
            makeShape(i * GameSettings.imgPixelSize + GameSettings.PADDING, GameSettings.PADDING);
            makeShape(i * GameSettings.imgPixelSize + GameSettings.PADDING, (GameSettings.height - GameSettings.imgPixelSize) + GameSettings.PADDING);
        }

        // Left and Right
        for (int i = 1; i < GameSettings.arrayBackgroundHeightLength - 1; i++) {
            makeShape(GameSettings.PADDING, i * GameSettings.imgPixelSize + GameSettings.PADDING);
            makeShape((GameSettings.width - GameSettings.imgPixelSize) + GameSettings.PADDING, i * GameSettings.imgPixelSize + GameSettings.PADDING);
        }
    }

    private void makeShape(int x, int y) {
        int logicalX = x / GameSettings.imgPixelSize;
        int logicalY = y / GameSettings.imgPixelSize;

        for (int arrayX = logicalX; arrayX < logicalX + 1; arrayX++) {
            for (int arrayY = logicalY; arrayY < logicalY + 1; arrayY++) {
                itemsOfMap[arrayX][arrayY] = new Shape(x, y);
            }
        }
    }

    private void makeRectangleAndSquare(int x, int y, int numberOfGrassX, int numberOfGrassY) {
        int logicalX = x / GameSettings.imgPixelSize;
        int logicalY = y / GameSettings.imgPixelSize;

        for (int arrayX = logicalX; arrayX < logicalX + numberOfGrassX; arrayX++) {
            for (int arrayY = logicalY; arrayY < logicalY + numberOfGrassY; arrayY++) {
                itemsOfMap[arrayX][arrayY] = new Shape(GameSettings.imgPixelSize * arrayX + GameSettings.PADDING, GameSettings.imgPixelSize * arrayY + GameSettings.PADDING);
            }
        }
    }
    // </Makers>
}