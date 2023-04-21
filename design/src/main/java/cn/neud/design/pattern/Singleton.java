package cn.neud.design.pattern;


import java.io.Serializable;

public class Singleton implements Serializable {

    // 可见性、有序性（防止指令重排）
    private static volatile Singleton INSTANCE = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }

}
