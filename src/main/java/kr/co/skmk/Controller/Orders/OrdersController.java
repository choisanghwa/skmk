package kr.co.skmk.Controller.Orders;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.skmk.Controller.Member.MemberController;
import kr.co.skmk.Model.DTO.Orders.OrderDTO;
import kr.co.skmk.Service.Orders.OrdersService;

//@RestController
@Controller
public class OrdersController {
	
	@Inject
	OrdersService service;
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	@ResponseBody
	@RequestMapping(value = "/orders/insertOrder", method = RequestMethod.POST)
	public String InsertOrders(@ModelAttribute OrderDTO dto){
		String entity = "";
		
		try {
		
		int i=service.insertOrder(dto);
		if(i == 1) {
		entity = "1";
		}else {
			entity = "0";
		}
	
		}catch(Exception e) {
			entity = "Error";
		}
		return entity;
	}
}
