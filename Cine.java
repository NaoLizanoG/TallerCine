import java.util.LinkedList;
import java.util.Queue;

public class Cine {
    //En el diseño del Formulario existe un label actualice a su Nombre y Apellido
    //No borre ninguna sección del codigo proporcionado,
    // Si borra tendrá la nota minima 1.0
    //Se necesita completar las clases Cine y Formulario
    //Con los algoritmos y métodos necesarios de la estructura FIFO
    //Enunciado: Cada sala de cine tiene una capacidad de 23 espacios, solo se
    //pueden comprar como máximo 3 entradas por cliente a una pelicula, VALIDAR Y GARANTIZAR QUE NO SE PUEDAN VENDER MÁS VOLETOS DE LOS DISPONIBLES 
    //Desplegar cada una de las compras en el textArea.
    //Se necesita consultar cuántos espacios quedan disponibles por cada una
    //de las peliculas. DESPLEGAR DESPUES DE CADA COMPRA
    //Rubrica de calificación:
    //Completar la clase Cine 4 Puntos.
    //Agregar elemento a la Cola y mostrar en el textArea 2 Puntos.
    //Programar los botones para conocer la cantidad de espacios disponibles 4 Puntos.
    //Suba su programa a la plataforma hasta que finalice la hora.

    //Declare la referencia Cola para almacenar asistentes
    private Queue<Asistente> asistente;
    public Cine(){
        asistente = new LinkedList<Asistente>();
    }

    public boolean esVacia(){
     return asistente.isEmpty();
    }

    public int tamanio(){
       int tamanio= asistente.size();
        return tamanio;
    }

    public void encolar(String pelicula, int cantidad){
        asistente.add(new Asistente(pelicula, cantidad));
    }

    public Object desencolar() throws Exception {//el throws obliga a quien use este metodoa manejar la excepcion
        if (asistente.isEmpty())
            throw new Exception("No hay asistentes");
        else {
            asistente.poll();
        }
       //actualice el método para eliminar el elemento del inicio.
        return null;
    }

    //cree un método para listar los elementos en una textArea.
    public String listarAsistente(){
        String mensaje="";
        for(Asistente v:asistente){
            mensaje+=v.toString();
        }
        return mensaje;
    }


    //cree un método para conocer la cantidad de entradas disponibles
    public int listarAsistentePelicula(String pelicula){
        int mensaje=0;
        for(Asistente v:asistente){//for que recorre la cola
            if(v.getPelicula().equals(pelicula)){
                mensaje=mensaje+v.getCantidad();
            }
        }
        return mensaje;
    }

}
