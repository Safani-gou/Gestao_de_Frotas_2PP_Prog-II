public class Cliente {
    private String name;
    private String age;
    private String n_bi;
    private String address;
    private String phone_n;
    private boolean activo;

    public Cliente(String name, String age, String n_bi, String address, String phone_n) {
        this.name = name;
        this.age = age;
        this.n_bi = n_bi;
        this.address = address;
        this.phone_n = phone_n;
        this.activo = false;
    }
    public String getName() {
        return name;
    }
    public String getN_bi() {
        return n_bi;
    }
    public boolean isActivo() {
        return activo;}
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String formatoString() {
        return name + ";" + age + ";" + n_bi + ";" + address + ";" + phone_n + ";" + activo;
    }
    public static Cliente
    leFormatoString(String linha) {
        String[] parte = linha.split(";",
                -1);
        Cliente cliente = new Cliente(parte[0].trim(), parte[1].trim(), parte[2].trim(), parte[3].trim(), parte[4].trim());
        cliente.setActivo(Boolean.parseBoolean(parte[5].trim()));
        return cliente;
    }
    public String toString() {
        return "Cliente: " + name +
                "\nIdade: " + age +
                "\nNºBI: " + n_bi +
                "\nEndereço: " + address +
                "\nTelefone: " + phone_n +"\nActivo: " + (activo ? "Sim" : "Não");
    }
}
