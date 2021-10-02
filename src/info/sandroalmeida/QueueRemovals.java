package info.sandroalmeida;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueRemovals {

    static class Node{
        int index;
        int value;

        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public static int[] findPositions(int[] arr, int x) {

        List<Integer> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++)
            queue.add(new Node(i, arr[i]));

        while(result.size() < arr.length - 1 && result.size() < x){
            int times = x;
            Queue<Node> auxQueue = new LinkedList<>();
            Node maxNode = null;
            while(times > 0 && !queue.isEmpty()){
                Node current = queue.poll();
                if(maxNode == null)
                    maxNode = current;
                else if(maxNode.value < current.value)
                    maxNode = current;
                auxQueue.add(current);
                times--;
            }
            result.add(maxNode.index + 1);
            while(!auxQueue.isEmpty()){
                Node current = auxQueue.poll();
                if(current.value > 0)
                    current.value = current.value - 1;
                if(current != maxNode)
                    queue.add(current);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        //int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        //int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
    }
}
