package Controller;


import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Post;
import View.Alert;

public class ReadPostComments {
	
	private int comments;
	
	public ReadPostComments(Post p, Database database) {
		
		comments = 0;
		
		String select = "SELECT * FROM `Comments` WHERE `Post` = "+p.getID()+";";
		
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				comments++;
			}
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
			
		}
		
	}
	
	public int getCommentsCount() {
		return comments;
	}

}
