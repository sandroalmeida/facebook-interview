package info.sandroalmeida;

// time - O(n) space O(n)
public class NumberOfVisibleNodes {

    static class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int visibleNodes(Node root) {

        if(root.left == null && root.right == null)
            return 1;
        else if(root.left != null && root.right == null)
            return visibleNodes(root.left) + 1;
        else if(root.left == null && root.right != null)
            return visibleNodes(root.right) + 1;
        else
            return Math.max(visibleNodes(root.left), visibleNodes(root.right)) + 1;

    }

    public static void main(String[] args) {
        Node root_1 = new Node(8);
        root_1.left = new Node(3);
        root_1.right = new Node(10);
        root_1.left.left = new Node(1);
        root_1.left.right = new Node(6);
        root_1.right.right = new Node(14);
        root_1.left.right.left = new Node(4);
        root_1.left.right.right = new Node(7);
        root_1.right.right.left = new Node(13);
        //int expected_1 = 4;
        System.out.println(visibleNodes(root_1));

        Node root_2 = new Node(10);
        root_2.left = new Node(8);
        root_2.right = new Node(15);
        root_2.left.left = new Node(4);
        root_2.left.left.right = new Node(5);
        root_2.left.left.right.right = new Node(6);
        root_2.right.left = new Node(14);
        root_2.right.right = new Node(16);

        //int expected_2 = 5;
        System.out.println(visibleNodes(root_2));
    }
}
