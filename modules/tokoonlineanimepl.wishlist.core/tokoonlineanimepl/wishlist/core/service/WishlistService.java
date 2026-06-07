package tokoonlineanimepl.wishlist.core.service;
import java.util.*;

import tokoonlineanimepl.wishlist.core.model.Wishlist;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface WishlistService {
	Wishlist createWishlist(Map<String, Object> requestBody);
	HashMap<String, Object> getWishlist(String idStr);
    HashMap<String, Object> updateWishlist(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllWishlist();
    List<HashMap<String,Object>> getWishlistByCustomerEmail(String customerEmail);
    List<HashMap<String,Object>> getWishlistByProdukRef(String produkRef);
    List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Wishlist> List);
}
