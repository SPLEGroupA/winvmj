package tokoonlineanimepl.reviewandrating;

import tokoonlineanimepl.reviewandrating.core.service.ReviewAndRatingService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ReviewAndRatingServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(ReviewAndRatingServiceFactory.class.getName());

    public ReviewAndRatingServiceFactory() {}

    public static ReviewAndRatingService createReviewAndRatingService(String fullyQualifiedName, Object ... base) {
        ReviewAndRatingService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ReviewAndRatingService) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ReviewAndRatingService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ReviewAndRatingService.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ReviewAndRatingService.");
            System.exit(50);
        }
        return record;
    }
}
