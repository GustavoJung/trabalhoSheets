package br.udesc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@Path("/homepage")
public class Homepage {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String direBonjour() {
		return "Rafael";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJsonHello() {
		return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde!\"}";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String homepage() {
		return "<html><title>Trabalho</title>"
				+ "<body><br>"
				+ "<h1>Get"
				+ " </h1>"
				+ "Selecione a coluna inicial e a linha que deseja buscar (Ex.: A1, B2, C3)"
				+ "<input type=\"text\" id=\"inicial\" name=\"inicial\"><br><br>"
				+ "Selecione a coluna final e a linha que deseja buscar (Ex.: D1, E2, F3)"
				+ "<input type=\"text\" id=\"inicial\" name=\"inicial\"><br><br>"
				+ "<a href=\"http://localhost:8080/HelloREST/teste/selecao{inicio}{fim}>\r\n"
				+ "   <button>Visit Google</button>\r\n"
				+ "</a>\r\n"
				+ ""
				+ "<body></html>";
	}
}
