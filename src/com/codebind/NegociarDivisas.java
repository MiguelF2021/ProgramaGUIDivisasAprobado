package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class NegociarDivisas {
    public JPanel pnlNegociarDivisas;
    private JComboBox comboBoxDivisasCompra;
    private JComboBox comboBoxDivisasVenta;
    private JTextField txtCantidadDivisaCompra;
    private JTextField txtCantidadDivisaVenta;
    private JButton btnComprar;
    private JButton btnVender;
    private JButton btnRegresar;
    private JLabel lblDolar;
    private JLabel lblPagaras;
    private JLabel lblPesosPorCompra;
    private JLabel lblRecibirás;
    private JLabel lblPesosPorVenta;
    public JLabel lblDisponiblesCOP;
    public JLabel lblPrecioCompraDolar;
    public JLabel lblPrecioVentaDolar;
    public JLabel lblDisponibleDolar;
    public JLabel lblPrecioDolarCompra;
    public JLabel lblPrecioDolarVenta;
    private JLabel lblEuro;
    private JLabel lblNegociarDivisas;
    public JLabel lblPrecioCompraEuro;
    public JLabel lblPrecioVentaEuro;
    public JLabel lblDisponibleEuro;
    public JLabel lblPrecioEuroCompra;
    public JLabel lblPrecioEuroVenta;
    private JLabel lblLibra;
    public JLabel lblPrecioCompraLibra;
    public JLabel lblPrecioVentaLibra;
    public JLabel lblDisponibleLibra;
    public JLabel lblPrecioLibraCompra;
    public JLabel lblPrecioLibraVenta;


    private Boolean compraExitosaDolar = false;
    private Boolean ventaExitosaDolar = false;
    private Double pesosPorCompraDolar;
    private Double pesosPorVentaDolar;
    private Double cantidadVentaDolar;
    private Double cantidadCompraDolar;
    private Boolean compraExitosaEuro = false;
    private Boolean ventaExitosaEuro = false;
    private Double pesosPorCompraEuro;
    private Double pesosPorVentaEuro;
    private Double cantidadVentaEuro;
    private Double cantidadCompraEuro;
    private Boolean compraExitosaLibra = false;
    private Boolean ventaExitosaLibra = false;
    private Double pesosPorCompraLibra;
    private Double pesosPorVentaLibra;
    private Double cantidadVentaLibra;
    private Double cantidadCompraLibra;

    public NegociarDivisas() {

        comboBoxDivisasVenta.addItem(".....");
        comboBoxDivisasVenta.addItem("Dolar");
        comboBoxDivisasVenta.addItem("Euro");
        comboBoxDivisasVenta.addItem("Libra");


        comboBoxDivisasCompra.addItem(".....");
        comboBoxDivisasCompra.addItem("Dolar");
        comboBoxDivisasCompra.addItem("Euro");
        comboBoxDivisasCompra.addItem("Libra");

        //Compra y venta de dólares
        comboBoxDivisasCompra.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == comboBoxDivisasCompra) {
                    String seleccionado = (String) comboBoxDivisasCompra.getSelectedItem();
                    if (seleccionado == "Dolar") {
                      cantidadCompraDolar = Double.valueOf(txtCantidadDivisaCompra.getText());
                    } if ( cantidadCompraDolar > Double.valueOf(lblDisponibleDolar.getText()) ) {
                        JOptionPane.showMessageDialog(null, "No tenemos esa cantidad de Dólares disponibles." +
                                " Modifique la cantidad de Dólares que desea comprar.");
                        txtCantidadDivisaCompra.setText("");
                    }
                    if ( cantidadCompraDolar <= Double.valueOf(lblDisponibleDolar.getText())) {
                        pesosPorCompraDolar = cantidadCompraDolar * Double.valueOf(lblPrecioDolarCompra.getText());
                        lblPesosPorCompra.setText(String.valueOf(pesosPorCompraDolar));
                        compraExitosaDolar = true;
                    }
                }
            }
        });
        comboBoxDivisasVenta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == comboBoxDivisasVenta) {
                    String seleccionado = (String) comboBoxDivisasVenta.getSelectedItem();
                    if (seleccionado == "Dolar") {
                        cantidadVentaDolar = Double.valueOf(txtCantidadDivisaVenta.getText());
                        if (cantidadVentaDolar > 0 ) {
                            pesosPorVentaDolar = Double.valueOf(txtCantidadDivisaVenta.getText()) * Double.valueOf(lblPrecioDolarVenta.getText());
                            lblPesosPorVenta.setText(String.valueOf(pesosPorVentaDolar));
                            ventaExitosaDolar = true;
                        } if (cantidadVentaDolar < 0) {
                            JOptionPane.showMessageDialog(null, "La cantidad de dolares introducida debe ser mayor a cero. " +
                                    " Modifique la cantidad de Dólares que desea vender.");
                            txtCantidadDivisaVenta.setText("");
                            lblPesosPorVenta.setText("");
                        }
                    }
                }
            }
        });

        //Compra y venta de Euro
        comboBoxDivisasCompra.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == comboBoxDivisasCompra) {
                    String seleccionado = (String) comboBoxDivisasCompra.getSelectedItem();
                    if (seleccionado == "Euro") {
                        cantidadCompraEuro = Double.valueOf(txtCantidadDivisaCompra.getText());
                    } if ( cantidadCompraEuro > Double.valueOf(lblDisponibleEuro.getText()) ) {
                        JOptionPane.showMessageDialog(null, "No tenemos esa cantidad de Euros disponibles." +
                                " Modifique la cantidad de Euros que desea comprar.");
                        txtCantidadDivisaCompra.setText("");
                    }
                    if ( cantidadCompraEuro <= Double.valueOf(lblDisponibleEuro.getText())) {
                        pesosPorCompraEuro = cantidadCompraEuro * Double.valueOf(lblPrecioEuroCompra.getText());
                        lblPesosPorCompra.setText(String.valueOf(pesosPorCompraEuro));
                        compraExitosaEuro = true;
                    }
                }
            }
        });
        comboBoxDivisasVenta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == comboBoxDivisasVenta) {
                    String seleccionado = (String) comboBoxDivisasVenta.getSelectedItem();
                    if (seleccionado == "Euro") {
                        cantidadVentaEuro = Double.valueOf(txtCantidadDivisaVenta.getText());
                        if (cantidadVentaEuro > 0 ) {
                            pesosPorVentaEuro = Double.valueOf(txtCantidadDivisaVenta.getText()) * Double.valueOf(lblPrecioEuroVenta.getText());
                            lblPesosPorVenta.setText(String.valueOf(pesosPorVentaEuro));
                            ventaExitosaEuro = true;
                        } if (cantidadVentaEuro < 0) {
                            JOptionPane.showMessageDialog(null, "La cantidad de Euros introducida debe ser mayor a cero. " +
                                    " Modifique la cantidad de Euros que desea vender.");
                            txtCantidadDivisaVenta.setText("");
                            lblPesosPorVenta.setText("");
                        }
                    }
                }
            }
        });

        //Compra y venta de Libra
        comboBoxDivisasCompra.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == comboBoxDivisasCompra) {
                    String seleccionado = (String) comboBoxDivisasCompra.getSelectedItem();
                    if (seleccionado == "Libra") {
                        cantidadCompraLibra = Double.valueOf(txtCantidadDivisaCompra.getText());
                    } if ( cantidadCompraLibra > Double.valueOf(lblDisponibleLibra.getText()) ) {
                        JOptionPane.showMessageDialog(null, "No tenemos esa cantidad de Libras disponibles." +
                                " Modifique la cantidad de Libras que desea comprar.");
                        txtCantidadDivisaCompra.setText("");
                    }
                    if ( cantidadCompraLibra <= Double.valueOf(lblDisponibleLibra.getText())) {
                        pesosPorCompraLibra = cantidadCompraLibra * Double.valueOf(lblPrecioLibraCompra.getText());
                        lblPesosPorCompra.setText(String.valueOf(pesosPorCompraLibra));
                        compraExitosaLibra = true;
                    }
                }
            }
        });
        comboBoxDivisasVenta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == comboBoxDivisasVenta) {
                    String seleccionado = (String) comboBoxDivisasVenta.getSelectedItem();
                    if (seleccionado == "Libra") {
                        cantidadVentaLibra = Double.valueOf(txtCantidadDivisaVenta.getText());
                        if (cantidadVentaLibra > 0 ) {
                            pesosPorVentaLibra = Double.valueOf(txtCantidadDivisaVenta.getText()) * Double.valueOf(lblPrecioLibraVenta.getText());
                            lblPesosPorVenta.setText(String.valueOf(pesosPorVentaLibra));
                            ventaExitosaLibra = true;
                        } if (cantidadVentaLibra < 0) {
                            JOptionPane.showMessageDialog(null, "La cantidad de dolares introducida debe ser mayor a cero. " +
                                    " Modifique la cantidad de Dólares que desea vender.");
                            txtCantidadDivisaVenta.setText("");
                            lblPesosPorVenta.setText("");
                        }
                    }
                }
            }
        });

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (compraExitosaDolar == true) {
                    Double cantidadDisponibleDolar = Double.valueOf(lblDisponibleDolar.getText()) - (cantidadCompraDolar);
                    lblDisponibleDolar.setText(String.valueOf(cantidadDisponibleDolar));
                    JOptionPane.showMessageDialog(null, " La compra fue exítosa");
                    txtCantidadDivisaCompra.setText("");
                    lblPesosPorCompra.setText(" ");
                }
                if (compraExitosaEuro == true) {
                    Double cantidadDisponibleEuro = Double.valueOf(lblDisponibleEuro.getText()) - (cantidadCompraEuro);
                    lblDisponibleEuro.setText(String.valueOf(cantidadDisponibleEuro));
                    JOptionPane.showMessageDialog(null, " La compra fue exítosa");
                    txtCantidadDivisaCompra.setText("");
                    lblPesosPorCompra.setText(" ");
                }
                if (compraExitosaLibra == true) {
                    Double cantidadDisponibleLibra = Double.valueOf(lblDisponibleLibra.getText()) - (cantidadCompraLibra);
                    lblDisponibleLibra.setText(String.valueOf(cantidadDisponibleLibra));
                    JOptionPane.showMessageDialog(null, " La compra fue exítosa");
                    txtCantidadDivisaCompra.setText("");
                    lblPesosPorCompra.setText(" ");
                }
            }
        });

        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ventaExitosaDolar == true){
                    Double cantidadDisponibleDolar = Double.valueOf(lblDisponibleDolar.getText()) + Double.valueOf(txtCantidadDivisaVenta.getText());
                    lblDisponibleDolar.setText(String.valueOf(cantidadDisponibleDolar));
                    JOptionPane.showMessageDialog(null, " La venta fue exítosa");
                    txtCantidadDivisaVenta.setText("");
                    lblPesosPorVenta.setText(" ");
                }
                if(ventaExitosaEuro == true){
                    Double cantidadDisponibleEuro = Double.valueOf(lblDisponibleEuro.getText()) + Double.valueOf(txtCantidadDivisaVenta.getText());
                    lblDisponibleEuro.setText(String.valueOf(cantidadDisponibleEuro));
                    JOptionPane.showMessageDialog(null, " La venta fue exítosa");
                    txtCantidadDivisaVenta.setText("");
                    lblPesosPorVenta.setText(" ");
                }
                if(ventaExitosaLibra == true){
                    Double cantidadDisponibleLibra = Double.valueOf(lblDisponibleLibra.getText()) + Double.valueOf(txtCantidadDivisaVenta.getText());
                    lblDisponibleLibra.setText(String.valueOf(cantidadDisponibleLibra));
                    JOptionPane.showMessageDialog(null, " La venta fue exítosa");
                    txtCantidadDivisaVenta.setText("");
                    lblPesosPorVenta.setText(" ");
                }
            }
        });

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("PreciosDivisas");
                PreciosDivisas preciosdivisas = new PreciosDivisas();
                frame.setContentPane(preciosdivisas.pnlPreciosDivisas);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}








