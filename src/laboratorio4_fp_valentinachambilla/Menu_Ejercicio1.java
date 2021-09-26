
package laboratorio4_fp_valentinachambilla;

import java.util.*;

public class Menu_Ejercicio1 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int desicion=0;
        boolean continuar=true;
        Persona[] Personas_Registradas = new Persona[10];
        Paquete[] Paquetes_Registrados = new Paquete[20];
        //Inicialización de todos como Personas
        for (int i=0; i<10;i++)
            Personas_Registradas[i] = new Persona();
        //Inicialización de todos como Paquetes
        for (int i=0; i<20;i++)
            Paquetes_Registrados[i] = new Paquete();
        int cantidadPersonas=-1;
        int cantidadPaquete=-1;
        
        while(continuar){
        System.out.println("*********************************MENÚ DE EMPRESA XXXXXXXXXXX*********************************");
        
        System.out.println("1. Registro de persona \n2. Registro de paquete \n3. Registrar paquete entregado\n"
                + "4. Comparación de Kilos (Como mínimo) \n5. Comparación por Costo (Igual cantidad) \n6. Pendientes de Envio "
                + "\n7. Mostrar los Datos de la persona de cierto paquete \n8. Mostrar los Datos de la persona de cierto DNI");
        desicion = scan.nextInt();
        
            if(desicion<=8 && desicion>=1){
                break;
            }
            else{
                System.out.println("Numero no permitido, volver a ingresar el número por favor");
            }
        }
        
        while(continuar){
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
                    System.out.println("¿Qué paquete se ha entregado? (Colocar el Identificador):");
                    int indicador = scan.nextInt();
                    for (int i=0; i<=cantidadPaquete; i++){
                        if (Paquetes_Registrados[i].getIdentificador() == indicador)
                            Paquetes_Registrados[i] = RegistroDeEntrega(Paquetes_Registrados, indicador);
                    }
                    break;
                }
                case 4: {
                    ComparacionPeso(Paquetes_Registrados);
                    break;
                }
                case 5: {
                    ComparacionCosto(Paquetes_Registrados);
                    break;
                }
                case 6: {
                    ComparacionEnvio(Paquetes_Registrados, cantidadPaquete);
                    break;
                }
                case 7: {
                    PersonaDeEnvio(Paquetes_Registrados);
                    break;
                }
                case 8:{
                    PaqueteDNI(Paquetes_Registrados);
                }
            }
            
            System.out.println("¿Desea realizar otra operación? \n1. SI \n2. NO");
            desicion = scan.nextInt();
            
            if (desicion==1){
                System.out.println("1. Registro de persona \n2. Registro de paquete \n3. Registrar paquete entregado\n"
                + "4. Comparación de Kilos \n5. Igual Costo \n6. Pendientes de Envio "
                + "\n7. Mostrar los Datos de la persona de cierto paquuete \n8. Mostrar los Datos de la persona de cierto DNI");
                desicion = scan.nextInt();
            }
            else if (desicion==2){
                System.out.println("Hasta luego OwO");
                break;
            }
        }
    }
    
    public static Persona RegistroPersona(Persona[] PersonaRegistro, int cantidadPersona) {
        boolean continuar=true;
        String nombre="";
        int DNI=0,celular=0;
        Scanner scan= new Scanner(System.in);
        while (continuar){
            System.out.println("Ingrese los datos solicitados para el registro");
            //RECUERDA REALIZAR SI SE ACPETA O NO
            System.out.print("DNI: ");
            DNI = scan.nextInt();
            System.out.print("Nombre: ");
            scan.next();
            nombre = scan.nextLine();
            System.out.print("Celular: ");
            celular = scan.nextInt();
            if (DNI<100000000 && celular<1000000000 && celular>99999999){
                System.out.println("¿Confirma los datos a subir? \n1. SI \n2.NO");
                int dec = scan.nextInt();
                if (dec == 1)
                    break;
            }
            else {
                System.out.println("Vuelva a ingresar los datos, revise el DNI y/o el celular");
            }
        }
        PersonaRegistro[cantidadPersona] = new Persona();
        PersonaRegistro[cantidadPersona].setNomDniCel(nombre, DNI, celular);
        
        return PersonaRegistro[cantidadPersona];
    }
    
    public static Paquete RegistroPaquete(Paquete[] PaqueteRegistro, int cantidadPaquetes, Persona[] PersonaRegistro) {
        int identificador, dia, mes, año, DNIpersona;
        double costoEn, pesoKilos;
        String direccion;
        Scanner scan= new Scanner(System.in);
        
        System.out.println("Ingrese los datos solicitados para el registro");
        //RECUERDA REALIZAR SI SE ACPETA O NO
        System.out.print("Identificador: ");
        identificador = scan.nextInt();
        System.out.println("Fecha de recepcion: (Ingrese primero día, luego el mes en formato número y luego el año)");
        System.out.println("Día: ");
        dia = scan.nextInt();
        System.out.println("Mes(número): ");
        mes = scan.nextInt();
        System.out.println("Año: ");
        año = scan.nextInt();
        System.out.print("Peso del Paquete en kilos: ");
        pesoKilos = scan.nextDouble();
        System.out.print("Costo: ");
        costoEn = scan.nextDouble();
        System.out.print("DNI del Cliente: ");
        DNIpersona = scan.nextInt();
        System.out.print("Dirección: ");
        scan.nextLine();
        direccion = scan.nextLine();
        
        Date fecha = new Date((año-1900), (mes-1), dia);
        
        Persona PersonaDniIngre = new Persona();
        for (int i=0; i<PersonaRegistro.length;i++){
            if (DNIpersona == PersonaRegistro[i].getDNI())
                PersonaDniIngre = PersonaRegistro[i];
        }
        
        PaqueteRegistro[cantidadPaquetes] = new Paquete();
        PaqueteRegistro[cantidadPaquetes].setPaquete(identificador, fecha, DNIpersona, pesoKilos, costoEn, direccion, PersonaDniIngre);
        
        return PaqueteRegistro[cantidadPaquetes];
    }
    
    public static Paquete RegistroDeEntrega(Paquete[] PaqueteRegistro,int indicador){
        int dia, mes, año;
        int identi=0;
        Scanner scan= new Scanner(System.in);
        System.out.println("Fecha de entrega: (Ingrese primero día, luego el mes en formato número y luego el año)");
        System.out.println("Día: ");
        dia = scan.nextInt();
        System.out.println("Mes(número): ");
        mes = scan.nextInt();
        System.out.println("Año: ");
        año = scan.nextInt();
        Date entrega = new Date((año-1900), (mes-1), dia);
        for (int i=0; i<PaqueteRegistro.length; i++){
            if ((PaqueteRegistro[i].getIdentificador()) == indicador)
                identi = i;
        }
        PaqueteRegistro[identi].setEntrega(entrega);
        return PaqueteRegistro[identi];
    }
    
    public static void ComparacionPeso(Paquete[] PaqueteRegistro){
        Paquete[] RegistroTemporal = new Paquete[20];
        //Inicialización de RegistroTemporal
        for (int i=0; i<20;i++)
            RegistroTemporal[i] = new Paquete();
        Scanner scan= new Scanner(System.in);
        System.out.print("Ingrese la cantidad de peso mínimo (en kilos): ");
        int pesoMinimo = scan.nextInt();
        int cantidadDePaquetes=0;
        
        for (int i=0; i< PaqueteRegistro.length; i++){
            if (pesoMinimo <= PaqueteRegistro[i].getPeso()){
                RegistroTemporal[cantidadDePaquetes] = PaqueteRegistro[i];
                cantidadDePaquetes++;
            }
        }
        
        if (cantidadDePaquetes>0){
            System.out.printf( "%5s%18s%10s%6s%6s%40s%12s\n", "Ind.", "Fecha_Recepción", "Dni_Cli", "Peso","Costo","Dirección", "Est.Entrega" );
            for ( int contador = 0; contador < cantidadDePaquetes; contador++)
                System.out.printf("%5d%18s%10d%6.2f%6.2f%40s%12s\n", RegistroTemporal[contador].getIdentificador(), RegistroTemporal[contador].getRecepcion(),
                        (RegistroTemporal[contador].getPersona()).getDNI(), RegistroTemporal[contador].getPeso(),
                        RegistroTemporal[contador].getCosto(), RegistroTemporal[contador].getDireccion() ,RegistroTemporal[contador].getEntrega());
        }
        else
            System.out.print("No hay paquetes de mayor peso al ingresado.");      
    }
    
    public static void ComparacionCosto(Paquete[] PaqueteRegistro){
        Paquete[] RegistroTemporal = new Paquete[20];
        //Inicialización de RegistroTemporal
        for (int i=0; i<20;i++)
            RegistroTemporal[i] = new Paquete();
        Scanner scan= new Scanner(System.in);
        System.out.print("Ingrese el costo: ");
        int costo = scan.nextInt();
        int cantidadDePaquetes=0;
        
        for (int i=0; i< PaqueteRegistro.length; i++){
            if (costo == PaqueteRegistro[i].getCosto()){
                RegistroTemporal[cantidadDePaquetes] = PaqueteRegistro[i];
                cantidadDePaquetes++;
            }
        }
        
        if (cantidadDePaquetes>0){
            System.out.printf( "%5s%18s%10s%6s%6s%40s%12s\n", "Ind.", "Fecha_Recepción", "Dni_Cli", "Peso","Costo","Dirección", "Est.Entrega" );
            for ( int contador = 0; contador < cantidadDePaquetes; contador++)
                System.out.printf("%5d%18s%10d%6.2f%6.2f%40s%12s\n", RegistroTemporal[contador].getIdentificador(), RegistroTemporal[contador].getRecepcion(),
                        (RegistroTemporal[contador].getPersona()).getDNI(), RegistroTemporal[contador].getPeso(),
                        RegistroTemporal[contador].getCosto(), RegistroTemporal[contador].getDireccion() ,RegistroTemporal[contador].getEntrega());
        }
        else
            System.out.print("No hay paquetes de ese costo en el sistema.");
    }
    
    public static void ComparacionEnvio(Paquete[] PaqueteRegistro, int PaquetesRegistrados){
        Paquete[] RegistroTemporal = new Paquete[20];
        int cantidadDePaquetes=0;
        //Inicialización de RegistroTemporal
        for (int i=0; i<20;i++)
            RegistroTemporal[i] = new Paquete();
        for (int i=0; i <= PaquetesRegistrados; i++){
            if ((PaqueteRegistro[i].getEntrega()).equals("31/01/0001")){
                RegistroTemporal[cantidadDePaquetes] = PaqueteRegistro[i];
                cantidadDePaquetes++;
            }
        }
        
        if (cantidadDePaquetes>0){
            System.out.printf( "%5s%18s%10s%6s%6s%40s\n", "Ind.", "Fecha_Recepción", "Dni_Cli", "Peso","Costo","Dirección");
            for ( int contador = 0; contador < cantidadDePaquetes; contador++)
                System.out.printf("%5d%18s%10d%6.2f%6.2f%40s\n",RegistroTemporal[contador].getIdentificador(), RegistroTemporal[contador].getRecepcion(),
                        (RegistroTemporal[contador].getPersona()).getDNI(), RegistroTemporal[contador].getPeso(),
                        RegistroTemporal[contador].getCosto(), RegistroTemporal[contador].getDireccion());
        }
        else
            System.out.print("TODOS LOS PAQUETES HAN SIDO ENTREGADOS");
    }
    
    public static void PersonaDeEnvio(Paquete[] PaqueteRegistro){
        Scanner scan= new Scanner(System.in);
        Persona Buscada = new Persona();
        System.out.print("Ingrese el Identificador del paquete: ");
        int identificador = scan.nextInt();
        for (int i=0; i<PaqueteRegistro.length; i++){
            if ((PaqueteRegistro[i].getIdentificador()) == identificador){
                Buscada = PaqueteRegistro[i].getPersona();
            }
        }
        
        if ((Buscada.getNombre()).equals(""))
            System.out.println("No hay paquete con ese identificador");
        else {
            System.out.printf( "%20s%10s%10s\n", "Nombre", "DNI ", "Celular");
            System.out.printf("%20s%10d%10d\n", Buscada.getNombre(), Buscada.getDNI(), Buscada.getCelular());
        }
    }
    
    public static void PaqueteDNI(Paquete[] PaqueteRegistro){
        Paquete[] RegistroTemporal = new Paquete[20];
        //Inicialización de RegistroTemporal
        for (int i=0; i<20;i++)
            RegistroTemporal[i] = new Paquete();
        Scanner scan= new Scanner(System.in);
        System.out.print("Ingrese el DNI: ");
        int DNI = scan.nextInt();
        int cantidadDePaquetes=0;
        
        for (int i=0; i< PaqueteRegistro.length; i++){
            if (DNI == PaqueteRegistro[i].getDNIpersona()){
                RegistroTemporal[cantidadDePaquetes] = PaqueteRegistro[i];
                cantidadDePaquetes++;
            }
        }
        
        if (cantidadDePaquetes>0){
            System.out.printf("%5s%18s%10s%6s%6s%40s%12s\n", "Ind.", "Fecha_Recepción", "Dni_Cli", "Peso","Costo","Dirección", "Est.Entrega");
            for ( int contador = 0; contador < cantidadDePaquetes; contador++)
                System.out.printf("%5d%18s%10d%6.2f%6.2f%40s%12s\n", RegistroTemporal[contador].getIdentificador(), RegistroTemporal[contador].getRecepcion(),
                        (RegistroTemporal[contador].getPersona()).getDNI(), RegistroTemporal[contador].getPeso(),
                        RegistroTemporal[contador].getCosto(), RegistroTemporal[contador].getDireccion() ,RegistroTemporal[contador].getEntrega());
        }
        else
            System.out.print("No hay paquetes de ese costo en el sistema.");
    }
}
