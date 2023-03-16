package Loguin;

import CBP.Cajas;
import CBP.DatosCajas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Perfil extends JFrame {
    private JPanel perfilPane;
    private JTextField nombretextField1;
    private JTextField apellidotextField2;
    private JTextField aliastextField3;
    private JTextField correotextField4;
    private JTextField telefonotextField5;
    private JTextField dpitextField6;
    private JTextField nittextField7;
    private JTextField paswordtextField8;
    private JTextField tarjetatextField9;
    private JTextField direcciontextField10;
    private JButton editarButton;
    private JButton registrarButton;

    private Usuarios usuariosreg;
    private LinkedList<Usuarios> listausuarios;
    private LinkedList<Cajas> listacajas;
    private LinkedList<DatosCajas> listadatos;

public Perfil(Usuarios usuariosreg,LinkedList<Usuarios> listausuarios,LinkedList<Cajas> listacajas,LinkedList<DatosCajas> listadatos) {
    super();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(perfilPane);
    this.pack();
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.usuariosreg = usuariosreg;
    this.listausuarios = listausuarios;
    this.listacajas = listacajas;
    this.listadatos = listadatos;

    setUsuariosreg();

    editarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            editar();
        }
    });
    registrarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        guardar();
        }
    });
}

public void setUsuariosreg(){
    nombretextField1.setText(usuariosreg.nobreusuario);
    apellidotextField2.setText(usuariosreg.apelliuousuario);
    aliastextField3.setText(usuariosreg.aliasusuario);
    correotextField4.setText(usuariosreg.correousuario);
    telefonotextField5.setText(usuariosreg.telefonousuario);
    nittextField7.setText(usuariosreg.nitusuario);
    direcciontextField10.setText(usuariosreg.direccionusuario);
    dpitextField6.setText(usuariosreg.dpiusuario);
    paswordtextField8.setText(usuariosreg.contraseñausuario);
    tarjetatextField9.setText(usuariosreg.tarjetacd);
}
public void editar (){
    nombretextField1.setEditable(true);
    apellidotextField2.setEditable(true);
    aliastextField3.setEditable(true);
    correotextField4.setEditable(true);
    telefonotextField5.setEditable(true);
    nittextField7.setEditable(true);
    direcciontextField10.setEditable(true);
    paswordtextField8.setEditable(true);
    tarjetatextField9.setEditable(true);

}

public void guardar(){

    String nombre = nombretextField1.getText();
    String apellido = apellidotextField2.getText();
    String alias = aliastextField3.getText();
    String correo = correotextField4.getText();
    String telefono =  telefonotextField5.getText();
    String nit = nittextField7.getText();
    String direccion = direcciontextField10.getText();
    String pasword = paswordtextField8.getText();
    String tarjeta = tarjetatextField9.getText();

    if(tarjeta.length()<16 || tarjeta.length()>16){
        JOptionPane.showMessageDialog(this,"La tarjeta debe tener 16 dijitos","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    }else if(nombre.isEmpty() || apellido.isEmpty()||alias.isEmpty()||correo.isEmpty()||telefono.isEmpty()||pasword.isEmpty() || nit.isEmpty() || direccion.isEmpty()){
        JOptionPane.showMessageDialog(this,"Ingresar todos los datos","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    }else {

        usuariosreg.nobreusuario = nombre;
        usuariosreg.apelliuousuario = apellido;
        usuariosreg.aliasusuario = alias;
        usuariosreg.correousuario = correo;
        usuariosreg.telefonousuario = telefono;
        usuariosreg.nitusuario = nit;
        usuariosreg.direccionusuario = direccion;
        usuariosreg.contraseñausuario = pasword;
        usuariosreg.tarjetacd = tarjeta;

        JOptionPane.showMessageDialog(this,"Usuario editado correctamente");

        Menu menu = new Menu(usuariosreg,listausuarios,listacajas,listadatos);
        dispose();
    }



}

}
