package handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jetty_db.DBCon;
import jetty_db.Product;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

//http://localhost:8080/?get=
public final class Handlers extends AbstractHandler {


    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        baseRequest.setHandled(true);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public static HandlerCollection getHandlers() throws Exception {
        HandlerCollection handlerCollection = new HandlerCollection();

        getAllProducts getAllProducts = new getAllProducts();
        postNewProduct postNewProduct = new postNewProduct();

        ContextHandler context = new ContextHandler();
        ContextHandler postContext = new ContextHandler();

        postContext.setContextPath("/postProduct");
        context.setContextPath("/getProduct");

        context.setHandler(getAllProducts);
        postContext.setHandler(postNewProduct);
        handlerCollection.addHandler(context);
        handlerCollection.addHandler(postContext);
        return handlerCollection;
    }

    public static class getAllProducts extends AbstractHandler {

        @Override
        public void handle(String target,
                           Request baseRequest,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

            var params = request.getParameterMap();
            DBCon dbCon = new DBCon();
            try {
                if (params.containsKey("get")) {
                    response.setContentType("text/html");
                    response.getWriter().println(dbCon.getProductsName());
                } else {
                    response.setContentType("text/html");
                    response.getWriter().print("type ?get= in search bar in order to get products name list");
                }
                baseRequest.setHandled(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static class postNewProduct extends AbstractHandler {

        @Override
        public void handle(String target,
                           Request baseRequest,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

            var params = request.getParameterMap();
            DBCon dbCon = new DBCon();
            try {
                if (params.containsKey("post")) {
                    try {
                        response.setContentType("text/html");
                        response.getWriter().println(params);
                        System.out.println();
                        String[] inputParams = Arrays.toString(Arrays.stream(params.get("post")).
                                toArray()).
                                replaceAll("[\\[\\]]","").
                                split(",");
                        Product prod = new Product(Integer.parseInt(inputParams[0]),
                                inputParams[1],
                                inputParams[2],
                                Integer.parseInt(inputParams[3]));
                        dbCon.addNewProduct(prod);
                    }catch (NumberFormatException t){
                        t.printStackTrace();
                    }
                } else {
                    response.setContentType("text/html");
                    response.getWriter().print("type ?post= *some int*, *some string*, " +
                            "*some string*, *some int* in search bar in order to add new Product. " +
                            "Make sure ID is unique!");
                }
                baseRequest.setHandled(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
