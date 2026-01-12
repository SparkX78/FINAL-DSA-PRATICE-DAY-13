public class MaxBinary {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }
    public static TreeNode MaxBinaryTree(int[] arr){
        if(arr == null){
            return null;
        }
        return build(arr, 0, arr.length-1);

    }
    private static TreeNode build(int[] arr, int start, int end){
        if(start > end)return null;
        int Max = start;
        for(int i = start+1; i <= end; i++ ){
            if(arr[i] > arr[Max]){
                Max = i;
            }
        }
        TreeNode node = new TreeNode(arr[Max]);
        node.left = build(arr, start, Max-1);
        node.right = build(arr, Max+1, end);
        return node;

    }
    public static void preorder(TreeNode root){
        if(root == null)return ;
        System.out.println(root.val+" ");
        preorder(root.left);
        preorder(root.right);

        
    }
    public static void main(String[] args){
        int[] arr = {2,1,6,3,7,5,4,0};
        TreeNode root = MaxBinaryTree(arr);
        preorder(root);
    }
}
