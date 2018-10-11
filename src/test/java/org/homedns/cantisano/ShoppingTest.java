/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShoppingTest {
	private static IShopping shop;

	@BeforeClass
	public static void initShopping() {
		shop = new ShoppingService();
	}

	@Before
	public void beforeEachTest() {
		System.out.println("This is executed before each Test");		
	}

	@After
	public void afterEachTest() {
		System.out.println("This is exceuted after each Test");
	}

	@Test
	public void testLoginFailed() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\loginInvalido.json")));
		Response result = shop.login(jsonData);
		assertEquals(ResponseMessage.RET_ERROR, result.getStatus());
	}

	@Test
	public void testLoginOk() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\loginOk.json")));
		Response result = shop.login(jsonData);
		assertEquals(ResponseMessage.RET_OK, result.getStatus());
	}

	@Test
	public void testAdd() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\add.json")));
		Response result = shop.add(jsonData);
		assertEquals(ResponseMessage.RET_OK, result.getStatus());
	}

	@Test
	public void testEdit() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\edit.json")));
		Response result = shop.edit(jsonData);
		assertEquals(ResponseMessage.RET_OK, result.getStatus());
	}

	@Test
	public void testDelete() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\add.json")));
		Response result = shop.delete(jsonData);
		assertEquals(ResponseMessage.RET_OK, result.getStatus());
	}

	@Test
	public void testList() {
		Response result = shop.list();
		assertEquals(ResponseMessage.RET_OK, result.getStatus());
	}

	@Test
	public void testSearch() {
		Response result = shop.search("americanas");
		assertEquals(ResponseMessage.RET_OK, result.getStatus());
	}

	@Test
	public void testDetails() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\loja.json")));
		Response result = shop.details(jsonData);
		assertEquals(ResponseMessage.RET_OK, result.getStatus());
	}
}