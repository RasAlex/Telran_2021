package telran.matrix.tests;

import telran.matrix.tools.Matrix;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    int[][] matrix1 ={{1,2,3}};
    int[][] matrix2 ={{1},{2},{3}};
    int[][] expectedMul ={{14}};

    @org.junit.jupiter.api.Test
    void sumMatrix() {
        assertEquals(6, Matrix.sumMatrix(matrix1));
    }

    @org.junit.jupiter.api.Test
    void transpMatrix() {
        assertArrayEquals(matrix2, Matrix.transpMatrix(matrix1));
    }

    @org.junit.jupiter.api.Test
    void multiplyMatrix() {
        assertArrayEquals(expectedMul,Matrix.multiplyMatrix(matrix1,matrix2));

        int[][] m1 ={{1,2,3},{4,5,6}};
        int[][] m2 ={{1,2},{3,4},{5,6}};
        int[][] mul ={{22, 28},{49,64}};
        assertArrayEquals(mul,Matrix.multiplyMatrix(m1,m2));
    }
}