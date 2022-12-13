package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;

	public void useStandardRepoMethods() {

		// Insert an employee.
		Student newstudent = new Student(-1, 50, "Sam", "Italy");
		newstudent = repo.save(newstudent);
		System.out.printf("Inserted Student, id %d\n", newstudent.getStudentId());

		// Get count of all employees.
		System.out.printf("There are now %d Student\n", repo.count());

		// Get all employees.
		displaystudents("All students: ", repo.findAll());

	}

	public void useCustomQueryMethods() {

		// Get all employees by region.
		displaystudents("All employees in London: ", repo.findByRegion("London"));

		System.out.println();

		// Get employees by salary range.
		List<Student> stud = repo.findInTotalRange(60, 90);
		displaystudents("Student getting mark range from 60 to 90: ", stud);

		List<Student> stud1 = repo.findByRegionOrTotalGreaterThanEqual("Belfast", 78);
		displaystudents("Students in Region and Total greater than or equalto ", stud1);

		// Get a page of employees.
		Pageable pageable = PageRequest.of(0, 3, Direction.DESC, "total");
		Page<Student> page = repo.findByTotalBetween(0,110,pageable);
		displaystudents("Page 1 of employees from 40 to 60: ", page.getContent());

		// System.out.println("No of pages is " + page.getTotalPages() + " get Total
		// Elements " + page.getTotalElements()
		// + " current page " + page.getNumber());

		pageable = PageRequest.of(1, 3, Direction.DESC, "total");
		page = repo.findByTotalBetween(0,110,pageable);
		displaystudents("Page 2 of employees 60 to 80: ", page.getContent());

		pageable = PageRequest.of(2, 3, Direction.DESC, "total");
		page = repo.findByTotalBetween(0,110,pageable);
		displaystudents("Page 3 of employees 80 to 110: ", page.getContent());

		System.out.println();
	}

	private void displaystudents(String message, Iterable<Student> students) {
		System.out.printf("\n%s\n", message);
		for (Student stu : students) {
			System.out.println(stu);
		}
	}
}
