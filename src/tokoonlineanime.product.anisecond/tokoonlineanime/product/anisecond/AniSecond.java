package tokoonlineanime.product.anisecond;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.ac.ui.cs.prices.winvmj.core.VMJCors;
import id.ac.ui.cs.prices.winvmj.core.VMJServer;
import id.ac.ui.cs.prices.winvmj.core.Router;
import id.ac.ui.cs.prices.winvmj.hibernate.HibernateUtil;
import org.hibernate.cfg.Configuration;



import id.ac.ui.cs.prices.winvmj.auth.model.UserResourceFactory;
import id.ac.ui.cs.prices.winvmj.auth.model.RoleResourceFactory;
import id.ac.ui.cs.prices.winvmj.auth.model.core.resource.UserResource;
import id.ac.ui.cs.prices.winvmj.auth.model.core.resource.RoleResource;

import tokoonlineanimepl.katalogproduk.KatalogProdukResourceFactory;
import tokoonlineanimepl.katalogproduk.core.resource.KatalogProdukResource;
import tokoonlineanimepl.katalogproduk.KatalogProdukServiceFactory;
import tokoonlineanimepl.katalogproduk.core.service.KatalogProdukService;
import tokoonlineanimepl.keranjangbelanja.KeranjangBelanjaResourceFactory;
import tokoonlineanimepl.keranjangbelanja.core.resource.KeranjangBelanjaResource;
import tokoonlineanimepl.keranjangbelanja.KeranjangBelanjaServiceFactory;
import tokoonlineanimepl.keranjangbelanja.core.service.KeranjangBelanjaService;
import tokoonlineanimepl.cartitem.CartItemResourceFactory;
import tokoonlineanimepl.cartitem.core.resource.CartItemResource;
import tokoonlineanimepl.cartitem.CartItemServiceFactory;
import tokoonlineanimepl.cartitem.core.service.CartItemService;
import tokoonlineanimepl.akunpengguna.AkunPenggunaResourceFactory;
import tokoonlineanimepl.akunpengguna.core.resource.AkunPenggunaResource;
import tokoonlineanimepl.akunpengguna.AkunPenggunaServiceFactory;
import tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaService;
import tokoonlineanimepl.pembayaran.PembayaranResourceFactory;
import tokoonlineanimepl.pembayaran.core.resource.PembayaranResource;
import tokoonlineanimepl.pembayaran.PembayaranServiceFactory;
import tokoonlineanimepl.pembayaran.core.service.PembayaranService;
import tokoonlineanimepl.manajemenpesanan.ManajemenPesananResourceFactory;
import tokoonlineanimepl.manajemenpesanan.core.resource.ManajemenPesananResource;
import tokoonlineanimepl.manajemenpesanan.ManajemenPesananServiceFactory;
import tokoonlineanimepl.manajemenpesanan.core.service.ManajemenPesananService;
import tokoonlineanimepl.orderitem.OrderItemResourceFactory;
import tokoonlineanimepl.orderitem.core.resource.OrderItemResource;
import tokoonlineanimepl.orderitem.OrderItemServiceFactory;
import tokoonlineanimepl.orderitem.core.service.OrderItemService;
import tokoonlineanimepl.preorder.PreOrderResourceFactory;
import tokoonlineanimepl.preorder.core.resource.PreOrderResource;
import tokoonlineanimepl.preorder.PreOrderServiceFactory;
import tokoonlineanimepl.preorder.core.service.PreOrderService;

public class AniSecond {

	private static final Logger logger;
	
	static {
		logger = LoggerFactory.getLogger(AniSecond.class);
	}
    
	public static void main(String[] args) {



		// get hostAddress and portnum from env var
        // ex:
        // AMANAH_HOST_BE --> "localhost"
        // AMANAH_PORT_BE --> 7776
		String hostAddress= getEnvVariableHostAddress("AMANAH_HOST_BE");
        int portNum = getEnvVariablePortNumber("AMANAH_PORT_BE");
        activateServer(hostAddress, portNum);
		setCors();

		Configuration configuration = new Configuration();
		// panggil setter setelah membuat object dari kelas Configuration
        // ex:
        // AMANAH_DB_URL --> jdbc:postgresql://localhost:5432/superorg
        // AMANAH_DB_USERNAME --> postgres
        // AMANAH_DB_PASSWORD --> postgres123
		setDBProperties("AMANAH_DB_URL", "url", configuration);
        setDBProperties("AMANAH_DB_USERNAME", "username", configuration);
        setDBProperties("AMANAH_DB_PASSWORD","password", configuration);

		configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.User.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.passworded.model.UserImpl.class);

