
import Loguin.Login;
import Loguin.Usuarios;
public class Main {

    public static void main(String[] args) {
        Usuarios admin = new Usuarios("Pablo","Ortiz","Pablo","3758142720101","41877278","202200231", "202200231", "Hombere", "Guatemala","Admin","hola","1234567835486275","zona 2");
        Usuarios.listausuarios.add(admin);
        Login  login = new Login(Usuarios.listausuarios,admin);
    }

}