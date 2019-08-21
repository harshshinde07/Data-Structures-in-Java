import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

// using keySet() for iteration over keys
//        for (String name : gfg.keySet())
//        System.out.println("key: " + name);

// using values() for iteration over keys
//        for (String url : gfg.values())
//        System.out.println("value: " + url);

// forEach(action) method to iterate map
//        gfg.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));

public class Hashmap {

    public static int countOccurrences(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        str = str.toLowerCase();
        int retVal = 0;
        char[] arr = str.toCharArray();
        for (char a : arr) {
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
//        int res = 0;
//        if(map.containsKey(c))
//            res = map.get(c);
//        return res;

        for(char a: map.keySet()) {
            int res = map.get(a);
            if (checkPrime(res)) {
                retVal += res;
            }
        }

        return retVal;
    }

    public static boolean checkPrime(int val) {
        if (val < 2)
            return false;
        if (val == 2)
            return true;
        if(val % 2 == 0)
            return false;
        for (int i = 3; i < Math.sqrt(val); i += 2) {
            if (val % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        String input = br.readLine();
//        char val = in.next().charAt(0);
//        System.out.println(countOccurrences(input, val));
        System.out.println(countOccurrences(input));
    }
}
