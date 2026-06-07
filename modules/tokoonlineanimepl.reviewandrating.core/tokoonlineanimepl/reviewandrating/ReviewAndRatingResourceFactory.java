package tokoonlineanimepl.reviewandrating;

import tokoonlineanimepl.reviewandrating.core.resource.ReviewAndRatingResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ReviewAndRatingResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(ReviewAndRatingResourceFactory.class.getName());

    public ReviewAndRatingResourceFactory() {}

    public static ReviewAndRatingResource createReviewAndRatingResource(String fullyQualifiedName, Object ... base) {
        ReviewAndRatingResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ReviewAndRatingResource) constructor.newInstance(base);
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of ReviewAndRatingResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to cast to ReviewAndRatingResource.");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Class not found: " + fullyQualifiedName);
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Unexpected error when creating ReviewAndRatingResource.");
            System.exit(50);
        }
        return record;
    }
}
