package org.example.model;

import org.example.model.fill.Fill;
import org.example.model.fill.FillBehavior;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class MyShape  {
    private Color color;
    private RectangularShape shape;
    private FillBehavior fb;
    private Cloneable cloneable;

    public MyShape(RectangularShape shape) {
        this.shape = shape;
        color = Color.GRAY;
        fb = new Fill();
        fb.setColor(color);
        fb.serShape(shape);
    }

    public MyShape() {
        color = Color.GRAY;
        shape = new Rectangle2D.Double();
        fb = new Fill();
        fb.setColor(color);
        fb.serShape(shape);
    }

    public MyShape(Color color, RectangularShape shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
        this.fb.serShape(shape);
        this.fb.setColor(color);
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
        fb.serShape(shape);
        fb.setColor(color);
    }

    public void setShape(RectangularShape shape) {
       /* MyShape clone = new MyShape();*/
        this.shape = shape;
    }

    public void setFrame(Point2D[] pd) {
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    void draw(Graphics2D g) {
        fb.draw(g);

    }

    public MyShape clone () {
        MyShape clone = new MyShape();
        clone.shape = (RectangularShape) this.shape.clone();
        clone.fb =this.fb;
        clone.color = this.color;
        clone.setShape((RectangularShape) this.shape.clone());
        return clone;
    }



}
