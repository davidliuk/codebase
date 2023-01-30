package algorithm.search.dfs.enumerate.permutation;

import java.util.*;

public class Ladders {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList
    ) {
        wordList.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        HashMap<String, Set<String>> graph = construct(wordSet);

        Queue<String> forwardQueue = new ArrayDeque<>();
        Queue<String> backwardQueue = new ArrayDeque<>();
        Set<String> forwardSet = new HashSet<>();
        Set<String> backwardSet = new HashSet<>();

        forwardQueue.offer(beginWord);
        forwardSet.add(beginWord);
        backwardQueue.offer(endWord);
        backwardSet.add(endWord);

        int distance = 1;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            distance++;
            if (extendQueue(forwardQueue, forwardSet, backwardSet, graph)) {
                break;
            }

            distance++;
            if (extendQueue(backwardQueue, backwardSet, forwardSet, graph)) {
                break;
            }
        }

        List<List<String>> results = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        List<String> result = new ArrayList<>();
        result.add(beginWord);
        dfs(distance, beginWord, endWord, graph, visited, result, results, new HashMap<>());

        return results;
    }

    HashMap<String, Set<String>> construct(
            Set<String> wordSet
    ) {
        HashMap<String, Set<String>> graph = new HashMap<>();
        for (String word : wordSet) {
            graph.put(word, getNextWords(word, wordSet));
        }

        return graph;
    }

    Set<String> getNextWords(
            String word,
            Set<String> wordSet
    ) {
        Set<String> nextWordSet = new HashSet<>();
        int wordLength = word.length();
        StringBuilder wordBuilder = new StringBuilder(word);
        for (int i = 0; i < wordLength; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char temp = wordBuilder.charAt(i);
                wordBuilder.replace(i, i + 1, "" + c);
                String nextWord = wordBuilder.toString();
                if (wordSet.contains(nextWord)) {
                    nextWordSet.add(nextWord);
                }
                wordBuilder.replace(i, i + 1, "" + temp);
            }
        }
        nextWordSet.remove(word);
        return nextWordSet;
    }

    boolean extendQueue(
            Queue<String> queue,
            Set<String> set,
            Set<String> oppsiteSet,
            HashMap<String, Set<String>> graph
    ) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String node = queue.poll();
            for (String neighbor : graph.getOrDefault(node, new HashSet<String>())) {
                if (set.contains(neighbor)) {
                    continue;
                }
                if (oppsiteSet.contains(neighbor)) {
                    return true;
                }

                set.add(neighbor);
                queue.offer(neighbor);
            }
        }

        return false;
    }

    public boolean dfs(
            int depth,
            String beginWord,
            String endWord,
            Map<String, Set<String>> graph,
            Set<String> visited, // 避免走环路
            List<String> result,
            List<List<String>> results,
            Map<String, Integer> memo // 记录匹配失败的情况，避免重复计算
    ) {
        // catch1 超深度，不符合要求
        if (result.size() > depth) {
            return false;
        }
        // catch1 记忆化+剪枝
        if (memo.containsKey(beginWord) && result.size() >= memo.get(beginWord)) {
            return false;
        }
        // catch2: base case, 成功找到
        if (beginWord.equals(endWord)) {
            // 深拷贝
            results.add(new ArrayList<>(result));
            return true;
        }

        boolean flag = false;
        for (String word : graph.get(beginWord)) {
            if (visited.contains(word)) {
                continue;
            }
            // forward
            result.add(word);
            visited.add(word);

            flag = dfs(depth, word, endWord, graph, visited, result, results, memo) || flag;

            // backward
            result.remove(result.size() - 1);
            visited.remove(word);
        }
        // 如果找不到就把位置记下来，防止后面反复搜索
        if (!flag) {
            int level = memo.getOrDefault(beginWord, result.size());
            memo.put(beginWord, Math.min(level, result.size()));
        }

        return flag;
    }

}
