package com.edu.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    public void setEnemyTank(Vector<EnemyTank> enemyTanks){
        this.enemyTanks = enemyTanks;
    }
    public boolean block(){
        switch (this.getDirection()){
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (this.getY() <= enemyTank.getY() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40){
                                return false;
                            }
                            if (this.getY() <= enemyTank.getY() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40){
                                return false;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() ==3) {
                            if (this.getY() <= enemyTank.getY() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60){
                                return false;
                            }
                            if (this.getY() <= enemyTank.getY() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60){
                                return false;
                            }
                        }
                    }
                }
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (this.getY() <= enemyTank.getY() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40){
                                return false;
                            }
                            if (this.getY() + 40 <= enemyTank.getY() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40){
                                return false;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() ==3) {
                            if (this.getY() <= enemyTank.getY() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60){
                                return false;
                            }
                            if (this.getY() + 40 <= enemyTank.getY() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60){
                                return false;
                            }
                        }
                    }
                }
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (this.getY() + 60<= enemyTank.getY() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40){
                                return false;
                            }
                            if (this.getY() + 60 <= enemyTank.getY() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40){
                                return false;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() ==3) {
                            if (this.getY() + 60 <= enemyTank.getY() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60){
                                return false;
                            }
                            if (this.getY() + 60 <= enemyTank.getY() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60){
                                return false;
                            }
                        }
                    }
                }
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (this.getY() <= enemyTank.getY() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40){
                                return false;
                            }
                            if (this.getY() + 40 <= enemyTank.getY() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40){
                                return false;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() ==3) {
                            if (this.getY() <= enemyTank.getY() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60){
                                return false;
                            }
                            if (this.getY() + 40 <= enemyTank.getY() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60){
                                return false;
                            }
                        }
                    }
                }
        }
        return true;
    }
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true){
            int step = 30;
            if (shots.size() < 10 && isLive){
                Shot shot = null;
                switch (getDirection()){
                    case 0:
                        shot = new Shot(getX() + 20,getY(),0);
                        break;
                    case 1:
                        shot = new Shot(getX() + 60,getY() + 20,1);
                        break;
                    case 2:
                        shot = new Shot(getX() + 20,getY() + 60,2);
                        break;
                    case 3:
                        shot = new Shot(getX(),getY() + 20,3);
                        break;
                }
                shots.add(shot);
                new Thread(shot).start();
            }
            again:switch (getDirection()){
                case 0:
                    for (int i = 0; i < step; i++) {
                        if(getY() > 0 && block()) {
                            moveUp();
                        }else break again;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < step; i++) {
                        if (getX() + 60 < 1000 && block()) {
                            moveRight();
                        }else break again;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < step; i++) {
                        if (getY() + 60 < 750 && block()) {
                            moveDown();
                        }else break again;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < step; i++) {
                        if (getX() > 0 && block()) {
                            moveLeft();
                        }else break again;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            step = (int)Math.random()*20 + 20;
            setDirection((int)(Math.random()*4));
            if (!isLive){
                break;
            }
        }
    }
}
