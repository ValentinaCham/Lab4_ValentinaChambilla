/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4_fp_valentinachambilla;

import java.util.Date;

public class Paquete {
    private int identificador;
    private Date fecha;
    private Persona persona_origen;
    private double pesoKilos;
    private boolean entregado=false;
    
    public void setPaquete(int pIdentificador, Date pFecha, int DNIingre, double peso, Persona[] RegistroPersonas){
        identificador = pIdentificador;
        fecha = pFecha;
        pesoKilos = peso;
        Persona PersonaDniIngre = new Persona();
        for (int i=0; i<RegistroPersonas.length;i++){
            if (DNIingre == RegistroPersonas[i].getDNI())
                PersonaDniIngre = RegistroPersonas[i];
        }
        persona_origen = PersonaDniIngre;
    }
    
    public void setEntrega(){
        entregado = true;
    }
    
    public int getIdentificador(){
        return identificador;
    }
    
    public double getPeso(){
        return pesoKilos;
    }
}
