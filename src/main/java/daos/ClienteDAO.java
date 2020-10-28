package daos;

import model.Cliente;

public interface ClienteDAO {

    public void insert(Cliente cliente);
    public void update(Cliente cliente);
    public void delete(Integer id);
    public Cliente queyId(Integer id);

}
