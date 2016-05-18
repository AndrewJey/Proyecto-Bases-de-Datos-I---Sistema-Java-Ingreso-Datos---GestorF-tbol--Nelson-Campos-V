import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class frmInsertarEquipo extends javax.swing.JFrame {


    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    DefaultTableModel temp;
    Statement s;
    
    public frmInsertarEquipo() {
        initComponents();
        this.setTitle("Insertar Equipo");
        this.setLocationRelativeTo(null);
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/equipo.png"));
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
                ResultSet resultado = st.executeQuery ("SELECT \"NOMBRE\" FROM public.estadio");
                
                while (resultado.next())
                {
                // Comenzamos a rellenar el combobox a partir de la consulta
                txtEstadio.addItem(resultado.getString("NOMBRE"));
                }
                
                
                Statement st2 = cn.createStatement();
                ResultSet resultado2 = st2.executeQuery ("SELECT \"NOMBRE\" FROM public.campeonato");
                
                while (resultado2.next())
                {
                // Comenzamos a rellenar el combobox a partir de la consulta
                txtCampeonato.addItem(resultado2.getString("NOMBRE"));
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

        jToggleButton1 = new javax.swing.JToggleButton();
        txtEstadio = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCampeonato = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Estadio:");

        jLabel4.setText("Campeonato:");

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
                .addGap(0, 676, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addGap(82, 82, 82)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         Conexion();
        String id = txtNombre.getText();
        String url = "jdbc:postgresql://localhost:5432/GestorDeportivo";
        String password = "995511";

        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(url, "postgres", password);
            ps = cn.prepareStatement("SELECT * FROM public.equipo WHERE \"NOMBRE\" =  '" + id + "'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            if (!rs.next()) {
                if (txtNombre.getText().length() == 0 ) {

                    JOptionPane.showMessageDialog(null, "El campo 'Nombre' es requerido");
                } else {
                    try {
                        String nombre = txtNombre.getText();
            Object estadio = txtEstadio.getSelectedItem();
            Object campeonato =  txtCampeonato.getSelectedItem();
                        s = cn.createStatement();
                        int z = s.executeUpdate("INSERT INTO public.equipo(\"NOMBRE\",\"ESTADIO\", \"CAMPEONATO\")VALUES  ('"+nombre+"','"+estadio+"','"+campeonato+"')");
                        if (z == 1) {
                            JOptionPane.showMessageDialog(null, "El Equipo ingresado fué registrado correctamente.");
                            txtNombre.setText(null);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado a la hora de guardar.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: El nombre del equipo ingresado ya está registrado, intente nuevamente con otro nombre.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(frmInsertarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInsertarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInsertarEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox<String> txtCampeonato;
    private javax.swing.JComboBox<String> txtEstadio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
