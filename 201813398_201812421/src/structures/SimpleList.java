package structures;

import java.util.Comparator;
import java.util.Iterator;

public class SimpleList<T> implements Iterable<T>{
	private Node<T> head;
	private Comparator<T> comparator;

	public SimpleList(Comparator<T> comparator){
		this.head = null;
		this.comparator = comparator;
	}

	public void insert(T data) {
		Node<T> auxNode = new Node<T>(data);
		if (head == null) {
			head = auxNode;
		} else {
			Node<T> actualNode = head;
			while (actualNode.getNext() != null) {
				actualNode = actualNode.getNext();
			}
			actualNode.setNext(auxNode);
		}
	}

	public boolean exist(T data) {
		Node<T> actualNode = head;
		if (actualNode != null) {
			while (comparator.compare(actualNode.getValue(), data) != 0) {
				if (actualNode.getNext() != null) {
					actualNode = actualNode.getNext();
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public void remove(T data) {
		Node<T> actualNode = head;
		if (exist(data)) {
			if (comparator.compare(actualNode.getValue(), data) == 0) {
				head = actualNode.getNext();
			} else {
				Node<T> previousNode = actualNode;
				while (comparator.compare(previousNode.getNext().getValue(), data) != 0) {
					previousNode = previousNode.getNext();
				}
				actualNode = previousNode.getNext().getNext();
				previousNode.setNext(actualNode);
			}
		}
	}

	public String show() {
		String listMessage = " | ";
		Node<T> actualNode = head;
		if (actualNode != null) {
			while (actualNode.getNext() != null) {
				listMessage += actualNode.getValue().toString() + " | ";
				actualNode = actualNode.getNext();
			}
			listMessage += actualNode.getValue().toString();
			return listMessage;
		} else {
			return listMessage;
		}
	}
	
	public Node<T> getNode(T data) {
		Node<T> actualNode = head;
		if (actualNode != null) {
			while (comparator.compare(actualNode.getValue(), data) != 0) {
				if (actualNode.getNext() != null) {
					actualNode = actualNode.getNext();
				} else {
					return null;
				}
			}
			return actualNode;
		} else {
			return null;
		}
	}
	
	public int showLength() {
		int lenghtList = 0;
		Node<T> actualNode = head;
		if(head == null) {
			return lenghtList;
		}else {
			lenghtList = 1;
			while(actualNode.getNext()!= null) {
				lenghtList++;
				actualNode = actualNode.getNext();
			}
			return lenghtList;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> actual = head;
			@Override
			public boolean hasNext() {
				return actual != null;
			}

			@Override
			public T next() {
				T data = actual.getValue();
				actual = actual.getNext();
				return data;
			}
		};
	}
}