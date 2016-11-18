import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList; 
import java.util.List;

public class Arbol23 {
	Nodo raiz=new Nodo();
	public void Insertatree(int b){
		if (this.raiz==null){
			this.raiz=new Nodo(b);
		}
		else{
			Nodo segundo=new Nodo(b);
			this.raiz.insertar(segundo);
			while (this.raiz.par!=null){
				this.raiz=this.raiz.par;					
				}
			}
	}
}