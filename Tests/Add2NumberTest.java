import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chanlvh on 11/1/14.
 */
public class Add2NumberTest {
    class Node {
        int key;
        Node next;
        Node (int key, Node next) {
            this.key = key;
            this.next = next;
        }

        @Override
        public String toString() {
            String output = Integer.toString(this.key);
            if (next != null)
                output += next.toString();
            return output;
        }
    }

    Node reverse(Node head) {
        Node tmp, prev = null;
        while (head != null) {
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    Node add2Numbers(Node headA, Node headB) {
        headA = reverse(headA);
        headB = reverse(headB);
        Node headC = null;
        int left = 0;

        while (headA != null && headB != null) {
            int value = headA.key + headB.key + left;
            headC = new Node(value % 10, headC);
            left = value / 10;
            headA = headA.next;
            headB = headB.next;
        }

        if (headB != null)
            headA = headB;

        while (headA != null) {
            int value = headA.key + left;
            headC = new Node(value % 10, headC);
            left = value / 10;
            headA = headA.next;
        }

        if (left != 0)
            headC = new Node(left, headC);

        return headC;
    }

    Node[] node;
    @Before
    public void setup() {
        node = new Node[11];
        for (int i = 9; i >= 0; i--)
            node[i] = new Node(i, node[i + 1]);
        node[3].next = null;
        node[6].next = null;
        node[9].next = null;
    }

    @Test
    public void testNormal() {
        assertEquals("579", add2Numbers(node[1], node[4]).toString());
    }

    @Test
    public void testHasLeft() {
        assertEquals("1245", add2Numbers(node[4], node[7]).toString());
    }

    @Test
    public void testBigSmall() {
        assertEquals("792", add2Numbers(node[3], node[7]).toString());
    }
}
