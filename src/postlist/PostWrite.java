package postlist;

import java.util.ArrayList;

import postapp.DataBaseAccess;
import postapp.parameter.Post;
import postapp.parameter.Reply;
import properties.CreateDataBaseInstance;

public class PostWrite {
	public ArrayList<Reply> getComment(String postNumber) {
		
		
		  ArrayList<Reply> comments = new ArrayList<Reply>();
		  try {
		    DataBaseAccess access = (DataBaseAccess) CreateDataBaseInstance.getInstance("instance");
			
		    comments = access.allCommentsSelect(postNumber);
		    access.disconnect();
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  return comments;
	}
	public Post getPost(String postNumber) {
		Post post = new Post();
		  try {
			    DataBaseAccess access = (DataBaseAccess) CreateDataBaseInstance.getInstance("instance");
			    post = access.postSelect(postNumber);
			    access.disconnect();
			  } catch (Exception e) {
			    e.printStackTrace();
			  }
		  return post;
	}


}
