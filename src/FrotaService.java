import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FrotaService {

    private ArrayList<Carro> carros = new ArrayList<>();
    private ArrayList<Aluguer> alugueres = new ArrayList<>();
    private static final String FICHEIRO_CARROS = "carros.txt";
    private static final String FICHEIRO_ALUGUERES = "alugueres.txt";

    public FrotaService() {
        carregarCarros();
        carregarAlugueres();
    }

    public void adicionarCarro(Carro carro) {
        for (Carro c : carros) {
            if (c.getMatricula().equalsIgnoreCase(carro.getMatricula())) {
                System.out.println("Já existe um carro com essa matrícula.");
                return;
            }
        }
        carros.add(carro);
        guardarCarros();
        System.out.println("Carro cadastrado com sucesso!");
    }

    public void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
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
            if (carro.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println(carro);
                return;
            }
        }
        System.out.println("Carro não encontrado.");
    }

    public void removerCarro(String matricula) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equalsIgnoreCase(matricula)) {
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

    public void alugarCarro(String matricula, String cliente, String data) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equalsIgnoreCase(matricula)) {
                if (!carro.isDisponivel()) {
                    System.out.println("Este carro já está alugado ao cliente: " + carro.getClienteAtual());
                    return;
                }
                carro.setDisponivel(false);
                carro.setClienteAtual(cliente);
                Aluguer aluguer = new Aluguer(matricula, cliente, data);
                alugueres.add(aluguer);
                guardarCarros();
                guardarAlugueres();
                System.out.println("Carro alugado com sucesso ao cliente " + cliente + ".");
                return;
            }
        }
        System.out.println("Carro não encontrado.");
    }

    public void devolverCarro(String matricula, String data) {
        for (Carro carro : carros) {
            if (carro.getMatricula().equalsIgnoreCase(matricula)) {
                if (carro.isDisponivel()) {
                    System.out.println("Este carro não está alugado.");
                    return;
                }
                carro.setDisponivel(true);
                carro.setClienteAtual("");
                for (int i = alugueres.size() - 1; i >= 0; i--) {
                    Aluguer a = alugueres.get(i);
                    if (a.getMatricula().equalsIgnoreCase(matricula) && a.getDataDevolucao().isEmpty()) {
                        a.setDataDevolucao(data);
                        break;
                    }
                }
                guardarCarros();
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
}