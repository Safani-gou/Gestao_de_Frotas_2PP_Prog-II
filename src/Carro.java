public class Carro {
    private String matricula;
    private String marca;
    private String modelo;
    private String ano;
    private boolean disponivel;
    private boolean emManutencao;
    private String clienteBi;

    public Carro(String matricula, String marca, String modelo, String ano) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.disponivel = true;
        this.emManutencao = false;
        this.clienteBi = "";
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
    public void setClienteBi(String n_Bi) {
        this.clienteBi = n_Bi;
    }
    public String getClienteBi() {
        return clienteBi;
    }
    public boolean isEmManutencao(){
        return emManutencao;
    }
    public void setEmManutencao(boolean emManutencao){
        this.emManutencao = emManutencao;
    }
    public String toFileString() {
        return matricula + ";" + marca + ";" + modelo + ";" + ano + ";" + disponivel + ";" + clienteBi;
    }
    public static Carro
    fromFileString(String linha) {
        String[] partes = linha.split(";", -1);
        Carro c = new Carro(partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim());
        c.setDisponivel(Boolean.parseBoolean(partes[4].trim()));
        c.setClienteBi(partes.length > 5 ? partes[5].trim() : "");
        return c;
    }
    public String toString() {return "Matrícula: " + matricula +
            "\nMarca: " + marca +
            "\nModelo: " + modelo +
            "\nAno: " + ano +
            "\nDisponível: " + (disponivel ? "Sim" : "Não") +
            "\nEm Manutenção: " + (emManutencao ? "Sim" : "Não") +
            (!clienteBi.isEmpty() ? "\nCliente: " + clienteBi : "");
    }
}