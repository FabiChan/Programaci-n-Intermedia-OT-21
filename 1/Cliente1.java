import java.io.*;
import java.text.*;
import java.time.LocalDate;
import java.time.Period;

public class Cliente1
{
 protected Nombre nombre;
   protected String rfc;
   protected String telefono;
   protected String correo;
   protected Direccion direccion;
   protected String municipio;
   protected LocalDate fechaPrimCompra;
   protected LocalDate fechaUltimCompra;
   protected float montoCompAlt;
   protected float descuento;

   public Cliente1(Nombre nombre, String rfc, String telefono, String correo, Direccion direccion, String municipio, LocalDate fechaPrimCompra,
   LocalDate fechaUltimCompra, float montoCompAlt, float descuento)
   {
        setNombre(nombre);
        setRfc(rfc);
        setTelefono(telefono);
        setCorreo(correo);
        setDireccion(direccion);
        setMunicipio(municipio);
        setFechaPrimCompra(fechaPrimCompra);
        setFechaUltimCompra(fechaUltimCompra);
        setMontoCompAlt(montoCompAlt);
        setDescuento(descuento);
   }
   
   public void setNombre(Nombre nombre)
 {
   this.nombre=nombre;
   }

   public void setRfc(String rfc)
   {
   this.rfc=rfc;
   }
   
   public void setTelefono(String telefono)
   {
   this.telefono=telefono;
   }
   
   public void setCorreo(String correo)
   {
   this.correo=correo;
   }
   public void setDireccion(Direccion direccion)
   {
   this.direccion=direccion;
   }

   public void setMunicipio(String municipio)
   {
       this.municipio = municipio;
   }

   public void setFechaPrimCompra(LocalDate fechaPrimCompra)
   {
       this.fechaPrimCompra = fechaPrimCompra;
   }

   public void setFechaUltimCompra(LocalDate fechaUltimCompra)
   {
       this.fechaUltimCompra = fechaUltimCompra;
   }

   public void setMontoCompAlt(float montoCompAlt)
   {
       this.montoCompAlt = montoCompAlt;
   }

   public void setDescuento(float descuento)
   {
       this.descuento = descuento;
   }

   public Nombre getNombre()
   {
      return nombre;
   }
   public String getRfc()
   {
      return rfc;
   }

   public String getTelefono()
   {
      return telefono;
   }

   public String getCorreo()
   {
      return correo;
   }

   public Direccion getDireccion()
   {
      return direccion;
   }

   public String getMunicipio()
   {
       return municipio;
   }

   public LocalDate getFechaPrimCompra()
   {
       return fechaPrimCompra;
   }

   public LocalDate getFechaUltimCompra()
   {
       return fechaUltimCompra;
   }

   public float getMontoCompAlt()
   {
       return montoCompAlt;
   }

   public float getDescuento()
   {
       return descuento;
   }
   
   public void definirDescuento()
   {
        if (montoCompAlt>20000)
            setDescuento(0.13f);

        else
            setDescuento(0.05f);
   }

   public int calcularAniosAnti(LocalDate fechaActual)
   {
        return Period.between(fechaPrimCompra, fechaActual).getYears();
   }
   
   public String toString()
 {
        DecimalFormat y = new DecimalFormat("0.00");

        return "\nNombre: "+nombre.toString()+"\nRFC: "+rfc+"\nTeléfono: "+telefono+"\nCorreo: "+correo+"\nDirección: "+direccion.toString()+
       "\nMunicipio: "+municipio+"\nFecha de primera compra: "+fechaPrimCompra+"\nFecha de última compra: "+fechaUltimCompra+
       "\nMonto de compra más alta: $"+y.format(montoCompAlt);
   }
}


class Gold extends Cliente1 {

    public Gold(Nombre nombre, String rfc, String telefono, String correo, Direccion direccion, String municipio, LocalDate fechaPrimCompra,
    LocalDate fechaUltimCompra, float montoCompAlt, float descuento)
    {
        super(nombre, rfc, telefono, correo, direccion, municipio, fechaPrimCompra, fechaUltimCompra, montoCompAlt, descuento);
    }

}

class Platino extends Cliente1 {

    private int vecesCompra;

    public Platino(Nombre nombre, String rfc, String telefono, String correo, Direccion direccion, String municipio, LocalDate fechaPrimCompra,
    LocalDate fechaUltimCompra, float montoCompAlt, float descuento, int vecesCompra)
    {
        super(nombre, rfc, telefono, correo, direccion, municipio, fechaPrimCompra, fechaUltimCompra, montoCompAlt, descuento);
        setVecesCompra(vecesCompra);
    }

    public void setVecesCompra(int vecesCompra)
    {
        this.vecesCompra = vecesCompra;
    }

    public int getVecesCompra()
    {
        return vecesCompra;
    }

    public void definirDescuento()
    {
        if (montoCompAlt>=20000 && vecesCompra>5)
            setDescuento(0.15f);

        else
            super.definirDescuento();
    }

    public String toString()
    {
        return super.toString()+"\nCantidad de veces que ha comprado: "+vecesCompra;
    }

}

