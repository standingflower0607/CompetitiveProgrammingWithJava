package AtcoderBeginnersSelection.ABC086C_Traveling;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args){
        var sc = new FastScanner();
        int n = sc.nextInt();
        String result = "Yes";
        int[] tArray = new int[n+1];
        int[] xArray = new int[n+1];
        int[] yArray = new int[n+1];

        tArray[0] = 0;
        xArray[0] = 0;
        yArray[0] = 0;

        for(int i=1; i<=n; i++){
            tArray[i] = sc.nextInt();
            xArray[i] = sc.nextInt();
            yArray[i] = sc.nextInt();
        }


        for(int j = 1; j <= n ; j++){

            int tDifference = tArray[j] - tArray[j - 1];
            int yDifference = yArray[j] - yArray[j - 1];
            int xDifference = xArray[j] - xArray[j - 1];

            // tの偶奇と座標の和x+yは必ず一致する
            if(tArray[j] % 2 != Math.abs(xArray[j] + yArray[j]) % 2){
                result = "No";
                break;
            }
            // xとyの移動距離の合計が、移動回数よりも大きければno
            int absTotal = Math.abs(xDifference) + Math.abs(yDifference);
            if(absTotal > tDifference){
                result = "No";
                break;
            }

        }
        System.out.println(result);

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
