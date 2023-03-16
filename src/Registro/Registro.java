package Registro;

import Loguin.Login;
import Loguin.Usuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Registro extends JFrame {

    private  Usuarios usuariosreg;
    private JButton registrarButton;
    private JButton cancelarButton;
    private JTextField nombretextField1;
    private JTextField apellidotextField2;
    private JTextField aliastextField3;
    private JTextField correotextField4;
    private JTextField telefonotextField5;
    private JTextField dpitextField6;
    private JTextField nittextField7;
    private JComboBox generocomboBox1;
    private JComboBox paiscomboBox2;
    private JComboBox rolcomboBox3;
    private JPanel regisroPane;
    private JTextField paswordtextField8;
    private JTextField tarjetacdtextField1;
    private JTextField direcciontextField1;
    private LinkedList<Usuarios>listausuarios;
    public Registro(LinkedList<Usuarios>listausuarios,Usuarios usuariosreg) {


    super();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(regisroPane);
    this.pack();
    this.setLocationRelativeTo(null);


    this.listausuarios = listausuarios;

    this.usuariosreg = usuariosreg;


    registrarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            registeruser();
        }


    });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Login login = new Login(listausuarios,usuariosreg);
               dispose();
            }
        });
        this.setVisible(true);
    }


    public void registeruser(){
        String nombre = nombretextField1.getText();
        String apellido =  apellidotextField2.getText();
        String alias = aliastextField3.getText();
        String correo  = correotextField4.getText();
        String telefono = telefonotextField5.getText();
        String dpi = dpitextField6.getText();
        String nit = nittextField7.getText();
        String pasword = paswordtextField8.getText();
        String tarjetacd = tarjetacdtextField1.getText();
        String genero = (String) generocomboBox1.getSelectedItem();
        String nacion = (String) paiscomboBox2.getSelectedItem();
        String rol = (String) rolcomboBox3.getSelectedItem();
        String direccion = direcciontextField1.getText();

        if(tarjetacd.length()<16 || tarjetacd.length()>16){
            JOptionPane.showMessageDialog(this,"La tarjeta debe tener 16 dijitos","Trate otra vez",JOptionPane.ERROR_MESSAGE);
            return;
        }else if(nombre.isEmpty() || apellido.isEmpty()||alias.isEmpty()||correo.isEmpty()||telefono.isEmpty()||dpi.isEmpty()||nit.isEmpty()||pasword.isEmpty()||genero.isEmpty()||nacion.isEmpty()||rol.isEmpty()){
            JOptionPane.showMessageDialog(this,"Ingresar todos los datos","Trate otra vez",JOptionPane.ERROR_MESSAGE);
            return;
        }else {

            Usuarios usuariosreg = new Usuarios(nombre,apellido,alias,dpi,telefono,pasword,nit,genero,nacion,rol,correo,tarjetacd,direccion);
            Usuarios.listausuarios.add(usuariosreg);
            Login login = new Login(listausuarios,usuariosreg);
            JOptionPane.showMessageDialog(this,"Usuario registrado");
            dispose();
        }






    }
}
