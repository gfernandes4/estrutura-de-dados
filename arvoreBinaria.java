package binaryTree;

import java.util.Random;

public class arvoreBinaria<T extends Comparable<T>> {

	protected nodeBT<T> root;
	private static Random rand = new Random();

	public arvoreBinaria() {
		this.root = null;
	}

	public void randomInsertion(T val) {

		boolean inserted = false; // Guarda se fizemos a inserção

		// Raiz nula
		if (root == null) {
			root = new nodeBT<T>(val);
		}

		// Raiz não nula
		else {
			nodeBT<T> aux = root;
			// Percorre enquanto não encontra a posição de inserção
			while (!inserted) {
				// Se próximo boolean for verdadeiro, procura à esquerda
				if (rand.nextBoolean()) {
					// Se nó à esquerda for nulo, insere
					if (aux.left == null) {
						aux.left = new nodeBT<T>(val);
						inserted = true;
					}
					// Senão: se nó à esquerda não for nulo
					else {
						aux = aux.left;
					}
				}
				// Senão: desço à direita
				else {
					// Se nó à direita for nulo, insere
					if (aux.right == null) {
						aux.right = new nodeBT<T>(val);
						inserted = true;
					}
					// Senão: se nó à direita não for nulo
					else {
						aux = aux.right;
					}
				}
			}
		}
	}

	public boolean search(T val) {
		return search(root, val);
	}

	private boolean search(nodeBT<T> node, T val) {
		// Se o nó for nulo, o valor não está aqui
		if (node == null)
			return false;

		// Se o valor estiver no nó, retorna verdadeiro
		if (node.value.equals(val))
			return true;

		// Busca à esquerda
		if (search(node.left, val))
			return true;

		// Busca à direita
		if (search(node.right, val))
			return true;

		return false;
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		if (root == null) {
			out.append("<null>\n");
		} else {
			toString(root.right, "", false, out);
			out.append(root.value.toString() + "\n");
			toString(root.left, "", true, out);
			out.append("\n");
		}
		return out.toString();
	}

	private void toString(nodeBT<T> node, String prefix, boolean leftChild, StringBuilder out) {
		if (node == null)
			return;

		if (leftChild) {
			toString(node.right, prefix + "| ", false, out);
			out.append(prefix + "|>" + node.value.toString() + "\n");
			toString(node.left, prefix + "  ", true, out);
		} else {
			toString(node.right, prefix + "  ", false, out);
			out.append(prefix + "|>" + node.value.toString() + "\n");
			toString(node.left, prefix + "| ", true, out);
		}
	}

	public void insertMultiple(T[] values) {
		for (int i = 0; i < values.length; i++)
			randomInsertion(values[i]);
	}

	public int height() {
		return height(root);
	}

	public int height(nodeBT<T> node) {
		if (node == null) {
			return -1;
		} else {
			return Math.max(height(node.left), height(node.right)) + 1;
		}
	}

	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(nodeBT<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + countNodes(node.left) + countNodes(node.right);
		}
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(nodeBT<T> node) {
		if(node == null){
			return true;
		}

		int direita = height(root.right);
		int esquerda = height(root.left);
		int continha = Math.abs(direita - esquerda);

		if (continha > 1) {
			return false;
		}
		return isBalanced(node.left) && isBalanced(node.right);
	}

	public T findMin() {
		return findMin(root);
	}

	private T findMin(nodeBT<T> node) {
		if (node == null) {
			return null;
		}

		T minValue = node.value;
		T esqMin = findMin(node.left);
		T dirMin = findMin(node.right);

		if (esqMin != null && esqMin.compareTo(minValue) < 0) // retorna um numero negativo se esqMin < minValue
			minValue = esqMin;
		if (dirMin != null && dirMin.compareTo(minValue) < 0) // Retorna um numero negativo se dirMin < minValue
			minValue = dirMin;
		

		return minValue;
	}

	public T findMax() {
		if (root == null) {
			throw new IllegalStateException("A árvore está vazia");
		}
		return findMax(root);
	}

	private T findMax(nodeBT<T> node) {
		if (node == null) {
			return null;
		}

		T maxValue = node.value;
		T leftMax = findMax(node.left); // Percorre a subárvore esquerda
		T rightMax = findMax(node.right); // Percorre a subárvore direita

		// Compara e atualiza o valor máximo usando compareTo
		if (leftMax != null && leftMax.compareTo(maxValue) > 0) // Retorna um valor positivo se leftMax > maxValue
			maxValue = leftMax;
		
		if (rightMax != null && rightMax.compareTo(maxValue) > 0) // Retorna um valor positivo se leftMax > maxValue
			maxValue = rightMax;
		

		return maxValue;
	}

}