package br.com.fiap.resource;

import br.com.fiap.bo.SugestoesBO;
import br.com.fiap.to.SugestoesTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/sugestoes")
public class SugestoesResource {
    private SugestoesBO sugestoesBO = new SugestoesBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodas() {
        ArrayList<SugestoesTO> resultado = sugestoesBO.listarTodas();
        if (resultado != null) {
            return Response.ok(resultado).build(); // 200 - OK com a lista de sugestões
        } else {
            return Response.status(404).entity("Sugestões não encontradas").build(); // 404 NOT FOUND
        }
    }

    @GET
    @Path("/{idSugestao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("idSugestao") int idSugestao){
        SugestoesTO resultado = sugestoesBO.getById(idSugestao);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok(); // 200
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

}
