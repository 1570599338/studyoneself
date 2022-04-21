package com.lquan.wind;

import javax.swing.*;
import java.awt.*;

/**
 * @program: gobang
 * @description: 框架
 * @author: lquan
 * @create: 2022-04-21 12:12
 **/
public class WZWindowFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    TextArea area=new TextArea();
    QiPanPanel qiPanPanel = new QiPanPanel(area);

    public void start() {
        // 名称
        this.setTitle("五子棋");
        // 棋盘，west
        this.add(qiPanPanel,BorderLayout.WEST);





        this.setResizable(false);//缩放
        this.setSize(900, 700);//大小
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
