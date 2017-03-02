import java.util.Scanner;

public class MatConvert {
   public static String convertToHex(int number) {
    return Integer.toHexString(number);
  }
  public int[][] getHexMatP(char s, String p) {
    int[][] mat = new int[4][4];
    char[] ch = new char[p.length()];
    for(int i=0; i<p.length(); i++) {
      ch[i] = p.charAt(i);
      System.out.println(ch[i]);
    }
    for(int i=0; i<p.length(); i++){
      for(int j=0; j<p.length(); j++) {
        try {
          while(i < 4) {
            mat[i][j] = (int)ch[i];
            i++;
          }
        } catch(ArrayIndexOutOfBoundsException e) {
          
        }
      }
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