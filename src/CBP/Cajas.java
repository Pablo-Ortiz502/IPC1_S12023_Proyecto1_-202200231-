package CBP;

import java.util.LinkedList;

public class Cajas {
    public static LinkedList<Cajas>listacajas = new LinkedList<>();
   public String origenDepa;
   public String origenMuni;
    public String destinoDepa;
    public String destinoMuni;

   public String tamañocajas;
    public String numerodecajas;

    public String nombredestino;

    public float preciocaja;



    public Cajas(String origenDepa, String origenMuni, String destinoDepa, String destinoMuni, String tamañocajas, String numerodecajas,String nombredestino,float preciocaja){

        this.origenDepa = origenDepa;
        this.origenMuni = origenMuni;
        this.destinoDepa = destinoDepa;
        this.destinoMuni = destinoMuni;
        this.tamañocajas = tamañocajas;
        this.numerodecajas = numerodecajas;
        this.nombredestino = nombredestino;
        this.preciocaja = preciocaja;
    }
}
