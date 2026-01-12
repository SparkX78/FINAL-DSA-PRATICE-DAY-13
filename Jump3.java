import java.util.*;
public class Jump3 {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val = x;
            left= null;
            right = null;
        }
    }
    public static boolean jumpGame(int[] arr, int start){
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(arr[curr] == 0){
                return true;
            }
            if(arr[curr] < 0){
                continue;
            }
            if(curr + arr[curr] < arr.length)queue.add(arr[curr]+curr);
            if(curr - arr[curr] >= 0)queue.add(curr-arr[curr]);
            arr[curr] = -arr[curr];
        }
        return false;

    }
    public static void main(String[] args){
        int[] arr = {4,2,3,0,3,1,2};
        System.out.println(jumpGame(arr,5));
    }
}
