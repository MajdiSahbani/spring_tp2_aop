package test.resources;

import org.junit.Assert;
import org.junit.Test;

import com.esprit.bootstap.Main;

public class TestApp2 {
	@Test
	public void testPrintHelloWorld2() {

		Assert.assertEquals(Main.getHelloWorld2(), "Hello World 2");

	}
}
