import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList; 
import java.util.List;


//Constructor de Nodo
public class Nodo {
    ArrayList<Integer> val=new ArrayList<Integer>(); //alberga valor (val) y altura (alt) del Nodo
    ArrayList<Nodo> hijos=new ArrayList<Nodo>(); //referencia a Nodo izquierdo y derecho
    Nodo par=null;
    public Nodo(int valor) { //metodo para signar valor al Nodo
    	val.add(valor);
    	//agrega a la cola
    }
    public Nodo() { //metodo para signar valor al Nodo
    }
 
    private boolean hoja(){
    	return this.hijos.size()==0; // probar con null despues
    }
    
    private void agregar(Nodo b){
    	for (Nodo q : b.hijos){//setear padres de b como a
    		q.par = this;
    	}
    	this.val.addAll(b.val);     // agrega valores del arreglo b.val a la cola de a.val
    	Collections.sort(this.val); //ordena arregla dinamico de int
    	this.hijos.addAll(b.hijos); //agregar nodo a la coa
    	if (this.hijos.size() > 1){
    		this.sortnodo();
    	}
    	if (this.val.size() > 2){
    		this.splitear();
    	}	
    }
    public void insertar(Nodo b){
    	if(this.hoja() && this.val.size()==2 && this.val.get(0)!=b.val.get(0) && this.val.get(1)!=b.val.get(0)){
    		this.agregar(b);
    	}
    	else if (this.hoja() && this.val.size()==1 && this.val.get(0)!=b.val.get(0)){
    		this.agregar(b);
    	}
    	else if (this.hoja() && this.val.size()==0){
    		this.agregar(b);
    	}
    	else if (b.val.get(0) > this.val.get(this.val.size()-1)){//entrega el ultimo//si no es hoja y el nodo a insertab, es mayor que el ultimo valor de a, se inserta en el ultimo hijo de a
    		this.hijos.get(this.hijos.size()-1).insertar(b);//implementar largo de los nodos
    	}
    	else{
    		for (int i=0;i<this.val.size();i++){
    			if (b.val.get(0) < this.val.get(i)){//compara el valor de b con cada valor de ay lo agrega en el primer o segundo hijo
    				this.hijos.get(i).insertar(b);
    				break;//return;
    			}
    		}
    	}
    }
    
    private void splitear(){
    	Nodo hijoizq = new Nodo(this.val.get(0));
    	Nodo hijoder = new Nodo(this.val.get(2));
    	if (this.hijos.size()==4){ //revisar esta wea
    		this.hijos.get(0).par=hijoizq;
    		this.hijos.get(1).par=hijoizq;
    		this.hijos.get(2).par=hijoder;
    		this.hijos.get(3).par=hijoder;
    		hijoizq.hijos.add(this.hijos.get(0));
    		hijoizq.hijos.add(this.hijos.get(1));
    		hijoder.hijos.add(this.hijos.get(2));
    		hijoder.hijos.add(this.hijos.get(3));
    	}
    	this.hijos.clear();//cuando es hoja
    	this.hijos.add(hijoizq);
    	this.hijos.add(hijoder);
    	int auxiliar=this.val.get(1);
    	this.val.clear();
    	this.val.add(auxiliar);
    	
    	if (this.par!=null){//aqui
    		if (this.par.hijos.contains(this)){
    			this.par.hijos.remove(this);
    		}
    		this.par.agregar(this);
    	}
    	else {
    		hijoizq.par=this;
    		hijoder.par=this;
    	}
    	
    }
    private void sortnodo(){
    	Nodo aux;
    	for (int i=0; i<this.hijos.size()-1; i++){//selecciona nodo a comparar
    		if(this.hijos.get(i).val.get(0)>this.hijos.get(i+1).val.get(0)){//tiene q partir de 0 compara
    			aux=this.hijos.get(i+1);
    			this.hijos.remove(i+1);
    			this.hijos.add(i+1,this.hijos.get(i));
    			this.hijos.remove(i);
    			this.hijos.add(i,aux);}
    		}
    	}
    public void preordern(){
    	if (this!=null){
	    if (this.val.size()==1 && this.hijos.size()!=0){
	      System.out.print(this.val.get(0) + " ");
	      this.hijos.get(0).preordern();
	      this.hijos.get(1).preordern();
	    }
	    else if (this.val.size()==2 && this.hijos.size()!=0){
	      System.out.print(this.val.get(0) + "," +this.val.get(1) + " ");
	      this.hijos.get(0).preordern();
	      this.hijos.get(1).preordern();
	      this.hijos.get(2).preordern();
	    }
	    else if (this.val.size()==1 && this.hijos.size()==0){
	      System.out.print(this.val.get(0) +" "+". . ");
	    }
	    
	    else if (this.val.size()==2 && this.hijos.size()==0){
		      System.out.print(this.val.get(0)+ ","+this.val.get(1) + " "+". . . ");
		    }
    	}
    	if (this.val.size()==0) {
        	System.out.print(". ");
        }
	  }
    	
}