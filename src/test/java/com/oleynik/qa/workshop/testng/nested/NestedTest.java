package com.oleynik.qa.workshop.testng.nested;

import com.oleynik.qa.workshop.testng.model.MyDoubleWrapper;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedTest {
    class Multiply {
        @Test
        void multiplication_with_zero_test() {
            int x = 0;
            int y = 10;
            System.out.printf("Multiplying %s on %s%n", x, y);
            assertEquals(new MyDoubleWrapper(x).multiply(y), x * y, 0);
        }

        @Test
        void multiplication_with_two_negatives_test() {
            int x = -1;
            int y = -10;
            System.out.printf("Multiplying %s on %s%n", x, y);
            assertEquals(new MyDoubleWrapper(x).multiply(y), x * y, 0);
        }

        @Test
        void multiplication_with_two_fractions_test() {
            double x = 0.5;
            double y = 0.0005;
            System.out.printf("Multiplying %s on %s%n", x, y);
            assertEquals(new MyDoubleWrapper(x).multiply(y), x * y,0);
        }
    }

    class Divide {
        @Test
        void division_with_two_fractions_test() {
            double x = 0.5;
            double y = 0.0005;
            System.out.printf("Dividing %s by %s%n", x, y);
            assertEquals(new MyDoubleWrapper(x).divide(y), x / y, 0);
        }

        @Test
        void division_with_two_negatives_test() {
            double x = -1;
            double y = -10;
            System.out.printf("Dividing %s by %s%n", x, y);
            assertEquals(new MyDoubleWrapper(x).divide(y), x / y, 0);
        }
    }

    class Add {
        @Test
        void addition_with_two_negatives_test() {
            double x = -1;
            double y = -10;
            System.out.printf("Adding %s to %s%n", x, y);
            assertEquals(new MyDoubleWrapper(x).add(y), x + y, 0);
        }

        @Test
        void addition_with_two_fractions_test() {
            double x = 0.5;
            double y = 0.0005;
            System.out.printf("Adding %s to %s%n", x, y);
            assertEquals(new MyDoubleWrapper(x).add(y), x + y, 0);
        }
    }
}
