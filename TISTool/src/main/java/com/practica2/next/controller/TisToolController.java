package com.practica2.next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica2.next.persistence.util.InvestResponse;
import com.practica2.next.persistence.util.InuputValidation;
import com.practica2.next.persistence.util.InvestRequest;
import com.practica2.next.service.TisToolInvestorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "Main Controller")
@RestController
public class TisToolController {

	@Autowired
	private TisToolInvestorService service;

	@GetMapping(value = "/api/swagger")
	public String sayHello() {
		return "HI, Swagger Hello world";
	}

	@ApiOperation(value = "InvestCalc")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operacion Exitosa") })
	@PostMapping(value = "InvestCalc/v1")
	@ResponseBody
	public ResponseEntity<InvestResponse> InvestCalc(@RequestBody InvestRequest request) {

		InvestResponse response = new InvestResponse();
		try {
			InuputValidation.parameterValidate(request);
			response = service.InvestCalc(request);

			return (new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK));

		} catch (Exception e) {
			response.setMessage(e.getLocalizedMessage());
			return (new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST));
		}
	}
}
