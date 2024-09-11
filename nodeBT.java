package binaryTree;

public class nodeBT<T extends Comparable<T>> {
	T value;
	nodeBT<T> left; // Referência para o filho da esquerda
	nodeBT<T> right; // Referência para filho da direita
	
	public nodeBT() {
		this.value = null;
		this.left = null;
		this.right = null;
	}
	
	public nodeBT(T value) {
		this.value = value;
	}
	
	public nodeBT(T value, nodeBT<T> left, nodeBT<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}