
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = { "/LoginServlet" },
        initParams = {
                @WebInitParam(name = "user", value = "Shiwani"),
                @WebInitParam(name = "password", value = "Sonu@123")
        })

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        String namePattern = "^[A-Z][a-z]{2,}$";
        String passwordPattern="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";

        //get request parameters for userID and Password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        //get servlet config init params
        String userId=getServletConfig().getInitParameter("user");
        String password=getServletConfig().getInitParameter("password");
        if((userId.equals(user) && password.equals(pwd))&&Pattern.matches(namePattern,userId)&& Pattern.matches(passwordPattern,password)){
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSucess.jsp").forward(request,response);
        }
        else {
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out=response.getWriter();
            out.println("<font color=red> Either user name or password is wrong.</font>");
            rd.include(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        String namePattern = "^[A-Z][a-z]{2,}$";
        String passwordPattern="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";

        //get request parameters for userID and Password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        //get servlet config init params
        String userId=getServletConfig().getInitParameter("user");
        String password=getServletConfig().getInitParameter("password");
        if((userId.equals(user) && password.equals(pwd))&&Pattern.matches(namePattern,userId)&& Pattern.matches(passwordPattern,password)){
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSucess.jsp").forward(request,response);
        }
        else {
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out=response.getWriter();
            out.println("<font color=red> Either user name or password is wrong.</font>");
            rd.include(request,response);
        }

    }
}