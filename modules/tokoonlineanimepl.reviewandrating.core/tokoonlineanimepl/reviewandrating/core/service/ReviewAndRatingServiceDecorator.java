package tokoonlineanimepl.reviewandrating.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.reviewandrating.core.model.ReviewAndRating;

public abstract class ReviewAndRatingServiceDecorator extends ReviewAndRatingServiceComponent{
	protected ReviewAndRatingServiceComponent record;

    public ReviewAndRatingServiceDecorator(ReviewAndRatingServiceComponent record) {
        this.record = record;
    }

	public ReviewAndRating createReviewAndRating(Map<String, Object> requestBody){
		return record.createReviewAndRating(requestBody);
	}
	
    public ReviewAndRating createReviewAndRating(Map<String, Object> requestBody, UUID id){
		return record.createReviewAndRating(requestBody, id);
	}

	public HashMap<String, Object> getReviewAndRating(String idStr){
		return record.getReviewAndRating(idStr);
	}

	public List<HashMap<String,Object>> getAllReviewAndRating(){
		return record.getAllReviewAndRating();
	}

	public List<HashMap<String,Object>> getReviewAndRatingByCustomerEmail(String customerEmail){
		return record.getReviewAndRatingByCustomerEmail(customerEmail);
	}

	public List<HashMap<String,Object>> getReviewAndRatingByProdukRef(String produkRef){
		return record.getReviewAndRatingByProdukRef(produkRef);
	}

    public HashMap<String, Object> updateReviewAndRating(Map<String, Object> requestBody){
		return record.updateReviewAndRating(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ReviewAndRating> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteReviewAndRating(Map<String, Object> requestBody){
		return record.deleteReviewAndRating(requestBody);
	}

	public HashMap<String, Object> getReviewAndRatingById(UUID id){	
        return record.getReviewAndRatingById(id);
    }

}
