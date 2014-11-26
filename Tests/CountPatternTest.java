import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chanlvh on 11/1/14.
 */
public class CountPatternTest {
    public String process(int n) {
        String s = "0";
        for (int i=1; i<=n; i++) {
            StringBuilder builder = new StringBuilder();
            int j = 0;
            int k = 0;
            while (k<s.length() && s.charAt(k) == s.charAt(j)) k++;
            int count = k-j;
            builder.append(count);
            builder.append(s.charAt(j));
            j = k;
            s = builder.toString();
        }
        return s;
    }

    @Test
    public void test1() {
        assertEquals("111221", process(4));
        assertEquals("312211", process(5));
    }
}
