import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FrotaService service = new FrotaService();
        Validar validar = new Validar();

        String opcao;//Para opções do menu
        do {
            System.out.println("\n=====FROTA SIMBA WAMBAU=====");
            System.out.println("  =»» Gestor");
            System.out.println("  =»» Operário");
            System.out.println("  =»» Sair");
            System.out.print("Escolha: ");
            opcao = scanner.next();
            scanner.nextLine();
            switch (opcao) {
                case "Gestor":
                    /*
                    System.out.print("Usuario: \n");
                    System.out.println("Senha: \n");
                     */
                    int opcao1;
                    do {
                        System.out.println("\n=====FROTA SIMBA WUAMBAU=====");
                        System.out.println("1. Gestão de Carros");
                        System.out.println("2. Gestão de Clientes");
                        System.out.println("3. Manutenção");
                        System.out.println("4. Relatórios");
                        System.out.println("0. Terminar Sessão");
                        System.out.print("nº: ");
                        opcao1 = scanner.nextInt();
                        switch (opcao1){
                            case 1:
                                int opcao1_1;
                                do {
                                    System.out.println("\n=====Gestão de Carros=====");
                                    System.out.println("1. Registar Carro");
                                    System.out.println("2. Listar Carro");
                                    System.out.println("3. Listar Carros Disponíveis");
                                    System.out.println("4. Procurar Carro");
                                    System.out.println("5. Remover carro");
                                    System.out.println("0. Sair");
                                    System.out.print("nº: ");
                                    opcao1_1 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao1_1){
                                        case 1:
                                            System.out.println("\n»»» Registar Carros »»»");
                                            System.out.print("Matrícula: ");
                                            String matricula = scanner.nextLine();
                                            while (!validar.matricula(matricula)){
                                                System.out.println("Erro, matricula incorreta!");
                                                System.out.print("Matricula: ");
                                                matricula = scanner.nextLine();
                                            }
                                            System.out.print("Marca: ");
                                            String marca = scanner.nextLine();
                                            System.out.print("Modelo: ");
                                            String modelo = scanner.nextLine();
                                            System.out.print("Ano: ");
                                            String ano = scanner.nextLine();
                                            while (!validar.ano(ano)){
                                                System.out.println("Erro, ano incorreto!");
                                                System.out.print("Ano: ");
                                                ano = scanner.nextLine();
                                            }
                                            Carro carro = new Carro(matricula, marca, modelo, ano);
                                            service.adicionarCarro(carro);
                                            break;
                                        case 2:
                                            System.out.println("\n»»» Lista Carros »»»");
                                            service.listarCarros();
                                            break;
                                        case 3:
                                            System.out.println("\n»»» Lista dos Carros Disponíveis »»»");
                                            service.listarCarrosDisponiveis();
                                            break;
                                        case 4:
                                            System.out.println("\n»»» Procurar Carro »»»");
                                            System.out.print("Digite a matrícula: ");
                                            String busca = scanner.nextLine();
                                            while (!validar.matricula(busca)){
                                                System.out.println("Erro, matrícula incorreta!");
                                                System.out.println("Matrícula: ");
                                                busca = scanner.nextLine();
                                            }
                                            service.procurarCarro(busca);
                                            break;
                                        case 5:
                                            System.out.println("\n»»» Remover Carros »»»");
                                            System.out.print("matrícula: ");
                                            String remover = scanner.nextLine();
                                            while (!validar.matricula(remover)){
                                                System.out.println("Erro, matricula incorreta!");
                                                System.out.print("Matrícula: ");
                                                remover = scanner.nextLine();
                                            }
                                            service.removerCarro(remover);
                                            break;
                                        default:
                                            System.out.println("Opção invalida!");
                                    }
                                }while (opcao1_1 != 0);
                                break;
                            case 2:
                                int opcao2_2;
                                do {
                                    System.out.println("\n=====Gestão de Clientes=====");
                                    System.out.println("1. Registar Cliente");
                                    System.out.println("2. Listar Clientes");
                                    System.out.println("3. Clientes Activos");
                                    System.out.println("4. Remover Clientes");
                                    System.out.println("0. Sair");
                                    System.out.print("nº: ");
                                    opcao2_2 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao2_2){
                                        case 1:
                                            System.out.println("\n»»» Registar Cliente »»»\n");
                                            System.out.print("Nome: ");
                                            String nome = scanner.nextLine();
                                            while (!validar.nomeFistLastClie(nome)){
                                                System.out.println("Erro, nome incorreto");
                                                System.out.print("Nome: ");
                                                nome = scanner.nextLine();
                                            }
                                            System.out.print("Idade: ");
                                            String idade = scanner.nextLine();
                                            while (!validar.idadeClie(idade)){
                                                System.out.println("Erro, idade incorreta");
                                                System.out.print("Idade: ");
                                                idade = scanner.nextLine();
                                            }
                                            System.out.print("NºBI: ");
                                            String n_bi = scanner.nextLine();
                                            while (!validar.n_bilheteClie(n_bi)){
                                                System.out.println("Erro, nº BI incorreto!");
                                                System.out.print("Nª BI: ");
                                                n_bi = scanner.nextLine();
                                            }
                                            System.out.print("Endereço: ");
                                            String endereco = scanner.nextLine();
                                            while (!validar.enderecoClie(endereco)){
                                                System.out.println("Erro, endereço incorreto");
                                                System.out.print("Endereço: ");
                                                endereco = scanner.nextLine();
                                            }
                                            System.out.print("Telefone: ");
                                            String telefone = scanner.nextLine();
                                            while (!validar.telefoneClie(telefone)){
                                                System.out.println("Erro, telefone incorreto");
                                                System.out.print("Telefone: ");
                                                telefone = scanner.nextLine();
                                            }
                                            Cliente cliente = new Cliente(nome, idade, n_bi, endereco, telefone);
                                            service.adicionarCliente(cliente);
                                            break;
                                        case 2:
                                            System.out.println("\n»»» Lista Clientes »»»\n");
                                                service.listarClientes();
                                            break;
                                        case 3:
                                            System.out.println("\n»»» Clientes Activos »»»\n");
                                                service.listarClientesActivo();
                                            break;
                                        case 4:
                                            System.out.println("\n»»» Remover Clientes »»»\n");
                                            System.out.print("Nº BI: ");
                                            String r_n_Bi = scanner.nextLine();
                                            while (!validar.n_bilheteClie(r_n_Bi)){
                                                System.out.println("Erro, nº BI incorreto!");
                                                System.out.print("Nº BI: ");
                                                r_n_Bi = scanner.nextLine();
                                            }
                                            service.removerCliente(r_n_Bi);
                                            break;
                                        default:
                                            System.out.println("opção invalida!");
                                    }
                                }while (opcao2_2 != 0);
                                break;
                            case 3:
                                int opcao3_3;
                                    do {
                                        System.out.println("\n=====Manutenção=====");
                                        System.out.println("1. Enivar para a manutenção");
                                        System.out.println("2. Consultar fila");
                                        System.out.println("3. Concluir manutenção");
                                        System.out.println("0. Sair");
                                        System.out.print("nº: ");
                                        opcao3_3 = scanner.nextInt();
                                        scanner.nextLine();
                                        switch (opcao3_3){
                                            case 1:
                                            System.out.println("»»» Enviado para Manutenção »»»");
                                            service.enviarParaManutencao();
                                            break;
                                            case 2:
                                            System.out.println("»»» Consultar Fila da Manutenção »»»");
                                            service.consultarFilaManutencao();
                                        break;
                                    case 3:
                                        System.out.println("»»» Concluida a Manutenção »»»");
                                        service.concluirManutencao();
                                        break;
                                    default:
                                        System.out.println("Opção invalida!");
                                    }
                                }while (opcao3_3 != 0);
                                break;
                            case 4:
                                int opcao4_4;
                                do {
                                    System.out.println("\n=====Relatórios=====");
                                    System.out.println("1. Relatorio Estatístico");
                                    System.out.println("0. Sair");
                                    System.out.print("nº: ");
                                    opcao4_4 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao4_4){
                                        case 1:
                                            System.out.println("»»» Relatório Estastítico »»»");
                                            service.relatorioEstatistico();
                                            break;
                                        case 2:
                                            System.out.println("»»» Lista dos Carros Devolvidos »»»");
                                            //Conveniencia de gerar um relatório em pdf
                                            break;
                                        default:
                                            System.out.println("Opção invalida!");
                                    }
                                }while (opcao4_4 != 0);
                                break;
                            case 0:
                                System.out.println("Sessão terminada!");
                                break;
                            default:
                                System.out.println("Opção invalida!");
                        }
                    }while (opcao1 != 0);
                    break;
                case "Operario":
                    int opcao2;
                    do {
                        System.out.println("\n=====Atendimento ao Cliente=====");
                        System.out.println("1. Registar Carros");
                        System.out.println("2. Registar Cliente");
                        System.out.println("3. Alugar Carro");
                        System.out.println("4. Devolução de Carros");
                        System.out.println("5. Listar Carros Dispníveis");
                        System.out.println("6. Procura Carro");
                        System.out.println("7. Historico de Aluguer de Carros");
                        System.out.println("8. Manutenção");
                        System.out.println("0. Terminar Sessão");
                        System.out.print("nº: ");
                        opcao2 = scanner.nextInt();
                        scanner.nextLine();
                        switch(opcao2){
                            case 1:
                                System.out.println("\n»»» Registar Carros »»»");
                                System.out.print("Matrícula: ");
                                String matricula = scanner.nextLine();
                                while (!validar.matricula(matricula)){
                                    System.out.println("Erro, matricula incorreta!");
                                    System.out.print("Matricula: ");
                                    matricula = scanner.nextLine();
                                }
                                System.out.print("Marca: ");
                                String marca = scanner.nextLine();
                                System.out.print("Modelo: ");
                                String modelo = scanner.nextLine();
                                System.out.print("Ano: ");
                                String ano = scanner.nextLine();
                                while (!validar.ano(ano)){
                                    System.out.println("Erro, ano incorreto!");
                                    System.out.print("Ano: ");
                                    ano = scanner.nextLine();
                                }
                                Carro carro = new Carro(matricula, marca, modelo, ano);
                                service.adicionarCarro(carro);
                                break;
                            case 2:
                                System.out.println("\n»»» Registar Cliente »»»");
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                while (!validar.nomeFistLastClie(nome)){
                                    System.out.println("Erro, nome incorreto");
                                    System.out.print("Nome: ");
                                    nome = scanner.nextLine();
                                }
                                System.out.print("Idade: ");
                                String idade = scanner.nextLine();
                                while (!validar.idadeClie(idade)){
                                    System.out.println("Erro, idade incorreta");
                                    System.out.print("Idade: ");
                                    idade = scanner.nextLine();
                                }
                                System.out.print("NºBI: ");
                                String n_bi = scanner.nextLine();
                                while (!validar.n_bilheteClie(n_bi)){
                                    System.out.println("Erro, nome incorreto");
                                    System.out.print("Nome: ");
                                    n_bi = scanner.nextLine();
                                }
                                System.out.print("Endereço: ");
                                String endereco = scanner.nextLine();
                                while (!validar.enderecoClie(endereco)){
                                    System.out.println("Erro, endereço incorreto");
                                    System.out.print("Endereço: ");
                                    endereco = scanner.nextLine();
                                }
                                System.out.print("Telefone: ");
                                String telefone = scanner.nextLine();
                                while (!validar.telefoneClie(telefone)){
                                    System.out.println("Erro, telefone incorreto");
                                    System.out.print("Telefone: ");
                                    telefone = scanner.nextLine();
                                }
                                Cliente cliente = new Cliente(nome, idade, n_bi, endereco, telefone);
                                service.adicionarCliente(cliente);
                                break;
                            case 3:
                                System.out.println("\n»»» Alugar Carro »»»");
                                System.out.print("Matrícula: ");
                                String matricula1 = scanner.nextLine();
                                while (!validar.matricula(matricula1)){
                                    System.out.println("Erro, matricula incorreta!");
                                    System.out.print("Matricula: ");
                                    matricula1 = scanner.nextLine();
                                }
                                System.out.print("Cliente nº BI: ");
                                String n_BI = scanner.nextLine();
                                while (!validar.n_bilheteClie(n_BI)){
                                    System.out.println("Erro, n º BI incorreto!");
                                    System.out.print("Cliente nº BI: ");
                                    n_BI = scanner.nextLine();
                                }
                                LocalDateTime dateTimeIn = LocalDateTime.now();
                                DateTimeFormatter formatoIn = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:ss");
                                String dataAluguer = dateTimeIn.format(formatoIn);
                                service.alugarCarro(matricula1, n_BI, dataAluguer);
                                break;
                            case 4:
                                System.out.println("\n»»» Devolução de Carros »»»");
                                System.out.print("Matrícula do carro a devolver: ");
                                String matDevolucao = scanner.nextLine();
                                LocalDateTime dateTimeOut = LocalDateTime.now();
                                DateTimeFormatter formatoOut = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:ss");
                                String dataDevolucao = dateTimeOut.format(formatoOut);
                                service.devolverCarro(matDevolucao, dataDevolucao);
                                break;
                            case 5:
                                System.out.println("\n»»» Listar Carros Disponíveis »»»");
                                service.listarCarrosDisponiveis();
                                break;
                            case 6:
                                System.out.println("\n»»» Procurar Carro »»»");
                                System.out.print("Digite a matrícula: ");
                                String busca = scanner.nextLine();
                                service.procurarCarro(busca);
                                break;
                            case 7:
                                System.out.println("\n»»» Historico de Aluguer de Carros »»»");
                                service.listarHistoricoAlugueres();
                                break;
                            case 8:
                                int opcao8_8;
                                do {
                                    System.out.println("\n=====Manutenção=====");
                                    System.out.println("1. Enivar para a manutenção");
                                    System.out.println("2. Consultar fila");
                                    System.out.println("3. Concluir manutenção");
                                    System.out.println("0. Sair");
                                    System.out.print("nº: ");
                                    opcao8_8 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao8_8){
                                        case 1:
                                            System.out.println("»»» Enviar para Manutenção »»»");
                                            service.enviarParaManutencao();
                                            break;
                                        case 2:
                                            System.out.println("»»» Consultar Fila da Manutenção »»»");
                                            service.consultarFilaManutencao();
                                            break;
                                        case 3:
                                            System.out.println("»»» Concluida a Manutenção »»»");
                                            service.concluirManutencao();
                                            break;
                                        default:
                                            System.out.println("Opção invalida!");
                                    }
                                }while (opcao8_8 != 0);

                            case 0:
                                System.out.println("Sessão Terminada");
                                break;
                            default:
                                System.out.println("Opção invalida!");
                        }
                    }while (opcao2 != 0);
                    break;
                case "Sair":
                    System.out.println("Sistema encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equalsIgnoreCase("Sair"));

        scanner.close();
    }
}