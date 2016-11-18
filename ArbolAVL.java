import java.io.IOException;
import java.util.Scanner;

public class ArbolAVL {
 
    Nodo2 raiz;
 
    // Metodo para obtener altura del arbol
    public static int altura(Nodo2 N) {
        if (N == null) //Si el nodo es null, no es un arbol i.e. altura=0
            return 0;
 
        return N.alt;
    }
 
    // Metodo que retorna maximo de dos enteros
    public static int max(int a, int b) {
        return (a > b) ? a : b; //Si (a>b) true, retorna a, si false retorna b
    }
 
    // Metodo para rotar a la dereche Nodo y
    public static Nodo2 rotarDer(Nodo2 y) {	//				y
        Nodo2 x = y.izq;						//			   / 
        Nodo2 T2 = x.der;					//			  x  
        									//			   \
        									//			   T2
        // realizar rotacion
        x.der = y;			//				x
        y.izq = T2;			//			     \
        					//         		  y
        					//		         / 
                            //		        T2  
        
        // actualizar alturas
        y.alt = max(altura(y.izq), altura(y.der)) + 1;//??
        x.alt = max(altura(x.izq), altura(x.der)) + 1;//??
 
        // Retorna nueva raiz de arbol rotado
        return x;
    }
 
    // Metodo para rotar a la izquierda el arbol hijo de x
    public static Nodo2 rotarIzq(Nodo2 x) {
        Nodo2 y = x.der;
        Nodo2 T2 = y.izq;
 
        // realizar rotacion
        y.izq = x;
        x.der = T2;
 
        //  Update heights
        x.alt = max(altura(x.izq), altura(x.der)) + 1;
        y.alt = max(altura(y.izq), altura(y.der)) + 1;
 
        // Retorana nueva raiz de arbol rotado
        return y;
    }
 
    // Obtener factor de balance de Nodo
    public static int obtBalance(Nodo2 N) {
        if (N == null) //si arbol vacio, balance=0
            return 0;
 
        return altura(N.izq) - altura(N.der); //balance= altura izq-altura der
    }
 
    public static Nodo2 insertar(Nodo2 nodo, int valor) {
 
        /* 1.  Realizar insercion clasica de arbol de busqueda binaria (ABB) */
        if (nodo == null) 				//si nodo vacio, se crea un nodo con el valor agregado
            return (new Nodo2(valor));
 
 
        if (valor < nodo.val)			//si valor<(valor del nodo), se pasa a rama izquierda
            nodo.izq = insertar(nodo.izq, valor);
        if (valor>nodo.val)							//si valor>=(valor del nodo), se pasa a rama derecha **q pasa cuando son iguales
            nodo.der = insertar(nodo.der, valor);
 
        /* 2. actualizar altura de los ancestros */
        nodo.alt = 1 + max(altura(nodo.izq),
                              altura(nodo.der));
 
        /* 3. Obtener el balance del ancestro para ver si este nodo
          se vuelve desbalanceado (balance >1 o <-1 */
        int balance = obtBalance(nodo);
 
        // Si hay desbalance, hay cuatro casos:
        // Caso Izq Izq
        if (balance > 1 && valor < nodo.izq.val)
            return rotarDer(nodo); //se rota a derecha
 
        // Caso Der Der
        if (balance < -1 && valor > nodo.der.val)
            return rotarIzq(nodo); //se rota a izquierda
 
        // Caso Izq Der
        if (balance > 1 && valor > nodo.izq.val) {
            nodo.izq = rotarIzq(nodo.izq); //hijo izquierdo de nodo se rota a izquierda para tener caso Izq Izq
            return rotarDer(nodo);         //Caso Izq Izq se rota a derecha
        }
 
        // Caso Der Izq
        if (balance < -1 && valor < nodo.der.val) {
            nodo.der = rotarDer(nodo.der); //hijo derecho de nodo se rota a derecha para tener caso Der Der
            return rotarIzq(nodo);			//Caso Der Der se rota a izquierda
        }
 
        /* retorna la referencia al nodo*/
        return nodo;// esto se retorna recursivamente, entonces al final q se retorna? la referencia al nodo raiz?
    }
 
    // Metodo para imprimir arbol en preorden.
    public static void preOrden(Nodo2 nodo) {
        if (nodo != null) {
            System.out.print(nodo.val + " ");
            preOrden(nodo.izq);
            preOrden(nodo.der);
        }
        if (nodo == null) {
        	System.out.print(". ");
        }
    }
 
}