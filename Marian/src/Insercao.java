public class Insercao {
        private static No raiz;

    public static boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private static boolean buscarRecursivo(No no, int valor) {
        if (no == null)
            return false;

        if (no.valor == valor)
            return true;

        if (valor < no.valor)
            return buscarRecursivo(no.esquerda, valor);
        else
            return buscarRecursivo(no.direita, valor);
    }


        public static void inserir(int valor) {
            raiz = inserirRecursivo(raiz, valor);
        }

        private static No inserirRecursivo(No no, int valor) {
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
}
