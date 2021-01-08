import mainPkg.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "StudentUtil")
public class StudentUtil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String am = request.getParameter("id");
        PrintWriter writer = response.getWriter();
        Student student = new Student(am,request.getParameter("password"));
        ResultSet rs = student.GetStudentsWork(am);

        writer.println("<!DOCTYPE html><html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\" />");
        writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
        writer.println("<title>UniPi-CS: Bcs Thesis Status</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class =\"w3-container\">");
        writer.println("<table class = \"w3-table w3-bordered\">");
        writer.println("<h1 id = 'am' style = 'font-family:Calibri;'>"+am+"</h1>");
        writer.println("<tr><td><b>Supervisor's Fullname</b></td>");
        writer.println("<td><b>Supervisor's E-mail</b></td>");
        writer.println("<td><b>Bachelor Thesis</b></td>");
        writer.println("<td><b>Starting Date</b></td>");
        writer.println("<td><b>Programming Language</b></td>");
        writer.println("<td><b>Tools</b></td>");
        writer.println("<td><b>Progress</b></td>");
        writer.println("<td><b>Meeting</b></td>");
        writer.println("<td><b>Grade</b></td></tr>");
        try {
            while (rs.next()) {
                writer.println("<tr><td>" + rs.getString("fullname") + "</td>");
                writer.println("<td>" + rs.getString("email") + "</td>");
                writer.println("<td>" + rs.getString("bsc_thesis") + "</td>");
                writer.println("<td>" + rs.getString("start_date") + "</td>");
                writer.println("<td>" + rs.getString("prog_languages") + "</td>");
                writer.println("<td>" + rs.getString("tools") + "</td>");
                writer.println("<td>" + rs.getString("progress") + "</td>");
                if(rs.getString("meeting")!= "-"){ writer.println("<td>" + rs.getString("meeting") + "</td>");}
                else{  writer.println("<td> None </td>");}
                writer.println("<td>" + rs.getString("grade") + "</td></tr>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</table>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}