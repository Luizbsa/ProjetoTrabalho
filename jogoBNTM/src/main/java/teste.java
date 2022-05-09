import java.io.IOException;

import persistencia.dao.PersonagemDao;
import persistencia.modelos.Casa;
import persistencia.modelos.Nacao;
import persistencia.modelos.Personagem;
import persistencia.modelos.Status;
import servico.controller.PersonagemController;
import servico.dto.CriarPersonagemDto;
import servico.dto.ListarPersonagemDto;

public class teste {

	public static void main(String[] args) throws IOException {
		//instancia do Controller
		PersonagemController controller = new PersonagemController();


		//Criando personagem cru
		controller.criarPersonagem(new CriarPersonagemDto("Luiz", Nacao.ANAO));

		//selecionando o personagem que criamos
		Personagem personagem = controller.selecionarPersonagem(0);

		//atribuindo status para o nosso personagem
		controller.setarPontosEmRecuperacao(20, personagem);

		//mudando nome do personagem
		controller.mudarNome("Claudio", 0);

		//Listar os personagens e seus id
		for(ListarPersonagemDto dto : controller.listar()){
			System.out.println(dto);
		}

		//Mostar status do personagem
		System.out.println(controller.mostrarStatus(personagem));

		//apagando nosso personagem
		controller.apagarPersonagem(0);


	}
}
