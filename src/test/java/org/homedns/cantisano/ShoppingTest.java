/**
 * @author Bruno Cardoso Cantisano
 */
package org.homedns.cantisano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		String result = shop.login(jsonData);
		assertEquals("Login inválido", result);
	}

	@Test
	public void testLoginOk() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\loginOk.json")));
		String result = shop.login(jsonData);
		assertEquals("Login realizado com sucesso", result);
	}

	@Test
	public void testAdd() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\add.json")));
		String result = shop.add(jsonData);
		assertEquals("Loja adicionada com sucesso!", result);
	}

	@Test
	public void testEdit() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\edit.json")));
		String result = shop.edit(jsonData);
		assertEquals("Loja editada com sucesso!", result);
	}

	@Test
	public void testDelete() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\add.json")));
		String result = shop.delete(jsonData);
		assertEquals("Loja removida com sucesso!", result);
	}

	@Test
	public void testList() {
		String result = shop.list();
		assertNotNull(result);
	}

	@Test
	public void testSearch() {
		String result = shop.search("americanas");
		assertNotNull(result);
	}

	@Test
	public void testDetails() throws IOException {
		String jsonData = new String(Files.readAllBytes(Paths.get("C:\\github\\RestfullShopping\\src\\main\\resources\\json\\loja.json")));
		String result = shop.details(jsonData);
		assertNotNull(result);
	}
}