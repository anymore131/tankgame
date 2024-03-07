package com.edu.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game4 extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        new Game4();
    }
    public Game4(){

        DemoDialog dd = new DemoDialog();
        while(true){
            this.setVisible(false);
            if (dd.getKey() == 1 || dd.getKey() == 0){
                break;
            }
        }

        mp = new MyPanel(dd.getKey());
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1300,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听成功！");
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
