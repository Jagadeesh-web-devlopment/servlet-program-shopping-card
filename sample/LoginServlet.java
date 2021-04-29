import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet 
{
protected void doPost(HttpServletRequest req, HttpServletResponse res) 
throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String usr=req.getParameter("User");
String pwd=req.getParameter("Password");
String card=req.getParameter("CardID");
boolean flag=true;

String[] userID=getInitParameter("usernames").split(",");
String[] password=getInitParameter("passwords").split(",");
String[] cardids=getInitParameter("cardIDs").split(",");
int i;
for(i=0;i<userID.length;i++)
{
if(userID[i].equals(usr)&& password[i].equals(pwd)&& cardids[i].equals(card))
{
flag=false;
Cookie MyCookie=new Cookie("CurrentUser",usr);
//setting cookie to expiry in 60 mins
MyCookie.setMaxAge(60*60);
res.addCookie(MyCookie);
res.sendRedirect("http://localhost:8080/sample/ex/LoginSuccess");
}
}
if(flag==true)
//invalid user name or passowrd
{
out.println("<h4>Invvalid user,Please try again by clcking folowing link</h4>");
out.println("<a href='LoginFrom.html'>"+"LoginFrom.html");
}
}
}