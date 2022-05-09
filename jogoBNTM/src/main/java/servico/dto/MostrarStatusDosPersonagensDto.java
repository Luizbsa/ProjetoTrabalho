package servico.dto;

import persistencia.modelos.Personagem;

public class MostrarStatusDosPersonagensDto {
    private String nome;
    private int forca;
    private int precisao;
    private int velocidade;
    private int armadura;
    private int recuperacao;

    public MostrarStatusDosPersonagensDto(Personagem personagem) {
        this.nome = personagem.getNome();
        this.forca = personagem.getStatus().getForca();
        this.precisao = personagem.getStatus().getPrecisao();
        this.velocidade = personagem.getStatus().getVelocidade();
        this.armadura = personagem.getStatus().getArmadura();
        this.recuperacao = personagem.getStatus().getRecuperacao();
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", Força: " + this.forca + ", Precisão: " + this.precisao +
                ", Velocidade: " +this.velocidade + ", Armadura: " + this.armadura + ", Recuperação: " +
                this.recuperacao;
    }
}
