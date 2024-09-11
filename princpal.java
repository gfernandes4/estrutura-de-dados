package binaryTree;

public class princpal {
    public static void main(String[] args) {
        arvoreBinaria<Integer> newTree = new arvoreBinaria<>();

        Integer[] vector = {4, 3, 1, 5, 6, 10, 9, 100};

        newTree.insertMultiple(vector);
        

        System.out.println(newTree);
        System.out.println("Balanceado: " + newTree.isBalanced());
        System.out.println("Altura:" + newTree.height());
        System.out.println("QTD Nós:" + newTree.countNodes());
        System.out.println("Maior valor: " + newTree.findMax());
        System.out.println("menor valor: " + newTree.findMin
        ());

    }

}
