package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTest {

    /*
        Unit(Coordinates startCoordinates, int maxFuel, int maxCargoWeight) {

        this.coordinates = startCoordinates;
        this.maxFuel = maxFuel;
        this.fuel = maxFuel;
        this.maxCargoWeight = maxCargoWeight;
        this.currentCargoWeight = 0;
        this.cargo = new ArrayList<>();
        */
    Unit unit;
    int maxTestFuel = 10;
    private Coordinates startingCoords = new Coordinates(5,5);

    //Unit loadUnit = new Unit(startingCoords,0,10);


    @BeforeEach
            void setupUnit(){
        unit = new Unit(startingCoords, maxTestFuel,0)
        ;
    }



    //private Cargo cargoItem1 = new Cargo("test1", 2);

    @Test
    void newUnitHasFuelEqualToGivenValue(){

        assertEquals(unit.getFuel(),2);

    }
    @Test
    void newUnitHasEmptyCargoSpace(){
        assertEquals(unit.getLoad(),0);
    }
    @Test
    void ifMovedWithinFuelCapacityFuelIsBeingConsumed(){
        //        if (this.fuel - (x + y) < 0) {
        // 10 - 10 = 0
        // 10 - 11 = -1
        //10 - 7 = 3
        unit.move(5,2);
        assertThat(unit.getFuel(),greaterThan(2));
        assertThat(unit.getFuel(),lessThan(10));

    }
    @Test
    void ifMovedOutOfFuelCapacityThrowsISException(){
        //        if (this.fuel - (x + y) < 0) {
        // 10 - 10 = 0
        // 10 - 11 = -1
        //10 - 7 = 3

        assertThrows(IllegalStateException.class ,() -> unit.move(20,20) );
    }
    @Test
    void ifUnitMovedOutOfBoundsThrowsIAException(){
        Unit unit2 = new Unit (startingCoords,200,0);
        assertThrows(IllegalArgumentException.class, () -> unit2.move(100,20));
    }
    @RepeatedTest(10)
    void ifUnitIsTankedUpFuelLevelRaisesToTheLimitOfMaxFuel(){
        unit.move(5,2);
        int newFuelLevel = unit.getFuel();
        unit.tankUp();
        assertThat(unit.getFuel(), greaterThan(newFuelLevel));
        assertThat(unit.getFuel(), lessThanOrEqualTo(maxTestFuel));

    }
    /*private static Stream<Arguments> createCargoItems(){
        return Stream.of(
                Arguments.of(),
                Arguments.of()
        );
    }*/

    /*ArrayList<Cargo> returnCargoUnits() {
        for (int i =0; i< 100; i ++ ){
            Cargo cargo = new Cargo();
    }*/


    @ExtendWith(ISExceptionExtension.class)
    @ParameterizedTest
    @ValueSource(ints = {1,3,5,8,10,11,15})
    void calculateIfCargoOverExceedsMaxCargo(int maxCargo){
        Unit testUnit = new Unit(startingCoords,0,10);


            // assertThat(price,lessThan(10));
            if(maxCargo > 10){
                throw new IllegalStateException();
            }
            assertThat(testUnit.getLoad(),lessThan(10));

        }

    }





