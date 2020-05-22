package controlador;

import java.util.Scanner;
import modelo.MongoAccess;

public class Main {
	static Scanner scanner;
	static MongoAccess data;
	static boolean menuLoop;

	public static void main(String[] args) {
		data = new MongoAccess();
		menuLoop = true;
		System.out.println("CRUD APP WITH MONGODB");
		scanner = new Scanner(System.in);
		while (menuLoop) {
			printMenu();
		}
		System.out.println("TERMINATED");
	}

	private static void printMenu() {
		System.out.println("CHOOSE OPTION:\n" + "1. Show all.\n" + "2. Search for title.\n" + "3. Add element.\n"
				+ "4. Update titles.\n" + "5. Close.");
		int input = scanner.nextInt();
		String value;
		String value2;
		scanner.nextLine();
		switch (input) {
		// Show all
		case 1:
			data.showAll();
			break;
		// Search for title
		case 2:
			System.out.println("Enter the title:");
			value = scanner.nextLine();
			data.searchForTitle(value);
			break;
		// Add element
		case 3:
			System.out.println("Enter the name:");
			value = scanner.nextLine();
			System.out.println("Enter the city:");
			value2 = scanner.nextLine();
			data.add(value, value2);
			break;
		// Update titles
		case 4:
			System.out.println("Enter the name:");
			value = scanner.nextLine();
			System.out.println("Enter the new title:");
			value2 = scanner.nextLine();
			data.updateTitles(value, value2);
			break;
		default:
			menuLoop = false;
			break;
		}
	}
}
