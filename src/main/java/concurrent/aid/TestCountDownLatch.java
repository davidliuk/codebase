package concurrent.aid;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    // 6个同学陆续离开教师后，班长才可以锁门
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "号同学离开了教室");
                // 计数器减一
                latch.countDown();
            }, String.valueOf(i + 1)).start();
        }

        // 等待
        latch.await();
        System.out.println(Thread.currentThread().getName() + "班长锁门了");
    }

}
