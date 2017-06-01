/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Departamento;
import edu.co.sergio.mundo.vo.Colmena;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Labing
 */
public class ColmenaDAO {
    public List<Colmena> findAll() {
		List<Colmena> colmenas= null;
	    String query = "SELECT * FROM Colmena";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int id =0;
	    int idA =0;
            
	    String nombreTec = null;
	
	    while (rs.next()){
	    	if(colmenas == null){
	    		colmenas= new ArrayList<Colmena>();
	    	}
	      
	        Colmena registro= new Colmena();
	        id = rs.getInt("id_colmena");
	        registro.setId_Colmena(id);
	        
                idA = rs.getInt("id_apiario");
	        registro.setId_Apiario(idA);
                
	        nombreTec = rs.getString("nombre_tecnico");
	        registro.setNombre_Tecnico(nombreTec) ;
                
                
	        
	        colmenas.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Colmenas");
			e.printStackTrace();
		}
	    
	    return colmenas;
	}
}
