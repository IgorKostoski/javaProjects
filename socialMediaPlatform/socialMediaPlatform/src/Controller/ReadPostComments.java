package Controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Comment;
import Model.Database;
import Model.Post;
import View.Alert;

public class ReadPostComments {
	
	private int comments;
	
	public ReadPostComments(Post p, Database database) {
		
		comments = 0;
		
		String select = "SELECT * FROM `Comments` WHERE `Post` = "+p.getID()+";";
		ArrayList<Integer> usersIDs = new ArrayList<>();
		
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				comments++;
				Comment c = new Comment();
				c.setID(rs.getInt("ID"));
				c.setContent(rs.getString("Content"));
				usersIDs.add(rs.getInt("User"));
				c.setDateTimeFromString(rs.getString("DateTime"));
				
			}
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
			
		}
		
	}
	
	public int getCommentsCount() {
		return comments;
	}

}
