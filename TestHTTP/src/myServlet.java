

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    Map<String, String> books = new HashMap();
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		books.put("JAVA", "700");
		books.put("PHP", "600");
		books.put("C#", "800");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter pw = response.getWriter();
		pw.write("user =  " + request.getParameter("user") + "\n");
		pw.write("password = " + request.getParameter("password"));*/
		
		Cookie cookies[] = request.getCookies();
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Список книг, которые вы выбрали: ");
		for (int i =0; i< cookies.length;i++){
			out.println(cookies[i]+ "\n");
			out.println(cookies[i].getName() + "|" + cookies[i].getValue());
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lang = request.getParameter("lang");
		String price = books.get(lang).toString();
		response.setContentType("text/html, charset = UTF-8"); //the format of the response
		Cookie cookie = new Cookie(lang, price);
		response.addCookie(cookie);
		PrintWriter out = response.getWriter();
		out.println("Вы выбрали книгу по изучению " + lang + "по цене " + price);
		out.println("<a href='TestHTTP/index.html'>НАЗАД</a>");
	}

}
