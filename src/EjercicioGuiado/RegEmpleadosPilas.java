
package EjercicioGuiado;

import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegEmpleadosPilas extends javax.swing.JFrame {

    public class Nodo {
        String codigo;
        String nombre;
        String apellidos;
        String sexo;
        float sueldo;
        Nodo sig;
            
        public Nodo(String cod, String nom, String ape, String sex, float suel){
            codigo = cod;
            nombre = nom;
            apellidos = ape;
            sexo = sex;
            sueldo = suel;
            sig = null;
        }
    }
    
    // Definiendo las intrucciones de los metodos del Nodo
    private Nodo Buscar(Nodo tope, String cod){
        Nodo  pos = tope;
        while(pos!=null && !cod.equalsIgnoreCase(pos.codigo)){
            pos = pos.sig;
        }
        return pos;
    }
    
    private void mensaje(String data){
        
        StringTokenizer st = new StringTokenizer(data, ",");
        
        // Partiendo Texto
        String c = st.nextToken();
        String n = st.nextToken();
        String a = st.nextToken();
        String s = st.nextToken();
        String su = st.nextToken();
        String datos = "Descripcion de los datos Eliminados: \n"+
                "Codigo     :"+c+"\n"+
                "Nombre     :"+n+"\n"+
                "Apellidos     :"+a+"\n"+
                "Sexo     :"+s+"\n"+
                "Sueldo     :"+su+"\n";
        
        JOptionPane.showMessageDialog(this, datos);
    }
    
    private void push(String cod, String nom, String ape, String sex, float suel){
        Nodo nuevo = new Nodo(cod, nom, ape, sex, suel);
        // Realizamos los enlaces correspondientes
        if(tope == null)
            nuevo.sig = null;
        else
            nuevo.sig = tope;
        tope = nuevo;
    }
    
    private String pop(){
        String eliminado = "";
        Nodo aux = tope;
        // Extrayendo los datos a ser eliminados
        String c = aux.codigo;
        String n = aux.nombre;
        String a = aux.apellidos;
        String s = aux.sexo;
        float su = aux.sueldo;
        
        eliminado = c + ", " + n + ", " + a + ", " + s + ", " + String.valueOf(su);
        tope = tope.sig;
        aux.sig = null;
        return eliminado;
    }
    
    void verDatos(){
        // Variable para recorrer la lista
        String cod, nom, ape, se, su;
        Nodo aux = tope;
        VaciarTabla(); // Limpiamos la tabla
        Nodo p; // Puntero adicional para el recorrido
        num = NumElem();
        while (aux != null){
            cod = aux.codigo;
            nom = aux.nombre;
            ape = aux.apellidos;
            se = aux.sexo;
            // Dando Formato al sueldo
            DecimalFormat df2 = new DecimalFormat("####.00");
            su = df2.format(aux.sueldo);
            Object[] fila = {num, cod, nom, ape, se, su};
            num--;
            miModelo.addRow(fila);
            aux = aux.sig;
            
        }
    }
    
    void Resumen(){
        String nom = "", acum = "";
        float suma = 0, mayor = -9999;
        float s;
        Nodo p = tope;
        while (p!=null){
            s = p.sueldo;
            if(s>mayor){
                mayor = s;
                nom = p.nombre + " " + p.apellidos;
            }
            suma = suma+s;
            p = p.sig; 
        }
        // Colocamos la informacion en los objetos
        jTextNomMay.setText(nom);
        jTextNomMay.setEnabled(false);
        
        // Dandole Formato al acumulado
        DecimalFormat  df2 = new DecimalFormat("####.00");
        acum = df2.format(suma);
        
        jTextAcumulado.setText(acum);
        jTextAcumulado.setEnabled(false);
    } 
    
    void Habilitar(){
        jBtonActualizar.setEnabled(true);
        jBtonGuardar.setEnabled(false);
    }
    
    void Deshabilitar(){
        jBtonActualizar.setEnabled(false);
        jBtonGuardar.setEnabled(true);
    }
    
    void LimpiarEntradas(){
        jTextCodigo.setText("");
        jTextNombre.setText("");
        jTextApellidos.setText("");
        jCBoxSexo.setSelectedIndex(0);
        jTextSueldo.setText("");
        jTextCodigo.requestFocus();
        jTextNomMay.setEnabled(true);
        jTextAcumulado.setEnabled(true);
    }
    
    private int NumElem(){
        int num = 0;
        Nodo aux = tope;
        while(aux != null){
            num++;
            aux = aux.sig;
        }
        return num;
    }
    
    void VaciarTabla(){
        // Obteniendo el numero de filas de la tabla 
        int filas = tblRegistros.getRowCount();
        for(int i = 0; i <filas;i++)
            miModelo.removeRow(0);
    }
    
    // Declaramos el formato de la tabla
    DefaultTableModel miModelo;
    String[] cabecera = {"N°", "Codigo", "Nombres", "Apellidos", "Sexo", "Sueldo"};
    String[][] data = {};
    
    // Declaracion de variables locales
    public Nodo tope;
    public Nodo pFound;
    int num = 0;
    
    public RegEmpleadosPilas() {
        initComponents();
        tope = null;
        // Inicializando la Tabla
        miModelo = new DefaultTableModel(data, cabecera);
        tblRegistros.setModel(miModelo);
        Deshabilitar();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCBoxSexo = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jTextSueldo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBtonActualizar = new javax.swing.JButton();
        jBtonGuardar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jBtonRestaurar = new javax.swing.JButton();
        jBtonEliminar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextNomMay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextAcumulado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Empleado"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextCodigoFocusLost(evt);
            }
        });
        jPanel2.add(jTextCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 140, 30));

        jLabel1.setText("CODIGO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        jTextNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextNombreFocusLost(evt);
            }
        });
        jPanel2.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 140, 30));

        jLabel2.setText("NOMBRE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 30));

        jLabel3.setText("APELLIDOS ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 30));

        jTextApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextApellidosFocusLost(evt);
            }
        });
        jPanel2.add(jTextApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 140, 30));

        jLabel4.setText("SEXO");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 30));

        jCBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECCIONE--", "FEMENINO", "MASCULINO" }));
        jPanel2.add(jCBoxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, 30));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 140, 30));
        jPanel2.add(jTextSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 140, 30));

        jLabel7.setText("SUELDO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 290, 180));

        jBtonActualizar.setText("ACTUALIZAR");
        jBtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 120, 50));

        jBtonGuardar.setText("GUARDAR");
        jBtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 120, 50));

        jButton3.setText("CONSULTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 120, 50));

        jBtonRestaurar.setText("RESTAURAR");
        jBtonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtonRestaurarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtonRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 120, 50));

        jBtonEliminar.setText("ELIMINAR");
        jBtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 120, 50));

        jButton6.setText("SALIR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 120, 50));

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRegistros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 560, 160));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("EMPLEADO CON MAYOR SUELDO");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel3.add(jTextNomMay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 30));

        jLabel6.setText("MONTO DE SUELDOS ACUMULADOS");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));
        jPanel3.add(jTextAcumulado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 230, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 560, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jBtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtonGuardarActionPerformed
        // Capturamos la informacion de los objetos
        String cod = jTextCodigo.getText();
        String nom = jTextNombre.getText();
        String ape = jTextApellidos.getText();
        String sex = jCBoxSexo.getSelectedItem().toString();
        String suel = jTextSueldo.getText();
        
        // Creamos el nodo de la lista en memoria y colocando la informacion
        push(cod, nom, ape, sex, Float.parseFloat(suel));
        LimpiarEntradas();
        verDatos();
        Resumen();
    }//GEN-LAST:event_jBtonGuardarActionPerformed

    private void jTextCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextCodigoFocusLost
        jTextCodigo.setText(jTextCodigo.getText().toUpperCase());
    }//GEN-LAST:event_jTextCodigoFocusLost

    private void jTextNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextNombreFocusLost
        jTextNombre.setText(jTextNombre.getText().toUpperCase());
    }//GEN-LAST:event_jTextNombreFocusLost

    private void jTextApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextApellidosFocusLost
        jTextApellidos.setText(jTextApellidos.getText().toUpperCase());
    }//GEN-LAST:event_jTextApellidosFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String cod = jTextCodigo.getText();
        if (cod.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Ingrese un codigo por favor.");
        } else {
            // Llamada a la funcion que retorna la posicion del dato buscado 
            pFound = Buscar(tope, cod);
            
            // Verificando el puntero pFound para mostrar la inf. buscada
            if(pFound != null){
                jTextNombre.setText(pFound.nombre);
                jTextApellidos.setText(pFound.apellidos);
                if (pFound.sexo.equalsIgnoreCase("MASCULINO"))
                    jCBoxSexo.setSelectedIndex(2);
                else
                    jCBoxSexo.setSelectedIndex(1);
                jTextSueldo.setText(String.valueOf(pFound.sueldo));
                
                // Habilitamos los objetos para eliminar y actualizar
                Habilitar();
            } 
            else {
                JOptionPane.showMessageDialog(this, "El codigo " + cod + " no se encuentra en la Pila.");
            }
                
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtonEliminarActionPerformed
        if (tope == null){
            JOptionPane.showMessageDialog(this, "La pila esta vacia.");
            jTextCodigo.requestFocus();
        } else {
            String dato = pop();
            System.out.println(dato);
            mensaje(dato);
            LimpiarEntradas();
            verDatos();
            if(tope == null)
                JOptionPane.showMessageDialog(this, "La pila esta vacia.");
           
            Deshabilitar();
            Resumen();
        }
    }//GEN-LAST:event_jBtonEliminarActionPerformed

    private void jBtonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtonRestaurarActionPerformed
        LimpiarEntradas();
        Deshabilitar();
    }//GEN-LAST:event_jBtonRestaurarActionPerformed

    private void jBtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtonActualizarActionPerformed
        // Colocamos la informacion en el puntero pFound
        pFound.codigo = jTextCodigo.getText();
        pFound.nombre = jTextNombre.getText();
        pFound.apellidos = jTextApellidos.getText();
        pFound.sexo = jCBoxSexo.getSelectedItem().toString();
        pFound.sueldo = Float.parseFloat(jTextSueldo.getText());
        LimpiarEntradas();
        Deshabilitar();
        verDatos();
        Resumen();
    }//GEN-LAST:event_jBtonActualizarActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegEmpleadosPilas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtonActualizar;
    private javax.swing.JButton jBtonEliminar;
    private javax.swing.JButton jBtonGuardar;
    private javax.swing.JButton jBtonRestaurar;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jCBoxSexo;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextAcumulado;
    private javax.swing.JTextField jTextApellidos;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextNomMay;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextSueldo;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables
}
