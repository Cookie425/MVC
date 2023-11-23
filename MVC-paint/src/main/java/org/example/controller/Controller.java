package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.fill.NoFill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;*/

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Controller {
   private static Controller controller;
   private ActionDraw actionDraw;
    private Model model;
    private MyFrame frame;
    private MyPanel panel;
    private Point2D [] pd;
    private MyShape shape;

    public Controller(ActionDraw actionDraw) {
        this.actionDraw = actionDraw;

    }
    public void init() {
        shape = new MyShape(Color.BLACK, new Rectangle2D.Double(), new NoFill());
        actionDraw.setSampleShape(shape);
        actionDraw.setShape(shape);
        model.addObserver(panel);
        frame.setPanel(panel);

        pd = new Point2D[2];
    }

    protected Controller() {
        model = new Model();
        shape = new MyShape(new Rectangle2D.Double());
        shape.setFb(new NoFill());
        model.setMyShape(shape);

        panel = new MyPanel();
        panel.setController(this);

        model.addObserver(panel);

        frame = new MyFrame();
        frame.setPanel(panel);

        pd = new Point2D[2];
    }
   /* void MouseStreth(Point point){
        actionDraw.createShape(point);

    }*/
    void MouseDreget(Point point){
        actionDraw.createShape(point);

    }
    public void mousePressed(Point point){
        actionDraw.createShape(point);


    }

    public void getPointOne(Point2D p){
        pd[0] = p;
    }
    public void getPointTwo(Point2D p){
        pd[1] = p;
        model.changeShape(pd);
    }
    static public Controller getInstance(){
        if(controller == null)
            controller = new Controller();
        return controller;
    }

    public void draw(Graphics2D g2) {
        model.setMyShape(shape);
        model.draw(g2);
    }
    public void createSampleShape(MyShape shape){
       createSampleShape(shape);
    }
    public void setModel(Model model) {
        this.model = model;
    }

    public void setFrame(MyFrame frame) {
        this.frame = frame;
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }

    public void setActionDraw(ActionDraw actionDraw) {
        this.actionDraw = actionDraw;
    }
}
