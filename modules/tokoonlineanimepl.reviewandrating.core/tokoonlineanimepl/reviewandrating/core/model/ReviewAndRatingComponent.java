package tokoonlineanimepl.reviewandrating.core.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="reviewandrating_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReviewAndRatingComponent implements ReviewAndRating {
	@Id
	protected UUID id_review;
	protected String produk_ref;
	protected String customer_email;
	protected int rating;
	protected String komentar;
	protected String tanggal_review;
	protected String objectName = ReviewAndRatingComponent.class.getName();

	public ReviewAndRatingComponent() { }

	public ReviewAndRatingComponent(UUID id_review, String produk_ref, String customer_email, int rating, String komentar, String tanggal_review) {
		this.id_review = id_review;
		this.produk_ref = produk_ref;
		this.customer_email = customer_email;
		this.rating = rating;
		this.komentar = komentar;
		this.tanggal_review = tanggal_review;
	}

	public UUID getId_review() { return this.id_review; }
	public void setId_review(UUID id_review) { this.id_review = id_review; }
	public String getProduk_ref() { return this.produk_ref; }
	public void setProduk_ref(String produk_ref) { this.produk_ref = produk_ref; }
	public String getCustomer_email() { return this.customer_email; }
	public void setCustomer_email(String customer_email) { this.customer_email = customer_email; }
	public int getRating() { return this.rating; }
	public void setRating(int rating) { this.rating = rating; }
	public String getKomentar() { return this.komentar; }
	public void setKomentar(String komentar) { this.komentar = komentar; }
	public String getTanggal_review() { return this.tanggal_review; }
	public void setTanggal_review(String tanggal_review) { this.tanggal_review = tanggal_review; }
}
