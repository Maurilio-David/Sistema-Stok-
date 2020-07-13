/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author mauri
 */
public class ProdutoDAO {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
    
    public void create(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produtos (descricao,qtd,validade)VALUE(?,?,?)");
            
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDate(3, new java.sql.Date(p.getValidade().getTime()));
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar!: "+ex);
        }finally{
            ConnectionFactory.closeConnection (con, stmt);
        }
    }
    public List<Produto> read(){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("qtd"));
                produto.setValidade(rs.getDate("validade"));
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    
        public void update(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produtos SET descricao = ?,qtd = ?, validade =? WHERE ID = ?");
            
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDate(3, new java.sql.Date(p.getValidade().getTime()));
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!: "+ex);
        }finally{
            ConnectionFactory.closeConnection (con, stmt);
        }
        }        
        public void delete(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
          
                               
            stmt = con.prepareStatement("DELETE FROM produtos WHERE ID = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao tentar apagar!: "+ex);
        }finally{
            ConnectionFactory.closeConnection (con, stmt);
        }
        }        
    public List<Produto> readForDesc(String desc){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos WHERE descricao LIKE ? or validade LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            stmt.setString(2, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("qtd"));
                produto.setValidade(rs.getDate("validade"));
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    } 
    public List<Produto> validade(String a, String b){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM produtos WHERE validade BETWEEN  str_to_date( ? , '%d/%m/%Y') AND str_to_date( ? , '%d/%m/%Y')");
            stmt.setString(1, a);
           stmt.setString(2, b);
            rs = stmt.executeQuery();
            
            
           while (rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("qtd"));
                produto.setValidade(rs.getDate("validade"));
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    } 
}