		configuration.addAnnotatedClass(tokoonlineanimepl.katalogproduk.core.model.KatalogProduk.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.katalogproduk.core.model.KatalogProdukComponent.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.katalogproduk.core.model.KatalogProdukDecorator.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.katalogproduk.core.model.KatalogProdukImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.katalogproduk.katalogprodukpreowned.model.KatalogProdukImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.katalogproduk.reviewdanrating.model.KatalogProdukImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanja.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaComponent.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaDecorator.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.cartitem.core.model.CartItem.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.cartitem.core.model.CartItemComponent.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.cartitem.core.model.CartItemDecorator.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.cartitem.core.model.CartItemImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.akunpengguna.core.model.AkunPengguna.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaDecorator.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.akunpengguna.sistempoinloyalitas.model.AkunPenggunaImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.pembayaran.core.model.Pembayaran.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.pembayaran.core.model.PembayaranComponent.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.pembayaran.core.model.PembayaranDecorator.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.pembayaran.core.model.PembayaranImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesanan.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesananComponent.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesananDecorator.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesananImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.orderitem.core.model.OrderItem.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.orderitem.core.model.OrderItemComponent.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.orderitem.core.model.OrderItemDecorator.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.orderitem.core.model.OrderItemImpl.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.preorder.core.model.PreOrder.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.preorder.core.model.PreOrderComponent.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.preorder.core.model.PreOrderDecorator.class);
		configuration.addAnnotatedClass(tokoonlineanimepl.preorder.core.model.PreOrderImpl.class);

		Map<String, Object> featureModelMappings = mappingFeatureModel();
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Map<String, String[]>>>(){}.getType();
        String convertedFeatureModelMappings = gson.toJson(featureModelMappings, type);
		
