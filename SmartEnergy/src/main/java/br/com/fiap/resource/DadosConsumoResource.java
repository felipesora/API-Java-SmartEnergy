package br.com.fiap.resource;

import br.com.fiap.bo.DadosConsumoBO;
import br.com.fiap.dao.DadosConsumoDAO;
import br.com.fiap.to.DadosConsumoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/dados-consumo")
public class DadosConsumoResource {
    private DadosConsumoBO dadosConsumoBO = new DadosConsumoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos() {
        ArrayList<DadosConsumoTO> resultado = dadosConsumoBO.listarTodos();
        if (resultado != null) {
            return Response.ok(resultado).build(); // 200 - OK com a lista de usuários
        } else {
            return Response.status(404).entity("Usuários não encontrados").build(); // 404 NOT FOUND
        }
    }

    @GET
    @Path("/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("idUsuario") int idUsuario) {
        // Obtenha uma lista de objetos DadosConsumoTO
        ArrayList<DadosConsumoTO> resultados = dadosConsumoBO.getById(idUsuario);
        Response.ResponseBuilder response = null;

        if (resultados != null && !resultados.isEmpty()) {
            response = Response.ok(resultados); // Retorna a lista completa de resultados
        } else {
            response = Response.status(404); // 404 NOT FOUND se não houver registros
        }

        return response.build();
    }




    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(@Valid DadosConsumoTO dadosConsumoTO) throws SQLException {
        DadosConsumoDAO dadosConsumoDAO = new DadosConsumoDAO();
        Response.ResponseBuilder response = null;
        DadosConsumoTO resultado = dadosConsumoDAO.inserir(dadosConsumoTO);
        if (resultado != null){
            response = Response.created(null); //201 CREATED
        } else {
            response = Response.status(400); // BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{idCosumo}")
    public Response excluir(@PathParam("idCosumo") int idConsumo){
        if (dadosConsumoBO.excluir(idConsumo)){
            return Response.status(204).build(); // 204 NO CONTENT
        } else {
            return Response.status(404).entity("Dados Consumo não encontrado").build(); // 404 NOT FOUND
        }
    }
}
