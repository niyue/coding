package com.niyue.coding.interviewstreet.farvertices;

import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.niyue.coding.interviewstreet.BaseTest;
import com.niyue.coding.interviewstreet.TestLoader;

@RunWith(Parameterized.class)
public class FarVerticesTest extends BaseTest {
    public FarVerticesTest(String input, String output) {
        super(input, output);
    }
    
    @Parameters
    public static Collection<String[]> data() {
        return TestLoader.load(FarVerticesTest.class);
    }

    @Override
    protected void solve() throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }
}
