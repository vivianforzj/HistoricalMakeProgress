package good.easy;

public class PathSum {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
//		tn.right = new TreeNode(8);
//		tn.left.left = new TreeNode(11);
//		tn.left.left.left = new TreeNode(7);
//		tn.left.left.right = new TreeNode(3);
//		tn.right.left = new TreeNode(13);
//		tn.right.right = new TreeNode(4);
//		tn.right.right.right = new TreeNode(1);
		System.out.println(new PathSum().hasPathSum(tn, 1));
	}

	 public boolean hasPathSum(TreeNode root, int sum) {
		 if(root == null) return false;
		 if (root.left == null && root.right == null)
				if (sum == root.val)
					return true;
				else return false;
			 if (root.left != null &&hasPathSum(root.left, sum - root.val))
				 return true;
			 else if (root.right != null)
			 	return hasPathSum(root.right, sum - root.val);
			 return false;
		 
	 }

}
