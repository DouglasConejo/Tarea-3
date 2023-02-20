package UI;

import AVLNode.ArbolAVL;
import Node.Node;

public class Main {
    public static void main(String[] args) {
        ArbolAVL tree = new ArbolAVL();

        tree.root = tree.insert(tree.root, 100);
        tree.root = tree.insert(tree.root, 80);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 20);
       // tree.root = tree.insert(tree.root, 30);
      //  tree.root = tree.insert(tree.root, 40);
        //tree.root = tree.insert(tree.root, 50);
        //tree.root = tree.insert(tree.root, 25);

        System.out.println("Árbol AVL:");
        printInorder(tree.root);
    }

    // Recorrer el árbol en orden
    public static void printInorder(Node node) {
        if (node == null)
            return;

        printInorder(node.getIzquierdo());
        System.out.print(node.getValor() + " ");
        printInorder(node.getDerecho());
    }
}