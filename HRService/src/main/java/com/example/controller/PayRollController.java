package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Payroll;
import com.example.service.PayrollService;

@RestController
@RequestMapping("/hr")
public class PayRollController {
	@Autowired
	private PayrollService payrollService;
	@PostMapping("/addPayroll")
	public ResponseEntity<String> addPayroll(@RequestBody Payroll tasks) {
		Payroll s = payrollService.getPayroll(tasks.getPayrollId());
		if(s == null) {
			payrollService.addPayroll(tasks);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/updatePayroll")
	public ResponseEntity<String> updatePayroll(@RequestBody Payroll tasks) {
		Payroll s = payrollService.getPayroll(tasks.getPayrollId());
		if(s != null) {
			payrollService.updatePayroll(tasks);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getPayroll/{id}")
	public ResponseEntity<Payroll> getPayroll(@PathVariable int id) {
		Payroll s = payrollService.getPayroll(id);
		if(s!=null) {
			return new ResponseEntity<Payroll>(s,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getPayrolls")
	public ResponseEntity<List<Payroll>> getAllPayroll() {
		List<Payroll> s = payrollService.getPayrolls();
		if(s!=null)
		{
			return new ResponseEntity<List<Payroll>>(s,HttpStatus.OK);
			}
		else{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deletePayroll/{id}")
	public ResponseEntity<String> deletePayroll(@PathVariable(value="id") int id) {
		Payroll s = payrollService.getPayroll(id);
		if(s != null) {
			payrollService.deletePayroll(id);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
