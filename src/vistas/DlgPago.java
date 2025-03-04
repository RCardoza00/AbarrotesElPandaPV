/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import objetosNegocio.Empleado;

/**
 *
 * @author GPE
 */
public class DlgPago extends javax.swing.JDialog {

    private final String total;
    private final Empleado empleado;
    private final FrmPuntoDeVenta frmPuntoDeVenta;

    /**
     * Creates new form DlgPago
     *
     * @param parent
     * @param modal
     * @param total
     */
    public DlgPago(java.awt.Frame parent, boolean modal, String total, Empleado empleado) throws ParseException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        frmPuntoDeVenta = (FrmPuntoDeVenta) parent;
        this.empleado = empleado;
        this.total = total;
        this.txtTotal.setText(total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImgPago = new javax.swing.JLabel();
        btnTarjeta = new javax.swing.JButton();
        btnCredito = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnEfectivo = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccione el Tipo de Pago");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImgPago.setFont(new java.awt.Font("Sylfaen", 3, 36)); // NOI18N
        lblImgPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FormaDePago.png"))); // NOI18N
        getContentPane().add(lblImgPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 260, 70));

        btnTarjeta.setBackground(new java.awt.Color(0, 102, 153));
        btnTarjeta.setText("Tarjeta");
        btnTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjetaActionPerformed(evt);
            }
        });
        getContentPane().add(btnTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        btnCredito.setBackground(new java.awt.Color(0, 102, 153));
        btnCredito.setText("Credito");
        btnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        lblTotal.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("Total:");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        btnEfectivo.setBackground(new java.awt.Color(0, 102, 153));
        btnEfectivo.setText("Efectivo");
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 51, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0.00");
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 220, 70));

        lblFondo.setFont(new java.awt.Font("Sylfaen", 3, 36)); // NOI18N
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoPV.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjetaActionPerformed
        try {
            this.frmPuntoDeVenta.cobrarEnTarjeta();
            this.txtTotal.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(DlgPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTarjetaActionPerformed

    private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed
        this.frmPuntoDeVenta.cobrarCredito();
    }//GEN-LAST:event_btnCreditoActionPerformed

    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
        this.cobrarEfectivo();
    }//GEN-LAST:event_btnEfectivoActionPerformed
    private boolean isFloat(String cadena) {
        try {
            Float.parseFloat(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public void cobrarEfectivo() {
        if (!txtTotal.getText().equalsIgnoreCase("0")) {
            String respuesta = "0";
            if (!txtTotal.getText().equalsIgnoreCase("0")) {
                do {
                    respuesta = JOptionPane.showInputDialog(null, "Ingrese el monto del pago");
                    if (!isFloat(respuesta)) {
                        respuesta = "0";
                    }
                    if (Float.parseFloat(respuesta) < Float.parseFloat(txtTotal.getText())) {
                        JOptionPane.showMessageDialog(null, "El monto de la compra es mayor a la cantidad ingresada ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (Float.parseFloat(respuesta) < Float.parseFloat(txtTotal.getText()));
            }
            Float cambio = Float.parseFloat(respuesta) - Float.parseFloat(txtTotal.getText());
            try {
                this.frmPuntoDeVenta.cobrarEfectivoMetodo();
            } catch (SQLException ex) {
                Logger.getLogger(DlgPago.class.getName()).log(Level.SEVERE, null, ex);
            }
            lblTotal.setText("Cambio: ");
            txtTotal.setText(cambio + "");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCredito;
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JButton btnTarjeta;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblImgPago;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
