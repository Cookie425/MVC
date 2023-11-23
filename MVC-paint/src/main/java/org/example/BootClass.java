package org.example;

import org.example.controller.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class BootClass {
    public static void main(String[] args) {
        Controller.getInstance();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BootClass.class);
        context.refresh();
        context.getBean(Controller.class);
    }
    }
