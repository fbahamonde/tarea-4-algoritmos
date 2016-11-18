import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList; 
import java.util.List;

public class Contructor {
	
    public static void main(String[] args) throws IOException{
        
        Scanner in = new Scanner(System.in);        // crea parametro con el valor ingresado en la consola
        
        while (in.hasNextLine())
        {
        	String linea = in.nextLine();    		// extrae primera linea como string con parametros STDIN
            String[] param = linea.split(" ");	
  
            if (param[0].equals("2-3")){			//verifica primer elemnto del String array y ve que tipo de arbol se desea contruir
            	Arbol23 arbol = new Arbol23();
            	
            	for (int i=1; i<param.length; i++){//inserta valores en el arbol
            		arbol.Insertatree(Integer.parseInt(param[i]));
            	}
            	arbol.raiz.preordern();			//imprime arbol
            	System.out.println();
            }
            if (param[0].equals("AVL")){			//verifica primer elemnto del String array y ve que tipo de arbol se desea contruir
            	ArbolAVL arbol = new ArbolAVL();
            	
            	for (int i=1; i<param.length; i++){//inserta valores en el arbol
            		arbol.raiz=arbol.insertar(arbol.raiz, Integer.parseInt(param[i]));
            	}
            	arbol.preOrden(arbol.raiz);			//imprime arbol
            	System.out.println();
            }
        }
            
    }

}
