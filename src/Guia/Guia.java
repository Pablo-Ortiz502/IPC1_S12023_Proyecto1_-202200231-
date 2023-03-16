package Guia;
import CBP.Cajas;
import CBP.DatosCajas;
import Loguin.Usuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Guia {
    private  Usuarios usuariosreg;
    private LinkedList<Usuarios>listausuarios;
    private LinkedList<Cajas>listacajas;

    public Guia(Usuarios usuariosreg,LinkedList<Cajas>listacajas){
        this.listacajas = listacajas;
        this.listausuarios = listausuarios;
        this.usuariosreg = usuariosreg;
        crearGuia();
    }

    public void crearGuia(){
        Random random = new Random();
        try {
            FileWriter archivoHTML = new FileWriter("Guia.html");
            archivoHTML.write(
                    "<!DOCTYPE html>\n" +
                        "<html lan = \"es\">\n"+
                        "<head>\n"+
                        "<meta charset = \"utf-8\">"+
                        "<title>Guia</title>"+
                        "</head>" +
                            "<body>");
            archivoHTML.write("<table class=\"default\">\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Origen: </td>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().origenDepa+",</td>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().origenMuni+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Destino:</td>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().destinoDepa+",</td>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().destinoMuni+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Nombre del emisor:</td>\n" +
                    "\n" +
                    "    <td>"+usuariosreg.nobreusuario+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Nombre del destinatario:</td>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().nombredestino+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Codigo:</td>\n" +
                    "\n" +
                    "    <td>"+"IPC1#"+random.nextInt(1000,9999)+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Numero de cajas:</td>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().numerodecajas+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>Tamaño del paquete:</td>\n" +
                    "\n" +
                    "    <td>"+Cajas.listacajas.getLast().tamañocajas+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "</table>");
            archivoHTML.write("<img src =\"https://www.caltico.es/wp-content/uploads/barcode-306926_1280.png\" > ");
            archivoHTML.write("</body></html>");
            archivoHTML.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
