package postapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import postapp.parameter.Reply;

public abstract class DataBaseAccess{
	 private static final String DATABASE_CLASS = "oracle.jdbc.driver.OracleDriver";
	    private static final String DATABASE_LOGIN_INFO = "jdbc:oracle:thin:@localhost:1521:orcl";
	    private static final String DATABASE_LOGIN_USER = "dduser";
	    private static final String DATABASE_LOGIN_PW = "dduser";
	    private static Connection connection;

	    // Connection 初期化
	    public static Connection getConnection() throws ClassNotFoundException, SQLException {
	        Class.forName(DATABASE_CLASS);

	        connection = DriverManager.getConnection(DATABASE_LOGIN_INFO,
	                DATABASE_LOGIN_USER, DATABASE_LOGIN_PW);
	        
	        return connection;
	    }

	    // Connectionをcloseする
	    public void disconnect() throws SQLException {
	        connection.close();
	    }
	    
	    public abstract String getCurVal() throws ServletException, SQLException;
	    public abstract ArrayList<postapp.parameter.Post> postSelect() throws SQLException;
	    public abstract ArrayList<postapp.parameter.Post> postSelect(int num) throws SQLException;
	    public abstract ArrayList<postapp.parameter.Post> postSelect(int startNum, int endNum) throws SQLException;
	    public abstract postapp.parameter.Post postSelect(String postNumber) throws SQLException;
	    public abstract void postInsert(String author,String pw, String title, String content) throws SQLException;
	    public abstract void postInsert(String author,String pw, String title, String content, String tags) throws SQLException;
	    public abstract void postDelete(String postNumber) throws SQLException; 
	    public abstract void postUpdate(String postNumber, String content) throws SQLException;
	    public abstract ArrayList<Reply> allCommentsSelect(String postNumber) throws SQLException;
	    public abstract String commentPwSelect(String replyNumber) throws SQLException;
	    public abstract void commentInsert(String postNumber, String author, String pw, String content) throws SQLException;
	    public abstract void commentDelete(String replyNumber) throws SQLException;
	    public abstract ArrayList<String> tagSelect(String tagName) throws SQLException;
	    
	    
	    

}
