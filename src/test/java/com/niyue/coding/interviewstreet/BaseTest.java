package com.niyue.coding.interviewstreet;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.io.CharStreams;

public abstract class BaseTest {
    private String inputFile;
    private String outputFile;
    private ByteArrayOutputStream actualOutputData;
    
    public BaseTest(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
    
    @Before
    public void setUpStreams() {
        redirecInputToInputFile();
        
        redirectOutputToMemory();
    }
    
    @Test
    public void test() throws Exception {
        solve();
        assertEquals(expectedOutput().trim(), actualOutputData.toString().trim());
    }
    
    private void redirecInputToInputFile() {
        InputStream inputStream = this.getClass().getResourceAsStream(inputFile);
        System.setIn(inputStream);
    }
    
    private void redirectOutputToMemory() {
        actualOutputData = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputData));
    }
    
    private String expectedOutput() throws IOException {
        InputStream outputStream = this.getClass().getResourceAsStream(outputFile);
        String outputData = CharStreams.toString(new InputStreamReader(outputStream));
        return outputData;
    }
    
    protected abstract void solve() throws Exception;
}
