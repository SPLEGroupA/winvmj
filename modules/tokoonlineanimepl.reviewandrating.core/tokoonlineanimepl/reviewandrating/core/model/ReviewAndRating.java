package tokoonlineanimepl.reviewandrating.core.model;

import java.util.HashMap;
import java.util.UUID;

public interface ReviewAndRating {
	public UUID getId_review();
	public void setId_review(UUID id_review);
	public String getProduk_ref();
	public void setProduk_ref(String produk_ref);
	public String getCustomer_email();
	public void setCustomer_email(String customer_email);
	public int getRating();
	public void setRating(int rating);
	public String getKomentar();
	public void setKomentar(String komentar);
	public String getTanggal_review();
	public void setTanggal_review(String tanggal_review);
	HashMap<String, Object> toHashMap();
}
