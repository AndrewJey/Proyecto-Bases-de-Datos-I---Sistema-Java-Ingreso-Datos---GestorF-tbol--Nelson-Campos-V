import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nelson-PC
 */
public class frmInsertarEntrenador extends javax.swing.JFrame {

Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    DefaultTableModel temp;
    Statement s;
    
    public frmInsertarEntrenador() {
        initComponents();
        this.setTitle("Insertar Entrenador");
        this.setLocationRelativeTo(null);
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/entrenador.png"));
        JLabel fondo= new JLabel(); fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
        Mostrar();
    }
    public void Mostrar(){
        if(cn != null){
        return;
        }
        
        String url = "jdbc:postgresql://localhost:5432/GestorDeportivo";
        String password = "995511";
        try{
            Class.forName("org.postgresql.Driver");
            
            cn = DriverManager.getConnection(url,"postgres", password);
            
            if(cn != null){
            
               Statement st = cn.createStatement();
                ResultSet resultado = st.executeQuery ("SELECT \"NOMBRE\" FROM public.equipo;");
                
                while (resultado.next())
                {
                // Comenzamos a rellenar el combobox a partir de la consulta
                txtEquipo.addItem(resultado.getString("NOMBRE"));
                }
            }
            
        }catch (Exception e){
            System.out.println("Problemas al conectar a BD");
        }
        }
    public void Conexion(){
        if(cn != null){
        return;
        }
        
        String url = "jdbc:postgresql://localhost:5432/GestorDeportivo";
        String password = "995511";
        try{
            Class.forName("org.postgresql.Driver");
            
            cn = DriverManager.getConnection(url,"postgres", password);
            
            if(cn != null){
            System.out.println("Conectado a BD");
            }
            
        }catch (Exception e){
            System.out.println("Problemas al conectar a BD");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtEquipo = new javax.swing.JComboBox<>();
        txtEstado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel1.setText("Cédula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellidos:");

        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        jLabel4.setText("Edad:");

        jLabel5.setText("Pais:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel6.setText("Teléfono:");

        jLabel7.setText("Correo:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Desempleado" }));

        jLabel9.setText("Estado:");

        jLabel8.setText("Equipo:");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(btnGuardar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(9, 9, 9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEquipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEstado, 0, 178, Short.MAX_VALUE)
                                    .addComponent(txtCorreo)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtPais)
                                    .addComponent(txtEdad)
                                    .addComponent(txtApellidos)
                                    .addComponent(txtNombre)
                                    .addComponent(txtId))))
                        .addGap(578, 578, 578)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Guardar() {
        Conexion();
        try {
            String cedula = txtId.getText();
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String edad = txtEdad.getText();
            String pais = txtPais.getText();
            String telefono = txtTelefono.getText();
            String correo = txtCorreo.getText();
            Object equipo = txtEquipo.getSelectedItem();
            Object estados = txtEstado.getSelectedItem();

            s = cn.createStatement();
            int z = s.executeUpdate("INSERT INTO public.entrenador(\"ID\", \"NOMBRE\", \"APELLIDOS\", \"EDAD\", \"PAIS\", \"TELEFONO\", \"CORREO\", \"EQUIPO\", \"ESTADO\") VALUES ('" + cedula + "','" + nombre + "','" + apellidos + "','" + edad + "','" + pais + "','" + telefono + "','" + correo + "','" + equipo + "','" + estados + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "El Entrenador ingresado fué registrado correctamente.");
                txtId.setText(null);
                txtNombre.setText(null);
                txtApellidos.setText(null);
                txtEdad.setText(null);
                txtPais.setText(null);
                txtTelefono.setText(null);
                txtCorreo.setText(null);

            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado a la hora de guardar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos.");
        }
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtId.getText().length() == 0 || txtNombre.getText().length() == 0 || txtApellidos.getText().length() == 0 || txtEdad.getText().length() == 0 || txtPais.getText().length() == 0 || txtTelefono.getText().length() == 0 || txtCorreo.getText().length() == 0 || txtEquipo.getSelectedItem() == "" || txtEstado.getSelectedItem() == "") {

            JOptionPane.showMessageDialog(null, "Error: Todos los campos son requeridos");
        } else {
            Conexion();
            String id = txtId.getText();
            Object estado = txtEstado.getSelectedItem();
            Object equipo = txtEquipo.getSelectedItem();
            String url = "jdbc:postgresql://localhost:5432/GestorDeportivo";
            String password = "995511";

            try {
                Class.forName("org.postgresql.Driver");
                cn = DriverManager.getConnection(url, "postgres", password);
                ps = cn.prepareStatement("SELECT * FROM public.entrenador WHERE \"ID\" =  '" + id + "'");
                rs = ps.executeQuery();
                rsm = rs.getMetaData();
                if (!rs.next()) {
                    ps = cn.prepareStatement("SELECT * FROM public.entrenador WHERE \"EQUIPO\" =  '" + equipo + "' AND \"ESTADO\" =  'Empleado'");
                    rs = ps.executeQuery();
                    rsm = rs.getMetaData();
                    if (estado == "Empleado" && rs.next()) {
                        ps = cn.prepareStatement("SELECT * FROM public.entrenador WHERE \"ESTADO\" =  '" + estado + "'");
                        rs = ps.executeQuery();
                        rsm = rs.getMetaData();
                        if (!rs.next()) {
                        Guardar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: Este equipo ya tiene un entrenador en estado empleado, debe de desemplear el entrenador de este equipo antes de emplear un nuevo entrenador.");
                        }
                    } else {
                        Guardar();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error: El ID del entrenador ingresado ya está registrado, intente nuevamente con otro ID.");
                }

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Error: Este campo unicamente permite el ingres de NÚMEROS");
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        char car = evt.getKeyChar();
        if( txtId.getText().length()>=8 ) evt.consume();
        if(( car<'0' || car>'9' )) evt.consume();
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Error: Este campo unicamente permite el ingres de NÚMEROS");
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char car = evt.getKeyChar();
        if( txtTelefono.getText().length()>=8 ) evt.consume();
        if(( car<'0' || car>'9' )) evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtEdadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Error: Este campo unicamente permite el ingres de NÚMEROS");
        }
    }//GEN-LAST:event_txtEdadKeyPressed

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        char car = evt.getKeyChar();
        if( txtEdad.getText().length()>=8 ) evt.consume();
        if(( car<'0' || car>'9' )) evt.consume();
    }//GEN-LAST:event_txtEdadKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInsertarEntrenador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JComboBox<String> txtEquipo;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
