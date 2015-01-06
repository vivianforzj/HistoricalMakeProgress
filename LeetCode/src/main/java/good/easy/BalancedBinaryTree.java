package good.easy;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
//		tn.right = new TreeNode(2);
		tn.left.left = new TreeNode(4);
//		tn.left.right = new TreeNode(3);
//		tn.right.left = new TreeNode(5);
//		tn.right.right = new TreeNode(3);
		tn.left.left.left = new TreeNode(4);
		tn.left.left.left.left = new TreeNode(4);
		System.out.println(new BalancedBinaryTree().isBalanced(tn));
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		
		if (Math.abs(depth(root.left) - depth(root.right)) > 1)
			return false;
		
		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int depth(TreeNode node) {
		if (node == null)
		return 0;
		
		return Math.max(depth(node.left), depth(node.right)) + 1;
	}

}
