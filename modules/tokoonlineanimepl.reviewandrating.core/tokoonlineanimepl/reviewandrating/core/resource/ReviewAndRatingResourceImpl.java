package tokoonlineanimepl.reviewandrating.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.reviewandrating.core.model.ReviewAndRating;
import tokoonlineanimepl.reviewandrating.core.service.ReviewAndRatingServiceImpl;
//add other required packages


public class ReviewAndRatingResourceImpl extends ReviewAndRatingResourceComponent{
	
	private ReviewAndRatingServiceImpl reviewAndRatingServiceImpl = new ReviewAndRatingServiceImpl();

	
    @Route(url="call/reviewandrating/save")
    public List<HashMap<String,Object>> saveReviewAndRating(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		createReviewAndRating(vmjExchange);
		return reviewAndRatingServiceImpl.getAllReviewAndRating();
	}

	public ReviewAndRating createReviewAndRating(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewAndRating result = reviewAndRatingServiceImpl.createReviewAndRating(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public ReviewAndRating createReviewAndRating(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ReviewAndRating result = reviewAndRatingServiceImpl.createReviewAndRating(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/reviewandrating/update")
    public HashMap<String, Object> updateReviewAndRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reviewAndRatingServiceImpl.updateReviewAndRating(requestBody);
		
	}

	
    @Route(url="call/reviewandrating/detail")
    public HashMap<String, Object> getReviewAndRating(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_review");
		return reviewAndRatingServiceImpl.getReviewAndRating(idStr);
	}

	
    @Route(url="call/reviewandrating/list")
    public List<HashMap<String,Object>> getAllReviewAndRating(VMJExchange vmjExchange){
		String customerEmail = getOptionalGETParam(vmjExchange, "customer_email");
		String produkRef = getOptionalGETParam(vmjExchange, "produk_ref");
		if (produkRef != null && !produkRef.isBlank()) {
			return reviewAndRatingServiceImpl.getReviewAndRatingByProdukRef(produkRef);
		}
		if (customerEmail == null || customerEmail.isBlank()) {
			return reviewAndRatingServiceImpl.getAllReviewAndRating();
		}
		return reviewAndRatingServiceImpl.getReviewAndRatingByCustomerEmail(customerEmail);
	}

	private String getOptionalGETParam(VMJExchange vmjExchange, String key) {
		String query = vmjExchange.getHttpExchange().getRequestURI().getQuery();
		if (query == null || query.isBlank()) {
			return null;
		}
		for (String param : query.split("&")) {
			String[] pair = param.split("=", 2);
			if (pair.length == 2 && pair[0].equals(key)) {
				return pair[1];
			}
		}
		return null;
	}

	
    @Route(url="call/reviewandrating/delete")
    public List<HashMap<String,Object>> deleteReviewAndRating(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reviewAndRatingServiceImpl.deleteReviewAndRating(requestBody);
	}


}
