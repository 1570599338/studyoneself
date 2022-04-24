package com.lquan.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;




import com.lquan.bean.ChessModel;
import com.lquan.common.Constant;
import com.lquan.wind.QiPanPanel;

/**
   *  点击监听
 * @author lquan
 *
 */
public class MouseClickListener extends MouseAdapter{
	
	private Boolean isClick=Boolean.FALSE;
	
	private QiPanPanel qipan ;
	
	public MouseClickListener(QiPanPanel qipan) {
		super();
		this.qipan = qipan;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		isClick=Boolean.TRUE;
		//super.mouseClicked(e);
		int Xx=e.getX();
		int Yy=e.getY();			
		Xx=(Xx-Constant.GoBangWWW_offset/2)/ Constant.GoBangWWW_width;
		Yy=(Yy-Constant.GoBangWWW_offset/2)/Constant.GoBangWWW_width;
		if(Xx>=0&&Xx<Constant.GoBangGitNumber&&Yy>=0&&Yy<Constant.GoBangGitNumber) {
			//获取棋子
			ChessModel[][] chessbeans = this.qipan.getChessbeans();
			if(chessbeans[Xx][Yy].isEmpty()) {
				chessbeans[Xx][Yy]=new  ChessModel(Xx,Yy, this.qipan.getCurrentPlayer(),this.qipan.getCount());
				//
				this.qipan.setCurrentPlayer(3-this.qipan.getCurrentPlayer());
				this.qipan.setCount(this.qipan.getCount()+1);
				
				try {
					this.qipan.checkWin(Xx,Yy,chessbeans[Xx][Yy].getPlayer());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
		
		
		
		
	}

	public QiPanPanel getQipan() {
		return qipan;
	}
	
	public Boolean getIsClick() {
		return isClick;
	}

}
