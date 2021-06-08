import trees.MyBST;
import trees.MyBinTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*MyArrayList<Integer> arrayList = new MyArrayList<>();
        for (int i = 0; i < 300; i++) {
            arrayList.add(i);
        }arrayList.remove(100);
        arrayList.insert(10,100);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println(arrayList.size());
        */

        /*StackBySimpLinkedList<Integer> stack = new StackBySimpLinkedList<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty())
            System.out.println(stack.pop());
        System.out.println();

        QueueBySimpLinkedList<Integer> queue = new QueueBySimpLinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
        */

        MyBST<Integer> bst = new MyBST<>();

        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            bst.add((int) (rand.nextDouble() * 100));
        }
        bst.inorder();
        System.out.println(bst.dfs(10));


    }
}
