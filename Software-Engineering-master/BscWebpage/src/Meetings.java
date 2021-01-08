import mainPkg.Meeting;
import mainPkg.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Meetings")
public class Meetings extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String am = (String) request.getParameter("am");
            String meeting = (String) request.getParameter("meeting");
            Meeting meeting1 = new Meeting(meeting);
            meeting1.ArrangeMeeting(meeting ,am);
            if (meeting1.ArrangeMeeting(meeting,am) == 1){ out.print("<script>alert('Meeting arranged successfully!');window.history.back();</script>");}
            else { out.print("<script>alert('Error in meeting arrangement...');window.history.back();</script>");}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}