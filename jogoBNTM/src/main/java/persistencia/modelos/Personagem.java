package persistencia.modelos;

public class Personagem {
	
	private int id;
	private String nome;
	private int pontosStatus;
	private int pontosEnergia; 
	private Status status;
	private Nacao nacao;
	private Casa casa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontosStatus() {
		return pontosStatus;
	}

	public void setPontosStatus(int pontosStatus) {
		this.pontosStatus = pontosStatus;
	}

	public int getPontosEnergia() {
		return pontosEnergia;
	}

	public void setPontosEnergia(int contosEnergia) {
		this.pontosEnergia = contosEnergia;
	}

	public Nacao getNacao() {
		return nacao;
	}

	public void setNacao(Nacao nacao) {
		this.nacao = nacao;
	}

	public Casa getCasa() {
		return casa;
	}

	

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "id: " + id + " nome: " + nome + " pontosStatus: " + pontosStatus + " pontosEnergia: "
				+ pontosEnergia + " status: " + status + " nacao: " + nacao + " casa: " + casa;
	}
	
	public String resumo() {
		return this.id + ", " + this.nome + ", " + this.nacao + ", " + this.casa + ", " + this.pontosEnergia + ", " + this.pontosStatus
				+ ", " + this.status.getForca() + ", " + this.status.getArmadura() + ", " + this.status.getPrecisao() + ", " + this.status.getRecuperacao()
				+ ", " + this.status.getVelocidade();
	}
	
	
	
	
	
	
}