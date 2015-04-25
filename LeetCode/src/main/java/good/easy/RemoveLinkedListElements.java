package good.easy;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		
		ListNode temp = head,
					pre = temp;
		while (temp != null) {
			if (temp.val == val)
				if (temp == head) {
					head = head.next; 
					temp = head;
					pre = temp;
				}
				else {
					pre.next = temp.next;
					temp = temp.next;
				}
			else {
				pre = temp;
				temp = temp.next;
			}
		}
		
		return head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
//		head.next = new ListNode(1);
//		head.next.next = new ListNode(1);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(3);
		
		ListNode result = new RemoveLinkedListElements().removeElements(head,0);
		ListNode node = result;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
			
	}
}
