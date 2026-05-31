package tokoonlineanimepl.preorder.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="preorder_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PreOrderComponent implements PreOrder{
	@Id
	protected UUID id_preorder; 
	protected String tanggal_preorder;
	protected String status_preorder;
	protected String produk_ref;
	protected int quantity;
	protected String customer_email;
	protected String nama_pelanggan;
	protected String objectName = PreOrderComponent.class.getName();

	public PreOrderComponent() {

	} 

	public PreOrderComponent(
        UUID id_preorder, String tanggal_preorder, String status_preorder, String produk_ref, int quantity, String customer_email, String nama_pelanggan
    ) {
        this.id_preorder = id_preorder;
        this.tanggal_preorder = tanggal_preorder;
        this.status_preorder = status_preorder;
        this.produk_ref = produk_ref;
        this.quantity = quantity;
        this.customer_email = customer_email;
        this.nama_pelanggan = nama_pelanggan;
    }

	public UUID getId_preorder() {
		return this.id_preorder;
	}

	public void setId_preorder(UUID id_preorder) {
		this.id_preorder = id_preorder;
	}
	public String getTanggal_preorder() {
		return this.tanggal_preorder;
	}

	public void setTanggal_preorder(String tanggal_preorder) {
		this.tanggal_preorder = tanggal_preorder;
	}
	public String getStatus_preorder() {
		return this.status_preorder;
	}

	public void setStatus_preorder(String status_preorder) {
		this.status_preorder = status_preorder;
	}
	public String getProduk_ref() {
		return this.produk_ref;
	}

	public void setProduk_ref(String produk_ref) {
		this.produk_ref = produk_ref;
	}
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCustomer_email() {
		return this.customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getNama_pelanggan() {
		return this.nama_pelanggan;
	}

	public void setNama_pelanggan(String nama_pelanggan) {
		this.nama_pelanggan = nama_pelanggan;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id_preorder='" + getId_preorder() + "'" +
            " tanggal_preorder='" + getTanggal_preorder() + "'" +
            " status_preorder='" + getStatus_preorder() + "'" +
            " produk_ref='" + getProduk_ref() + "'" +
            " quantity='" + getQuantity() + "'" +
            " customer_email='" + getCustomer_email() + "'" +
            " nama_pelanggan='" + getNama_pelanggan() + "'" +
            "}";
    }
	
}
