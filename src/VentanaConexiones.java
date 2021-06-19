
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VentanaConexiones extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    int numeroDeNodos;
    Object[][] datosTabla;
    String[][] datosConexiones;
     String[][] datosConexionesSinRedundancias;
    int columnaNodo = 0, columnaConexiones = 1;
    
    public VentanaConexiones(int numero_nodos, Object[][] datos_tabla) {
        initComponents();
        setLocationRelativeTo(null);
         this.numeroDeNodos = numero_nodos;
         this.datosTabla = datos_tabla; 
         this.setVisible(true);
         modeloTabla = (DefaultTableModel)tabla.getModel();
         iniciarTabla();
    }
    
    private void iniciarTabla(){
        String[] renglon = new String[2];
        
        for (int i = 1; i <= numeroDeNodos; i++) {
                renglon[0] = String.valueOf(i);
                renglon[1] = "";
                
                modeloTabla.addRow(renglon);            
        }
    }
    
    private void eliminacionDeRejdundanciasEnLasConexiones() {
        datosConexionesSinRedundancias = datosConexiones;

        for (int renglonNodo = 0; renglonNodo < datosConexiones.length; renglonNodo++) {
            String nodo = datosConexiones[renglonNodo][columnaNodo];
            for (int renglon = renglonNodo; renglon < datosConexiones.length; renglon++) {
                for (int columna = 1; columna < datosConexiones[renglon].length; columna++) {
                    String conexion = datosConexiones[renglon][columna];
                    if (nodo.equals(conexion)) {
                        datosConexionesSinRedundancias[renglon][columna] = null;
                    }
                    System.out.println(nodo + " no es igual a " + conexion);
                }
            }
        }

    }

    
    private void leerTabla(){
        String[] listaConexionesPorNodo;
        String celdaNodo;
        datosConexiones = new String[numeroDeNodos][numeroDeNodos];
        
        for (int numeroDeRenglon = 0; numeroDeRenglon < tabla.getRowCount(); numeroDeRenglon++) {
            String celdaConexiones = String.valueOf(tabla.getValueAt(numeroDeRenglon, columnaConexiones));
            celdaNodo= String.valueOf(tabla.getValueAt(numeroDeRenglon,columnaNodo));
            
            listaConexionesPorNodo = celdaConexiones.split(",");
            
            // Eliminar espacios en blanco del arreglo
            for(int j = 0; j < listaConexionesPorNodo.length ; j++) {
                listaConexionesPorNodo[j] = listaConexionesPorNodo[j].trim();
            }
            
            boolean hayUnError = comprueba_errores(listaConexionesPorNodo);
            if (hayUnError)
                break;
            
            datosConexiones[numeroDeRenglon][columnaNodo] = celdaNodo;
            for(int numeroColumna = 1; numeroColumna <= listaConexionesPorNodo.length ; numeroColumna++) {
                datosConexiones[numeroDeRenglon][numeroColumna] = listaConexionesPorNodo[numeroColumna-1];
            }
        }
    }
    
    
    
    
    private boolean comprueba_errores(String[] conexiones){
        int longitudDelArreglo = conexiones.length;
        boolean error = false;
        
        for (int j = 0; j < longitudDelArreglo; j++) {
            try {
                int dato = Integer.parseInt(conexiones[j]);
                
                if(dato <1 || dato > numeroDeNodos){
                    JOptionPane.showMessageDialog(null, "Número fuera de rango: " + conexiones[j]);
                    error = true;
                    return error;
                }
                
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Dato incorrecto: " + conexiones[j]);
                error = true;
                return error;
            }
            
            for (int i = 0; i < numeroDeNodos; i++) {
                
            }
        }
        return error;
    }
    
    public void combinar_arreglos(Object[][] datos_tabla, String[] conexiones){
         
    }
    
    public void imprimirDatosParaHacerPruebas(String[][]datos){
        for (int i = 0; i < datos.length; i++) {
            System.out.println("");
            for (int j = 0; j < datos[i].length; j++) {
                if(datos[i][j] != null)
                System.out.print(datos[i][j] + ", ");
            }
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        bEliminarRedundanciasDeLaTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nodo", "Conexion "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bEliminarRedundanciasDeLaTabla.setText("Eliminar Redundancias De La Tabla");
        bEliminarRedundanciasDeLaTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarRedundanciasDeLaTablaActionPerformed(evt);
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
                .addComponent(bEliminarRedundanciasDeLaTabla)
                .addGap(157, 157, 157)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(bEliminarRedundanciasDeLaTabla))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        leerTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bEliminarRedundanciasDeLaTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarRedundanciasDeLaTablaActionPerformed
        leerTabla();
        eliminacionDeRejdundanciasEnLasConexiones();
        imprimirDatosParaHacerPruebas(datosConexionesSinRedundancias);
    }//GEN-LAST:event_bEliminarRedundanciasDeLaTablaActionPerformed

    public static void main(String args[]) {
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEliminarRedundanciasDeLaTabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
