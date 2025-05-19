package lk.ijse.gdse72;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("")
public class EmptyStringMappingServlet extends HttpServlet {
    //match empty string url
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Empty String Mapping");

    }
    //http://localhost:8080/Mapping_specification_Web_exploded/    ---this is working
    //http://localhost:8080/Mapping_specification_Web_exploded/emptyStringMappingServlet  ---this is not working
}
