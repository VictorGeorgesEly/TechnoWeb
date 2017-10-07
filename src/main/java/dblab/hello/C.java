public class C {
    private static void method1(int i, StringBuffer s) {
        i++; s.append("d");
    }
    public static void main(String [] args) {
        int i = 0;
        StringBuffer s = new StringBuffer("abc");
        method1(i, s);
        System.out.println("i=" + i + ", s=" + s);
        // i=0, s='abcd'
    }
}
