package tokoonlineanimepl.reviewandrating.core.model;

import java.util.HashMap;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="reviewandrating_impl")
@Table(name="reviewandrating_impl")
public class ReviewAndRatingImpl extends ReviewAndRatingComponent {
	public ReviewAndRatingImpl(UUID id_review, String produk_ref, String customer_email, int rating, String komentar, String tanggal_review) {
		super(id_review, produk_ref, customer_email, rating, komentar, tanggal_review);
	}

	public ReviewAndRatingImpl(String produk_ref, String customer_email, int rating, String komentar, String tanggal_review) {
		super(UUID.randomUUID(), produk_ref, customer_email, rating, komentar, tanggal_review);
	}

	public ReviewAndRatingImpl() { }

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> reviewMap = new HashMap<String, Object>();
		reviewMap.put("id_review", getId_review());
		reviewMap.put("produk_ref", getProduk_ref());
		reviewMap.put("customer_email", getCustomer_email());
		reviewMap.put("rating", getRating());
		reviewMap.put("komentar", getKomentar());
		reviewMap.put("tanggal_review", getTanggal_review());
		return reviewMap;
	}
}
