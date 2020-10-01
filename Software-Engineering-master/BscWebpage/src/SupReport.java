import dbConn.UserrDAO;
import mainPkg.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SupReport", urlPatterns = {"/SupReport"})
public class SupReport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        User user = new User(id,request.getParameter("password"));
        int status = user.login();
        String fullname = user.getFullname();
        PrintWriter writer = response.getWriter();
        ResultSet rs = UserrDAO.GetAllStudentInfo(id);
        ResultSet r2 = UserrDAO.ShowDates();


        writer.println("<!DOCTYPE html><html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\" />");
        writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
        writer.println("<title>UniPi-CS: Bcs Thesis Status</title>");
        writer.println("</head>");
        writer.println("<h1 style = 'font-family: Calibri; '>Hello Professor "+fullname+".</h1>");
        writer.println("<body>");
        writer.println("<style> font-size: 18px; </style>");
        writer.println("<div class =\"w3-container\">");

        writer.println("<table class=\"w3-table w3-bordered\">");
        writer.println("<td><b>Your Students</b></td></tr>");
        writer.println("<tr><td><b>AM</b></td>");
        writer.println("<td><b>Fullname</b></td>");
        writer.println("<td><b>E-mail</b></td>");
        writer.println("<td><b>Orientation</b></td>");
        writer.println("<td><b>Bachelor Thesis</b></td>");
        writer.println("<td><b>Starting Date</b></td>");
        writer.println("<td><b>Programming Language</b></td>");
        writer.println("<td><b>Tools</b></td></tr>");
        try {
            while (rs.next()) {
                request.setAttribute("am",rs.getString("am"));
                writer.println("<tr><td><form method = 'post' action = 'stuDetails.jsp'><input type='submit' name= 'am' value ="+ rs.getString("am")+ "></form></td>");
                writer.println("<td>" + rs.getString("fullname") + "</td>");
                writer.println("<td>" + rs.getString("email") + "</td>");
                writer.println("<td>" + rs.getString("orientation") + "</td>");
                writer.println("<td>" + rs.getString("bsc_thesis") + "</td>");
                writer.println("<td>" + rs.getString("start_date") + "</td>");
                writer.println("<td>" + rs.getString("prog_languages") + "</td>");
                writer.println("<td>" + rs.getString("tools") + "</td></tr>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("<td><b></b></td></tr>");
        writer.println("<td><b>Your Scheduled Appointments</b></td></tr>");
        try {
            while (r2.next()) {
                writer.println("<td>" + r2.getString("am") + "</td>");
                writer.println("<td>" + r2.getString("fullname") + "</td>");
                writer.println("<td>" + r2.getString("meeting") + "</td></tr>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.println("<tr></tr>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response, String am) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+ "/stuDetails.jsp");
        rd.forward(request,response);
    }
}