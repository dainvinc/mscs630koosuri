import java.util.Scanner;

public class AESCipher {
  public static int len = 0;
  public static int[] w = new int[4];
  public static int[][] matK = new int[4][4];
  public static int[][] matW = new int[4][44];
  public static int[] ki = new int[4];
  public static int[] wi = new int[4];
  public static String[][] SBox = {
    {"63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76"},
    {"CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0"},
    {"B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15"},
    {"04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75"},
    {"09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84"},
    {"53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", "58", "CF"},
    {"D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8"},
    {"51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2"},
    {"CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E", "3D", "64", "5D", "19", "73"},
    {"60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB"},
    {"E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79"},
    {"E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08"},
    {"BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A"},
    {"70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E"},
    {"E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF"},
    {"8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16"}
  };
 
  public static final String[][] RCon = {
    {"8D", "01", "02", "04", "08", "10", "20", "40", "80", "1B", "36", "6C", "D8", "AB", "4D", "9A"},
    {"2F", "5E", "BC", "63", "C6", "97", "35", "6A", "D4", "B3", "7D", "FA", "EF", "C5", "91", "39"},
    {"72", "E4", "D3", "BD", "61", "C2", "9F", "25", "4A", "94", "33", "66", "CC", "83", "1D", "3A"},
    {"74", "E8", "CB", "8D", "01", "02", "04", "08", "10", "20", "40", "80", "1B", "36", "6C", "D8"},
    {"AB", "4D", "9A", "2F", "5E", "BC", "63", "C6", "97", "35", "6A", "D4", "B3", "7D", "FA", "EF"},
    {"C5", "91", "39", "72", "E4", "D3", "BD", "61", "C2", "9F", "25", "4A", "94", "33", "66", "CC"},
    {"83", "1D", "3A", "74", "E8", "CB", "8D", "01", "02", "04", "08", "10", "20", "40", "80", "1B"},
    {"36", "6C", "D8", "AB", "4D", "9A", "2F", "5E", "BC", "63", "C6", "97", "35", "6A", "D4", "B3"},
    {"7D", "FA", "EF", "C5", "91", "39", "72", "E4", "D3", "BD", "61", "C2", "9F", "25", "4A", "94"},
    {"33", "66", "CC", "83", "1D", "3A", "74", "E8", "CB", "8D", "01", "02", "04", "08", "10", "20"},
    {"40", "80", "1B", "36", "6C", "D8", "AB", "4D", "9A", "2F", "5E", "BC", "63", "C6", "97", "35"},
    {"6A", "D4", "B3", "7D", "FA", "EF", "C5", "91", "39", "72", "E4", "D3", "BD", "61", "C2", "9F"},
    {"25", "4A", "94", "33", "66", "CC", "83", "1D", "3A", "74", "E8", "CB", "8D", "01", "02", "04"},
    {"08", "10", "20", "40", "80", "1B", "36", "6C", "D8", "AB", "4D", "9A", "2F", "5E", "BC", "63"},
    {"C6", "97", "35", "6A", "D4", "B3", "7D", "FA", "EF", "C5", "91", "39", "72", "E4", "D3", "BD"},
    {"61", "C2", "9F", "25", "4A", "94", "33", "66", "CC", "83", "1D", "3A", "74", "E8", "CB", "8D"}
  };
  
  public static String convertToHex(int number) {
    return Integer.toHexString(number);
  }
  
  public void getHexMatP(char s, String p) {
    int[] set = new int[len];
    String str = p;
    char[] ch = new char[128];
    for(int i=0; i<p.length(); i++) {
      ch[i] = p.charAt(i);
    }
    int n =0;
    int k=0;
    for(int q=0; q<set.length; q++) {
      System.out.println("the length of set "+set.length);
      for(int j=0; j<16; j++) {
        try {
          while(n < 4) {
            matK[n][j] = (int)ch[k];
            if(ch[k] == 0)
              matK[n][j] = (int)s;
            n++;
            k++;
          }
          n = 0;
        } catch(Exception e) {}
      }
      printMat();
    }
  }
  
  public static void printMat() {
    for(int p=0; p<4; p++) {
      for(int q=0; q<4; q++) {
        w[q] = matK[p][q];
        //System.out.println("((((("+convertToHex(w[q]));
        System.out.print(convertToHex(matK[q][p]) +" ");
      }
      System.out.println();
    }
  }
  
  public static void printKi(int j) {
    for(int i=0; i<ki.length; i++) {
      ki[i] = matK[i][j];
      System.out.println(convertToHex(ki[i]));
    }
    printWi(j);
  }
  
  public static void printWi(int i) {
    for(int j=0; j<wi.length; j++) {
      wi[j] = ki[j];
      matW[j][i] = wi[j];
      //System.out.println(convertToHex(wi[j]));
      System.out.print(convertToHex(matW[j][i])+" ");
    }
    //System.out.print(convertToHex(matW[j][i])+"****");
  }
  
  public static void main(String[] args) {
    AESCipher aes = new AESCipher();
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a string: ");
    String input = s.nextLine();
    len = (int) Math.ceil((double)input.length()/16);
    System.out.println("Enter a character that you want to use to fill up:");
    char c = s.next().charAt(0);
    aes.getHexMatP(c, input);
    for(int i=0; i<4; i++)
      printKi(i);
    // for(int i=0; i<4; i++)
    //   printWi(i);
    //printTestMat();
    System.out.println();
    for(int i=0; i<4; i++) {
      for(int j=0; j<44; j++) {
        System.out.print(convertToHex(matW[i][j])+" ");
      }
      System.out.println();
    }
  }
}