package net.codejava;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@Path("/teste/selecao/{inicio}/{fim}")
public class Teste {
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
	public String teste(@PathParam("inicio") String inicio, @PathParam("fim") String fim) {
		System.out.println(inicio +" asdasdasd " + fim);
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("https://sheets.googleapis.com/v4/spreadsheets/1JL122Yjhzl8rZ8iq7O6PGNKt46hB8wb_Eyvl8bxJI5Y/values/"
				+ "Trabalho!"+inicio+":"+fim+"?key=AIzaSyCa2KmziN2MGvFbGbVu3ZPdYWTW-bD_BtY");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();  
		
		return "<html><title>Hello</title><body><h1>"+ value +"</h1><body></html>";
	}
}
