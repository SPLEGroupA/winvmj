package tokoonlineanimepl.wishlist.core.model;

import java.util.HashMap;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="wishlist_impl")
@Table(name="wishlist_impl")
public class WishlistImpl extends WishlistComponent {
	public WishlistImpl(UUID id_wishlist, String produk_ref, String customer_email, String tanggal_ditambahkan) {
		super(id_wishlist, produk_ref, customer_email, tanggal_ditambahkan);
	}

	public WishlistImpl(String produk_ref, String customer_email, String tanggal_ditambahkan) {
		super(UUID.randomUUID(), produk_ref, customer_email, tanggal_ditambahkan);
	}

	public WishlistImpl() { }

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> wishlistMap = new HashMap<String, Object>();
		wishlistMap.put("id_wishlist", getId_wishlist());
		wishlistMap.put("produk_ref", getProduk_ref());
		wishlistMap.put("customer_email", getCustomer_email());
		wishlistMap.put("tanggal_ditambahkan", getTanggal_ditambahkan());
		return wishlistMap;
	}
}
