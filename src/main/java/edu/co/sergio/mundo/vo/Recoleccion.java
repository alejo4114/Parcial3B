/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.vo;

/**
 *
 * @author Labing
 */
public class Recoleccion {
    private String fecha;
    private String Nombre_Reco;
    private int Id_Colmena;
    private int Kilos_Miel;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre_Reco() {
        return Nombre_Reco;
    }

    public void setNombre_Reco(String Nombre_Reco) {
        this.Nombre_Reco = Nombre_Reco;
    }

    public int getId_Colmena() {
        return Id_Colmena;
    }

    public void setId_Colmena(int Id_Colmena) {
        this.Id_Colmena = Id_Colmena;
    }

    public int getKilos_Miel() {
        return Kilos_Miel;
    }

    public void setKilos_Miel(int Kilos_Miel) {
        this.Kilos_Miel = Kilos_Miel;
    }
    
    
}
