package tokoonlineanimepl.reviewandrating.core.service;
import java.util.*;

import tokoonlineanimepl.reviewandrating.core.model.ReviewAndRating;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ReviewAndRatingService {
	ReviewAndRating createReviewAndRating(Map<String, Object> requestBody);
	HashMap<String, Object> getReviewAndRating(String idStr);
    HashMap<String, Object> updateReviewAndRating(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllReviewAndRating();
    List<HashMap<String,Object>> getReviewAndRatingByCustomerEmail(String customerEmail);
    List<HashMap<String,Object>> getReviewAndRatingByProdukRef(String produkRef);
    List<HashMap<String,Object>> deleteReviewAndRating(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<ReviewAndRating> List);
}
