import java.util.Scanner;


public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            no = new No(valor);
            return no;
        }

        if (valor < no.valor)
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = inserirRecursivo(no.direita, valor);

        return no;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null)
            return false;

        if (no.valor == valor)
            return true;

        if (valor < no.valor)
            return buscarRecursivo(no.esquerda, valor);
        else
            return buscarRecursivo(no.direita, valor);
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No no, int valor) {
        if (no == null)
            return null;

        if (valor < no.valor)
            no.esquerda = removerRecursivo(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = removerRecursivo(no.direita, valor);
        else {
            if (no.esquerda == null)
                return no.direita;
            else if (no.direita == null)
                return no.esquerda;

            No sucessor = encontrarMin(no.direita);
            no.valor = sucessor.valor;
            no.direita = removerRecursivo(no.direita, sucessor.valor);
        }
        return no;
    }
    private No encontrarMin(No no) {
        while (no.esquerda != null)
            no = no.esquerda;
        return no;
    }

    public void imprimirArvore() {
        imprimirArvoreRecursivo(raiz, 0);
    }

    private void imprimirArvoreRecursivo(No no, int nivel) {
        if (no == null)
            return;

        imprimirArvoreRecursivo(no.direita, nivel + 1);

        for (int i = 0; i < nivel; i++)
            System.out.print("   ");

        System.out.println(no.valor);

        imprimirArvoreRecursivo(no.esquerda, nivel + 1);
    }


    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Trabalho de Arvore Binaria \n");
        System.out.println("Inserir numeros (0 break): ");

        while (true) {
            int numero = scanner.nextInt();

            if (numero == 0) {
                break;
            }
            arvore.inserir(numero);

        }


        System.out.println("Arvore atual:");
        arvore.imprimirArvore(); ;

        System.out.println("Buscar valor: ");
        int numeros = scanner.nextInt();
        System.out.println("Busca pelo valor " + numeros + ": " + arvore.buscar(numeros));

        System.out.println("Excluir valor: ");
        int numero2 = scanner.nextInt();
        System.out.println("Removendo o valor " + numero2);
        arvore.remover(numero2);

        System.out.println("\nArvore atual:");
        arvore.imprimirArvore();
    }
}