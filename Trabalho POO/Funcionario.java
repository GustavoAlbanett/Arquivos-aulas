class Funcionario extends Pessoa {
    private int matricula;
    private double salario;

    public Funcionario(String nome, String cpf, int matricula, double salario) {
        super(nome, cpf);
        this.matricula = matricula;
        this.salario = salario;
    }



    public int getMatricula() {
        return matricula;
    }
    public double getSalario() {
        return salario;
    }

    private boolean percentualValido(double percentual) {
        return percentual > 0;
    }

    public void aumentarSalario(double percentual) {
        if (percentualValido(percentual)) {
            salario += salario * percentual / 100;
        }
    }
    @Override
    public String toString() {
        return "Funcionario: " + getNome() +
                " | CPF: " + getCpf() +
                "\n Matrícula: " + matricula +
                " | Salário: " + salario + "\n";
    }
}
