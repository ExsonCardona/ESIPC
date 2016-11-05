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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import java.sql.Blob;
import javax.imageio.ImageIO;



/**
 *
 * @author ADMIN
 */
public class Estudiante extends javax.swing.JInternalFrame {
  private TableRowSorter trsFiltro;
    DefaultTableModel model;
    Statement sent;
    Connection conn;
    private TableRowSorter tr;
    
   
    
      void enviar(){
String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
String year = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
String fecha = (year + "/"+  mes +"/" + dia);
txtfecha.setText(fecha);       
   }
      
      public void limpiarEntradas(){
        this.txtcarne.setText(null);
        this.txtnombre.setText(null);
        this.txtfecha.setText(null);
        this.txttelefono.setText(null);
        this.txtdireccion.setText(null);
        this.txtmunicipio.setText(null);
        this.dir.setText(null);
        this.fotografa.setText(null);
        Image foto= getToolkit().createImage(dir.getText());
        foto = foto.getScaledInstance(156, 147, Image.SCALE_DEFAULT);
        fotografa.setIcon(new ImageIcon(foto));
        }
      
      
      //bloquear
  void bloquear(){
    txtid.setEnabled(true);
    txtcarne.setEnabled(false);
    txtnombre.setEnabled(false);
    txttelefono.setEnabled(false);
    txtdireccion.setEnabled(false);
    txtfecha.setEnabled(false); 
    dir.setEnabled(false);
    buscartodo.setEnabled(false);
    txtmunicipio.setEnabled(false);
    cbmunicipio.setEnabled(false);
    jButton2.setEnabled(false);
    jButton1.setEnabled(false);
    jButton4.setEnabled(false);
    jButton3.setEnabled(true);
    jdt.setEnabled(false);
    txtcancelar.setEnabled(false);
    comboFiltro.setEnabled(false);
    fotografa.setEnabled(false);
    jButton5.setEnabled(false);
    jButton5.setEnabled(false);
    
    
    }
  
  //desbloquear
     void desbloquear(){
    txtid.setEnabled(false);
    txtcarne.setEnabled(true);
    txtnombre.setEnabled(true);
    txttelefono.setEnabled(true);
    txtdireccion.setEnabled(true);
    txtfecha.setEnabled(true); 
    dir.setEnabled(true);
    buscartodo.setEnabled(true);
    txtmunicipio.setEnabled(true);
    cbmunicipio.setEnabled(true);
    jButton2.setEnabled(true);
    jButton1.setEnabled(true);
    jButton4.setEnabled(false);
    jButton3.setEnabled(true);
    jdt.setEnabled(true);
    txtcancelar.setEnabled(true);
    comboFiltro.setEnabled(true);
    fotografa.setEnabled(true);
    jButton5.setEnabled(true);
    jButton5.setEnabled(true);
    
    
    }
     
     

