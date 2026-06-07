package tokoonlineanimepl.wishlist.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import tokoonlineanimepl.wishlist.core.model.Wishlist;

public abstract class WishlistResourceDecorator extends WishlistResourceComponent{
	protected WishlistResourceComponent record;

    public WishlistResourceDecorator(WishlistResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveWishlist(VMJExchange vmjExchange){
		return record.saveWishlist(vmjExchange);
	}

    public Wishlist createWishlist(VMJExchange vmjExchange){
		return record.createWishlist(vmjExchange);
	}
	
	public Wishlist createWishlist(VMJExchange vmjExchange, UUID id){
		return record.createWishlist(vmjExchange, id);
	}

    public HashMap<String, Object> updateWishlist(VMJExchange vmjExchange){
		return record.updateWishlist(vmjExchange);
	}

    public HashMap<String, Object> getWishlist(VMJExchange vmjExchange){
		return record.getWishlist(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllWishlist(VMJExchange vmjExchange){
		return record.getAllWishlist(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange){
		return record.deleteWishlist(vmjExchange);
	}

}
