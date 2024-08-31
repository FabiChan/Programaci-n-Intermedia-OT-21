//Nombre: Leslie Fabiola L�pez Rosale     571315
//C�digo de Honor: "Yo, Leslie L�pez, doy mi palabra de que he realizado este examen final con integridad acad�mica"

import java.io.*;
import java.util.*;
import java.text.*;

//clase Acta que tendr� los elementos de un acta fiscal
class Acta {
   private int tipo;
   private String dia;
   
   //metodo constructor
   public Acta(int tipo, String dia) {
      setTipo(tipo);
      setDia(dia);
   }
   
   //metodos sets y gets
   public void setTipo(int tipo) {
      this.tipo=tipo;
   }
   public void setDia(String dia) {
      this.dia=dia;
   }
   public int getTipo() {
      return tipo;
   }
   public String getDia() {
      return dia;
   }
   
}

//clase para generar el reporte 1
class Reporte1 {
   private ArrayList<Acta> actas;
   
   //m�todo constructor
   public Reporte1(ArrayList<Acta> actas) {
      setActas(actas);
   }
   
   //m�todos set y get
   public void setActas(ArrayList<Acta> actas) {
        this.actas = actas;
   }
   public ArrayList<Acta> getActas() {
        return actas;
   }
   
   //m�todo para calcular el total del importe de acerdo al dia de la semana 
   public double calcularImporte(String diaS) {
      double importe = 0;
      for(Acta acta: actas)
         if(acta.getDia().equals(diaS))
            importe+=51;
      return importe;   
   }
   
   //M�todo para generar los espacios de formato
   public String generarEspacios(String variable){
      while(variable.length() < 21){
         variable += " ";
      }
      return variable;
   }
   
   //m�todo para imprimir el reporte 1
   public String toString() {
      DecimalFormat d= new DecimalFormat("0.00");
      String salida = "\n\nRelacion de actas solicitadas por dia\n\n\nDia\t\t\t\t\t\tImporte\n\n";
      salida += generarEspacios("Lunes")+generarEspacios("$"+String.valueOf(d.format(calcularImporte("lunes"))))+"\n"+generarEspacios("Martes")+generarEspacios("$"+String.valueOf(d.format(calcularImporte("martes"))))+"\n"+generarEspacios("Miercoles")+generarEspacios("$"+String.valueOf(d.format(calcularImporte("miercoles"))))+"\n"+generarEspacios("Jueves")+generarEspacios("$"+String.valueOf(d.format(calcularImporte("jueves"))))+"\n"+generarEspacios("Viernes")+generarEspacios("$"+String.valueOf(d.format(calcularImporte("viernes"))));
   return salida;
   } 
}


//clase para generar el reporte 2
class Reporte2 {
   private ArrayList<Acta> actas;
   
   //metodo constructor
   public Reporte2(ArrayList<Acta> actas) {
      setActas(actas);
   }
   
   //metodos set y get
   public void setActas(ArrayList<Acta> actas) {
        this.actas = actas;
   }
   public ArrayList<Acta> getActas() {
        return actas;
   }
   
   //metodo para calcular la cantidad de actas de cierto tipo
   public int calcularCant(int tipoA) {
      int total = 0;
      for(Acta acta: actas)
         if(acta.getTipo()==tipoA)
            total++;
      return total;   
   }
   
   //M�todo para generar los espacios de formato
   public String generarEspacios(String variable){
      while(variable.length() < 24){
         variable += " ";
      }
      return variable;
   }
   
   //m�todo para imprimir el reporte 2
   public String toString() {
      String salida = "\n\n\nRelacion de actas solicitadas por tipo\n\n\nTipo de Acta\t\t\tCantidad\n\n";
      salida += generarEspacios("Nacimiento")+generarEspacios(String.valueOf(calcularCant(1)))+"\n"+generarEspacios("Defuncion")+generarEspacios(String.valueOf(calcularCant(2)))+"\n"+generarEspacios("Matrimonio")+generarEspacios(String.valueOf(calcularCant(3))+"\n"+generarEspacios("Divorcio")+generarEspacios(String.valueOf(calcularCant(4))));
   return salida;
   }
}

//Clase Principal
class Principal {
   public static void main(String[] args) {
      ArrayList<Acta> actas = new ArrayList<>(); //variable que contendr� todas las actas
      //lectura del archivo
      try {
         File f = new File("C:actasExamenIntermedia.txt");
         FileInputStream f2 = new FileInputStream(f);
         InputStreamReader f3 = new InputStreamReader(f2);
         BufferedReader f4 = new BufferedReader(f3);
         String fila, info []; //variable para leer la fila y arreglo para guardar cada elemento de la fila
         fila = f4.readLine();
         while(fila!=null)
         {
            info = fila.split("\\,"); //elementos separados por ','
            Acta a = new Acta(Integer.parseInt(info[0]),info[1]); //crear objeto Acta
            actas.add(a); //agregarla al arraylist
            fila = f4.readLine();         
         }
         Reporte1 r1 = new Reporte1(actas); //generar reporte 1
         System.out.println(r1); //imprimir reporte 1
         Reporte2 r2 = new Reporte2(actas); //generar reporte 2
         System.out.println(r2); //imprimir reporte 2
         f4.close(); //cerrar el archivo
      }
      //Esception en caso de que exista un error al leer el archivo
      catch(IOException e){
      System.out.println("Error en en la lectura del archivo");
      }
   }
}

