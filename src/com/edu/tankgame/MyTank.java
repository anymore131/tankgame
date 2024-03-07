package com.edu.tankgame;

import java.util.Vector;

public class MyTank extends Tank {
     Shot shot = null;

    @Override
    public void setSpeed(int speed) {
        super.setSpeed(speed);
    }

    public MyTank(int x, int y){
        super(x, y);
    }
    Vector<EnemyTank> enemyTanks = new Vector<>();
    public void setEnemyTank(Vector<EnemyTank> enemyTanks){
        this.enemyTanks = enemyTanks;
    }
    public boolean block(){
        switch (this.getDirection()){
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
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
            case 1:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
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
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
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
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
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
        return true;
    }
    public void shotEnemy(){
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
        //new Thread(shot).start();
    }
}
