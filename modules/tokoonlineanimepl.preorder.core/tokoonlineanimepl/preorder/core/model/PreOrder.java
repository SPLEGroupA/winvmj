package tokoonlineanimepl.preorder.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface PreOrder {
	    public UUID getId_preorder();
	    public void setId_preorder(UUID id_preorder);
	    public String getTanggal_preorder();
	    public void setTanggal_preorder(String tanggal_preorder);
	    public String getStatus_preorder();
	    public void setStatus_preorder(String status_preorder);
	    public String getProduk_ref();
	    public void setProduk_ref(String produk_ref);
	    public int getQuantity();
	    public void setQuantity(int quantity);
	    public String getCustomer_email();
	    public void setCustomer_email(String customer_email);
	    public String getNama_pelanggan();
	    public void setNama_pelanggan(String nama_pelanggan);
	HashMap<String, Object> toHashMap();
}
