package uke10;

public class Node<T> {
	
	T data;
	Node<T> neste;
	

	public Node(T data) {
		this.data = data;
		this.neste = null;
	}
	
}