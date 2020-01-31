package on2012_8_10.cs_connectedsets;



import com.wintech.io.BaseIn;
import java.io.PrintWriter;

public class CS_ConnectedSets {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        int n = in.readInt();
        byte[][] matrix = new byte[n][n];
        int row, col, setCount;

        for(row = 0; row < n; row++) {
            for(col = 0; col < n; col++) {
                matrix[row][col] = in.readByte();
            }
        }

        setCount = 0;
        for(row = 0; row < n; row++) {
            for(col = 0; col < n; col++) {
                if(matrix[row][col] == 1) {
                    setCount++;
                    visitMatrixPosition(matrix, row, col);
                }
            }
        }

        out.println(setCount);
    }

    private void visitMatrixPosition(byte[][] matrix, int srow, int scol) {
        matrix[srow][scol] = -1;
        int row, col;
        boolean isVisitFound;
        for(row = srow; row < matrix.length; row++) {
            isVisitFound = false;
            for(col = (row == srow? scol+1: 0); col < matrix.length; col++) {
                if(matrix[row][col] == 1) {
                    if(row > 0) {
                        if(matrix[row-1][col] == -1) {
                            matrix[row][col] = -1;
                            isVisitFound = true;
                            continue;
                        }
                        if(col > 0 && matrix[row-1][col-1] == -1) {
                            matrix[row][col] = -1;
                            isVisitFound = true;
                            continue;
                        }
                        if(col < matrix.length - 1 && matrix[row-1][col+1] == -1) {
                            matrix[row][col] = -1;
                            isVisitFound = true;
                            continue;
                        }
                    }
                    if(col > 0 && matrix[row][col-1] == -1) {
                        matrix[row][col] = -1;
                        isVisitFound = true;
                        continue;
                    }
                }
            }
            if(isVisitFound == false)
                break;
        }

    }
}
