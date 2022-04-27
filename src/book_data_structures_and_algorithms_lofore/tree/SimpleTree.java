package book_data_structures_and_algorithms_lofore.tree;

import java.util.LinkedList;
import java.util.Stack;

public class SimpleTree<E extends Comparable<E>> {
    private Node<E> root;

    public Node<E> find(E value) {
        Node<E> curr = root;
        while (!curr.value.equals(value)) {
            if (curr.value.compareTo(value) > 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }

    public void insert(E value) {
        Node<E> newNode = new Node<>(value);
        if (root == null) {
            root = newNode;
        } else {
            Node<E> curr = root;
            Node<E> parent;
            while (true) {
                parent = curr;
                if (curr.value.compareTo(value) > 0) {
                    curr = curr.left;
                    if (curr == null) {
                        parent.left = newNode;
                        break;
                    }
                } else {
                    curr = curr.right;
                    if (curr == null) {
                        parent.right = newNode;
                        break;
                    }
                }
            }
        }
    }

    public boolean delete(E value) {
        Node<E> curr = root;
        Node<E> parent = root;
        boolean isLeft = true;
        boolean isChange = true;
        while (!curr.value.equals(value)) {
            parent = curr;
            if (curr.value.compareTo(value) > 0) {
                isLeft = true;
                curr = curr.left;
            } else {
                isLeft = false;
                curr = curr.right;
            }
            if (curr == null) {
                isChange = false;
                break;
            }
        }
        if (curr != null && curr.left == null && curr.right == null) {
            if (curr == root) {
                root = null;
            } else if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (curr.right == null) {
            if (curr == root) {
                root = curr.left;
            } else if (isLeft) {
                parent.left = curr.left;
            } else {
                parent.right = curr.left;
            }
        } else if (curr.left == null) {
            if (curr == root) {
                root = curr.right;
            } else if (isLeft) {
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
        } else {
            Node<E> successor = getSuccessor(curr);
            if (curr == root) {
                root = successor;
            } else if (isLeft) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
        }
        return isChange;
    }

    public void traverse(int type) {
        switch (type) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    public void displayTree() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;
        boolean isRowEmpty = false;
        System.out.println("................................................................");
        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (!globalStack.isEmpty()) {
                Node<E> temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.value);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("................................................................");
    }

    private Node<E> getSuccessor(Node<E> delNode) {
        Node<E> parent = delNode;
        Node<E> successor = delNode;
        Node<E> curr = delNode.right;
        while (curr != null) {
            parent = successor;
            successor = curr;
            curr = curr.left;
        }
        if (successor != delNode.right) {
            parent.left = successor.left;
            successor.right = delNode.right;
        }
        return successor;
    }

    private void preOrder(Node<E> root) {
        if (root != null) {
            System.out.println(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void inOrder(Node<E> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.value + " ");
            inOrder(root.right);
        }
    }

    private void postOrder(Node<E> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value + " ");
        }
    }

    public static class Node<T extends Comparable<T>> {
        T value;

        Node<T> left;

        Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
