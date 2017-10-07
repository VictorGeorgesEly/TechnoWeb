package dblab.ex01E;

class A {
    int x;

    void m() {
        System.out.println("Je suis dans la méthode m d'une instance de A");
    }
}

class B extends A {

    void m() {
        System.out.println("Je suis dans la méthode m d'une instance de B");
    }
}

class C extends B {
    int a;

    void m() {
        System.out.println("Je suis dans la méthode m d'une instance de C");
    }

    void test() {
        a = super.x;
        a = ((B) this).x;
        a = ((A) this).x;
        super.m();
        ((B) this).m();
    }
}
