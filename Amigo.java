import java.io.*;
import java.util.*;

class Amigo implements Serializable{
   private String nombre;
   private String correo;
   public Amigo (String nombre, String correo) {
      setNombre(nombre);
      setCorreo(correo);
   }
   public void setNombre(String nombre) {
      this.nombre=nombre;
   }
   public String getNombre() {
      return nombre;
   }
   
   public void setCorreo(String correo) {
      this.correo=correo;
   }
   public String getCorreo() {
      return correo;
   }
   public String toString() {
      return "Amigo: "+nombre+" correo: "+correo;
   }
}

class ArchObjetoCrear implements Serializable{
   public static void main(String args[]) {
      try {
         Scanner s = new Scanner(System.in);
         FileOutputStream fos = new FileOutputStream("C:amigo.dat");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         System.out.println("Ingrese el nombre del amigo");
         String nombre = s.next();
         System.out.println("Ingrese el correo del amigo");
         String correo = s.next();
         Amigo a = new Amigo(nombre,correo);
         oos.writeObject(a);
         oos.close();
         fos.close();
      }
      catch(IOException e) { System.out.println("Error en el archivo");}
      try {
         FileInputStream fis = new FileInputStream("C:amigo.dat");
         ObjectInputStream ois = new ObjectInputStream(fis);
         Amigo a = (Amigo) ois.readObject(); // while(true){....}
         System.out.println(a);
         ois.close();
         fis.close();
      }
      catch(EOFException e){ System.out.println("Se llego el fin del archivo");}
      catch(IOException e){ System.out.println("error en el archivo");}
      catch(ClassNotFoundException e){ System.out.println("no definida la clase");}
   }
}
