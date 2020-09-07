import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Player object = new Player();
	static PlayGround_Owner object2 = new PlayGround_Owner();
	static Playground object3 = new Playground();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}

	private static void start() {

		// TODO Auto-generated method stub

		System.out.println("Welcome to GoFo system.");
		System.out.println("1. Register.");
		System.out.println("2. Login.");
		System.out.println("3. Add playground.");
		System.out.println("4. Book playground.");
		System.out.println("5. Display playgorunds.");
		System.out.println("6. Create team.");

		int choise = scanner.nextInt();
		choosed(choise);
	}

	private static void choosed(int choise) {

		// TODO Auto-generated method stub

		switch (choise) {
		case 1:
			// register
			System.out.println("For player enter 1, for owner enter 2");
			int rp = scanner.nextInt();
			if (rp == 1) {
				object.Register();

			} else if (rp == 2) {
				object2.Register();
			} else {
				start();
			}
			break;

		case 2:
			// login
			System.out.println("For player enter 1, for owner enter 2");
			int lp = scanner.nextInt();
			if (lp == 1) {
				object.login();
			} else if (lp == 2) {
				object2.login();
			} else {
				start();
			}

			break;

		case 3:
			// add playground
			object3.addPlayGround();
			break;

		case 4:
			// booking
			object3.Read_From_File();
			object.Booking();
			break;

		case 5:
			// display playgrounds
			object3.Read_From_File();
			object3.print();
			break;

		case 6:
			// create team
			object.Creating_Team();
			object.print_Team();
			break;
		}
	}

}
