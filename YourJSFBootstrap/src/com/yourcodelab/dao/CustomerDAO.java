package com.yourcodelab.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yourcodelab.model.Customer;

public class CustomerDAO extends GenericDAO {
	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO tbcustomer(name , email) VALUES (? , ?);";
	private String SQL_SELECT = "SELECT * FROM tbcustomer;";

	public void insertCustomer(Customer c){
		try {
			// Abrir conexão
			openConnection();
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			// Executar o comando de INSERT, logo não se espera retorno
			ps.executeUpdate();
			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting");
		}
	}
	public List<Customer> listarTodos(){
		List<Customer> lista = new ArrayList<Customer>();
		
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar comando de SELECT
			ps = connect.prepareStatement(SQL_SELECT);
			
			// Retorno da consulta com os dados no ResultSet
			ResultSet rs = ps.executeQuery();
			
			// Se houve retorno
			if(rs != null){
				while(rs.next()){
					// Para cada registro do ResultSet, instanciar um objeto Customer
					Customer c = new Customer(rs.getInt("id"), rs.getString("name"),
							rs.getString("email"));
					
					// Adicionar na lista de Clientes
					lista.add(c);
				}
			}
			
			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting");
		}
		
		// Se por acado não houve retorno do banco de dados, retorna
		return lista;
	}

}
