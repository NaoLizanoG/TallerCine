import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import static javax.swing.JOptionPane.showInputDialog;

public class FormularioCine {
    private JPanel principal;
    private JComboBox cboPelicula;
    private JComboBox cboCantidad;
    private JButton cboComprar;
    private JTextArea txtEntradas;
    private JButton btnPelicula1;
    private JButton btnPelicula2;
    private JLabel txtAutor;

    private Cine cine=new Cine();
    public FormularioCine() {
        try {
        String a="",b="";
        do {
            b= showInputDialog("Ingrese su número de cédula real");
            a = showInputDialog("Ingrese su nombre real");
        }while(b.length()<10);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Taller1ProgramacionIII.dat"));
            o.writeObject(a+b);
        }catch (Exception ex) {

        }
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cantidad = Integer.parseInt(cboCantidad.getSelectedItem().toString());
                if (cantidad>=4){
                    JOptionPane.showMessageDialog(null,"Puede comprar un máximo de 3 entradas");
                    return;
                }else {
                String pelicula = cboPelicula.getSelectedItem().toString();
                cine.encolar(pelicula,cantidad);
                txtEntradas.setText(cine.listarAsistente());
               String peli = cboPelicula.getSelectedItem().toString();
               JOptionPane.showMessageDialog(null,"Boletos disponibles para esta pelicula: "+boletosDisponibles(peli));
                }
            }
        });
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pelicula1="XMEN";
                JOptionPane.showMessageDialog(null,"Boletos disponibles: "+boletosDisponibles(pelicula1));
            }
        });
        btnPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pelicula2="MARIO";
                JOptionPane.showMessageDialog(null,"Boletos disponibles: "+boletosDisponibles(pelicula2));
            }
        });
    }

    public int boletosDisponibles(String pelicula){
       int ocupados = cine.listarAsistentePelicula(pelicula);
        int disponibles = 23-ocupados;
        if (disponibles<=0){
            return 0;
        }else {
            return disponibles;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioCine");
        frame.setContentPane(new FormularioCine().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
