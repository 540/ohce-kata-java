import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HelloWorldTest {

    @Test
    public void helloName() throws Exception {
        HelloWorld helloWorld = new HelloWorld();

        assertEquals("Hola Don Pepito", helloWorld.hello("Don Pepito"));
    }

    @Test
    public void helloName2() throws Exception {
        HelloWorld helloWorld = new HelloWorld();

        assertThat(helloWorld.hello("Don Jose"), is("Hola Don Jose"));
    }
}
