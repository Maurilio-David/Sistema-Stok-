/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author mauri
 */
import com.sun.java.swing.plaf.motif.MotifComboBoxUI;
import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;
import javax.swing.plaf.synth.SynthComboBoxUI;
import javax.swing.text.MaskFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {
   
    private int id ,quantidade;
    private String descricao;
    private Date validade;
    private Date hoje, prazo;
    private JFormattedTextField formattedTextField;

    public JFormattedTextField getFormattedTextField() {
        return formattedTextField;
    }

    public void setFormattedTextField(JFormattedTextField formattedTextField) {
        this.formattedTextField = formattedTextField;
    }

    public Date getHoje() {
        return hoje;
    }

    public void setHoje(Date hoje) {
        this.hoje = hoje;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
    
    

    


    public Date getValidade() {
        return validade;
    }

    /* public Date getValidade() {
    try {
    return new SimpleDateFormat("dd/MM/yyyy").parse(formattedTextField.getText());
    } catch (ParseException ex) {
    return null;
    }
    }
    public void setValidade(Date validade) {
    try{
    formattedTextField.setText(new SimpleDateFormat("dd/MM/yyyy").format(validade));
    }catch(Exception e){
    formattedTextField.setText("");
    }
    }*/
    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

  
   
    
    
    
}
