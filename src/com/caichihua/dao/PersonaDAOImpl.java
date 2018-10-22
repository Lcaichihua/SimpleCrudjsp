package com.caichihua.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caichihua.model.Persona;
import com.caichihua.util.Conexion;

public class PersonaDAOImpl implements PersonaDAO {

	private Connection cx;

	public PersonaDAOImpl() {
		cx = Conexion.conectar();
	}

	@Override
	public void agregar(Persona persona) {
		try {
			String sql = "INSERT INTO PERSONA(nombres, apellidos) VALUES (?,?)";
			PreparedStatement preparedStatement = cx.prepareStatement(sql);
			preparedStatement.setString(1, persona.getNombres());
			preparedStatement.setString(2, persona.getApellidos());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int personaId) {
		try {
			String sql = "DELETE FROM PERSONA WHERE ID = ?";
			PreparedStatement preparedStatement = cx.prepareStatement(sql);
			preparedStatement.setInt(1, personaId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(Persona persona) {
		try {
			String sql = "UPDATE PERSONA SET NOMBRES = ?, APELLIDOS = ? WHERE ID = ?";
			PreparedStatement preparedStatement = cx.prepareStatement(sql);
			preparedStatement.setString(1, persona.getNombres());
			preparedStatement.setString(2, persona.getApellidos());
			preparedStatement.setInt(3, persona.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Persona> listarTodos() {
		List<Persona> personas = new ArrayList<>();
		try {
			Statement statement = cx.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSONA");
			while (resultSet.next()) {
				Persona persona = new Persona();
				persona.setId(resultSet.getInt("id"));
				persona.setNombres(resultSet.getString("nombres"));
				persona.setApellidos(resultSet.getString("apellidos"));
				personas.add(persona);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//Conexion.desconectar();
		}
		return personas;
	}

	@Override
	public Persona listarPorId(int id) {
		Persona persona = new Persona();
		try {
			String query = "SELECT * FROM PERSONA WHERE ID =?";
			PreparedStatement preparedStatement = cx.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				persona.setId(resultSet.getInt("id"));
				persona.setNombres(resultSet.getString("nombres"));
				persona.setApellidos(resultSet.getString("apellidos"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persona;
	}

}
