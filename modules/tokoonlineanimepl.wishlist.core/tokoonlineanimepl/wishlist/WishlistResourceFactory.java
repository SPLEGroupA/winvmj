package tokoonlineanimepl.wishlist;

import tokoonlineanimepl.wishlist.core.resource.WishlistResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class WishlistResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(WishlistResourceFactory.class.getName());

    public WishlistResourceFactory() {}

    public static WishlistResource createWishlistResource(String fullyQualifiedName, Object ... base) {
        WishlistResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (WishlistResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of WishlistResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to WishlistResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating WishlistResource.");
            System.exit(50);
        }
        return record;
    }
}
