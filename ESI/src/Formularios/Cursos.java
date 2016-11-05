/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Conexion.conectar;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ADMIN
 */
public class Cursos extends javax.swing.JInternalFrame {
    private TableRowSorter trsFiltro;
   //Variables
    DefaultTableModel model;
    
 //fecha   
void enviar(){
    
            String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
            String year = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
            String fecha = (year + "/"+  mes +"/" + dia);
            txtinicio.setText(fecha);

}
void enviarr(){
    
            String dia = Integer.toString(jdt1.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(jdt1.getCalendar().get(Calendar.MONTH) + 1);
            String year = Integer.toString(jdt1.getCalendar().get(Calendar.YEAR));
            String fecha = (year + "/"+  mes +"/" + dia);
            txtfin.setText(fecha);

}

//Limpiar todos lo campos
public void limpiarEntradas(){
        this.txtcodigo.setText(null);
        this.txtcurso.setText(null);
        this.txtmensual.setText(null);
        this.txttotal.setText(null);
        this.txthorario.setText(null);
        this.txtinicio.setText(null);
        this.txtfin.setText(null);
        this.txtmunicipio.setText(null);
        }

//bloquear
  void bloquear(){
    txtcodigo.setEnabled(false);
    txtcurso.setEnabled(false);
    txtmensual.setEnabled(false);
    txttotal.setEnabled(false);
    txthorario.setEnabled(false);
    
    txtinicio.setEnabled(false);
    txtfin.setEnabled(false);
    txtmunicipio.setEnabled(false);
    cbmunicipio.setEnabled(false);
    btnguardar.setEnabled(false);
    jButton1.setEnabled(false);
    jButton2.setEnabled(true);
    btncancelar.setEnabled(false);
    jdt.setEnabled(false);
    jdt1.setEnabled(false);
    
    }
  
  //desbloquear
      void desbloquear(){
    txtcodigo.setEnabled(true);
    txtcurso.setEnabled(true);
    txtmensual.setEnabled(true);
    txttotal.setEnabled(true);
    txthorario.setEnabled(true);
    txtinicio.setEnabled(true);
     txtfin.setEnabled(true);
     txtmunicipio.setEnabled(true);
    cbmunicipio.setEnabled(true);
    btnguardar.setEnabled(false);
    jButton1.setEnabled(false);
    jButton2.setEnabled(true);
    btncancelar.setEnabled(true);
    jdt.setEnabled(true);
    jdt1.setEnabled(true);
    }
      
      
      public void filtro() {
    int columnaABuscar = 0;
        if (comboFiltro.getSelectedItem() == "Codigo") {
            columnaABuscar = 0;
        }
        if (comboFiltro.getSelectedItem().toString() == "Curso") {
            columnaABuscar = 1;
        }
        if (comboFiltro.getSelectedItem() == "Instructor") {
            columnaABuscar = 7;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(buscartodo.getText(), columnaABuscar));
    
    
//el 3 es el numero de columna a filtrar
    }







    /**
     * Creates new form Cursos
     */
    public Cursos() {
        initComponents();
        this.mostrar();
        this.bloquear();
        
        try{
                   
           Statement Sent=cn.createStatement();
           ResultSet rs=Sent.executeQuery("select * from instructor");
           while (rs.next()){
               this.cbmunicipio.addItem(rs.getString("Nombre"));
           }
                        
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    //Mostrar datos en la tabla
public void mostrar()
    {
String[]titulos={"Codigo","Curso","Costo Mensual","Costo Total","Horario","Inicio","Final","Instructor"} ;  
        String []registros= new String[8];
        model=new DefaultTableModel(null,titulos);
        String Sql= "call consultar_curso()";
     
       
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next())
             {
                registros[0]=rs.getString("C.Codigo"); 
                registros[1]=rs.getString("C.Curso");
                registros[2]=rs.getString("C.Costo_mensual");  
                registros[3]=rs.getString("C.Costo_total");
                registros[4]=rs.getString("C.Horario");
                registros[5]=rs.getString("C.Fecha_inicio");
                registros[6]=rs.getString("C.Fecha_final");
                registros[7]=rs.getString("I.Nombre");
                
                 model.addRow(registros);
             } 
             tblcursos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Bestudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcurso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtmensual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txthorario = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbmunicipio = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtmunicipio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdt = new com.toedter.calendar.JDateChooser();
        txtinicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jdt1 = new com.toedter.calendar.JDateChooser();
        txtfin = new javax.swing.JTextField();
        btncancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox();
        buscartodo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcursos = new javax.swing.JTable();

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Editar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("CURSOS"));

        jLabel1.setText("Codigo");

        jLabel2.setText("Curso");

        jLabel3.setText("Costo Mensual");

        jLabel4.setText("Costo Total");

        jLabel5.setText("Horario");

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar (1).png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cargar (1).png"))); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevoo (1).png"))); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbmunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmunicipioActionPerformed(evt);
            }
        });

        jLabel7.setText("Instructor");

        txtmunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmunicipioActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha de Inicio");

        jLabel8.setText("Fecha de Finalizacion");

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar (1).png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("Buscar por:");

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Curso", "Instructor" }));

        buscartodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscartodoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcurso, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txthorario))
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3)
                        .addGap(57, 57, 57)
                        .addComponent(txtmensual, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfin)
                                    .addComponent(jdt1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(btnguardar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(16, 16, 16)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtmensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txthorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdt1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(cbmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(txtfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btncancelar)))))
                            .addComponent(jLabel8))))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("INFORMACION"));

        tblcursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblcursos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblcursos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        PreparedStatement ps;

        enviar();
        enviarr();
        
        try{
            ps=cn.prepareCall("call guardarcurso(?,?,?,?,?,?,?,?)");
           
            ps.setString(1,this.txtcodigo.getText());
            ps.setString(2,this.txtcurso.getText());
            ps.setString(3,this.txtmensual.getText());
            ps.setString(4,this.txttotal.getText());
            ps.setString(5,this.txthorario.getText());
            ps.setString(6,this.txtinicio.getText());
            ps.setString(7,this.txtfin.getText());
            ps.setString(8,this.txtmunicipio.getText());
                 int res=ps.executeUpdate();
       if (res==1){
                JOptionPane.showMessageDialog(rootPane,"Datos Guardados..");
                
            }

        } catch (SQLException ex){
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.mostrar();
        // TODO add your handling code here:
        this.limpiarEntradas();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void cbmunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmunicipioActionPerformed

        try{

            Statement Sent1=cn.createStatement();
            ResultSet rs1= Sent1.executeQuery("select id from instructor where Nombre= '"+this.cbmunicipio.getSelectedItem()+"'");
            rs1.next();
            this.txtmunicipio.setText(String.valueOf(rs1.getInt("id")));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmunicipioActionPerformed

    private void txtmunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmunicipioActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
//Editar datos
        this.desbloquear();
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
          int fila = tblcursos.getSelectedRow();
if (fila>=0){
   txtcodigo.setText(tblcursos.getValueAt(fila,0 ).toString());
    txtcurso.setText(tblcursos.getValueAt(fila, 1).toString());
    txtmensual.setText(tblcursos.getValueAt(fila, 2).toString());
    txttotal.setText(tblcursos.getValueAt(fila, 3).toString());
    txthorario.setText(tblcursos.getValueAt(fila, 4).toString());
    txtinicio.setText(tblcursos.getValueAt(fila, 5).toString());
    txtfin.setText(tblcursos.getValueAt(fila, 6).toString());
    txtmunicipio.setText(tblcursos.getValueAt(fila, 7).toString());
    
        // TODO add your handling code here:
    }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        
        
        int fila= tblcursos.getSelectedRow();
    String cod="";
    cod=tblcursos.getValueAt(fila, 0).toString();
    if(fila>=0)
    {
        try {
            PreparedStatement ps=cn.prepareCall("{call EliminarCurso(?)}");
            ps.setString(1, cod);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        {
            JOptionPane.showMessageDialog(rootPane,"Dato eliminado");
            mostrar();
        }
        
    }
    else
    {
        JOptionPane.showMessageDialog(this, "No ha selecionada ninguna fila");
    }
        
// TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        PreparedStatement ps;
    try {
    ps=cn.prepareCall("call Actualizar_Curso(?,?,?,?,?,?,?,?)");
    
    ps.setString(1,this.txtcodigo.getText());
    ps.setString(2,this.txtcurso.getText());
    ps.setString(3,this.txtmensual.getText());
    ps.setString(4,this.txttotal.getText());
    ps.setString(5,this.txthorario.getText());
    ps.setString(6,this.txtinicio.getText());
    ps.setString(7,this.txtfin.getText());
    ps.setString(8,this.txtmunicipio.getText());


    
      int res=ps.executeUpdate();
      if(res==1){
          JOptionPane.showMessageDialog(rootPane,"Datos editados correctamente");
          mostrar();
          this.bloquear();
      }
      

    } catch (Exception e) {
        System.out.print(e.getMessage());
    }
this.limpiarEntradas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.desbloquear();
        btnguardar.setEnabled(true);
        this.limpiarEntradas();
        txtcodigo.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

        this.bloquear();
        
// TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed

    private void buscartodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyTyped
 buscartodo.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (buscartodo.getText());
                buscartodo.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(tblcursos.getModel());
        tblcursos.setRowSorter(trsFiltro);
        

// TODO add your handling code here:
    }//GEN-LAST:event_buscartodoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JTextField buscartodo;
    private javax.swing.JComboBox cbmunicipio;
    private javax.swing.JComboBox comboFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdt;
    private com.toedter.calendar.JDateChooser jdt1;
    private javax.swing.JTable tblcursos;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcurso;
    private javax.swing.JTextField txtfin;
    private javax.swing.JTextField txthorario;
    private javax.swing.JTextField txtinicio;
    private javax.swing.JTextField txtmensual;
    private javax.swing.JTextField txtmunicipio;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
conectar con=new conectar();
	Connection cn = con.conexion();

}
