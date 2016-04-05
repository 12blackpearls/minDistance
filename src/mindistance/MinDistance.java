//NLP - Minimum Edit Distance (Levenshtein) 
//By : Della Fitrayani Budiono - M0513014
package mindistance;
import static java.lang.Integer.min;
import java.util.*;
public class MinDistance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan string pertama : ");
        String sen1 = in.nextLine();
        sen1 = sen1.toLowerCase();
        System.out.println("Masukkan string kedua : ");
        String sen2 = in.nextLine();
        sen2 = sen2.toLowerCase();
        String[] arr1 = explode(sen1);
        String[] arr2 = explode(sen2);
        int x;
        String matx[][] = new String[arr1.length+2][arr2.length+2];
        x = 0;
        for(int i = arr1.length + 1; i >= 0; i--) {
            if(i == arr1.length+1) 
                matx[i][0] = " ";
            else if(i == arr1.length) 
                matx[i][0] = "0";
            else {
                matx[i][0] = arr1[x];
                x++;
            }
        }
        for(int i = 0; i < (arr2.length + 2); i++) {
            if (i==0)
                matx[arr1.length + 1][i] = " ";
            else if(i == 1)
                matx[arr1.length + 1][i] = "0";
            else 
                matx[arr1.length + 1][i] = arr2[i-2];
        }
        x = 1;
        for(int i = arr1.length; i >= 0; i--) {
            if(i == arr1.length) {
                matx[i][1] = "0";
            }
                
            else {
                matx[i][1] = Integer.toString(x);
                x++;
            }
        }
        for(int i = 0; i < (arr2.length + 1); i++) {

            if(i == 0)
                matx[arr1.length][i+1] = "0";
            else 
                matx[arr1.length][i+1] = Integer.toString(i);
        }
        
        int mir;
        for(int i = 0; i < arr2.length; i++) {
            for(int j = arr1.length; j >= 1; j--){
                if(matx[j-1][0].equals(matx[arr1.length+1][i+2])) {
                    mir = Integer.parseInt(matx[j][i+1])+0;
                }  
                else mir = Integer.parseInt(matx[j][i+1])+2;
                matx[j-1][i+2] = Integer.toString(min(min(Integer.parseInt(matx[j-1][i+1])+1,Integer.parseInt(matx[j][i+2])+1),mir));
            }
        }
        System.out.println("Minimum Edit Distance : "+matx[0][arr2.length + 1]);
    }
    
    public static String[] explode(String s) {
        String[] arr = new String[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
            arr[i] = String.valueOf(s.charAt(i));
        }
        return arr;
    }
    
}
