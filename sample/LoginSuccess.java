import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginSuccess extends HttpServlet 
{
protected void doGet(HttpServletRequest req, HttpServletResponse res) 
throws ServletException,IOException
{
Cookie[] my_cookies=req.getCookies();
res.setContentType("text/html");
PrintWriter out = res.getWriter();
out.println("<b>");
String userName=null;
if(my_cookies !=null)
{
for(Cookie cookie:my_cookies)
{
if(cookie.getName().equals("CurrentUser"))
userName=cookie.getValue();
}
}
out.println("<h3>Login Success!!! Welcome</h3>");
out.println("<h2>This is a Shopping cart for :"+userName+"</h2>");
out.close();
}
}