import java.util.Scanner;

public class MatConvert {
   public static String convertToHex(int number) {
    return Integer.toHexString(number);
  }
  
  public int[][] getHexMatP(char s, String p) {
    int[][] mat = new int[4][4];
    String str = p;
    char c = '~';
    char[] ch = new char[64];
    for(int i=0; i<p.length(); i++) {
      ch[i] = p.charAt(i);
      //System.out.println(ch[i]);
    }
    int n =0;
    int k=0;
    for(int j=0; j<16; j++) {
      try {
        while(n < 4) {
          mat[n][j] = (int)ch[k];
          if(ch[k] == 0)
            mat[n][j] = (int)c;
          //System.out.println("--------"+mat[n][j]);
          n++;
          k++;
        }
        n = 0;
      } catch(Exception e) {}
    }
    for(int i=0; i<4; i++) {
      for(int j=0; j<4; j++) {
        System.out.print(convertToHex(mat[i][j]) +"  ");
      }
      System.out.println();
    } 
    return mat; 
  }
  
  public static void main(String[] args) {
    MatConvert m = new MatConvert();
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a string: ");
    String input = s.nextLine();
    m.getHexMatP('e', input);
  }
}