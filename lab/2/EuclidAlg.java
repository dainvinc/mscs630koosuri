import java.util.*;

public class EuclidAlg {
  public long euclidAlg(long a, long b) {
    long temp = 0;
    long rem = 0;
    if(a < b) {
      System.out.println("The elements are switched as it does not meet the condition.");
      temp = a;
      a = b;
      b = temp;
    }
    do {
      long div = a/b;
      rem = a%b;
      System.out.println(a +" = " +b +" * "+div +" + "+rem);
      if(rem == 0)
        System.out.println("The GCD is: "+b);
      a = b;
      b = rem;
    }while(rem != 0);
    return rem;
  }
  public static void main(String[] args) {
    EuclidAlg ea = new EuclidAlg();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the dividend: ");
    long num1 = input.nextLong();
    System.out.print("Enter the divisor: ");
    long num2 = input.nextLong();
    
    ea.euclidAlg(num1, num2);
    ea.euclidAlg(75, 148);
  }
}