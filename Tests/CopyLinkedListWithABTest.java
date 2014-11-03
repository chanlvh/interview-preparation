import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by chanlvh on 11/3/14.
 */
public class CopyLinkedListWithABTest {
    class Node {
        int key;
        Node next, arbi;
        Node (int key, Node next) {
            this.key = key;
            this.next = next;
        }

        @Override
        public boolean equals(Object other) {
            Node obj = (Node) other;
            try {
                if (key == obj.key
                        && (next == obj.next || next.key == obj.next.key)
                        && (arbi == obj.arbi || arbi.key == obj.arbi.key))
                    return true;
            } catch (NullPointerException e) {
                return false;
            }
            return false;
        }
    }

    Node copyLinkedListWithABPointer(Node headOld) {
        Node newList = null;

        Node oldList = headOld;
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();

        // create new list without pointers
        while (oldList != null) {
            // create a new list Node
            newList = new Node(oldList.key, null);
            map.put(oldList.key, newList);
            oldList = oldList.next;
        }

        oldList = headOld;

        // map corresponding pointer
        while (oldList != null) {
            newList = map.get(oldList.key);
            newList.next = (oldList.next == null) ? null : map.get(oldList.next.key);
            newList.arbi = (oldList.arbi == null) ? null : map.get(oldList.arbi.key);
            oldList = oldList.next;
        }

        return headOld == null? null : map.get(headOld.key);
    }

    Node[] list;

    @Before
    public void setup() {
        list = new Node[10];
        for (int i=0; i<10; i++)
            list[i] = new Node(i, i == 0 ? null : list[i-1]);
        list[0].arbi = list[2];
        list[1].arbi = list[3];
        list[2].arbi = list[0];
        list[3].arbi = list[0];
    }

    @Test(timeout = 1000)
    public void testNormalCase() {
        Node head = copyLinkedListWithABPointer(list[9]);
        int i = 9;
        while (i >= 0) {
            assertEquals("Node " + Integer.toString(i),head, list[i]);
            head = head.next;
            i -= 1;
        }
    }
}
