package uk.co.autotrader.imageserver.rest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RestServlet extends HttpServlet {

    private HttpServletResponse response;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.response = response;
        String path = request.getPathInfo();
        System.out.println(path);
        if(path.equals("/")) {
            getIndex();
        } else {
            get404();
        }

    }

    private void get404() throws IOException {
        response.setContentType("application/json");
        response.setStatus(404);
        PrintWriter out = response.getWriter();
        out.print("{");
        out.print("response:{error:404 page not found}");
        out.print("}");
        out.close();
    }

    private void getIndex() throws IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        out.print("{");
        out.print("response:{success:index requested}");
        out.print("}");
        out.close();
    }

}
