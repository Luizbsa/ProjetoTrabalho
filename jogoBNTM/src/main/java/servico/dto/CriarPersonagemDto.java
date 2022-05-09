package servico.dto;

import persistencia.modelos.Nacao;
import persistencia.modelos.Personagem;

public class CriarPersonagemDto {
   private String nome;
   private Nacao nacao;

    public CriarPersonagemDto(String nome, Nacao nacao) {
        this.nome = nome;
        this.nacao = nacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nacao getNacao() {
        return nacao;
    }

    public void setNacao(Nacao nacao) {
        this.nacao = nacao;
    }

    public Personagem converter(){
        Personagem personagem = new Personagem();
        personagem.setNacao(this.nacao);
        personagem.setNome(this.nome);
        return personagem;
    }
}
