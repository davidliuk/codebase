package cn.neud.concurrent.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("cut");
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("---------");
        future1.get();
        System.out.println("---------");
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            return 200;
        });
        future2.whenComplete((u, v) -> {
            System.out.println(u + ":" + v);
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("---------");
        TimeUnit.SECONDS.sleep(2);
    }

}
