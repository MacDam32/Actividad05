/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import beans.HistorialEJB;
import beans.incidenciasEJB;
import entities.Empleado;
import entities.Historial;
import entities.Incidencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vicent
 */
@WebServlet(name = "insertarinc", urlPatterns = {"/insertarinc"})
public class insertarinc extends HttpServlet {

    @EJB
    incidenciasEJB incEJB;
    @EJB
    HistorialEJB histEJB;
    
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
            out.println("<title>insertar incidencia</title>");            
            out.println("</head>");
            out.println("<body>");
            int id = incEJB.numincidencia()+1;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String FH = sdf.format(new Date());
            String det = request.getParameter("detalle");
            String tipo = request.getParameter("tipo");
            Empleado o = new Empleado(request.getParameter("origen"));
            Empleado origen = incEJB.Emplxusu(o);
            Empleado d = new Empleado(request.getParameter("destino"));
            Empleado destino = incEJB.Emplxusu(d);
            Incidencia I = new Incidencia(id, FH, det, tipo, origen, destino);
            if (incEJB.insertarincidencia(I)){
                out.println("incidencia insertada.");
                int idh = histEJB.numhistorial();
                String tipoh;
                //Historial H = new Historial(idh, tipoh, FH, destino);
                //histEJB.guardarHistorial(H);
                if (tipo.equals("urgente")){
                   tipoh = "U"; 
                   Historial H = new Historial(idh, tipoh, FH, destino);
                   histEJB.guardarHistorial(H);
                }else{
                   tipoh = "C";
                   Historial H = new Historial(idh, tipoh, FH, destino);
                   histEJB.guardarHistorial(H);
                }
            }else out.println("error insertando la incidencia");
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
