package EjemploIMC.VIsta;

import EjemploIMC.Controlador.Coordinador;
import EjemploIMC.Modelo.dto.PersonaDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsularIndividual extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Coordinador miCoordinador;
    private JTextField txtDocumento;
    private JButton btnConsultar;
    private JButton btnCerrar;
    private JTextArea txtAreaResultado;

    public VentanaConsularIndividual() {
        setTitle("Consulta Individual de Persona");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 450, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel lblTitulo = new JLabel("CONSULTA INDIVIDUAL DE PERSONA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblTitulo.setBounds(50, 20, 350, 30);
        lblTitulo.setForeground(Color.ORANGE);
        contentPane.add(lblTitulo);

        Border bordeNaranja = BorderFactory.createLineBorder(Color.ORANGE, 2);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(50, 70, 100, 25);
        contentPane.add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(160, 70, 200, 25);
        txtDocumento.setBackground(Color.darkGray);
        txtDocumento.setForeground(Color.ORANGE);
        txtDocumento.setBorder(bordeNaranja);
        contentPane.add(txtDocumento);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(160, 110, 100, 30);
        btnConsultar.addActionListener(this);
        btnConsultar.setBackground(Color.ORANGE);
        btnConsultar.setForeground(Color.BLACK);
        btnConsultar.setBorder(bordeNaranja);
        contentPane.add(btnConsultar);

        txtAreaResultado = new JTextArea();
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setBackground(Color.darkGray);
        txtAreaResultado.setForeground(Color.ORANGE);
        txtAreaResultado.setBorder(bordeNaranja);
        txtAreaResultado.setLineWrap(true);
        txtAreaResultado.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setBounds(50, 160, 350, 150);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(175, 330, 100, 30);
        btnCerrar.addActionListener(this);
        btnCerrar.setForeground(Color.BLACK);
        btnCerrar.setBackground(Color.ORANGE);
        btnCerrar.setBorder(bordeNaranja);
        contentPane.add(btnCerrar);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    private void consultarPersona() {
        String documento = txtDocumento.getText().trim();

        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un documento");
            return;
        }

        PersonaDTO persona = miCoordinador.consultarPersona(documento);

        if (persona != null) {
            String resultado = "DATOS DE LA PERSONA:\n\n" +
                    "Documento: " + persona.getDocumento() + "\n" +
                    "Nombre: " + persona.getNombre() + "\n" +
                    "Edad: " + persona.getEdad() + " años\n" +
                    "Peso: " + persona.getPeso() + " kg\n" +
                    "Altura: " + persona.getAltura() + " m\n" +
                    "IMC: " + String.format("%.2f", persona.getImc()) + "\n" +
                    "Clasificación: " + persona.getClasificacion();

            txtAreaResultado.setText(resultado);
        } else {
            txtAreaResultado.setText("No se encontró ninguna persona con el documento: " + documento);
        }
    }

    private void limpiarCampos() {
        txtDocumento.setText("");
        txtAreaResultado.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConsultar) {
            consultarPersona();
        } else if (e.getSource() == btnCerrar) {
            limpiarCampos();
            this.setVisible(false);
        }
    }
}