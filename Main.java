
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matheus
 */
public class Main {

    public static void main(String[] args) {
        Arvore obj = new Arvore();
        No no = new No();
        Scanner leia = new Scanner(System.in);
        int dado;
        int opcao = 0;

        do {
            try {
                System.out.println("0 - Sair");
                System.out.println("1 - Inserir");
                System.out.println("2 - Remover");
                System.out.println("3 - Procurar");
                System.out.println("4 - Menor elemento");
                System.out.println("5 - Em ordem");
                System.out.println("6 - Pre ordem");
                System.out.println("7 - Pos ordem");
                System.out.println("Opção: ");
                opcao = leia.nextInt();
                switch (opcao) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("Entre como o dado: ");
                        dado = leia.nextInt();
                        obj.inserir(dado);
                        break;
                    case 2:
                        System.out.println("Dado que deseja remover: ");
                        dado = leia.nextInt();
                        obj.remover(dado);
                        break;
                    case 3:
                        System.out.println("Dado que deseja procurar: ");
                        dado = leia.nextInt();
                        obj.procurar(dado);
                        break;
                    case 4:
                        obj.menor();
                        break;
                    case 5:
                        obj.emOrder(no);
                        break;
                    case 6:
                        obj.preOrder(no);
                        break;
                    case 7:
                        obj.posOrder(no);
                        break;

                    default:
                        System.out.println("Opção invalida");
                        break;
                }

            } catch (Exception err) {
                System.out.println("Erro" + err);
            }
        } while (opcao != 0);
    }

}
