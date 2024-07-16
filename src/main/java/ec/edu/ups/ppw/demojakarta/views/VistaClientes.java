package ec.edu.ups.ppw.demojakarta.views;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.business.GestionClientes;
import ec.edu.ups.ppw.demojakarta.model.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("clientes")
@RequestScoped
public class VistaClientes {

	@Inject
	private GestionClientes gClientes;
	
	private Cliente persona = new Cliente();
	
	private List<Cliente> listado;
	
	@PostConstruct
	public void init() {
		listado = gClientes.getClientes();
	}
	
	public Cliente getPersona() {
		return persona;
	}
	public void setPersona(Cliente persona) {
		this.persona = persona;
	}
	
	public List<Cliente> getListado() {
		return listado;
	}
	
	public void setListado(List<Cliente> listado) {
		this.listado = listado;
	}
	
	public String guardar() {
		System.out.println(this.persona);
		
		try {
			gClientes.createCliente(persona);
			return "listadoclientes?faces-redirect-true";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
}
