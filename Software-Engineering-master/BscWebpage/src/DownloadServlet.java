import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    private final long serialVersionVID = 1L;
    public void init() throws ServletException
    {
        System.out.println("--------------------------");
        System.out.println("Init method is called in" +this.getClass().getName());
        System.out.println("--------------------------");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


                }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String filename = "ergasiaaa.docx";
        String filepath = "C:\\Users\\xarat\\Downloads\\Software-Engineering-master (1)\\out\\artifacts\\BscWebpage_Web_exploded";
        response.setContentType("APPLICATION STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        FileInputStream fileInputStream = new FileInputStream(filepath + filename);
        int i;
        while ((i = fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }
        public void destroy()
        {
            System.out.println("--------------------------");
            System.out.println("destroy method is called in" +this.getClass().getName());
            System.out.println("--------------------------");
        }

    }


