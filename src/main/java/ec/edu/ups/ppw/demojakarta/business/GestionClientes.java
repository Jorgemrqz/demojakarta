package ec.edu.ups.ppw.demojakarta.business;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.ClienteDAO;
import ec.edu.ups.ppw.demojakarta.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {
	  @Inject
	    private ClienteDAO daoCliente;
	    
	  
	  //Aqui se aplica la logica y validaciones
		
	    public Cliente getCliente(String cedula) throws Exception {
			if(cedula.length() != 10) {
				throw new Exception("Cedula Incorrecta");
			}
			
			Cliente cliente = daoCliente.read(cedula);
			if(cliente == null)
				throw new Exception("Cliente no existe");
			return cliente;
		}
		
		public List<Cliente> getClientes(){
			return daoCliente.getAll();
		}
		
		public void createCliente(Cliente cliente) throws Exception {
			if(cliente.getCedula().length() != 10) {
				throw new Exception("Cedula Incorrecta");
			}			
			daoCliente.insert(cliente);
		}
		
		public void deleteCliente(String cedula) throws Exception{
			if(cedula.length() != 10) {
				throw new Exception("Cedula Incorrecta");
			}	
			daoCliente.delete(cedula);
		}
		
		public void updateCliente(Cliente cliente) throws Exception{
			daoCliente.update(cliente);
		}

}