package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/usuario")
public class UsuarioResource {
    private UsuarioBO usuarioBO = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos() {
        ArrayList<UsuarioTO> resultado = usuarioBO.listarTodos();
        if (resultado != null) {
            return Response.ok(resultado).build(); // 200 - OK com a lista de usuários
        } else {
            return Response.status(404).entity("Usuários não encontrados").build(); // 404 NOT FOUND
        }
    }

    @GET
    @Path("/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("idUsuario") int idUsuario){
        UsuarioTO resultado = usuarioBO.getById(idUsuario);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok(); // 200
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(@Valid UsuarioTO usuarioTO) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Response.ResponseBuilder response = null;

        // Chama o método de inserção e verifica se retornou null, o que significa que o email já existe
        UsuarioTO resultado = usuarioBO.inserir(usuarioTO);
        if (resultado != null) {
            response = Response.created(null); // 201 CREATED
            response.entity(resultado);
        } else {
            response = Response.status(400).entity("{\"message\":\"Email já cadastrado.\"}"); // 400 BAD REQUEST
        }
        return response.build();
    }


    @PUT
    @Path("/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterar(@Valid UsuarioTO usuarioTO, @PathParam("idUsuario") int idUsuario){
        usuarioTO.setIdUsuario(idUsuario);
        UsuarioTO resultado = usuarioBO.alterar(usuarioTO);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null); // 201 CREATED
        } else {
            response = Response.status(400); // BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{idUsuario}")
    public Response excluir(@PathParam("idUsuario") int idUsuario){
        if (usuarioBO.excluir(idUsuario)){
            return Response.status(204).build(); // 204 NO CONTENT
        } else {
            return Response.status(404).entity("Usuário não encontrado").build(); // 404 NOT FOUND
        }
    }


}
