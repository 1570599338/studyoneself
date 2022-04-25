package com.lquan.wind;

import com.lquan.bean.ChessModel;
import com.lquan.common.Constant;
import com.lquan.listener.MouseClickListener;
import com.lquan.listener.MouseMotionListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * @program: gobang
 * @description: 棋盘
 * @author: lquan
 * @create: 2022-04-21 12:14
 **/
public class QiPanPanel extends JPanel {
    // 常量
    private final int BLACK = 1;
    private final int WHITE = 2;

    // 游戏标识-结束
    public boolean isGameOver = true;

    private ChessModel[][] chessbeans = new ChessModel[Constant.GoBangGitNumber][Constant.GoBangGitNumber];// all棋子信息
    private MouseMotionListener  mouseMotionListener;
    private MouseClickListener mouseClickListener;
    private int cx = Constant.GoBangGitNumber_center;
    private int cy = Constant.GoBangGitNumber_center;



    private static int count=1;

    //玩家1为黑子，2白子
    private int currentPlayer=WHITE;


    private TextArea area;// 主图

    public QiPanPanel(TextArea area) {
        this.area = area;
        mouseMotionListener=new MouseMotionListener(this);
        mouseClickListener=new MouseClickListener(this);

        this.setBackground(Color.ORANGE);// 设置棋盘背景色
        this.setPreferredSize(new Dimension(650, 700));// 设置尺寸和自适应
        this.addMouseMotionListener(mouseMotionListener);// 添加鼠标移动监听
         this.addMouseListener(mouseClickListener);// 添加鼠标点击监听

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
       // int x = 320, y = 320;
        int x=this.cx*40,y=this.cy*40;
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

      // 画棋子
        drawChess(g2d);
    }

    public void drawChess(Graphics2D g2d){// 画棋子

        int width = Constant.GoBangWWW_width / 4 * 3;
        for (ChessModel[] chessBean2 : chessbeans) {
            for (ChessModel chessBean : chessBean2) {
                if (!chessBean.isEmpty()) {
                    if (chessBean.getPlayer() == BLACK) {
                        g2d.setColor(Color.BLACK);
                    } else if (chessBean.getPlayer() == WHITE) {
                        g2d.setColor(Color.WHITE);
                    }
                    // 橡素坐标
                    int x = chessBean.getX() * Constant.GoBangWWW_width + Constant.GoBangWWW_offset - width / 2;
                    int y = chessBean.getY() * Constant.GoBangWWW_width + Constant.GoBangWWW_offset - width / 2;
                    g2d.fillOval(x, y, width, width);
                }
            }

        }
    }


    /**
     * 检查是否构成五子
     * @param x
     * @param y
     * @param player
     * @return
     * @throws IOException
     */
    public boolean checkWin(int x,int y,int player) throws IOException {//判断输赢


        if(count==226){
            JOptionPane.showMessageDialog(QiPanPanel.this,"平局");
            isGameOver=true;
            System.out.println(count+"\t"+(isGameOver==true?"true":"false"));
            return true;
        }else{
            boolean win =false;
            if((1+check(x,y,1,0,player))+check(x,y,-1,0,player)>=5){
                win=true;
            }else if((1+check(x,y,0,1,player))+check(x,y,0,-1,player)>=5){
                win=true;
            }else if((1+check(x,y,1,1,player))+check(x,y,-1,-1,player)>=5){
                win=true;
            }else if((1+check(x,y,-1,1,player))+check(x,y,1,-1,player)>=5){
                win=true;
            }
            if(win) {

                ChessModel biaoji=null;//标记

                JOptionPane.showMessageDialog(QiPanPanel.this, (player==BLACK?"黑子":"白子")+"赢了");
                //	GoBangFrame.music1.STop();
                //	GoBangFrame.flag=0;
                isGameOver=true;
                return true;
            }
        }
        return false;
    }

    public int check(int x, int y, int dx, int dy, int player) {// 检查五子连线
        int ncount = 0;
        for (int i = 0; i < 4; ++i){
            x += dx;
            y += dy;
            if (x >= 0 && x < Constant.GoBangGitNumber && y >= 0 && y < Constant.GoBangGitNumber){// 检查是否溢界
                if (chessbeans[x][y].getPlayer() == player) {
                    ncount++;
                } else {
                    break;
                }
            }
        }
        return ncount;
    }

    public ChessModel[][] getChessbeans() {
        return chessbeans;
    }

    public void setChessbeans(ChessModel[][] chessbeans) {
        this.chessbeans = chessbeans;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        QiPanPanel.count = count;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public MouseMotionListener getMouseMotionListener() {
        return mouseMotionListener;
    }

    public MouseClickListener getMouseClickListener() {
        return mouseClickListener;
    }

    public void setMouseMotionListener(MouseMotionListener mouseMotionListener) {
        this.mouseMotionListener = mouseMotionListener;
    }

    public void setMouseClickListener(MouseClickListener mouseClickListener) {
        this.mouseClickListener = mouseClickListener;
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }
}
