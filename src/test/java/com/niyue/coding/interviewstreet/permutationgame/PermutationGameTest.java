package com.niyue.coding.interviewstreet.permutationgame;

import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.niyue.coding.interviewstreet.BaseTest;
import com.niyue.coding.interviewstreet.DataLoader;

@RunWith(Parameterized.class)
public class PermutationGameTest extends BaseTest {
    public PermutationGameTest(String input, String output) {
        super(input, output);
    }
    
    @Parameters
    public static Collection<String[]> data() {
        return DataLoader.load(PermutationGameTest.class);
    }

    @Override
    protected void solve() throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }
}