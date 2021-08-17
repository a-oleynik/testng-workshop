package com.oleynik.qa.workshop.testng.dependencies;

import org.testng.annotations.Test;

public class DependenciesTest {

    @Test/*(dependsOnGroups = "Smoke")*/
    public void login_test(){
        System.out.println("Login test");
    }

    @Test/*(dependsOnMethods = "login_test")*/
    public void send_mail_test(){
        System.out.println("Send mail test");
    }

    @Test(groups = {"Smoke","Regression"})
    public void install_test(){
        System.out.println("Install test");
    }
}
