
package barquero;

/**
 *
 * @author eratostenes97
 */
public class AlgoritmoSolucion {
    
    private int[] vectorInicio;
    private int[] vectorFin;
    private int capacidadBote;
    private boolean monitor1, monitor2;
    
    public AlgoritmoSolucion(){
        this.vectorInicio = new int[5];
        this.vectorFin = new int[5];
        this.monitor1 = true;
        this.monitor2 = false;
        this.llenarVector();
        this.calcularCapacidad();
    }    
    
    public AlgoritmoSolucion(int dim){
        this.vectorInicio = new int[dim];
        this.vectorFin = new int[dim];
        this.monitor1 = true;
        this.monitor2 = false;
        this.llenarVector();
        this.calcularCapacidad();
        System.out.println("Inicio");
        this.imprimirVector(vectorInicio);
    }
    
    private void llenarVector(){
        int x = 2;
        for(int i = 0; i<this.vectorInicio.length; i++)
        {
            this.vectorInicio[i] = x;
            x = x *2;
        }
    }
    
    public void imprimirVector(int[] vector){
       for(int j=0; j<vector.length; j++)System.out.print(vector[j] +"\t");
        System.out.println("");
        System.out.println("Monitor 1: " + this.monitor1);
        System.out.println("Monitor 2: " + this.monitor2);
    }

    private void calcularCapacidad(){
        int cont = 0;
        for(int i = 0; i<vectorInicio.length; i++)
        {
            if(i%2 != 0){
                cont++;
            }
        }
        this.capacidadBote = cont;
    }
    
    //Algoritmo de solucion del barquero
    public void resolverVector(){
       
        this.moverPresasAdelante();
        System.out.println("=======LADO_INICIAL===========");
        this.imprimirVector(vectorInicio);
        System.out.println("=======LADO_FINAL===========");
        this.imprimirVector(vectorFin);
        this.moverDepredadoresAdelante();    
        this.moverPresasAtras();
        System.out.println("=======LADO_INICIAL===========");
        this.imprimirVector(vectorInicio);
        System.out.println("=======LADO_FINAL===========");
        this.imprimirVector(vectorFin);
        this.moverUltimoElemento();
        System.out.println("=======LADO_INICIAL===========");
        this.imprimirVector(vectorInicio);
        System.out.println("=======LADO_FINAL===========");
        this.imprimirVector(vectorFin);
        this.moverPresasAdelante();
        System.out.println("=======LADO_INICIAL===========");
        this.imprimirVector(vectorInicio);
        System.out.println("=======LADO_FINAL===========");
        this.imprimirVector(vectorFin);
        System.out.println("COMPLETADO");
        
    }
    
    public void moverPresasAdelante(){
        for(int b=0; b<vectorInicio.length; b++){
            if(b%2 != 0){
                vectorFin[b] = vectorInicio[b];
                vectorInicio[b] = 0;
                monitor1 = false;
                monitor2 = true;
            }
        }
    }
    
    private void moverPresasAtras(){
          for(int b=0; b<vectorInicio.length; b++){
            if(b%2 != 0){
                vectorInicio[b] = vectorFin[b];
                vectorFin[b]=0;
                monitor1 = true;
                monitor2 = false;
            }
        }
    }
    
    private void moverDepredadoresAdelante(){
        int capacidad =0;
        for(int i = 0; i<vectorInicio.length; i++)
        {
            
            if(i%2 == 0 && capacidad<this.capacidadBote){
                this.vectorFin[i]  =  this.vectorInicio[i];
                this.vectorInicio[i] = 0;
                this.monitor1 = false;
                this.monitor2 = true;
                capacidad++;
            }
        }
    }
    
    private void moverDepredadoresAtras(){
        int capacidad =1;
        for(int i = 0; i<vectorInicio.length; i++)
        {
            if(i%2 == 0 && capacidad<=this.capacidadBote){
                this.vectorFin[i] = this.vectorInicio[i];
                this.vectorFin[i] = 0;
                this.monitor1 = true;
                this.monitor2 = false;
                capacidad++;
            }else break;
        }
    }
    
    private void moverUltimoElemento(){
        this.vectorFin[this.vectorFin.length -1] = this.vectorInicio[this.vectorInicio.length -1] ;
        this.vectorInicio[this.vectorInicio.length -1] = 0;
        monitor1 = false;
        monitor2 = true;
    }

    public int[] getVectorInicio() {
        return vectorInicio;
    }

    public void setVectorInicio(int[] vectorInicio) {
        this.vectorInicio = vectorInicio;
    }

    public int[] getVectorFin() {
        return vectorFin;
    }

    public void setVectorFin(int[] vectorFin) {
        this.vectorFin = vectorFin;
    }

    public int getCapacidadBote() {
        return capacidadBote;
    }

    public void setCapacidadBote(int capacidadBote) {
        this.capacidadBote = capacidadBote;
    }

    public boolean isMonitor1() {
        return monitor1;
    }

    public void setMonitor1(boolean monitor1) {
        this.monitor1 = monitor1;
    }

    public boolean isMonitor2() {
        return monitor2;
    }

    public void setMonitor2(boolean monitor2) {
        this.monitor2 = monitor2;
    }
 
    
}
