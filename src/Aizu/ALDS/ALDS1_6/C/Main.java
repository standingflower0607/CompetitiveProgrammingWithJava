package Aizu.ALDS.ALDS1_6.C;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 100000;
    private static final int SENTINEL = 2000000000; // 番兵
    private static Card[] L = new Card[MAX/2+2];
    private static Card[] R = new Card[MAX/2+2];

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        Card[] A = new Card[n];
        Card[] B = new Card[n];
        boolean stable = true;
        for(int i=0; i<n; i++){
            A[i] = B[i] = new Card(sc.next().charAt(0), sc.nextInt());
        }

        mergeSort(A, n, 0, n);
        quickSort(B, n, 0, n-1);
        for(int i=0; i<n; i++){
            if(A[i].suit != B[i].suit) stable = false;
        }

        if(stable) out.println("Stable");
        else out.println("Not stable");
        for(int i=0; i<n; i++){
            out.printf("%s %d\n", B[i].suit, B[i].value);
        }
        out.flush();
    }
    static class Card{
        private char suit = 'A';
        private int value = 0;

        public Card(char suit, int value){
            this.suit = suit;
            this.value = value;
        }

        public String toString(){
            return this.suit + " " + this.value;
        }
    }

    static void merge(Card A[],int n, int left, int mid, int right){
        int n1 = mid - left;
        int n2 = right - mid;
        for (int i=0; i<n1; i++) L[i] = A[left + i];
        for(int i=0; i<n2; i++) R[i] = A[mid + i];
        L[n1] = R[n2] = new Card('A', SENTINEL);
        // L[n1].value = R[n2].value = SENTINEL;
        int i = 0;
        int j = 0;
        for(int k=left; k<right; k++){
            // 比較回数を計算
            // 小さい方を元の配列に格納する
            if(L[i].value <= R[j].value){
                A[k] = L[i++];
            }else{
                A[k] = R[j++];
            }
        }
    }
    static void mergeSort(Card A[], int n, int left, int right){
        // left と right の　差が 1 より上だったら
        if(left+1 < right){
            int mid = (left + right)/2;
            mergeSort(A, n, left ,mid);
            mergeSort(A, n, mid, right);
            merge(A, n, left, mid, right);
        }
    }

    static void quickSort(Card A[], int n, int p, int r){
        int q;
        if(p < r){
            q = partition(A, n, p, r);
            quickSort(A,n,p,q-1);
            quickSort(A,n,q+1,r);
        }
    }


    static int partition(Card A[], int n, int p, int r){
        Card x = A[r];
        int i = p - 1;
        Card t;
        for(int j=p; j<r; j++){
            if (A[j].value <= x.value) {
                i++;
                // swap
                t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
            // 大きかったらjを1進めるだけで良い
        }
        // swap
        t = A[i+1];
        A[i+1] = A[r];
        A[r] = t;
        return i+1;
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