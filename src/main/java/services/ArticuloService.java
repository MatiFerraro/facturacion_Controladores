package services;

import dtos.ArticuloDTO;
import model.Articulo;

public interface ArticuloService {

    public void ingresarArticulo(ArticuloDTO articuloDTO);
    public ArticuloDTO consultarArticulo(Integer idArticulo);
    public void updateService(ArticuloDTO articuloDTO);
    public void deleteService(Integer idArticulo);

}
