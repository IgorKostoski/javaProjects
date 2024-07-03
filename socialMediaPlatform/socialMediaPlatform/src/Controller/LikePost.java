package Controller;

import Model.Database;
import Model.Post;
import Model.User;

public class LikePost {
	
	private User u;
	private Post p;
	private Database database;
	
	
	public LikePost(User u, Post p, Database database) {
		this.u = u;
		this.p = p;
		this.database = database;
		
	}
	
	public boolean isLiked() {
		boolean liked = false;
	}

}
