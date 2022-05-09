package servico.controller;

import persistencia.dao.PersonagemDao;
import persistencia.modelos.Casa;
import persistencia.modelos.Personagem;
import persistencia.modelos.Status;
import servico.dto.CriarPersonagemDto;
import servico.dto.ListarPersonagemDto;
import servico.dto.MostrarStatusDosPersonagensDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemController {
    private PersonagemDao dao = new PersonagemDao("arquivoBNTM.txt");

    public PersonagemController() throws IOException {
    }

    public List<ListarPersonagemDto> listar(){
        List<ListarPersonagemDto> listaDto = new ArrayList<>();
        dao.getPersonagens().forEach(personagem -> {
           ListarPersonagemDto dto = new ListarPersonagemDto();
           dto.converter(personagem);
           listaDto.add(dto);
       });

        return listaDto;
    }

    public MostrarStatusDosPersonagensDto mostrarStatus(Personagem personagem){
        return new MostrarStatusDosPersonagensDto(personagem);
    }

    public void mudarNome(String novoNome, int id){
        Personagem personagem = this.selecionarPersonagem(id);
        personagem.setNome(novoNome);

    }

    public void setarPontosEmForça(int pontos, Personagem personagem) throws IOException {
        if(personagem.getPontosStatus() >= pontos){
            personagem.setPontosStatus(personagem.getPontosStatus() - pontos);
            personagem.getStatus().setForca(pontos + personagem.getStatus().getForca());
            dao.atualizar();
            System.out.println("Pontos atribuidos com Sucesso");
        }else {
            System.out.println("Erro: você não tem pontos o suficiente");
        }
    }

    public void setarPontosEmVelocidade(int pontos, Personagem personagem) throws IOException {
        if(personagem.getPontosStatus() >= pontos){
            personagem.setPontosStatus(personagem.getPontosStatus() - pontos);
            personagem.getStatus().setVelocidade(pontos + personagem.getStatus().getVelocidade());
            dao.atualizar();
            System.out.println("Pontos atribuidos com Sucesso");
        }else{
            System.out.println("Erro: você não tem pontos o suficiente");
        }
    }

    public Personagem selecionarPersonagem(int id){
        return dao.encontrarPorId(id);
    }

    public void setarPontosEmPrecisao(int pontos, Personagem personagem) throws IOException {
        if(personagem.getPontosStatus() >= pontos){
            personagem.setPontosStatus(personagem.getPontosStatus() - pontos);
            personagem.getStatus().setPrecisao(pontos + personagem.getStatus().getPrecisao());
            dao.atualizar();
            System.out.println("Pontos atribuidos com Sucesso");
        }else{
            System.out.println("Erro: você não tem pontos o suficiente");
        }
    }

    public void setarPontosEmArmadura(int pontos, Personagem personagem) throws IOException {
        if(personagem.getPontosStatus() >= pontos){
            personagem.setPontosStatus(personagem.getPontosStatus() - pontos);
            personagem.getStatus().setArmadura(pontos + personagem.getStatus().getArmadura());
            dao.atualizar();
            System.out.println("Pontos atribuidos com Sucesso");
        }else{
            System.out.println("Erro: você não tem pontos o suficiente");
        }
    }

    public void setarPontosEmRecuperacao(int pontos, Personagem personagem) throws IOException {
        if(personagem.getPontosStatus() >= pontos){
            personagem.setPontosStatus(personagem.getPontosStatus() - pontos);
            personagem.getStatus().setRecuperacao(pontos + personagem.getStatus().getRecuperacao());
            dao.atualizar();
            System.out.println("Pontos atribuidos com Sucesso");
        }else{
            System.out.println("Erro: você não tem pontos o suficiente");
        }
    }

    public void criarPersonagem(CriarPersonagemDto personagemDto) throws IOException {
       Personagem personagem = personagemDto.converter();
       personagem.setPontosEnergia(100);
       personagem.setPontosStatus(100);
       personagem.setStatus(new Status(0, 0, 0, 0, 0));
       this.setarCasaAutomaticamente(personagem);
       dao.addPersonagens(personagem);
       dao.atualizar();

    }

    public void apagarPersonagem(int id) throws IOException {
        dao.apagarPersonagem(dao.encontrarPorId(id));
        dao.atualizar();
        System.out.println("personagem apagado com sucesso!");
    }

    private void setarCasaAutomaticamente(Personagem personagem){
        switch (personagem.getNacao()){
            case ORC_SNAGA:
                personagem.setCasa(Casa.CIRITH_UNGOL);
                break;
            case URUK_HAI:
                personagem.setCasa(Casa.PORTAO_NEGRO);
                break;
            case CAVALEIRO_DE_ROHAN:
                personagem.setCasa(Casa.ABISMO_DE_HELM);
                break;
            case GUERREIRO_DE_GONDOR:
                personagem.setCasa(Casa.MINAS_TIRITH);
                break;
            case HOBBIT:
                personagem.setCasa(Casa.O_CONDADO);
                break;
            case ELFO_DA_FLORESTA:
                personagem.setCasa(Casa.FLORESTA_DAS_TREVAS);
                break;
            case ELFO_DE_LOTHLORIEN:
                personagem.setCasa(Casa.CARAS_GALADHON);
                break;
            case ANAO:
                personagem.setCasa(Casa.COLINAS_DE_FERRO);
                break;


        }
    }

}
