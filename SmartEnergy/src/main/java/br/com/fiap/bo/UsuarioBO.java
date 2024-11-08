package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;

import java.util.ArrayList;

public class UsuarioBO {
    UsuarioDAO usuarioDAO;

    /**
     * Retorna uma lista contendo todos os usuários cadastrados.
     *
     * <p>
     * Este método não realiza validações ou regras de negócios específicas,
     * apenas recupera e retorna todos os registros de usuários armazenados
     * no banco de dados.
     * </p>
     *
     * @return uma lista de objetos {@link UsuarioTO} representando todos os usuários cadastrados
     */
    public ArrayList<UsuarioTO> listarTodos() {
        usuarioDAO = new UsuarioDAO();
        // Sem validações significativas para o metodo de listar.
        return usuarioDAO.listarTodos();
    }

    /**
     * Retorna as informações de um usuário com base no seu ID.
     * <p>
     * Este método consulta o banco de dados para obter os dados do usuário correspondente ao ID fornecido.
     * Não há regras de negócios adicionais aplicadas na visualização.
     * </p>
     *
     * @param idUsuario o ID do usuário que se deseja visualizar.
     * @return um objeto {@link UsuarioTO} contendo as informações do usuário,
     *         ou {@code null} se o usuário não for encontrado.
     */
    public UsuarioTO getById (int idUsuario){
        usuarioDAO = new UsuarioDAO();
        // Sem validações significativas para o metodo de listar pelo ID.
        return usuarioDAO.getById(idUsuario);
    }
}
