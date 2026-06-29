import java.time.LocalDate;

public class Manutencao {

        private String matricula;
        private String descricao;
        private LocalDate dataEntrada;

        public Manutencao(String matricula, String descricao, LocalDate dataEntrada) {
            this.matricula = matricula;
            this.descricao = descricao;
            this.dataEntrada = dataEntrada;
        }

        public String getMatricula() {
            return matricula;
        }

        public String getDescricao() {
            return descricao;
        }

        public LocalDate getDataEntrada() {
            return dataEntrada;
        }

        @Override
        public String toString() {
            return "Matricula: " + matricula +
                    "\nProblema: " + descricao +
                    "\nData: " + dataEntrada;
        }
}