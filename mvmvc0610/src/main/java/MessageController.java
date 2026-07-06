

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Message;
/**
 * Servlet implementation class MessageController
 */
@WebServlet("/message")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MessageController() {
        super();
      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Message msg=new Message();
		String n=request.getParameter("name");
		String data="";
		if(n!=null && n!="") {
			data=msg.says(n);
		}else {
			data="no message";
		}
		request.setAttribute("message", data);
		request.getRequestDispatcher("msgview.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
