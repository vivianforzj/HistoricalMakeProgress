package good.easy;

public class LinkedListReverser {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(3);
		
		ListNode result = new LinkedListReverser().reverseList(head);
		ListNode node = result;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}

	}

	 public ListNode reverseList(ListNode head) {
		 if (head == null)
			 return head;
		 
		 ListNode first = head;
		 ListNode next = head.next;
		 while (next != null) {
			 ListNode temp = next.next;
			 next.next = head;
			 head = next;
			 next = temp;
		 }
		 first.next = null;
		 
		 return head;
	  }
}
