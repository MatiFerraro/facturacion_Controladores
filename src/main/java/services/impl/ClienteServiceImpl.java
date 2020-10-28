package services.impl;

import daos.ClienteDAO;
import daos.impl.ClienteDAOImp;
import dtos.ClienteDTO;
import model.Cliente;
import services.ClienteService;

public class ClienteServiceImpl implements ClienteService {

    public void ingresarCliente(ClienteDTO cli) {

        ClienteDAOImp clienteDAO = new ClienteDAOImp();
        Cliente cliente = converterDTOtoModel(cli);

        clienteDAO.insert(cliente);

    }

    public ClienteDTO consultarCliente(int clienteId) {

        ClienteDAOImp clienteDAO = new ClienteDAOImp();

        return converterModeltoDTO(clienteDAO.queyId(clienteId));

    }

    private Cliente converterDTOtoModel(ClienteDTO clienteDTO) {

        Cliente cliente = new Cliente();

        cliente.setNombre(clienteDTO.getNombre());

        return cliente;
    }

    private ClienteDTO converterModeltoDTO(Cliente cliente){

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setNombre(cliente.getNombre());

        return clienteDTO;
    }

}
