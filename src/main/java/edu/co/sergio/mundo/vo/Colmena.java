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
public class Colmena {
   private int Id_Colmena;
   private int Id_Apiario;
   private String Nombre_Tecnico;
   private boolean Reina;
   private boolean Miel;
   private int Pan_Cera;
   private int Pan_Alim;
   private int Pan_Cria;
   private int Pan_Vacio;
   private String fecha;

    public int getId_Colmena() {
        return Id_Colmena;
    }

    public void setId_Colmena(int Id_Colmena) {
        this.Id_Colmena = Id_Colmena;
    }

    public int getId_Apiario() {
        return Id_Apiario;
    }

    public void setId_Apiario(int Id_Apiario) {
        this.Id_Apiario = Id_Apiario;
    }

    public String getNombre_Tecnico() {
        return Nombre_Tecnico;
    }

    public void setNombre_Tecnico(String Nombre_Tecnico) {
        this.Nombre_Tecnico = Nombre_Tecnico;
    }

    public boolean isReina() {
        return Reina;
    }

    public void setReina(boolean Reina) {
        this.Reina = Reina;
    }

    public boolean isMiel() {
        return Miel;
    }

    public void setMiel(boolean Miel) {
        this.Miel = Miel;
    }

    public int getPan_Cera() {
        return Pan_Cera;
    }

    public void setPan_Cera(int Pan_Cera) {
        this.Pan_Cera = Pan_Cera;
    }

    public int getPan_Alim() {
        return Pan_Alim;
    }

    public void setPan_Alim(int Pan_Alim) {
        this.Pan_Alim = Pan_Alim;
    }

    public int getPan_Cria() {
        return Pan_Cria;
    }

    public void setPan_Cria(int Pan_Cria) {
        this.Pan_Cria = Pan_Cria;
    }

    public int getPan_Vacio() {
        return Pan_Vacio;
    }

    public void setPan_Vacio(int Pan_Vacio) {
        this.Pan_Vacio = Pan_Vacio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   
   
   
    
}
