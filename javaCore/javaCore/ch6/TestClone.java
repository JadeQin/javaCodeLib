package javaCore.ch6;

import java.util.Date;

public class TestClone implements Cloneable {

	private int num;
	private String name;
	private Date date;
	private A a;

	public TestClone(int num, String name, Date date) {
		this.num = num;
		this.name = name;
		this.date = date;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public TestClone clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (TestClone) super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		TestClone clone = new TestClone(1, "aaa", new Date(10, 1, 1));
		clone.setA(new A("aaa"));
		TestClone t = clone.clone();
		clone.setA(new A("bbb"));
		clone.setDate(new Date(12, 2, 2));
		clone.setName("test");
		clone.setNum(2);
		System.out.println(t.getName());
		System.out.println(t.getNum());
		System.out.println(t.getDate());
		System.out.println(t.getA().getName());
	}
}

class A {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public A(String name) {
		this.name = name;
	}

}
