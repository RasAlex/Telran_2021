package telran.multiarray.controller;

public class InterviewTest {
    private static final int SIZE = 10;

    public static void main(String[] args) {
        int[][] arr = new int[SIZE][SIZE];
        long t1 = System.currentTimeMillis();
       //fillArray1(arr);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println("---------------------------------------------------");
       // printArray(arr);
        t1 = System.currentTimeMillis();
        fillArray2(arr);
        t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println("---------------------------------------------------");
      printArray(arr);
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();

        }
    }

    private static void fillArray1(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i * j;

            }

        }
    }

    private static void fillArray2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = i*i;
            for (int j = i+1; j < arr[i].length; j++) {
              arr[i][j]  = arr [j][i] = i * j;

            }
        }
    }
}