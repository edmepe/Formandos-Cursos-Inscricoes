package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Grsi013 {

    static Continuar continuar = new Continuar();
    static ArrayList<Formando> osFormandos = new ArrayList<>();
    static ArrayList<Curso> osCursos = new ArrayList<>();
    static ArrayList<InscricaoFormando> asInsForm = new ArrayList<>();
    static ArrayList<InscricaoDisciplina> asInsDes = new ArrayList<>();
    static ArrayList<Disciplina> asDisciplinas = new ArrayList<>();
    static int idFormando = 1;
    static int idCurso = 1;
    static int idDisciplina = 1;

    public static void main(String[] args) {

        Menus menu = new Menus();
        Scanner sc = new Scanner(System.in);

        int escolha = 0;
        int escolhaSec = 0;
        do {
            escolha = menu.showMenuPrincipal();
            switch (escolha) {
                case 1:
                    do {
                        escolhaSec = menu.showMenuSecundario("Formandos");
                        switch (escolhaSec) {
                            case 1:
                                System.out.println("Inserir formando");
                                inserirFormando();
                                break;
                            case 2:
                                System.out.println("Modificar formando");
                                modificarFormando();
                                break;
                            case 3:
                                System.out.println("Eliminar formando");
                                eliminarFormando();
                                break;
                            case 4:
                                System.out.println("Listar formando");
                                for (Formando oFormando : osFormandos) {
                                    System.out.println(oFormando.toString());
                                }
                                break;
                        }
                    } while (escolhaSec != 9);
                    break;
                case 2:
                    do {
                        escolhaSec = menu.showMenuSecundario("Cursos");
                        switch (escolhaSec) {
                            case 1:
                                System.out.println("Inserir curso");
                                inserirCurso();
                                break;
                            case 2:
                                System.out.println("Modificar curso");
                                modificarCurso();
                                break;
                            case 3:
                                System.out.println("Eliminar curso");
                                eliminarCurso();
                                break;
                            case 4:
                                for (Curso oCurso : osCursos) {
                                    System.out.println(oCurso.toString());
                                }
                                break;
                        }
                    } while (escolhaSec != 9);
                    break;
                case 3:
                    do {
                        escolhaSec = menu.showMenuSecundario("Disciplinas");
                        switch (escolhaSec) {
                            case 1:
                                System.out.println("Inserir disciplina");
                                inserirDisciplina();
                                break;
                            case 2:
                                System.out.println("Modificar disciplina");
                                modificarDisciplina();
                                break;
                            case 3:
                                System.out.println("Eliminar disciplina");
                                eliminarDisciplina();
                                break;
                            case 4:
                                for (Disciplina aDisciplina : asDisciplinas) {
                                    System.out.println(aDisciplina.toString());
                                }
                                break;
                        }
                    } while (escolhaSec != 9);
                    break;

                case 4:
                    do {
                        escolhaSec = menu.showMenuInscrições("Inscrições");
                        switch (escolhaSec) {
                            case 1:
                                System.out.println("Inscrever formando em curso");
                                inscreverFormando();
                                break;
                            case 2:
                                System.out.println("Inscrever disciplina em curso");
                                inscreverDisciplina();
                                break;
                            case 3:
                                System.out.println("Eliminar formando de um curso");
                                eliminarFormandoCurso();
                                break;
                            case 4:
                                System.out.println("Eliminar disciplina de um curso");
                                eliminarDisciplinaCurso();
                                break;
                            case 5:
                                if (osFormandos.size() == 0 || osCursos.size() == 0) {
                                    System.out.println("Não há formandos e/ou não há cursos!");
                                } else {
                                    System.out.println("Formandos de cada curso: ");
                                    for (InscricaoFormando i : asInsForm) {
                                        System.out.println(i.toString());
                                    }
                                    System.out.println("Disciplinas de cada curso: ");
                                    for (InscricaoDisciplina d : asInsDes) {
                                        System.out.println(d.toString());
                                    }
                                }
                                break;
                        }
                    } while (escolhaSec != 9);
                    break;
            }
        } while (escolha != 9);

    }

    private static void inserirFormando() {

        do {
            Formando formando = new Formando();
            Scanner sc = new Scanner(System.in);
            formando.setIdFormando(idFormando++);
            System.out.println("Nome do formando:");
            formando.setNome(sc.nextLine());
            System.out.println("Masculino (true/false):");
            formando.setMasculino(sc.nextBoolean());
            System.out.println("Telefone:");
            formando.setTelefones(sc.nextInt());
            osFormandos.add(formando);
        } while (continuar.perguntar());

        for (Formando f : osFormandos) {
            System.out.println(f.toString());
        }
    }

    private static void inserirCurso() {

        do {
            Curso curso = new Curso();
            Scanner sc = new Scanner(System.in);
            curso.setIdCurso(idCurso++);
            System.out.println("Nome do curso:");
            curso.setNome(sc.nextLine());
            System.out.println("Horas do curso:");
            curso.setHoras(sc.nextInt());

            osCursos.add(curso);

        } while (continuar.perguntar());

        for (Curso c : osCursos) {
            System.out.println(c.toString());
        }
    }

    private static void inserirDisciplina() {

        do {
            Disciplina disciplina = new Disciplina();
            Scanner sc = new Scanner(System.in);
            disciplina.setIdDisciplina(idDisciplina++);
            System.out.println("Nome da disciplina:");
            disciplina.setNome(sc.nextLine());
            System.out.println("Horas da disciplina:");
            disciplina.setHoras(sc.nextInt());

            asDisciplinas.add(disciplina);

        } while (continuar.perguntar());

        for (Disciplina d : asDisciplinas) {
            System.out.println(d.toString());
        }
    }

    private static void modificarFormando() {
        if (osFormandos.size() == 0) {
            System.out.println("Não há formandos!");
        } else {
            Scanner sc = new Scanner(System.in);
            for (Formando oFormando : osFormandos) {
                System.out.println(oFormando.toString());
            }

            System.out.println("ID do formando:");
            int id = sc.nextInt();
            try {
                Formando formando = osFormandos.get(id - 1);
                sc = new Scanner(System.in);
                System.out.println("Nome do formando:");
                String nome = sc.nextLine();
                if (!nome.isEmpty()) {
                    formando.setNome(nome);
                }
                System.out.println("Masculino (true/false):");
                String genero = sc.nextLine();
                if (!genero.isEmpty()) {
                    formando.setMasculino((genero.equals("true")) ? true : false);
                }
                for (int x = 0; 0 < formando.getTelefones().size(); x++) {
                    System.out.println("Insira um número para substituir " + formando.getTelefones().get(x));
                    String newTelefones = sc.nextLine();
                    if (!newTelefones.isEmpty()) {
                        formando.telefones.set(x, Integer.parseInt(newTelefones));
                    }
                }
                for (Formando f : osFormandos) {
                    System.out.println(f.toString());
                }

            } catch (Exception e) {
                System.out.println("O formando com o ID " + id + " não existe");
            }
        }
    }

    private static void modificarCurso() {
        if (osCursos.size() == 0) {
            System.out.println("Não há cursos!");
        } else {
            Scanner sc = new Scanner(System.in);
            for (Curso oCurso : osCursos) {
                System.out.println(oCurso.toString());
            }

            System.out.println("ID do curso:");
            int id = sc.nextInt();
            try {
                Curso curso = osCursos.get(id - 1);
                sc = new Scanner(System.in);
                System.out.println("Nome do curso:");
                String nome = sc.nextLine();
                if (!nome.isEmpty()) {
                    curso.setNome(nome);
                }
                System.out.println("Horas do curso:");
                String newHoras = sc.nextLine();
                if (!newHoras.isEmpty()) {
                    int horas = Integer.parseInt(newHoras);
                    curso.setHoras(horas);
                }
                for (Curso c : osCursos) {
                    System.out.println(c.toString());
                }

            } catch (Exception e) {
                System.out.println("O curso com o ID " + id + " não existe");
            }
        }
    }

    private static void modificarDisciplina() {
        if (asDisciplinas.size() == 0) {
            System.out.println("Não há disciplinas!");
        } else {
            Scanner sc = new Scanner(System.in);
            for (Disciplina aDisciplina : asDisciplinas) {
                System.out.println(aDisciplina.toString());
            }

            System.out.println("ID da disciplina:");
            int id = sc.nextInt();
            try {
                Disciplina disciplina = asDisciplinas.get(id - 1);
                sc = new Scanner(System.in);
                System.out.println("Nome da disciplina:");
                String nome = sc.nextLine();
                if (!nome.isEmpty()) {
                    disciplina.setNome(nome);
                }
                System.out.println("Horas da disciplina:");
                String newHoras = sc.nextLine();
                if (!newHoras.isEmpty()) {
                    int horas = Integer.parseInt(newHoras);
                    disciplina.setHoras(horas);
                }
                for (Disciplina c : asDisciplinas) {
                    System.out.println(c.toString());
                }

            } catch (Exception e) {
                System.out.println("A disciplina com o ID " + id + " não existe");
            }
        }
    }

    private static void eliminarCurso() {
        Curso curso = new Curso();
        if (osCursos.size() == 0) {
            System.out.println("Não há cursos!");
        } else {
            Scanner sc = new Scanner(System.in);
            for (Curso oCurso : osCursos) {
                System.out.println(oCurso.toString());
            }
            sc = new Scanner(System.in);
            System.out.println("ID do curso que deseja eliminar?");
            int id = sc.nextInt();

            if (id > 0 && id <= osCursos.size()) {

                if (osCursos.size() == 0) {
                    System.out.println("Não há cursos!");

                } else {
                    osCursos.remove(id - 1);
                    idCurso = 2;
                    int j = osCursos.size();
                    for (int x = 2; x < j + 1; x++) {
                        curso = osCursos.get(x - 1);
                        curso.setIdCurso(idCurso++);
                    }

                    System.out.println("O curso com o ID " + id + " foi eliminado.");
                    for (Curso c : osCursos) {
                        System.out.println(c.toString());
                    }
                }
            } else {
                System.out.println("Não existe nenhum curso com o ID " + id);
            }

        }
    }

    private static void eliminarFormando() {
        Formando formando = new Formando();
        if (osFormandos.size() == 0) {
            System.out.println("Não há formandos!");
        } else {
            Scanner sc = new Scanner(System.in);
            for (Formando oFormando : osFormandos) {
                System.out.println(oFormando.toString());
            }
            sc = new Scanner(System.in);
            System.out.println("ID do formando que deseja eliminar?");
            int id = sc.nextInt();

            if (id > 0 && id <= osFormandos.size()) {

                if (osFormandos.size() == 0) {
                    System.out.println("Não há formandos!");

                } else {
                    osFormandos.remove(id - 1);
                    idFormando = 1;
                    int j = osFormandos.size();
                    for (int x = 1; x < j + 1; x++) {
                        formando = osFormandos.get(x - 1);
                        formando.setIdFormando(idFormando++);
                    }

                    System.out.println("O formando com o ID " + id + " foi eliminado.");
                    for (Formando f : osFormandos) {
                        System.out.println(f.toString());
                    }
                }
            } else {
                System.out.println("Não existe nenhum formando com o ID " + id);
            }

        }
    }

    private static void eliminarDisciplina() {
        Disciplina disciplina = new Disciplina();
        if (asDisciplinas.size() == 0) {
            System.out.println("Não há disciplinas!");
        } else {
            Scanner sc = new Scanner(System.in);
            for (Disciplina aDisciplina : asDisciplinas) {
                System.out.println(aDisciplina.toString());
            }
            sc = new Scanner(System.in);
            System.out.println("ID da disciplina que deseja eliminar?");
            int id = sc.nextInt();

            if (id > 0 && id <= asDisciplinas.size()) {

                if (asDisciplinas.size() == 0) {
                    System.out.println("Não há disciplinas!");

                } else {
                    asDisciplinas.remove(id - 1);
                    idDisciplina = 2;
                    int j = asDisciplinas.size();
                    for (int x = 2; x < j + 1; x++) {
                        disciplina = asDisciplinas.get(x - 1);
                        disciplina.setIdDisciplina(idDisciplina++);
                    }

                    System.out.println("A disciplina com o ID " + id + " foi eliminada.");
                    for (Disciplina d : asDisciplinas) {
                        System.out.println(d.toString());
                    }
                }
            } else {
                System.out.println("Não existe nenhuma disciplina com o ID " + id);
            }

        }
    }

    private static void eliminarFormandoCurso() {
        if (osFormandos.size() == 0 || osCursos.size() == 0) {
            System.out.println("Não há formandos e/ou não há cursos!");
        } else {
            Scanner sc = new Scanner(System.in);

            do {
                InscricaoFormando inscricaoformando = new InscricaoFormando();
                for (InscricaoFormando i : asInsForm) {
                    System.out.println(i.toString());
                }

                System.out.println("ID do formando:");
                int id = sc.nextInt();
                if (id <= asInsForm.size() && idFormando > 0) {
                    asInsForm.remove(id - 1);
                    
                } else {
                    System.out.println("O formando com o ID " + idFormando + " não existe.");
                }
            } while (continuar.perguntar());

            for (InscricaoFormando i : asInsForm) {
                System.out.println(i.toString());
            }
        }
    }

    private static void eliminarDisciplinaCurso() {
        if (asDisciplinas.size() == 0 || osCursos.size() == 0) {
            System.out.println("Não há disciplinas e/ou não há cursos!");
        } else {
            Scanner sc = new Scanner(System.in);

            do {
                InscricaoDisciplina inscricaodisciplina = new InscricaoDisciplina();
                for (InscricaoDisciplina d : asInsDes) {
                    System.out.println(d.toString());
                }

                System.out.println("ID da disciplina:");
                int id = sc.nextInt();
                if (id <= asInsDes.size() && idDisciplina > 0) {
                    asInsDes.remove(id - 1);

                } else {
                    System.out.println("A disciplina com o ID " + idDisciplina + " não existe.");
                }
            } while (continuar.perguntar());

            for (InscricaoDisciplina d : asInsDes) {
                System.out.println(d.toString());
            }
        }
    }

    private static void inscreverFormando() {
        if (osFormandos.size() == 0 || osCursos.size() == 0) {
            System.out.println("Não há formandos e/ou não há cursos!");
        } else {
            Scanner sc = new Scanner(System.in);

            do {
                InscricaoFormando inscricaoformando = new InscricaoFormando();
                for (Formando oFormando : osFormandos) {
                    System.out.println(oFormando.toString());
                }

                System.out.println("ID do formando:");
                idFormando = sc.nextInt();
                if (idFormando <= osFormandos.size() && idFormando > 0) {
                    asInsForm.add(inscricaoformando);
                    inscricaoformando.setIdFormando(idFormando++);
                    for (Curso oCurso : osCursos) {
                        System.out.println(oCurso.toString());
                    }

                    System.out.println("ID do curso:");
                    idCurso = sc.nextInt();
                    if (idCurso <= osCursos.size() && idCurso > 0) {
                        inscricaoformando.setIdCurso(idCurso++);
                    } else {
                        System.out.println("O curso com o ID " + idCurso + " não existe.");
                    }

                } else {
                    System.out.println("O formando com o ID " + idFormando + " não existe.");
                }
            } while (continuar.perguntar());
            
            for (InscricaoFormando i : asInsForm) {
                System.out.println(i.toString());
            }
        }
    }

    private static void inscreverDisciplina() {
        if (asDisciplinas.size() == 0 || osCursos.size() == 0) {
            System.out.println("Não há disciplinas e/ou não há cursos!");
        } else {
            Scanner sc = new Scanner(System.in);

            do {
                InscricaoDisciplina inscricaodisciplina = new InscricaoDisciplina();
                for (Disciplina aDisciplina : asDisciplinas) {
                    System.out.println(aDisciplina.toString());
                }

                System.out.println("ID da disciplina:");
                idDisciplina = sc.nextInt();
                if (idDisciplina <= asDisciplinas.size() && idDisciplina > 0) {
                    asInsDes.add(inscricaodisciplina);
                    inscricaodisciplina.setIdDisciplina(idDisciplina++);
                    for (Curso oCurso : osCursos) {
                        System.out.println(oCurso.toString());
                    }

                    System.out.println("ID do curso:");
                    idCurso = sc.nextInt();
                    if (idCurso <= osCursos.size() && idCurso > 0) {
                        inscricaodisciplina.setIdCurso(idCurso++);
                    } else {
                        System.out.println("O curso com o ID " + idCurso + " não existe.");

                    }
                } else {
                    System.out.println("A disciplina com o ID " + idDisciplina + " não existe.");
                }

            } while (continuar.perguntar());

            for (InscricaoDisciplina d : asInsDes) {
                System.out.println(d.toString());
            }

        }

    }
}
