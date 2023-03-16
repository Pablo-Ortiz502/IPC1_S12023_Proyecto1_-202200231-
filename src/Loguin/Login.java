package Loguin;

import CBP.Cajas;
import CBP.CBP;
import CBP.DatosCajas;
import Registro.Registro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Login extends JFrame{
    private LinkedList<DatosCajas>listadatos;
    private Usuarios usuariosreg;
    private Usuarios admin;
    private LinkedList<Usuarios>listausuarios;
    private JButton ingresarlogbutton1;
    private JTextField correoTextField1;
    private JTextField paswordTextField2;
    private JButton registrologbutton2;
    private JPanel loginpane;

    private LinkedList<Cajas>listacajas;


    public Login(LinkedList<Usuarios>listausuarios,Usuarios usuariosreg) {


        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginpane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.listausuarios = listausuarios;
        this.admin = admin;
        this.usuariosreg = usuariosreg;





    ingresarlogbutton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            comprovacion();

        }
    });


    registrologbutton2.addActionListener(new ActionListener() {
         @Override
          public void actionPerformed(ActionEvent e) {
             Registro registro = new Registro(Usuarios.listausuarios,usuariosreg);
             dispose();
        }
     });
    }

    public void comprovacion(){
        String correo =  correoTextField1.getText();
        String paswordlog = paswordTextField2.getText();

        int contador= 0;
        for(int i = 0; i < Usuarios.listausuarios.size() && Usuarios.listausuarios.get(i) != null; i++){
            if(paswordlog.equals(Usuarios.listausuarios.get(i).contraseñausuario) && correo.equals(Usuarios.listausuarios.get(i).correousuario)){
                Menu menu = new Menu(usuariosreg,Usuarios.listausuarios,Cajas.listacajas,DatosCajas.listadatos);
                contador++;
                dispose();
            }else if (correo.isEmpty() || paswordlog.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Ingresar todos los datos","Trate otra vez",JOptionPane.ERROR_MESSAGE);
                return;
        }
        }
        if(contador == 0){JOptionPane.showMessageDialog(this,"datos incorectos","Trate otra vez",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
