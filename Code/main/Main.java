import java.util.logging.Level;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedInputStream;
import java.util.Collection;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Prabu
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("IO/A-small-attempt0.in");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("IO/A-small-attempt0.out");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		BaseIn in = new BaseIn(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		CJ2014QR_MagicTrick solver = new CJ2014QR_MagicTrick();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class CJ2014QR_MagicTrick {
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        final int SIZE = 4;

        int answer1 = in.readInt();
        int[] cardArrangement11 = in.readInt2D(SIZE, SIZE)[answer1-1];
        ArrayList<Integer> cardArrangement12 = new ArrayList<Integer>();
        ArrayList<Integer> cardArrangement13 = new ArrayList<Integer>();
        for(int i = 0; i < SIZE; i++) {
            cardArrangement12.add(cardArrangement11[i]);
            cardArrangement13.add(cardArrangement11[i]);
        }

        int answer2 = in.readInt();
        int[] cardArrangement21 = in.readInt2D(SIZE, SIZE)[answer2-1];
        ArrayList<Integer> cardArrangement22 = new ArrayList<Integer>();
        for(int i = 0; i < SIZE; i++) {
            cardArrangement22.add(cardArrangement21[i]);
        }

        cardArrangement12.removeAll(cardArrangement22);

        if(cardArrangement12.size() == SIZE) {
            out.println("Case #" + testNumber + ": " + "Volunteer cheated!");
        }
        else if(cardArrangement12.size() == SIZE-1) {
            cardArrangement13.removeAll(cardArrangement12);
            out.println("Case #" + testNumber + ": " + cardArrangement13.get(0));
        }
        else {
            out.println("Case #" + testNumber + ": " + "Bad magician!");
        }
	}
}

class BaseIn {
    public final int DEFAULT_BUFFER_SIZE = 512;
    private static final int EOF = -1;

    private BufferedInputStream in;
    private boolean eofReached;

    /**
     * Create input stream for standard input with default buffer size
     */
    public BaseIn() {
        init(System.in, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Create an input stream from a file
     *
     * @param fileName
     * @throws java.io.IOException
     */
    public BaseIn(String fileName) {
        try {
            init(new FileInputStream(new File(fileName)), DEFAULT_BUFFER_SIZE);
        } catch (IOException ex) {
            Logger.getLogger(BaseIn.class.getName()).log(
                    Level.SEVERE, "Could not open file - " + fileName, ex);
        }
    }

    /**
     * Create an input stream from a another input stream
     *
     * @param is
     * @throws java.io.IOException
     */
    public BaseIn(InputStream is) {
        init(is, DEFAULT_BUFFER_SIZE);
    }

    private void init(InputStream is, int bufferSize) {
        in = new BufferedInputStream(is);
        eofReached = false;
    }

    /**
     * Return the next string from the input stream.
     *
     * @return
     */
    public String readString() {
        if(eofReached) throw new UnknownError("Reading from empty input stream");

        try {
            StringBuilder buffer = new StringBuilder();

            int ch = in.read();
            while(ch != EOF && Character.isWhitespace(ch)) { //skip white space chars
                ch = in.read();
            }

            while(ch != EOF && !Character.isWhitespace(ch)) {
                buffer.append((char)ch);
                ch = in.read();
            }

            if(ch == EOF) {
                eofReached = true;
                //if(buffer.length() == 0) return null;
            }

            return buffer.toString();
        }
        catch(IOException ex) {
            return null;
        }
    }

    public String next() {
        return readString();
    }

    /**
     * Read and return the next integer (32 bit) from input stream
     *
     * @return
     */
    public int readInt() {
        if(eofReached) throw new UnknownError("Reading from empty input stream");

        try {
            return Integer.parseInt(readString());
        }
        catch (NumberFormatException nfe) {
            throw new InputMismatchException(nfe.getMessage());
        }
    }

    /**
     * Read in and return the M-by-N array of ints (given M x N) from input stream
     *
     * @return
     */
    public int[][] readInt2D(int M, int N) {
        int[][] a = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                a[i][j] = readInt();
            }
        }
        return a;
    }

    }

