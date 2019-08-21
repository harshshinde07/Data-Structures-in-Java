import java.util.*;
import java.util.stream.IntStream;
public class Solution {

//    public int solution(String S) {
//        // write your code in Java SE 8
//        String []arr = S.trim().split(" ");
//
//        Stack<String> stack = new Stack<>();
//        for(String s : arr) {
//            System.out.println(s);
//            if(s.matches("[0-9]+")) {
//                System.out.println("Pushing: "+s);
//                stack.push(s);
//            } else {
//                switch (s) {
//                    case "DUP":
//                        System.out.println("Add result: ");
//                        if(stack.empty()) {
//                            return -1;
//                        }else {
//                            String top = stack.peek();
//                            System.out.println("duplicating: "+top);
//                            stack.push(top);
//                        }
//                        break;
//                    case "POP":
//                        if(stack.empty()) {
//                            return -1;
//                        }else {
//                            String val = stack.pop();
//                            System.out.println("Popping: "+val);
//                        }
//                        break;
//                    case "+":
//                        if(stack.size() >= 2) {
//                            String first = stack.pop();
//                            System.out.println("Popping 1: "+first);
//                            String second = stack.pop();
//                            System.out.println("Popping 2: "+second);
//                            int firstVal = Integer.parseInt(first);
//                            int secondVal = Integer.parseInt(second);
//                            int result = firstVal + secondVal;
//                            System.out.println("Add result: "+result);
//                            stack.push(String.valueOf(result));
//                        } else {
//                            return -1;
//                        }
//                        break;
//                    case "-":
//                        if(stack.size() >= 2) {
//                            String first = stack.pop();
//                            System.out.println("Popping 1: "+first);
//                            String second = stack.pop();
//                            System.out.println("Popping 2: "+second);
//                            int firstVal = Integer.parseInt(first);
//                            int secondVal = Integer.parseInt(second);
//                            int result = firstVal - secondVal;
//                            System.out.println("Add result: "+result);
//                            if(result <0)
//                                return -1;
//                            else
//                                stack.push(String.valueOf(result));
//                        } else {
//                            return -1;
//                        }
//                        break;
//                        default:
//                            System.out.println("Error");
//                }
//            }
//
//        }
//        if(stack.empty()) {
//            return -1;
//        } else {
//            String top = stack.pop();
//            System.out.println("Returning: "+top);
//            return Integer.parseInt(top);
//        }
//    }

    public int solution(int[] A) {
        // write your code in Java SE 8
//        int[] diff = IntStream.range(0, A.length - 1).map(i->A[i]-A[i+1]).toArray();
        int[] diff = new int[A.length-1];
        for(int i = 0; i < A.length - 1; i++) {
            diff[i] = A[i] - A[i+1];
        }
        int first = diff[0];
        int start = 0, total = 0;

        for(int i = 0; i < diff.length; i++) {
            if(diff[i] != first) {
                if(i - start > 1) {
                    int n = i - start;
                    total += n*(n-1)/2;
                }
                start = i;
                first = diff[start];
            }
        }
        if(start + 1 < diff.length) {
            int n = diff.length - start;
            total += n*(n-1)/2;
        }
        return total;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int [] arr = {-1, 1, 3, 3, 3,2,3,2,1,0};
        int reu = s.solution(arr);
        System.out.println(reu);
    }
}
