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
            boolean reina;
            boolean miel;
            int pan_cera = 0;
            int pan_alim = 0;
            int pan_cria = 0;
            int pan_vacio = 0;
            String fecha = null;
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
	        registro.setNombre_Tecnico(nombreTec);
                
                reina = rs.getBoolean("reina");
                registro.setReina(reina);
                
                miel = rs.getBoolean("miel");
                registro.setMiel(miel);
               
	        pan_cera = rs.getInt("pan_cera");
	        registro.setPan_Cera(pan_cera);
                
                pan_alim = rs.getInt("pan_alim");
	        registro.setPan_Alim(pan_alim);
                
                pan_cria = rs.getInt("pan_cria");
	        registro.setPan_Cria(pan_cria);
                
                pan_vacio = rs.getInt("pan_vacio");
	        registro.setPan_Vacio(pan_vacio);
                
                fecha = rs.getString("fecha");
	        registro.setFecha(fecha);
                
	        colmenas.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Colmenas");
			e.printStackTrace();
		}
	    
	    return colmenas;
	}
    
    
    public List<Colmena> PanalALimentos() {
		List<Colmena> colmenas= null;
	    String query = "select pan_alim from Colmena where id_colmena = 1 group by id_colmena";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int total =0;
    
	    String nombre = null;
	
	    while (rs.next()){
	    	if(colmenas == null){
	    		colmenas= new ArrayList<Colmena>();
	    	}
	      
	        Colmena registro= new Colmena();
                
	        total = rs.getInt("pan_alim");
	        registro.setPan_Alim(total);
	               
	        
	        colmenas.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la busqueda");
			e.printStackTrace();
		}
	    
	    return colmenas;
	}
}
