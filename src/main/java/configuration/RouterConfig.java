package configuration;

import handlers.DirectoryHandler;
import handlers.FileHandler;
import router.Route;
import router.Router;

import java.io.File;

public class RouterConfig {
    public static void setUpRoutes() {
        Router.addRoute(new Route("/", new DirectoryHandler()));
        File root = new File(Settings.PUBLIC_DIR);
        if(root.isDirectory()){
            addRoutesToRouter(root);
        }
    }

    private static void addRoutesToRouter(File directory) {
        File[] list = directory.listFiles();

        for(File file : list){
            if(file.isFile()){
                Router.addRoute(new Route("/" + file.getName(), new FileHandler()));
            }
        }
    }
}
