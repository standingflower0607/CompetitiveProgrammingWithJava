package Aizu.ALDS.ALDS1_3.A;

import java.io.*;
import java.util.*;

public class Main {
    // 要素数　最後の位置
    public static int top = 0;
    public static int[] stack = new int[200];

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        ArrayDeque<Integer> st = new ArrayDeque<>();
        String[] inputStr = sc.nextLine().split(" ");


        // stack を　使うやり方
        for(String str : inputStr){
            if(str.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a + b);
            }else if(str.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }else if(str.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a * b);
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        System.out.println(st.pop());


        // stackを再現するやり方

        /*
        for(String str : inputStr){
            if(str.equals("+")){
                int a = pop();
                int b = pop();
                push(a + b);
            }else if(str.equals("-")){
                int a = pop();
                int b = pop();
                push(b - a);
            }else if(str.equals("*")){
                int a = pop();
                int b = pop();
                push(a * b);
            }else{
                push(Integer.parseInt(str));
            }
        }
        System.out.println(pop());

         */



    }
    public static void push(int x){
        top++;
        stack[top] = x;
    }
    public static int pop(){
        top--;
        return stack[top+1];
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

        public long nextInt() {
            return Integer.parseInt(next());
        }

    }
}