class Nombre
{
 private String primerNombre;
   private String apellido1;
   private String apellido2;

   public Nombre(String primerNombre, String apellido1, String apellido2)
   {
      setPrimerNombre(primerNombre);
      setApellido1(apellido1);
      setApellido2(apellido2);
   }

   public void setPrimerNombre(String primerNombre)
   {
      this.primerNombre=primerNombre;
   }

   public void setApellido1(String apellido1)
   {
      this.apellido1=apellido1;
   }

   public void setApellido2(String apellido2)
   {
      this.apellido2=apellido2;
   }
   
   public String getPrimerNombre()
   {
      return primerNombre;
   }
   public String getApellido1()
   {
      return apellido1;
   }

   public String getApellido2()
   {
      return apellido2;
   }

   public String toString()
   {
      return primerNombre+" "+apellido1+" "+apellido2;
   }
}

class Direccion
{
   private String calle;
   private int num;
   private String colonia;
   private String ciudad;
   private long cp;

   public Direccion(String calle, int num, String colonia, String ciudad, long cp)
   {
      setCalle(calle);
      setNum(num);
      setColonia(colonia);
      setCiudad(ciudad);
      setCp(cp);
   }

   public void setCalle(String calle)
   {
      this.calle=calle;
   }

   public void setNum(int num)
   {
      this.num=num;
   }

   public void setColonia(String colonia)
   {
      this.colonia=colonia;
   }

   public void setCiudad(String ciudad)
   {
      this.ciudad=ciudad;
   }

   public void setCp(long cp)
   {
      this.cp=cp;
   }

public String getCalle()
   {
      return calle;
   }

   public int getNum()
   {
      return num;
   }

   public String getColonia()
   {
      return colonia;
   }
      public String getCiudad()
   {
      return ciudad;
   }
   public long getCp()
   {
      return cp;
   }
   
   public String toString()
   {
      return calle+" #"+num+" "+colonia+" "+ciudad+" CP: "+cp;
   }
}


class Principal
{
 public static void main (String[] args)
    {
        DecimalFormat y = new DecimalFormat("0.00");

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaPrimera1 = LocalDate.of(2016, 05, 11);
        LocalDate fechaUltima1 = LocalDate.of(2018, 10, 07);
        LocalDate fechaPrimera2 = LocalDate.of(2015, 02, 23);
        LocalDate fechaUltima2 = LocalDate.of(2020, 10, 15);
        LocalDate fechaPrimera3 = LocalDate.of(2010, 06, 02);
        LocalDate fechaUltima3 = LocalDate.of(2018, 02, 25);

        //Llenado del nombre
        Nombre nombre1 = new Nombre("Melania","Hernández","Coronado");
        Nombre nombre2 = new Nombre("Adriana","Martínez","Pérez");
        Nombre nombre3 = new Nombre("Alfonso","Villarreal","Castillo");

        //Llenado de la dirección
        Direccion dir1 = new Direccion("Encelade",321,"Residencial Nova","San Nicolás de los Garza",66464);
        Direccion dir2 = new Direccion("Rosas",623,"Colonia Villa","San Pedro",32312);
        Direccion dir3 = new Direccion("Temis",1021,"Residencial Bonita","Escobedo",94382);


        //Llenado de objetos
        Cliente1 cliente1 = new Cliente1(nombre1, "HECM8321938AO", "8182665106", "melania.hernandez@udem.edu", dir1, "San Nicolás de los Garza", fechaPrimera1, fechaUltima1, 10000.50f, 0);
        Gold gold1 = new Gold(nombre2, "AHC832198A", "831283821", "adriana.martinez@udem.edu", dir2, "San Pedro", fechaPrimera2, fechaUltima2, 25000f,0);
        Platino platino1 = new Platino(nombre3, "ALFC318931A", "83182133", "alfonso.villarreal@hotmail.com", dir3, "Escobedo", fechaPrimera3, fechaUltima3, 30000f, 0, 12);

     //Desplegado para cliente
        cliente1.definirDescuento();
        System.out.println("\nCLIENTE ESTÁNDAR\n"+cliente1);
        System.out.println("\nAños de antiguedad: "+cliente1.calcularAniosAnti(fechaActual));
        System.out.println("\nDescuento: "+y.format((cliente1.getDescuento())*100)+"%\n");

        //Desplegado para gold
        gold1.definirDescuento();
        System.out.println("\nCLIENTE GOLD\n"+gold1);
        System.out.println("\nAños de antiguedad: "+gold1.calcularAniosAnti(fechaActual));
        System.out.println("\nDescuento: "+y.format((gold1.getDescuento())*100)+"%\n");

         //Desplegado para platino
         platino1.definirDescuento();
         System.out.println("\nCLIENTE PLATINO\n"+platino1);
         System.out.println("\nAños de antiguedad: "+platino1.calcularAniosAnti(fechaActual));
         System.out.println("\nDescuento: "+y.format((platino1.getDescuento())*100)+"%\n");
    }
}
