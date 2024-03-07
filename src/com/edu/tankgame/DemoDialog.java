package com.edu.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoDialog extends JDialog implements ActionListener {
    JButton jb1;
    JButton jb2;
    private int key = 3;
    DemoDialog(){
        this.setTitle("Dialog弹窗");
        this.setVisible(true);
        this.setLocation(200,200);
        this.setSize(200,100);
        //add one label
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p.setLayout(new BorderLayout());
        JLabel jLabel = new JLabel("请选择：");
        jb1 = new JButton("新游戏");
        jb2 = new JButton("上局游戏");
        contentPane.add(jLabel,BorderLayout.NORTH);

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        p1.add(jb1);
        p2.add(jb2);
        p.add(p1,BorderLayout.WEST);
        p.add(p2,BorderLayout.EAST);
        contentPane.add(p,BorderLayout.CENTER);

        //center 居中
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1){
            key = 0;
            this.setVisible(false);
        } else if (e.getSource() == jb2) {
            key = 1;
            this.setVisible(false);
        }
    }
    public int getKey(){
        return this.key;
    }
}
