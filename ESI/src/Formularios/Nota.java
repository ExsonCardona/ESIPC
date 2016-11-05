/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;
import Conexion.conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.Calendar;
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
        this.setLocation(25,15 );
        
        
         bloquear();
         cargar("");
         Combo();
         desbloquear();
     
   
    }
    
    private void bloquear(){
    Textcarne.setEnabled(false);
    Textcurso.setEnabled(false);
    jdt.setEnabled(false);
    textvNota.setEnabled(false);
   textFinal.setEnabled(false);
    txtnombre.setEnabled(true);
    Btnguardar.setEnabled(false);
    Btnnuevo.setEnabled(false);
  
    
    }
    
    void limpiar(){
    Textcarne.setText("");
    Textcurso.setText("");
    textvNota.setText("");
    textFinal.setText("");
    txtnombre.setText("");
    jdt.setDate(null);
    
   }
    
    void insertar()     {
        PreparedStatement ps;
try{
    ps=cn.prepareCall("call InsertNota(?,?,?,?,?,?)");
    ps.setDate(1, (java.sql.Date) this.jdt.getDate());
    ps.setString(2,this.parc.getSelectedItem().toString());
    ps.setString(3,this.textvNota.getText());
    ps.setString(4,this.textFinal.getText());
    ps.setString(5,this.Textcarne.getText());
    ps.setString(6,this.Textcurso.getText());
    ps.executeUpdate();
    
  
}catch (Exception e){
    System.out.print(e.getMessage());
    
}
        
        

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
    jdt.setEnabled(true);
    textvNota.setEnabled(true);
   textFinal.setEnabled(true);
    
    Btnguardar.setEnabled(true);
    Btnnuevo.setEnabled(true);
      
    }
     
        void cargar (String valor) { 
            String [] titulos={"Carne","Curso","Fecha Parcial","Parcial","Nota","Nota Final"};
            String []registros= new String[8];
             model=new DefaultTableModel(null,titulos);
             String Sql= "call consulNota()";
            
            try {    
           Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next())
             {
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnmodificar = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Textcarne = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        parc = new javax.swing.JComboBox();
        textvNota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textFinal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jdt = new com.toedter.calendar.JDateChooser();
        Textcurso = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Btnnuevo = new javax.swing.JButton();
        Btnguardar = new javax.swing.JButton();
        Btnnuevo1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Textbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbNotes = new javax.swing.JTable();

        mnmodificar.setText("Modificar");
        mnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnmodificar);

        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setForeground(new java.awt.Color(204, 204, 255));
        setIconifiable(true);
        setMaximizable(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 14))); // NOI18N

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

        jdt.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(parc, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textvNota, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel8)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Textcurso, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Textcarne, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Textcarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Textcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
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
                    .addComponent(textFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 14))); // NOI18N

        Btnnuevo.setBackground(new java.awt.Color(51, 51, 255));
        Btnnuevo.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo (1).png"))); // NOI18N
        Btnnuevo.setText("Nuevo");
        Btnnuevo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo (2).png"))); // NOI18N
        Btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnnuevoActionPerformed(evt);
            }
        });

        Btnguardar.setBackground(new java.awt.Color(51, 51, 255));
        Btnguardar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar (1).png"))); // NOI18N
        Btnguardar.setText("Guardar");
        Btnguardar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar (2).png"))); // NOI18N
        Btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnguardarActionPerformed(evt);
            }
        });

        Btnnuevo1.setBackground(new java.awt.Color(51, 51, 255));
        Btnnuevo1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        Btnnuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BBoletas.png"))); // NOI18N
        Btnnuevo1.setText("Buscar");
        Btnnuevo1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BCliente.png"))); // NOI18N
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
                    .addComponent(Btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnnuevo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btnnuevo1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jLabel4.setText("Buscar");

        Textbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextbuscarActionPerformed(evt);
            }
        });
        Textbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextbuscarKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel1.setText("Notas");

        TbNotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        TbNotes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(TbNotes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Textbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Textbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        // TODO add your handling code here:cargar("");
        cargar("");
    }//GEN-LAST:event_TextbuscarActionPerformed

    
     void enviar(){
String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
String year = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
String fecha = (year + "/"+  mes +"/" + dia);
txtfecha.setText(fecha);      
   }
    
    private void BtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnguardarActionPerformed
        // TODO add your handling code here:
          PreparedStatement ps;
    enviar();      
try{
    ps=cn.prepareCall("call InsertNota(?,?,?,?,?,?)");
    ps.setString(1, this.txtfecha.getText());
    ps.setString(2,this.parc.getSelectedItem().toString());
    ps.setString(3,this.textvNota.getText());
    ps.setString(4,this.textFinal.getText());
    ps.setString(5,this.Textcarne.getText());
    ps.setString(6,this.Textcurso.getText());
    ps.executeUpdate();
  cargar("");  
  
}catch (Exception e){
    System.out.print(e.getMessage());
    
    } 
    }//GEN-LAST:event_BtnguardarActionPerformed

    private void BtnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnnuevoActionPerformed
        // TODO add your handling code here:
        
      desbloquear();
      Btnguardar.setEnabled(true);
     limpiar();
    }//GEN-LAST:event_BtnnuevoActionPerformed

    private void TextbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextbuscarKeyReleased
cargar(Textbuscar.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_TextbuscarKeyReleased

    private void mnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnmodificarActionPerformed
        // TODO add your handling code here:
         int fila = TbNotes.getSelectedRow();
       if (fila>=0){
   Textcurso.setText(TbNotes.getValueAt(fila,0 ).toString());
   txtfecha.setText(TbNotes.getValueAt(fila, 1).toString());
   txtnombre.setText(TbNotes.getValueAt(fila, 2).toString());
   txtfecha.setText(TbNotes.getValueAt(fila, 3).toString());
   textvNota.setText(TbNotes.getValueAt(fila, 4).toString());
   textFinal.setText(TbNotes.getValueAt(fila, 5).toString());
   
    }//GEN-LAST:event_mnmodificarActionPerformed
  }    
    private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
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

    }//GEN-LAST:event_mneliminarActionPerformed

    private void Btnnuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnnuevo1ActionPerformed
        // TODO add your handling code here:
        Bnota nota = new Bnota();
        Menu.jDesktopPane1.add(nota);
        nota.toFront();
        nota.setVisible(true);        // TODO add your handling code here:

    }//GEN-LAST:event_Btnnuevo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnguardar;
    private javax.swing.JButton Btnnuevo;
    private javax.swing.JButton Btnnuevo1;
    private javax.swing.JTable TbNotes;
    private javax.swing.JTextField Textbuscar;
    public static javax.swing.JTextField Textcarne;
    public static javax.swing.JTextField Textcurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdt;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnmodificar;
    private javax.swing.JComboBox parc;
    private javax.swing.JTextField textFinal;
    private javax.swing.JTextField textvNota;
    private javax.swing.JTextField txtfecha;
    public static javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

    conectar cc= new conectar();
   Connection cn=cc.conexion();

 }