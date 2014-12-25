package easy;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical 
 * and the nodes have the same value.
 */
public class SameTree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(2);
		p.left.left = new TreeNode(4);
		p.left.right = new TreeNode(3);
		p.right.left = new TreeNode(5);
		p.right.right = new TreeNode(3);
		
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(2);
		q.left.left = new TreeNode(4);
		q.left.right = new TreeNode(3);
//		q.right.left = new TreeNode(5);
//		q.right.right = new TreeNode(3);
		System.out.println(new SameTree().isSameTree(null, null));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q) 
        	return true;
        else if (p == null || q == null)
        	return false;
        
        if (p.val == q.val) {
        	if (isSameTree(p.left, q.left))
        		return isSameTree(p.right, q.right);
        }
        
		return false;
    }
}
