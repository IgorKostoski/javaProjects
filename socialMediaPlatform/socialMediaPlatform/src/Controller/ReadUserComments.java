package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import Model.Comment;
import Model.Database;

import Model.User;
import View.Alert;
import View.Post;


public class ReadUserComments {
	
	private ArrayList<JPanel> panels;
	
	
	public ReadUserComments(User u, Database database) {
		
		panels = new ArrayList<>();
		
		String select = "SELECT * FROM `Comments` WHERE `User` = "+u.getID()+";";
		
		try {
			ResultSet rs = database.getStatement().executeQuery(select); 
			while (rs.next()) {
				Comment p = new Comment();
				p.setID(rs.getInt("ID"));
				p.setContent(rs.getString("Content"));
				p.setUser(u);
				p.setDateTimeFromString(rs.getString("DateTime"));
				int postsID = rs.getInt("Post");
				Model.Post post = new ReadPostByID(postsID, database).getPost();
				panels.add(new Post(u, post, database, null));
				panels.add(new View.Comment(p));
				
				
			}
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
		}
		
	}
	
	
	public ArrayList<JPanel> getPostsWithComments() {
		return panels;
	}

}
