package Aizu.ALDS.ALDS1_5.C;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        Point a = new Point();
        Point b = new Point();
        a.x = 0;
        a.y = 0;
        b.x = 100;
        b.y = 0;
        System.out.printf("%.8f %.8f\n", a.x, a.y);
        koch(n, a, b);
        System.out.printf("%.8f %.8f\n", b.x, b.y);

    }

    static void koch(int n, Point a, Point b){
        if( n == 0 )return;
        Point s = new Point();
        Point t = new Point();
        Point u = new Point();
        double th = Math.toRadians(60);

        s.x = (2.0 * a.x + 1.0 * b.x) / 3.0; // (a.x + b.x) * ３分の２
        s.y = (2.0 * a.y + 1.0 * b.y) / 3.0;
        t.x = (1.0* a.x + 2.0*b.x) / 3.0;
        t.y = (1.0*a.y + 2.0*b.y)/3.0;
        u.x = (t.x - s.x)*Math.cos(th) - (t.y - s.y)*Math.sin(th) + s.x;
        u.y = (t.y - s.y)*Math.cos(th) + (t.x - s.x)*Math.sin(th) + s.y;

        koch(n-1,a,s);
        System.out.printf("%.8f %.8f\n", s.x, s.y);
        koch(n-1,s,u);
        System.out.printf("%.8f %.8f\n", u.x, u.y);
        koch(n-1,u,t);
        System.out.printf("%.8f %.8f\n", t.x, t.y);
        koch(n-1,t,b);
    }

    static class Point{
        private double x;
        private double y;
    }

    static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return tokenizer.nextToken("\n");
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}