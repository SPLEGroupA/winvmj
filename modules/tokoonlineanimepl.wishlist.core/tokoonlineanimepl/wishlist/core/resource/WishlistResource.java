package tokoonlineanimepl.wishlist.core.resource;
import java.util.*;

import tokoonlineanimepl.wishlist.core.model.Wishlist;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface WishlistResource {
    List<HashMap<String,Object>> saveWishlist(VMJExchange vmjExchange);
    HashMap<String, Object> updateWishlist(VMJExchange vmjExchange);
    HashMap<String, Object> getWishlist(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllWishlist(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange);
}
