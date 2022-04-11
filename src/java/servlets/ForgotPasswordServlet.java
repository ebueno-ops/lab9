package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author emman
 */
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String email = request.getParameter("email");

            AccountService as = new AccountService();
            String path = getServletContext().getRealPath("/WEB-INF");

            as.forgotPassword(email, path);

            HttpSession session = request.getSession();
            session.setAttribute("email", email);
     
            request.setAttribute("alert", 
                "If the address you entered is valid, you will receive an email very soon. Please check your email for your password.");
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

}
