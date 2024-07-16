package ec.edu.ups.ppw.demojakarta.business;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.ClienteDAO;
import ec.edu.ups.ppw.demojakarta.model.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@PostConstruct
	public void init() {
		
		Cliente cliente = new Cliente();
		cliente.setCedula("1729635019");
		cliente.setNombre("Jorge Marquez");
		cliente.setDireccion("Yanuncay");
		
		Cliente cliente1 = new Cliente();
		cliente1.setCedula("0706623873");
		cliente1.setNombre("Roberto Romero");
		cliente1.setDireccion("El Batan");
		
		daoCliente.insert(cliente);
		daoCliente.insert(cliente1);
		
		List<Cliente> listado = daoCliente.getAll();
		for(Cliente cli: listado) {
			System.out.println(cli.getCedula() + " " + cli.getNombre());
		}
	}	
}
