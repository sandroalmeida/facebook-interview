package info.sandroalmeida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NodesInASubtree {

    // Tree Node
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int u;
        char c;
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    public static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        if (root == null) return new int[] { 0 }; // Return if empty tree
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> hm;

        for (Query value : queries) {
            char c = value.c;
            int u = value.u;
            Node curr = null;

            hm = new HashMap<>();

            if (root.val != u) { // If root is not in target query move on
                for (Node val : root.children) {
                    if (val.val == u) { // Child node is the root for query
                        curr = val;
                    }
                }
            }
            else {
                curr = root;
            }

            if (curr != null) { // Traverse the n-ary Tree
                traverse(curr, c, u, hm, s);
            }

            if (!hm.isEmpty()) { // Remove empty Hash
                ans.add(hm.get(c));
            }
        }

        return ans.stream().mapToInt(i -> i).toArray(); // Lambda array
    }

    public static void traverse(Node root, char c, int v, HashMap<Character, Integer> hm, String s) {
        if (root == null) return;

        if (s.charAt(root.val - 1) == c) { // Save if match query
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (Node value : root.children) { // Traverse the tree
            traverse(value, c, v, hm, s);
        }
    }

    public static void main(String[] args) {
        int n_1 = 3, q_1 = 1;
        String s_1 = "aba";
        Node root_1 = new Node(1);
        root_1.children.add(new Node(2));
        root_1.children.add(new Node(3));
        ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));
        int[] result_1 = countOfNodes(root_1, queries_1, s_1);
        //int[] expected_1 = {2};

        // Testcase 2
        int n_2 = 7, q_2 = 3;
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        int[] result_2 = countOfNodes(root_2, queries_2, s_2);
        //int[] expected_2 = {4, 1, 2};
    }
}
