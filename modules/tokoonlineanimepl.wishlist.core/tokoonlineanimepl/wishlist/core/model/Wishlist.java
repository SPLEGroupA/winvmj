package tokoonlineanimepl.wishlist.core.model;

import java.util.HashMap;
import java.util.UUID;

public interface Wishlist {
	public UUID getId_wishlist();
	public void setId_wishlist(UUID id_wishlist);
	public String getProduk_ref();
	public void setProduk_ref(String produk_ref);
	public String getCustomer_email();
	public void setCustomer_email(String customer_email);
	public String getTanggal_ditambahkan();
	public void setTanggal_ditambahkan(String tanggal_ditambahkan);
	HashMap<String, Object> toHashMap();
}
