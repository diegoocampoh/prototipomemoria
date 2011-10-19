/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import memoria.commons.structures.coordinates.*;

/**
 *
 * @author Fran
 */
public class Servletprueba extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int cantidadCapas = 3;
        System.out.println("Vino por aca" +  (String)request.getParameter("testo"));
        System.out.println("Vino por aca1" + (String)request.getParameter("id_lat"));
        System.out.println("Vino por aca2" + (String)request.getParameter("id_lng"));
        System.out.println("Vino por aca3" + (String)request.getParameter("id_lat_sw"));
        System.out.println("Vino por aca4" + (String)request.getParameter("id_lng_sw"));
        System.out.println("Vino por aca5" + (String)request.getParameter("id_lat_ne"));
        System.out.println("Vino por aca6" + (String)request.getParameter("id_lng_ne"));
        System.out.println("A ver los checkBox "+ request.getParameter("Escuelas"));

        Coordinate centro = new LatLonCoordinate((String)request.getParameter("id_lat"), (String)request.getParameter("id_lng") );
        Coordinate puntaSW  = new LatLonCoordinate ((String)request.getParameter("id_lat_sw"),(String)request.getParameter("id_lng_sw"));
        Coordinate puntaNE = new LatLonCoordinate((String)request.getParameter("id_lat_ne"),(String)request.getParameter("id_lng_ne"));

        String[] capas = new String[cantidadCapas];
        int tope = 0;
        if(request.getParameter("Escuelas") != null)
        {
            capas[tope] = "Escuelas";
            tope = tope +1;
        }
        if(request.getParameter("Fabrica")!= null)
        {
            capas[tope] = "Fabricas";
            tope = tope + 1;
        }
        if(request.getParameter("Policia")!= null)
        {
            capas[tope] = "Est Policias";
            tope = tope + 1;
        }

        Consultador  cons = new Consultador();
        System.out.println("LLega");
        cons.generarConsulta(puntaNE, puntaSW, centro, capas);







        //System.out.println("Parametro DALEEEE "+request.getSession().getAttribute("pepe"));



        //ACA va el codigo a ejecutar


        response.setContentType("text/html;charset=UTF-8");

        if (request.getSession().getAttribute("parametro") == null){
            //Reenvío
            request.getSession().setAttribute("parametro", new Date());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mapa.jspx");
            dispatcher.forward(request, response);
        } else {
            PrintWriter o = response.getWriter();
            try {
                o.println("Acá mostramos los datos");
            } finally {
                o.close();
            }
        }
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
