package package1;

import java.util.Scanner;
import java.util.ArrayList;
// Randomizer: (Math.random() * (max - min)) + min + 1 // + 1 kalo butuh saja

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<Customer> custList = new ArrayList<>();
	
	public final String genLounge() {
		String lounge = "LO"; int temp = 0;
		for(int i=0;i<3;i++) {
			temp = (int) (Math.random() * (3-1)) + 1;
			lounge += temp;
		}
		return lounge;
	}
	
	public final String genLCID(String status) {
		String ID; int temp=0;
		ID = status.equals("VIP") ? "V" : "R";
		for(int i=0;i<5;i++) {
			temp = (int) (Math.random() * (9-1)) + 1;
			ID += temp;
		}
		return ID;
	}
	
	public final boolean phoneValidator(String phoneNum) {
	    for(int i=0;i<phoneNum.length();i++) {
	    	Character temp = phoneNum.charAt(i);
	    	if(!Character.isDigit(temp)) return false;
	    }
	    return true;
	}
	
	public final void addNewMember() {
		String name = "", gender = "", email = "", phoneNum = "", status = ""; int points = 0;
		String LC_ID = "", lounge = ""; int queue = 0;
		
		do {
			System.out.print("Name: ");
			name = scan.nextLine(); name.strip();
		} while(name.length()<5||name.length()>12);
		
		do {
			System.out.print("Gender: ");
			gender = scan.nextLine(); gender.strip();
		} while(!gender.equals("Male") && !gender.equals("Female"));
		
		do {
			System.out.print("Phone Number: ");
			phoneNum = scan.nextLine(); phoneNum.strip();
		} while(phoneNum.length()!=12 || phoneValidator(phoneNum)==false);
		
		do {
			System.out.print("Status: ");
			status = scan.nextLine(); status.strip();
		} while(!status.equals("VIP") && !status.equals("Regular"));
		
		LC_ID = genLCID(status);
		
		if(status.equals("VIP")) {
			do {
				System.out.print("Email: ");
				email = scan.nextLine(); email.strip();
			} while(!email.endsWith("@gmail.com"));
			
			lounge = genLounge();
			
			custList.add(new VIP(points, name, gender, phoneNum, status, LC_ID, email, lounge));
		} else {
			queue = (int) (Math.random() * (3-1)) + 1;
			
			custList.add(new Regular(points, name, gender, phoneNum, status, LC_ID, queue));
		}
		
		System.out.println("\na new customer has been added...");

		pressEnterToContinue();
	}
	
	public final void pressEnterToContinue() {
		System.out.println("\nPress Enter To Continue..."); scan.nextLine();
	}
	
	public final void printMenu() {
		System.out.println("jtheatre");
		System.out.println("1. add new member");
		System.out.println("2. view all member");
		System.out.println("3. watch a movie");
		System.out.println("4. cancel membership");
		System.out.println("5. exit");
		System.out.print(">> ");
	}
	
	public final void viewAllMember(ArrayList<Customer> custList) {
		if(custList.isEmpty()) {
			System.out.println("\nThere are no member currently..."); pressEnterToContinue(); return;
		} else {
			// no , name, gender, phoneNum, status, LC_ID, points, email, lounge, queue
			Customer curr;
			System.out.printf("| %-4s | %-16s | %-10s | %-20s | %-10s | %-16s | %-15s | %-30s | %-15s | %-10s |\n",
			                  "No.","Name","Gender","Phone Number","Status","Loyalty Card ID","Points","Email","Lounge","Queue");
			for(int i=0;i<custList.size();i++) {
				curr = custList.get(i);
				if(curr instanceof VIP) {
					System.out.printf("| %-4d | %-16s | %-10s | %-20s | %-10s | %-16s | %-15d | %-30s | %-15s | %-10s |\n",
					                  i+1,curr.getName(),curr.getGender(),curr.getPhoneNum(),curr.getStatus(),curr.getLC_ID(),curr.getPoints(),
					                  ((VIP) curr).getEmail(),((VIP) curr).getLounge(),"-");
				}
				else {
					System.out.printf("| %-4d | %-16s | %-10s | %-20s | %-10s | %-16s | %-15d | %-30s | %-15s | %-10d |\n",
					                  i+1,curr.getName(),curr.getGender(),curr.getPhoneNum(),curr.getStatus(),curr.getLC_ID(),curr.getPoints(),
					                  "-","-",((Regular) curr).getQueue());
				}
			}
			return;
		}
	}
	
	public final void watchAMovie() {
		String ID;
		System.out.println(" ");
		viewAllMember(custList);
		
		System.out.print("Input Loyalty Card ID: ");  ID = scan.nextLine();
		
		for (Customer c : custList) {
			if(c.getLC_ID().equals(ID)) {
				c.setPoints(c.genPoints());
				System.out.println("\nThanks For Watching..."); return;
			}
		}
		
		System.out.println("\nID Not Found...");
	}
	
	public final void cancelMembership() {
		String ID;
		System.out.println(" ");
		viewAllMember(custList);
		
		System.out.print("Input Loyalty Card ID: ");  ID = scan.nextLine();
		
		for (Customer c : custList) {
			if(c.getLC_ID().equals(ID)) {
				custList.remove(c);
				System.out.println("\nWe're Sad to See You Go..."); return;
			}
		}
		
		System.out.println("\nID Not Found...");
	}
	
   	public Main() {
		int menu = 0;
		
		do {
			printMenu();
			menu = scan.nextInt(); scan.nextLine();
			
			switch(menu) {
			case 1: {
				addNewMember();
				break;
			}
			case 2: {
				viewAllMember(custList); pressEnterToContinue();
				break;
			}
			case 3: {
				watchAMovie(); pressEnterToContinue();
				break;
			}
			case 4: {
				cancelMembership(); pressEnterToContinue();
				break;
			}
			case 5: {
				System.out.println("\nBye Bye..."); pressEnterToContinue();
				break;
			}
			default: {
				System.out.println("\nInvalid Menu Input..."); pressEnterToContinue();
				break;
			}
			}
			
		} while(menu!=5);
		scan.close();
	}

	public static void main(String[] args) {
		new Main();
	}

}

//JtheateR
//
//class
//-Customer(abstract // nama, gender, noHP, status, LoyaltyCardID, Points)
//-VIP(conc extends customer // super, email, Lounge)
//-Regular(conc extends customer // super, queue)
//-Override how to get point nya
//
//feature
//-Add new member
//-View all member
//-Watch a movie (Points ny bakal nambah kalo nonton)
//-Cancel membership (delete user)
//-Exit
//
//validasi
//-nama (length: min 5 char max 12 char)
//-gender (equals : "Male" atau "Female")
//-email (endswith: @gmail.com)
//-noHP (length: harus 12 angka, isDigit: harus smua nya angka)
//-Status (equals: "VIP" atau "Regular")
//
//action
//-Random 6 angka (buat loyaltyCardId)
//-Random queue [0-3]
//-Random lounge ("LO"+[0-3][0-3][0-3])
//-View all attribute, add, delete
//-Show empty message
//-kalkulasi Points (Override)
// VIP = (random dari 0 - length) * 2
// regular = (random dari 0 - length)