/**
 * file: DriverAES.java
 * author: Vishal Koosuri
 * course: MSCS 630
 * lab: 5
 * version: 1.0
 *due date: May 9
 *
 *This file accepts some plaintext input and
 *Hexadecimal key input to implement
 * AES Encryption
 */
import java.util.Scanner;

public class DriverAES {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input : ");
    while (input.hasNext()) {
      String pTextHex = input.nextLine();
      String keyHex = input.nextLine();
      AESCipher.AES(pTextHex, keyHex);
    }
  }
}
