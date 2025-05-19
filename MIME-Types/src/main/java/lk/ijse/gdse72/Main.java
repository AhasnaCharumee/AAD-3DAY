package lk.ijse.gdse72;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@WebServlet("/mine")
public class Main extends HttpServlet {
    // @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }



//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       String body = new BufferedReader(new InputStreamReader(req.getInputStream())).lines().collect(Collectors.joining("\n"));
//        resp.getWriter().println(body);
//    }


    //---- read x-www-form-urlencoded data form httpRequest body


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//     String name =   req.getParameter("name");
//     String address =   req.getParameter("address");
//
//     resp.setContentType("text/plain");
//     resp.getWriter().println("reciverd as x-www-form-urlencoded:\n Name "+name+"\nAddress "+address);
////     resp.getWriter().println(address);
//
//    }


    //---- read form data form httpRequest body


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name =  req.getParameter("name");
//        Part part = req.getPart("file");
//        String fileName = part.getSubmittedFileName();
//        resp.setContentType("text/plain");
//        resp.getWriter().println("reciverd as Multipart Form Data: "+name+" "+fileName);
//    }
//

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonArray = objectMapper.readTree(req.getReader());

        StringBuilder responseText = new StringBuilder("Received as JSON:\n");

        for (JsonNode jsonNode : jsonArray) {
            String name = jsonNode.has("name") ? jsonNode.get("name").asText() : "N/A";
            String address = jsonNode.has("address") ? jsonNode.get("address").asText() : "N/A";
            responseText.append("Name: ").append(name).append("\nAddress: ").append(address).append("\n");
        }

        resp.setContentType("text/plain");
        resp.getWriter().println(responseText.toString());
    }
}