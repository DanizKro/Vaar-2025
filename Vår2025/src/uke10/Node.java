package uke10;

public class Node<T> {
	
	T data;
	Node<T> neste = null;
	

	public Node(T data) {
		this.data = data;
	}
	
}