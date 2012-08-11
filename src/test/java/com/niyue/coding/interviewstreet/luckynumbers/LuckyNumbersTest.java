package com.niyue.coding.interviewstreet.luckynumbers;

import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.niyue.coding.BaseTest;
import com.niyue.coding.DataLoader;

@RunWith(Parameterized.class)
public class LuckyNumbersTest extends BaseTest {
    public LuckyNumbersTest(String input, String output) {
        super(input, output);
    }
    
    @Parameters
    public static Collection<String[]> data() {
        return DataLoader.load(LuckyNumbersTest.class);
    }

    @Override
    protected void solve() throws Exception {
        Solution solution = new Solution();
        solution.solve();
    }
}
