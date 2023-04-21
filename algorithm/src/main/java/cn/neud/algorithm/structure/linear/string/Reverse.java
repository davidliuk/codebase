package cn.neud.algorithm.structure.linear.string;

public class Reverse {

    public String reverseWords(String s) {
        String[] tokens = s.trim().split(" ");
        int left = 0, right = tokens.length - 1;
        while (left < right) {
            while (left < right && tokens[left].length() == 0) {
                left++;
            }
            while (left < right && tokens[right].length() == 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            String temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", tokens);
    }

}
