package tokoonlineanimepl.reviewandrating.core.model;

import java.util.HashMap;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class ReviewAndRatingDecorator extends ReviewAndRatingComponent {
    @OneToOne(cascade=CascadeType.ALL)
	protected ReviewAndRatingComponent record;

	public ReviewAndRatingDecorator() {
		super();
		this.id_review = UUID.randomUUID();
	}

	public ReviewAndRatingDecorator(UUID id_review, ReviewAndRatingComponent record) {
		this.id_review = id_review;
		this.record = record;
	}
	
	public ReviewAndRatingDecorator(ReviewAndRatingComponent record, String objectName) {
		this.id_review = UUID.randomUUID();
		this.record = record;
		this.objectName = objectName;
	}

	public UUID getId_review() { return record.getId_review(); }
	public void setId_review(UUID id_review) { record.setId_review(id_review); }
	public String getProduk_ref() { return record.getProduk_ref(); }
	public void setProduk_ref(String produk_ref) { record.setProduk_ref(produk_ref); }
	public String getCustomer_email() { return record.getCustomer_email(); }
	public void setCustomer_email(String customer_email) { record.setCustomer_email(customer_email); }
	public int getRating() { return record.getRating(); }
	public void setRating(int rating) { record.setRating(rating); }
	public String getKomentar() { return record.getKomentar(); }
	public void setKomentar(String komentar) { record.setKomentar(komentar); }
	public String getTanggal_review() { return record.getTanggal_review(); }
	public void setTanggal_review(String tanggal_review) { record.setTanggal_review(tanggal_review); }

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}
