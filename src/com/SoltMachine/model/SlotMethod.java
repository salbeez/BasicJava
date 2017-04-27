package com.SoltMachine.model;

import javax.swing.ImageIcon;

/*		
		0 = bar
		1 = bigwin
		2 = cherry
		3 = seven
		4 = sweetMelon
		5 = banana
		**rule**
		*BIG *3 = 200
		*BAR*3 	= 50
		*7 *3		= 20
		*(sM|ba) && (ch|sev) && (bar|big)	= 16
		*ch*3	= 15
		*bana*3	= 14
		*SM*3	= 12
		*Fuilt*3	=7
		
*/
public class SlotMethod{
	public int differentiate(int rdArr[]){
		int num= rdArr[0];
		int num2= rdArr[1];
		int num3= rdArr[2];
		
		if(num==1 && num2==1 && num3==1){
			return 200;
		}else if (num==0 && num2==0 && num3==0){
			return 50;
		}else if (num==3 && num2==3 && num3==3) {
			return 20;
		}else if( (num==4 || num==5) && (num==2 || num==3) && (num==0 || num==1) ){
			return 16;
		}else if(num==2 && num2==2 && num3==2){
			return 15;
		}else if(num==5 && num2==5 && num3==5){
			return 14;
		}else if(num==4 && num2==4 && num3==4){
			return 12;
		}else if((num==2 || num==4 || num==5) && (num2==2 || num2==4 || num2==5) && (num3==2 || num3==4 || num3==5)){
			return 7;
		}
		return 0;
	}
}
