import org.junit.Test;

/**
 * Created by chanlvh on 11/18/14.
 */

import static org.junit.Assert.assertEquals;

public class DoubleSquareTest {
    public int countDoubleSquare(int n) {
        int i=0;
        int x=0, y=n;
        int count = 0;

        while (x <= n/2) {
            int j = (int) Math.sqrt(y);
            if (j*j == y) {
                count++;
            }
            i++;
            x = i*i;
            y = n-x;
        }
        return count;

    }

    @Test(timeout = 1000)
    public void testCount1() {
        assertEquals(1, countDoubleSquare(10));
    }

    @Test(timeout = 1000)
    public void testCount2() {
        assertEquals(2, countDoubleSquare(25));
    }
}
