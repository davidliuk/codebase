package cn.neud.algorithm.structure.linear.string;

public class Convert {

    String[] singles = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    String[] thousands = {"", "万", "亿", "兆"};
    String[] bits = {"", "十", "百", "千"};
    int[] mods = {1, 10, 100, 1000};

    public String numberToWords(int num) {
        if (num == 0) {
            return singles[0];
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 2, unit = 1_0000_0000; i >= 0; i--, unit /= 10000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
//                toChinese(sb, curNum);
                recursion(sb, curNum, 3);
                sb.append(thousands[i]);
            }
        }

        return sb.toString().trim();
    }

    public void toChinese(StringBuffer curr, int num) {
        int thousand = num / 1000;
        num %= 1000;
        if (thousand != 0) {
            curr.append(singles[thousand]).append(bits[3]);
        } else if (curr.length() > 0 && curr.charAt(curr.length() - 1) != singles[0].charAt(0)) {
            curr.append(singles[0]);
        }
        int hundred = num / 100;
        num %= 100;
        if (hundred != 0) {
            curr.append(singles[hundred]).append(bits[2]);
        } else if (curr.length() > 0 && curr.charAt(curr.length() - 1) != singles[0].charAt(0)) {
            curr.append(singles[0]);
        }
        int ten = num / 10;
        num %= 10;
        if (ten != 0) {
            // 如果想要去掉"一十"的情况，在这里加特判
            curr.append(singles[ten]).append(bits[1]);
        } else if (curr.length() > 0 && curr.charAt(curr.length() - 1) != singles[0].charAt(0)) {
            curr.append(singles[0]);
        }
        if (num != 0) {
            curr.append(singles[num]).append(bits[0]);
        } else if (curr.length() > 0 && curr.charAt(curr.length() - 1) == singles[0].charAt(0)) {
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public void recursion(StringBuffer curr, int num, int bit) {
        if (num == 0) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == singles[0].charAt(0)) {
                curr.deleteCharAt(curr.length() - 1);
            }
            return;
        }

        int thousand = num / mods[bit];
        num %= mods[bit];
        if (thousand != 0) {
            curr.append(singles[thousand]).append(bits[bit]);
        } else if (curr.length() > 0 && curr.charAt(curr.length() - 1) != singles[0].charAt(0)) {
            curr.append(singles[0]);
        }

        recursion(curr, num, bit - 1);
    }
}
