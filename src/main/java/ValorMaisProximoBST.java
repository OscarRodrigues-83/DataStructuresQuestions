package main.java;
import java.util.Arrays;
import java.util.Scanner;

class ValorMaisProximoBST {
    public static void main(String[] args) {
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        String[] sequencia = sc.nextLine().split(" ");
        int[] numeros = new int[sequencia.length];
        for (int i = 0; i < sequencia.length; i++) {
            numeros[i] = Integer.parseInt(sequencia[i]);
            bst.add(Integer.parseInt(sequencia[i]));
        }
      int n = sc.nextInt();
        System.out.println("[" + bst.preOrdem().substring(0, bst.preOrdem().length() - 2)+ "]");
        System.out.println(bst.valorProximo(n));
        sc.close();
    }
}

 class BST {
    private Node root;

    public BST() {
        this.root = null;
    }
    public String preOrdem() {
        return preOrdem(this.root);
    }
    private String preOrdem(Node no) {
        if(no == null) return "";
       return no.valor + ", " + preOrdem(no.left) + preOrdem(no.right);
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

    public int valorProximo(int valor) {
        return valor - (valorProximo(this.root, valor, valor - this.root.valor));
    }

    private int valorProximo(Node no, int valor, int diferenca) {
        if (diferenca == 0)
            return diferenca;
        if (no.left == null && no.right == null)
            return diferenca;

        if (valor < no.valor && no.left != null) {
            int aux = valorProximo(no.left, valor, valor - no.left.valor);
            if (Math.abs(diferenca) > Math.abs(aux))
            diferenca = aux;
        }
        if (valor > no.valor && no.right != null) {
            int aux = valorProximo(no.right, valor, valor - no.right.valor);
            if (Math.abs(diferenca) > Math.abs(aux))
                diferenca = aux;
        }

        return diferenca;
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
