import java.util.Random;

public class matrixrotation {

    public static void main(String[] args) {
        int size = 8;

        int[][] matrix = createMatrix(size);

        System.out.println("матрица до поворота:");
        printMatrix(matrix);

        rotate90Clockwise(matrix);

        System.out.println();
        System.out.println("матрица после поворота на 90 градусов по часовой стрелке:");
        printMatrix(matrix);
    }

    public static int[][] createMatrix(int n) {
        Random random = new Random();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(256);
            }
        }

        return matrix;
    }

    public static void rotate90Clockwise(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;

            for (int i = layer; i < last; i++) {
                int offset = i - layer;

                int temp = matrix[layer][i];

                matrix[layer][i] = matrix[last - offset][layer];

                matrix[last - offset][layer] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }
}
