package com.crunchify.jsp.servlet;
 
import edu.co.sergio.mundo.dao.ColmenaDAO;
import edu.co.sergio.mundo.dao.DepartamentoDAO;
import edu.co.sergio.mundo.vo.Colmena;
import edu.co.sergio.mundo.vo.Departamento;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        ColmenaDAO dao = new ColmenaDAO();
        
        Colmena colmena = new Colmena();

        //Listando la informacion  
        List<Colmena> colmenas =  dao.findAll();
        request.setAttribute("colmenas", colmenas);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        }
}
