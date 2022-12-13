package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="Student") 
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId = -1;
	
	private String stuName;
	private String region;
	
	@Column(name="total")
	private double total;
	
	public Student() {
		// Empty no-arg constructor.
	}
	
	public Student(long studentId, double total,String name,String region) {
		this.studentId = studentId;
		this.stuName = name;
		this.total = total;
		this.region = region;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return stuName;
	}

	public void setName(String name) {
		this.stuName = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Student) {
			Student otherStud = (Student)other;
			result = (this.studentId == otherStud.studentId);
		}
		return result;
	}
	
	@Override 
	public int hashCode() {
		return (int)studentId;
	}

	@Override
	public String toString() {
		return String.format("Student [StudentId=%s, Name=%s, Region=%s, TotalMarks=%s]", studentId, stuName, region, total);
	}
}
