package com.lquan.common;

/**
 * @program: gobang
 * @description: 常量
 * @author: lquan
 * @create: 2022-04-21 12:23
 **/
public class Constant {

    public static final int EMPTY = 0;


    //工具类
    //常量

    //视图的宽和高
    public static final int GoBang_Width=900;
    public static final int GoBang_High=700;

    //地图的宽和高
    public static final int GoBangPanel_Width=650;
    public static final int GoBangPanel_High=700;

    public static final int GoBangWWW_offset=40;//偏离量
    public static final int GoBangWWW_width=40;//两点宽度
    public static final int GoBangGitNumber=15;//计数（行和列的总数）
    public static final int GoBangGitNumber_center=8;//中心点序号(8,H(8))
    public static final int GoBangGitNumber_change=4;//星离中心点的距离平均值
    //中心点坐标x和y
    public static final int GoBang_centpoint_x=GoBangWWW_offset*GoBangGitNumber_center;
    public static final int GoBang_centpoint_y=GoBangWWW_offset*GoBangGitNumber_center;





    //游戏模式
    public static boolean Game=true;
}
