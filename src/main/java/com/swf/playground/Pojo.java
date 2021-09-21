package com.swf.playground;

public class Pojo {

	private String one;

	private String two;

	@Override
	public String toString() {
		return "Pojo{" + "one='" + one + '\'' + ", two='" + two + '\'' + '}';
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

}
