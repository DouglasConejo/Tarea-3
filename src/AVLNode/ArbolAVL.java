package AVLNode;

import Node.Node;

public class ArbolAVL {

   public Node root;

    // Rotación simple a la derecha
    Node rightRotate(Node y) {
        Node x = y.getIzquierdo();
        Node t2 = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(t2);

        y.setAltura(Math.max(height(y.getIzquierdo()), height(y.getDerecho())) + 1);
        x.setAltura(Math.max(height(x.getIzquierdo()), height(x.getDerecho())) + 1);

        return x;
    }

    // Rotación simple a la izquierda
    Node leftRotate(Node x) {
        Node y = x.getDerecho();
        Node t2 = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(t2);

        x.setAltura(Math.max(height(x.getIzquierdo()), height(x.getDerecho())) + 1);
        y.setAltura(Math.max(height(y.getIzquierdo()), height(y.getDerecho())) + 1);

        return y;
    }

    // Rotación doble a la derecha
    Node doubleRightRotate(Node y) {
        y.setDerecho(leftRotate(y.getDerecho()));
        return rightRotate(y);
    }

    // Obtener la altura de un nodo
    int height(Node node) {
        if (node == null)
            return 0;
        return node.getAltura();
    }

    // Insertar un nuevo nodo en el árbol AVL
    public Node insert(Node node, int val) {
        if (node == null)
            return new Node(val);

        if (val < node.getValor())
            node.setIzquierdo(insert(node.getIzquierdo(), val));
        else if (val > node.getValor())
        node.setDerecho(insert(node.getDerecho(), val));
        else
            return node;

        /****/  node.setAltura(1 + Math.max(height(node.getIzquierdo()), height(node.getDerecho())));

        int balance = getBalance(node);

        // Casos de rotación
        if (balance > 1 && val < node.getIzquierdo().getValor())
            return rightRotate(node);
        if (balance < -1 && val > node.getDerecho().getValor())
            return leftRotate(node);
        if (balance > 1 && val > node.getDerecho().getValor())
            return doubleRightRotate(node);

        return node;
    }

    // Obtener el balance de un nodo
    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.getIzquierdo()) - height(node.getDerecho());
    }
}


