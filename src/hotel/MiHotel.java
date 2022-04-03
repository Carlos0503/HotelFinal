package hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PaqC06.*;

public class MiHotel extends JFrame {
    private JTextField tfUsuario;
    private JButton btnLimpiar;
    private JButton btnEntrar;
    private JPanel hotel;
    private JPasswordField tpContraseña;
    private Hotel h;

    public MiHotel(Hotel h1){
        String usuario="usuario1";
        String contraseña="123456";
        setContentPane(hotel);
        setTitle("Hotel Montealegre **");
        setSize(550,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.h=h1;

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfUsuario.setText("");
                tpContraseña.setText("");
            }
        });
        btnEntrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuario.equals(tfUsuario.getText()) && contraseña.equals(tpContraseña.getText())){
                    Reservas r=new Reservas(h);
                }
                else{
                    Descripcion d1=new Descripcion("Usuario o contraseña incorrecto");}
            }
        });
    }

}
