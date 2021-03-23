package structures;

import java.util.Comparator;
import java.util.Iterator;

public class DoubleList<T> implements Iterable<T> {
	private Node<T> head;
	private Comparator<T> comparator;
	private Comparator<T> orderComparator;

	public DoubleList(Comparator<T> comparator, Comparator<T> orderComparator) {
		this.head = null;
		this.comparator = comparator;
		this.orderComparator = orderComparator;
	}

	public void insertInOrder(T data) {
		Node<T> auxNode = new Node<T>(data);
		if (head == null) {
			head = auxNode;
			head.setPrevious(null);
		} else if (orderComparator.compare(head.getValue(), data) == 1) {
			validateChangeHead(auxNode);
		} else {
			orderNumbers(data, auxNode);
		}
	}

	private void validateChangeHead(Node<T> auxNode) {
		Node<T> auxHead = head;
		head = auxNode;
		head.setPrevious(null);
		head.setNext(auxHead);
		auxHead.setPrevious(head);
	}

	private void orderNumbers(T data, Node<T> auxNode) {
		Node<T> actualNode = head;
		boolean dataCompare = true;
		while (actualNode.getNext() != null && dataCompare) {
			if (orderComparator.compare(actualNode.getValue(), data) == 1) {
				actualNode = actualNode.getPrevious();
				auxNode.setNext(actualNode.getNext());
				auxNode.setPrevious(actualNode);
				actualNode.setNext(auxNode);
				actualNode.getNext().getNext().setPrevious(auxNode);
				dataCompare = false;
				actualNode = actualNode.getNext().getNext();
			} else {
				actualNode = actualNode.getNext();
			}
		}
		validateLastNode(data, auxNode, actualNode, dataCompare);
	}

	private void validateLastNode(T data, Node<T> auxNode, Node<T> actualNode, boolean dataCompare) {
		if (orderComparator.compare(actualNode.getValue(), data) == 1 && dataCompare) {
			actualNode = actualNode.getPrevious();
			auxNode.setNext(actualNode.getNext());
			auxNode.setPrevious(actualNode);
			actualNode.setNext(auxNode);
			actualNode.getNext().getNext().setPrevious(auxNode);
			dataCompare = false;
			actualNode = actualNode.getNext().getNext();
		} else if (dataCompare) {
			actualNode.setNext(auxNode);
			auxNode.setPrevious(actualNode);
		}
	}

	public void insert(T data) {
		Node<T> auxNode = new Node<T>(data);
		if (head == null) {
			head = auxNode;
			head.setPrevious(null);
		} else {
			Node<T> actualNode = head;
			while (actualNode.getNext() != null) {
				actualNode = actualNode.getNext();
			}
			actualNode.setNext(auxNode);
			auxNode.setPrevious(actualNode);
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
				Node<T> previousNode = head;
				while (comparator.compare(previousNode.getNext().getValue(), data) != 0) {
					previousNode = previousNode.getNext();
				}
				actualNode = previousNode.getNext().getNext();
				if (actualNode != null) {
					actualNode.setPrevious(previousNode);
				}
				previousNode.setNext(actualNode);
			}
		}
	}

	public String showForward() {
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

	public String showBackward() {
		String listMessage = " | ";
		Node<T> actualNode = head;
		if (actualNode != null) {
			while (actualNode.getNext() != null) {
				actualNode = actualNode.getNext();
			}
			while (actualNode.getPrevious() != null) {
				listMessage += actualNode.getValue().toString() + " | ";
				actualNode = actualNode.getPrevious();
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

	public int lengthDoubleList() {
		int lenghtList = 0;
		Node<T> actualNode = head;
		if (head == null) {
			return lenghtList;
		} else {
			lenghtList = 1;
			while (actualNode.getNext() != null) {
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