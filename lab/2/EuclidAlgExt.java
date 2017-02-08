/**
 * file: EuclidAlgExt.java
 * author: Vishal Koosuri
 * course: MSCS 630
 * lab: 1
 * version: 1.0
 *due date: February 8
 *
 *This file demonstrates the working of Extended Euclid
 *algorithm that shows even the GCD
 */
import java.util.*;
import java.util.Scanner;

public class EuclidAlgExt {
  public long euclidAlgExt(long a, long b) {
    long temp = 0;
    if(a < b) {
      temp = a;
      a = b;
      b = temp;
      System.out.println("a is "+a +" b is "+b +" "+temp);
    }
    long r = 0;
    long x = 0, prevx = 1, y = 1, prevy = 0;

    do {
        long q = a/b;
         r = a%b;
      System.out.println(a +" = " +q +" * "+b +" + "+r);
      a = b;
        if(r == 0) {
          System.out.println("The GCD is: "+a);
          System.out.println(x);
          System.out.println(y);
        }
      b = r;
      
      temp = x;
      x = prevx - q*x;
      prevx = temp;
      temp = y;
      y = prevy - q*y;
      prevy = temp;
      
    }while (r != 0);
    return r;
  }
  public static void main(String[] args) {
    Test s = new Test();
    long input1 = 0;
    long input2 = 0;
    Scanner sc = new Scanner(System.in);
    if(sc.hasNextLong()) {
      input1 = sc.nextLong();
      input2 = sc.nextLong();
      if(sc.hasNextLine())
        System.out.println("It is not valid!");
    } else {
      System.out.println("Invalid input!");
    }
    s.euclidAlg(input1, input2);
  }
}
