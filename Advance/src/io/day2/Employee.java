//6/15[3]
package io.day2;
import java.io.*;
/**
 * 객체를 스트림으로 내보내거나, 네트워크로 전송하려면
 * 반드시 java.io.Serializable 인터페이스를 상속받아야 한다.
 * Serializable 인터페이스에는 추상메소드는 없고  단순히
 * 객체를 일렬로 나열해서 네트워크로 전송할 준비가 되었다는 
 * 표시를 해주는 기능을 한다.
 * */

public class Employee implements Serializable {//직렬화를 해야한다.(implements Serializable)

				private String name;
				private int deptno;
				private String job;
	transient 	private int sal;//transient가 붙은 데이터는 직렬화시 디폴트값으로 저장함(노출을 안시킴)
		
	public Employee(String name, int deptno, String job, int sal) {
		super();
		this.name = name;
		this.deptno = deptno;
		this.job = job;
		this.sal = sal;
	}

	public void print() {
		System.out.println("----Record for "+name+"-------------");
		System.out.println("Dept NO: "+deptno);
		System.out.println("Job: "+job);
		System.out.println("Salary: "+sal);
	}
	

}///////////////////////////////////////

