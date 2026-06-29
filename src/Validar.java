public class Validar {
    public boolean nomeFistLastClie(String nome) {
        return nome.matches("[A-Z]+[a-zÀ-ÿ]+\\s+[A-Z]+[a-zÀ-ÿ]+");
    }
    public boolean idadeClie(String idade)
    {
        return idade.matches("\\d{2}");
    }
    public boolean n_bilheteClie(String bi)
    {
        return bi.matches("\\d{9}[A-Z][A-Z]\\d{3}");
    }
    public boolean enderecoClie(String endereco) {
        return endereco.matches("([A-Z]+[a-z]+\\s+[A-Za-z]+)|([A-Z]+[a-z]+\\s+\\d+)|[A-Za-z]+");
    }
    public boolean telefoneClie(String telefone)
    {
        return telefone.matches("9\\d{8}");
    }
    public boolean matricula(String matricula){
        return  matricula.matches("[A-Z]+['-]\\d{2}['-]\\d{2}['-][A-Z]+");
    }
    public boolean ano(String ano){
        return ano.matches("\\d{4}");
    }
    public void nomeFi() {
    }
/*
    public static void main(String[] args) {
        String nome = "225442";

        if (matricula(nome))
            System.out.println(nome);
    }
*/
}
