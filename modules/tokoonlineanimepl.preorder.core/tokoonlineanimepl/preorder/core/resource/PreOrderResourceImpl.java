package tokoonlineanimepl.preorder.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.AuthHandler;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.auth.core.AuthPayload;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import tokoonlineanimepl.preorder.PreOrderFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import tokoonlineanimepl.preorder.core.model.PreOrder;
import tokoonlineanimepl.preorder.core.service.PreOrderServiceImpl;
//add other required packages


public class PreOrderResourceImpl extends PreOrderResourceComponent{
	
	private PreOrderServiceImpl preorderServiceImpl = new PreOrderServiceImpl();

	
    @Route(url="call/preorder/save")
    public List<HashMap<String,Object>> savePreOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PreOrder preorder = createPreOrder(vmjExchange);
		return preorderServiceImpl.getAllPreOrder();
	}

    public PreOrder createPreOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			PreOrder result = preorderServiceImpl.createPreOrder(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public PreOrder createPreOrder(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			PreOrder result = preorderServiceImpl.createPreOrder(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/preorder/update")
    public HashMap<String, Object> updatePreOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return preorderServiceImpl.updatePreOrder(requestBody);
		
	}

	
    @Route(url="call/preorder/detail")
    public HashMap<String, Object> getPreOrder(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_preorder");
		return preorderServiceImpl.getPreOrder(idStr);
	}

	
    @Route(url="call/preorder/list")
    public List<HashMap<String,Object>> getAllPreOrder(VMJExchange vmjExchange){
		try {
			boolean isAuthorized = AuthHandler.authorize(vmjExchange, "");
			if (!isAuthorized) {
				throw new ForbiddenException("Token tidak valid");
			}
			AuthPayload authPayload = vmjExchange.getAuthPayload();
			if (authPayload == null || authPayload.getEmail() == null) {
				throw new ForbiddenException("Email user login tidak ditemukan");
			}
			if (AuthHandler.isAdministrator(vmjExchange)) {
				return preorderServiceImpl.getAllPreOrder();
			}
			return preorderServiceImpl.getPreOrderByCustomerEmail(authPayload.getEmail());
		} catch (ForbiddenException e) {
			throw e;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	
    @Route(url="call/preorder/delete")
    public List<HashMap<String,Object>> deletePreOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return preorderServiceImpl.deletePreOrder(requestBody);
	}


}
