package cn.dlpenn.algorithm.math;

import java.util.concurrent.ThreadPoolExecutor;

public class Math {

    double myPow(double a, int n) {
        if (a == 0.0f) {
            return 0.0d;
        }
        if (n < 0) {
            // 防止n是min_value，会溢出
            return (1 / a) * myPow(1 / a, -(n + 1));
        }
        double ans = 1, base = a;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = (ans * base);
            }
            base = (base * base);
            n >>= 1;
        }

        return ans;
    }

    // 尾递归，效率高
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
