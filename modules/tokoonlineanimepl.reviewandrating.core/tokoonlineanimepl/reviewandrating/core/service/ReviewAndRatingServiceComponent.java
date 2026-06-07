package tokoonlineanimepl.reviewandrating.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.reviewandrating.core.model.ReviewAndRating;
//add other required packages

public abstract class ReviewAndRatingServiceComponent implements ReviewAndRatingService{
	protected RepositoryUtil<ReviewAndRating> Repository;

    public ReviewAndRatingServiceComponent(){
        this.Repository = new RepositoryUtil<ReviewAndRating>(tokoonlineanimepl.reviewandrating.core.model.ReviewAndRatingComponent.class);
    }	

    public abstract ReviewAndRating createReviewAndRating(Map<String, Object> requestBody);
	public abstract ReviewAndRating createReviewAndRating(Map<String, Object> requestBody, UUID id);
	public abstract HashMap<String, Object> updateReviewAndRating(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReviewAndRating(String idStr);
    public abstract List<HashMap<String,Object>> getAllReviewAndRating();
    public abstract List<HashMap<String,Object>> getReviewAndRatingByCustomerEmail(String customerEmail);
    public abstract List<HashMap<String,Object>> getReviewAndRatingByProdukRef(String produkRef);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<ReviewAndRating> List);
    public abstract List<HashMap<String,Object>> deleteReviewAndRating(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReviewAndRatingById(UUID id);	

}
