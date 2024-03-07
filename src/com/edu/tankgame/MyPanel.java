package com.edu.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    Vector<Shot> shots = new Vector<>();
    Vector<Node> nodes = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    int enemyTankSize = 3;
    int key = 3;
    public  MyPanel(int key){

        switch (key){
            case 0:
                myTank = new MyTank(500,200);//初始化
                myTank.setSpeed(5);
                for (int i = 0; i < enemyTankSize; i++) {
                    EnemyTank enemyTank = new EnemyTank(i * 100 + 100,0);
                    enemyTank.setEnemyTank(enemyTanks);
                    enemyTank.setDirection(2);
                    new Thread(enemyTank).start();
                    enemyTanks.add(enemyTank);
                }
                myTank.setEnemyTank(enemyTanks);
                break;
            case 1:
                Recorder.getNodes(nodes);
                System.out.println(nodes.size());
                myTank = new MyTank(500,200);//初始化
                myTank.setSpeed(5);
                for (int i = 0; i < nodes.size(); i++) {
                    EnemyTank enemyTank = new EnemyTank(nodes.get(i).getX(),nodes.get(i).getY());
                    System.out.println(nodes.get(i).getX() + "");
                    enemyTank.setEnemyTank(enemyTanks);
                    enemyTank.setDirection(nodes.get(i).getDirection());
                    new Thread(enemyTank).start();
                    enemyTanks.add(enemyTank);
                }
                myTank.setEnemyTank(enemyTanks);
                break;

        }



        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        show(g);
        if (myTank != null && myTank.isLive){
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirection(),0);
        }
//        if(myTank.shot != null && myTank.shot.isLive != false){
//            g.draw3DRect(myTank.shot.x, myTank.shot.y,1,1,false);
//        }

        for (int i = 0; i < shots.size(); i++) {
            Shot shot = shots.get(i);
            new Thread(shot).start();
            if (shot != null && myTank.shot.isLive != false) {
                g.draw3DRect(shot.x,shot.y,1,1,false);
            } else if (shot.isLive == false) {
                shots.remove(i);
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6){
                 g.drawImage(image1, bomb.x, bomb.y, 60,60,this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60,60,this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60,60,this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        for (int i = 0; i < enemyTanks.size(); i++) {//绘制敌方坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank.isLive){
                drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirection(),1);
                for(int j = 0; j < enemyTank.shots.size(); j++){
                    Shot shot = enemyTank.shots.get(j);
                    if(shot.isLive){
                        g.draw3DRect(shot.x, shot.y, 1,1,false);
                    }else{
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
        Recorder.setEnemyTanks(enemyTanks);
    }

    public void show(Graphics g){
        g.setColor(Color.BLACK);
        Font font = new Font("微软雅黑",Font.BOLD,25);
        g.setFont(font);
        g.drawString("累计击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,1);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTankNumber() + "",1080,100);
    }

    public void drawTank(int x,int y,Graphics g,int direction,int type){
        switch (type){
            case 0:
                //自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1:
                //地方坦克
                g.setColor(Color.yellow);
                break;
        }
        switch (direction){
            case 0://up
                g.fill3DRect(x, y, 10,60,false);//左轮子
                g.fill3DRect(x + 30,y,10,60,false);//右轮子
                g.fill3DRect(x + 10,y + 20,20,30,false);
                g.fillOval(x + 10,y + 25,20,20);
                g.drawLine(x + 20,y,x + 20,y + 35);
                break;
            case 1://right
                g.fill3DRect(x, y, 60,10,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fill3DRect(x + 10,y + 10,30,20,false);
                g.fillOval(x + 15,y + 10,20,20);
                g.drawLine(x + 25,y + 20,x + 60,y + 20);
                break;
            case 2://down
                g.fill3DRect(x, y, 10,60,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,30,false);
                g.fillOval(x + 10,y + 15,20,20);
                g.drawLine(x + 20,y + 25,x + 20,y + 60);
                break;
            case 3://left
                g.fill3DRect(x, y, 60,10,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fill3DRect(x + 20,y + 10,30,20,false);
                g.fillOval(x + 25,y + 10,20,20);
                g.drawLine(x,y + 20,x + 35,y + 20);
                break;
            default:
        }
    }

    public void hitMyTank(){
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if(shot != null && myTank.isLive && shot.isLive){
                    hitTank(shot,myTank);
                }
            }
        }
    }
    public void hitEnemyTank(){
        for (int i = 0; i < shots.size(); i++) {//单颗子弹判断击中
            Shot shot = shots.get(i);
            if(shot != null && shot.isLive){
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(shot,enemyTank);
                }
            }
        }
    }
    //判断是否击中
    public void hitTank(Shot s,Tank tank){
        switch (tank.getDirection()){
            case 0:
            case 2:
                if (s.x > tank.getX() && s.x < tank.getX() +40
                        && s.y > tank.getY() && s.y < tank.getY() + 60){
                    s.isLive = false;
                    tank.isLive = false;
                    enemyTanks.remove(tank);
                    if (tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNumber();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    shots.remove(s);
                }
                break;
            case 1:
            case 3:
                if (s.x > tank.getX() && s.x < tank.getX() + 60
                        && s.y > tank.getY() && s.y < tank.getY() + 40){
                    s.isLive = false;
                    tank.isLive = false;
                    enemyTanks.remove(tank);
                    if (tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNumber();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    shots.remove(s);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W && myTank.isLive && myTank.block()){
            //改变方向
            myTank.setDirection(0);
            //修改坐标
            if (myTank.getY() > 0) {
                myTank.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D && myTank.isLive && myTank.block()) {
            myTank.setDirection(1);
            if (myTank.getX() + 60 < 1000) {
                myTank.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S && myTank.isLive && myTank.block()) {
            myTank.setDirection(2);
            if (myTank.getY() + 60 < 750) {
                myTank.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A && myTank.isLive && myTank.block()) {
            myTank.setDirection(3);
            if (myTank.getX() > 0){
                myTank.moveLeft();
            }
        }
        //发射
        if (e.getKeyCode() == KeyEvent.VK_J && myTank.isLive) {
            myTank.shotEnemy();
            Shot shot = new Shot(myTank.shot);
            shots.add(shot);
        }
        this.repaint();//重绘
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemyTank();
            hitMyTank();
            this.repaint();
        }
    }
}
