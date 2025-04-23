package ru.netology.except1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldProductRemoveWhenExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "наушники", 3000);
        Product product2 = new Product(2, "принтер", 12000);
        Product product3 = new Product(3, "микрофон", 1200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldProductRemoveWhenNotExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "наушники", 3000);
        Product product2 = new Product(2, "принтер", 12000);
        Product product3 = new Product(3, "микрофон", 1200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(
                NotFoundException.class,
                () -> repo.remove(4654)
        );
    }

    @Test
    public void shouldGetProductTitle() {

        Product product = new Product(12, "машина", 12000);

        String expected = "машина";
        String actual = product.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetProductTitleEmptyString() {

        Product product = new Product(12, "", 12000);

        String expected = "";
        String actual = product.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetProductPrice() {

        Product product = new Product(12, "машина", 12000);

        int expected = 12000;
        int actual = product.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetTitleProduct() {
        Product product = new Product(12, "машина", 12000);

        product.setTitle("машина");

        Assertions.assertEquals("машина", product.getTitle());
    }

    @Test
    public void shouldSetPriceProduct() {
        Product product = new Product(12, "машина", 12000);

        product.setPrice(12000);

        Assertions.assertEquals(12000, product.getPrice());
    }

}
