package com.edu.tankgame;

import java.util.Vector;

public class Tank {
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    private int x;
    private int y;
    private int direction;
    private int speed = 2;
    public Tank(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public void setDirection(int direction){
        this.direction = direction;
    }
    public int getDirection() {
        return direction;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getSpeed(){
        return speed;
    }
    public void moveUp(){
        y -= speed;
    }
    public void moveRight(){
        x += speed;
    }
    public void moveDown(){
        y += speed;
    }
    public void moveLeft(){
        x -= speed;
    }
}
