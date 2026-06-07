package tokoonlineanimepl.wishlist;

import tokoonlineanimepl.wishlist.core.service.WishlistService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class WishlistServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(WishlistServiceFactory.class.getName());

    public WishlistServiceFactory() {}

    public static WishlistService createWishlistService(String fullyQualifiedName, Object ... base) {
        WishlistService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (WishlistService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of WishlistService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to WishlistService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating WishlistService.");
            System.exit(50);
        }
        return record;
    }
}
