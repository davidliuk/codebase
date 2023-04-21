package cn.neud.classloader;

class C {
    public C() {
        System.out.println("AAA");
    }

    {
        System.out.println("BBB");
    }

    static {
        System.out.println("CCC");
    }
}

class A {
    static C c = new C() {{
        System.out.println("DDD");
    }};

    public A() {
        System.out.println("1");
    }

    public A(int x) {
        System.out.println("xx");
    }

    {
        System.out.println("2");
    }

    static {
        System.out.println("3");
    }
}

public class B extends A {
    public B() {
        super(1);
        System.out.println("4");
    }

    {
        System.out.println("5");
    }

    static {
        System.out.println("6");
    }

    public static void main(String[] args) {
        new B();
        new A();
    }
}