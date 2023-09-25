import java.util.Scanner;

public class ArvoreBinaria {

    private static No raiz;
    public ArvoreBinaria() {
        No raiz = null;
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
            Insercao.inserir(numero);

        }


        System.out.println("Arvore atual:");
        arvore.imprimirArvore(); ;

        System.out.println("Buscar valor: ");
        int numeros = scanner.nextInt();
        System.out.println("Busca pelo valor " + numeros + ": " + Insercao.buscar(numeros));

        System.out.println("Excluir valor: ");
        int numero2 = scanner.nextInt();
        System.out.println("Removendo o valor " + numero2);
        Delete.remover(numero2);

        System.out.println("\nArvore atual:");
        arvore.imprimirArvore();
    }
}