package tokoonlineanimepl.wishlist.core.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="wishlist_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistComponent implements Wishlist {
	@Id
	protected UUID id_wishlist;
	protected String produk_ref;
	protected String customer_email;
	protected String tanggal_ditambahkan;
	protected String objectName = WishlistComponent.class.getName();

	public WishlistComponent() { }

	public WishlistComponent(UUID id_wishlist, String produk_ref, String customer_email, String tanggal_ditambahkan) {
		this.id_wishlist = id_wishlist;
		this.produk_ref = produk_ref;
		this.customer_email = customer_email;
		this.tanggal_ditambahkan = tanggal_ditambahkan;
	}

	public UUID getId_wishlist() { return this.id_wishlist; }
	public void setId_wishlist(UUID id_wishlist) { this.id_wishlist = id_wishlist; }
	public String getProduk_ref() { return this.produk_ref; }
	public void setProduk_ref(String produk_ref) { this.produk_ref = produk_ref; }
	public String getCustomer_email() { return this.customer_email; }
	public void setCustomer_email(String customer_email) { this.customer_email = customer_email; }
	public String getTanggal_ditambahkan() { return this.tanggal_ditambahkan; }
	public void setTanggal_ditambahkan(String tanggal_ditambahkan) { this.tanggal_ditambahkan = tanggal_ditambahkan; }
}
