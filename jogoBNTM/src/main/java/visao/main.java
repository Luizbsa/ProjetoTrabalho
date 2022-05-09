package visao;

import persistencia.modelos.Nacao;
import persistencia.modelos.Personagem;
import servico.controller.PersonagemController;
import servico.dto.CriarPersonagemDto;
import servico.dto.ListarPersonagemDto;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        PersonagemController controller = new PersonagemController();

        System.out.println("Menu Principal");
        System.out.println("1 - Criar personagem");
        System.out.println("2 - Selecionar personagem");
        System.out.println("3 - listar os personagem");

        System.out.println("Digite alguma das opcao a cima: ");

        Scanner valor = new Scanner(System.in);
        int opcao = valor.nextInt();

        switch (opcao) {
            case 1: {

                System.out.println("Digite o nome do seu personagem:");

                Scanner nome = new Scanner(System.in);
                String Nome = nome.nextLine();

                System.out.println("Agora escolha uma das nacao!");
                System.out.println("A - ORC_SNAGA ");
                System.out.println("B - URUK_HAI");
                System.out.println("C - CAVALEIRO_DE_ROHAN ");
                System.out.println("D - GUERREIRO_DE_GONDOR");
                System.out.println("E - HOBBIT");
                System.out.println("F - ELFO_DA_FLORESTA ");
                System.out.println("G - ANAO ");
                Scanner valor2 = new Scanner(System.in);
                String opcaoN = valor2.nextLine();

                Nacao nat = null;
                switch(opcaoN){
                    case "A":{
                       nat = Nacao.ORC_SNAGA;
                       break;
                    }
                    case "B":{
                        nat = Nacao.URUK_HAI;
                        break;
                    }
                    case "C":{
                        nat = Nacao.CAVALEIRO_DE_ROHAN;
                        break;
                    }
                    case "D":{
                        nat = Nacao.GUERREIRO_DE_GONDOR;
                        break;
                    }
                    case "E":{
                        nat = Nacao.HOBBIT;
                        break;
                    }
                    case "F":{
                        nat = Nacao.ELFO_DA_FLORESTA;
                        break;
                    }
                    case "G":{
                        nat = Nacao.ANAO;
                        break;
                    }
                    default:{
                        System.out.println("OPCAO INVALIDA!!");
                    }
                }

                controller.criarPersonagem(new CriarPersonagemDto(Nome, nat));
                System.out.println("Personagem Criado Com Sucesso!");
                break;
            }
            case 2: {
                System.out.println("Digite o id do personagem:");
                int id = valor.nextInt();

                Personagem personagem = controller.selecionarPersonagem(id);

                System.out.println("o personagem que voce escolheu foi o \n" + personagem );
                System.out.println("1 - atribuir pontos de habilidade");
                System.out.println("2 - mudar nome de personagem");
                System.out.println("3 - Monstrar status do personagem selecionado");
                System.out.println("4 - Apagar Personagem selecionado");
                System.out.println("5 - Batalhar com o persoagem");

                Scanner valor3 = new Scanner(System.in);
                int opcaoG = valor3.nextInt();

                switch (opcaoG){
                    case 1:{
                        System.out.println("qual status deseja atribuir os pontos?");
                        System.out.println("A -  forca");
                        System.out.println("B - precisao");
                        System.out.println("C - velocidade");
                        System.out.println("D - armadura");
                        System.out.println("E - recuperacao");

                        Scanner valor4 = new Scanner(System.in);
                        String opcaoR = valor4.nextLine();

                        System.out.println("Quantos pontos deseja atribuir Nessa habilidade?");

                        Scanner valor5 = new Scanner(System.in);
                        int pontos = valor5.nextInt();


                        switch (opcaoR){
                            case "A":{
                                controller.setarPontosEmForça(pontos, personagem);
                                break;
                            }
                            case "B":{
                                controller.setarPontosEmPrecisao(pontos, personagem);
                                break;
                            }
                            case "C":{
                                controller.setarPontosEmVelocidade(pontos, personagem);
                                break;
                            }
                            case "D":{
                                controller.setarPontosEmArmadura(pontos, personagem);
                                break;
                            }
                            case "E":{
                                controller.setarPontosEmRecuperacao(pontos, personagem);
                                break;
                            }
                            default:{
                                System.out.println("OPCAO INVALIDA!!");
                            }
                        }
                        break;
                    }
                    case 2:{
                        System.out.println("digite seu novo nome: ");
                        Scanner valor6 = new Scanner(System.in);
                        String novNome = valor6.nextLine();

                        controller.mudarNome(novNome, id);
                        System.out.println("nome alterado com sucesso!");
                        break;
                    }
                    case 3:{
                        System.out.println(controller.mostrarStatus(personagem));
                        break;
                    }
                    case 4:{
                        controller.apagarPersonagem(id);
                        break;
                    }
                    case 5:{
                        System.out.println("NÃO CONSIGIMOS FAZER :(");
                        break;
                    }
                    default:{
                        System.out.println("OPCAO INVALIDA!!");
                    }
                }

                break;
            }
            case 3: {
                for (ListarPersonagemDto dto : controller.listar()) {
                    System.out.println(dto);

                }
                break;
            }
            default:{
                System.out.println("OPCAO INVALIDA!!");
            }
        }
    }
}