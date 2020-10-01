import dbConn.UserrDAO;
import mainPkg.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GradeSubmission")
public class GradeSubmission extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String am = (String) request.getParameter("am");
        String grade = (String) request.getParameter("newGrade");
        double newGrade = Double.parseDouble(grade);
        UserrDAO.submitGrade(newGrade,am);
        PrintWriter writer = response.getWriter();
        if (UserrDAO.submitGrade(newGrade,am) == 1){ writer.print("<script>alert('Grade submitted successfully!');window.history.back();</script>");}
        else { writer.print("<script>alert('Error in grade submission...');window.history.back();</script>");}


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}