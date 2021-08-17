package com.oleynik.qa.workshop.testng.general;

import com.oleynik.qa.workshop.testng.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.String.format;

/*@Test*/
public class AssertTest {

    @Test
    public void assert_equals_multiplication_test() {
        System.out.println("Multiplication test");
        Assert.assertEquals(2*5, 10, "Multiplication result is wrong");
    }

    @Test
    public void assert_equals_division_test(){
        System.out.println("Division test.");
        Assert.assertEquals(10/5.0, 2.0, 0);
    }

    @Test
    public void assert_boolean_test(){
        boolean variable = true;
        Assert.assertTrue(variable, "variable is not true");
        Assert.assertFalse(!variable, "!variable is not false");
    }

    @Test
    public void fail_test(){
        boolean isFailed = false;
        if (isFailed) {
            Assert.fail(format("The test is failed because isFailed equals to %s", isFailed));
        }
    }

    @Test
    public void assert_null_test() {
        Object myObject = null;
        Assert.assertNull(myObject, "My object is not null");
    }

    @Test
    public void assert_not_null_test() {
        Object myObject = new Object();
        Assert.assertNotNull(myObject, "My object is null");
    }

    @Test
    public void assert_same_test() {
        User user1 = User.builder("Crocodilovich")
                .name("Crocodil")
                .yearOfBirth(1991)
                .build();
        Assert.assertSame(user1, user1, "The users are not the same");
    }

    @Test
    public void assert_not_the_same_test() {
        User user1 = User.builder("Crocodilovich")
                .name("Crocodil")
                .yearOfBirth(1991)
                .build();
        User user2 = user1.toBuilder().build();
        Assert.assertNotSame(user1, user2, "The users are not the same");
    }
}
