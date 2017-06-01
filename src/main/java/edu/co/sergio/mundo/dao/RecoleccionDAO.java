/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Recoleccion;
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
public class RecoleccionDAO {
    public List<Recoleccion> findAll() {
		List<Recoleccion> recolecciones= null;
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
	    int kilos =0;
            
	    String nombreRec = null;
            String fecha = null;
	    while (rs.next()){
	    	if(recolecciones == null){
	    		recolecciones= new ArrayList<Recoleccion>();
	    	}
	      
	        Recoleccion registro= new Recoleccion();
	        fecha = rs.getString("fecha");
	        registro.setFecha(fecha);
                
                nombreRec = rs.getString("nombre_reco");
	        registro.setNombre_Reco(nombreRec);
                
                id = rs.getInt("id_colmena");
	        registro.setId_Colmena(id);
	        
                kilos = rs.getInt("kilos_miel");
	        registro.setKilos_Miel(kilos);
                
                recolecciones.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Colmenas");
			e.printStackTrace();
		}
	    
	    return recolecciones;
            
            
	}
    
    public List<Recoleccion> KilosMiel() {
		List<Recoleccion> recolecciones= null;
	    String query = "select id_colmena, kilos_miel from Recoleccion";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int colmena =0;
    
	    int kilos = 0;
	
	    while (rs.next()){
	    	if(recolecciones == null){
	    		recolecciones= new ArrayList<Recoleccion>();
	    	}
	      
	        Recoleccion registro= new Recoleccion();
                
	        colmena = rs.getInt("id_colmena");
	        registro.setId_Colmena(colmena);
	              
                kilos = rs.getInt("kilos_miel");
	        registro.setKilos_Miel(kilos);
	        
	        recolecciones.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la busqueda");
			e.printStackTrace();
		}
	    
	    return recolecciones;
	}
}
