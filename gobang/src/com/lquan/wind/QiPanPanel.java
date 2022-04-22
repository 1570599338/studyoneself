package com.lquan.wind;

import com.lquan.bean.ChessModel;
import com.lquan.common.Constant;
import com.lquan.listener.MouseMotionListener;

import javax.swing.*;
import java.awt.*;


/**
 * @program: gobang
 * @description: 棋盘
 * @author: lquan
 * @create: 2022-04-21 12:14
 **/
public class QiPanPanel extends JPanel {

    private ChessModel[][] chessbeans = new ChessModel[Constant.GoBangGitNumber][Constant.GoBangGitNumber];// all棋子信息



    private TextArea area;// 主图

    public QiPanPanel(TextArea area) {
        this.area = area;

        this.setBackground(Color.ORANGE);// 设置棋盘背景色
        this.setPreferredSize(new Dimension(650, 700));// 设置尺寸和自适应
        this.addMouseMotionListener(new MouseMotionListener(this));// 添加鼠标移动监听
        // this.addMouseListener(l);// 添加鼠标点击监听

        // 初始化棋盘
        for (int i = 0; i < Constant.GoBangGitNumber; ++i) {
            for (int j = 0; j < Constant.GoBangGitNumber; ++j) {
                ChessModel chessbean = new ChessModel(i, j, Constant.EMPTY, 0);
                chessbeans[i][j] = chessbean;
            }
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(2));// 线宽
        // 棋盘
        for (int i = 0; i < Constant.GoBangGitNumber; ++i) {
            g2d.drawLine(40, 40 + i * 40, 40 + (15 - 1) * 40, 40 + i * 40);
            g2d.drawLine(40 + i * 40, 40, 40 + i * 40, 40 + (15 - 1) * 40);
        }

        //棋盘的5个点
        g2d.setStroke(new BasicStroke(8));
        g2d.drawLine(160, 160, 160, 160);
        g2d.drawLine(160, 480, 160, 480);
        g2d.drawLine(320, 320, 320, 320);
        g2d.drawLine(480, 160, 480, 160);
        g2d.drawLine(480, 480, 480, 480);

        // 棋子画预选框(先以中心点为基点)
        /**
         *
         |
         ------|---------->x
         |
         |
         |
         v(y)
         **/
        int x = 320, y = 320;
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(2));
        // 左上坐标点(x-20,y-20)
        g2d.drawLine(x - 20, y - 20, x - 20, y - 20 + 10);
        g2d.drawLine(x - 20, y - 20, x - 20 + 10, y - 20);
        // 右上坐标点(x+20,y-20)
        g2d.drawLine(x + 20, y - 20, x + 20 - 10, y - 20);
        g2d.drawLine(x + 20, y - 20, x + 20, y - 20 + 10);

        // 左下坐标点(x-20,y+20)
        g2d.drawLine(x - 20, y + 20, x - 20, y + 20 - 10);//竖线
        g2d.drawLine(x - 20, y + 20, x - 20 + 10, y + 20);//横线

        // 右下坐标点(x+20,y+20)
        g2d.drawLine(x + 20, y + 20, x + 20, y + 20 - 10);//竖线
        g2d.drawLine(x + 20, y + 20, x + 20 - 10, y + 20);//横线


        // 标数字和字母
        String[] str1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
        String[] str2 = {"15", "14", "13", "12", "11", "10", "  9", "  8", "  7", "  6", "  5", "  4", "  3", "  2",
                "  1"};
        Font font = new Font("微软雅黑", Font.BOLD, 14);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int heigth = fm.getAscent();
        int width = fm.stringWidth(str1[0]);

        // 棋盘
        for (int i = 0; i < Constant.GoBangGitNumber; ++i) {
            g2d.drawString(String.valueOf(str2[i]), 40 / 2 - heigth, 40 * (i + 1) + heigth / 2);
            g2d.drawString(String.valueOf(str1[i]), 40 * (i + 1) - width / 2, 40 / 2 + 600);
        }

        //  画棋子
        // 画圆
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x-15, y-15, 30, 30);

    }

}
