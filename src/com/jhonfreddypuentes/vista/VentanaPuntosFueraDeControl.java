/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonfreddypuentes.vista;


import com.jhonfreddypuentes.cmd.Cmd;
import com.jhonfreddypuentes.constante.Constante;
import com.jhonfreddypuentes.constante.TipoGraficaEnum;
import com.jhonfreddypuentes.dto.GraficoPorAtributo;
import com.jhonfreddypuentes.dto.GraficoPorVariable;
import com.jhonfreddypuentes.dto.PuntoFueraLimite;
import com.jhonfreddypuentes.util.Util;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhon
 */
public class VentanaPuntosFueraDeControl extends javax.swing.JFrame {

    private GraficoPorVariable graficoPorVariable    = null;
    private GraficoPorAtributo graficoPorAtributo    = null;
    private List<PuntoFueraLimite> puntosFueraLimite = null;
    public static List<PuntoFueraLimite> eliminados  = null;
                
    /**
     * Creates new form VentanaPuntosFueraDeControl
     * @param grafico
     * @param puntosFueraLimite
     */
    public VentanaPuntosFueraDeControl(GraficoPorVariable grafico, List<PuntoFueraLimite> puntosFueraLimite) {
        if(Constante.DEBUG)
            System.out.println("INI-VentanaPuntosFueraDeControl()");
        initComponents();
        this.graficoPorVariable = grafico;
        this.puntosFueraLimite = puntosFueraLimite;
        imprimirPuntosEnTabla();
    }

    public VentanaPuntosFueraDeControl(GraficoPorAtributo grafico, List<PuntoFueraLimite> puntosFueraLimite) {
        if(Constante.DEBUG)
            System.out.println("INI-VentanaPuntosFueraDeControl()");
        initComponents();
        this.graficoPorAtributo = grafico;
        this.puntosFueraLimite  = puntosFueraLimite;
        imprimirPuntosEnTabla();
    }
    
    /**
     * Mostrar puentos fuera en la tabla.
     */
    private void imprimirPuntosEnTabla(){
        if(Constante.DEBUG)
            System.out.println("INI-imprimirPuntosEnTabla()");
        try{
            DefaultTableModel modelo = (DefaultTableModel)jTable_puntosFuera.getModel();
            for(PuntoFueraLimite punto: puntosFueraLimite){
                modelo.addRow(buildRow(punto));
            }
        }catch(Exception e){
            System.out.println("Error en imprimirPuntosEnTabla(). Mensaje: "+e.getMessage());
        }
    }
    
    /**
     * @param PuntoFueraLimite punto.
     */
    private Object[] buildRow(PuntoFueraLimite punto){
        Object[] row = {punto.getMuestra(), punto.getTipoGrafico(), punto.getDato(), true};
        return row;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_puntosFuera = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_puntosFuera = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton_cancelar = new javax.swing.JButton();
        jButton_aplicarCambios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel_puntosFuera.setBorder(javax.swing.BorderFactory.createTitledBorder("Puntos Fuera de Límites"));

        jTable_puntosFuera.setAutoCreateRowSorter(true);
        jTable_puntosFuera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Muestra", "Tipo Gráfico", "Valor", "¿Eliminar?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_puntosFuera);

        javax.swing.GroupLayout jPanel_puntosFueraLayout = new javax.swing.GroupLayout(jPanel_puntosFuera);
        jPanel_puntosFuera.setLayout(jPanel_puntosFueraLayout);
        jPanel_puntosFueraLayout.setHorizontalGroup(
            jPanel_puntosFueraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_puntosFueraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_puntosFueraLayout.setVerticalGroup(
            jPanel_puntosFueraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_puntosFueraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acción"));

        jButton_cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_cancelar.setForeground(new java.awt.Color(255, 102, 102));
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });

