package test.resources;

import org.junit.Assert;
import org.junit.Test;

import com.esprit.bootstap.Main;

public class TestApp1 {
	@Test
	public void testPrintHelloWorld() {

		Assert.assertEquals(Main.getHelloWorld(), "Hello World");

	}

}
