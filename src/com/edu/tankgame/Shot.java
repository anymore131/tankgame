package com.edu.tankgame;

public class Shot implements Runnable{
    int x;
    int y;
    int direction;
    int speed = 5;
    boolean isLive = true;
    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Shot(Shot shot){
        this.x = shot.x;
        this.y = shot.y;
        this.isLive = shot.isLive;
        this.direction = shot.direction;
        this.speed = shot.speed;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction){
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                isLive = false;
                break;
            }
        }
    }
}
