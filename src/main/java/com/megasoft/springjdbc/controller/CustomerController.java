package com.megasoft.springjdbc.controller;

import com.megasoft.springjdbc.models.Customer;
import com.megasoft.springjdbc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/1.0.0/customers")
public class CustomerController {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping("")
	public ResponseEntity<Iterable<Customer>> getAllCustomers(Pageable pageable) {
		Page<Customer> page = customerRepository.findAll(PageRequest.of(pageable.getPageNumber(),
				pageable.getPageSize(), pageable.getSortOr(Sort.by(Sort.Direction.ASC, "id"))));

		return ResponseEntity.ok(page.getContent());
	}

}
