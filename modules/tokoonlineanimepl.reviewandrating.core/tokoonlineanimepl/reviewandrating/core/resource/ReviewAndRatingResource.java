package tokoonlineanimepl.reviewandrating.core.resource;
import java.util.*;

import tokoonlineanimepl.reviewandrating.core.model.ReviewAndRating;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ReviewAndRatingResource {
    List<HashMap<String,Object>> saveReviewAndRating(VMJExchange vmjExchange);
    HashMap<String, Object> updateReviewAndRating(VMJExchange vmjExchange);
    HashMap<String, Object> getReviewAndRating(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReviewAndRating(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReviewAndRating(VMJExchange vmjExchange);
}
