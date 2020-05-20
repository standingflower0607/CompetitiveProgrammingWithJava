package AtCoder.ABC.AtcoderBeginnersSelection;

import java.util.*;

public class PlacingMarbles {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        String totalStr = String.valueOf(total);
        int count = 0;
        for (int i = 0; i < totalStr.length(); i++){
            count += Character.getNumericValue(totalStr.charAt(i));
        }
        System.out.println(count);

    }
}

