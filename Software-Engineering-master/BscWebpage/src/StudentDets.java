import dbConn.UserrDAO;
import mainPkg.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "StudentDets")
public class StudentDets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String am = (String) request.getParameter("am");
        User user = new User(am,request.getParameter("password"));
        PrintWriter writer = response.getWriter();
        ResultSet rs = UserrDAO.GetSuperReport(am);

        writer.println("<!DOCTYPE html><html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\" />");
        writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
        writer.println("<title>UniPi-CS: Bcs Thesis Status: Student's Details</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<style>  body { font-family: Calibri; } </style>");
        writer.println("<h1 id = 'am' style = 'font-family:Calibri;'>"+am+"</h1>");
        writer.println("<div class =\"w3-container\">");
        writer.println("<table class = \"w3-table w3-bordered\">");
        writer.println("<tr><td><b>Fullname</b></td>");
        writer.println("<td><b>E-mail</b></td>");
        writer.println("<td><b>Orientation</b></td>");
        writer.println("<td><b>Bachelor Thesis</b></td>");
        writer.println("<td><b>Starting Date</b></td>");
        writer.println("<td><b>Programming Language</b></td>");
        writer.println("<td><b>Tools</b></td>");
        writer.println("<td><b>Progress</b></td>");
        writer.println("<td><b>Meeting</b></td>");
        writer.println("<td><b>Project</b></td>");
        writer.println("<td><b>Grade</b></td></tr>");

        try {
            while (rs.next()) {
                writer.println("<tr><td>" + rs.getString("fullname") + "</td>");
                writer.println("<td>" + rs.getString("email") + "</td>");
                writer.println("<td>" + rs.getString("orientation") + "</td>");
                writer.println("<td>" + rs.getString("bsc_thesis") + "</td>");
                writer.println("<td>" + rs.getString("start_date") + "</td>");
                writer.println("<td>" + rs.getString("prog_languages") + "</td>");
                writer.println("<td>" + rs.getString("tools") + "</td>");
                writer.println("<td>" + rs.getString("progress") + "</td>");
                writer.println("<td>" + rs.getString("meeting") + "</td>");
                writer.println("<td>" + rs.getString("project") + "</td>");

                writer.println("<td><form><p id= 'grade'>"+ rs.getString("grade") + "</p></form></td></tr>");

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        writer.println("<td><b>Progress</b></td>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+ "/GradeSubmission");
        rd.forward(request,response);
        System.out.println(request.getParameter("changeGrade"));
    }



}