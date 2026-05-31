package tokoonlineanimepl.katalogproduk.katalogprodukpreowned.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import tokoonlineanimepl.katalogproduk.core.service.KatalogProdukServiceDecorator;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProdukImpl;
import tokoonlineanimepl.katalogproduk.core.service.KatalogProdukServiceComponent;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProduk;
import tokoonlineanimepl.katalogproduk.core.model.KatalogProdukDecorator;
import tokoonlineanimepl.katalogproduk.KatalogProdukFactory;

public class KatalogProdukServiceImpl extends KatalogProdukServiceDecorator {
    public KatalogProdukServiceImpl (KatalogProdukServiceComponent record) {
        super(record);
    }

 	public KatalogProduk createKatalogProduk(Map<String, Object> requestBody){
		String kondisi = (String) requestBody.get("kondisi");
		String nama = (String) requestBody.get("nama");
		String hargaStr = (String) requestBody.get("harga");
		int harga = Integer.parseInt(hargaStr);
		String kategori = (String) requestBody.get("kategori");
		String deskripsi = (String) requestBody.get("deskripsi");
		String stokStr = (String) requestBody.get("stok");
		int stok = Integer.parseInt(stokStr);
		String gambar_url = (String) requestBody.get("gambar_url");
		KatalogProduk katalogprodukkatalogprodukpreowned = record.createKatalogProduk(requestBody);
		KatalogProduk katalogprodukkatalogprodukpreowneddeco = KatalogProdukFactory.createKatalogProduk("tokoonlineanimepl.katalogproduk.katalogprodukpreowned.model.KatalogProdukImpl", katalogprodukkatalogprodukpreowned, kondisi);
		Repository.saveObject(katalogprodukkatalogprodukpreowneddeco);
		return katalogprodukkatalogprodukpreowneddeco;
	}

    public KatalogProduk createKatalogProduk(Map<String, Object> requestBody, UUID id){	
		KatalogProduk savedKatalogProduk = Repository.getObject(id);
		String kondisi = (String) requestBody.get("kondisi");
		savedKatalogProduk.setNama((String) requestBody.get("nama"));
		savedKatalogProduk.setHarga(parseInteger(requestBody.get("harga")));
		savedKatalogProduk.setKategori((String) requestBody.get("kategori"));
		savedKatalogProduk.setDeskripsi((String) requestBody.get("deskripsi"));
		savedKatalogProduk.setStok(parseInteger(requestBody.get("stok")));
		savedKatalogProduk.setGambar_url((String) requestBody.get("gambar_url"));
		((tokoonlineanimepl.katalogproduk.katalogprodukpreowned.model.KatalogProdukImpl) savedKatalogProduk)
			.setKondisi(kondisi);
		return savedKatalogProduk;
	}

    public HashMap<String, Object> updateKatalogProduk(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_produk");
		UUID id = UUID.fromString(idStr);
		
		KatalogProduk katalogprodukkatalogprodukpreowned = Repository.getObject(id);
		katalogprodukkatalogprodukpreowned = createKatalogProduk(requestBody, id);
		
		Repository.updateObject(katalogprodukkatalogprodukpreowned);
		katalogprodukkatalogprodukpreowned = Repository.getObject(id);
		return katalogprodukkatalogprodukpreowned.toHashMap();
	}

	public HashMap<String, Object> getKatalogProduk(String idStr){
		UUID id = UUID.fromString(idStr);		
		KatalogProduk katalogprodukkatalogprodukpreowned = Repository.getObject(id);
		return katalogprodukkatalogprodukpreowned.toHashMap();
	}

	public HashMap<String, Object> getKatalogProdukById(UUID id){
		List<HashMap<String, Object>> katalogprodukList = getAllKatalogProduk();
		for (HashMap<String, Object> katalogproduk : katalogprodukList){
			UUID katalogproduk_id = UUID.fromString((String) katalogproduk.get("id_produk"));
			if (katalogproduk_id.equals(id)){
				return katalogproduk;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllKatalogProduk(){
		List<KatalogProduk> List = Repository.getAllObject("katalogproduk_katalogprodukpreowned");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<KatalogProduk> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteKatalogProduk(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_produk"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllKatalogProduk();
	}

	private int parseInteger(Object value) {
		if (value instanceof Number) {
			return ((Number) value).intValue();
		}
		return Integer.parseInt(value.toString());
	}

}
