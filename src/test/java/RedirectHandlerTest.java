import builders.Request;
import builders.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertTrue;

public class RedirectHandlerTest {
    @Before
    public void setUp(){

    }

    @Test
    public void testReturns302statusLineLine() throws URISyntaxException, IOException {
        Request request = new Request("GET", new URI("/redirect"), "HTTP/1.1");

        Response response = new RedirectHandler("/").handle(request);

        assertTrue(response.statusLine.contains("302 Found"));
        assertTrue(response.headers.containsKey("Location"));
        assertTrue(response.headers.containsValue("http://localhost:5000/"));
    }
}

// Ditch empty setup
// key and value checks in test make hard dependency on hashmap datatype

// StatusLine enum might behoove you - rather than having special knowledge of what they should be
// located here in the test

// Also, can't really say why, but I'm pretty sure best practices dictate getting things via getter
// methods rather than via properties
// e.g.
// response.getStatusLine() v. response.statusLine

// RedirectHandler could probably be part of the core server