        configuration.setProperty("feature.model.mappings", convertedFeatureModelMappings);
		configuration.buildMappings();
		// Try to initialize Hibernate - graceful failure if DB not available
		try {
			HibernateUtil.buildSessionFactory(configuration);


			createObjectsAndBindEndPoints();
		} catch (Exception e) {
			logger.warn("Database connection failed - server running but database features disabled");
			logger.debug("Database error: {}", e.getMessage());
		}
	}

	public static void activateServer(String hostName, int portNumber) {
		VMJServer vmjServer = VMJServer.getInstance(hostName, portNumber);
		try {
			vmjServer.startServerGeneric();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void createObjectsAndBindEndPoints() {
		logger.info("Creating objects and binding endpoints");
		UserResource userResource = UserResourceFactory
            .createUserResource("id.ac.ui.cs.prices.winvmj.auth.model.core.resource.UserResourceImpl"
			);

		RoleResource roleResource = RoleResourceFactory
        	.createRoleResource("id.ac.ui.cs.prices.winvmj.auth.model.core.resource.RoleResourceImpl"
			);
        
        UserResource userPasswordedResource = UserResourceFactory
	        .createUserResource("id.ac.ui.cs.prices.winvmj.auth.model.passworded.resource.UserResourceImpl"
			,
		    UserResourceFactory.createUserResource("id.ac.ui.cs.prices.winvmj.auth.model.core.resource.UserResourceImpl"));

        KatalogProdukService katalogprodukKatalogProduk2Service = KatalogProdukServiceFactory
            .createKatalogProdukService("tokoonlineanimepl.katalogproduk.core.service.KatalogProdukServiceImpl"
            	);		

        KatalogProdukResource katalogprodukKatalogProduk2Resource = KatalogProdukResourceFactory
            .createKatalogProdukResource("tokoonlineanimepl.katalogproduk.core.resource.KatalogProdukResourceImpl"
                );
			
        KatalogProdukService katalogprodukpreownedKatalogProduk2Service = KatalogProdukServiceFactory
            .createKatalogProdukService("tokoonlineanimepl.katalogproduk.katalogprodukpreowned.service.KatalogProdukServiceImpl"
            	, katalogprodukKatalogProduk2Service);		

        KatalogProdukResource katalogprodukpreownedKatalogProduk2Resource = KatalogProdukResourceFactory
            .createKatalogProdukResource("tokoonlineanimepl.katalogproduk.katalogprodukpreowned.resource.KatalogProdukResourceImpl"
                , katalogprodukKatalogProduk2Resource, katalogprodukKatalogProduk2Service);
			
        KatalogProdukService reviewdanratingKatalogProduk2Service = KatalogProdukServiceFactory
            .createKatalogProdukService("tokoonlineanimepl.katalogproduk.reviewdanrating.service.KatalogProdukServiceImpl"
            	, katalogprodukKatalogProduk2Service);		

        KatalogProdukResource reviewdanratingKatalogProduk2Resource = KatalogProdukResourceFactory
            .createKatalogProdukResource("tokoonlineanimepl.katalogproduk.reviewdanrating.resource.KatalogProdukResourceImpl"
                , katalogprodukKatalogProduk2Resource, katalogprodukKatalogProduk2Service);
			
        KeranjangBelanjaService keranjangbelanjaKeranjangBelanja2Service = KeranjangBelanjaServiceFactory
            .createKeranjangBelanjaService("tokoonlineanimepl.keranjangbelanja.core.service.KeranjangBelanjaServiceImpl"
            	);		

        KeranjangBelanjaResource keranjangbelanjaKeranjangBelanja2Resource = KeranjangBelanjaResourceFactory
            .createKeranjangBelanjaResource("tokoonlineanimepl.keranjangbelanja.core.resource.KeranjangBelanjaResourceImpl"
                );
			
        CartItemService cartitemCartItem2Service = CartItemServiceFactory
            .createCartItemService("tokoonlineanimepl.cartitem.core.service.CartItemServiceImpl"
            	);		

        CartItemResource cartitemCartItem2Resource = CartItemResourceFactory
            .createCartItemResource("tokoonlineanimepl.cartitem.core.resource.CartItemResourceImpl"
                );
			
        AkunPenggunaService akunpenggunaAkunPengguna2Service = AkunPenggunaServiceFactory
            .createAkunPenggunaService("tokoonlineanimepl.akunpengguna.core.service.AkunPenggunaServiceImpl"
            	);		

        AkunPenggunaResource akunpenggunaAkunPengguna2Resource = AkunPenggunaResourceFactory
            .createAkunPenggunaResource("tokoonlineanimepl.akunpengguna.core.resource.AkunPenggunaResourceImpl"
                );
			
        AkunPenggunaService sistempoinloyalitasAkunPengguna2Service = AkunPenggunaServiceFactory
            .createAkunPenggunaService("tokoonlineanimepl.akunpengguna.sistempoinloyalitas.service.AkunPenggunaServiceImpl"
            	, akunpenggunaAkunPengguna2Service);		

        AkunPenggunaResource sistempoinloyalitasAkunPengguna2Resource = AkunPenggunaResourceFactory
            .createAkunPenggunaResource("tokoonlineanimepl.akunpengguna.sistempoinloyalitas.resource.AkunPenggunaResourceImpl"
                , akunpenggunaAkunPengguna2Resource, akunpenggunaAkunPengguna2Service);
			
        PembayaranService pembayaranPembayaran2Service = PembayaranServiceFactory
            .createPembayaranService("tokoonlineanimepl.pembayaran.core.service.PembayaranServiceImpl"
            	);		

        PembayaranResource pembayaranPembayaran2Resource = PembayaranResourceFactory
            .createPembayaranResource("tokoonlineanimepl.pembayaran.core.resource.PembayaranResourceImpl"
                );
			
        ManajemenPesananService manajemenpesananManajemenPesanan2Service = ManajemenPesananServiceFactory
            .createManajemenPesananService("tokoonlineanimepl.manajemenpesanan.core.service.ManajemenPesananServiceImpl"
            	);		

        ManajemenPesananResource manajemenpesananManajemenPesanan2Resource = ManajemenPesananResourceFactory
            .createManajemenPesananResource("tokoonlineanimepl.manajemenpesanan.core.resource.ManajemenPesananResourceImpl"
                );
			
        OrderItemService orderitemOrderItem2Service = OrderItemServiceFactory
            .createOrderItemService("tokoonlineanimepl.orderitem.core.service.OrderItemServiceImpl"
            	);		

        OrderItemResource orderitemOrderItem2Resource = OrderItemResourceFactory
            .createOrderItemResource("tokoonlineanimepl.orderitem.core.resource.OrderItemResourceImpl"
                );
			
        PreOrderService preorderPreOrder2Service = PreOrderServiceFactory
            .createPreOrderService("tokoonlineanimepl.preorder.core.service.PreOrderServiceImpl"
            	);		

        PreOrderResource preorderPreOrder2Resource = PreOrderResourceFactory
            .createPreOrderResource("tokoonlineanimepl.preorder.core.resource.PreOrderResourceImpl"
                );
			

		logger.info("Binding endpoints for preorderPreOrder2Resource");
		Router.route(preorderPreOrder2Resource);
		
		logger.info("Binding endpoints for preorderPreOrder2Service");
		Router.route(preorderPreOrder2Service);
		
		logger.info("Binding endpoints for orderitemOrderItem2Resource");
		Router.route(orderitemOrderItem2Resource);
		
		logger.info("Binding endpoints for orderitemOrderItem2Service");
		Router.route(orderitemOrderItem2Service);
		
		logger.info("Binding endpoints for manajemenpesananManajemenPesanan2Resource");
		Router.route(manajemenpesananManajemenPesanan2Resource);
		
		logger.info("Binding endpoints for manajemenpesananManajemenPesanan2Service");
		Router.route(manajemenpesananManajemenPesanan2Service);
		
		logger.info("Binding endpoints for pembayaranPembayaran2Resource");
		Router.route(pembayaranPembayaran2Resource);
		
		logger.info("Binding endpoints for pembayaranPembayaran2Service");
		Router.route(pembayaranPembayaran2Service);
		
		logger.info("Binding endpoints for sistempoinloyalitasAkunPengguna2Resource");
		Router.route(sistempoinloyalitasAkunPengguna2Resource);
		
		logger.info("Binding endpoints for sistempoinloyalitasAkunPengguna2Service");
		Router.route(sistempoinloyalitasAkunPengguna2Service);
		
		logger.info("Binding endpoints for akunpenggunaAkunPengguna2Resource");
		Router.route(akunpenggunaAkunPengguna2Resource);
		
		logger.info("Binding endpoints for akunpenggunaAkunPengguna2Service");
		Router.route(akunpenggunaAkunPengguna2Service);
		
		logger.info("Binding endpoints for cartitemCartItem2Resource");
		Router.route(cartitemCartItem2Resource);
		
		logger.info("Binding endpoints for cartitemCartItem2Service");
		Router.route(cartitemCartItem2Service);
		
		logger.info("Binding endpoints for keranjangbelanjaKeranjangBelanja2Resource");
		Router.route(keranjangbelanjaKeranjangBelanja2Resource);
		
		logger.info("Binding endpoints for keranjangbelanjaKeranjangBelanja2Service");
		Router.route(keranjangbelanjaKeranjangBelanja2Service);
		
		logger.info("Binding endpoints for reviewdanratingKatalogProduk2Resource");
		Router.route(reviewdanratingKatalogProduk2Resource);
		
		logger.info("Binding endpoints for reviewdanratingKatalogProduk2Service");
		Router.route(reviewdanratingKatalogProduk2Service);
		
		logger.info("Binding endpoints for katalogprodukpreownedKatalogProduk2Resource");
		Router.route(katalogprodukpreownedKatalogProduk2Resource);
		
		logger.info("Binding endpoints for katalogprodukpreownedKatalogProduk2Service");
		Router.route(katalogprodukpreownedKatalogProduk2Service);
		
		logger.info("Binding endpoints for katalogprodukKatalogProduk2Resource");
		Router.route(katalogprodukKatalogProduk2Resource);
		
		logger.info("Binding endpoints for katalogprodukKatalogProduk2Service");
		Router.route(katalogprodukKatalogProduk2Service);
		
		logger.info("Binding auth endpoints");
		Router.route(userPasswordedResource);
		Router.route(roleResource);
		Router.route(userResource);
	}

	private static Map<String, Object> mappingFeatureModel() {
		Map<String, Object> featureModelMappings = new HashMap<>();

		featureModelMappings.put(
            tokoonlineanimepl.katalogproduk.core.model.KatalogProdukComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					tokoonlineanimepl.katalogproduk.core.model.KatalogProdukComponent.class.getName()
				});
				put("deltas", new String[] {
					tokoonlineanimepl.katalogproduk.katalogprodukpreowned.model.KatalogProdukImpl.class.getName(),
					tokoonlineanimepl.katalogproduk.reviewdanrating.model.KatalogProdukImpl.class.getName()
				});
			}});
		featureModelMappings.put(
            tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					tokoonlineanimepl.keranjangbelanja.core.model.KeranjangBelanjaComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            tokoonlineanimepl.cartitem.core.model.CartItemComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					tokoonlineanimepl.cartitem.core.model.CartItemComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					tokoonlineanimepl.akunpengguna.core.model.AkunPenggunaComponent.class.getName()
				});
				put("deltas", new String[] {
					tokoonlineanimepl.akunpengguna.sistempoinloyalitas.model.AkunPenggunaImpl.class.getName()
				});
			}});
		featureModelMappings.put(
            tokoonlineanimepl.pembayaran.core.model.PembayaranComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					tokoonlineanimepl.pembayaran.core.model.PembayaranComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesananComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					tokoonlineanimepl.manajemenpesanan.core.model.ManajemenPesananComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            tokoonlineanimepl.orderitem.core.model.OrderItemComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					tokoonlineanimepl.orderitem.core.model.OrderItemComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            tokoonlineanimepl.preorder.core.model.PreOrderComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					tokoonlineanimepl.preorder.core.model.PreOrderComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
	            id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserComponent.class.getName(),
				new HashMap<String, String[]>() {{ 
					put("components", new String[] {
						id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserComponent.class.getName()
					});
					put("deltas", new String[] {
						id.ac.ui.cs.prices.winvmj.auth.model.passworded.model.UserImpl.class.getName()
					});
				}});
        
	    featureModelMappings.put(
				id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleComponent.class.getName(),
				new HashMap<String, String[]>() {{ 
					put("components", new String[] {
						id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleComponent.class.getName()
					});
					put("deltas", new String[] {
					});
				}});
        
	    featureModelMappings.put(
				id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleComponent.class.getName(),
				new HashMap<String, String[]>() {{ 
					put("components", new String[] {
						id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleComponent.class.getName()
					});
					put("deltas", new String[] {
					});
				}});
        
		return featureModelMappings;
	}

	public static void setDBProperties(String varname, String typeProp, Configuration configuration) {
		String varNameValue = System.getenv(varname);
		String propertyName = String.format("hibernate.connection.%s",typeProp);
		if (varNameValue != null) {
			configuration.setProperty(propertyName, varNameValue);
		} else {
			String hibernatePropertyVal = configuration.getProperty(propertyName);
			if (hibernatePropertyVal == null) {
				logger.warn("Please check '{}' in your local environment variable or 'hibernate.connection.{}' in your 'hibernate.properties' file!", varname, typeProp);
			}
		}
	}

	// if the env variable for server host is null, use localhost instead.
    public static String getEnvVariableHostAddress(String varname_host){
            String hostAddress = System.getenv(varname_host)  != null ? System.getenv(varname_host) : "localhost"; // Host
            return hostAddress;
    }

    // try if the environment variable for port number is null, use 7776 instead
    public static int getEnvVariablePortNumber(String varname_port){
            String portNum = System.getenv(varname_port)  != null? System.getenv(varname_port)  : "7776"; //PORT
            int portNumInt = Integer.parseInt(portNum);
            return portNumInt;
    }
	
	public static void setCors() {
    	Properties properties = new Properties();
        String propertyValue = "";
        
        try (FileInputStream fileInput = new FileInputStream("cors.properties")) {
            properties.load(fileInput);
            propertyValue = properties.getProperty("allowedMethod");
            VMJCors.setAllowedMethod(propertyValue);
            
            propertyValue = properties.getProperty("allowedOrigin");
            VMJCors.setAllowedOrigin(propertyValue);
            
        		} catch (IOException e) {
			VMJCors.setAllowedMethod("GET, POST, PUT, PATCH, DELETE");
			VMJCors.setAllowedOrigin("*");
			logger.info("cors.properties not found, using defaults (allowedMethod=GET,POST,PUT,PATCH,DELETE, allowedOrigin=*)");
        }
    }

}