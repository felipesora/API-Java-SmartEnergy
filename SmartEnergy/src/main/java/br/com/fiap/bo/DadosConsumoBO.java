package br.com.fiap.bo;

import br.com.fiap.dao.DadosConsumoDAO;
import br.com.fiap.to.DadosConsumoTO;


import java.sql.SQLException;
import java.util.ArrayList;

public class DadosConsumoBO {
    DadosConsumoDAO dadosConsumoDAO;

    /**
     * Retorna uma lista contendo todos os usuários cadastrados.
     *
     * <p>
     * Este método não realiza validações ou regras de negócios específicas,
     * apenas recupera e retorna todos os registros de dados consumo armazenados
     * no banco de dados.
     * </p>
     *
     * @return uma lista de objetos {@link br.com.fiap.to.DadosConsumoTO} representando todos os dados consumo cadastrados
     */
    public ArrayList<DadosConsumoTO> listarTodos() {
        dadosConsumoDAO = new DadosConsumoDAO();
        // Sem validações significativas para o metodo de listar.
        return dadosConsumoDAO.listarTodos();
    }

    /**
     * Retorna as informações de um dados consumo com base no seu ID.
     * <p>
     * Este método consulta o banco de dados para obter os dados do dados consumo correspondente ao ID fornecido.
     * Não há regras de negócios adicionais aplicadas na visualização.
     * </p>
     *
     * @param idUsuario o ID do usuário que se deseja visualizar.
     * @return um objeto {@link DadosConsumoTO} contendo as informações do usuário,
     *         ou {@code null} se o usuário não for encontrado.
     */
    public ArrayList<DadosConsumoTO> getById(int idUsuario) {
        dadosConsumoDAO = new DadosConsumoDAO();
        // Sem validações significativas para o metodo de listar pelo ID.
        return dadosConsumoDAO.getById(idUsuario);
    }


    /**
     * Insere um novo dados consumo no banco de dados.
     *
     * @param dadosConsumoTO Um objeto {@link DadosConsumoTO} que contém os dados do dados consumo a ser inserido.
     * @return O objeto {@link DadosConsumoTO} inserido no banco de dados.
     * @throws SQLException Se ocorrer um erro durante a operação de inserção no banco de dados.
     */
    public DadosConsumoTO inserir(DadosConsumoTO dadosConsumoTO) throws SQLException{
        dadosConsumoDAO = new DadosConsumoDAO();
        // Sem validações significativas para o metodo de inserir.
        return dadosConsumoDAO.inserir(dadosConsumoTO);
    }

    /**
     * Exclui um dados consumo do banco de dados com base no seu ID.
     *
     * <p>
     * Este método remove um dados consumo do banco de dados com base no ID fornecido.
     * Não realiza validações adicionais ou regras de negócios, apenas executa
     * a exclusão do registro correspondente ao ID informado.
     * </p>
     *
     * @param idCosumo o ID do dados consumo que será excluído
     * @return {@code true} se a exclusão for bem-sucedida, {@code false} caso contrário
     */
    public boolean excluir(int idCosumo){
        dadosConsumoDAO = new DadosConsumoDAO();
        // Sem validações significativas para o metodo de excluir.
        return dadosConsumoDAO.excluir(idCosumo);
    }
}
