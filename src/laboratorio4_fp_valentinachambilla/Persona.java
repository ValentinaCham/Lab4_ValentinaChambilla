/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4_fp_valentinachambilla;

public class Persona {
    private String nombre="";
    private int DNI=0;
    private int celular=0;
    
    public void setNomDniCel(String Nom, int Dni, int Cel){
        nombre = Nom;
        DNI = Dni;
        celular = Cel;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getDNI(){
        return DNI;
    }
    
    public int getCelular(){
        return celular;
    }
}
