package controler;

import dtos.ArticuloDTO;
import services.ArticuloService;
import services.impl.ArticuloServiceImpl;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ArticuloControler extends HttpServlet {

    ArticuloDTO articuloDTO = new ArticuloDTO();
    ArticuloService articuloService = new ArticuloServiceImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        ArticuloService articuloService = new ArticuloServiceImpl();

        articuloService.consultarArticulo((Integer.parseInt(req.getParameter("id"))));

        // Obtenemos un objeto Print Writer para enviar respuesta
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Llamar al recurso Articulo</p>");
        pw.println("</body>");
        pw.close();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        articuloDTO.setDescripcion(req.getParameter("descripcion"));

        articuloService.ingresarArticulo(articuloDTO);
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Post</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Crear Articulo</p>");
        pw.println(req.getParameter("descripcion"));
        pw.println(req.getParameter("precio"));
        pw.println("</body>");
        pw.close();

    }


    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        articuloDTO.setPrecio(Float.parseFloat(req.getParameter("precio")));
        articuloDTO.setDescripcion(req.getParameter("descripcion"));

        articuloService.updateService(articuloDTO);

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Se realizo un doPut</p>");
        pw.println("</body>");
        pw.close();

    }


    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        articuloService.deleteService(Integer.parseInt(req.getParameter("idArticulo")));

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Se elimino Articulo</p>");
        pw.println("</body>");
        pw.close();

    }
}