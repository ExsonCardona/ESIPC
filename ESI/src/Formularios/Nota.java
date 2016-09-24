/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
import Conect.conectar;
import static Form.menu.Loca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author Danica
 */

public class Nota extends javax.swing.JInternalFrame {
    
    
    
    DefaultTableModel model ;
    
     

    /**
     * Creates new form Nota
     */
    public Nota() {
        initComponents();
         bloquear();
         cargar("");
         Combo();
         desbloquear();
   
    }
    
    private void bloquear(){
    Textcarne.setEnabled(false);
    Textcurso.setEnabled(false);
    TextFecha.setEnabled(false);
    textvNota.setEnabled(false);
   textFinal.setEnabled(false);
    txtnombre.setEnabled(true);
    Btnguardar.setEnabled(false);
    Btnnuevo.setEnabled(false);
    Btnelim.setEnabled(false);
    Btnactualizar.setEnabled(false);
    
    }
    
    void limpiar(){
    Textcarne.setText("");
    Textcurso.setText("");
    textvNota.setText("");
    textFinal.setText("");
    txtnombre.setText("");
    TextFecha.setDate(null);
    
   }
    
    
    void Combo(){
             
        ResultSet rs;
        String sql= "SELECT * FROM Parcial";
        PreparedStatement sqls = null;
        try {
            sqls = cn.prepareStatement(sql);
         
        
            rs=sqls.executeQuery();
        
        while(rs.next()){
           Nota u = new Nota();
            u.setName(rs.getString("Parcial 1 ,Parcial 2"));
            parc.addItem(u);
}
        
        }catch (SQLException ex) {
           
    }
         }
       
        
        void desbloquear(){
   
    Textcarne.setEnabled(true);
    Textcurso.setEnabled(true);
    TextFecha.setEnabled(true);
    textvNota.setEnabled(true);
   textFinal.setEnabled(true);
    
    Btnguardar.setEnabled(true);
    Btnnuevo.setEnabled(true);
    Btnelim.setEnabled(true);
    Btnactualizar.setEnabled(true);     
    }
     
        void cargar (String valor) { 
            String [] titulos={"Carne","Curso","Fecha Parcial","Parcial","Nota","Nota Final"};
             model=new DefaultTableModel(null,titulos);
            String [] registros= new String[6];
            
                       
            String mostrar="select * from Nota WHERE CONCAT (fecha_Parcial,'',Parcial,'',Nota,'',Nota_Final,'',Curso_Codigo,'',Estudiante_Carne) LIKE '%"+valor+"%'";
            Statement st;
            
            try {    
            st=cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while(rs.next()){
                registros[0]=rs.getString("Estudiante_Carne");
                registros[1]=rs.getString("curso_Codigo");
                registros[2]=rs.getString("fecha_parcial");
                registros[3]=rs.getString("parcial");
                registros[4]=rs.getString("Nota");
                registros[5]=rs.getString("Nota_Final");
                
                
                model.addRow(registros);      
                }
          TbNotes.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Nota.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
        }
        void BuscarNOTAEditar(String cod) {
        
        try{
           
            String car="",curs="",nota="",Nota_Final="";
            String cons="select * from Nota WHERE carne='"+car+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next())
            {
                car=rs.getString("carne");
                curs=rs.getString("curso");
                nota=rs.getString("nota");
                Nota_Final=rs.getString("Nota_Final");
           
            }
            Textcarne.setText(car);
            Textcurso.setText(curs);
            textvNota.setText(nota);
            textFinal.setText(Nota_Final);
           
            }catch(Exception e)
            {
            System.out.println(e.getMessage());
            }
     
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Textbuscar = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbNotes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Textcarne = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Textcurso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        parc = new javax.swing.JComboBox();
        textvNota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textFinal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TextFecha = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        Btnnuevo = new javax.swing.JButton();
        Btnguardar = new javax.swing.JButton();
        Btnactualizar = new javax.swing.JButton();
        Btnelim = new javax.swing.JButton();
        Btnsalir = new javax.swing.JButton();
        Btnnuevo1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        Textbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextbuscarActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 153, 255));
        jButton6.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Buscar.png"))); // NOI18N
        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Yu Mincho Demibold", 1, 18)); // NOI18N
        jLabel1.setText("Notas");

        TbNotes.setForeground(new java.awt.Color(0, 0, 255));
        TbNotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TbNotes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel2.setText("Carne:");

        Textcarne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextcarneActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel8.setText("Curso:");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel3.setText("Fecha_Parcial:");

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel5.setText("Parcial:");

        parc.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        parc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Parcial 1", "Parial 2", "" }));
        parc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parcActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel6.setText("Nota:");

        textFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFinalActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel7.setText("Nota Final:");

        jLabel11.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel11.setText("Estudiante:");

        TextFecha.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Textcarne, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(parc, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textvNota, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Textcurso, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Textcarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(parc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textvNota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Textcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        Btnnuevo.setBackground(new java.awt.Color(153, 153, 255));
        Btnnuevo.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Nuevoo (2).png"))); // NOI18N
        Btnnuevo.setText("Nuevo");
        Btnnuevo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Nuevoo (1).png"))); // NOI18N
        Btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnnuevoActionPerformed(evt);
            }
        });

        Btnguardar.setBackground(new java.awt.Color(153, 153, 255));
        Btnguardar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Guardar (1).png"))); // NOI18N
        Btnguardar.setText("Guardar");
        Btnguardar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Guardar (1).png"))); // NOI18N
        Btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnguardarActionPerformed(evt);
            }
        });

        Btnactualizar.setBackground(new java.awt.Color(153, 153, 255));
        Btnactualizar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Nuevo (1).png"))); // NOI18N
        Btnactualizar.setText("Actualizar");
        Btnactualizar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Nuevo (2).png"))); // NOI18N
        Btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnactualizarActionPerformed(evt);
            }
        });

        Btnelim.setBackground(new java.awt.Color(153, 153, 255));
        Btnelim.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnelim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Cancelar (1).png"))); // NOI18N
        Btnelim.setText("Eliminar");
        Btnelim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnelimActionPerformed(evt);
            }
        });

        Btnsalir.setBackground(new java.awt.Color(153, 153, 255));
        Btnsalir.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/salir (2).png"))); // NOI18N
        Btnsalir.setText("Salir");
        Btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnsalirActionPerformed(evt);
            }
        });

        Btnnuevo1.setBackground(new java.awt.Color(153, 153, 255));
        Btnnuevo1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnnuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/imagenes/Nuevoo (2).png"))); // NOI18N
        Btnnuevo1.setText("Buscar");
        Btnnuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnnuevo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnnuevo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnelim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnnuevo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnelim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(363, 363, 363)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(Textbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6)
                            .addComponent(Textbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parcActionPerformed

    private void TextcarneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextcarneActionPerformed
        // TODO add your handling code here:
        Textcarne.transferFocus();
    }//GEN-LAST:event_TextcarneActionPerformed

    private void textFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFinalActionPerformed
        // TODO add your handling code here:
        textFinal.transferFocus();
    }//GEN-LAST:event_textFinalActionPerformed

    private void TextbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextbuscarActionPerformed
        // TODO add your handling code here:
          
           
        
    }//GEN-LAST:event_TextbuscarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
     
          
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BtnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnsalirActionPerformed
        // TODO add your handling code here:
          this.dispose();
    }//GEN-LAST:event_BtnsalirActionPerformed

    private void BtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnguardarActionPerformed
        // TODO add your handling code here:
      
        PreparedStatement ps;
