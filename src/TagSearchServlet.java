

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import postapp.DataBaseAccess;
import postapp.OracleAccess;
import postapp.parameter.Post;
import properties.CreateDataBaseInstance;



/**
 * Servlet implementation class SearchResult
 */
@WebServlet("/SearchResult")
public class TagSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TagSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		 String tagName = request.getParameter("search");
		 ArrayList searchedPost = new ArrayList();
		 try {
			    DataBaseAccess access = (DataBaseAccess)CreateDataBaseInstance.getInstance("instance");

			    ArrayList<String> postNumberList =  access.tagSelect(tagName);

			    for(String postNumber : postNumberList) {
			        Post post = access.postSelect(postNumber);
			        searchedPost.add(post);
			    }
			  

			    access.disconnect();
			  } catch (Exception e) {
			      e.printStackTrace();
			  }
		 	Boolean  isEmpty = false;
			
		    if(searchedPost.size()<1) {
		    	isEmpty = true;
	        }
			
		
		 
		 
		 request.setAttribute("check", isEmpty);
		 request.setAttribute("tagName", tagName);
		 request.setAttribute("searchedPost", searchedPost);
		
		 RequestDispatcher rd = request.getRequestDispatcher("searchresult");
		 rd.forward(request, response);
	}

}
