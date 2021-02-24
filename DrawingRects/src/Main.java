import java.util.Scanner;
/* Main.java - places a rectangle, that was created by the Rect.java class, onto a 20x20 grid */
public class Main {

	public static void main(String[] args) {
		
		/* Create 20x20 grid*/
		char [] [] grid = new char [20][20];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				grid[i][j] = '.';
			}
		}
		System.out.println();
		
		/* Prompt the user to enter the width of the rectangle */
		Scanner input = new Scanner(System.in);
		System.out.println("Enter rectangle width (1 - 5)? ");
		int entry = 0;
		boolean valid = false;
		/* Make sure the user's input is an integer and between 1 & 5*/
		while(!valid) {
			if(input.hasNextInt()) {
				entry = input.nextInt();
				if(entry <= 5 && entry >= 1) {
					valid = true;
				} else {
					System.out.println("Invalid Range.");
					System.out.println("Enter rectangle width (1 - 5)? ");
				}
			} else {
				input.next();
				System.out.println("Invalid Input.");
				System.out.println("Enter rectangle width (1 - 5)? ");
			}
		}
		
		/* Prompt the user to enter the height of the rectangle*/
		Scanner input2 = new Scanner(System.in);
		System.out.println("Enter rectangle height (1 - 5)? ");
		int entry2 = 0;
		boolean valid2 = false;
		/* Make sure the user's input is an integer and between 1 & 5*/
		while(!valid2) {
			if(input2.hasNextInt()) {
				entry2 = input2.nextInt();
				if(entry2 <= 5 && entry2 >= 1) {
					valid2 = true;
				} else {
					System.out.println("Invalid Range.");
					System.out.println("Enter rectangle height (1 - 5)? ");
				}
			} else {
				input2.next();
				System.out.println("Invalid Input.");
				System.out.println("Enter rectangle width (1 - 5)? ");
			}
		}
		
		int w = entry; //user's width
		int h = entry2; //user's height
		
		Rect r1 = new Rect(w, h); //create rectangle with provided height & width using the Rect.java class
		
		placeRect(grid, r1); //place newly created rectangle on the grid
		
		displayGrid(grid); //display the grid to the user
		
		int choice = menu(); //call the menu and initialize it as a variable
		
		while (choice != 5) { //until the user quits.....
			if (choice == 1) { //if the user chooses to move the rectangle up...
				if(r1.getY() == 0) { // make sure the move will not take the rectangle out of bounds
					System.out.println("\nYou can't go that way.\n"); //if it will go out of bounds, user will be notified and prompted to try again
				} else { // otherwise...
					r1.translate(0, -1); // coordinates for the upper left corner of the rectangle are moved up one row
					resetGrid(grid); // reset grid
					placeRect(grid, r1); //replace the rectangle
					displayGrid(grid); //display the grid to the user
				}
			}
			else if (choice == 2) { //if the user chooses to move the rectangle down...
				if (r1.getY() == (20 - h)) { // make sure the move will not take the rectangle out of bounds
					System.out.println("\nYou can't go that way.\n");
				} else {
					r1.translate(0, 1); // coordinates for the upper left corner of the rectangle are moved down one row
					resetGrid(grid);
					placeRect(grid, r1);
					displayGrid(grid);
				}
			}
			else if (choice == 3) { //if the user chooses to move the rectangle left...
				if (r1.getX() == 0) { // make sure the move will not take the rectangle out of bounds
					System.out.println("\nYou can't go that way.\n");
				} else {
					r1.translate(-1, 0); // coordinates for the upper left corner of the rectangle are moved to the left one column
					resetGrid(grid);
					placeRect(grid, r1);
				}
			}
			else if (choice == 4) {//if the user chooses to move the rectangle right...
				if (r1.getX() == (20 - w)) { // make sure the move will not take the rectangle out of bounds
					System.out.println("\nYou can't go that way.\n");
				} else {
					r1.translate(1, 0); // coordinates for the upper left corner of the rectangle are moved to the right one column
					resetGrid(grid);
					resetGrid(grid);
					placeRect(grid, r1);
					displayGrid(grid);
				}
			}
			choice = menu(); //prompt user to choose from menu again
		}
	}
	
	 /* Display the grid to the user
	  * @param char 2D array */
	public static void displayGrid(char [][] g) {
		
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				System.out.print(g[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/* Place the rectangle on the grid
	 * @param char 2D array
	 * @param Rect r - the rectangle created using the Rect.java class*/
	public static void placeRect(char [][] g, Rect r ) {
		for (int i = 0; i < r.getWidth(); i++) {
			for (int j = 0; j < r.getHeight(); j++) {
				g[r.getY() + j][r.getX() + i] = '*'; //y coordinate is moving row to row & x coordinate is moving column to column
			}
		}
	}
	
	/* Resets the grid with no rectangle on it
	 * @param char 2D array*/
	public static void resetGrid(char [][] g) {
		for(int i = 0; i < g.length; i++) {
			for(int j = 0; j < g[0].length; j++) {
				g[i][j] = '.';
			}
		}
		System.out.println();
	}
	
	/* Menu with 5 choices for the user to select from
	 * @return user's choice from the options provided */
	public static int menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("1. Up\n2. Down\n3. Left\n4. Right\n5. Quit");
		int entry = 0;
		boolean valid = false;
		while(!valid) { //make sure the user's input is an integer & between 1 - 5
			if (input.hasNextInt()) {
				entry = input.nextInt();
				if(entry >= 1 && entry <= 5) {
					valid = true;
				} else {
					System.out.println("Invalid Range.");
					System.out.println("1. Up\n2. Down\n3. Left\n4. Right\n5. Quit");
				}
			}else {
				input.next();
				System.out.println("Invalid Input.");
				System.out.println("1. Up\n2. Down\n3. Left\n4. Right\n5. Quit");
			}
		}
		return entry;
	}


}
