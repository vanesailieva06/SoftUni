package UnitTesting_Exercises.src.main.java.p02_ExtendedDatabase;


import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        Person person1 = new Person(1, "Pesho");
        Person person2 = new Person(1, "Toshko");
        Person person3 = new Person(1, "Gosho");
        database = new Database(person1,person2, person3);
    }
}