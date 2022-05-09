package servico.dto;

import persistencia.modelos.Nacao;
import persistencia.modelos.Personagem;

import java.util.ArrayList;
import java.util.List;

public class ListarPersonagemDto {
    private int id;
    private String nome;
    private Nacao nacao;


    public void converter(Personagem personagem){
            this.id = personagem.getId();
            this.nome = personagem.getNome();
            this.nacao = personagem.getNacao();

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacao(Nacao nacao) {
        this.nacao = nacao;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " Nome: " + this.nome + " Nacao: " + this.nacao;
    }
}
