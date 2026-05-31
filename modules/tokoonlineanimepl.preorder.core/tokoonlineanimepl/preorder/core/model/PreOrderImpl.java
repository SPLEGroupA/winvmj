package tokoonlineanimepl.preorder.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="preorder_impl")
@Table(name="preorder_impl")
public class PreOrderImpl extends PreOrderComponent {

	public PreOrderImpl(UUID id_preorder, String tanggal_preorder, String status_preorder, String produk_ref, String customer_email, String nama_pelanggan) {
		this.id_preorder = id_preorder;
		this.tanggal_preorder = tanggal_preorder;
		this.status_preorder = status_preorder;
		this.produk_ref = produk_ref;
		this.customer_email = customer_email;
		this.nama_pelanggan = nama_pelanggan;
	}

	public PreOrderImpl(String tanggal_preorder, String status_preorder, String produk_ref, String customer_email, String nama_pelanggan) {
		this.id_preorder =  UUID.randomUUID();
		this.tanggal_preorder = tanggal_preorder;
		this.status_preorder = status_preorder;
		this.produk_ref = produk_ref;
		this.customer_email = customer_email;
		this.nama_pelanggan = nama_pelanggan;
	}

	public PreOrderImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> preorderMap = new HashMap<String,Object>();
		preorderMap.put("id_preorder",getId_preorder());
		preorderMap.put("tanggal_preorder",getTanggal_preorder());
		preorderMap.put("status_preorder",getStatus_preorder());
		preorderMap.put("produk_ref",getProduk_ref());
		preorderMap.put("customer_email",getCustomer_email());
		preorderMap.put("nama_pelanggan",getNama_pelanggan());

        return preorderMap;
    }

}
