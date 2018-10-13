package com.maxaramos.springwstestclient.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maxaramos.springwstestclient.client.AddressClient;
import com.maxaramos.springwstestclient.model.Address;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private Logger log;

	@Autowired
	private AddressClient addressClient;

	@PutMapping("/add")
	public Address add(@RequestBody Address address) {
		log.info("add: " + address);
		return addressClient.addAddress(address);
	}

	@GetMapping("/get")
	public Address get(@RequestParam("id") Long id) {
		log.info("get: " + id);
		return addressClient.getAddress(id);
	}

	@PostMapping("/update")
	public Address update(@RequestBody Address address) {
		log.info("update: " + address);
		return addressClient.updateAddress(address);
	}

	@DeleteMapping("/delete")
	public boolean delete(@RequestParam("id") Long id) {
		log.info("delete: " + id);
		return addressClient.deleteAddress(id);
	}

}
