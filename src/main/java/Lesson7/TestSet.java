package Lesson7;

import Lesson7.Interfaces.AfterTest;
import Lesson7.Interfaces.BeforeTest;
import Lesson7.Interfaces.Test;

public class TestSet {
    @BeforeTest
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Тест 3");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Тест 1");
    }

    @Test(priority = 2)
    public void test2A() {
        System.out.println("Тест 2A");
    }

    @Test(priority = 2)
    public void test2B() {
        System.out.println("Тест 2B");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("Тест 4");
    }

    @AfterTest
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
