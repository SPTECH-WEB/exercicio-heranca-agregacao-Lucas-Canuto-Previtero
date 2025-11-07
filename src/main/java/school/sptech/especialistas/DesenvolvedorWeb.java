package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public void setFrontend(String frontend) {this.frontend = frontend;}
    public void setSgbd(String sgbd) {this.sgbd = sgbd;}
    public void setBackend(String backend) {this.backend = backend;}
    public void setHorasMentoria(Integer horasMentoria) {this.horasMentoria = horasMentoria;}
    public String getBackend() {return backend;}
    public String getFrontend() {return frontend;}
    public String getSgbd() {return sgbd;}
    public Integer getHorasMentoria() {return horasMentoria;}

    public DesenvolvedorWeb(){};

    public DesenvolvedorWeb(String nome, Integer qtdHoras, Double valorHora, String backend, String frontend, String sgbd, Integer horasMentoria) {
        super(nome, qtdHoras, valorHora);
        this.backend = backend;
        this.frontend = frontend;
        this.sgbd = sgbd;
        this.horasMentoria = horasMentoria;
    }

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + (this.horasMentoria * 300.00);
    }

    public Boolean isFullstack(){
        return this.frontend != null && this.backend != null && this.sgbd != null;
    }
}
