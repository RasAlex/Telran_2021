package telran.matrix.tools;

public class Matrix {
    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;

            }

        }
        return sum;
    }

    public static int[][] transpMatrix(int[][] matrix) {
        int matrixColLength = matrix.length;
        int matrixRowLength = matrix[0].length;
        int[][] trnMatrix = new int[matrixRowLength][matrixColLength];
        for (int i = 0; i < trnMatrix.length; i++) {
            for (int j = 0; j < trnMatrix[i].length; j++) {
                trnMatrix[i][j] = matrix[j][i];

            }
            
        }
        return trnMatrix;
    }


    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2){
// Матрицы могут быть перемножены, если количество столбцов первой матрицы m
// должно быть равно количеству строк во второй матрице l
// ( n x m) X (l x k) ==> (n x k)                            j1                    j2               k1 k2
//   1 2 3         1 2                               i1 (1*1 + 2*3 + 3*5) , (1*2 + 2*4 + 3*6)    n1 22 28
//   4 5 6         3 4     (2 x 3) X (3 x 2) ==>         l1    l2    l3      l1    l2    l3  ==>
//                 5 6                               i2 (4*1 + 5*3 + 6*5) , (4*2 + 5*4 + 6*6)    n2 49 64
//  Умножение матриц не коммунитативно
//        int [][] multiMatrix = new int [matrix1.length] [matrix2[0].length];
        int m1ColLength = matrix1[0].length; // m
        int m2RowLength = matrix2.length;    // l
        if (m1ColLength == m2RowLength){     // m=l
            int resMatrixRowLength = matrix1.length;    // n
            int resMatrixColLength = matrix2[0].length; // k
            int [][] resMatrix = new int[resMatrixRowLength][resMatrixColLength]; // создаём новую матрицу n x k
            for (int i = 0; i <resMatrixRowLength; i++) { // начинаем перебирать n
                for (int j = 0; j < resMatrixColLength; j++) { // перебираем k
                    for (int l = 0; l < m1ColLength; l++) { // перебираем m
                        resMatrix[i][j] += matrix1[i][l] * matrix2 [l][j];
            // Cуммируем произведения элементов строк первой матрицы со столбцами второй матрицы.

                        
                    }

                }

            }
            return resMatrix;
        }

        return null;
    }
}
