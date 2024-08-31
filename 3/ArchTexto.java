import java.io.*;
import java.util.*;

class ArchTexto {
   public static void main(String[] args) {
      try {
         File f = new File("c:Ejemplo.txt");
         FileOutputStream f2 = new FileOutputStream(f, true);
         PrintStream f3 = new PrintStream(f2);
         Scanner s = new Scanner(System.in);
         System.out.println("Ingrese cuantos productos desea registrar");
         int p = s.nextInt();
         String nom, precio;
         for (int i = 0; i<p; i++)
         {
            System.out.println("Ingrese el nombre del producto");
            nom = s.next();
            System.out.println("Ingrese el precio del producto");
            precio = s.next();
            f3.println(nom+", $"+precio);
         }
         f3.close();
      }
      catch(IOException e){
      System.out.println("Error en el archivo");
      }
   }
}
