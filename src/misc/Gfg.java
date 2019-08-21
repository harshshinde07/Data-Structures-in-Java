import java.util.*;
import java.lang.*;
import java.io.*;

public class Gfg {
    public static String print(long val) {
        if(val == 0) {
            return "";
        } else {
            return print((val-1)/26)+(char)((val-1)%26+'A');
        }
    }
    public static void main(String args[]) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        Scanner in  = new Scanner(System.in);
        long n = in.nextLong();
        for(int i = 0; i < n; i++) {
            long  val = in.nextLong();
            System.out.println(print(val));
        }
    }
}
