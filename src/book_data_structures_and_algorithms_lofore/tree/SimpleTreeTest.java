package book_data_structures_and_algorithms_lofore.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleTreeTest {
    public static void main(String[] args) throws IOException {

        int value;

        SimpleTree<Integer> tree = new SimpleTree<>();
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(43);
        tree.insert(30);

        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choise = getChar();
            switch (choise) {
                case 's':
                    tree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    SimpleTree.Node<Integer> foundNode = tree.find(value);
                    if (foundNode != null) {
                        System.out.print("Found: ");
                        System.out.println(foundNode);
                        System.out.println();
                    }
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    System.out.println(tree.delete(value));
            }
        }
    }

    private static char getChar() throws IOException {
        String str = getString();
        return str.charAt(0);
    }

    private static int getInt() throws IOException {
        String str = getString();
        return Integer.parseInt(str);
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        return str;
    }
}
