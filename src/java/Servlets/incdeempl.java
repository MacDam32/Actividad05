/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.incidenciasEJB;
import entities.Empleado;
import entities.Incidencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vicen
 */
@WebServlet(name = "incdeempl", urlPatterns = {"/incdeempl"})
public class incdeempl extends HttpServlet {

    @EJB
    incidenciasEJB incEJB;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>incidencias de un empleado.</title>");            
            out.println("</head>");
            out.println("<body>");
            List<Incidencia> incidencias = incEJB.findAllIncidencias();
            String usuario = request.getParameter("usuario");
            Empleado e = new Empleado(usuario);
            Incidencia i = new Incidencia();
            if(incEJB.existeEmpleado(e)){
            for(int k=0; k<incidencias.size(); k++){
                if(usuario.equals(incidencias.get(k).getOrigen().getNombreusuario())){
                    i.setIdincidencia(incidencias.get(k).getIdincidencia());
                    i.setFechahora(incidencias.get(k).getFechahora());
                    i.setDetalle(incidencias.get(k).getDetalle());
                    i.setTipo(incidencias.get(k).getTipo());
                    i.setOrigen(incidencias.get(k).getOrigen());
                    i.setDestino(incidencias.get(k).getDestino());
                    out.println(i.toString() + "</br>");
                }           
            }
            }else{
                out.println("No existe ninguna incidencia de ese usuario.");
                }
            out.println("<form action=\"Logged.html\" method=\"POST\">"
                    + "Volver al menú"
                    + "<input type=\"submit\" name=\"volver\" value=\"Volver\" />"
                    + "</form>");             
            out.println("</body>");
            out.println("</html>");
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
