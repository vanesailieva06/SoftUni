package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiftFactoryTests {
    private GiftFactory giftFactory;
    private Gift gift;

    @Before
    public void setUp(){
        giftFactory = new GiftFactory();
        gift = new Gift("Present", 25);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftWithExistingGiftShouldThrow(){
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }

    @Test
    public void testCreateGiftWithValidElements(){
        giftFactory.createGift(gift);
        assertEquals(giftFactory.getCount(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithNullNameShouldThrow(){
        giftFactory.removeGift(null);
    }

    @Test
    public void testRemoveWithValidElements(){
        giftFactory.createGift(new Gift("Doll", 20));
        assertTrue(giftFactory.removeGift("Doll"));
        assertEquals(giftFactory.getCount(), 0);
    }

    @Test
    public void testGetPresentWithLeastMagic(){
        giftFactory.createGift(gift);
        giftFactory.createGift(new Gift("Car", 15));
        Gift presentWithLeastMagic = giftFactory.getPresentWithLeastMagic();
        assertEquals(presentWithLeastMagic.getType(), "Car");
    }

    @Test
    public void testGetPresent(){
        giftFactory.createGift(gift);
        giftFactory.createGift(new Gift("Car", 15));
        Gift present = giftFactory.getPresent("Present");
        assertEquals(present, gift);
    }

}
