package com.SoltMachine.controllor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.SoltMachine.model.SlotMethod;
import com.SoltMachine.view.ViewFront;

public class Cont implements ActionListener,Runnable{
	ViewFront view;
	SlotMethod slotM;
	int time=100;
	public Cont(){
		init();
		setting();
		eventUp();
	}
	private void init() {
		view = new ViewFront();
		slotM = new SlotMethod();
	}
	private void setting() {
	}
	private void eventUp() {
		view.bt_spin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == view.bt_spin){
			Thread playTime = new Thread(this);
			view.tf_totSpin.setText(time+"");
			playTime.start();
		}
	}
	
	public static void main(String[] args){
		new Cont();	
	}
	@Override
	public void run(){
		while(true){
			try {
				time--;
				Thread.sleep(10);
				view.spinImage();
				if(time<=0){
					int lastWint = slotM.differentiate(view.rdArr);
					view.tf_lastWin.setText(lastWint+"");
					time =100;
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
