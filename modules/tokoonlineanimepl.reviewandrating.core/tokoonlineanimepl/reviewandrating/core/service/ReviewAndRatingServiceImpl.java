package tokoonlineanimepl.reviewandrating.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import tokoonlineanimepl.reviewandrating.ReviewAndRatingFactory;
import tokoonlineanimepl.reviewandrating.core.model.ReviewAndRating;

public class ReviewAndRatingServiceImpl extends ReviewAndRatingServiceComponent {

    public ReviewAndRating createReviewAndRating(Map<String, Object> requestBody) {
		String produk_ref = (String) requestBody.get("produk_ref");
		String customer_email = (String) requestBody.get("customer_email");
		int rating = parseRating(requestBody.get("rating"));
		String komentar = (String) requestBody.get("komentar");
		String tanggal_review = (String) requestBody.get("tanggal_review");
		ReviewAndRating review = ReviewAndRatingFactory.createReviewAndRating(
			"tokoonlineanimepl.reviewandrating.core.model.ReviewAndRatingImpl",
			produk_ref, customer_email, rating, komentar, tanggal_review
		);
		Repository.saveObject(review);
		return review;
	}

    public ReviewAndRating createReviewAndRating(Map<String, Object> requestBody, UUID id) {
		String produk_ref = (String) requestBody.get("produk_ref");
		String customer_email = (String) requestBody.get("customer_email");
		int rating = parseRating(requestBody.get("rating"));
		String komentar = (String) requestBody.get("komentar");
		String tanggal_review = (String) requestBody.get("tanggal_review");
		ReviewAndRating review = ReviewAndRatingFactory.createReviewAndRating(
			"tokoonlineanimepl.reviewandrating.core.model.ReviewAndRatingImpl",
			id, produk_ref, customer_email, rating, komentar, tanggal_review
		);
		Repository.saveObject(review);
		return review;
	}

    public HashMap<String, Object> updateReviewAndRating(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id_review"));
		ReviewAndRating review = Repository.getObject(id);
		review.setProduk_ref((String) requestBody.get("produk_ref"));
		review.setCustomer_email((String) requestBody.get("customer_email"));
		review.setRating(parseRating(requestBody.get("rating")));
		review.setKomentar((String) requestBody.get("komentar"));
		review.setTanggal_review((String) requestBody.get("tanggal_review"));
		Repository.updateObject(review);
		return review.toHashMap();
	}

    public HashMap<String, Object> getReviewAndRating(String idStr) {
		UUID id = UUID.fromString(idStr);
		ReviewAndRating review = Repository.getObject(id);
		return review.toHashMap();
	}

	public HashMap<String, Object> getReviewAndRatingById(UUID id) {
		List<HashMap<String, Object>> reviewList = getAllReviewAndRating();
		for (HashMap<String, Object> review : reviewList) {
			UUID reviewId = (UUID) review.get("id_review");
			if (reviewId.equals(id)) {
				return review;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllReviewAndRating() {
		List<ReviewAndRating> list = Repository.getAllObject("reviewandrating_impl");
		return transformListToHashMap(list);
	}

    public List<HashMap<String,Object>> getReviewAndRatingByCustomerEmail(String customerEmail) {
		List<HashMap<String,Object>> filtered = new ArrayList<HashMap<String,Object>>();
		if (customerEmail == null) {
			return filtered;
		}
        for (HashMap<String,Object> review : getAllReviewAndRating()) {
			if (customerEmail.equals(review.get("customer_email"))) {
				filtered.add(review);
			}
        }
		return filtered;
	}

    public List<HashMap<String,Object>> getReviewAndRatingByProdukRef(String produkRef) {
		List<HashMap<String,Object>> filtered = new ArrayList<HashMap<String,Object>>();
		if (produkRef == null) {
			return filtered;
		}
        for (HashMap<String,Object> review : getAllReviewAndRating()) {
			if (produkRef.equals(review.get("produk_ref"))) {
				filtered.add(review);
			}
        }
		return filtered;
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ReviewAndRating> list) {
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for (int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }
        return resultList;
	}

    public List<HashMap<String,Object>> deleteReviewAndRating(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id_review"));
		Repository.deleteObject(id);
		return getAllReviewAndRating();
	}

	private int parseRating(Object value) {
		int rating;
		if (value instanceof Number) {
			rating = ((Number) value).intValue();
		} else {
			rating = Integer.parseInt((String) value);
		}
		if (rating < 1 || rating > 5) {
			throw new IllegalArgumentException("Rating harus berada pada rentang 1 sampai 5");
		}
		return rating;
	}
}
