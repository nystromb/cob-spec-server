import builders.Request;
import builders.Response;
import handlers.ApplicationController;

import java.io.IOException;

public class RedirectHandler extends ApplicationController {
    Response.Builder response = new Response.Builder(302);
    String redirectPath = "/";

    public RedirectHandler(String redirectPath) {
        this.redirectPath = redirectPath;
    }

    @Override
    public Response handle(Request request) throws IOException {
        response.addHeader("Location", "http://localhost:5000" + redirectPath);
        return response.build();
    }
}
