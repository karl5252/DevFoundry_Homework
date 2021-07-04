package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {
    Coordinates coordinates = new Coordinates(0,0);
    @Test
    void coordinatesThrowsErrorWhenOneOfTheParametersIsLowerThanZero(){

        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1,1 ));
    }
    @Test
    void coordinatesThrowsErrorWhenOneOfTheParametersIsGreaterThanOneHundred(){

        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0,101 ));
    }
    @Test
    void copyThrowsErrorWhenOneOfTheParametersIsLowerThanZero(){
        assertThrows(IllegalArgumentException.class, () -> coordinates.copy(coordinates,0,-1 ));

    }
    @Test
    void copyThrowsErrorWhenOneOfTheParametersIsGreaterThanOneHundred(){
        assertThrows(IllegalArgumentException.class, () -> coordinates.copy(coordinates,0,110 ));

    }
    @Test
    void twoCoordinatesWithIdenticalParamsAreSameObject(){
        Coordinates coords1 = new Coordinates(2,5);
        Coordinates coords2 = new Coordinates(2,5);

        assertEquals(coords1,coords2);

    }

}