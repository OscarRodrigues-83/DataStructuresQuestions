// import java.util.Scanner;

// class ContaFolhasBST {
//     public static void main(String[] args) {
//         BST bst = new BST();
//         Scanner sc = new Scanner(System.in);
//         String[] sequencia = sc.nextLine().split(" ");
//         int[] numeros = new int[sequencia.length];
//         for (int i = 0; i < sequencia.length; i++) {

//             bst.add(Integer.parseInt(sequencia[i]));
//         }
//         System.out.println(bst.contaFolhas());

//         sc.close();
//     }
// }

// class BST {
//     private Node root;

//     public BST() {
//         this.root = null;
//     }

//     public boolean isEmpty() {
//         return this.root == null;
//     }

//     public void add(int valor) {

//         if (isEmpty()) {
//             this.root = new Node(valor);
//             return;
//         }
//         Node aux = this.root;
//         while (aux != null) {
//             if (valor > aux.valor) {
//                 if (aux.right == null) {
//                     aux.right = new Node(valor);
//                     return;
//                 }
//                 aux = aux.right;
//             }
//             if (valor < aux.valor) {
//                 if (aux.left == null) {
//                     aux.left = new Node(valor);
//                     return;
//                 }
//                 aux = aux.left;

//             }
//         }

//     }

//     public int contaFolhas() {
//         return contaFolhas(this.root);
//     }

//     private int contaFolhas(Node no) {
//         if (isEmpty())
//             return 0;
//         int cont = 0;
//         if (no.left != null) {
//             cont += contaFolhas(no.left);
//         }
//         if (no.right != null) {
//             cont += contaFolhas(no.right);
//         } else
//             return 1;
//         return cont;
//     }

//     class Node {
//         int valor;
//         Node left;
//         Node right;

//         public Node(int valor) {
//             this.valor = valor;
//             this.left = null;
//             this.right = null;

//         }

//     }
// }
