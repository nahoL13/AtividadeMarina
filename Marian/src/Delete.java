
public class Delete {
    private static No raiz;
    public static void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private static No encontrarMin(No no) {
        while (no.esquerda != null)
            no = no.esquerda;
        return no;
    }



    private static No removerRecursivo(No no, int valor) {
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

}
