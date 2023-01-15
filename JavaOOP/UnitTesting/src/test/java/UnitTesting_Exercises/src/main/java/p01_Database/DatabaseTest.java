package UnitTesting_Exercises.src.main.java.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private Integer[] numbers = {1, 2, 3, 4};

   @Before
   public void setUp() throws OperationNotSupportedException {
       database = new Database(numbers);
    }
    @Test
    public void testConstructorCreatesValidDB() {
        Integer[] dbElements = database.getElements();
        Assert.assertArrayEquals(numbers,dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCapacityShouldBeThrowingWhenCapacityIsMoreThan17() throws OperationNotSupportedException {
        Integer[] correctArray = new Integer[17];
        new Database(correctArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCapacityShouldBeThrowingWhenThereIsNoElement() throws OperationNotSupportedException {
        Integer[] emptyArr = new Integer[0];
        new Database(emptyArr);
    }

    @Test
    public void testShouldAddAnElementAtTheNextFreeCell() throws OperationNotSupportedException {
        database.add(5);
        Integer[] arr = database.getElements();
        Assert.assertEquals(arr[arr.length - 1], Integer.valueOf(5));
        Assert.assertEquals(arr.length, numbers.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldBeThrowingWhenElementIsNull() throws OperationNotSupportedException {
       database.add(null);
    }

    @Test
    public void testRemoveShouldElementAtTheLastIndex() throws OperationNotSupportedException {
       database.remove();
       Integer[] elements = database.getElements();
       Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(3));
       Assert.assertEquals(elements.length, numbers.length - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldBeThrowingWhenItIsRemovingFromAEmptyDB() throws OperationNotSupportedException {
       //Integer[] emptyArr = new Integer[];
       Database emptyDB = new Database();
       emptyDB.remove();
    }

}