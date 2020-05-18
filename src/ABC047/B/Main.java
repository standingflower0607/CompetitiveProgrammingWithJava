package ABC047.B;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args){
        FastScanner sc = new FastScanner();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();
        int[][] details = new int[n][3];
        int area = w * h;
        int whiteArea = 0;
        int blackArea = 0;
        int maxX = w;
        int maxY = h;
        int minX = 0;
        int minY = 0;


        for(int i=0; i<n; i++){
            int[] detail = new int[3];
            detail[0] = sc.nextInt();
            detail[1] = sc.nextInt();
            detail[2] = sc.nextInt();
            details[i] = detail;
        }
        for(int[] detail : details){
            int x = detail[0];
            int y = detail[1];
            int a = detail[2];
            int xDiffrence = maxX - minX;
            int yDiffrence = maxY - minY;
            if(a == 1){
                if(x > minX) {
                    blackArea += (x - minX)*yDiffrence;
                    minX = Math.max(x, minX);
                }

            }else if(a == 2){
                if(x < maxX) {
                    blackArea += (maxX - x) * yDiffrence;
                    maxX = Math.min(x, maxX);
                }

            }else if(a == 3){
                if(y > minY) {
                    blackArea += xDiffrence*(y - minY);
                    minY = Math.max(y, minY);
                }

            }else if(a == 4){
                if(y < maxY) {
                    blackArea += xDiffrence*(maxY - y);
                    maxY = Math.min(y, maxY);
                }
            }else{

            }


            System.out.println(String.format("xDiffrence = %d", xDiffrence));
            System.out.println(String.format("yDifference = %d", yDiffrence));
            System.out.println(String.format("blackarea = %d", blackArea));


        }
        whiteArea = area - blackArea;
        System.out.println(whiteArea);

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

