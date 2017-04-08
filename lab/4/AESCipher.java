public class AESCipher {
  public static String[] roundKeys = new String[10];
  public static String[] w = new String[4];
  
  
  public static String[] roundKeysHex(String keyHex) {
    return roundKeys;
  }
  
  public static void aesSBox() {
    
  }
  
  public static String convertToHex(int number) {
    return Integer.toHexString(number).toUpperCase();
  }
  
  public static String getHexKey(String something) {
    String s1 = something;
    String res = "";
    char[] ch = new char[64];
    System.out.println(s1.length());
    
    for(int i=0; i<s1.length(); i++) {
      ch[i] = s1.charAt(i);
      res = res + convertToHex((int) ch[i])+ " ";
      //System.out.println(convertToHex((int) ch[i]));
    }
    System.out.println("********* "+'\n' +res);
    return res;
  }
  
  public static void main(String[] args) {
    AESCipher aes = new AESCipher();
    aes.getHexKey("Thats my Kung Fu");
  }
}