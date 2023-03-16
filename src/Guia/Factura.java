package Guia;

import CBP.Cajas;
import CBP.DatosCajas;
import Loguin.Usuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Factura {

    private LinkedList<Usuarios>listausuarios;
    private LinkedList<Cajas>listacajas;
    private  LinkedList<DatosCajas>listadatos;
    private Usuarios usuariosreg;

    public Factura(Usuarios usuariosreg,LinkedList<Cajas>listacajas,LinkedList<DatosCajas>listadatos){
        this.listacajas = listacajas;
        this.listadatos = listadatos;
        this.usuariosreg = usuariosreg;
       gestiones();
    }
    public String persona;
    public void gestiones(){
        if(listadatos.getLast().tipofac.equals("C/F")){
            persona = "C/F";
        } else if (listadatos.getLast().tipofac.equals("NIT")) {
            persona = usuariosreg.nitusuario;
        }
        crearGuia();
    }
    public void crearGuia(){
        Random random = new Random();
        try {
            FileWriter archivoHTML = new FileWriter("Factura.html");
            archivoHTML.write(
                    "<!DOCTYPE html>\n" +
                            "<html lan = \"es\">\n"+
                            "<head>\n"+
                            "<meta charset = \"utf-8\">"+
                            "<title>Factura</title>"+
                            "</head>" +
                            "<body>");
            archivoHTML.write("<table border=\"1\">\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>NIT </td>\n" +
                    "\n" +
                    "    <td>"+persona+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Nombre:</td>\n" +
                    "\n" +
                    "    <td>"+usuariosreg.nobreusuario+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Direccion:</td>\n" +
                    "\n" +
                    "    <td>"+usuariosreg.direccionusuario+"</td>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "   <th scope=\"col\">Numero de paquetes</th>" +
                    "\n" +
                    "    <th scope=\"col\">tamaño del paquete</th>" +
                    "\n" +
                    "    <th scope=\"col\">Total</th>" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().numerodecajas+"</td>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().tamañocajas+"</td>\n" +
                    "\n" +
                    "    <td><strong>"+Cajas.listacajas.getLast().preciocaja+"</strong></td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "</table>");
            archivoHTML.write("</body></html>");
            archivoHTML.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}