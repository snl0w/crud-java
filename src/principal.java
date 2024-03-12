import java.util.ArrayList;
import javax.swing.JOptionPane;

public class principal {

    public static void main(String[] args) {

        // ArrayList para armazanar os dados dos usuarios
        ArrayList<usuario> listaUsuarios = new ArrayList<usuario>();

        // ArrayList para armazenar os dados dos afiliados ("usuario VIP")
        ArrayList<afiliado> listaAfiliados = new ArrayList<afiliado>();

        // Mensagem de boas vindas
        JOptionPane.showMessageDialog(null, "Bem-Vindo(a) ao meu CRUD!");

        // Declaração da variavel de opção "op"
        int op;

        // Código será repetido até que seja digitado a opção de saida
        do {

            // Menu de opções
            String input = JOptionPane.showInputDialog(
                    "1 - Criar usuário\n" +
                            "2 - Criar afiliado\n" +
                            "3 - Atualizar usuário\n" +
                            "4 - Atualizar afiliados\n" +
                            "5 - Excluir usuário\n" +
                            "6 - Excluir afiliado\n" +
                            "7 - Listar usuário\n" +
                            "8 - Listar afiliado\n" +
                            "0 - Encerrar o programa\n" +
                            "	 \nDigite a opção desejada:");
            op = Integer.parseInt(input);

            switch (op) {
                // Sair do programa
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    System.exit(0);
                    break;
                // Criar usuário
                case 1:
                    String nome;
                    int limitenome = 0;
                    do {
                        if (limitenome >= 50) {
                            JOptionPane.showMessageDialog(null, "Limite de letras ultrapassado.");
                        }
                        nome = JOptionPane.showInputDialog("Digite o nome do usuário: ");
                        limitenome = nome.length();

                    } while (limitenome >= 50);
                    usuario novoUsuario = new usuario(nome);
                    listaUsuarios.add(novoUsuario);
                    JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
                    break;
                // Criar afiliado
                case 2:
                    nome = JOptionPane.showInputDialog("Digite o nome do afiliado: ");
                    afiliado novoAfiliado = new afiliado(nome);
                    listaAfiliados.add(novoAfiliado);
                    JOptionPane.showMessageDialog(null, "Afiliação criado com sucesso!");
                    break;
                // Atualizar usuário
                case 3:
                    String idInput = JOptionPane.showInputDialog("Digite o ID do usuário a ser atualizado: ");
                    long idAtualizar = Long.parseLong(idInput);
                    boolean encontrado = false;

                    for (usuario usuario : listaUsuarios) {
                        if (usuario.getId() == idAtualizar) {
                            String novoNome = JOptionPane.showInputDialog("Digite o novo nome: ");
                            usuario.setNome(novoNome);
                            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
                            encontrado = true;

                        }
                    }
                    break;
                // Atualizar afiliado
                case 4:
                    String idInputAfiliado = JOptionPane.showInputDialog("Digite o ID do afiliado a ser atualizado:");
                    idAtualizar = Long.parseLong(idInputAfiliado);
                    encontrado = false;
                    for (afiliado afiliado : listaAfiliados) {
                        if (afiliado.getId() == idAtualizar) {
                            String novoNome = JOptionPane.showInputDialog("Digite o novo nome:");
                            afiliado.setNome(novoNome);
                            JOptionPane.showMessageDialog(null, "Afiliado atualizado com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "Afiliado não encontrado no banco de dados da Magic Ring.");
                    }

                    break;

                // Excluir usuário
                case 5:
                    idInput = JOptionPane.showInputDialog("Digite o ID do usuário a ser excluído:");
                    long idDeletar = Long.parseLong(idInput);
                    usuario usuarioDeletar = null;

                    for (usuario usuario : listaUsuarios) { // Criação de variavel local "usuario" para o ArrayList dos
                                                            // usuários
                        if (usuario.getId() == idDeletar) {
                            usuarioDeletar = usuario;
                            break;
                        }
                    }

                    if (usuarioDeletar != null) {
                        listaUsuarios.remove(usuarioDeletar); // Remove o objeto que recebeu o usuário
                        JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado."); // Mensagem de erro caso o ID
                                                                                        // digitado não seja encontrado
                    }
                    break;

                // Excluir afiliado
                case 6:
                    idInputAfiliado = JOptionPane.showInputDialog("Digite o ID do afiliado a ser excluído: ");
                    idDeletar = Long.parseLong(idInputAfiliado);
                    afiliado afiliadoDeletar = null; // Objeto vazio para o afiliado ser deletado

                    for (afiliado afiliado : listaAfiliados) { // Criação de variavel local "afiliado" para o ArrayList
                                                               // dos afiliados
                        if (afiliado.getId() == idDeletar) { // getId busca o ID do afiliado para ser deletado
                            afiliadoDeletar = afiliado; // Objeto vazio recebe o afiliado que deseja deletar
                            break;
                        }
                    }

                    if (afiliadoDeletar != null) {
                        listaAfiliados.remove(afiliadoDeletar); // Remove o objeto que recebeu o afiliado
                        JOptionPane.showMessageDialog(null, "Afiliado deletado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Afiliado não encontrado."); // Mensagem de erro caso o ID
                                                                                         // digitado não seja encontrado
                    }
                    break;

                // Status do usuário
                case 7:
                    StringBuilder userMessage = new StringBuilder("Usuários:\n");
                    for (usuario lerUsuarios : listaUsuarios) {
                        userMessage.append("Nome: ").append(lerUsuarios.getNome()).append("\n");
                        userMessage.append("ID: ").append(lerUsuarios.getId()).append("\n");
                        userMessage.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, userMessage.toString());
                    break;
                // Status do afiliado
                case 8:
                    StringBuilder afiliadoMessage = new StringBuilder("Afiliados:\n");
                    for (afiliado lerAfiliados : listaAfiliados) {
                        afiliadoMessage.append("Nome: ").append(lerAfiliados.getNome()).append("\n");
                        afiliadoMessage.append("ID: ").append(lerAfiliados.getId()).append("\n");
                        afiliadoMessage.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, afiliadoMessage.toString());
                    break;
                // Mensagem de erro caso o cliente digite uma opção invalída
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }

        } while (op != 0);
    }
}