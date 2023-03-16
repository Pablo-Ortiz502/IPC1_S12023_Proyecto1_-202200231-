package Loguin;

import CBP.CBP;
import CBP.Cajas;
import CBP.DatosCajas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Menu extends JFrame{
    private JButton realizarEnvioButton;
    private JButton salirButton;
    private JButton perfilbutton3;
    private JTextField nametextField1;
    private JPanel menuPane;

    private Usuarios usuariosreg;

    private LinkedList<Usuarios> listausuarios;
    private LinkedList<Cajas> listacajas;
    private LinkedList<DatosCajas> listadatos;





    public Menu(Usuarios usuariosreg, LinkedList<Usuarios> listausuarios, LinkedList<Cajas> listacajas, LinkedList<DatosCajas> listadatos) {

        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(menuPane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.listausuarios = listausuarios;
        this.usuariosreg = usuariosreg;
        this.listacajas = listacajas;
        this.listadatos = listadatos;
        names();

        realizarEnvioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CBP cbp = new CBP(usuariosreg, Cajas.listacajas, DatosCajas.listadatos,Usuarios.listausuarios);
                dispose();
            }
        });
        perfilbutton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Perfil perfil = new Perfil(usuariosreg,listausuarios,listacajas,listadatos);
                dispose();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login  login =  new Login(Usuarios.listausuarios,usuariosreg);
                dispose();
            }
        });
    }

    public void names(){

        if(usuariosreg == null){
            nametextField1.setText(Usuarios.listausuarios.getFirst().nobreusuario + " " + Usuarios.listausuarios.getFirst().apelliuousuario);
        }else {nametextField1.setText(usuariosreg.nobreusuario + " " +usuariosreg.apelliuousuario);}
    }
}

