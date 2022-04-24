package com.lquan.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


import com.lquan.common.Constant;
import com.lquan.wind.QiPanPanel;

public class MouseMotionListener extends MouseMotionAdapter {

	public static final int GoBangGitNumber_center=8;//���ĵ����(8,H(8))
	public static final int GoBangGitNumber_change=4;//�������ĵ�ľ���ƽ��ֵ
	private int cx=GoBangGitNumber_center;
	private int cy=GoBangGitNumber_center;
	
	private QiPanPanel qipan ;
	
	
	public MouseMotionListener(QiPanPanel qipan) {
		
		this.qipan = qipan;
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();			
		cx=(x- Constant.GoBangWWW_offset/2)/Constant.GoBangWWW_width+1;
		cy=(y-Constant.GoBangWWW_offset/2)/Constant.GoBangWWW_width+1;
		qipan.setCx(cx);
		qipan.setCy(cy);

		if(cx>=0&&cx<=Constant.GoBangGitNumber&&cy>=0&&cy<=Constant.GoBangGitNumber){
			qipan.repaint();
		}
		System.out.println("cx:"+cx+"---cy:"+cy);
		
	}


	public QiPanPanel getQipan() {
		return qipan;
	}



}
