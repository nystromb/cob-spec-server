package servertest;

import configuration.Settings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import router.Router;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SettingsTest {
    @Before
    public void setUp() throws IOException {
    }

    @After
    public void cleanUp() throws IOException {
        Settings.PUBLIC_DIR = System.getProperty("user.dir") + "/public/";
        Settings.PORT = 5000;
    }

    @Test
    public void testParseArgs(){
        Settings.parse(new String[] {"-p", "9009", "-d", "/"});

        assertTrue(Settings.PUBLIC_DIR == "/");
        assertTrue(Settings.PORT == 9009);
    }

	@Test
	public void testDefaultPortAndPublicDir() {
		assertEquals(5000, Settings.PORT);
        assertEquals(System.getProperty("user.dir") + "/public/", Settings.PUBLIC_DIR);
    }

    @Test
    public void testCreatesLogsDirectory(){
        Settings.setUpLogger();

        assertTrue(Files.exists(new File(System.getProperty("user.dir"), "/logs/").toPath()));
    }

    @Test
    public void testCreatesRoutes() throws URISyntaxException, IOException {
        createDirectories();
        Settings.createRoutes();

        assertTrue(Router.getRoute("/") != null);
        assertTrue(Router.getRoute("/file1") != null);
        assertTrue(Router.getRoute("/file2") != null);
        assertTrue(Router.getRoute("/text-file.txt") != null);
        assertTrue(Router.getRoute("/patch-content.txt") != null);
        assertTrue(Router.getRoute("/image.png") != null);
        assertTrue(Router.getRoute("/image.gif") != null);
        assertTrue(Router.getRoute("/partial_content.txt") != null);
        assertTrue(Router.getRoute("/image.jpeg") != null);
        deleteCreatedFiles();
    }

    private void createDirectories() throws IOException {
        File publicDir = new File(System.getProperty("user.dir"), "/public/");
        publicDir.mkdir();
        Files.createFile(new File(Settings.PUBLIC_DIR, "/file1").toPath());
        Files.createFile(new File(Settings.PUBLIC_DIR, "/file2").toPath());
        Files.createFile(new File(Settings.PUBLIC_DIR, "/text-file.txt").toPath());
        Files.createFile(new File(Settings.PUBLIC_DIR, "/image.png").toPath());
        Files.createFile(new File(Settings.PUBLIC_DIR, "/image.gif").toPath());
        Files.createFile(new File(Settings.PUBLIC_DIR, "/partial_content.txt").toPath());
        Files.createFile(new File(Settings.PUBLIC_DIR, "/patch-content.txt").toPath());
        Files.createFile(new File(Settings.PUBLIC_DIR, "/image.jpeg").toPath());
    }


    private void deleteCreatedFiles() throws IOException {
        Files.delete(new File(Settings.PUBLIC_DIR, "/file1").toPath());
        Files.delete(new File(Settings.PUBLIC_DIR, "/file2").toPath());
        Files.delete(new File(Settings.PUBLIC_DIR, "/text-file.txt").toPath());
        Files.delete(new File(Settings.PUBLIC_DIR, "/image.png").toPath());
        Files.delete(new File(Settings.PUBLIC_DIR, "/image.gif").toPath());
        Files.delete(new File(Settings.PUBLIC_DIR, "/partial_content.txt").toPath());
        Files.delete(new File(Settings.PUBLIC_DIR, "/patch-content.txt").toPath());
        Files.delete(new File(Settings.PUBLIC_DIR, "/image.jpeg").toPath());
    }
}