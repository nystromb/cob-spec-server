import org.junit.Before;
import server.HttpServer;

import java.io.IOException;

public class HttpServerTest {
    private final int port = 5000;
    HttpServer server;

    @Before
    public void setUp() throws IOException{
        server = new HttpServer(port);
    }

}


