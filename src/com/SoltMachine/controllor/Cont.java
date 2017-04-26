package com.SoltMachine.controllor;

import com.SoltMachine.view.ViewFront;

public class Cont {
	ViewFront view;
	
	public Cont(){
		view = new ViewFront();
	}
	
	public static void main(String[] args) {
		new Cont();	
	}
}
