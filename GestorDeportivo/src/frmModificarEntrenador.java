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
public class frmModificarEntrenador extends javax.swing.JFrame {

Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    DefaultTableModel temp;
    Statement s;
    
    public frmModificarEntrenador() {
        initComponents();
        this.setTitle("Modificar Entrenador");
        this.setLocationRelativeTo(null);
        Mostrar();
        MostrarTodo();
        txtId.setText("Entrenador");
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/pic1.jpg"));
        JLabel fondo= new JLabel(); fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),u­no.getIconHeight());
    }

public void Mostrar() {
        
        if (cn != null) {
            return;
        }

        String url = "jdbc:postgresql://localhost:5432/GestorDeportivo";
        String password = "995511";
        try {
            Class.forName("org.postgresql.Driver");

            cn = DriverManager.getConnection(url, "postgres", password);

            if (cn != null) {

                Statement st2 = cn.createStatement();
                ResultSet resultado2 = st2.executeQuery("SELECT \"ID\" FROM public.entrenador");

                while (resultado2.next()) {
                    // Comenzamos a rellenar el combobox a partir de la consulta
                    txtEstadio.addItem(resultado2.getString("ID"));
                }
                
                Statement st = cn.createStatement();
                ResultSet resultado = st.executeQuery ("SELECT \"NOMBRE\" FROM public.equipo;");
                
                while (resultado.next())
                {
                // Comenzamos a rellenar el combobox a partir de la consulta
                txtEquipo.addItem(resultado.getString("NOMBRE"));
                }

            }

        } catch (Exception e) {
            System.out.println("Problemas al conectar a BD");
        }
    }
    public void MostrarTodo() {
        limpiaTabla();
        Object nombre = txtEstadio.getSelectedItem();
        Object estados = txtEstado2.getSelectedItem();

        String url = "jdbc:postgresql://localhost:5432/GestorDeportivo";
        String password = "995511";
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(url, "postgres", password);
            ps = cn.prepareStatement("SELECT \"ID\", \"NOMBRE\", \"APELLIDOS\", \"EDAD\", \"PAIS\", \"TELEFONO\", \"CORREO\", \"EQUIPO\", \"ESTADO\" FROM public.entrenador WHERE  \"ESTADO\" = '" + estados + "'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) this.tbCampeonato.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    void limpiaTabla() {
        try {
            temp = (DefaultTableModel) tbCampeonato.getModel();
            int a = temp.getRowCount() - 0;
            for (int i = 0; i < a; i++) {
                temp.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Principal(){
        limpiaTabla();
        Object nombre = txtEstadio.getSelectedItem();
        Object estados = txtEstado2.getSelectedItem();

        String url = "jdbc:postgresql://localhost:5432/GestorDeportivo";
        String password = "995511";
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(url, "postgres", password);
            ps = cn.prepareStatement("SELECT \"ID\", \"NOMBRE\", \"APELLIDOS\", \"EDAD\", \"PAIS\", \"TELEFONO\", \"CORREO\", \"EQUIPO\", \"ESTADO\" FROM public.entrenador WHERE \"ID\" = '" + nombre + "' AND  \"ESTADO\" = '" + estados + "'");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) this.tbCampeonato.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel8 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtEstadio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCampeonato = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtId = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtEquipo = new javax.swing.JComboBox<>();
        txtEstado = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        est = new javax.swing.JLabel();
        txtEstado2 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        jMenuItem1.setText("Modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jLabel8.setText("ID:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Entrenador:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrenador"));
        jPanel3.setToolTipText("Estadio");

        tbCampeonato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDOS", "EDAD", "PAIS", "TELEFONO", "CORREO", "EQUIPO", "ESTADO"
            }
        ));
        tbCampeonato.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbCampeonato);

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("ID:");

        jLabel5.setText("Nombre:");

        jLabel6.setText("Apellidos:");

        jLabel11.setText("Teléfono:");

        jLabel12.setText("Pais:");

        jLabel13.setText("Edad:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisActionPerformed(evt);
            }
        });

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });

        jLabel18.setText("Equipo:");

        jLabel19.setText("Correo:");

        jLabel17.setText("Estado:");

        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Desempleado" }));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        est.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(est, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addComponent(txtEquipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtId)
                            .addComponent(est))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txtEstado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Desempleado" }));
        txtEstado2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtEstado2ItemStateChanged(evt);
            }
        });

        jLabel22.setText("Estado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 763, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEstadio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        Principal();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        int fila = tbCampeonato.getSelectedRow();
        if (fila>=0) {
            txtId.setText(tbCampeonato.getValueAt(fila, 0).toString());
            txtNombre.setText(tbCampeonato.getValueAt(fila, 1).toString());
            txtApellidos.setText(tbCampeonato.getValueAt(fila, 2).toString());
            txtEdad.setText(tbCampeonato.getValueAt(fila, 3).toString());
            txtPais.setText(tbCampeonato.getValueAt(fila, 4).toString());
            txtTelefono.setText(tbCampeonato.getValueAt(fila, 5).toString());
            txtCorreo.setText(tbCampeonato.getValueAt(fila, 6).toString());
            txtEquipo.setSelectedItem(tbCampeonato.getValueAt(fila, 7).toString());
            txtEstado.setSelectedItem(tbCampeonato.getValueAt(fila, 8).toString());
            est.setText(tbCampeonato.getValueAt(fila, 8).toString());
        }
        else  {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed
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
    private void txtPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisActionPerformed
public void Guardar() {
    
    try {
            PreparedStatement pat = cn.prepareStatement("UPDATE public.entrenador SET \"ID\"='" + txtId.getText() + "', \"NOMBRE\"='" + txtNombre.getText() + "', \"APELLIDOS\"='" + txtApellidos.getText() + "', \"EDAD\"='" + txtEdad.getText() + "', \"PAIS\"='" + txtPais.getText() + "', \"TELEFONO\"='" + txtTelefono.getText() + "', \"CORREO\"='" + txtCorreo.getText() + "', \"EQUIPO\"='" + txtEquipo.getSelectedItem() + "', \"ESTADO\"='" + txtEstado.getSelectedItem() + "' WHERE \"ID\" ='" + txtId.getText() + "' ");
            pat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos fueron modificados correctamente.");
            txtId.setText("Entrenador");
                txtNombre.setText(null);
                txtApellidos.setText(null);
                txtEdad.setText(null);
                txtPais.setText(null);
                txtTelefono.setText(null);
                txtCorreo.setText(null);
            limpiaTabla();
            Mostrar();
            MostrarTodo();
            

        } catch (SQLException ex) {
            Logger.getLogger(frmModificarEstadio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
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
                if (rs.next()) {
                    
                    String cadena1 = "Empleado";
                    String cadena12 = est.getText();
                    if(cadena12 == null ? cadena1 != null : !cadena12.equals(cadena1)){
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
                    }
                    else{
                       Guardar();
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Error: El ID del entrenador ingresado No está registrado, intente nuevamente con otro ID.");
                }

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtEstado2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtEstado2ItemStateChanged
        MostrarTodo();
    }//GEN-LAST:event_txtEstado2ItemStateChanged

    private void txtEdadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyPressed
char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Error: Este campo unicamente permite el ingres de NÚMEROS");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Error: Este campo unicamente permite el ingres de NÚMEROS");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
char car = evt.getKeyChar();
        if( txtEdad.getText().length()>=8 ) evt.consume();
        if(( car<'0' || car>'9' )) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
char car = evt.getKeyChar();
        if( txtTelefono.getText().length()>=8 ) evt.consume();
        if(( car<'0' || car>'9' )) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(frmModificarEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmModificarEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmModificarEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmModificarEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmModificarEntrenador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel est;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCampeonato;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JComboBox<String> txtEquipo;
    private javax.swing.JComboBox<String> txtEstadio;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JComboBox<String> txtEstado2;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
