package persistencia.modelos;

public class Status {
	private int forca;
	private int precisao;
	private int velocidade;
	private int armadura;
	private int recuperacao;
	
	
	
	public Status() {
		super();
	}
	
	public Status(int forca, int precisao, int velocidade, int armadura, int recuperacao) {
		super();
		this.forca = forca;
		this.precisao = precisao;
		this.velocidade = velocidade;
		this.armadura = armadura;
		this.recuperacao = recuperacao;
	}
	
	public int getForca() {
		return forca;
	}
	public void setForca(int forca) {
		this.forca = forca;
	}
	public int getPrecisao() {
		return precisao;
	}
	public void setPrecisao(int precisao) {
		this.precisao = precisao;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	public int getArmadura() {
		return armadura;
	}
	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}
	public int getRecuperacao() {
		return recuperacao;
	}
	public void setRecuperacao(int recuperacao) {
		this.recuperacao = recuperacao;
	}
	@Override
	public String toString() {
		return "forca: " + forca + " precisao: " + precisao + " velocidade: " + velocidade + " armadura: "
				+ armadura + " recuperacao: " + recuperacao;
	}
	
	
}
