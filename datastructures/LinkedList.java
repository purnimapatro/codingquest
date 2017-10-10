import java.io.*;
import java.util.*;

/* Basic implementation of linked list with various operations */
public class LinkedList {

    class Node {
        int data;
        Node next;
        
        Node(int d) {
            data = d;
            next = null;
        }
    };

    Node head;
    
    LinkedList() {
        head=null;
    }
    
    void insertAtBeginning(int val) {
        if (head == null) {
            Node temp = new Node(val);
            head = temp;
        } else {
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
        }        
    }
    
    void insertAtEnd(int val) {
        if (head == null) {
            Node temp = new Node(val);
            head = temp;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node temp = new Node(val);
            current.next = temp;
        }        
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    Node find(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    boolean contains(int key) {
        Node temp = find(key);
        if (temp != null) {
            return true;
        } else {
            return false;
        }
    }
    
    void delete(int key) {
        if (head.data == key) {
            Node temp = head;
            temp = temp.next;
            head = temp;
        } else {
            Node prev = findPrev(key);
            if (prev != null) {
                prev.next = prev.next.next;
            }
        }
    }
    
    Node findPrev(int key) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.next.data == key) {
                prev = temp;
                return prev;
            }
            temp = temp.next;
        }
        return prev;
    }
    
    void reverse() {
        Node temp = head;
        Node prev = null;
        Node next = null;
        
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            head = temp;
            temp = next;
        }
    }
    
    public static void main(String[] args) {

        /* List elements: 2->3->8->12->16->5->1->NULL */
        LinkedList ll = new LinkedList();
      /*  ll.insertAtBeginning(2);
        ll.insertAtBeginning(3);
        ll.insertAtBeginning(8);
        ll.insertAtBeginning(12);
        ll.insertAtBeginning(16);
        ll.insertAtBeginning(5);
        ll.insertAtBeginning(1); */

        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(8);
        ll.insertAtEnd(12);
        ll.insertAtEnd(16);
        ll.insertAtEnd(5);
        ll.insertAtEnd(1);

        ll.printList();
        
        System.out.println("Size of the list: " + ll.size());
        
        System.out.println("List contains 5: " + ll.contains(5));
        System.out.println("List contains 7: " + ll.contains(7));
        
        ll.insertAtEnd(7);
        ll.printList();
        
        System.out.println("Size of the list: " + ll.size());

        ll.delete(7);
        ll.printList();
        
        System.out.println("Size of the list: " + ll.size());
        
        System.out.println("List after reversing: ");
        ll.reverse();
        ll.printList();        
    }    
}
