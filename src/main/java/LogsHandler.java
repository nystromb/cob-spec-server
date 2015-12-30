import builders.Request;
import builders.Response;
import handlers.ApplicationController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class LogsHandler extends ApplicationController {
    @Override
    protected Response get(Request request) throws IOException {
        byte[] logs = Files.readAllBytes(new File(System.getProperty("user.dir"), "/logs/logfile.txt").toPath());
        return new Response.Builder(200, logs).build();
    }
}

// Looks legit. Not sure yet what's happening behind the scenes to the logs being passed in the
// Builder constructor though.

// You might be able to get the contents of the logfile in a more terse way too - I don't remember
// having quite such a long line just to read from a file.
