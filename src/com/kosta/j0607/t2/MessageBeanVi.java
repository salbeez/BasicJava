package com.kosta.j0607.t2;

public class MessageBeanVi implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("신짜오, "+name);
	}

}
