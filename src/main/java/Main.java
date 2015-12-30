import configuration.Settings;
import handlers.Authorization;
import handlers.DirectoryHandler;
import handlers.FileHandler;
import router.Route;
import router.Router;
import server.HttpServer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static Logger logger = Logger.getLogger( "http.log" );

    public static void main(String[] args){
        Settings.parse(args);
        Settings.setUpLogger();
        addMyRoutes();
        try {
            HttpServer server = new HttpServer(Settings.PORT);
            logger.log(Level.INFO, "Server started on port " + Settings.PORT);
            logger.log(Level.INFO, "Serving files from " + Settings.PUBLIC_DIR);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addMyRoutes() {
        Router.addRoute(new Route("/", new DirectoryHandler()));

        Router.addRoute(new Route("/file1", new FileHandler()));

        Router.addRoute(new Route("/file2", new FileHandler()));

        Router.addRoute(new Route("/image.png", new FileHandler()));

        Router.addRoute(new Route("/image.jpeg", new FileHandler()));

        Router.addRoute(new Route("/image.gif", new FileHandler()));

        Router.addRoute(new Route("/text-file.txt", new FileHandler()));

        Router.addRoute(new Route("/partial_content.txt", new FileHandler()));

        Router.addRoute(new Route("/patch-content.txt", new FileHandler()));

        Router.addRoute(new Route("/logs", new Authorization("admin", "hunter2", "secret", new LogsHandler())));

        Router.addRoute(new Route("/form", new Resource()));

        Router.addRoute(new Route("/parameters", new ParameterHandler()));

        Router.addRoute(new Route("/method_options", new Resource()));

        Router.addRoute(new Route("/redirect", new RedirectHandler("/")));
    }
}

// Might want to handle an IOException differently - kind of surprised creating a HTTPServer could
// raise one. Or calling start on one. Might be better for those to handle IOExceptions closer to
// the actions that could actually throw them.

// Adding routes is nice and clean.

// Pretty easy to follow Main logic. Might want to extract logging into a small private method.
