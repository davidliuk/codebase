package algorithm.optimise.deconquer.tp.window;

import java.util.*;

public class MinWindow {

    public static void main(String[] args) {
        String s = "sss";
        System.out.println(s.length());
        int[] a = new int[2];
        System.out.println(a.length);
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(map.size());
        Deque<Integer> q = new ArrayDeque<>();
        q.poll();
        q.pollFirst();
        q.peek();
        q.offer(1);
        q.offerLast(1);
        List<Integer> list = new ArrayList<>();
    }

}
