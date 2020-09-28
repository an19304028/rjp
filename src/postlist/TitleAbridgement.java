package postlist;
import java.util.ArrayList;

import postapp.DataBaseAccess;
import postapp.parameter.Post;
import properties.CreateDataBaseInstance;

public class TitleAbridgement {
	public ArrayList<Post> abridgement() {
		ArrayList<Post> postBuff = new ArrayList<Post>();
		  try {
		    DataBaseAccess access = (DataBaseAccess)CreateDataBaseInstance.getInstance("instance");
		    postBuff = access.postSelect(5);
		    access.disconnect();
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  return postBuff;
	}
}
