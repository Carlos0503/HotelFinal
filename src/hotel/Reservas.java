package hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import PaqC06.*;

public class Reservas extends JFrame{
    private JPanel reserva;
    private JTextField tfNomb;
    private JTextField tfAp;
    private JTextField tfDir;
    private JTextField tfTel;
    private JTextField tfEmail;
    private JTextField tfDNI;
    private JTextField tfTarC;
    private JCheckBox chEst;
    private JTextField tfEst;
    private JComboBox cbRég;
    private JCheckBox chBalcón;
    private JCheckBox chSuite;
    private JTextField tfBalcón;
    private JTextField tfSuite;
    private JTextField tfPreT;
    private JButton btnCal;
    private JButton btnCancelar;
    private JButton btnLimp;
    private JButton btnConf;
    private JButton btnBuscar;

    public Reservas(Hotel h1){
        setContentPane(reserva);
        setTitle("Reservas");
        setSize(1200,500);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        cbRég.addItem("");
        cbRég.addItem("Sin desayuno");
        cbRég.addItem("Con desayuno");
        cbRég.addItem("Media pensión");
        cbRég.addItem("Pensión completa");
        tfEst.setText("0");
        tfBalcón.setText("0");
        tfSuite.setText("0");
        Hotel h=h1;

        btnLimp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNomb.setText("");
                tfAp.setText("");
                tfDir.setText("");
                tfTel.setText("");
                tfEmail.setText("");
                tfDNI.setText("");
                tfTarC.setText("");
                tfPreT.setText("");
                tfEst.setText("0");
                tfBalcón.setText("0");
                tfSuite.setText("0");
                cbRég.setSelectedItem("");
                chEst.setSelected(false);
                chBalcón.setSelected(false);
                chSuite.setSelected(false);
            }
        });
        chEst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chEst.isSelected()){
                    tfEst.setText("1");
                    Descripcion d=new Descripcion("Has seleccionado Estándar");
                }
                else tfEst.setText("0");
            }
        });
        chBalcón.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chBalcón.isSelected()){
                    tfBalcón.setText("1");
                    Descripcion d=new Descripcion("Has seleccionado Balcón");
                }
                else tfBalcón.setText("0");
            }
        });
        chSuite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chSuite.isSelected()){
                    tfSuite.setText("1");
                    Descripcion d=new Descripcion("Has seleccionado Suite");
                }
                else tfSuite.setText("0");
            }
        });
        cbRég.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbRég.getSelectedItem()=="Sin desayuno"){
                    Descripcion d=new Descripcion("Has seleccionado Sin desayuno");
                }
                if(cbRég.getSelectedItem()=="Con desayuno"){
                    Descripcion d=new Descripcion("Has seleccionado Con desayuno");
                }
                if(cbRég.getSelectedItem()=="Media pensión"){
                    Descripcion d=new Descripcion("Has seleccionado Media pensión");
                }
                if(cbRég.getSelectedItem()=="Pensión completa"){
                    Descripcion d=new Descripcion("Has seleccionado Pensión completa");
                }
            }
        });
        btnConf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime fecha = LocalDateTime.now();
                String fechaent = fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear();
                String fechasal = fecha.getDayOfMonth()+10+"/"+fecha.getMonthValue()+"/"+fecha.getYear();
                int i;
                int est2=0;
                int bal2=0;
                int sui2=0;
                if(chEst.isSelected()){
                    String txtE=tfEst.getText();
                    est2=Integer.parseInt(txtE);
                }
                if(chBalcón.isSelected()){
                    String txtB=tfBalcón.getText();
                    bal2=Integer.parseInt(txtB);
                }
                if(chSuite.isSelected()){
                    String txtS=tfSuite.getText();
                    sui2=Integer.parseInt(txtS);
                }
                int totalhab=est2+bal2+sui2;
                if(totalhab<=48 && est2<=30 && bal2<=12 && sui2<=6){
                int [] tipo = new int[totalhab];
                int j;
                int k;
                for(i=0;i<est2;i++){
                    tipo[i]=0;
                }
                for(j=est2;j<est2+bal2;j++){
                    tipo[j]=1;
                }
                for(k=est2+bal2;k<totalhab;k++){
                    tipo[k]=2;
                }
                h.hacerReserva(tipo,tfDNI.getText(),tfNomb.getText(),tfAp.getText(),tfTel.getText(),tfTarC.getText(),fechaent,fechasal, (String) cbRég.getSelectedItem());
                    Descripcion d=new Descripcion("Reserva confirmada");
                    System.out.println(h.toString());
                }
                else {
                    Descripcion d2 = new Descripcion("Exceso de habitaciones");
                }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnCal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int est=60;
                int bal=75;
                int sui=90;
                int cd=10;
                int mp=30;
                int pt=50;
                int total;
                String txtE=tfEst.getText();
                String txtB=tfBalcón.getText();
                String txtS=tfSuite.getText();
                int est2=Integer.parseInt(txtE);
                int bal2=Integer.parseInt(txtB);
                int sui2=Integer.parseInt(txtS);
                if(chEst.isSelected() && chSuite.isSelected() && chBalcón.isSelected()){
                    if(cbRég.getSelectedItem()=="Sin desayuno"){
                        total=(est2*est)+(bal2*bal)+(sui2*sui);
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Con desayuno"){
                        total=(est2*est)+(bal2*bal)+(sui2*sui)+cd;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Media pensión"){
                        total=(est2*est)+(bal2*bal)+(sui2*sui)+mp;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Pensión completa"){
                        total=(est2*est)+(bal2*bal)+(sui2*sui)+pt;
                        tfPreT.setText(""+total);
                    }
                }

                if(chEst.isSelected() && !chSuite.isSelected() && chBalcón.isSelected()){
                    if(cbRég.getSelectedItem()=="Sin desayuno"){
                        total=(est2*est)+(bal2*bal);
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Con desayuno"){
                        total=(est2*est)+(bal2*bal)+cd;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Media pensión"){
                        total=(est2*est)+(bal2*bal)+mp;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Pensión completa"){
                        total=(est2*est)+(bal2*bal)+pt;
                        tfPreT.setText(""+total);
                    }
                }

                if(chEst.isSelected() && chSuite.isSelected() && !chBalcón.isSelected()){
                    if(cbRég.getSelectedItem()=="Sin desayuno"){
                        total=(est2*est)+(sui2*sui);
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Con desayuno"){
                        total=(est2*est)+(sui2*sui)+cd;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Media pensión"){
                        total=(est2*est)+(sui2*sui)+mp;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Pensión completa"){
                        total=(est2*est)+(sui2*sui)+pt;
                        tfPreT.setText(""+total);
                    }
                }

                if(!chEst.isSelected() && chSuite.isSelected() && chBalcón.isSelected()){
                    if(cbRég.getSelectedItem()=="Sin desayuno"){
                        total=(bal2*bal)+(sui2*sui);
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Con desayuno"){
                        total=(bal2*bal)+(sui2*sui)+cd;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Media pensión"){
                        total=(bal2*bal)+(sui2*sui)+mp;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Pensión completa"){
                        total=(bal2*bal)+(sui2*sui)+pt;
                        tfPreT.setText(""+total);
                    }
                }

                if(chEst.isSelected() && !chSuite.isSelected() && !chBalcón.isSelected()){
                    if(cbRég.getSelectedItem()=="Sin desayuno"){
                        total=est2*est;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Con desayuno"){
                        total=(est2*est)+cd;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Media pensión"){
                        total=(est2*est)+mp;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Pensión completa"){
                        total=(est2*est)+pt;
                        tfPreT.setText(""+total);
                    }
                }

                if(!chEst.isSelected() && chSuite.isSelected() && !chBalcón.isSelected()){
                    if(cbRég.getSelectedItem()=="Sin desayuno"){
                        total=sui2*sui;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Con desayuno"){
                        total=(sui2*sui)+cd;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Media pensión"){
                        total=(sui2*sui)+mp;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Pensión completa"){
                        total=(sui2*sui)+pt;
                        tfPreT.setText(""+total);
                    }
                }

                if(!chEst.isSelected() && !chSuite.isSelected() && chBalcón.isSelected()){
                    if(cbRég.getSelectedItem()=="Sin desayuno"){
                        total=bal2*bal;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Con desayuno"){
                        total=(bal2*bal)+cd;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Media pensión"){
                        total=(bal2*bal)+mp;
                        tfPreT.setText(""+total);
                    }
                    if(cbRég.getSelectedItem()=="Pensión completa"){
                        total=(bal2*bal)+pt;
                        tfPreT.setText(""+total);
                    }
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reserva r;
                if(tfDNI.getText()!="") {
                    r = h.comprobarDNI(tfDNI.getText());
                    if(r==null){
                        Descripcion d = new Descripcion("El dni no coincide con ninguna reserva del hotel");
                    }
                    else{
                        tfNomb.setText(r.getNombre());
                        tfAp.setText(r.getApellidos());
                        tfTel.setText(r.getTelefono());
                        tfTarC.setText(r.getTarjeta());
                    }
                }
                else {
                    Descripcion d = new Descripcion("Rellena el dni,al menos, para realizar esta acción");
                }
            }
        });
    }

}
