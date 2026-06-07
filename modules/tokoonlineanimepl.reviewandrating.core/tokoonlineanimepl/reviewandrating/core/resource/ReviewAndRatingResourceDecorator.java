package tokoonlineanimepl.reviewandrating.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.reviewandrating.core.model.ReviewAndRating;

public abstract class ReviewAndRatingResourceDecorator extends ReviewAndRatingResourceComponent{
	protected ReviewAndRatingResourceComponent record;

    public ReviewAndRatingResourceDecorator(ReviewAndRatingResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveReviewAndRating(VMJExchange vmjExchange){
		return record.saveReviewAndRating(vmjExchange);
	}

    public ReviewAndRating createReviewAndRating(VMJExchange vmjExchange){
		return record.createReviewAndRating(vmjExchange);
	}
	
	public ReviewAndRating createReviewAndRating(VMJExchange vmjExchange, UUID id){
		return record.createReviewAndRating(vmjExchange, id);
	}

    public HashMap<String, Object> updateReviewAndRating(VMJExchange vmjExchange){
		return record.updateReviewAndRating(vmjExchange);
	}

    public HashMap<String, Object> getReviewAndRating(VMJExchange vmjExchange){
		return record.getReviewAndRating(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllReviewAndRating(VMJExchange vmjExchange){
		return record.getAllReviewAndRating(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteReviewAndRating(VMJExchange vmjExchange){
		return record.deleteReviewAndRating(vmjExchange);
	}

}
