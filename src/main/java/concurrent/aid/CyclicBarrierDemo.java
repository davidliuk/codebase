package concurrent.aid;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static final int NUMBER = 7;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "星龙珠被收集到了");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "星龙珠被使用完毕");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, String.valueOf(i + 1)).start();
        }
    }

}
