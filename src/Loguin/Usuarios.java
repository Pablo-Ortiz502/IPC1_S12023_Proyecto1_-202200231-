package Loguin;

import java.util.LinkedList;

public class Usuarios {


    public static LinkedList<Usuarios> listausuarios = new LinkedList<>();
    public String nobreusuario;
    public String apelliuousuario;
    public String aliasusuario;
    public String telefonousuario;
    public String contraseñausuario;
    public String nitusuario;

    public String dpiusuario;
    public String generousuario;
    public String nacionalidadusuario;
    public String rolusuario;
    public String correousuario;
    public String tarjetacd;

    public String direccionusuario;

    public Usuarios(String nobreusuario,String apelliuousuario, String aliasusuario,String dpiusuario, String telefonousuario, String contraseñausuario, String nitusuario, String generousuario, String nacionalidadusuario, String rolusuario, String correousuario,String tarjetacd, String direccionusuario){
        this.nobreusuario = nobreusuario;
        this.apelliuousuario = apelliuousuario;
        this.aliasusuario = aliasusuario;
        this.telefonousuario = telefonousuario;
        this.contraseñausuario = contraseñausuario;
        this.nitusuario = nitusuario;
        this.generousuario = generousuario;
        this.nacionalidadusuario = nacionalidadusuario;
        this.rolusuario = rolusuario;
        this.correousuario = correousuario;
        this.dpiusuario = dpiusuario;
        this.tarjetacd = tarjetacd;
        this.direccionusuario = direccionusuario;

    }
}
