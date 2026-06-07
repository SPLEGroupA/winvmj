package tokoonlineanimepl.wishlist.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import tokoonlineanimepl.wishlist.WishlistFactory;
import tokoonlineanimepl.wishlist.core.model.Wishlist;

public class WishlistServiceImpl extends WishlistServiceComponent {

    public Wishlist createWishlist(Map<String, Object> requestBody) {
		String produk_ref = (String) requestBody.get("produk_ref");
		String customer_email = (String) requestBody.get("customer_email");
		String tanggal_ditambahkan = (String) requestBody.get("tanggal_ditambahkan");
		Wishlist wishlist = WishlistFactory.createWishlist(
			"tokoonlineanimepl.wishlist.core.model.WishlistImpl",
			produk_ref, customer_email, tanggal_ditambahkan
		);
		Repository.saveObject(wishlist);
		return wishlist;
	}

    public Wishlist createWishlist(Map<String, Object> requestBody, UUID id) {
		String produk_ref = (String) requestBody.get("produk_ref");
		String customer_email = (String) requestBody.get("customer_email");
		String tanggal_ditambahkan = (String) requestBody.get("tanggal_ditambahkan");
		Wishlist wishlist = WishlistFactory.createWishlist(
			"tokoonlineanimepl.wishlist.core.model.WishlistImpl",
			id, produk_ref, customer_email, tanggal_ditambahkan
		);
		Repository.saveObject(wishlist);
		return wishlist;
	}

    public HashMap<String, Object> updateWishlist(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id_wishlist"));
		Wishlist wishlist = Repository.getObject(id);
		wishlist.setProduk_ref((String) requestBody.get("produk_ref"));
		wishlist.setCustomer_email((String) requestBody.get("customer_email"));
		wishlist.setTanggal_ditambahkan((String) requestBody.get("tanggal_ditambahkan"));
		Repository.updateObject(wishlist);
		return wishlist.toHashMap();
	}

    public HashMap<String, Object> getWishlist(String idStr) {
		UUID id = UUID.fromString(idStr);
		Wishlist wishlist = Repository.getObject(id);
		return wishlist.toHashMap();
	}

	public HashMap<String, Object> getWishlistById(UUID id) {
		List<HashMap<String, Object>> wishlistList = getAllWishlist();
		for (HashMap<String, Object> wishlist : wishlistList) {
			UUID wishlistId = (UUID) wishlist.get("id_wishlist");
			if (wishlistId.equals(id)) {
				return wishlist;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllWishlist() {
		List<Wishlist> list = Repository.getAllObject("wishlist_impl");
		return transformListToHashMap(list);
	}

    public List<HashMap<String,Object>> getWishlistByCustomerEmail(String customerEmail) {
		List<HashMap<String,Object>> filtered = new ArrayList<HashMap<String,Object>>();
		if (customerEmail == null) {
			return filtered;
		}
        for (HashMap<String,Object> wishlist : getAllWishlist()) {
			if (customerEmail.equals(wishlist.get("customer_email"))) {
				filtered.add(wishlist);
			}
        }
		return filtered;
	}

    public List<HashMap<String,Object>> getWishlistByProdukRef(String produkRef) {
		List<HashMap<String,Object>> filtered = new ArrayList<HashMap<String,Object>>();
		if (produkRef == null) {
			return filtered;
		}
        for (HashMap<String,Object> wishlist : getAllWishlist()) {
			if (produkRef.equals(wishlist.get("produk_ref"))) {
				filtered.add(wishlist);
			}
        }
		return filtered;
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> list) {
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for (int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }
        return resultList;
	}

    public List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody) {
		UUID id = UUID.fromString((String) requestBody.get("id_wishlist"));
		Repository.deleteObject(id);
		return getAllWishlist();
	}
}
