package com.niyue.coding.interviewstreet.hanoimoves;

import java.util.Collection;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.niyue.coding.BaseTest;
import com.niyue.coding.DataLoader;

@RunWith(Parameterized.class)
@Ignore("Unresolved yet")
public class SolutionTest extends BaseTest {
    public SolutionTest(String input, String output) {
        super(input, output);
    }
    
    @Parameters
    public static Collection<String[]> data() {
        return DataLoader.load(SolutionTest.class);
    }

    @Override
    protected void solve() throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }
}
