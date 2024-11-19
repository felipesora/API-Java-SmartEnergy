package br.com.fiap.bo;

import br.com.fiap.dao.SugestoesDAO;
import br.com.fiap.to.SugestoesTO;

import java.util.ArrayList;

public class SugestoesBO {
    SugestoesDAO sugestoesDAO;

    /**
     * Retorna uma lista contendo todos as sugestões cadastrados.
     *
     * <p>
     * Este método não realiza validações ou regras de negócios específicas,
     * apenas recupera e retorna todos os registros de usuários armazenados
     * no banco de dados.
     * </p>
     *
     * @return uma lista de objetos {@link br.com.fiap.to.SugestoesTO} representando todos as sugestões cadastrados
     */
    public ArrayList<SugestoesTO> listarTodas(){
        sugestoesDAO = new SugestoesDAO();
        // Sem validações significativas para o metodo de listar.
        return sugestoesDAO.listarTodas();
    }

    /**
     * Retorna as informações de uma sugestão com base no seu ID.
     * <p>
     * Este método consulta o banco de dados para obter os dados da sugestão correspondente ao ID fornecido.
     * Não há regras de negócios adicionais aplicadas na visualização.
     * </p>
     *
     * @param idSugestao o ID do sugestão que se deseja visualizar.
     * @return um objeto {@link SugestoesTO} contendo as informações da sugestão,
     *         ou {@code null} se a sugestão não for encontrada.
     */
    public SugestoesTO getById (int idSugestao){
        sugestoesDAO = new SugestoesDAO();
        // Sem validações significativas para o metodo de listar pelo ID.
        return sugestoesDAO.getById(idSugestao);
    }
}
