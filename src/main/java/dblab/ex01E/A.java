package dblab.ex01E;

class A {
    int x;

    void m() {
        System.out.println("Je suis dans la méthode m d'une instance de A");
    }
}

class B extends A {
    int x;

    void m() {
        System.out.println("Je suis dans la méthode m d'une instance de B");
    }
}

class C extends B {
    int x, a;

    void m() {
        System.out.println("Je suis dans la méthode m d'une instance de A");
    }

    void test() {
        a = super.x;
        a = super.super.x;
        a = ((B) this).x;
        a = ((A) this).x;
        super.m();
        super.super.m();
        ((B) this).m();
    }
}
