package RoverBasics;


public class Rover {
	public static final int N = 1;
	public static final int E = 2;
	public static final int S = 3;
	public static final int W = 4;
	
	public int x = 0;
	public int y = 0;
	public int heading = N;
	
	public Rover(int x, int y, int heading) {
		this.x = x;
		this.y = y;
		this.heading = heading;
	}

	// main objective is getting inst. from application and directing them to specified actions 
	public void getInstruction(String commands) { 
		for (char cm: commands.toCharArray()) {
			if (cm == 'L') {
				turnLeft();
			} else if (cm == 'R') {
				turnRight();
			} else if (cm == 'M') {
				move();
			}else {
				System.out.println("SYSTEM INSTRUCTION ERROR!");
			}
		}
	}
	
	// one of the specified actions for moving straight in 
	public void move() {
		if (heading == N) {
			this.y++;
		} else if (heading == E) {
			this.x++;
		} else if (heading == S) {
			this.y--;
		} else if (heading == W) {
			this.x--;
		}
	}
	//for ex if head of rover is looking to north it means we changed our direction to west
	public void turnLeft() {
		if (heading - 1 < N) {
			heading = W;
		}else {
			heading = heading - 1;
		}
	}
	//same logic also here
	public void turnRight() {
		if (heading + 1 > W) {
			heading = N;
		}else {
			heading = heading + 1;
		}
	}
	//checking if rover out of plateu bounds
	public boolean checkPlateauBounds(Plateau plateau) {
		return (this.x >= 0 && this.x <= plateau.x && this.y >= 0 && this.y <= plateau.y) ? true : false;	
	}
	//printing results in the end
	public void getLocation() {
		char direction = 'N';
		if (heading == 1) {
			direction = 'N';
		} else if (heading == 2) {
			direction = 'E';
		} else if (heading == 3) {
			direction = 'S';
		} else if (heading == 4) {
			direction = 'W';
		}
		System.out.println("Last location of rover: "+ x + " " + y + " " + direction);
	}
}