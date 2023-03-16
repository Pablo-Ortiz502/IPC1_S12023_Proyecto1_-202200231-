package CBP;
import Guia.Factura;
import Guia.Guia;
import Loguin.Menu;
import Loguin.Usuarios;
import Loguin.Login;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class CBP extends JFrame{
    private JComboBox origenDepacomboBox1;
    private JComboBox origenMunicomboBox2;
    private JComboBox destinoDepacomboBox3;
    private JComboBox destinoMunicomboBox4;
    private JComboBox tamañocajacomboBox5;
    private JButton cotizarButton;
    private JComboBox tipopagocomboBox6;
    private JComboBox tipofacturacomboBox7;
    private JButton realizarPagoButton;
    private JButton giaButton;
    private JButton facturaButton;
    private JButton cancelarPagoButton;
    private JPanel pagoPane;
    private JTextField tarjetastextField1;
    private JComboBox tipopreciocomboBox1;
    private JTextField numerocajastextField1;
    private JTextField precionormatextField1;
    private JTextField precioespecialtextField2;
    private JTextField nombredestinotextField1;
    private JTextField cvvtextField1;

    private LinkedList<Cajas>listacajas;

    private LinkedList<DatosCajas>listadatos;
    private  Usuarios usuariosreg;
    private LinkedList<Usuarios>listausuarios;








public CBP(Usuarios usuariosreg,LinkedList<Cajas>listacajas,LinkedList<DatosCajas>listadatos,LinkedList<Usuarios>listausuarios) {


    super();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(pagoPane);
    this.pack();
    this.setLocationRelativeTo(null);
    this.usuariosreg = usuariosreg;
    this.listacajas = listacajas;
    this.listadatos = listadatos;
    this.listausuarios = listausuarios;

    realizarPagoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            agregarcaja();

        }
    });
    giaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        guiaorden();
        }
    });
    facturaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            factutraorden();
        }
    });
    cancelarPagoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        eliminarcajas();
        dispose();
        }
    });

    cotizarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            contizar();
        }
    });


    tipopagocomboBox6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tarjeta();
        }
    });

    this.setVisible(true);
}

