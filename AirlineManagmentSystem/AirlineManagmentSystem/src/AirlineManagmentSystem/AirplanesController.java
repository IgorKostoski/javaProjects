package AirlineManagmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AirplanesController {
	
	public static void AddNewAirplane(Database database, Scanner s) throws SQLException {
		
		
		
		System.out.println("Enter economy capacity(int): ");
		int EconomyCapacity = s.nextInt();
		
		System.out.println("Enter business capacity (int): ");
		int BusinessCapacity = s.nextInt();	
		
		System.out.println("Enter model: ");
		String model = s.next();
		
		Airplane airplane = new Airplane();
		airplane.setEconomyCapacity(EconomyCapacity);
		airplane.setBusinessCapacity(BusinessCapacity);
		airplane.setModel(model);
		
		
		int id;
		
		ArrayList<Airplane> planes = getAllPlanes(database);
		
		if(planes.size()!= 0) {
			 id = planes.get(planes.size()-1).getId()+1;			
		} else {
			id = 0;
			
		}
		
		airplane.setId(id);
		
		
		String insert = "INSERT INTO `airplanes`(`id`, `EconomyCapacity`, `BusinessCapacity`, `model`)"
				+ " VALUES ('"+airplane.getId()+"',"
						+ "'"+airplane.getEconomyCapacity()+"',"
				+ "'"+airplane.getBusinessCapacity()+"',"
				+ "'"+airplane.getModel()+"');";
		
		database.getStatement().execute(insert);
		System.out.println("Airplane added succesfully!");
		
		
		
		
		
	
	}
	
	
	public static ArrayList<Airplane> getAllPlanes(Database database) throws SQLException{
		ArrayList<Airplane> planes = new ArrayList<>();
		String get = "SELECT * FROM `employees`;";
		
		ResultSet rs = database.getStatement().executeQuery(get);	
		
		while(rs.next()) {
			Airplane a = new Airplane();
			a.setId(rs.getInt("id"));
			a.setEconomyCapacity(rs.getInt("EconomyCapacity"));
			a.setBusinessCapacity(rs.getInt("BusinessCapacity"));
			a.setModel(rs.getString("model"));
			planes.add(a);
			
		}
		return planes;
	}
	
	

}
