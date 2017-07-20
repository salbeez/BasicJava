package com.kosta.j0607.di;

public class MessageBeanImpl implements MessageBean {
    
	private String greeting;
    private String name;
    private FileOutput fo;
    
    public MessageBeanImpl() {
	  System.out.println("기본 생성자!!");
    }
    
   /* public void setFo(FileOutput fo){
    	this.fo = fo;
    }*/
    
    public MessageBeanImpl(String greeting, FileOutput fo) {
    	System.out.println("오버로딩 생성자!!");
    	this.greeting = greeting;
    	this.fo = fo;
    }
    
    public void setName(String name){
    	this.name=name;
    }
    
	
	@Override
	public void sayHello() {
	    String str = greeting + ", "+ name+"!!";
	    System.out.println(str);//콘솔 출력
	    fo.output(str);//파일 출력
	}

}
