package org.daming.gwwf.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class AbstractHttpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String methodName = request.getParameter("method");
        boolean accessibleFlag = true;
        Method method = null;
        try {
            method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            accessibleFlag = method.isAccessible();
            method.setAccessible(true);
            method.invoke(this, request, response);
        } catch (Exception e) {
            response.sendError(404, "method: " + methodName + " is not found");
        } finally {
            method.setAccessible(accessibleFlag);
        }
    }
}
