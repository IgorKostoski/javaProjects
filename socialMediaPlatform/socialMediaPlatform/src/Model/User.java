package Model;

import java.util.ArrayList;

public class User {
	
	
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private ArrayList<Post> posts;
	private ArrayList<Comment> comments;
//	private ArrayList<Post> likes;
	private ArrayList<Integer> likesIDs;
//	private ArrayList<User> friends;
	private ArrayList<Integer> friendsIDs;
	
	
	
	public User() {
		posts = new ArrayList<>();
		
		comments = new ArrayList<> ();
//		likes = new ArrayList<> ();
		likesIDs = new ArrayList<> ();
//		friends = new ArrayList<> ();
		friendsIDs = new ArrayList<> ();
		
	}
	
	public int getID() {
		return ID;
	}
	
	public void  setID(int ID) {
		this.ID = ID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}
	
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
//	public ArrayList<Post> getLikes(){
//		return likes;
//	}
	
//	public void setLikes(ArrayList<Post> likes) {
//		this.likes = likes;
//	}
	
	
	public ArrayList<Integer> getLikesIDs(){
		return likesIDs;
	}
	
	public void setLikesIDs(ArrayList<Integer> likesIDs) {
		this.likesIDs = likesIDs;
	}
	
	public boolean liked(Post p) {
		return likesIDs.contains(p.getID());
	}
	
	public void like(Post p) {
		likesIDs.add(p.getID());
	}
	
	public void dislike(Post p) {
		likesIDs.remove((Integer) p.getID());
	}
	
//	public ArrayList<User> getFriends() {
//		return friends;
//	}
	
	public void setFriends(ArrayList<User> friends) {
//		this.friends = friends;
		friendsIDs = new ArrayList<>();
		for (User u : friends) {
			friendsIDs.add(u.getID());
		}
		
		
	}
	
	
	public void setFriendsIDs (ArrayList<Integer> friendsIDs){
		this.friendsIDs = friendsIDs;
	}
	
	public ArrayList<Integer> getFriendsIDs(){
		return friendsIDs;
	}
	
	public boolean isFriend(User u) {
		return friendsIDs.contains(u.getID());
	}
	
	
	public void addFriend(User f) {
//		friends.add(f);
		friendsIDs.add(f.getID());
	}
	
	public void removeFriend(User f) {
//		friends.remove(f);
		friendsIDs.remove((Integer)f.getID());
	}
	
	

}
