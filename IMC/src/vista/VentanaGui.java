package vista;

import logica.Persona;
import data.ModeloDatos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGui extends JFrame implements ActionListener {

    private JTextField txtNombre, txtEdad, txtPeso, txtTalla;
    private JButton btnRegistrar, btnMostrar, btnLimpiar;

    private ModeloDatos modeloDatos;

    public VentanaGui() {
        modeloDatos = new ModeloDatos();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        setLayout(null);

        initComponents();
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel("Registro de Personas");
        lblTitulo.setFont(new Font("Monaco", Font.BOLD, 20));
        lblTitulo.setBounds(150, 10, 250, 30);
        add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 80, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 150, 25);
        add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(30, 100, 80, 25);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(120, 100, 150, 25);
        add(txtEdad);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(30, 140, 80, 25);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(120, 140, 150, 25);
        add(txtPeso);

        JLabel lblTalla = new JLabel("Talla (m):");
        lblTalla.setBounds(30, 180, 80, 25);
        add(lblTalla);

        txtTalla = new JTextField();
        txtTalla.setBounds(120, 180, 150, 25);
        add(txtTalla);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(320, 60, 120, 30);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(320, 100, 120, 30);
        btnMostrar.addActionListener(this);
        add(btnMostrar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(320, 140, 120, 30);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRegistrar) {
            registrarPersona();
        } else if(e.getSource() == btnMostrar) {
            mostrarPersonasEnVentanaSecundaria();
        } else if(e.getSource() == btnLimpiar) {
            limpiarCampos();
        }
    }

    private void registrarPersona() {
        try {
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            double talla = Double.parseDouble(txtTalla.getText());

            Persona p = new Persona(nombre, edad, peso, talla);
            modeloDatos.agregarPersona(p);

            JOptionPane.showMessageDialog(this, "Persona registrada exitosamente");
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese datos válidos");
        }
    }

    private void mostrarPersonasEnVentanaSecundaria() {
        JFrame ventanaLista = new JFrame("Lista de Personas");
        ventanaLista.setSize(500, 400);
        ventanaLista.setLocationRelativeTo(this);
        ventanaLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        StringBuilder sb = new StringBuilder();
        for(Persona p : modeloDatos.getListaPersonas()) {
            double imc = p.getPeso() / (p.getTalla() * p.getTalla());
            sb.append("Nombre: ").append(p.getNombre())
                    .append(", Edad: ").append(p.getEdad())
                    .append(", Peso: ").append(p.getPeso())
                    .append(", Talla: ").append(p.getTalla())
                    .append(", IMC: ").append(String.format("%.2f", imc))
                    .append("\n");
        }
        areaTexto.setText(sb.toString());

        JScrollPane scroll = new JScrollPane(areaTexto);
        ventanaLista.add(scroll);

        ventanaLista.setVisible(true);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtTalla.setText("");
    }


}

