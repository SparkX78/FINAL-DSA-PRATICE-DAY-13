public class CountNode {
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
    public static int CountNodes(TreeNode root){
        int rightDepth = RightDepth(root.right);
        int leftDepth = LeftDepth(root.left);
        int count = 0;
        if(rightDepth == leftDepth){
            count += (int)Math.pow(2, leftDepth+1)-1;
            return count;
        }
        else{
            return 1 + CountNodes(root.left)+ CountNodes(root.right);
        }



        
    }
    private static int RightDepth(TreeNode root){
        int depth = 0;
        while(root != null){
            depth++;
            root = root.right;
        }
        return depth;
    }
    private static int LeftDepth(TreeNode root){
        int depth = 0;
        while(root != null){
            depth++;
            root = root.left;
        }
        return depth;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        System.out.println(CountNodes(root));
    }
}
