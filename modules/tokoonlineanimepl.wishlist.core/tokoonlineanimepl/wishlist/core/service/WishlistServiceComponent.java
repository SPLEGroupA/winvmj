package tokoonlineanimepl.wishlist.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.wishlist.core.model.Wishlist;
//add other required packages

public abstract class WishlistServiceComponent implements WishlistService{
	protected RepositoryUtil<Wishlist> Repository;

    public WishlistServiceComponent(){
        this.Repository = new RepositoryUtil<Wishlist>(tokoonlineanimepl.wishlist.core.model.WishlistComponent.class);
    }	

    public abstract Wishlist createWishlist(Map<String, Object> requestBody);
	public abstract Wishlist createWishlist(Map<String, Object> requestBody, UUID id);
	public abstract HashMap<String, Object> updateWishlist(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getWishlist(String idStr);
    public abstract List<HashMap<String,Object>> getAllWishlist();
    public abstract List<HashMap<String,Object>> getWishlistByCustomerEmail(String customerEmail);
    public abstract List<HashMap<String,Object>> getWishlistByProdukRef(String produkRef);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> List);
    public abstract List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getWishlistById(UUID id);	

}
