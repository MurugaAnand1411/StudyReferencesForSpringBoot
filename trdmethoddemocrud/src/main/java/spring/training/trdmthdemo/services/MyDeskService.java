package spring.training.trdmthdemo.services;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import spring.training.trdmthdemo.model.MyDesk;
import spring.training.trdmthdemo.repository.MyDeskRepo;

@Service
public class MyDeskService {

	private Scanner scanner = new Scanner(System.in);

	@Autowired
	private MyDeskRepo myDeskRepo;


	
	public void queryEntities() {
		
		try {
			// Get a scalar value.
			long count = myDeskRepo.getDeskCount();
			System.out.printf("Desk count: %d\n", count);
			
			// Get one record.
			long id = promptForId("Enter id of desk details to get: ");
			MyDesk my = myDeskRepo.getDeskDetail(id);
			System.out.printf("mydesk %d: %s\n", id, my);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void modifyEntities() {

		try {
			displayMydesk1("myDesk details: ", myDeskRepo);
			// Insert an employee.
			System.out.println("Going to add new Desk........");
			
			MyDesk newd = new MyDesk(-999, "Keyboard",1);
			myDeskRepo.insertNewDeatilOfMydesk(newd);
			displayMydesk1("All properties after insert new desk: ", myDeskRepo);

			// Update an employee.
			long id = promptForId("Enter id of assetname to update: ");
			myDeskRepo.updateOldDeatilsOfMydesk(id,"lighting keyboard");
			displayMydesk1("All properties after update: ", myDeskRepo);

			// Delete an employee.
			id = promptForId("(ASSETS leaving) Enter id of employee to delete: ");
			myDeskRepo.deleteEntireDeskProperties(id);
			displayMydesk1("All details of my desk after delete: ", myDeskRepo);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void displayMydesk1(String string, MyDeskRepo myDeskRepo2) {
		// TODO Auto-generated method stub
		
	}

	private long promptForId(String message) {
		System.out.printf("\n%s\n", message);
		return scanner.nextLong();
	}

//	private static void displayMydesk(String message, MyDeskRepo myDeskRepo2) {
//		List<MyDesk> myde = myDeskRepo2.getAllDetails();
//		System.out.printf("\n%s\n", message);
//		for (MyDesk my: myde) {
//			System.out.println(myde);
//		}
//	}

}
