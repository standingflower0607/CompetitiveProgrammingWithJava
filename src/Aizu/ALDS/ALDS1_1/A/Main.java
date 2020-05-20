package Aizu.ALDS.ALDS1_1.A;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
// insertion sort
public class Main {
    public static void main(String[] args){
        FastScanner sc = new FastScanner();
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i=0; i<N; i++){
            array[i] = sc.nextInt();
        }
        System.out.println(parseArray(array));
        for(int i=1; i<N; i++){

            int v = array[i];
            int j = i -1;
            while (j >= 0 && array[j] > v){
                array[j + 1] = array[j];
                j--;
                array[j + 1] = v;
            }
            System.out.println(parseArray(array));
        }

    }

    static String parseArray(int[] array){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<array.length; i++){
            if(i > 0) builder.append(" ");
            builder.append(array[i]);
        }
        return builder.toString();
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