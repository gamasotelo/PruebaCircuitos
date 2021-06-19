
import Tablas.Clase_CellEditor;
import Tablas.Clase_CellRender;
import javax.swing.table.DefaultTableModel;


public class Ventana extends javax.swing.JFrame {

    DefaultTableModel modeloTabla;
    int numeroDeNodos;
    Object[][] datosTabla;
    int columnaNodo = 0, columnaTierra = 1, columnaFuente = 2;
    
    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nodo");
        modeloTabla.addColumn("Conexión a tierra");
        modeloTabla.addColumn("Conexión a fuente");
        tabla.setModel(modeloTabla);
        /*Las siguientes lineas insertan el boton dentro de la tabla
          siempre son iguales getColumn(1) indica en que columna se deben insertar
        */
        tabla.getColumnModel().getColumn(1).setCellEditor(new Clase_CellEditor());
        tabla.getColumnModel().getColumn(1).setCellRenderer(new Clase_CellRender());
        
        tabla.getColumnModel().getColumn(2).setCellEditor(new Clase_CellEditor());
        tabla.getColumnModel().getColumn(2).setCellRenderer(new Clase_CellRender());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumeroDeNodos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bIngresarNumeroNodos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        bSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Número de nodos");

        bIngresarNumeroNodos.setText("Aceptar");
        bIngresarNumeroNodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIngresarNumeroNodosActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumeroDeNodos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(bIngresarNumeroNodos)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bSiguiente)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroDeNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bIngresarNumeroNodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSiguiente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIngresarNumeroNodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIngresarNumeroNodosActionPerformed
        numeroDeNodos = Integer.parseInt(txtNumeroDeNodos.getText());
        
        Object[] nuevoRenglon = new Object[3];
        modeloTabla.setRowCount(0);
        
        for(int i = 0; i < numeroDeNodos; i++){
            nuevoRenglon[0] = String.valueOf(i + 1);
            nuevoRenglon[1] = Boolean.FALSE;
            nuevoRenglon[2] = Boolean.FALSE;
            modeloTabla.addRow(nuevoRenglon);
        }
    }//GEN-LAST:event_bIngresarNumeroNodosActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        leer_tabla();
        this.dispose();
        VentanaConexiones v = new VentanaConexiones(numeroDeNodos, datosTabla);
        v.setVisible(true);
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void leer_tabla(){
        tabla.getCellEditor().stopCellEditing(); // Detiene la edicion de la tabla, para que se guarden todos los valores
        datosTabla = new Object[numeroDeNodos][3];
        Object[] renglon_tabla = new Object[3];
        
        
        for(int renglon = 0; renglon<numeroDeNodos; renglon++){
            renglon_tabla[columnaNodo] = tabla.getValueAt(renglon, columnaNodo);
            renglon_tabla[columnaTierra] = tabla.getValueAt(renglon, columnaTierra); 
            renglon_tabla[columnaFuente] = tabla.getValueAt(renglon, columnaFuente);
            
            datosTabla[renglon][columnaNodo] =  renglon_tabla[columnaNodo];
            datosTabla[renglon][columnaTierra] =  renglon_tabla[columnaTierra];
            datosTabla[renglon][columnaFuente] =  renglon_tabla[columnaFuente];
        }
        
    }
    
    public void imprimirParaPruebas(){
        for (int i = 0; i < datosTabla.length; i++) {
              System.out.println("nodo: " + datosTabla[i][0]);
              System.out.println("tierra: " + datosTabla[i][1]);
              System.out.println("fuente: " + datosTabla[i][2]);
              
        }
    
    }
    
   
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>https://meet.google.com/zfe-ztkv-ewu

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bIngresarNumeroNodos;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNumeroDeNodos;
    // End of variables declaration//GEN-END:variables
}
