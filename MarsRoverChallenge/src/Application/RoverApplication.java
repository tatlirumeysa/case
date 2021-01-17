package Application;

import java.util.Scanner;

import RoverBasics.Plateau;
import RoverBasics.Rover;

public class RoverApplication {
	public static int facing = 1;
	public static void validateDirection(String direction) {
		if( direction.equals("N")) {
			facing = 1;
		}else if(direction.equals("E")) {
			facing = 2;
		}else if(direction.equals("S")) {
			facing = 3;
		}else if(direction.equals("W")) {
			facing = 4;
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Mars Rover console application!");
		System.out.print("Enter upper right coordinates of the plateau in the form x y :");
		String numbers[] = scanner.nextLine().split(" ");
        	int plateauX = Integer.parseInt(numbers[0]);
        	int plateauY = Integer.parseInt(numbers[1]);	
		System.out.println("Plateau is being created..");
		Plateau p = new Plateau(plateauX,plateauY);
		//for roverA
		System.out.print("Enter drop information for roverA in the form x y h:");
		String dropInfo[] = scanner.nextLine().split(" "); // 1 2 N
		validateDirection(dropInfo[2]);
		Rover roverA = new Rover(Integer.parseInt(dropInfo[0]), Integer.parseInt(dropInfo[1]),facing);
		System.out.print("Enter instructions for roverA in the form LMRMMMLMM :");
		String instructions = scanner.nextLine(); //LMLMLMLMM
		roverA.getInstruction(instructions);
		if(roverA.checkPlateauBounds(p)) {
			roverA.getLocation(); // prints 1 3 N
		} else {
			System.out.println("ROVER IS OUT OF PLATEAU IN SPECIFIED BOUNDS! SYSTEM ERROR!");
		}
		
		//for roverB
		System.out.print("Enter drop information for roverB in the form x y h:");
		String dropInfo2[] = scanner.nextLine().split(" "); // 3 3 E
		validateDirection(dropInfo2[2]);
		Rover roverB = new Rover(Integer.parseInt(dropInfo2[0]), Integer.parseInt(dropInfo2[1]),facing);
		System.out.print("Enter instructions for roverB in the form MMRMMRMRRM :");
		String instructions2 = scanner.nextLine(); //MMRMMRMRRM
		roverB.getInstruction(instructions2);
		if(roverB.checkPlateauBounds(p)) {
			roverB.getLocation(); // prints 5 1 E
		} else {
			System.out.println("ROVER IS OUT OF PLATEAU IN SPECIFIED BOUNDS! SYSTEM ERROR!");
		}
		
		System.out.println("END OF APPLICATION.");
		System.exit(1);
//		//scanner.close();
	}
}
