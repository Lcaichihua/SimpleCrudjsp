package com.caichihua.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
	
	// solo puede ser usado en el paquete
	protected static Connection cx ;
	
	public static Connection conectar() {
		
		if(cx != null) {
			
			return cx ;
		}
		//File archivo=new File("db.properties");
				//InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream(archivo.getPath());
				
		// leo a la altura de la carpeta src
		InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream("/db.properties");
		
		//creamos un objeto de tipo properties 
		Properties properties = new Properties();
		
		//traemos los datos del archivo properties
		
	
		
		try {
			properties.load(inputStream);
			String driver  = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password =properties.getProperty("password");
			Class.forName(driver);
			cx = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		return cx;
		
	}
	
	public static void desconectar() {
		
		if(cx== null) {
			
			return ;
		}
		try {
			cx.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		 
	}
	/*
	public static void main(String [] args)
	{
		
		
		// leo a la altura de la carpeta src
		InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream("/db.properties");
		
		//creamos un objeto de tipo properties 
		Properties properties = new Properties();
		
		//traemos los datos del archivo properties
		String driver  = null;
	
		
		try {
			properties.load(inputStream);
			 driver  = properties.getProperty("driver");
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		System.out.println("el driver es " + driver);
		
	}*/
	
}


