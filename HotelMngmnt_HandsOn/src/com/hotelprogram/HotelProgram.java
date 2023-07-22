package com.hotelprogram;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class HotelProgram {
	
	private static boolean MainMenu = true;
	private static boolean SubMenu = true;
	

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner (System.in);
		Room[] myHotel = new Room[10];
		myHotel[0] =new Room();
		myHotel[1] =new Room();
		myHotel[2] =new Room();
		myHotel[3] =new Room();
		myHotel[4] =new Room();
		myHotel[5] =new Room();
		myHotel[6] =new Room();
		myHotel[7] =new Room();
		myHotel[8] =new Room();
		myHotel[9] =new Room();
		int roomNum = 0;
		initialise(myHotel);
		while (MainMenu){
			while (SubMenu){
				System.out.println("***********************************************");
				System.out.println(
						"Hello and Welcome to our Hotel Program\nPlease keep hands and feet in the vehicle at all time.");
				System.out.println("***********************************************");
				System.out.println("Please select one of the options");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("A: Book A New Room.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("E: Display Empty Rooms.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("V: View all Rooms.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("D: Delete customer from room.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("F: Find room from customer name.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("S: Store program data into file.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("L: Load program data into file.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("O: View rooms Ordered alphabetically by name.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("**********************************************");
				String Selection = input.next();
				Selection = Selection.toUpperCase();
				switch (Selection) {
					case "A":
						BookARoom(myHotel, roomNum);
						break;
					case "E":
						CheckIfEmpty(myHotel);
						break;
					case "V":
						ViewAllRooms(myHotel);
						break;
					case "D":
						DeleteCustomerFromRoom(myHotel, roomNum);
						break;
					case "F":
						FindRoomFromCustomerName(myHotel);
						break;
					case "S":
						StoreProgramDataInToFile(myHotel);
						break;
					case "L":
						LoadProgramDataFromFile(myHotel);
						break;
					case "O":
						ViewRoomsOrderAlphabeticallyByName(myHotel);
						break;
					default:
						System.out.println("Invalid Selection");
						break;
				}
				System.out.println("*******************************************************************");
				System.out.println("Would you like to select another\n1) Yes\n2) No");
				System.out.println("*******************************************************************");
				if (input.nextInt() == 1) {
					SubMenu = true;
				} else {
					SubMenu = false;
				}
			}
			
		SubMenu = true;
		System.out.println("*******************************************************************");
		System.out.println("Would you like to continue with the program\n1) Yes\n2) No");
		System.out.println("*******************************************************************");

		if (input.nextInt() == 1) {
			MainMenu = true;
		} else {
			System.out.println("");
			System.exit(0);
		}

	}

}

private static void initialise(Room[] myHotel) {
	for (int x = 0; x< myHotel.length; x++) {
		myHotel[x].setName("Nobody");
		myHotel[x].setEmail("Null");
		myHotel[x].setAddress("Null");
		myHotel[x].setPhoneNumber(0);
		
	}
}

private static void  CheckIfEmpty(Room[] myHotel) {
	for (int x = 0; x < myHotel.length; x++) {
		if(myHotel[x].getName().equals("Nobody")) {
			System.out.println("Room" + (x + 1) + "is empty");
		}
	}
}

private static void BookARoom(Room[] myHotel, int roomNum) {
    String roomName, roomEmail, roomAddress;
    long roomPhoneNumber;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter room number (1-10):");
	roomNum = input.nextInt() - 1;
    System.out.println("Enter name for room " + (roomNum + 1) + " :");
    roomName = input.next();
    System.out.println("Enter emailId for room " + (roomNum + 1) + " :");
    roomEmail = input.next();
    System.out.println("Enter Address for room " + (roomNum + 1) + " :");
    roomAddress= input.next();
    System.out.println("Enter Phonenumber for room " + (roomNum + 1) + " :");
    roomPhoneNumber = input.nextLong();
    myHotel[roomNum].setName(roomName);
    myHotel[roomNum].setEmail(roomEmail);
    myHotel[roomNum].setAddress(roomAddress);
    myHotel[roomNum].setPhoneNumber(roomPhoneNumber);
    System.out.println("Room is Booked");
}

private static void ViewAllRooms(Room[] myHotel) {
    for (int x = 0; x < myHotel.length; x++) {
        System.out.println("Room " + (x + 1) + " occupied by " + myHotel[x].getName());
    }
}

private static void DeleteCustomerFromRoom(Room[] myHotel, int roomNum) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter room number to delete(1-10):");
    roomNum = input.nextInt() - 1;
    myHotel[roomNum].setName("Nobody");
    System.out.println("Entry Deleted :)");
}

private static void FindRoomFromCustomerName(Room[] myHotel) {
    Scanner input = new Scanner(System.in);
    String roomName;
    System.out.println("Enter name to Search for:");
    roomName = input.nextLine();
    int x;
    boolean Checker = true;
    for (x = 0; x < myHotel.length; x++) {
        if (roomName.equals(myHotel[x].getName())) {
            System.out.println("The Account That Matches That name is Account number " + x);
            Checker = true;
        }
    }
    if (Checker == false) {
        System.out.println("There are no Rooms Booked with that name\n(make sure you've used the correct CAP's)");
    }
}

private static void StoreProgramDataInToFile(Room[] myHotel) throws IOException {
    try (PrintWriter out = new PrintWriter(new FileWriter("C:/Users/2212154/Documents/Java_HandsON_Hotel/HotelManagement.txt"))) {
        int x;
        for (x = 0; x < myHotel.length; x++) {
            System.out.println("Name and Room number is: " + myHotel[x].getName() + "at: " + x);
        }

    }
    System.out.println("All Room Names have been Saved.");
}

private static void LoadProgramDataFromFile(Room[] myHotel) throws IOException {
    FileInputStream fs = new FileInputStream("C:/Users/2212154/Documents/Java_HandsON_Hotel/HotelManagement.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fs));
    for (int i = 0; i < myHotel.length; i++) {
        myHotel[i].setName(br.readLine());
    }
    System.out.println("File is Loaded");
}

private static void ViewRoomsOrderAlphabeticallyByName(Room[] myHotel) {
    String[] myStrArray = new String[myHotel.length];
    for (int i = 0; i < myHotel.length; i++) {
        myStrArray[i] = myHotel[i].getName();
    }

    Arrays.sort(myStrArray);
    for (int a = 0; a < myStrArray.length; a++) {
        System.out.println(myStrArray[a]);
    }

}

public static class Room {

    private String mainName,mainEmail,mainAddress;
    private long mainPhoneNumber;
    int guestsInRoom;

    public Room() {
        mainName = "k";

    }

    public void setName(String aName) {
        mainName = aName;
    }

    public String getName() {
        return mainName;
    }
    public void setEmail(String aEmail) {
        mainEmail = aEmail;
    }

    public String getEmail() {
        return mainEmail;
    }
    public void setAddress(String aAddress) {
        mainAddress = aAddress;
    }

    public String getAddress() {
        return mainAddress;
    }
    public void setPhoneNumber(long aPhoneNumber) {
        mainPhoneNumber = aPhoneNumber;
    }

    public long getPhoneNumber() {
        return mainPhoneNumber;
    }
    
}
}