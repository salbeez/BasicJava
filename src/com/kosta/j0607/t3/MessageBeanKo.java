package com.kosta.j0607.t3;

public class MessageBeanKo implements MessageBean{

	public MessageBeanKo() {
	   System.out.println("MessageBeanKo생성자");
	}
	
	@Override
	public void sayHello(String name) {
	   System.out.println("안녕, "+ name);			
	}
   
}
