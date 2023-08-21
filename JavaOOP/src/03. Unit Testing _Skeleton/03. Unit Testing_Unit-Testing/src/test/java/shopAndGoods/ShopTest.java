package shopAndGoods;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {
    private Shop shop;
    private Goods goods;

    @Before
    public void setUp() {
        shop = new Shop();
        goods = new Goods("Misho", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenThereIsNotShelfShouldBeThrowing() throws OperationNotSupportedException {
        shop.addGoods("Idk", goods);
    }
}