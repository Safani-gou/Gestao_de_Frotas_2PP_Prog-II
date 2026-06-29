public class Aluguer {

    private String matricula;
    private String n_BI;
    private String dataAluguer;
    private String dataDevolucao;

    public Aluguer(String matricula, String n_BI, String dataAluguer) {
        this.matricula = matricula;
        this.n_BI = n_BI;
        this.dataAluguer = dataAluguer;
        this.dataDevolucao = "";
    }
    public String getN_BI(){
        return n_BI;
    }
    public String getMatricula() {
        return matricula;
    }

    public String getCliente() {
        return n_BI;
    }
    /*
    public static String isRegistado(String rg){
        C
    }

     */
    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String toFileString() {
        return matricula + "; " + n_BI + "; " + dataAluguer + "; " + dataDevolucao;
    }

    public static Aluguer fromFileString(String linha) {
        String[] partes = linha.split(";", -1);
        Aluguer a = new Aluguer(partes[0], partes[1], partes[2]);
        a.setDataDevolucao(partes.length > 3 ? partes[3] : "");
        return a;
    }

    public String toString() {
        return "\nMatrícula: " + matricula +
                "\nCliente: " + n_BI +
                "\nData de Aluguer: " + dataAluguer +
                "\nData de Devolução: " + (dataDevolucao.isEmpty() ? "Ainda alugado" : dataDevolucao);
    }
}