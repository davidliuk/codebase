package concurrent.forkjoint;

import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer> {

    private static final Integer VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    // 拆分和合并过程
    @Override
    protected Integer compute() {
        // base 判断相加两个数是否大于10
        if (end - begin <= VALUE) {
            for (int i = begin; i <= end; i++) {
                result += i;
            }
            return result;
        }

        int mid = (begin + end) / 2;
        MyTask left = new MyTask(begin, mid);
        MyTask right = new MyTask(mid + 1, end);
        left.fork();
        right.fork();
        // 合并结果
        return result = left.join() + right.join();
    }
}

public class ForkJoinDemo {


}
