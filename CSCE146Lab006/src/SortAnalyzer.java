//Evan Eargle

import java.util.Scanner;


class Node<T> 
{
    T data;
    Node<T> next;

    public Node(T data) 
    {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> 
{
    private Node<T> head;
    private int size;

    public LinkedList() 
    {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) 
    {
        Node<T> newNode = new Node<>(data);
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            Node<T> current = head;
            while (current.next != null) 
            {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public Node<T> getHead() 
    {
        return head;
    }

    public int size() 
    {
        return size;
    }
}

public class SortAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> strings = new LinkedList<>();
        String input;

        System.out.println("Enter any number of strings and I will sort by SORT’s. Once you’re done entering sentences enter 'quit'.");
        
        while (true) 
        {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) 
            {
                break;
            }
            strings.add(input);
        }
        
        sortStrings(strings);

        System.out.println("Sorted:");
        printLinkedList(strings.getHead());

        System.out.println("\nWould you like to sort more Strings?");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.startsWith("y")) 
        {
            main(null);
        } 
        else 
        {
            System.out.println("Goodbye!");
        }

        scanner.close();
    }

    private static void sortStrings(LinkedList<String> strings) 
    {
        Node<String> current = strings.getHead();
        Node<String> index = null;
        String temp;

        if (current == null) 
        {
            return;
        } 
        else 
        {
            while (current != null) 
            {
                index = current.next;

                while (index != null) 
                {
                    if (countSortOccurrences(index.data) < countSortOccurrences(current.data)) 
                    {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    private static int countSortOccurrences(String str) 
    {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) 
        {
            if (str.substring(i, i + 4).equalsIgnoreCase("sort")) 
            {
                count++;
            }
        }
        return count;
    }

    private static void printLinkedList(Node<String> head) 
    {
        Node<String> current = head;
        while (current != null) 
        {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
