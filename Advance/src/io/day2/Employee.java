//6/15[3]
package io.day2;
import java.io.*;
/**
 * ��ü�� ��Ʈ������ �������ų�, ��Ʈ��ũ�� �����Ϸ���
 * �ݵ�� java.io.Serializable �������̽��� ��ӹ޾ƾ� �Ѵ�.
 * Serializable �������̽����� �߻�޼ҵ�� ����  �ܼ���
 * ��ü�� �Ϸķ� �����ؼ� ��Ʈ��ũ�� ������ �غ� �Ǿ��ٴ� 
 * ǥ�ø� ���ִ� ����� �Ѵ�.
 * */

public class Employee implements Serializable {//����ȭ�� �ؾ��Ѵ�.(implements Serializable)

				private String name;
				private int deptno;
				private String job;
	transient 	private int sal;//transient�� ���� �����ʹ� ����ȭ�� ����Ʈ������ ������(������ �Ƚ�Ŵ)
		
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

