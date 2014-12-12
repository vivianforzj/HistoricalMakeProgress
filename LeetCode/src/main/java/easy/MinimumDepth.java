package easy;

/**
 * Given a binary tree, find its minimum depth. The minimum depth is the number
 * of nodes along the shortest path from the root node down to the nearest leaf
 * node.
 *
 */
public class MinimumDepth {

	int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(2);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(3);
		tn.right.left = new TreeNode(5);
		tn.right.right = new TreeNode(3);
		System.out.println(new MinimumDepth().minDepth(tn));
	}

	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int[] temp = new int[2];
		if (root.left == null && root.right == null) return 1;
		else if (root.left == null && root.right != null) {
			return 1 + minDepth(root.right);
		} else if (root.left != null && root.right == null) {
			return 1 + minDepth(root.left);
		}else {
			temp[0] = 1 + minDepth(root.left);
			temp[1] = 1 + minDepth(root.right);
			return temp[0] < temp[1] ? temp[0] : temp[1];
		} 
	}

}
