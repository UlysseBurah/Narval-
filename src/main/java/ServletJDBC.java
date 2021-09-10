

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertDBFrom
 */
@WebServlet("/ServletJDBC")
public class ServletJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
               
       
        out.println("You are " + request.getParameter("age") + " years old!");
        out.println("</body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String JDBCUrl = "jdbc:mysql://ee417.crxkzf89o3fh.eu-west-1.rds.amazonaws.com:3306/testdb";
        String username = "ee417";
        String password = "ee417";
        PrintWriter out = response.getWriter();
        try {
            System.out.println("\nConnecting to the SSD Database......");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBCUrl, username, password);
        }
        catch (Exception e) {
            System.out.println("\nAn error has occurred during the connection phase!  This is most likely due to your CLASSPATH being set wrong and the"
                    + "  classes unable to be found.  Otherwise the database itself may be down.  Try telneting to port 3306 and see if it is up!");
            e.printStackTrace();
            System.exit(0);
        }   

     
       
       String firstname = request.getParameter("firstname");
       String lastname = request.getParameter("lastname");
       String email = request.getParameter("email");
       String passwordd = request.getParameter("password");
       
       
      
	 try {
		  PreparedStatement pstmt = con.prepareStatement("INSERT INTO testdb.Ulysse_database1(firstname,lastname,email,password) VALUES (?,?,?,?)");
				  pstmt.clearParameters();       // Clears any previous parameters
	
				  pstmt.setString(1, firstname);
				  pstmt.setString(2, lastname);
				  pstmt.setString(3, email);
				  pstmt.setString(4, passwordd);
				
				  pstmt.executeUpdate();

		 System.out.println("\nConnection Successful..... creating statement....");
     	     stmt = con.createStatement();
	     rs = stmt.executeQuery("SELECT * FROM MyDB.CUSTOMERS");

	     //while (rs.next())
	     //{    System.out.println("\nName=" + rs.getString("firstname") + " " + rs.getString("lastname"));
	     	//out.println("\nName=" + rs.getString("firstname") + " " + rs.getString("lastname"));}
	 }
        catch (SQLException e) {
	     System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
            while (e != null) {
	         System.out.println(e.getMessage());
                e = e.getNextException();
	     }
            System.exit(0);
        }

        finally {
	     try {    
	         if (rs != null) rs.close();
		 if (stmt != null) stmt.close();
		 if (con != null) con.close();
	     }
	     catch (Exception ex) {
	         System.out.println("An error occurred while closing down connection/statement"); 
            }
        }
		
		
		
		
		
	}

}
