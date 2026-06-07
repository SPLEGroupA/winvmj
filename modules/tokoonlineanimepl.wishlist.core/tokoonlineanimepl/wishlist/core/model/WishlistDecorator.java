package tokoonlineanimepl.wishlist.core.model;

import java.util.HashMap;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class WishlistDecorator extends WishlistComponent {
    @OneToOne(cascade=CascadeType.ALL)
	protected WishlistComponent record;

	public WishlistDecorator() {
		super();
		this.id_wishlist = UUID.randomUUID();
	}

	public WishlistDecorator(UUID id_wishlist, WishlistComponent record) {
		this.id_wishlist = id_wishlist;
		this.record = record;
	}
	
	public WishlistDecorator(WishlistComponent record, String objectName) {
		this.id_wishlist = UUID.randomUUID();
		this.record = record;
		this.objectName = objectName;
	}

	public UUID getId_wishlist() { return record.getId_wishlist(); }
	public void setId_wishlist(UUID id_wishlist) { record.setId_wishlist(id_wishlist); }
	public String getProduk_ref() { return record.getProduk_ref(); }
	public void setProduk_ref(String produk_ref) { record.setProduk_ref(produk_ref); }
	public String getCustomer_email() { return record.getCustomer_email(); }
	public void setCustomer_email(String customer_email) { record.setCustomer_email(customer_email); }
	public String getTanggal_ditambahkan() { return record.getTanggal_ditambahkan(); }
	public void setTanggal_ditambahkan(String tanggal_ditambahkan) { record.setTanggal_ditambahkan(tanggal_ditambahkan); }

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}
