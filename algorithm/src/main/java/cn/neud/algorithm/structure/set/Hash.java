package cn.neud.algorithm.structure.set;

import java.util.*;

public class Hash {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 1);
            put(3, 3);
        }};
        map.forEach((k, v) -> System.out.println(k + ", " + v));

        int[][] values = map.entrySet().stream()
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .toArray(int[][]::new);

        // 一般的stream无法直接返回int等基本数据类型数组，需要在map的时候mapToInt，这样才可以直接toArray基本数据类型的数组
        int[] array = Arrays.stream(values)
                .skip(values.length - 2)
                .mapToInt(pair -> pair[0])
                .toArray();

        List<Integer> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(1);
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();


        StringBuilder sb = new StringBuilder();
        List<String> s = new ArrayList<>();
        String.join("->", s);
//        String.join("", new String[]{"v", "sss"});
        // parallelStream 影响排序
        map.entrySet().stream()
//                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .forEach(sb::append);
//                .map(e -> String.valueOf(e.getKey()))
//                .reduce("", (ret, i) -> ret + i);
    }

    // lc451
    public String frequencySort(String s) {
        Map<Character, Integer> occurrences = new HashMap<>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = occurrences.getOrDefault(c, 0) + 1;
            occurrences.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuilder[] buckets = new StringBuilder[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            StringBuilder bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }

}
