package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmvilleTests {

    private Farm farm;
    private Animal animal;

    @Before
    public void setUp() {
        farm = new Farm("Gosho's farm", 10);
        animal = new Animal("Cat", 12);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullNameShouldBeThrowing() {
        new Farm(null, 12);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyNameShouldBeThrowing() {
        new Farm("   ", 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityLessThanZeroShouldBeThrowing() {
        new Farm("Toshko's farm", -6);
    }

    @Test
    public void testValidConstructor() {
        assertEquals(farm.getName(), "Gosho's farm");
        assertEquals(farm.getCapacity(), 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenIsFullShouldBeThrowing() {
        Farm farm1 = new Farm("Pesho's farm", 1);
        Animal animal1 = new Animal("Dog", 4);
        farm1.add(animal);
        farm1.add(animal1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenAnimalIsAlreadyInTheFarm() {
        farm.add(animal);
        farm.add(animal);
    }

    @Test
    public void testAddWithValidElements() {
        farm.add(animal);
        assertEquals(farm.getCount(), 1);
    }

    @Test
    public void testRemove() {
        farm.add(animal);
        assertTrue(farm.remove(animal.getType()));
        assertEquals(farm.getCount(), 0);
    }

    @Test
    public void testWhenIsFalse() {
        assertFalse(farm.remove(animal.getType()));
    }
}
