package org.example.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    private MyShape currentShape;
    private List <MyShape> myList;

    public Model() {
    }
    public void init() {
        myList = new ArrayList<>();
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D[] pd) {
        currentShape.setFrame(pd);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        currentShape.draw(g);
    }

    public void createCurrentShape(MyShape shape) {
        currentShape = shape;
        myList.add(currentShape);
        setChanged();
        notifyObservers();

    }
}
