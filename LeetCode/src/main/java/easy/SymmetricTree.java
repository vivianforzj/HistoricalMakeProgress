package easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	//Symmetric Tree
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		TreeNode tn = new TreeNode(1);
//		tn.left = new TreeNode(2);
//		tn.right = new TreeNode(2);
////		tn.left.left = new TreeNode(4);
//		tn.left.right = new TreeNode(3);
////		tn.right.left = new TreeNode(5);
//		tn.right.right = new TreeNode(3);
//		SymmetricTree st = new SymmetricTree();
//		System.out.println(st.isSymmetric(tn));
//	}
	public final static String label = "#";
	
	public boolean isSymmetric(TreeNode root) {
		return generatedResult(root);
    }

	private boolean generatedResult(TreeNode root) {
		if (root == null) return true;
		String left = null, right = null;
		
		if(root.left != null)
			 left = getLeftString(root.left);
		else left = label;
		
		if(root.right != null)
			right = getRightString(root.right);
		else right = label;
		 
		System.out.println(left);
		System.out.println(right);
		return left.equals(right);
	}

	private String getLeftString(TreeNode left) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(left);
		String result = String.valueOf(left.val);
		
		while(!queue.isEmpty()){
			TreeNode tn = queue.poll();
			if (tn.left != null) {
				result += tn.left.val;
				queue.add(tn.left);
			} else
				result += label;
			if (tn.right != null) {
				result += tn.right.val;
				queue.add(tn.right);
			} else
				result += label;
		}
		
		return result;
	}

	private String getRightString(TreeNode right) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(right);
		String result = String.valueOf(right.val);

		while(!queue.isEmpty()){
			TreeNode tn = queue.poll();
			if (tn.right != null) {
				result += tn.right.val;
				queue.add(tn.right);
			} else
				result += label;
			if (tn.left != null) {
				result += tn.left.val;
				queue.add(tn.left);
			} else
				result += label;
		}
		
		return result;
	}
}
