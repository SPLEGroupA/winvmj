module tokoonlineanime.product.anisecond {
    requires id.ac.ui.cs.prices.winvmj.auth;
    requires id.ac.ui.cs.prices.winvmj.auth.model;
    requires id.ac.ui.cs.prices.winvmj.core;
    requires id.ac.ui.cs.prices.winvmj.hibernate;
    requires org.slf4j;
    
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires jdk.unsupported;

    requires tokoonlineanimepl.katalogproduk.core;
    requires tokoonlineanimepl.katalogproduk.katalogprodukpreowned;
    requires tokoonlineanimepl.katalogproduk.reviewdanrating;
    requires tokoonlineanimepl.keranjangbelanja.core;
    requires tokoonlineanimepl.cartitem.core;
    requires tokoonlineanimepl.akunpengguna.core;
    requires tokoonlineanimepl.akunpengguna.sistempoinloyalitas;
    requires tokoonlineanimepl.pembayaran.core;
    requires tokoonlineanimepl.manajemenpesanan.core;
    requires tokoonlineanimepl.orderitem.core;
    requires tokoonlineanimepl.preorder.core;


}