package com.lquan.bean;

import com.lquan.common.Constant;

/**
 * @program: gobang
 * @description: 棋子
 * @author: lquan
 * @create: 2022-04-21 12:16
 **/
public class ChessModel implements Comparable<ChessModel>{

//棋子类
private int x;
private int y;
private int player;//1:黑  2：白
private int  offense;
private int defense;
private int sum;
private int orderNumber;


    public ChessModel(int x,int y,int player,int orderNumber) {
        this.x=x;
        this.y=y;
        this.player=player;
        this.orderNumber=orderNumber;

    }

    public boolean isEmpty()
    {
        return this.player== Constant.EMPTY;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getOffense() {
        return offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public int compareTo(ChessModel o) {
        if(this.sum>o.sum) {
            return -1;
        }else if(this.sum<o.sum){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ChessModel{" +
                "x=" + x +
                ", y=" + y +
                ", player=" + player +
                ", offense=" + offense +
                ", defense=" + defense +
                ", sum=" + sum +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
