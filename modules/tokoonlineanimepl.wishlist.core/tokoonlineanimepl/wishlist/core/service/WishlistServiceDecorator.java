package tokoonlineanimepl.wishlist.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.wishlist.core.model.Wishlist;

public abstract class WishlistServiceDecorator extends WishlistServiceComponent{
	protected WishlistServiceComponent record;

    public WishlistServiceDecorator(WishlistServiceComponent record) {
        this.record = record;
    }

	public Wishlist createWishlist(Map<String, Object> requestBody){
		return record.createWishlist(requestBody);
	}
	
    public Wishlist createWishlist(Map<String, Object> requestBody, UUID id){
		return record.createWishlist(requestBody, id);
	}

	public HashMap<String, Object> getWishlist(String idStr){
		return record.getWishlist(idStr);
	}

	public List<HashMap<String,Object>> getAllWishlist(){
		return record.getAllWishlist();
	}

	public List<HashMap<String,Object>> getWishlistByCustomerEmail(String customerEmail){
		return record.getWishlistByCustomerEmail(customerEmail);
	}

	public List<HashMap<String,Object>> getWishlistByProdukRef(String produkRef){
		return record.getWishlistByProdukRef(produkRef);
	}

    public HashMap<String, Object> updateWishlist(Map<String, Object> requestBody){
		return record.updateWishlist(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody){
		return record.deleteWishlist(requestBody);
	}

	public HashMap<String, Object> getWishlistById(UUID id){	
        return record.getWishlistById(id);
    }

}
