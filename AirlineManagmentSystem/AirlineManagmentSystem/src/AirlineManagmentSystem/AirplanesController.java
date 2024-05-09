package AirlineManagmentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AirplanesController {
	
	public static void AddNewAirplane(Database database, Scanner s) throws SQLException {
		
		
		System.out.println("Enter economy capacity (int): ");
		int EconomyCapacity = s.nextInt();
		System.out.println("Enter business capacity(int): ");
		int BusinessCapacity = s.nextInt();
		System.out.println("Enter model: ");
		String model = s.next();
		
		
		Airplane airplane = new Airplane();
		
		airplane.setEconomyCapacity(EconomyCapacity);
		airplane.setBusinessCapacity(BusinessCapacity);
		airplane.setModel(model);
		
		int id;
		ArrayList<Airplane> planes = getAllPlanes(database);
		
		if(planes.size() != 0) {
			
			 id = planes.get(planes.size()-1).getId()+1;
		} else{
			id = 0;
		}
		airplane.setId(id);
		
		String insert = "INSERT INTO `airplanes`(`id`, `EconomyCapacity`, `BusinessCapacity`, `model`) "
				+ "VALUES ('"+airplane.getId()+"',"
						+ "'"+airplane.getEconomyCapacity()+"',"
								+ "'"+airplane.getBusinessCapacity()+"',"
										+ "'"+airplane.getModel()+"');";
		database.getStatement().execute(insert);
		System.out.println("Airplane added successfully!");
		
		
	}
	
	public static void PrintAllPlanes(Database database) throws SQLException {
		System.out.println("==========================");
		
		for(Airplane plane : getAllPlanes(database)) {
			plane.print();
		}
		
		System.out.println("==========================");
		
	}
	
	
	private static ArrayList<Airplane> getAllPlanes(Database database) throws SQLException {

		ArrayList<Airplane> planes = new ArrayList<>();
		String get = "SELECT * FROM `airplanes`;";
		
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
	
	public static void EditAirplane(Database database, Scanner s) throws SQLException {
	    System.out.println("Enter airplane id (int): \n(-1 to show all planes)");
	    int id = s.nextInt();
	    if (id == -1) {
	        PrintAllPlanes(database);

	        System.out.println("Enter id (int): ");
	        id = s.nextInt();
	    }

	    Airplane p = getPlaneByID(database, id);


	    System.out.println("Enter economy capacity (int): \n(-1 to keep old value)");
	    int economyCapacity = s.nextInt();
	    if (economyCapacity == -1) {
	        economyCapacity = p.getEconomyCapacity();
	    }


	    System.out.println("Enter business capacity (int): \n(-1 to keep old value)");
	    int businessCapacity = s.nextInt();
	    if (businessCapacity == -1) {
	        businessCapacity = p.getBusinessCapacity();
	    }


	    System.out.println("Enter model: \n(-1 to keep old value)");
	    String model = s.next();
	    if (model.equals("-1")) {
	        model = p.getModel();
	    }


	    String update = "UPDATE `airplanes` SET `id`='" + p.getId() + "',`EconomyCapacity`='" + economyCapacity + "',"
	            + "`BusinessCapacity`='" + businessCapacity + "',`model`='" + model + "' WHERE `id` =" + p.getId() + ";";

	    database.getStatement().execute(update);
	    System.out.println("Airplane edited successfully!");

	}
	
	
	public static Airplane getPlaneByID(Database database, int id) throws SQLException {
		Airplane a = new Airplane();
		
		String get  = "SELECT `id`, `EconomyCapacity`, `BusinessCapacity`,"
				+ " `model` FROM `airplanes` WHERE `id` = "+id+" ;";
		
		ResultSet rs = database.getStatement().executeQuery(get);
		rs.next();
		a.setId(rs.getInt("id"));
		a.setEconomyCapacity(rs.getInt("EconomyCapacity"));
		a.setBusinessCapacity(rs.getInt("BusinessCapacity"));
		a.setModel(rs.getString("model"));
		
		
		return a;
		
	}

}
