package hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Descripcion extends JFrame {
    private JButton btnAceptar;
    private JLabel lbDescripcion;
    private JPanel descripcion;

    public Descripcion(String d){
        setContentPane(descripcion);
        setSize(350,200);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        lbDescripcion.setText(d);
        setVisible(true);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
