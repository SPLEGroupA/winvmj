package tokoonlineanimepl.preorder.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PreOrderDecorator extends PreOrderComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PreOrderComponent record;

	public PreOrderDecorator () {
		super();
		this.id_preorder =  UUID.randomUUID();
	}

	public PreOrderDecorator (UUID id_preorder, PreOrderComponent record) {
		this.id_preorder =  id_preorder;
		this.record = record;
	}
	
	public PreOrderDecorator (PreOrderComponent record, String objectName) {
		this.id_preorder =  UUID.randomUUID();
		this.record = record;
		this.objectName=objectName;
	}


	public UUID getId_preorder() {
		return record.getId_preorder();
	}
	public void setId_preorder(UUID id_preorder) {
		record.setId_preorder(id_preorder);
	}
	public String getTanggal_preorder() {
		return record.getTanggal_preorder();
	}
	public void setTanggal_preorder(String tanggal_preorder) {
		record.setTanggal_preorder(tanggal_preorder);
	}
	public String getStatus_preorder() {
		return record.getStatus_preorder();
	}
	public void setStatus_preorder(String status_preorder) {
		record.setStatus_preorder(status_preorder);
	}
	public String getProduk_ref() {
		return record.getProduk_ref();
	}
	public void setProduk_ref(String produk_ref) {
		record.setProduk_ref(produk_ref);
	}
	public int getQuantity() {
		return record.getQuantity();
	}
	public void setQuantity(int quantity) {
		record.setQuantity(quantity);
	}
	public String getCustomer_email() {
		return record.getCustomer_email();
	}
	public void setCustomer_email(String customer_email) {
		record.setCustomer_email(customer_email);
	}
	public String getNama_pelanggan() {
		return record.getNama_pelanggan();
	}
	public void setNama_pelanggan(String nama_pelanggan) {
		record.setNama_pelanggan(nama_pelanggan);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
