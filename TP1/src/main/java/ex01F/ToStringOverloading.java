package ex01F;

import org.apache.log4j.Logger;

public class ToStringOverloading {
  public static void main(String[] args) {
    Circle c1 = new Circle(0, 0, 5);
    Circle c2 = new Circle(0, 0, 3);
    System.out.println("C1 => " + c1);
    log.info("C1 => " + c1);
    log.info("C1.toString() => " + c1.toString());
    log.info("C2 => " + c2);
  }
}

/*
 * mvn exec:java -Dexec.mainClass="ex01F.ToStringOverloading"
 */
