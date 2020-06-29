package org.titanium.intermediate;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite runs before a test suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest runs before @test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod runs before each method of @test");
    }
    @Test
    public void testCase1(){
        System.out.println("Test case 1");
    }
    @Test
    public void testCase2(){
        System.out.println("Test case 2");
    }
    @AfterMethod
    public void  afterMethod(){
        System.out.println("afterMethod runs after each method of test");
    }
    @AfterClass
    public void  afterClass(){
        System.out.println("afterClass runs after of the class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest runs after all tests");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite runs after a suite test");
    }
}