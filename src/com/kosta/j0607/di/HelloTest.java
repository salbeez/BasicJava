package com.kosta.j0607.di;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {
   public static void main(String[] args) {
	  GenericXmlApplicationContext ctx = 
        new GenericXmlApplicationContext("com/kosta/j0607/di/applicationContext.xml");
   
	  MessageBean msg = (MessageBean)ctx.getBean("msgBean");
	  
	   msg.sayHello();
	  
   }
}
