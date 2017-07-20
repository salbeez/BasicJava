package com.kosta.j0607.t3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kosta.j0607.t3.MessageBean;

public class HelloTest {
   public static void main(String[] args) {
	  ApplicationContext ctx = 
			  new GenericXmlApplicationContext("com/kosta/j0607/t3/applicationContext.xml");
	  
	  //XML문서에 정의된 Bean 가져오기!!
	  MessageBean msg = (MessageBean) ctx.getBean("msgBean");
	  //MessageBean msg = ctx.getBean("msgBean", MessageBean.class);
	  
	  msg.sayHello("길라임");
   }
}





