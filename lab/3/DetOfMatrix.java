import java.util.Scanner;

public class DetOfMatrix {
  public int cofModDet(int m, int[][] A) {
  int[][] tempMat;
  int result = 0;
  if(A.length == 1) {
    result = A[0][0];
    return result;
  }
  
  if(A.length == 2) {
    result = A[0][0]*A[1][1] - A[0][1]*A[1][0];
    return result;
  }
  for(int i=0; i<A[0].length; i++) {
    tempMat = new int[A.length-1][A[0].length-1];
    for(int j=1; j<A.length; j++) {
      for(int k=0; k<A[0].length; k++) {
        if(k<i)
          tempMat[j-1][k] = A[j][k];
        else if(k>i)
          tempMat[j-1][k-1] = A[j][k];
      }
    }
    result += A[0][i]*(int)Math.pow(-1, i)*cofModDet(1, tempMat);
  }  
  //System.out.println("Res = "+result%9);
  return result%m;
  }
  public static void main(String[] args) {
    DetOfMatrix d = new DetOfMatrix();
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the length of the matrix: ");
    int len = s.nextInt();
    System.out.println("Enter the mod value: ");
    int mod = s.nextInt();
    int[][] a = new int[len][len];
    System.out.println("Enter the values into the matrix:");
    for(int i=0;i<a.length; i++) {
      for(int j=0; j<a.length; j++) {
        a[i][j] = s.nextInt()%mod;
      }
    }
    System.out.println("Modulus of "+mod);
    for(int i=0; i<a.length; i++) {
      for(int j=0; j<a.length; j++) {
        System.out.print(a[i][j]+"  ");
      }
      System.out.println();
    }
    int r=d.cofModDet(mod, a);
    System.out.println("Determinent = " +r);
  }
}