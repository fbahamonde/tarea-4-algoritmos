//Constructor de Nodo
public class Nodo2 {
    int val, alt; //alberga valor (val) y altura (alt) del Nodo
    Nodo2 izq, der; //referencia a Nodo izquierdo y derecho
 
    Nodo2(int valor) { //metodo para signar valor al Nodo
        val = valor;
        alt = 1;
    }
}