import builders.Request;
import builders.Response;
import handlers.ApplicationController;

public class Resource extends ApplicationController {
    private Response.Builder response = new Response.Builder();
    private String data = "";

    @Override
    protected Response get(Request request) {
        return response.status(200).setBody(data).build();
    }

    @Override
    protected Response post(Request request) {
        data = request.getBody();
        return response.status(200).build();
    }

    @Override
    protected Response put(Request request) {
        data = request.getBody();
        return response.status(200).build();
    }

    @Override
    protected Response delete(Request request) {
        data = "";
        return response.status(200).build();
    }

    @Override
    protected Response options(Request request) {
        return response.status(200).addHeader("Allow", "GET,HEAD,POST,OPTIONS,PUT").build();
    }
}

// A lot of duplication. Better to extract the common stuff to a private method.

// Also, again, no need to declare Response.Builder outside of methods.

// Consider whether it's necessary for Resource to extend ApplicationController. Resources were
// their own distinct abstraction in my server. You could have handlers that use/interact with
// resources.

// You might not have this sort of duplication in that scenario.