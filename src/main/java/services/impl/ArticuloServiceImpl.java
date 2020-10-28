package services.impl;

import daos.impl.ArticuloDAOImp;
import dtos.ArticuloDTO;
import model.Articulo;
import services.ArticuloService;

public class ArticuloServiceImpl implements ArticuloService {

    ArticuloDAOImp articuloDAO = new ArticuloDAOImp();

    public void ingresarArticulo(ArticuloDTO art) {

        Articulo articulo = converterDTOtoModel(art);

        articuloDAO.insert(articulo);

    }

    public ArticuloDTO consultarArticulo(Integer idArticulo) {

        return converterModeltoDTO(articuloDAO.queyId(idArticulo));

    }

    private Articulo converterDTOtoModel(ArticuloDTO articuloDTO){

        Articulo articulo = new Articulo();

        articulo.setPrecio(articuloDTO.getPrecio());
        articulo.setDescripcion(articuloDTO.getDescripcion());

        return articulo;
    }

    private ArticuloDTO converterModeltoDTO(Articulo articulo){

        ArticuloDTO articuloDTO = new ArticuloDTO();

        articuloDTO.setPrecio(articulo.getPrecio());
        articuloDTO.setDescripcion(articulo.getDescripcion());

        return articuloDTO;

    }

    public void updateService(ArticuloDTO articuloDTO) {

        articuloDAO.update(converterDTOtoModel(articuloDTO));

    }

    public void deleteService(Integer idArticulo) {

        articuloDAO.delete(idArticulo);

    }

}