    /**
     * Creates new form Estudiante
     */
    public Estudiante() {
       
        initComponents();
        
        this.bloquear();
        this.mostrar();
        txtfecha.setEnabled(false);
        txtid.setVisible(false);
        dir.setEnabled(false);
        
        
          try{
                   
           Statement Sent=cn.createStatement();
           ResultSet rs=Sent.executeQuery("select * from municipio");
           while (rs.next()){
               this.cbmunicipio.addItem(rs.getString("Nombre"));
           }
                        
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
          
          
                  

    }
    
          
          
         public void mostrar()
    {
String[]titulos={"Codigo","Carne","Nombre","Fecha de Nacimiento","Telefono","Direccion","Foto","Municipio"} ;  
        String []registros= new String[8];
        model=new DefaultTableModel(null,titulos);
        String Sql= "call consulta()";
     
       
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next())
             {
                registros[0]=rs.getString("E.id"); 
                registros[1]=rs.getString("E.Carne");
                registros[2]=rs.getString("E.Nombre");  
                registros[3]=rs.getString("E.Fecha_nac");
                registros[4]=rs.getString("E.Telefono");
                registros[5]=rs.getString("E.Direccion");
                registros[6]=rs.getString("E.nomimagen");
                registros[7]=rs.getString("A.Nombre");
                
                 model.addRow(registros);
             } 
             tblestudiante.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Bestudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }    }
         
        
 public void filtro() {
    int columnaABuscar = 0;
        if (comboFiltro.getSelectedItem() == "Carne") {
            columnaABuscar = 1;
        }
        if (comboFiltro.getSelectedItem().toString() == "Nombre") {
            columnaABuscar = 2;
        }
        if (comboFiltro.getSelectedItem() == "Direccion") {
            columnaABuscar = 5;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(buscartodo.getText(), columnaABuscar));
    
    
//el 3 es el numero de columna a filtrar
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        comboFiltro = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jdt = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        buscartodo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtcarne = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbmunicipio = new javax.swing.JComboBox();
        txtmunicipio = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtcancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        dir = new javax.swing.JTextField();
        fotografa = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblestudiante = new javax.swing.JTable();

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Editar);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setForeground(new java.awt.Color(0, 153, 204));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ESTUDIANTES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS"));

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carne", "Nombre", "Direccion" }));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar (1).png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cargar (1).png"))); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buscartodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscartodoActionPerformed(evt);
            }
        });
        buscartodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscartodoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscartodoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscartodoKeyTyped(evt);
            }
        });

        jLabel7.setText("Buscar por: ");

        jLabel1.setText("Carné");

        jLabel2.setText("Nombre");

        jLabel3.setText("Fecha de Nacimiento");

        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefono");

        jLabel5.setText("Direccion");

        jLabel6.setText("Municipio");

        cbmunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmunicipioActionPerformed(evt);
            }
        });

        txtmunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmunicipioActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo (1).png"))); // NOI18N
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar (1).png"))); // NOI18N
        txtcancelar.setText("Cancelar");
        txtcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfecha)
                                    .addComponent(jdt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcarne)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttelefono)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jButton4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cbmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtmunicipio)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
                        .addGap(7, 7, 7))
                    .addComponent(txtcancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtcarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cbmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboFiltro)
                            .addComponent(buscartodo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(6, 6, 6)
                        .addComponent(txtcancelar))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("FOTO"));

        fotografa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cliente2.png"))); // NOI18N
        jButton5.setText("Tomar Foto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BCliente.png"))); // NOI18N
        jButton1.setText("Buscar Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fotografa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fotografa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("REGISTROS"));

        tblestudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        tblestudiante.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblestudiante);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        PreparedStatement ps;
    try {
    ps=cn.prepareCall("call Actualizar(?,?,?,?,?,?,?,?,?)");
    FileInputStream archivofoto;
    ps.setString(1,this.txtid.getText());
    ps.setString(2,this.txtcarne.getText());
    ps.setString(3,this.txtnombre.getText());
    ps.setString(4,this.txtfecha.getText());
    ps.setString(5,this.txttelefono.getText());
    ps.setString(6,this.txtdireccion.getText());
    ps.setString(7,this.txtmunicipio.getText());
    ps.setString(8,this.dir.getText());
    archivofoto =new FileInputStream(dir.getText());
    ps.setBinaryStream(9, archivofoto);

    
      int res=ps.executeUpdate();
      if(res==1){
          JOptionPane.showMessageDialog(rootPane,"Datos editados correctamente");
          mostrar();
      }
      

    } catch (Exception e) {
        System.out.print(e.getMessage());
    }
    this.limpiarEntradas();

        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed

        int fila= tblestudiante.getSelectedRow();
    String cod="";
    cod=tblestudiante.getValueAt(fila, 0).toString();
    if(fila>=0)
    {
        try {
            PreparedStatement ps=cn.prepareCall("{call EliminarEstudiante(?)}");
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

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
    
        
        
        
        this.desbloquear();
        jButton4.setEnabled(true);
        jButton3.setEnabled(false);
        jButton2.setEnabled(false);

        int fila = tblestudiante.getSelectedRow();
if (fila>=0){
   txtid.setText(tblestudiante.getValueAt(fila,0 ).toString());
    txtcarne.setText(tblestudiante.getValueAt(fila, 1).toString());
    txtnombre.setText(tblestudiante.getValueAt(fila, 2).toString());
    txtfecha.setText(tblestudiante.getValueAt(fila, 3).toString());
    txttelefono.setText(tblestudiante.getValueAt(fila, 4).toString());
    txtdireccion.setText(tblestudiante.getValueAt(fila, 5).toString());
    dir.setText(tblestudiante.getValueAt(fila, 6).toString());
    txtmunicipio.setText(tblestudiante.getValueAt(fila, 7).toString());
    
    Image foto= getToolkit().createImage(dir.getText());
    
    
    foto = foto.getScaledInstance(156, 147, Image.SCALE_DEFAULT);
    fotografa.setIcon(new ImageIcon(foto));
    
        // TODO add your handling code here:
    }
        
// TODO add your handling code here:
    }//GEN-LAST:event_EditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de JPEG(*.JPG;*.JPEG)","jpg","jpeg");
        JFileChooser archivo = new JFileChooser ();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        File ruta = new File ("C:\\Users\\ADMIN\\Documents\\GitHub\\ESIPC\\ESI");
        archivo.setCurrentDirectory(ruta);
    int ventana = archivo.showOpenDialog(null);
    if (ventana == JFileChooser.APPROVE_OPTION)
    {
        File file = archivo.getSelectedFile();
        dir.setText(String.valueOf(file));
        
        Image foto= getToolkit().createImage(dir.getText());
        foto = foto.getScaledInstance(156, 147, Image.SCALE_DEFAULT);
        fotografa.setIcon(new ImageIcon(foto));
        
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbmunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmunicipioActionPerformed

        try{

            Statement Sent1=cn.createStatement();
            ResultSet rs1= Sent1.executeQuery("select id from municipio where Nombre= '"+this.cbmunicipio.getSelectedItem()+"'");
            rs1.next();
            this.txtmunicipio.setText(String.valueOf(rs1.getInt("id")));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmunicipioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        PreparedStatement ps;

        enviar();
        
        try{
            ps=cn.prepareCall("call guardarcliente(?,?,?,?,?,?,?,?)");
            FileInputStream archivofoto;
            ps.setString(1,this.txtcarne.getText());
            ps.setString(2,this.txtnombre.getText());
            ps.setString(3,this.txtfecha.getText());
            ps.setString(4,this.txttelefono.getText());
            ps.setString(5,this.txtdireccion.getText());
            ps.setString(6,this.txtmunicipio.getText());
            ps.setString(7, dir.getText());
            archivofoto = new FileInputStream(dir.getText());
            ps.setBinaryStream(8, archivofoto);
            int res=ps.executeUpdate();
            if (res==1){
                JOptionPane.showMessageDialog(rootPane,"Datos Guardados..");
                this.mostrar();
            }

        } catch (SQLException ex){
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.limpiarEntradas();

        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscartodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyPressed

 
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_buscartodoKeyPressed

    private void buscartodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyTyped
        buscartodo.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (buscartodo.getText());
                buscartodo.setText(cadena);
                repaint();
                filtro();
            }
        });
        trsFiltro = new TableRowSorter(tblestudiante.getModel());
        tblestudiante.setRowSorter(trsFiltro);
                                 
        // TODO add your handling code here:
    }//GEN-LAST:event_buscartodoKeyTyped

    private void buscartodoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscartodoKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_buscartodoKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        camara cam = new camara();
       
        cam.run();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void buscartodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscartodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscartodoActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.desbloquear();
        this.limpiarEntradas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtmunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmunicipioActionPerformed

    private void txtcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcancelarActionPerformed

        this.limpiarEntradas();
        this.bloquear();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JTextField buscartodo;
    private javax.swing.JComboBox cbmunicipio;
    private javax.swing.JComboBox comboFiltro;
    private javax.swing.JTextField dir;
    private javax.swing.JLabel fotografa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdt;
    private javax.swing.JTable tblestudiante;
    private javax.swing.JButton txtcancelar;
    private javax.swing.JTextField txtcarne;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmunicipio;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
conectar con=new conectar();
	Connection cn = con.conexion();

}
