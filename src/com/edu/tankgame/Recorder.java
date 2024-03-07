package com.edu.tankgame;

import java.io.*;
import java.util.Vector;

public class Recorder {

    private static int allEnemyTankNumber = 0;
    private static FileWriter fw = null;
    private static BufferedReader br = null;
    private static BufferedWriter bw = null;
    private static String recordFile = "D:\\myRecord.txt";
    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Node> nodes = new Vector<>();
    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static Vector<Node> getNodes(Vector<Node> nodes){
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNumber = Integer.parseInt(br.readLine());
            String line = "";
            while ((line = br.readLine()) != null){
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNumber + "" + '\r');
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive){
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection() + " " + '\r';
                    bw.write(record);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static int getAllEnemyTankNumber() {
        return allEnemyTankNumber;
    }

    public static void setAllEnemyTankNumber(int allEnemyTankNumber) {
        Recorder.allEnemyTankNumber = allEnemyTankNumber;
    }
    public static void addAllEnemyTankNumber() {
        allEnemyTankNumber++;
    }
}