try{
    ps=cn.prepareCall("call InsertNota(?,?,?,?,?,?)");
     ps.setDate(1, (java.sql.Date) this.TextFecha.getDate());
     ps.setString(2,this.parc.getSelectedItem().toString());
    ps.setString(3,this.textvNota.getText());
    ps.setString(4,this.textFinal.getText());
    ps.setString(5,this.Textcarne.getText());
    ps.setString(6,this.Textcurso.getText());
   
    int res=ps.executeUpdate();
    if (res==1){
        
    }
    
     cargar("");
        bloquear();
}catch (Exception e){
    
    
}
    }//GEN-LAST:event_BtnguardarActionPerformed

    private void BtnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnactualizarActionPerformed
        // TODO add your handling code here:
        
        PreparedStatement ps;
try{
    ps=cn.prepareCall("call updateNota(?,?,?,?,?,?)");
    ps.setDate(1, (java.sql.Date) this.TextFecha.getDate());
    ps.setString(2,this.parc.getSelectedItem().toString());
    ps.setString(3,this.textvNota.getText());
    ps.setString(4,this.textFinal.getText());
    ps.setString(5,this.Textcarne.getText());
    ps.setString(6,this.Textcurso.getText());
    int res=ps.executeUpdate();
    if (res==1){
        
    }
    
     cargar("");
}catch (Exception e){
    
}
        
    }//GEN-LAST:event_BtnactualizarActionPerformed

    private void Btnnuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnnuevo1ActionPerformed
        // TODO add your handling code here:
    Bnota nota = new Bnota();
    menu.Loca.add(nota);
    nota.toFront();
    nota.setVisible(true);        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_Btnnuevo1ActionPerformed

    private void BtnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnnuevoActionPerformed
        // TODO add your handling code here:
        
      desbloquear();
      Btnguardar.setEnabled(true);
     limpiar();
    }//GEN-LAST:event_BtnnuevoActionPerformed

    private void BtnelimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnelimActionPerformed
        // TODO add your handling code here:
         int fila= TbNotes.getSelectedRow();
    String cod="";
    cod=TbNotes.getValueAt(fila, 0).toString();
    if(fila>=0)
    {
        try {
            PreparedStatement ps=cn.prepareCall("{call borrarnota(?)}");
            ps.setString(1, cod);
            ps.executeUpdate();
            cargar("");
        } catch (SQLException ex) {
            Logger.getLogger(Nota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else
    {
        JOptionPane.showMessageDialog(this, "No ha selecionada ninguna fila");
    }
    }//GEN-LAST:event_BtnelimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnactualizar;
    private javax.swing.JButton Btnelim;
    private javax.swing.JButton Btnguardar;
    private javax.swing.JButton Btnnuevo;
    private javax.swing.JButton Btnnuevo1;
    private javax.swing.JButton Btnsalir;
    private javax.swing.JTable TbNotes;
    private com.toedter.calendar.JDateChooser TextFecha;
    private javax.swing.JTextField Textbuscar;
    public static javax.swing.JTextField Textcarne;
    public static javax.swing.JTextField Textcurso;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox parc;
    private javax.swing.JTextField textFinal;
    private javax.swing.JTextField textvNota;
    public static javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

    conectar cc= new conectar();
   Connection cn=cc.conexion();

 }