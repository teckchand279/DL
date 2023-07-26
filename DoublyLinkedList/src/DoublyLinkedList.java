
public class DoublyLinkedList {

	static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node() {
			data = 0;
			next = null;
			prev = null;
		}

		public Node(int value) {
			data = value;
			next = null;
			prev = null;
		}
	}

	private Node head;
	private Node tail;
	private int count;

	public DoublyLinkedList() {
		head = tail = null;
		count = 0;
	}

	public boolean isEmpty() {
		return head == null && tail == null;
	}

	public int getSize() {
		return count;
	}

	public void displayForward() {

		Node trav = head;
		System.out.print("Fwd List : ");
		while (trav != null) {

			System.out.print(" " + trav.data);

			trav = trav.next;
		}
		System.out.println("");
	}

	public void displayReverse() {

		Node trav = tail;
		System.out.print("Rev List : ");
		while (trav != null) {

			System.out.print(" " + trav.data);

			trav = trav.prev;
		}
		System.out.println("");
	}

	public void addFirst(int value) {

		Node nn = new Node(value);

		if (isEmpty())

			head = tail = nn;

		else {

			nn.next = head;

			head.prev = nn;

			head = nn;
		}

		count++;
	}

	public void addLast(int value) {

		Node nn = new Node(value);

		if (isEmpty())

			head = tail = nn;

		else {

			nn.prev = tail;

			tail.next = nn;

			tail = nn;
		}

		count++;
	}

	public void addPos(int value, int pos) {
		if (pos <= 0 || pos > count + 1)
			return;
		else if (pos == 1) {
			addFirst(value);
			return;
		} else if (pos == count + 1) {
			addLast(value);
			return;
		}

		Node nn = new Node(value);

		if (isEmpty())

			head = tail = nn;

		else {

			Node trav = head;
			int i = 1;
			while (i++ < pos - 1)
				trav = trav.next;

			nn.prev = trav;

			nn.next = trav.next;

			trav.next = nn;

			nn.next.prev = nn;
		}

		count++;
	}

	public void delAll() {
		head = tail = null;
	}

	public void delFirst() {

		if (isEmpty())
			return;
		else if (head.next == null)

			head = tail = null;

		else {

			head = head.next;

			head.prev = null;
		}

		count--;
	}

	public void delLast() {

		if (isEmpty())
			return;
		else if (head.next == null)

			head = tail = null;

		else {

			tail = tail.prev;

			tail.next = null;
		}

		count--;
	}

	public void delPos(int pos) {

		if (isEmpty())

			return;

		else if (head.next == null)

			head = tail = null;

		else {

			Node trav = head;
			int i = 1;
			while (i++ < pos)
				trav = trav.next;

			trav.prev.next = trav.next;

			trav.next.prev = trav.prev;
		}

		count--;
	}

}
