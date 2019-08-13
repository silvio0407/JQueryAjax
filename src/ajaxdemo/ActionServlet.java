package ajaxdemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Gson gson = new Gson();

	public ActionServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = null;
		name = "Hello " + request.getParameter("user");
		if (request.getParameter("user") != null && request.getParameter("user").toString().equals("")) {
			name = "Hello User";
		}
		/*response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(name);*/
		
		Employee employee = new Employee(1, name, "TI", 1000);
		String employJsonString = this.gson.toJson(employee);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(employJsonString);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
