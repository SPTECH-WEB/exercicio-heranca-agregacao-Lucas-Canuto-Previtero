package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public void setNome(String nome) {this.nome = nome;}
    public void setVagas(Integer vagas) {this.vagas = vagas;}
    public String getNome() {return nome;}
    public Integer getVagas() {return vagas;}

    public Consultoria(){}

    public Consultoria(String nome, Integer vagas){
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }



    public void contratar(Desenvolvedor desenvolvedor) {
        if (this.vagas > this.desenvolvedores.size()) {
            this.desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (this.vagas > 0 && desenvolvedor.isFullstack()){
            this.desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double salarioTotal = 0.00;

        for (Desenvolvedor dev : this.desenvolvedores){
            salarioTotal += dev.calcularSalario();
        }

        return salarioTotal;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdDevsMobile = 0;

        for (Desenvolvedor dev : this.desenvolvedores){
            if (dev instanceof DesenvolvedorMobile){
                qtdDevsMobile++;
            }
        }

        return qtdDevsMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> devsSalarioMaisIgualQue = new ArrayList<>();

        for (Desenvolvedor dev : this.desenvolvedores){
            if (dev.calcularSalario() >= salario){
                devsSalarioMaisIgualQue.add(dev);
            }
        }

        return devsSalarioMaisIgualQue;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (this.desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor devMenorSalario = this.desenvolvedores.get(0);

        for (Desenvolvedor dev : this.desenvolvedores){
            if (dev.calcularSalario() < devMenorSalario.calcularSalario()){
                devMenorSalario = dev;
            }
        }

        return devMenorSalario;
    }

    // DESAFIO
    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> devsPorTecnologia = new ArrayList<>();

        for (Desenvolvedor dev : this.desenvolvedores){
            if (dev instanceof DesenvolvedorMobile) {
                if(((DesenvolvedorMobile) dev).getLinguagem().equalsIgnoreCase(tecnologia) || ((DesenvolvedorMobile) dev).getPlataforma().equalsIgnoreCase(tecnologia)){
                    devsPorTecnologia.add(dev);
                }
            } else if (dev instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) dev).getFrontend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) dev).getBackend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) dev).getSgbd().equalsIgnoreCase(tecnologia)){
                    devsPorTecnologia.add(dev);
                }
            }
        }

        return devsPorTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salarioTotalPorTecnologia = 0.00;

        List<Desenvolvedor> devsPorTecnologia = buscarPorTecnologia(tecnologia);

        for (Desenvolvedor dev : devsPorTecnologia){
            salarioTotalPorTecnologia += dev.calcularSalario();
        }

        return salarioTotalPorTecnologia;
    }
}
