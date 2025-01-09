package com.company.base;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseAction implements ITestListener {
    public Listeners() throws IOException {
        super();
    }

    public void onTestFailure(ITestResult tr) {
        try {
            takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
