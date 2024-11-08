package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
}
