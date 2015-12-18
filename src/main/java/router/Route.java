package router;

import builders.Request;
import builders.Response;
import handlers.RequestHandler;

import java.io.IOException;
import java.util.regex.Pattern;

public class Route implements RequestHandler {
    private String path;
    private RequestHandler handler;

    public Route(String path, RequestHandler handler) {
        this.path = path;
        this.handler = handler;
    }

    public boolean match(String path) {
        return Pattern.matches(this.path, path);
    }

    @Override
    public Response handle(Request request) throws IOException {
        return handler.handle(request);
    }
}
