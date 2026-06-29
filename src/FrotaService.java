import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FrotaService {

    private Queue<Manutencao> filaManutencao = new LinkedList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Carro> carros = new ArrayList<>();
    private ArrayList<Aluguer> alugueres = new ArrayList<>();
    private static final String FICHEIRO_CARROS = "carros.txt";
    private static final String FICHEIRO_ALUGUERES = "alugueres.txt";
    private static final String FICHEIRO_CLIENTE = "clientes.txt";
    private static final String FICHEIRO_MANUTENCAO = "manutencoes.txt";
    Scanner scanner = new Scanner(System.in);


    public FrotaService() {
        carregarCarros();
        carregarAlugueres();
        carregarClintes();
        carregarManutencoes();
    }


    public void adicionarCliente(Cliente cliente) {
        for (Cliente cl : clientes) {
            if (cl.getN_bi().equalsIgnoreCase(cliente.getN_bi())) {
                System.out.println("Já existe um cliente com esse número de BI ");
                return;
            }
        }
        clientes.add(cliente);
        guardarClientes();
        System.out.println("Registado com Sucesso!");
    }

    public void adicionarCarro(Carro carro) {
        for (Carro c : carros) {
            if (c.getMatricula().equals(carro.getMatricula())) {
                System.out.println("Já existe um carro com essa matrícula.");
                return;
            }
        }
        carros.add(carro);
        guardarCarros();
        System.out.println("Carro cadastrado com sucesso!");
    }

    public void listarClientes(){
        if (clientes.isEmpty()){
            System.out.println("Nenhum cliente registado!");
            return;
        }
        for (Cliente cliente : clientes){
            System.out.println(cliente);
            System.out.println("__________________");
        }
    }

    public void listarClientesActivo(){
        boolean sim = false;
        for (Cliente cliente : clientes) {
            if (cliente.isActivo()) {
                System.out.println(cliente);
                System.out.println("__________________");
                sim = true;
            }
        }
        if (!sim)
            System.out.println("Nenhum clinte activo");
    }

    public void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado!");
            return;
        }
        for (Carro carro : carros) {
            System.out.println(carro);
            System.out.println("------------------");
        }
    }

    public void listarCarrosDisponiveis() {
        boolean encontrou = false;
        for (Carro carro : carros) {
            if (carro.isDisponivel()) {
                System.out.println(carro);
                System.out.println("------------------");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum carro disponível.");
        }
    }

    public void procurarCarro(String matricula) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equals(matricula)) {
                System.out.println(carro);
                return;
            }
        }
        System.out.println("Carro não encontrado.");
    }

    public void removerCliente(String n_Bi) {
        for (Cliente cliente : clientes) {
            if (cliente.getN_bi().equals(n_Bi)) {
                if (cliente.isActivo()) {
                    System.out.println("Não é possível remover um cliente activo.");
                    return;
                }
                clientes.remove(cliente);
                guardarClientes();
                System.out.println("Cliente removido com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public void removerCarro(String matricula) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equals(matricula)) {
                if (!carro.isDisponivel()) {
                    System.out.println("Não é possível remover um carro que está alugado.");
                    return;
                }
                carros.remove(carro);
                guardarCarros();
                System.out.println("Carro removido com sucesso.");
                return;
            }
        }
        System.out.println("Carro não encontrado.");
    }

    public void alugarCarro(String matricula, String clienteBi, String data) {
        // Procurar o carro
        Carro carroEncontrado = null;
        for (Carro carro : carros) {
            if (carro.getMatricula().equalsIgnoreCase(matricula)) {
                carroEncontrado = carro;
                break;
            }
        }
        if (carroEncontrado == null) {
            System.out.println("Carro não encontrado.");
            return;
        }
        if (!carroEncontrado.isDisponivel()) {
            System.out.println("Este carro já está alugado ao cliente: " + carroEncontrado.getClienteBi());
            return;
        }
        if (carroEncontrado.isEmManutencao()) {
            System.out.println("O carro encontra-se em manutenção.");
            return;
        }
        Cliente clienteEncontrado = null;
        for (Cliente clie : clientes) {
            if (clie.getN_bi().equals(clienteBi)) {
                clienteEncontrado = clie;
                break;
            }
        }
        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado. Por favor registe o cliente primeiro.");
            return;
        }
        if (clienteEncontrado.isActivo()) {
            System.out.println("Este cliente já tem um carro alugado.");
            return;
        }
        // Realizar o aluguer
        carroEncontrado.setDisponivel(false);
        carroEncontrado.setClienteBi(clienteBi);
        clienteEncontrado.setActivo(true);
        // marcar cliente como activo
        Aluguer aluguer = new Aluguer(matricula, clienteBi, data);
        alugueres.add(aluguer);
        guardarCarros();
        guardarClientes();
        guardarAlugueres();
        System.out.println("Carro alugado com sucesso ao cliente " + clienteBi + ".");
    }

    public void devolverCarro(String matricula, String data) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equalsIgnoreCase(matricula)) {
                if (carro.isDisponivel()) {
                    System.out.println("Este carro não está alugado.");
                    return;
                }
                String clienteBi = carro.getClienteBi();
                for (Cliente clie : clientes) {
                    if (clie.getN_bi().equals(clienteBi)) {
                        clie.setActivo(false);
                        break;
                    }
                }
                carro.setDisponivel(true);
                carro.setClienteBi("");
                for (int i = alugueres.size() - 1; i >= 0; i--) {
                    Aluguer a = alugueres.get(i);
                    if (a.getMatricula().equalsIgnoreCase(matricula) && a.getDataDevolucao().isEmpty()) {
                        a.setDataDevolucao(data);
                        break;
                    }
                }
                guardarCarros();
                guardarClientes();
                guardarAlugueres();
                System.out.println("Carro devolvido com sucesso.");
                return;
            }
        }
        System.out.println("Carro não encontrado.");
    }

    public void listarHistoricoAlugueres() {
        if (alugueres.isEmpty()) {
            System.out.println("Nenhum aluguer registado.");
            return;
        }
        for (Aluguer a : alugueres) {
            System.out.println(a);
            System.out.println("------------------");
        }
    }


    private void guardarCarros() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FICHEIRO_CARROS));
            for (Carro c : carros) {
                pw.println(c.toFileString());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao guardar carros: " + e.getMessage());
        }
    }

    public void guardarClientes(){
        try {
            PrintWriter cliente = new PrintWriter(new FileWriter(FICHEIRO_CLIENTE));
            for (Cliente cl : clientes){
                cliente.println(cl.formatoString());
            }
            cliente.close();
        }
        catch (IOException ioException){
            System.out.println("Erro ao guardar clientes");
        }
    }

    public void carregarClintes(){
        try {
            BufferedReader cliente = new BufferedReader(new FileReader(FICHEIRO_CLIENTE));
            String linha;
            while ((linha = cliente.readLine()) != null){
                if(!linha.trim().isEmpty()){
                    clientes.add(Cliente.leFormatoString(linha));
                }
            }
            cliente.close();
        }
        catch (IOException exception){
        }

    }
    private void carregarCarros() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FICHEIRO_CARROS));
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    carros.add(Carro.fromFileString(linha));
                }
            }
            br.close();
        } catch (IOException e) {
        }
    }

    private void guardarAlugueres() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FICHEIRO_ALUGUERES));
            for (Aluguer a : alugueres) {
                pw.println(a.toFileString());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Erro ao guardar alugueres: " + e.getMessage());
        }
    }

    public void guardarManutencoes() {
        try (PrintWriter pw1 = new PrintWriter(new FileWriter(FICHEIRO_MANUTENCAO))) {
            for (Manutencao m : filaManutencao) {
                pw1.println(m.getMatricula() + ";" + m.getDescricao() + ";" + m.getDataEntrada());
            }
        } catch (IOException e) {
            System.out.println("Erro ao guardar manutenções.");
        }
    }

    public void carregarManutencoes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHEIRO_MANUTENCAO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Manutencao m = new Manutencao(dados[0], dados[1], LocalDate.parse(dados[2]));
                filaManutencao.add(m);
            }
        } catch (IOException e) {
            System.out.println("Nenhuma manutenção encontrada.");
        }
    }

    private void carregarAlugueres() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FICHEIRO_ALUGUERES));
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    alugueres.add(Aluguer.fromFileString(linha));
                }
            }
            br.close();
        } catch (IOException e) {
        }
    }

    public void enviarParaManutencao() {

        System.out.print("Digite a matrícula do carro: ");
        Validar validar = new Validar();
        String matricula = scanner.nextLine();
        while (!validar.matricula(matricula)){
            System.out.println("Erro, matricula incorreta!");
            System.out.println("MAtricula: ");
            matricula = scanner.nextLine();
        }
        Carro carroEncontrado = null;
        for (Carro carro : carros) {
            if (carro.getMatricula().equalsIgnoreCase(matricula)) {
                carroEncontrado = carro;
                break;
            }
        }
        if (carroEncontrado == null) {
            System.out.println("Carro não encontrado.");
            return;
        }
        if (!carroEncontrado.isDisponivel()) {
            System.out.println("O carro está alugado.");
            return;
        }
        if (carroEncontrado.isEmManutencao()) {
            System.out.println("O carro já está em manutenção.");
            return;
        }
        System.out.print("Descrição do problema: ");
        String descricao = scanner.nextLine();
        Manutencao manutencao = new Manutencao(matricula, descricao, LocalDate.now());
        filaManutencao.add(manutencao);
        carroEncontrado.setEmManutencao(true);
        System.out.println("Carro enviado para manutenção com sucesso.");
        guardarManutencoes();
    }

    public void consultarFilaManutencao() {
        if (filaManutencao.isEmpty()) {
            System.out.println("Nenhum carro em manutenção.");
            return;
        }
        System.out.println("\n===== FILA DE MANUTENÇÃO =====");
        for (Manutencao manutencao : filaManutencao) {
            System.out.println("---------------------------");
            System.out.println(manutencao);
        }
    }

    public void concluirManutencao() {
        if (filaManutencao.isEmpty()) {
            System.out.println("Não existem carros na fila.");
            return;
        }
        Manutencao manutencaoConcluida = filaManutencao.poll();
        for (Carro carro : carros) {
            if (carro.getMatricula().equalsIgnoreCase(manutencaoConcluida.getMatricula())) {
                carro.setEmManutencao(false);
                System.out.println("Manutenção concluída para o carro " + carro.getMatricula());
                return;
            }
        }
        concluirManutencao();
    }

    public void relatorioEstatistico() {

        int total = carros.size();
        double taxaUtilizacao = 0;
        int disponiveis = 0;
        int alugados = 0;
        int manutencao = 0;
        for (Carro carro : carros) {
            if (carro.isEmManutencao()) {
                manutencao++;
            } else if (carro.isDisponivel()) {
                disponiveis++;
            } else {
                alugados++;
            }
        }
        if (total > 0){
            taxaUtilizacao = ((double) alugados / total) * 100;
        }
        System.out.println("\n===== RELATÓRIO DA FROTA =====");
        System.out.println("Total de veículos: " + total);
        System.out.println("Disponíveis: " + disponiveis);
        System.out.println("Alugados: " + alugados);
        System.out.println("Em manutenção: " + manutencao);
        System.out.printf("Taxa de utilização: %.2f%%\n", taxaUtilizacao);
    }

}