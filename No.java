
/**
 *
 * @author matheus
 */
/*Classe contendo, os nos da arvore.*/
public class No {

    int dado; // Variavel receber o dado;
    No filhoDireita;// Variavel para referencia ao filho da direita.
    No filhoEsquerda; // Variavel para referencia ao filha da esquerda;

    /*Construtor padrão da classe*/
    public No() {

    }

    /*Metodo para imprimir a arvore*/
    public void mostrarNo() {
        System.out.println(dado);
    }

}
