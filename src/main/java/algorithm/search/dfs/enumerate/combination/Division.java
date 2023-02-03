package algorithm.search.dfs.enumerate.combination;

import java.util.ArrayList;
import java.util.List;

public class Division {

    static final int SEG_COUNT = 4;

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<String>();
        dfs(s, 0, new ArrayList<String>(), results);
        return results;
    }

    // 组合类
    public void dfs(
            String s,
            int startIndex,
            List<String> segments,
            List<String> results
    ) {
        // base case
        if (segments.size() == SEG_COUNT) {
            // catch 1. 匹配完毕
            if (startIndex == s.length()) {
                results.add(String.join(".", segments));
            }
            return;
        }
        // base case，字符串匹配完但是段数不够
        if (startIndex == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(startIndex) == '0') {
            segments.add("0");
            dfs(s, startIndex + 1, segments, results);
            segments.remove(segments.size() - 1);
            return;
        }

        int addr = 0;
        // 取的长度不一定，所以说循环来枚举
        for (int i = startIndex; i < s.length(); ++i) {
            addr = addr * 10 + (s.charAt(i) - '0');
            // 相当于isValid，
            // <=0是出现了异常，错误的输入的字符，或者这一位是0
            // >0xFF太大了，已经不需要往后试了，剪枝
            if (addr <= 0 || addr > 0xFF) {
                break;
            }
            segments.add(String.valueOf(addr));
            dfs(s, i + 1, segments, results);
            segments.remove(segments.size() - 1);
        }
    }

}
