package com.pinjingjing.demo.result;

public class ResponseResult {
	
	private int i;
	
	private String string;
	
	public ResponseResult(int i, String string) {
		super();
		this.i = i;
		this.string = string;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "ResponseResult [i=" + i + ", string=" + string + "]";
	}
	
	
}
