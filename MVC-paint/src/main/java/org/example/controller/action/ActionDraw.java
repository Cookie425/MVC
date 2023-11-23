package org.example.controller.action;


import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;


public class ActionDraw extends Container {
    private MyShape sampleShape;
    private MyShape shape;
    private Point2D [] p;
    private Model model;
    public ActionDraw() {

    }
    public void init() {
        shape = new MyShape();
        p = new Point2D[2];
    }

 public void stretchShape(Point point){
        p[1] =(Point2D) point;
        shape.setFrame(p);
    }
    public void createShape(Point point){
        p[0] = (Point2D)point;
        shape = sampleShape.clone();
        model.createCurrentShape(shape);
    }

    public ActionDraw(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public ActionDraw(Model model) {
        shape = new MyShape();
        this.model = model;
    }

    public ActionDraw(Point2D[] p) {
        this.p = p;
    }
    public  void setShape(MyShape shape){
        this.shape= shape;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }
}









