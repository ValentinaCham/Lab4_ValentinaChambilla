/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4_fp_valentinachambilla;

import java.text.DateFormat;
import java.util.Date;

public class Paquete {
    private int identificador=0;
    private Date fecha_recepcion= new Date(-1900,1,0);
    private Date fecha_entrega= new Date(-1900,1,0);
    private Persona persona_origen = new Persona();
    private int DNI_persona;
    private double pesoKilos;
    private String direccion;
    private double costo;
    
    public void setPaquete(int pIdentificador, Date rFecha, int DNIingre,
            double peso, double costoI, String direccionI, Persona PersonaDniIngre){
        identificador = pIdentificador;
        fecha_recepcion = rFecha;
        pesoKilos = peso;
        costo = costoI;
        DNI_persona = DNIingre;
        persona_origen = PersonaDniIngre;
        direccion = direccionI;
    }
    
    public void setEntrega(Date eFecha){
        fecha_entrega = eFecha;
    }
    
    public int getIdentificador(){
        return identificador;
    }
    
    public double getPeso(){
        return pesoKilos;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public String getRecepcion(){
        DateFormat formatoMedio = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return formatoMedio.format(fecha_recepcion);
    }
    
    public Persona getPersona(){
        return persona_origen;
    }
    
    public int getDNIpersona(){
        return DNI_persona;
    }
    
    public String getEntrega(){
        DateFormat formatoMedio = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return formatoMedio.format(fecha_entrega);
    }
    
    public String getDireccion(){
        return direccion;
    }
}
