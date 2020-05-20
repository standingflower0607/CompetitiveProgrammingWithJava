package AtCoder.ABC.ABC057.B;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args){
        FastScanner sc = new FastScanner();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] coordinatesN = new int[N][2];
        int[][] coordinatesM = new int[M][2];
        int[] results = new int[N];
        // System.out.println(N + " : " + M);

        for(int i=0; i<N; i++){
           coordinatesN[i][0] = sc.nextInt();
           coordinatesN[i][1] = sc.nextInt();
        }
        // System.out.println(Arrays.deepToString(coordinatesN));
        for(int j=0; j<M; j++){
            coordinatesM[j][0] = sc.nextInt();
            coordinatesM[j][1] = sc.nextInt();
        }
        // System.out.println(Arrays.deepToString(coordinatesM));
        for(int i=0; i<N; i++){
            long min = 400000001;
            int[] coordinateN = coordinatesN[i];
            int xN = coordinateN[0];
            int yN = coordinateN[1];
            int distance = 0;
            for(int j=0; j<M; j++){
                int[] coordinateM = coordinatesM[j];
                int xM = coordinateM[0];
                int yM = coordinateM[1];
                distance = Math.abs(xN -xM) + Math.abs(yN - yM);
                // System.out.println("distance : " + distance);
                if(min > distance) {
                    results[i] = j + 1;
                    min = distance;
                }
            }

        }
        for(int result : results) System.out.println(result);

    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            }else{
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while(true){
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                }else if(b == -1 || !isPrintableChar(b)){
                    return minus ? -n : n;
                }else{
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }
        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }
        public double nextDouble() { return Double.parseDouble(next());}
    }
}