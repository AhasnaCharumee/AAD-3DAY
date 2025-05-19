package lk.ijse.gdse72;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("*.txt")
public class ExtensionMappingServlet extends HttpServlet {
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, java.io.IOException {

//        resp.getWriter().write("Extension Mapping");
        // How to get MIME type from http requests
        req.getContentType();
        //how to set mime type  for http response
        resp.setContentType("text/html");
        resp.getWriter().print("Extension Mapping");
    }
    //http://localhost:8080/Mapping_specification_Web_exploded/banu*.jsp it working
}
