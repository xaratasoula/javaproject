package servlets;

import mainPkg.Supervisor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginCheck(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        Supervisor supervisor = new Supervisor.SuperBuilder("id","pass").build();
        int status = supervisor.login();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        if (status == 1) {
            out.println("<h1>Supervisor Login.</h1>");

            out.println("<form method = 'post' >" + "input type='submit' value='GetStudents' >"
                    + "</form>");

            out.println("<form action='mainPg.html'> <input type='submit' value='Logout' > </form>");

        } else if (status == 2) {
            out.println("<h1>ID - password missmatch.</h1>");

            out.println(
                    "<form action='mainPg.html'>" + "<input type= 'submit' value='Return home' />" + "</form>");
        } else{
            out.println("<h1>User does not exist.</h1>");

            out.println(
                    "<form action='mainPg.html'><input type='submit' value='Return home' /></form>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}

