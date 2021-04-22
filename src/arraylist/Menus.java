/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.Scanner;

/**
 *
 * @author edgar
 */
public class Menus {

    Scanner sc = new Scanner(System.in);

    public int showMenuPrincipal() {
        int escolha = 0;
        do {
            System.out.println("========");
            System.out.println(" 1. Formandos");
            System.out.println(" 2. Cursos");
            System.out.println(" 3. Disciplinas");
            System.out.println(" 4. Inscrições");
            System.out.println();
            System.out.println(" 9. Sair");
            System.out.println("========");
            System.out.println("========");
            System.out.println("Escolha uma opção: ");
            escolha = sc.nextInt();
        } while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 9);
    return escolha;
    }

    public int showMenuSecundario(String tipo) {
        int escolha = 0;
        do {
            System.out.println("========");
            System.out.println(" 1. Inserir " + tipo);
            System.out.println(" 2. Modificar " + tipo);
            System.out.println(" 3. Eliminar " + tipo);
            System.out.println(" 4. Listar " + tipo);
            System.out.println();
            System.out.println(" 9. Sair");
            System.out.println("========");
            System.out.println("========");
            System.out.println("Escolha uma opção: ");
            escolha = sc.nextInt();
        } while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 9);
    return escolha;
    }
    
        public int showMenuInscrições(String tipo) {
        int escolha = 0;
        do {
            System.out.println("========");
            System.out.println(" 1. Inscrições de formandos em cursos");
            System.out.println(" 2. Inserir disciplinas em cursos");
            System.out.println(" 3. Eliminar formando de curso");
            System.out.println(" 4. Eliminar disciplina de curso");
            System.out.println(" 5. Listar tudo");
            System.out.println();
            System.out.println(" 9. Sair");
            System.out.println("========");
            System.out.println("========"); 
            System.out.println("Escolha uma opção: ");
            escolha = sc.nextInt();
        } while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 5 && escolha != 9);
    return escolha;
    }

}
