public class Aluguer {

    private String matricula;
    private String cliente;
    private String dataAluguer;
    private String dataDevolucao;

    public Aluguer(String matricula, String cliente, String dataAluguer) {
        this.matricula = matricula;
        this.cliente = cliente;
        this.dataAluguer = dataAluguer;
        this.dataDevolucao = "";
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String toFileString() {
        return matricula + ";" + cliente + ";" + dataAluguer + ";" + dataDevolucao;
    }

    public static Aluguer fromFileString(String linha) {
        String[] partes = linha.split(";", -1);
        Aluguer a = new Aluguer(partes[0], partes[1], partes[2]);
        a.setDataDevolucao(partes.length > 3 ? partes[3] : "");
        return a;
    }

    public String toString() {
        return "\nMatrícula: " + matricula +
                "\nCliente: " + cliente +
                "\nData de Aluguer: " + dataAluguer +
                "\nData de Devolução: " + (dataDevolucao.isEmpty() ? "Ainda alugado" : dataDevolucao);
    }
}