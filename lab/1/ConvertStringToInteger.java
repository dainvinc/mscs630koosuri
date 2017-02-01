/**
 * file: ConvertStringToInteger.java
 * author: Vishal Koosuri
 * course: MSCS 630
 * lab: 1
 *due date: January 25
 *
 *This file contains the declaration of a ConvertStringToInteger
 *which converts a given String into certain integers.
 */
import java.util.HashMap;

public class ConvertStringToInteger {
  public int[] str2int(String plainText) {
    String changeCase = plainText.toLowerCase();
    System.out.println(changeCase);
    char[] pText = changeCase.toCharArray();
    int[] cipher = new int[20];
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('a', 0);
    map.put('b', 1);
    map.put('c', 2);
    map.put('d', 3);
    map.put('e', 4);
    map.put('f', 5);
    map.put('g', 6);
    map.put('h', 7);
    map.put('i', 8);
    map.put('j', 9);
    map.put('k', 10);
    map.put('l', 11);
    map.put('m', 12);
    map.put('n', 13);
    map.put('o', 14);
    map.put('p', 15);
    map.put('q', 16);
    map.put('r', 17);
    map.put('s', 18);
    map.put('t', 19);
    map.put('u', 20);
    map.put('v', 21);
    map.put('w', 22);
    map.put('x', 23);
    map.put('y', 24);
    map.put('z', 25);
    map.put(' ', 26);

    for(int i=0; i<pText.length; i++) {
      char cText = pText[i];
      cipher[i] = map.get(cText);
      System.out.print(cipher[i]+ " ");
    }

    return cipher;
  }

  public static void main(String[] args) {
    ConvertStringToInteger s2i = new ConvertStringToInteger();
    s2i.str2int("Hello World");
  }
}
