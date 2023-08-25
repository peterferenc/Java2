package linear.algebra;

public class GaussianElimination {

    private double[][] matrix;
    private int rows;
    private int cols;

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        if (getRows() != getRows()) {
            throw new IllegalArgumentException();
        } else {
            this.matrix = matrix;
        }
    }

    public GaussianElimination(int rownumbers, int colnumbers, double[][] matrix) {
        this.cols = colnumbers;
        this.rows = rownumbers;
        checkMatrixDimensions(matrix);
        this.matrix = matrix;
    }

    private int argMax(int rowIndex, int colIndex) {
        int maxIndex = rowIndex;
        double max = matrix[rowIndex][colIndex];
        for (int i = rowIndex + 1; i < getRows(); i++) {
            if (Math.abs(matrix[i][colIndex]) > Math.abs(max)) {
                max = matrix[i][colIndex];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void checkMatrixDimensions(double[][] matrix) {
        if (matrix.length != getRows() || matrix[0].length != getCols()) {
            throw new IllegalArgumentException();
        }
    }

    private void swapRows(int rowIndexA, int rowIndexB) {
        double[] temp = matrix[rowIndexA];
        matrix[rowIndexA] = matrix[rowIndexB];
        matrix[rowIndexB] = temp;
    }

    public void rowEchelonForm() {
        int h = 0;
        int k = 0;
        while (h < getRows() && k < getCols()) {
            int i_max = argMax(h, k);
            if (matrix[i_max][k] == 0) {
                k = k + 1;
            } else {
                swapRows(h, i_max);

                for (int i = h + 1; i < getRows(); i++) {
                    multiplyAndAddRow(i, h, k);
                }
                multiplyRow(h, k);
                h = h + 1;
                k = k + 1;

            }
        }
    }

    private void multiplyAndAddRow(int addRow, int mulRow, int colIndex) {
        double f = matrix[addRow][colIndex] / matrix[mulRow][colIndex];
        for (int j = colIndex; j < getCols(); j++) {
            matrix[addRow][j] -= matrix[mulRow][j] * f;
        }
    }

    private void multiplyRow(int row, int colIndex) {
        double f = matrix[row][colIndex];
        for (int j = 0; j < getCols(); j++) {
            matrix[row][j] = matrix[row][j] / f;
        }
    }

    public void print() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols() - 1; j++) {
                System.out.print("(" + matrix[i][j] + ")" + String.valueOf(((char) (j + 97))) + "+");
            }
            System.out.print("=" + matrix[i][getCols() - 1]);
            System.out.println();
        }
    }

    public void backSubstitution() {
        int h = getRows() - 1;
        int k = getCols() - 2;
        while (h >= 0 && k >= 0) {
            if (h == k) {
                if (matrix[h][k] == 0) {
                    throw new IllegalArgumentException();
                }
            }
            for (int i = h - 1; i >= 0; i--) {
                multiplyAndAddRow(i, h, k);
            }
            h--;
            k--;
        }
    }
}
