import builders.Request;
import builders.Response;
import handlers.ApplicationController;

import java.io.IOException;

public class ParameterHandler extends ApplicationController {
    Response response;

    @Override
    public Response get(Request request) throws IOException {
        response = new Response.Builder(200, request.getQuery()).build();
        return response;
    }
}

// There seems to be no reason to say the get method throws IOException.
// No need to declare Response outside of get method. Better like so:

//public class ParameterHandler extends ApplicationController {
//
//    @Override
//    public Response get(Request request) {
//        return new Response.Builder(200, request.getQuery()).build();
//    }
//}
