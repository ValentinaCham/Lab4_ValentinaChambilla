
package laboratorio4_fp_valentinachambilla;

import java.util.*;

public class Menu_Ejercicio1 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int desicion=0;
        boolean continuar=true;
        Persona[] Personas_Registradas = new Persona[10];
        Paquete[] Paquetes_Registrados = new Paquete[20];
        int cantidadPersonas=-1;
        int cantidadPaquete=-1;
        
        while(continuar){
        System.out.println("*********************************MENÚ DE EMPRESA XXXXXXXXXXX*********************************");
        System.out.print("1. Registro de persona \n2. Registro de paquete \n3. Registrar paquete entregado\n"
                + "4. Comparación de Kilos \n5. Igual Costo \n6. Pendientes de Envio "
                + "\n7. Mostrar los Datos de la persona de cierto paquuete \n8. Mostrar los Datos de la persona de cierto DNI");
        desicion = scan.nextInt();
        
            if(desicion<=8 && desicion>=1){
                break;
            }
            else{
                System.out.println("Numero no permitido, volver a ingresar el número por favor");
            }
        }
        
        switch (desicion){
            case 1:{
                cantidadPersonas++;
                if (cantidadPersonas<10 && cantidadPersonas>-1){
                    Personas_Registradas[cantidadPersonas] = RegistroPersona(Personas_Registradas, cantidadPersonas);
                }
                else
                    System.out.println("La cantidad de personas es máxima");
                break;
            }
            case 2:{
                cantidadPaquete++;
                if (cantidadPaquete<10 && cantidadPaquete>-1)
                    Paquetes_Registrados[cantidadPaquete] = RegistroPaquete(Paquetes_Registrados, cantidadPaquete, Personas_Registradas);
                else
                    System.out.println("La cantidad de personas es máxima");
                break;
            }
            case 3:{
                int identificador = RegistroDeEntrega(Paquetes_Registrados);
                for (int i=0; i< Paquetes_Registrados.length; i++){
                    if (identificador == Paquetes_Registrados[i].getIdentificador())
                    Paquetes_Registrados[i].setEntrega();
                }
                break;
            }
            case 4: {
                
            }
        }
    }
    
    public static Persona RegistroPersona(Persona[] PersonaRegistro, int cantidadPersona) {
        String nombre;
        int DNI,celular;
        Scanner scan= new Scanner(System.in);
        System.out.println("Ingrese los datos solicitados para el registro");
        //RECUERDA REALIZAR SI SE ACPETA O NO
        System.out.print("DNI: ");
        DNI = scan.nextInt();
        System.out.print("Nombre: ");
        nombre = scan.next();
        System.out.print("Celular: ");
        celular = scan.nextInt();
        
        PersonaRegistro[cantidadPersona] = new Persona();
        PersonaRegistro[cantidadPersona].setNomDniCel(nombre, DNI, celular);
        
        return PersonaRegistro[cantidadPersona];
    }
    
    public static Paquete RegistroPaquete(Paquete[] PaqueteRegistro, int cantidadPaquetes, Persona[] PersonaRegistro) {
        int identificador, dia, mes, año, DNIpersona, pesoKilos;
        Scanner scan= new Scanner(System.in);
        System.out.println("Ingrese los datos solicitados para el registro");
        //RECUERDA REALIZAR SI SE ACPETA O NO
        System.out.print("Identificador: ");
        identificador = scan.nextInt();
        System.out.println("Fecha: (Ingrese primero día, luego el mes en formato número y luego el año)");
        System.out.println("Día: ");
        dia = scan.nextInt();
        System.out.println("Mes(número): ");
        mes = scan.nextInt();
        System.out.println("Año: ");
        año = scan.nextInt();
        System.out.print("Peso del Paquete en kilos: ");
        pesoKilos = scan.nextInt();
        System.out.print("DNI del Cliente: ");
        DNIpersona = scan.nextInt();
        Date fecha = new Date((año-1900), mes, dia);
        
        PaqueteRegistro[cantidadPaquetes] = new Paquete();
        PaqueteRegistro[cantidadPaquetes].setPaquete(identificador, fecha, DNIpersona,pesoKilos, PersonaRegistro);
        
        return PaqueteRegistro[cantidadPaquetes];
    }
    
    public static int RegistroDeEntrega(Paquete[] PaqueteRegistro){
        Scanner scan= new Scanner(System.in);
        System.out.println("¿Qué paquete se ha entregado?");
        int indicador = scan.nextInt();
        return indicador;
    }
    
    public static void ComparacionPeso(Paquete[] PaqueteRegistro){
        Paquete[] RegistroTemporal = new Paquete[20];
        Scanner scan= new Scanner(System.in);
        System.out.print("Ingrese la cantidad de peso mínimo (en kilos): ");
        int pesoMinimo = scan.nextInt();
        boolean presencia;
        int cantidadDePaquetes=0;
        
        while (presencia=true){
            for (int i=0; i< PaqueteRegistro.length; i++){
                if (pesoMinimo <= PaqueteRegistro[i].getPeso()){
                    RegistroTemporal[cantidadDePaquetes] = PaqueteRegistro[i];
                    cantidadDePaquetes++;
                }
            if (cantidadDePaquetes>0){
                System.out.printf( "%10s%20s%10s%6d%6d\n", "Indicador", "Fecha_Recepción", "Dni_del_Cliente", "Peso", "Estado_de_Entrega" );
                for ( int contador = 0; contador <= cantidadDePaquetes; contador++)
                    System.out.printf("%10d%20d\n", contador, RegistroTemporal[contador]);
            }
            else
                System.out.print("No hay paquetes de mayor peso al ingresado.");
        }       
        }
    }
}
