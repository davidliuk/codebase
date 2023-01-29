package algorithm.math;

public class Math {
    public double myPow(double x, int n) {
        // 0的任何次幂均为0
        if (x == 0.0f) {
            return 0.0d;
        }
        if (n < 0) {
            // x = 1 / x;
            // n = -n;
            // 推荐递归写法
            return myPow(1 / x, -n);
        }

        double ans = 1.0, base = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= base;
            }
            base *= base;
            n >>= 1;
        }

        return ans;
    }

    // 尾递归，效率高
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
