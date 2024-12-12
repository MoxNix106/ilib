package com.mycompany.views;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.ilib.DAOBooksImpl;
import com.mycompany.ilib.DAOLendingsImpl;
import com.mycompany.ilib.DAOUsersImpl;
import com.mycompany.interfaces.DAOBooks;
import com.mycompany.interfaces.DAOLendings;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.models.Lendings;
import com.mycompany.utils.Utils;
import java.awt.Color;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class LendingsF extends javax.swing.JPanel {

    public LendingsF() {
        initComponents();
    }

      // Método para generar la factura y enviarla
    // Método para generar un PDF con los detalles del préstamo
    private String generarPDFPrestamo(String usuario, String libro) {
        String rutaCarpeta = "C:\\Semestre 5\\Topicos\\PDF Enviados"; // Ruta para guardar los PDFs
        String fileName = rutaCarpeta + "\\Prestamo_" + usuario + "_" + libro + ".pdf";

        // Crear la carpeta si no existe
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        // Generar el PDF
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // Título
            Paragraph title = new Paragraph("Detalles del Préstamo", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            // Información del préstamo
            document.add(new Paragraph("Usuario: " + usuario));
            document.add(new Paragraph("Libro: " + libro));
            document.add(new Paragraph("Fecha del préstamo: " + java.time.LocalDate.now()));
            document.add(new Paragraph(" "));

            document.close();
            return fileName;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + e.getMessage());
            return null;
        }
    }

    // Método para enviar un correo con un archivo PDF adjunto
    private void enviarCorreoConAdjunto(String emailDestino, String filePath) {
        final String remitente = ""; // Cambia por tu correo
        final String password = ""; // Cambia por tu contraseña o app password

        // Configuración del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Crear sesión de correo
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, password);
            }
        });

        try {
            // Crear mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino));
            message.setSubject("Detalles del Préstamo");

            // Cuerpo del mensaje
            MimeBodyPart mensajeTexto = new MimeBodyPart();
            mensajeTexto.setText("Adjunto encontrará los detalles del préstamo en formato PDF.");

            // Adjuntar el archivo PDF
            MimeBodyPart adjunto = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            adjunto.setDataHandler(new DataHandler(source));
            adjunto.setFileName(new File(filePath).getName());

            // Combinar partes
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mensajeTexto);
            multipart.addBodyPart(adjunto);

            message.setContent(multipart);

            // Enviar el correo
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Correo enviado exitosamente a: " + emailDestino);

        } catch (MessagingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al enviar el correo: " + e.getMessage());
        }
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        libroIdLbl = new javax.swing.JLabel();
        botonBuscarLibros = new javax.swing.JButton();
        button = new javax.swing.JButton();
        ComboUsuarios = new javax.swing.JComboBox<>();
        bucarUsuarios = new javax.swing.JTextField();
        BuscarLibros = new javax.swing.JTextField();
        ComboLibros = new javax.swing.JComboBox<>();
        usuarioslbl = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        libroslbl = new javax.swing.JLabel();
        folioLbl = new javax.swing.JLabel();
        botonBuscarUsuarios = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        libroIdLbl.setText("Nombre Libro");

        botonBuscarLibros.setBackground(new java.awt.Color(18, 90, 173));
        botonBuscarLibros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBuscarLibros.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarLibros.setText("Buscar");
        botonBuscarLibros.setBorderPainted(false);
        botonBuscarLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonBuscarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarLibrosActionPerformed(evt);
            }
        });

        button.setBackground(new java.awt.Color(18, 90, 173));
        button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setText("Prestar");
        button.setBorderPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        ComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboUsuariosActionPerformed(evt);
            }
        });

        ComboLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboLibrosActionPerformed(evt);
            }
        });

        usuarioslbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));

        libroslbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        folioLbl.setText("Nombre Usuario");

        botonBuscarUsuarios.setBackground(new java.awt.Color(18, 90, 173));
        botonBuscarUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBuscarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarUsuarios.setText("Buscar");
        botonBuscarUsuarios.setBorderPainted(false);
        botonBuscarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 293, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BuscarLibros, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ComboUsuarios, javax.swing.GroupLayout.Alignment.LEADING, 0, 313, Short.MAX_VALUE)
                        .addComponent(bucarUsuarios, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ComboLibros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(botonBuscarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonBuscarLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(11, 11, 11)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                            .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(199, 199, 199))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                            .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(223, 223, 223))
                        .addComponent(libroslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usuarioslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(10, 10, 10)))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(usuarioslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(libroslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(138, 138, 138))
                        .addGroup(bgLayout.createSequentialGroup()
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bucarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(ComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BuscarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonBuscarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34)
                            .addComponent(ComboLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(40, 40, 40)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarLibrosActionPerformed
        // TODO add your handling code here:
        String searchQuery = BuscarLibros.getText().trim();
        ComboLibros.removeAllItems();
        try {
            DAOBooks daoBooks = new DAOBooksImpl();
            daoBooks.listar(searchQuery).forEach(book -> ComboLibros.addItem(book.getTitle()));
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al buscar libros: " + e.getMessage());
        }
    }//GEN-LAST:event_botonBuscarLibrosActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
     String selectedUser = (String) ComboUsuarios.getSelectedItem();
        String selectedBook = (String) ComboLibros.getSelectedItem();

        if (selectedUser != null && selectedBook != null) {
            try {
                DAOUsers daoUsers = new DAOUsersImpl();
                DAOBooks daoBooks = new DAOBooksImpl();
                DAOLendings daoLendings = new DAOLendingsImpl();

                // Obtener IDs de usuario y libro
                int userId = daoUsers.getUserIdByName(selectedUser);
                int bookId = daoBooks.getBookIdByTitle(selectedBook);

                // Registrar el préstamo
                Lendings lending = new Lendings();
                lending.setUser_id(userId);
                lending.setBook_id(bookId);
                lending.setDate_out(java.time.LocalDate.now().toString());
                daoLendings.registrar(lending);

                // Generar PDF
                String pdfPath = generarPDFPrestamo(selectedUser, selectedBook);

                // Enviar correo con PDF adjunto
                String emailUsuario = "blum7490@gmail.com"; // Aquí obtendrás el correo del usuario
                enviarCorreoConAdjunto(emailUsuario, pdfPath);

                JOptionPane.showMessageDialog(this, "Préstamo registrado y correo enviado exitosamente.");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al registrar el préstamo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario y un libro.");
        }
    
    }//GEN-LAST:event_buttonActionPerformed

    private void ComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboUsuariosActionPerformed
        // TODO add your handling code here:

        String selectedUser = (String) ComboUsuarios.getSelectedItem();
        if (selectedUser != null) {
            usuarioslbl.setText(selectedUser);
        }

    }//GEN-LAST:event_ComboUsuariosActionPerformed

    private void ComboLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboLibrosActionPerformed
        // TODO add your handling code here:
        String selectedBook = (String) ComboLibros.getSelectedItem();
        if (selectedBook != null) {
            libroslbl.setText(selectedBook);
        }
    }//GEN-LAST:event_ComboLibrosActionPerformed

    private void botonBuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarUsuariosActionPerformed
        String searchQuery = bucarUsuarios.getText().trim();
        ComboUsuarios.removeAllItems();
        try {
            DAOUsers daoUsers = new DAOUsersImpl();
            daoUsers.listar(searchQuery).forEach(user -> ComboUsuarios.addItem(user.getName()));
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al buscar usuarios: " + e.getMessage());
        }
    }//GEN-LAST:event_botonBuscarUsuariosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarLibros;
    private javax.swing.JComboBox<String> ComboLibros;
    private javax.swing.JComboBox<String> ComboUsuarios;
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonBuscarLibros;
    private javax.swing.JButton botonBuscarUsuarios;
    private javax.swing.JTextField bucarUsuarios;
    private javax.swing.JButton button;
    private javax.swing.JLabel folioLbl;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel libroIdLbl;
    private javax.swing.JLabel libroslbl;
    private javax.swing.JLabel usuarioslbl;
    // End of variables declaration//GEN-END:variables
}
