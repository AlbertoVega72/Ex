/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
@WebServlet(urlPatterns = {"/logeo"})
public class logeo extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int res = Integer.parseInt(request.getParameter("numero1")) + Integer.parseInt(request.getParameter("numero2"));
        HttpSession sesion = request.getSession();
        sesion.setAttribute("Resultado", res);
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");

        for (int i = 0; i < nombre.length(); i++) {
            if (nombre.charAt(i) == Character.DECIMAL_DIGIT_NUMBER) {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Holi</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Error</h1>");
                    out.println("</body>");
                    out.println("</html>");
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Holi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculador</h1>");
            out.println("<center><br><br><br><form method=\"Get\" action=\"logeo\"> ");
            out.println("<input type=\"number\" name=\"numero1\"> + ");
            out.println("<input type=\"number\" name=\"numero2\"><br><br>");
            out.println("<input type=\"submit\" value=\"Enviar Resultado\">");
            out.println("<input type=\"button\" value=\"Salir\">");
            out.println("</form></center>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.getMessage();
        }
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
