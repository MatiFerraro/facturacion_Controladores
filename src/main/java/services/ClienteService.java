package services;

import dtos.ClienteDTO;

public interface ClienteService {

    void ingresarCliente(ClienteDTO cli);
    public ClienteDTO consultarCliente(int clienteId);

}
