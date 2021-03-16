package org.geektimes.projects.user.web.controller;

import org.geektimes.configuration.microprofile.config.JavaConfig;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 输出 “Hello,World” Controller
 */
@Path("/hello")
public class HelloWorldController implements PageController {

    private final JavaConfig javaConfig = new JavaConfig();

    @GET
    @POST
    @Path("/world") // /hello/world -> HelloWorldController
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        request.setAttribute("myapp", javaConfig.getValue("application.name", String.class));

        return "index.jsp";
    }
}
