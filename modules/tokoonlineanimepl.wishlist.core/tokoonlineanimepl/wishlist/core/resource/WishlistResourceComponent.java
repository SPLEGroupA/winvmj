package tokoonlineanimepl.wishlist.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.wishlist.core.model.Wishlist;
//add other required packages

public abstract class WishlistResourceComponent implements WishlistResource{
	
	public WishlistResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveWishlist(VMJExchange vmjExchange);
    public abstract Wishlist createWishlist(VMJExchange vmjExchange);
	public abstract Wishlist createWishlist(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updateWishlist(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getWishlist(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllWishlist(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange);

}
