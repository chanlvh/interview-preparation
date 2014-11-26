//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.LinkedList;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by chanlvh on 11/1/14.
// */
//public class WordFormDictTest {
//
//
//    public boolean check(String s, String[] dict) {
//        HashSet<String> set = new HashSet<String>(dict);
//        int n = s.length();
//        boolean[] f = new boolean[n];
//        for (int i=0; i<n; i++) {
//            if (set.contains(s.substring(0,i+1)))
//                f[i] = true;
//            else
//                f[i] = false;
//        }
//        for (int i=0; i<n; i++) {
//            if (f[i])
//                for (int j=i+1; j<n; j++)
//                    if (!f[j] && set.contains(s.substring(i + 1, j + 1)))
//                        f[j] = true;
//        }
//        return n==0 ? true : f[n-1];
//    }
//
//    @Test
//    public void test1() {
//        String[] dict = {"world", "hello", "super", "hell"};
//        assertEquals(check("hellohello", new ArrayList<String> (dict)), true);
//    }
//}
