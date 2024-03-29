/**
 * file: MatConvert.java
 * author: Vishal Koosuri
 * course: MSCS 630
 * lab: 1
 * version: 1.0
 *due date: March 1
 *
 *This file converts the Text input into a
 *matrix form in Hexadecimal format
 */
import java.util.Scanner;

public class MatConvert {
  public static int len = 0;
  public static int[][] mat = new int[4][4];

   public static String convertToHex(int number) {
    return Integer.toHexString(number);
  }
  
  public static void printMat() {
    for(int p=0; p<4; p++) {
      for(int q=0; q<4; q++) {
        System.out.print(convertToHex(mat[p][q]) +"  ");
      }
      System.out.println();
    }
  }
  
  public int[][] getHexMatP(char s, String p) {
    int[] set = new int[len];
    String str = p;
    char[] ch = new char[64];
    for(int i=0; i<p.length(); i++) {
      ch[i] = p.charAt(i);
    }
    int n =0;
    int k=0;
    for(int q=0; q<set.length; q++) {
      System.out.println();
      for(int j=0; j<16; j++) {
        try {
          while(n < 4) {
            mat[n][j] = (int)ch[k];
            if(ch[k] == 0)
              mat[n][j] = (int)s;
            n++;
            k++;
          }
          n = 0;
        } catch(Exception e) {}
      }
      printMat();
    }
    return mat; 
  }
  
  public static void main(String[] args) {
    MatConvert m = new MatConvert();
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a string: ");
    String input = s.nextLine();
    len = (int) Math.ceil((double)input.length()/16);
    System.out.println("Enter a character that you want to use to fill up:");
    char c = s.next().charAt(0);
    if(input.equals("")) {
      System.out.println("You just entered nothing!");
    } else {
      m.getHexMatP(c, input);
    }
  }
}
