public class Carro {

    private String matricula;
    private String marca;
    private String modelo;
    private int ano;
    private boolean disponivel;
    private String clienteAtual;

    public Carro(String matricula, String marca, String modelo, int ano) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.disponivel = true;
        this.clienteAtual = "";
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(String clienteAtual) {
        this.clienteAtual = clienteAtual;
    }

    public String toFileString() {
        return matricula + ";" + marca + ";" + modelo + ";" + ano + ";" + disponivel + ";" + clienteAtual;
    }

    public static Carro fromFileString(String linha) {
        String[] partes = linha.split(";", -1);
        Carro c = new Carro(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]));
        c.setDisponivel(Boolean.parseBoolean(partes[4]));
        c.setClienteAtual(partes.length > 5 ? partes[5] : "");
        return c;
    }

    public String toString() {
        return "\nMatrícula: " + matricula +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nAno: " + ano +
                "\nDisponível: " + (disponivel ? "Sim" : "Não") +
                (!clienteAtual.isEmpty() ? "\nCliente: " + clienteAtual : "");
    }
}