package UnitTesting_Exercises.src.main.java.p02_ExtendedDatabase;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private int Id = 15;
    private String username = "Ivan";
    private Person person;

    @Before
    public void setUp(){
        person = new Person(Id, username);
    }

    @Test
    public void testConstructorsCreatesValidPerson(){
        int id = 15;
        String user = "Ivan";
        Assert.assertEquals(person.getId(), id);
        Assert.assertEquals(person.getUsername(), user);
    }



}