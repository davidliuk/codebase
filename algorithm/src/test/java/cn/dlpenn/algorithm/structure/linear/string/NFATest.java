package cn.dlpenn.algorithm.structure.linear.string;

import org.junit.jupiter.api.Test;

class NFATest {

    NFA n = new NFA();

    @Test
    void myAtoi() {
//        System.out.println(n.myAtoi("123"));
        String s = "  hello world!  ";
//        List<String> list = Arrays.asList(s.split(" "));
//        for (String token : list) {
//            System.out.println(token.length());
//            System.out.println(token);
//        }
//        System.out.println(Arrays.toString(s.trim().split(" +")));
        System.out.println(carryStrings("1", "12"));
    }

    public String carryStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            ans.append(sum % 10);
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
