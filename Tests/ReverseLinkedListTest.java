import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    public class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    public static Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        Node temp;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test2Node() throws Exception {
        Node head, node1, node2;
        node2 = new Node(2, null);
        node1 = new Node(1, node2);
        head = node1;
        head = reverse(head);
        assertEquals(head, node2);
        assertEquals(head.next, node1);
        assertEquals(node1.next, null);
    }

    @Test
    public void test1Node() {
        Node node1 = new Node(1, null);
        Node head = node1;
        head = reverse(head);
        assertEquals(head, node1);
        assertEquals(node1.next, null);
    }

    @Test
    public void testNull() {
        Node head = null;
        head = reverse(head);
        assertEquals(head, null);
    }
}