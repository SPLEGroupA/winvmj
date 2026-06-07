package tokoonlineanimepl.wishlist.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.wishlist.core.model.Wishlist;
import tokoonlineanimepl.wishlist.core.service.WishlistServiceImpl;
//add other required packages


public class WishlistResourceImpl extends WishlistResourceComponent{
	
	private WishlistServiceImpl wishlistServiceImpl = new WishlistServiceImpl();

	
    @Route(url="call/wishlist/save")
    public List<HashMap<String,Object>> saveWishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		createWishlist(vmjExchange);
		return wishlistServiceImpl.getAllWishlist();
	}

	public Wishlist createWishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Wishlist result = wishlistServiceImpl.createWishlist(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Wishlist createWishlist(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Wishlist result = wishlistServiceImpl.createWishlist(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/wishlist/update")
    public HashMap<String, Object> updateWishlist(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return wishlistServiceImpl.updateWishlist(requestBody);
		
	}

	
    @Route(url="call/wishlist/detail")
    public HashMap<String, Object> getWishlist(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_wishlist");
		return wishlistServiceImpl.getWishlist(idStr);
	}

	
    @Route(url="call/wishlist/list")
    public List<HashMap<String,Object>> getAllWishlist(VMJExchange vmjExchange){
		String customerEmail = getOptionalGETParam(vmjExchange, "customer_email");
		String produkRef = getOptionalGETParam(vmjExchange, "produk_ref");
		if (produkRef != null && !produkRef.isBlank()) {
			return wishlistServiceImpl.getWishlistByProdukRef(produkRef);
		}
		if (customerEmail == null || customerEmail.isBlank()) {
			return wishlistServiceImpl.getAllWishlist();
		}
		return wishlistServiceImpl.getWishlistByCustomerEmail(customerEmail);
	}

	private String getOptionalGETParam(VMJExchange vmjExchange, String key) {
		String query = vmjExchange.getHttpExchange().getRequestURI().getQuery();
		if (query == null || query.isBlank()) {
			return null;
		}
		for (String param : query.split("&")) {
			String[] pair = param.split("=", 2);
			if (pair.length == 2 && pair[0].equals(key)) {
				return pair[1];
			}
		}
		return null;
	}

	
    @Route(url="call/wishlist/delete")
    public List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return wishlistServiceImpl.deleteWishlist(requestBody);
	}


}
