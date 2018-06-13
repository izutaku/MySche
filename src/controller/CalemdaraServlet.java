package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Calendarmodel;

/**
 * Servlet implementation class CalemdaraServlet
 */
@WebServlet("/CalemdaraServlet")
public class CalemdaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalemdaraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String jsonMsg = null;
        try {
        	HttpSession session = request.getSession();
        	String userid = (String)session.getAttribute("userId");
        	Calendarmodel model = new Calendarmodel();
        	jsonMsg = model.CalendarSelect(userid);

 //           List<Calemdaratt> eventList = new ArrayList<Calemdaratt>();
 //           Calemdaratt event = new Calemdaratt();
 //           event.setTitle("Javaシステム勉強会");
 //           event.setStart("2018-05-09");
 //           eventList.add(event);

 //           event = new Calemdaratt();
 //           event.setTitle("BOLDay");
 //           event.setStart("2018-05-18");
 //           eventList.add(event);

 //           jsonMsg = JSON.encode(eventList);

        } catch (Exception e) {
            System.out.println(e);
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonMsg);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
