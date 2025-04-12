
import java.util.Scanner;

class NosInternos {
    public static void main(String[] args) {
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        int[] numeros = new int[sequencia.length];
        for (int i = 0; i < sequencia.length; i++) {
            bst.add(Integer.parseInt(sequencia[i]));
        }
        System.out.println(bst.contaNosInternos());

        sc.close();
    }
}

class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int valor) {

        if (isEmpty()) {
            this.root = new Node(valor);
            return;
        }
        Node aux = this.root;
        while (aux != null) {
            if (valor > aux.valor) {
                if (aux.right == null) {
                    aux.right = new Node(valor);
                    return;
                }
                aux = aux.right;
            }
            if (valor < aux.valor) {
                if (aux.left == null) {
                    aux.left = new Node(valor);
                    return;
                }
                aux = aux.left;

            }
        }

    }

    public int contaNosInternos() {
        return contaNosInternos(this.root);
    }
    
    private int contaNosInternos(Node no) {
        if (no == null || (no.left == null && no.right == null)) {
            return 0; 
        }
    
        return 1 + contaNosInternos(no.left) + contaNosInternos(no.right);
    }


class Node {
    int valor;
    Node left;
    Node right;

    public Node(int valor) {
        this.valor = valor;
        this.left = null;
        this.right = null;

    }

}
}
