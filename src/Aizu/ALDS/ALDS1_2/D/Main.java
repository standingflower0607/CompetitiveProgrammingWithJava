package Aizu.ALDS.ALDS1_2.D;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Main {
    public static int cnt = 0;
    public static LinkedList<Integer> G = new LinkedList<>();
    public static void main(String[] args){
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++) array[i] = sc.nextInt();
        int[] result = shellSort(array, n);
        System.out.println(G.size());
        System.out.println(parseArray(G));
        System.out.println(cnt);
        for(int num : result){
            System.out.println(num);
        }

    }

    public static int[] insertionSort(int[] array, int n, int g){
        for(int i=g; i<n; i += g){
            int v = array[i];
            int j = i - g;
            while (j >= 0 && array[j] > v){
                array[j + g] = array[j];
                j -= g;
                array[j + g] = v;
                cnt++;
            }
        }

        return array;
    }

    public static int[] shellSort(int[] array, int n){
        // 数列gを作る
        for(int i=0; i<n; i++){

            int h = 3*i + 1;
            if(h > n) break;
            G.addFirst(h);
        }
        cnt = 0;

        for(int i= G.size()-1; i >=0; i--){
            int g = G.get(i);
            insertionSort(array, n, g);
        }
        return array;
    }
    static String parseArray(int[] array){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<array.length; i++){
            if(i > 0) builder.append(" ");
            builder.append(array[i]);
        }
        return builder.toString();
    }
    static String parseArray(List<Integer> array){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<array.size(); i++){
            if(i > 0) builder.append(" ");
            builder.append(array.get(i));
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