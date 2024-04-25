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
            int c=0;
        do {
            b= showInputDialog("Ingrese su número de cédula real");
            a = showInputDialog("Ingrese su nombre real");
            String primerosDosCaracteres = b.substring(0, 2);
            c=Integer.parseInt(primerosDosCaracteres);
        }while(b.length()<10 );
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
                    if (cantidad>boletosDisponibles(pelicula)){
                        JOptionPane.showMessageDialog(null,"No hay esa cantidad de boletos disponibles");
                    }else {
                        String peli = cboPelicula.getSelectedItem().toString();
                        cine.encolar(pelicula, cantidad);
                        txtEntradas.append("Compras:\n");
                        txtEntradas.append("Película: " + peli + "\n");
                        txtEntradas.append("Cantidad de entradas: " + cantidad + "\n");
                        txtEntradas.append("--------------------\n");


                        JOptionPane.showMessageDialog(null, "Boletos disponibles para esta pelicula: " + boletosDisponibles(peli));
                    }}
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
