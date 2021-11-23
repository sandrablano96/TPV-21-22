/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crud;
import modelo.Productos;

/**
 *
 * @author DAW-A
 */
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Productos> listado = Crud.getProductos();
        String operacion = request.getParameter("op");

        /**
         * LISTAR
         */
        switch (operacion) {
            case "listar":
                request.setAttribute("productos", listado);
                request.setAttribute("mensaje", "");
                request.getRequestDispatcher("verProductos.jsp").forward(request, response);
                /**
                 * INSERTAR DATOS
                 */     break;
            case "insertar":
                request.setAttribute("operacion", "insertarDatos");
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "insertarDatos":
                {
                    Productos prod = new Productos();
                    prod.setNombre(request.getParameter("nombre"));
                    prod.setPrecio(Float.parseFloat(request.getParameter("precio")));
                    prod.setCategoria(request.getParameter("categoria"));
                    prod.setImagen("imagen.jpg");
                    Crud.insertaProducto(prod);
                    request.setAttribute("productos", listado);
                    request.setAttribute("mensaje", "Producto insertado");
                    request.setAttribute("op", "listar");
                    request.getRequestDispatcher("verProductos.jsp").forward(request, response);
                    break;
                }
            case "borrar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    if (Crud.destroyProducto(id) != 0) {
                        request.setAttribute("productos", listado);
                        request.setAttribute("mensaje", "Produco con id " + id + " borrado");
                        request.getRequestDispatcher("verProductos.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", "No se ha podido eliminar");
                        request.setAttribute("productos", listado);
                        request.getRequestDispatcher("verProductos.jsp").forward(request, response);
                    }
                    /**
                     * ACTUALIZAR
                     */     break;
                }
            case "actualizar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Productos prod = Crud.getProducto(id);
                    request.setAttribute("operacion", "actualizar");
                    request.setAttribute("producto", prod);
                    request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                    break;
                } /**
                 * ACTUALIZAR DATOS
                 */
            case "actualizarDatos":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nombre = request.getParameter("nombre");
                    float precio = Float.parseFloat(request.getParameter("precio"));
                    String categoria = request.getParameter("categoria");
                    Productos prod = new Productos(id, nombre, categoria, precio);
                    if (Crud.actualizarProducto(prod) != 0) {
                        request.setAttribute("mensaje", "Producto con id " + id + " actualizado");
                        request.setAttribute("producto", prod);
                        request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensaje", "No se ha podido actualizar");
                        request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                    }       break;
                }
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
