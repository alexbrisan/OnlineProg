import java.io.*;
import java.util.*;

public class NewYear {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = Integer.parseInt(stdin.nextLine());
        List<String> res = new ArrayList<>();
        for(int i =0 ; i < N ; ++i){
            int k = Integer.parseInt(stdin.nextLine());
            int[] arr = new int[k];
            String raw_row = stdin.nextLine();
            
            String[] row = raw_row.split("\\s+");

            if(row.length != k) { System.out.println("INCONSISTENCY") ; return;}
            for(int j =0  ; j < row.length ; ++j){
                arr[j] = Integer.parseInt(row[j]);
            }
            int res1 = comparison_sort(arr);
            if(res1 == -1) res.add("Too chaotic");
            else res.add(String.valueOf(res1));
        }
        for(String s : res){
            System.out.println(s);
        }
    }
    public static int comparison_sort(int[] arr){
        int swaps = 0;
        Map<Integer, Integer> res = new HashMap<>();
        while(!is_sorted(arr)){
            for(int i = 0 ; i < arr.length - 1 ; ++i){
                if(arr[i] > arr[i+1]){
                    Integer j = res.get(arr[i]);
                    if(j==null) res.put(arr[i],1);
                    else if(j == 2) return -1;
                    else res.put(arr[i],j+1);
                    int cop = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = cop;
                    ++swaps;
                }
            }
        }
        return swaps;
    }
    public static boolean is_sorted(int[] arr){
        for(int i = 0 ; i < arr.length - 1; ++i){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}
