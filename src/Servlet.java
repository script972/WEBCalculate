import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by script972 on 06.04.2017.
 */
@WebServlet(name = "Servlet", value = "/calculate")
public class Servlet extends HttpServlet {
    ArrayList <String>arrayList;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a=Double.parseDouble(request.getParameter("a").toString());
        double b=Double.parseDouble(request.getParameter("b").toString());
        String operator=request.getParameter("operation");
        HttpSession session=request.getSession(true);
        Operation oper= Operation.valueOf(operator.toUpperCase());
        double result=calucater(oper, a, b);
        response.getWriter().print(result);
        try {
            response.getWriter().print("okk");
            if (session.isNew()) {
                arrayList = new ArrayList();
            } else {
                arrayList = (ArrayList<String>) session.getAttribute("form");
            }
            arrayList.add(a + " " + oper.getValue() + " " + b + " = " + result);
            session.setAttribute("form", arrayList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e){
            System.out.println(e);
        }

    }

    private double calucater(Operation oper, double a, double b) {
        Calc calc = new Calc();
        switch (oper){
            case ADD:{
                return calc.add(a,b);

            }
            case MINUS:{
                return calc.minus(a,b);

            }
            case MULT: {
                return calc.mult(a, b);

            }
            case DIV: {
                return calc.div(a, b);

            }
        }
        return 0;
    }
}
