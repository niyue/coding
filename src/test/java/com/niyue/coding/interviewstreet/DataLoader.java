package com.niyue.coding.interviewstreet;

import java.util.ArrayList;
import java.util.List;

public final class DataLoader {
    /**
     * The convention is:
     * 1) Tests are placed under the same path/package of test class
     * 2) Test comes with a pair of files, one for input, one for output
     * 3) Input file is named like "{idOfTest}.in.txt"
     * 4) Output file is named like "{idOfTest}.out.txt"
     * 5) Test id should be continuous (starting from 0)
     * @param testClass the class of the test code, which tells where test data is 
     * @return a list of test file names detected
     */
    public static final List<String[]> load(Class<?> testClass) {
        List<String[]> io = new ArrayList<String[]>();
        for(int i=0;i<1000;i++) {
            String inputResource = String.format("%d.in.txt", i);
            String outputResource = String.format("%d.out.txt", i);
            if(isExisting(inputResource, testClass) && isExisting(outputResource, testClass)) {
                io.add(new String[]{inputResource, outputResource});
            } else {
                break;
            }
        }
        return io;
    }
    
    private static boolean isExisting(String resource, Class<?> testClass) {
        return testClass.getResourceAsStream(resource) != null;
    }
}
