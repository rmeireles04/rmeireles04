package org.academiadecodigo.PhloxPurple.KillingMCs.Map.Items;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Shape extends ItemOfMap {

    private Picture shape;

    public Shape() {
        super(false);
    }

    public Shape(int x, int y) {
        super(false);
        shape = new Picture(x, y, "shape.png");
        shape.draw();
    }

}