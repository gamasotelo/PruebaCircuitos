
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VentanaConexiones extends javax.swing.JDialog {

    DefaultTableModel modelo;
    int numero_nodos;
    Object[][] datos_tabla;
    String[][] datos_conexiones;
    
    public VentanaConexiones(int numero_nodos, Object[][] datos_tabla) {
        initComponents();
        setLocationRelativeTo(null);
         this.numero_nodos = numero_nodos;
         this.datos_tabla = datos_tabla; 
         this.setVisible(true);
         modelo = (DefaultTableModel)tabla1.getModel();
         inicia_tabla();
    }
    
    private void inicia_tabla(){
        String[] renglon = new String[2];
        
        for (int i = 1; i <= numero_nodos; i++) {
            if(i % 2 != 0){
                renglon[0] = String.valueOf(i);
                renglon[1] = "";
                
                modelo.addRow(renglon);
            }
        }
    }
    
    private void leer_tabla(){
        String[] conexiones;
        String casilla_nodo;
        datos_conexiones = new String[numero_nodos][numero_nodos];
        
        for (int i = 0; i < tabla1.getRowCount(); i++) {
            String info_celda_conexiones = String.valueOf(tabla1.getValueAt(i, 1));
            casilla_nodo = String.valueOf(tabla1.getValueAt(i,0));
            
            conexiones = info_celda_conexiones.split(",");
            
            // Eliminar espacios del arreglo
            for(int j = 0; j < conexiones.length ; j++) {
            conexiones[j] = conexiones[j].trim();
            }
            
            boolean error = comprueba_errores(conexiones);
            if (error)
                break;
            
            datos_conexiones[i][0] = casilla_nodo;
            for(int j = 1; j <= conexiones.length ; j++) {
                datos_conexiones[i][j] = conexiones[j-1];
            }
        }
        
        Matrices objeto = new Matrices(numero_nodos);
        objeto.obtenerTodasLasConexiones(datos_conexiones);
    }
    
    
    
    
    private boolean comprueba_errores(String[] conexiones){
        int longitud = conexiones.length;
        boolean error = false;
        
        for (int j = 0; j < longitud; j++) {
            try {
                int dato = Integer.parseInt(conexiones[j]);
                
                if(dato <1 || dato > numero_nodos){
                    JOptionPane.showMessageDialog(null, "Número fuera de rango: " + conexiones[j]);
                    error = true;
                    return error;
                }
                
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Dato incorrecto: " + conexiones[j]);
                error = true;
                return error;
            }
            
            for (int i = 0; i < numero_nodos; i++) {
                
            }
        }
        return error;
    }
    
    public void combinar_arreglos(Object[][] datos_tabla, String[] conexiones){
         
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nodo", "Conexion "
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        leer_tabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
