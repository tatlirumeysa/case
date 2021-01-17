package RoverBasicsTest;

import org.junit.Assert;
import org.junit.Test;

import RoverBasics.Plateau;
import RoverBasics.Rover;


public class RoverTest {

    @Test
    public void isBoundsOutOfPlateau() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(6, 6, 1);

        //When
        rover.move();

        //then
        Assert.assertEquals(false, rover.checkPlateauBounds(plateau));
    }
    
    @Test
    public void isBoundsWithinPlateau() {
        //Given
    	Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(2, 2, 1);

        //When
        rover.move();

        //then
        Assert.assertEquals(true, rover.checkPlateauBounds(plateau));
    }
}