        jButton_aplicarCambios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_aplicarCambios.setForeground(new java.awt.Color(51, 153, 255));
        jButton_aplicarCambios.setText("Aplicar cambios");
        jButton_aplicarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aplicarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jButton_cancelar)
                .addGap(18, 18, 18)
                .addComponent(jButton_aplicarCambios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_aplicarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_puntosFuera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_puntosFuera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        if(Constante.DEBUG)
            System.out.println("INI-jButton_cancelarActionPerformed()");
        try{
            this.puntosFueraLimite = null;
            jTable_puntosFuera.setModel(new DefaultTableModel());
            eliminados = null;
            this.dispose();
        }catch(Exception e){
            System.out.println("Error al cerrar la ventana y variables.. "+e.getMessage());
        }
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton_aplicarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aplicarCambiosActionPerformed
        if(Constante.DEBUG)
            System.out.println("INI-jButton_aplicarCambiosActionPerformed()");
        eliminados = new ArrayList<>();
        
        //Capturo la data de la tabla.
        if(Constante.DEBUG)
            System.out.println("Capturando data de la tabla...");
        for (int i = 0; i < this.jTable_puntosFuera.getRowCount(); i++) {
            final Integer muestra  = (Integer)jTable_puntosFuera.getValueAt(i, 0);
            final String tipo      = (String) jTable_puntosFuera.getValueAt(i, 1);
            final Double valor     = (Double) jTable_puntosFuera.getValueAt(i, 2);
            final Boolean eliminar = (Boolean)jTable_puntosFuera.getValueAt(i, 3);
            if(eliminar)
                eliminados.add(new PuntoFueraLimite(muestra, valor, tipo));
        }
        
        //Eliminar muestras.
        if(Constante.DEBUG)
            System.out.println("Eliminando muestras repetidas no seleccionadas para eliminar...");
        for (int i = 0; i < this.jTable_puntosFuera.getRowCount(); i++) {
            final Integer muestra  = (Integer)jTable_puntosFuera.getValueAt(i, 0);
            final String tipo      = (String) jTable_puntosFuera.getValueAt(i, 1);
            final Double valor     = (Double) jTable_puntosFuera.getValueAt(i, 2);
            final Boolean eliminar = (Boolean)jTable_puntosFuera.getValueAt(i, 3);
            for(PuntoFueraLimite puntoFuera: eliminados){
                if(Objects.equals(puntoFuera.getMuestra(), muestra) && !eliminar)
                    eliminados.add(new PuntoFueraLimite(muestra, valor, tipo));
            }
        }
        
        final int cantidadPuntosEliminar = eliminados.size();
        if(Constante.DEBUG)
            System.out.println("Cantidad puntos a eliminar : ["+cantidadPuntosEliminar+"]");
                
        //Valido si hay puntos para eliminar.
        if(Constante.DEBUG)
            System.out.println("IF(cantidadPuntosEliminar>0) : ["+(cantidadPuntosEliminar>0)+"]");
        if(cantidadPuntosEliminar>0){
            final String mensaje = Constante.CONFIRMACION_ELIMINADOS.replace("{}",String.valueOf(cantidadPuntosEliminar));
            final int resultado  = JOptionPane.showConfirmDialog(this,mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);
            switch(resultado){
                case 0:
                    /**
                     * Grafico X-Bar-R.
                     */
                    if(graficoPorVariable!=null && graficoPorVariable.getTipoGrafico()==TipoGraficaEnum.X_BARRA_R)
                        graficarXBarR();
                    if(graficoPorVariable!=null && graficoPorVariable.getTipoGrafico()==TipoGraficaEnum.X_BARRA_S)
                        graficarXBarS();
                    if(graficoPorVariable!=null && graficoPorVariable.getTipoGrafico()==TipoGraficaEnum.X_M_R)
                        graficarXEmeR();
                    if(graficoPorAtributo!=null && graficoPorAtributo.getTipoGrafico()==TipoGraficaEnum.P)
                        graficarP();
                    if(graficoPorAtributo!=null && graficoPorAtributo.getTipoGrafico()==TipoGraficaEnum.NP)
                        graficarNP();
                    if(graficoPorAtributo!=null && graficoPorAtributo.getTipoGrafico()==TipoGraficaEnum.C)
                        graficarC();
                    if(graficoPorAtributo!=null && graficoPorAtributo.getTipoGrafico()==TipoGraficaEnum.U)
                        graficarU();
                    break;
            }
        }
    }//GEN-LAST:event_jButton_aplicarCambiosActionPerformed
        
    private void graficarXBarR(){
        if(Constante.DEBUG)
            System.out.println("INI-graficarXBarR()");
        
        //Graficar.
        List<Double> datosPrimerGrafico  = graficoPorVariable.getDatos();
        List<Double> datosSegundoGrafico = graficoPorVariable.getDatosSegundoGrafico();
        List<Double> rangosPorMuestra    = graficoPorVariable.getRangosPorFila();
        
        //Eliminar los puntos de las listas de datos a graficar.
        if(Constante.DEBUG)
            System.out.println("Eliminando puntos fuera de limites.");
        
        int contadorDeMuestra=1;
        for(PuntoFueraLimite punto:eliminados){
            datosPrimerGrafico.remove(punto.getMuestra()-contadorDeMuestra);
            datosSegundoGrafico.remove(punto.getMuestra()-contadorDeMuestra);
            rangosPorMuestra.remove(punto.getMuestra()-contadorDeMuestra);
            contadorDeMuestra++;
        }
        
        //Grafico X bar
        String datos                           = Util.obtenerDatosCsvDesdeLista(datosPrimerGrafico);
                
        Double mediaDeMedias = Util.obtenerMediaDeMedias(datosPrimerGrafico);
        
        if(graficoPorVariable!=null && graficoPorVariable.getMediaConocida()!=null){
            mediaDeMedias = graficoPorVariable.getMediaConocida();
        }
        
        final Double mediaDeRangos = Util.obtenerMediaDeRangos(rangosPorMuestra);
        // Constantes.
        final int tamMuestra = graficoPorVariable.getTamanioMuestra();
        
        final Double factorA2 = Constante.LISTA_A2.get(tamMuestra);
        final Double factorD3 = Constante.LISTA_D3.get(tamMuestra);
        final Double factorD4 = Constante.LISTA_D4.get(tamMuestra);
        
        final Double limiteControlInferiorEquisBarra = mediaDeMedias-factorA2*mediaDeRangos;
        final Double limiteControlSuperiorEquisBarra = mediaDeMedias+factorA2*mediaDeRangos;
        
        
        //Grafico R
        final String datosR                    = Util.obtenerDatosCsvDesdeLista(datosSegundoGrafico);
        //TODO: Calcular de nuevo estos limites.
        final Double limiteControlInferiorErre = factorD3*mediaDeRangos;
        final Double limiteControlSuperiorErre = factorD4*mediaDeRangos;
        //Double mediaDeRangos             = grafico.getLimiteSegundoGrafico().getLineaCentral();

        String parametros = limiteControlInferiorEquisBarra+" "+limiteControlSuperiorEquisBarra+" "+mediaDeMedias+""
                     + " \""+datos+"\"" +" "+limiteControlInferiorErre+" "+limiteControlSuperiorErre+" "+mediaDeRangos+" "+datosR;

        String rutaDelScript     = Util.getHome()+Constante.SCRIPTS+Constante.FILE_X_BAR_EXTENDIDO_PY;
        String comandoFinalXBarR = Util.getHome()+Constante.RUTA_PYTHON27+rutaDelScript+" "+parametros;
        String comandoFinal      = comandoFinalXBarR.replace(Constante.STR_BUILD_CLASES, Constante.STR_EMPTY);

        if(Constante.DEBUG)
            System.out.println("Comando Final:"+comandoFinal);
        
        //Ejecutar comando.
        callCommandExecutor(comandoFinal);
    }

    private void graficarXBarS(){
        if(Constante.DEBUG)
            System.out.println("INI-graficarXBarS()");
        
        //Graficar.
        List<Double> datosPrimerGrafico  = graficoPorVariable.getDatos();
        List<Double> datosSegundoGrafico = graficoPorVariable.getDatosSegundoGrafico();
        List<Double> desviacionPorFila   = graficoPorVariable.getDesviacionPorFila();
        Double limiteControlSuperiorS  = (double)0;
        Double limiteControlInferiorS  = (double)0;
        Double limiteControlInferiorXS = (double)0;
        Double limiteControlSuperiorXS = (double)0;
        double mediaDeDesviaciones     = (double)0;
       
        //Eliminar los puntos de las listas de datos a graficar.
        if(Constante.DEBUG)
            System.out.println("Eliminando puntos fuera de limites.");
        int contadorDeMuestra=1;
        for(PuntoFueraLimite punto:eliminados){
            datosPrimerGrafico.remove(punto.getMuestra()-contadorDeMuestra);
            datosSegundoGrafico.remove(punto.getMuestra()-contadorDeMuestra);
            desviacionPorFila.remove(punto.getMuestra()-contadorDeMuestra);
            contadorDeMuestra++;
        }
        
        final int tamanioMuestra = graficoPorVariable.getTamanioMuestra();
        mediaDeDesviaciones      = Util.obtenerMediaDeDesviaciones(desviacionPorFila);
        
        double B3 = Constante.LISTA_B3.get(tamanioMuestra);
        double B4 = Constante.LISTA_B4.get(tamanioMuestra);
        double A3 = Constante.LISTA_A3.get(tamanioMuestra);

        Double mediaDeMedias = Util.obtenerMediaDeMedias(datosPrimerGrafico);
        
        if(graficoPorVariable!=null && graficoPorVariable.getMediaConocida()!=null){
            mediaDeMedias = graficoPorVariable.getMediaConocida();
        }
        
        limiteControlInferiorS  = B3*mediaDeDesviaciones;
        limiteControlSuperiorS  = B4*mediaDeDesviaciones;
        limiteControlInferiorXS = mediaDeMedias - A3*mediaDeDesviaciones;
        limiteControlSuperiorXS = mediaDeMedias + A3*mediaDeDesviaciones;

        final String datos  = Util.obtenerDatosCsvDesdeLista(datosPrimerGrafico);
        final String datosS = Util.obtenerDatosCsvDesdeLista(datosSegundoGrafico);
        
        String parametros = limiteControlInferiorS+" "+limiteControlSuperiorS+" "+mediaDeDesviaciones+" \""+datosS+"\""
               + " "+limiteControlInferiorXS+" "+limiteControlSuperiorXS+" "+mediaDeMedias+" "+datos;

        String rutaDelScript     = Util.getHome()+Constante.SCRIPTS+Constante.FILE_X_BAR_S_PY;
        String comandoFinalXBarS = Util.getHome()+Constante.RUTA_PYTHON27+rutaDelScript+" "+parametros;
        String comandoFinal      = comandoFinalXBarS.replace(Constante.STR_BUILD_CLASES, Constante.STR_EMPTY);
                    
        if(Constante.DEBUG)
            System.out.println("Comando Final:"+comandoFinal);
        
        //Ejecutar comando.
        callCommandExecutor(comandoFinal);
    }
    
    private void graficarXEmeR(){
        
        List<Double> datosEnFila = graficoPorVariable.getDatos();
        //List<Double> rangosMoviles = graficoPorVariable.getDatosSegundoGrafico();
        
        //Eliminar los puntos de las listas de datos a graficar.
        if(Constante.DEBUG)
            System.out.println("Eliminando puntos fuera de limites.");
        int contadorDeMuestra=1;
        for(PuntoFueraLimite punto:eliminados){
            datosEnFila.remove(punto.getMuestra()-contadorDeMuestra);
            //rangosMoviles.remove(punto.getMuestra()-contadorDeMuestra);
            contadorDeMuestra++;
        }        
        
        Double mediaGeneral         = Util.calcularMedia(datosEnFila);
        List<Double> rangosMoviles  = Util.calcularRangosMoviles(datosEnFila);
        Double mediaDeRangosMoviles = Util.calcularMedia(rangosMoviles);
        String datosX               = Util.obtenerDatosCsvDesdeLista(datosEnFila);
        String datosRM              = Util.obtenerDatosCsvDesdeLista(rangosMoviles);

        if(graficoPorVariable!=null && graficoPorVariable.getMediaConocida()!=null){
            mediaGeneral = graficoPorVariable.getMediaConocida();
        }
        
        Double limiteSuperiorParaX = mediaGeneral + 3 * (mediaDeRangosMoviles/1.128);
        Double limiteInferiorParaX = mediaGeneral - 3 * (mediaDeRangosMoviles/1.128);

        Double limiteInferiorParaR = (double)0;
        Double limiteSuperiorParaR = Constante.D4*mediaDeRangosMoviles;

        String parametros = limiteInferiorParaR+" "+limiteSuperiorParaR+" "+mediaDeRangosMoviles+" \""+datosRM+"\""
                            + " "+limiteInferiorParaX+" "+limiteSuperiorParaX+" "+mediaGeneral+" "+datosX;

        String rutaDelScript     = Util.getHome()+Constante.SCRIPTS+Constante.FILE_X_M_R_PY;
        String comandoFinalXBarS = Util.getHome()+Constante.RUTA_PYTHON27+rutaDelScript+" "+parametros;
        String comandoFinal      = comandoFinalXBarS.replace(Constante.STR_BUILD_CLASES, Constante.STR_EMPTY);
        
        if(Constante.DEBUG)
            System.out.println("Comando Final:"+comandoFinal);
        
        //Ejecutar comando.
        callCommandExecutor(comandoFinal);
        
    }
    
    private void graficarP(){
      
      System.out.println("INI-graficarP()");
        
      List<Double> datosEnFila = graficoPorAtributo.getDatosEntrada();

      //Eliminar los puntos de las listas de datos a graficar.
      if(Constante.DEBUG)
          System.out.println("Eliminando puntos fuera de limites.");
      int contadorMuestra=1;
      for(PuntoFueraLimite punto:eliminados){
          int muestra = punto.getMuestra();
          datosEnFila.remove(muestra-contadorMuestra);
          contadorMuestra++;
      }

      Double sumatoria = Util.sumarElementos(datosEnFila);
      int tam  = graficoPorAtributo.getTamanioMuestra();

      int n      = datosEnFila.size();
      Double mxn =  (double) tam * n;

      Double pMedia              = sumatoria/mxn;
      
      if(graficoPorAtributo!=null && graficoPorAtributo.getMediaConocida()!=null){
            pMedia = graficoPorVariable.getMediaConocida();
      }
      
      Double limiteSuperiorParaP = pMedia+3*Math.sqrt((pMedia*(1-pMedia))/tam);
      Double limiteInferiorParaP = pMedia-3*Math.sqrt((pMedia*(1-pMedia))/tam);
      String datosP              = Util.obtenerDatosCsvDesdeLista(datosEnFila,tam);

      DecimalFormat df   = new DecimalFormat(Constante.STR_CERO_CERO);
      String nuevoLimInf = df.format(limiteInferiorParaP).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);
      String nuevoLimSup = df.format(limiteSuperiorParaP).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);
      String nuevaPMedia = df.format(pMedia).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);

      String parametros = nuevoLimInf+" "+nuevoLimSup+" "+nuevaPMedia+" \""+datosP+"\"";

      String rutaDelScript = Util.getHome()+Constante.SCRIPTS+Constante.FILE_P_PY;
      String comandoFinalP = Util.getHome()+Constante.RUTA_PYTHON27+rutaDelScript+" "+parametros;
      String comandoFinal  = comandoFinalP.replace(Constante.STR_BUILD_CLASES, Constante.STR_EMPTY);

      if(Constante.DEBUG)
          System.out.println("Comando Final:"+comandoFinal);

      //Ejecutar comando.
      callCommandExecutor(comandoFinal);
        
    }
    
    
    private void graficarNP(){
        System.out.println("INI-graficarNP()");
      
        List<Double> datosEnFila = graficoPorAtributo.getDatosEntrada();

        //Eliminar los puntos de las listas de datos a graficar.
        if(Constante.DEBUG)
            System.out.println("Eliminando puntos fuera de limites.");
        int contadorMuestra = 1;
        for(PuntoFueraLimite punto:eliminados){
            int muestra = punto.getMuestra();
            datosEnFila.remove(muestra-contadorMuestra);
            contadorMuestra++;
        }

        Double sumatoria         = Util.sumarElementos(datosEnFila);

        int tam = graficoPorAtributo.getTamanioMuestra();

        int n         = datosEnFila.size();
        Double mxn    =  (double) tam * n;
        Double pMedia = sumatoria/mxn;

        if(graficoPorAtributo!=null && graficoPorAtributo.getMediaConocida()!=null){
            pMedia = graficoPorVariable.getMediaConocida();
        }
        
        Double limiteSuperiorParaP = (tam*pMedia)+(3*Math.sqrt((tam*pMedia*(1-pMedia))));
        Double limiteInferiorParaP = (tam*pMedia)-(3*Math.sqrt((tam*pMedia*(1-pMedia))));
        String datosNP             = Util.obtenerDatosCsvDesdeLista(datosEnFila);

        DecimalFormat df   = new DecimalFormat(Constante.STR_CERO_CERO);
        String nuevoLimInf = df.format(limiteInferiorParaP).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);
        String nuevoLimSup = df.format(limiteSuperiorParaP).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);
        String nuevaPMedia = df.format(tam*pMedia).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);

        String parametros = nuevoLimInf+" "+nuevoLimSup+" "+nuevaPMedia+" \""+datosNP+"\"";

        String rutaDelScript = Util.getHome()+Constante.SCRIPTS+Constante.FILE_NP_PY;
        String comandoFinalP = Util.getHome()+Constante.RUTA_PYTHON27+rutaDelScript+" "+parametros;
        String comandoFinal  = comandoFinalP.replace(Constante.STR_BUILD_CLASES, Constante.STR_EMPTY);

        if(Constante.DEBUG)
            System.out.println("Comando Final:"+comandoFinal);

        //Ejecutar comando.
        callCommandExecutor(comandoFinal);
    }
    
    private void graficarC(){
        System.out.println("INI-graficarC()");
      
        List<Double> datosEnFila = graficoPorAtributo.getDatos();

        //Eliminar los puntos de las listas de datos a graficar.
        if(Constante.DEBUG)
            System.out.println("Eliminando puntos fuera de limites.");
        int contadorMuestra = 1;
        for(PuntoFueraLimite punto:eliminados){
            int muestra = punto.getMuestra();
            datosEnFila.remove(muestra-contadorMuestra);
            contadorMuestra++;
        }
        
        String datosC                = Util.obtenerDatosCsvDesdeLista(datosEnFila);
        Double sumatoria             = Util.sumarElementos(datosEnFila);
        Double cBarra                = sumatoria/datosEnFila.size();
                
        if(graficoPorAtributo!=null && graficoPorAtributo.getMediaConocida()!=null){
            cBarra = graficoPorVariable.getMediaConocida();
        }        
        
        Double limiteControlSuperior = cBarra + 3*Math.sqrt(cBarra);
        Double lineaCentral          = cBarra;
        Double limiteControlInferior = cBarra - 3*Math.sqrt(cBarra);

        String parametros = limiteControlInferior+" "+limiteControlSuperior+" "+lineaCentral+" \""+datosC+"\"";

        String rutaDelScript = Util.getHome()+Constante.SCRIPTS+Constante.FILE_C_PY;
        String comandoFinalP = Util.getHome()+Constante.RUTA_PYTHON27+rutaDelScript+" "+parametros;
        String comandoFinal  = comandoFinalP.replace(Constante.STR_BUILD_CLASES, Constante.STR_EMPTY);

        if(Constante.DEBUG)
            System.out.println("Comando Final:"+comandoFinal);

        //Ejecutar comando.
        callCommandExecutor(comandoFinal);        
    }
    
    private void graficarU(){
        System.out.println("INI-graficarU()");
      
        List<Double> disconformidadesPorUnidad = graficoPorAtributo.getDatos();
        DecimalFormat df = new DecimalFormat(Constante.STR_CERO_CERO);
        int n = graficoPorAtributo.getTamanioMuestra();

        //Eliminar los puntos de las listas de datos a graficar.
        if(Constante.DEBUG)
            System.out.println("Eliminando puntos fuera de limites.");
        int contadorMuestra = 1;
        for(PuntoFueraLimite punto:eliminados){
            int muestra = punto.getMuestra();
            disconformidadesPorUnidad.remove(muestra-contadorMuestra);
            contadorMuestra++;
        }
                
        //List<Double> disconformidadesPorUnidad = Util.getDisconformidadesPorUnidad(datosEnFila,n);
        String datosU                          = Util.obtenerDatosCsvDesdeLista(disconformidadesPorUnidad);
        Double sumatoria                       = Util.sumarElementos(disconformidadesPorUnidad);
        Double uBarra                          = sumatoria/disconformidadesPorUnidad.size();
                
        if(graficoPorAtributo!=null && graficoPorAtributo.getMediaConocida()!=null){
            uBarra = graficoPorVariable.getMediaConocida();
        }       
        
        Double limiteControlSuperior = uBarra + 3*Math.sqrt(uBarra/n);
        Double lineaCentral          = uBarra;
        Double limiteControlInferior = uBarra - 3*Math.sqrt(uBarra/n);

        String nuevoLimiteControlSuperior = df.format(limiteControlSuperior).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);
        String nuevaLineaCentral          = df.format(lineaCentral).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);
        String nuevolimiteControlInferior = df.format(limiteControlInferior).replace(Constante.STR_COMMA_SEPARATOR, Constante.STR_PUNTO);

        String parametros = nuevolimiteControlInferior+" "+nuevoLimiteControlSuperior+" "+nuevaLineaCentral+" \""+datosU+"\"";

        String rutaDelScript = Util.getHome()+Constante.SCRIPTS+Constante.FILE_U_PY;
        String comandoFinalP = Util.getHome()+Constante.RUTA_PYTHON27+rutaDelScript+" "+parametros;
        String comandoFinal  = comandoFinalP.replace(Constante.STR_BUILD_CLASES, Constante.STR_EMPTY);

        if(Constante.DEBUG)
            System.out.println("Comando Final:"+comandoFinal);
        //Ejecutar comando.
        callCommandExecutor(comandoFinal);        
    }
    
    private void callCommandExecutor(final String comando){
        if(Constante.DEBUG)
            System.out.println("INI-callCommandExecutor()");
        try{
            Cmd commandExecutor = new Cmd();
            commandExecutor.ejecutarComandoSinEspera(comando);
        }catch(Exception e){
            Util.print(e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_aplicarCambios;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_puntosFuera;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_puntosFuera;
    // End of variables declaration//GEN-END:variables
}
