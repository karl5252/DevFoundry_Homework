package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CargoTest {
    @Test
    void twoCargoWithSameParametersShouldBeEqual(){
        Cargo cargo1 = new Cargo("evagreen", 12);
        Cargo cargo2 = new Cargo("evagreen", 12);

        assertEquals(cargo1,cargo2);
    }
}
