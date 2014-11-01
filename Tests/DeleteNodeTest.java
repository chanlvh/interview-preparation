import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chanlvh on 11/1/14.
 */
public class DeleteNodeTest {
    class Node {
        int key;
        Node next;
        Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public Node deleteNode(Node head, int key) {
        Node prev = null;
        Node current = head;
        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (prev == null)
                return current.next;
            else {
                prev.next = current.next;
            }
        }
        return head;
    }

    Node node1, node2, node3, head;

    @Before
    public void setup() {
        node3 = new Node(3, null);
        node2 = new Node(2, node3);
        node1 = new Node(1, node2);
    }

    @Test
    public void testEmptyList() {
        head = deleteNode(null, 0);
        assertEquals(head, null);
    }

    @Test
    public void test1Node() {
        head = deleteNode(node3, 2);
        assertEquals(head, node3);
        head = deleteNode(node3, 3);
        assertEquals(head, null);
    }

    @Test
    public void testMiddleNode() {
        head = deleteNode(node1, 2);
        assertEquals(head, node1);
        assertEquals(head.next, node3);
        assertEquals(node3.next, null);
    }

    @Test
    public void testFrontNode() {
        head = deleteNode(node1, 1);
        assertEquals(head, node2);
    }
}
