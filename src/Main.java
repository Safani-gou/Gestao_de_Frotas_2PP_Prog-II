import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FrotaService service = new FrotaService();
        int opcao;

        do {
            System.out.println("\n===== GESTÃO DE FROTA =====");
            System.out.println("1. Cadastrar carro");
            System.out.println("2. Listar todos os carros");
            System.out.println("3. Listar carros disponíveis");
            System.out.println("4. Procurar carro");
            System.out.println("5. Alugar carro");
            System.out.println("6. Devolver carro");
            System.out.println("7. Histórico de alugueres");
            System.out.println("8. Remover carro");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    Carro carro = new Carro(matricula, marca, modelo, ano);
                    service.adicionarCarro(carro);
                    break;

                case 2:
                    service.listarCarros();
                    break;

                case 3:
                    service.listarCarrosDisponiveis();
                    break;

                case 4:
                    System.out.print("Digite a matrícula: ");
                    String busca = scanner.nextLine();
                    service.procurarCarro(busca);
                    break;

                case 5:
                    System.out.print("Matrícula do carro: ");
                    String matAluguer = scanner.nextLine();
                    System.out.print("Nome do cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Data de aluguer (ex: 2025-06-01): ");
                    String dataAluguer = scanner.nextLine();
                    service.alugarCarro(matAluguer, cliente, dataAluguer);
                    break;

                case 6:
                    System.out.print("Matrícula do carro a devolver: ");
                    String matDevolucao = scanner.nextLine();
                    System.out.print("Data de devolução (ex: 2025-06-10): ");
                    String dataDevolucao = scanner.nextLine();
                    service.devolverCarro(matDevolucao, dataDevolucao);
                    break;

                case 7:
                    service.listarHistoricoAlugueres();
                    break;

                case 8:
                    System.out.print("Digite a matrícula: ");
                    String remover = scanner.nextLine();
                    service.removerCarro(remover);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}