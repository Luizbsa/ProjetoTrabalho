package persistencia.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import persistencia.modelos.Casa;
import persistencia.modelos.Nacao;
import persistencia.modelos.Personagem;
import persistencia.modelos.Status;

public class PersonagemDao {
	private String endereco;
	private List<Personagem> personagens = new ArrayList<Personagem>();
	
	public PersonagemDao(String endereco) throws IOException {
		this.endereco = endereco;
		Path path = Paths.get(this.endereco);
		Files.lines(path).forEach(linha -> this.converter(linha)); 
			

			
		
	}

	private void converter(String linha) {
		String linhaFormatada[] = linha.replaceAll(" ", "").split(",");
		Personagem personagem = new Personagem();
		personagem.setId(Integer.parseInt(linhaFormatada[0]));
		personagem.setNome(linhaFormatada[1]);
		personagem.setNacao(Nacao.valueOf(linhaFormatada[2]));
		personagem.setCasa(Casa.valueOf(linhaFormatada[3]));
		personagem.setPontosEnergia(Integer.parseInt(linhaFormatada[4]));
		personagem.setPontosStatus(Integer.parseInt(linhaFormatada[5]));
		
		Status status = new Status();
		status.setForca(Integer.parseInt(linhaFormatada[6]));
		status.setArmadura(Integer.parseInt(linhaFormatada[7]));
		status.setPrecisao(Integer.parseInt(linhaFormatada[8]));
		status.setRecuperacao(Integer.parseInt(linhaFormatada[9]));
		status.setVelocidade(Integer.parseInt(linhaFormatada[10]));
		
		personagem.setStatus(status);
		
		personagens.add(personagem);
		
	}
	
	public void atualizar() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(this.endereco));
		personagens.forEach(personagem -> {
			try {
				writer.write(personagem.resumo());
				writer.newLine();
			} catch (IOException e) {
				
			}
		
		});
		writer.close();
	}
	
	public void addPersonagens(Personagem personagem) {
		
		try {
			int tamanho = personagens.size();
			Personagem ultimoPersonagem = this.personagens.get(tamanho - 1);
			personagem.setId(ultimoPersonagem.getId() + 1);
		} catch (Exception e) {
			personagem.setId(0);
		}
		
		this.personagens.add(personagem);
	}
	
	public Personagem encontrarPorId(int id) {
		for (Personagem personagem : personagens) {
			if(personagem.getId() == id) {
				return personagem;
			}
		}
		
		return null;
	
	}
	
	public void apagarPersonagem(Personagem personagem) {
		this.personagens.remove(personagem);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
	}
	
	
}
