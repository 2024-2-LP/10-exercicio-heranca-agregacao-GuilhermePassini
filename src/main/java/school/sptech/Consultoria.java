package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double soma = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            soma += desenvolvedor.calcularSalario();
        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer somaDesenvolvedor = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                somaDesenvolvedor++;
            }
        }
        return somaDesenvolvedor;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> salariosMaiorQue = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() > salario) {
                salariosMaiorQue.add(desenvolvedor);
            }
        }
        return salariosMaiorQue;
    }

        public Desenvolvedor buscarMenorSalario () {
            if (desenvolvedores.isEmpty()) {
                return null;
            }

            Desenvolvedor menorSalarioDev = desenvolvedores.get(0);

            for (Desenvolvedor dev : desenvolvedores) {
                if (dev.calcularSalario() < menorSalarioDev.calcularSalario()) {
                    menorSalarioDev = dev;
                }
            }
            return menorSalarioDev;
        }
    }




