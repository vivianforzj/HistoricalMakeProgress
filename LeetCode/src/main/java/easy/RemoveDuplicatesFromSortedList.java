package easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once. For example, Given 1->1->2, return 1->2. Given
 * 1->1->2->3->3, return 1->2->3.
 *
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		
		RemoveDuplicatesFromSortedList tool = new RemoveDuplicatesFromSortedList();
		ListNode result = tool.deleteDuplicates(head);
		ListNode node = result;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
			
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		
		int last = head.val;
		ListNode lastNode = head, currentNode = head.next;
		while (currentNode != null) {
			if (currentNode.val == last) {
				lastNode.next = currentNode.next;
				currentNode = lastNode.next;
			} else {
				lastNode = currentNode;
				last = lastNode.val;
				currentNode = currentNode.next;
			}
		}
		
		return head;
	}
}
