package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;

import java.sql.SQLException;
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

    /**
     * Insere um novo usuário no banco de dados, verificando previamente se o email já está cadastrado.
     *
     * @param usuarioTO Um objeto {@link UsuarioTO} que contém os dados do usuário a ser inserido.
     * @return O objeto {@link UsuarioTO} inserido no banco de dados, ou {@code null} se o email já estiver cadastrado.
     * @throws SQLException Se ocorrer um erro durante a operação de inserção no banco de dados.
     */
    public UsuarioTO inserir(UsuarioTO usuarioTO) throws SQLException {
        usuarioDAO = new UsuarioDAO();

        // Verificar se o email já está cadastrado
        if (usuarioDAO.emailExistente(usuarioTO.getEmailUsuario())) {
            // Se o email já existir, não permite a inserção
            return null;
        }

        return usuarioDAO.inserir(usuarioTO);
    }

    /**
     * Altera os dados de um objeto {@link UsuarioTO} no banco de dados.
     *
     * <p>
     * Este método utiliza a instância de {@link UsuarioDAO}
     * para atualizar o usuário no banco de dados. Não há validações adicionais
     * ou regras de negócios aplicadas.
     * </p>
     *
     * @param usuarioTO O objeto {@link UsuarioTO} que contém os dados atualizados do usuário.
     * @return O objeto {@link UsuarioTO} atualizado, caso a operação seja bem-sucedida;
     *         {@code null} se a operação falhar.
     */
    public UsuarioTO alterar(UsuarioTO usuarioTO){
        usuarioDAO = new UsuarioDAO();
        // Sem validações significativas para o metodo de alterar.
        return usuarioDAO.alterar(usuarioTO);
    }

    /**
     * Exclui um usuário do banco de dados com base no seu ID.
     *
     * <p>
     * Este método remove um usuário do banco de dados com base no ID fornecido.
     * Não realiza validações adicionais ou regras de negócios, apenas executa
     * a exclusão do registro correspondente ao ID informado.
     * </p>
     *
     * @param IdUsuario o ID do usuário que será excluído
     * @return {@code true} se a exclusão for bem-sucedida, {@code false} caso contrário
     */
    public boolean excluir(int IdUsuario){
        usuarioDAO = new UsuarioDAO();
        // Sem validações significativas para o metodo de excluir.
        return usuarioDAO.excluir(IdUsuario);
    }
}