public void guiaorden(){
    String precioes = precioespecialtextField2.getText();
    String precio = precionormatextField1.getText();
    String destino = nombredestinotextField1.getText();
    String tipopago = (String) tipopagocomboBox6.getSelectedItem();
    String cvv = cvvtextField1.getText();

    if (precio.isEmpty() || precioes.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Por favor presionar Realizar pago","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    } else if (destino.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Por favor presionar Realizar pago","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    }else if(tipopago.equals("Tarjeta") && cvv.isEmpty()){
        JOptionPane.showMessageDialog(this,"Por favor presionar Realizar pago","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    } else {
        Guia guia = new Guia(usuariosreg,listacajas);
        JOptionPane.showMessageDialog(this,"Guia  descargada");
        return;
    }


    }
public void factutraorden(){
        String precioes = precioespecialtextField2.getText();
        String precio = precionormatextField1.getText();
        String destino = nombredestinotextField1.getText();
        String tipopago = (String) tipopagocomboBox6.getSelectedItem();
        String cvv = cvvtextField1.getText();

        if (precio.isEmpty() || precioes.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Por favor presionar Realizar pago","Trate otra vez",JOptionPane.ERROR_MESSAGE);
            return;
        }else if (destino.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Por favor presionar Realizar pago","Trate otra vez",JOptionPane.ERROR_MESSAGE);
            return;
        }else if(tipopago.equals("Tarjeta") && cvv.isEmpty()){
            JOptionPane.showMessageDialog(this,"Por favor presionar Realizar pago","Trate otra vez",JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            Factura factura = new Factura(usuariosreg,listacajas,listadatos);
            JOptionPane.showMessageDialog(this,"Factura  descargada");
            return;
        }


    }
public  void  tarjeta(){
    String tipopago = (String) tipopagocomboBox6.getSelectedItem();


    if(tipopago.equals("Tarjeta") && usuariosreg.tarjetacd.isEmpty()){
        tarjetastextField1.setText("No hay tarjetas registradas");
    }else if (tipopago.equals("Tarjeta")){
        cvvtextField1.setEnabled(true);
        String tarjettta = usuariosreg.tarjetacd.substring(12,16);
        tarjetastextField1.setText("XXXXXXXXXXX"+ tarjettta);
    }else if (tipopago.equals("Pago contra entrega (recargo Q5.00)")) {
        tarjetastextField1.setText("");
        cvvtextField1.setEnabled(false);
        cvvtextField1.setText("");
    }



}
public void eliminarcajas(){

    Menu menu = new Menu(usuariosreg,listausuarios,listacajas,listadatos);
    dispose();
}
public void agregarcaja(){

    String destinoDepa = (String) destinoDepacomboBox3.getSelectedItem();
    String destinoMuni = (String) destinoMunicomboBox4.getSelectedItem();
    String origenDepa = (String) origenDepacomboBox1.getSelectedItem();
    String origenMuni = (String) origenMunicomboBox2.getSelectedItem();
    String tamañocaja = (String) tamañocajacomboBox5.getSelectedItem();
    String numerodecajas = numerocajastextField1.getText();
    String nombredestino = nombredestinotextField1.getText();
    String precioes = precioespecialtextField2.getText();
    String precio = precionormatextField1.getText();
    String cvv = cvvtextField1.getText();

    String  tipoprecio = (String) tipopreciocomboBox1.getSelectedItem();
    String tipopago = (String) tipopagocomboBox6.getSelectedItem();
    String datosfac = (String) tipofacturacomboBox7.getSelectedItem();



    DatosCajas nuevadat = new DatosCajas(datosfac);
    DatosCajas.listadatos.add(nuevadat);

    if (numerodecajas.isEmpty()){
        JOptionPane.showMessageDialog(this,"Por favor presionar cotizar","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    }

    if(tipopago.equals("Tarjeta") && cvv.isEmpty()/* && usuariosreg.tarjetacd.isEmpty() == true*/){
        JOptionPane.showMessageDialog(this,"Por favor llenar el CVV de su tarjeta","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    } else if (cvv.length() > 3 || cvv.length() < 3) {
            JOptionPane.showMessageDialog(this,"El CVV ndebe tener 3 dijitos.","Trate otra vez",JOptionPane.ERROR_MESSAGE);
            return;
    }

    if (precio.isEmpty() || precioes.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Por favor precionar cotizar","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (nombredestino.isEmpty()){
        JOptionPane.showMessageDialog(this,"Por favor colocar el nombre del destinatario","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    }
    if(tipoprecio.equals("Normal") && tipopago.equals("Tarjeta")){
        float preciofinal = Float.parseFloat(precionormatextField1.getText());
        Cajas nuevacaja = new Cajas(origenDepa,origenMuni,destinoDepa,destinoMuni,tamañocaja,numerodecajas,nombredestino,preciofinal);
        Cajas.listacajas.add(nuevacaja);
        numerocajastextField1.setText("");
        JOptionPane.showMessageDialog(this,"Orden confirmada");
        return;
    } else if (tipoprecio.equals("Especial") && tipopago.equals("Tarjeta")) {
        float preciofinal = Float.parseFloat(precioespecialtextField2.getText());
        Cajas nuevacaja = new Cajas(origenDepa,origenMuni,destinoDepa,destinoMuni,tamañocaja,numerodecajas,nombredestino,preciofinal);
        Cajas.listacajas.add(nuevacaja);
        numerocajastextField1.setText("");
        JOptionPane.showMessageDialog(this,"Orden confirmada");
        return;

    } else if (tipoprecio.equals("Normal") && tipopago.equals("Pago contra entrega (recargo Q5.00)")) {
        float preciofinal = Float.parseFloat(precionormatextField1.getText())+5;
        Cajas nuevacaja = new Cajas(origenDepa,origenMuni,destinoDepa,destinoMuni,tamañocaja,numerodecajas,nombredestino,preciofinal);
        Cajas.listacajas.add(nuevacaja);
        numerocajastextField1.setText("");
        JOptionPane.showMessageDialog(this,"Orden confirmada");
        return;

    } else if (tipoprecio.equals("Especial") && tipopago.equals("Pago contra entrega (recargo Q5.00)")) {
        float preciofinal = Float.parseFloat(precioespecialtextField2.getText())+5;
        Cajas nuevacaja = new Cajas(origenDepa,origenMuni,destinoDepa,destinoMuni,tamañocaja,numerodecajas,nombredestino,preciofinal);
        Cajas.listacajas.add(nuevacaja);
        precioespecialtextField2.setText("");
        JOptionPane.showMessageDialog(this,"Orden confirmada");
        return;

    }


}

public void contizar(){
    String destinoDepa = (String) destinoDepacomboBox3.getSelectedItem();
    String numerodecajas = numerocajastextField1.getText();
    String caja = numerocajastextField1.getText();
   float precionorm;
    float precioesp;
    String precionormS;
    String precioespS;

    if (caja.isEmpty()){
        JOptionPane.showMessageDialog(this,"Por favor agregar un numero de paquetes","Trate otra vez",JOptionPane.ERROR_MESSAGE);
        return;
    }


    if(destinoDepa.equals("Guatemala")){
        precionorm = (float) (Integer.parseInt(numerodecajas)*35);
        precioesp = (float) (Integer.parseInt(numerodecajas)*25);

        precioespS =  Float.toString(precioesp);
        precionormS = Float.toString(precionorm);

        precionormatextField1.setText(precionormS);
        precioespecialtextField2.setText(precioespS);
    }
    //Region Norte
    else if (destinoDepa.equals("Alta Verapaz") || destinoDepa.equals("Baja Verapaz") ) {

        precionorm = (float) (Integer.parseInt(numerodecajas)*68.50);
        precioesp = (float) (Integer.parseInt(numerodecajas)*45.55);

        precioespS =  Float.toString(precioesp);
        precionormS =  Float.toString(precionorm);

        precionormatextField1.setText(precionormS);
        precioespecialtextField2.setText(precioespS);
    }
    //Region Nororiente
    else if (destinoDepa.equals("Izabal") || destinoDepa.equals("Chiquimula") || destinoDepa.equals("Zacapa") || destinoDepa.equals("El Progreso")) {

        precionorm = (float) (Integer.parseInt(numerodecajas)*58.68);
        precioesp = (float) (Integer.parseInt(numerodecajas)*35.48);

        precioespS =  Float.toString(precioesp);
        precionormS = Float.toString(precionorm);

        precionormatextField1.setText(precionormS);
        precioespecialtextField2.setText(precioespS);
    }
    //Region Suroriente
    else if (destinoDepa.equals("Jutiapa") || destinoDepa.equals("Jalapa") || destinoDepa.equals("Santa Rosa")) {

        precionorm = (float) (Integer.parseInt(numerodecajas)*38.68);
        precioesp = (float) (Integer.parseInt(numerodecajas)*32.48);

        precioespS = Float.toString(precioesp);
        precionormS = Float.toString(precionorm);

        precionormatextField1.setText(precionormS);
        precioespecialtextField2.setText(precioespS);
    }
    // Recgion Surocciondete
    else if (destinoDepa.equals("San Marcos") || destinoDepa.equals("Quetzaltenango") || destinoDepa.equals("Totonicapán") || destinoDepa.equals("Sololá") || destinoDepa.equals("Retalhuleu")) {

        precionorm = (float) (Integer.parseInt(numerodecajas)*34);
        precioesp = (float) (Integer.parseInt(numerodecajas)*29);

        precioespS = Float.toString(precioesp);
        precionormS = Float.toString(precionorm);

        precionormatextField1.setText(precionormS);
        precioespecialtextField2.setText(precioespS);
    }
    //Noroccidente
    else if (destinoDepa.equals("Huehuetenango") || destinoDepa.equals("Quiché")) {

        precionorm = (float) (Integer.parseInt(numerodecajas)*44.50);
        precioesp = (float) (Integer.parseInt(numerodecajas)*40);

        precioespS = Float.toString(precioesp);
        precionormS =  Float.toString(precionorm);

        precionormatextField1.setText(precionormS);
        precioespecialtextField2.setText(precioespS);
    }

}

}

