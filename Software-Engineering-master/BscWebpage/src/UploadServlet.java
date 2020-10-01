import dbConn.UserrDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset+UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Part part = request.getPart("file");
            String id = (String) request.getParameter("id");
            String fileName = getSubmittedFileName(part);
            String path = getServletContext().getRealPath("/" + "files" + File.separator + fileName);
            InputStream is = part.getInputStream();
            boolean succs =uploadFile(is,path);
            if(succs){
                out.println(id + "File Uploaded to this Directory" +path);
                UserrDAO.Prog(id);


            }else{
                out.println("error");
            }
        }
    }
    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    public boolean uploadFile(InputStream is, String path) {
        boolean test = false;
        try {
            byte[] byt = new byte[is.available()];
            is.read();
            FileOutputStream fops = new FileOutputStream(path);
            fops.write(byt);
            fops.flush();
            fops.close();
            test = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}