import builders.Request;
import builders.Response;
import configuration.Settings;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class LogsHandlerTest {

    @Before
    public void setUp(){
        Settings.setUpLogger();
    }

    @Test
    public void testLogsHandler() throws IOException, URISyntaxException {
        LogsHandler handler = new LogsHandler();
        Request request = new Request("GET", new URI("/logs"), "HTTP/1.1");
        request.addHeader("Authorization", "Basic YWRtaW46aHVudGVyMg==");

        Response response = handler.handle(request);

        assertEquals("HTTP/1.1 200 OK", response.statusLine);
    }
}
