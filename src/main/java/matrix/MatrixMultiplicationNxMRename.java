package matrix;

public class MatrixMultiplicationNxMRename {
  public static void main(String[] args) {
//	https://javatutoring.com/matrix-multiplication-in-java/
//	output   matrix:-
//	30 24 18
//	84 69 54
//	138 114 90
    int aRows = 3;
    int aColumns = 3;

    int bRows = 3;
    int bColumns = 3;

    int[][] a = new int[aRows][aColumns];
    int[][] b = new int[bRows][bColumns];

    fillup(a, b);

    //solution
   
    //print
    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < bColumns; j++) {
//        todo undo
//        System.out.print(c[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void fillup(int[][] a, int[][] b) {
    a[0][0] = 1;
    a[0][1] = 2;
    a[0][2] = 3;
    a[1][0] = 4;
    a[1][1] = 5;
    a[1][2] = 6;
    a[2][0] = 7;
    a[2][1] = 8;
    a[2][2] = 9;
//    Elements of matrix a:
//    1 2 3
//    4 5 6
//    7 8 9
    b[0][0] = 9;
    b[0][1] = 8;
    b[0][2] = 7;
    b[1][0] = 6;
    b[1][1] = 5;
    b[1][2] = 4;
    b[2][0] = 3;
    b[2][1] = 2;
    b[2][2] = 1;
//    Elements of matrix b
//    9 8 7
//    6 5 4
//    3 2 1
  }
}
