package tokoonlineanimepl.reviewandrating.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.reviewandrating.core.model.ReviewAndRating;
//add other required packages

public abstract class ReviewAndRatingResourceComponent implements ReviewAndRatingResource{
	
	public ReviewAndRatingResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveReviewAndRating(VMJExchange vmjExchange);
    public abstract ReviewAndRating createReviewAndRating(VMJExchange vmjExchange);
	public abstract ReviewAndRating createReviewAndRating(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updateReviewAndRating(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReviewAndRating(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReviewAndRating(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReviewAndRating(VMJExchange vmjExchange);

}
