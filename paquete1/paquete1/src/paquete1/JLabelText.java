package paquete1;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class JLabelText extends JPanel {
    private JLabel etiqueta;
    private JTextArea cajatexto;

    public JLabelText(JLabel etiqueta, JTextArea cajatexto) {
        super();
        this.etiqueta = etiqueta;
        this.cajatexto = cajatexto;

        // Establecer un tamaño fijo para la etiqueta
        Dimension fixedSize = new Dimension(100, 30);
        etiqueta.setPreferredSize(fixedSize);
        etiqueta.setMinimumSize(fixedSize);
        etiqueta.setMaximumSize(fixedSize);

        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        this.setLayout(new BorderLayout());

        this.add(etiqueta, BorderLayout.WEST);

        // Crear un panel para el JTextArea
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(cajatexto, BorderLayout.CENTER); // Posicionar en el centro
        this.add(textPanel, BorderLayout.CENTER); // Agregar el panel al contenedor principal

        this.repaint();
    }

    public JLabelText(String tituloEtiqueta, String mensajeCajaTexto) {
        this(new JLabel(tituloEtiqueta), new JTextArea(mensajeCajaTexto));
    }

    public JLabelText() {
        this("Título", "Ingrese Texto");
    }

    public void setTituloEtiqueta(String Titulo) {
        this.etiqueta.setText(Titulo);
        this.etiqueta.repaint();
    }

    public String getTituloEtiqueta() {
        return this.etiqueta.getText();
    }

    public void setCajaTexto(String Titulo) {
        this.cajatexto.setText(Titulo);
        this.cajatexto.repaint();
    }

    public String getCajaTexto() {
        return this.cajatexto.getText();
    }

    public void setEtiquetaColor(Color color) {
        this.etiqueta.setForeground(color);
        this.etiqueta.repaint();
    }

    public Color getEtiquetaColor() {
        return this.etiqueta.getForeground();
    }

    public void setEtiquetaBackground(Color color) {
        this.etiqueta.setBackground(color);
        this.etiqueta.setOpaque(true);
        this.repaint();
    }

    public Color getEtiquetaBackground() {
        return this.etiqueta.getBackground();
    }

    public void setCajatextoColor(Color color) {
        this.cajatexto.setForeground(color);
        this.cajatexto.repaint();
    }

    public void setCajatextoBackground(Color color) {
        this.cajatexto.setBackground(color);
        this.cajatexto.setOpaque(true);
        this.repaint();
    }

    public Color getCajatextoBackground() {
        return this.cajatexto.getBackground();
    }

    // Métodos adicionales para posicionar el JTextArea
    public void setCajatextoAlignment(int alignment) {
        // Configura el JTextArea según la alineación deseada
        // Puedes usar un layout específico o ajustar propiedades como el margin
    }
}

