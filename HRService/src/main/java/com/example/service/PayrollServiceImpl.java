package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Payroll;
import com.example.repository.PayrollRepository;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	private PayrollRepository payrollRepository;
	@Override
	public Payroll addPayroll(Payroll tasks) {
		// TODO Auto-generated method stub
		return payrollRepository.save(tasks);
	}

	@Override
	public Payroll getPayroll(int id) {
		// TODO Auto-generated method stub
		Optional<Payroll> t = payrollRepository.findById(id);
		if(t.isPresent()) {
			return t.get();
		}
		return null;
	}

	@Override
	public Payroll updatePayroll(Payroll tasks) {
		// TODO Auto-generated method stub
		return  payrollRepository.save(tasks);
	}

	@Override
	public void deletePayroll(int id) {
		// TODO Auto-generated method stub
		payrollRepository.deleteById(id);
		
	}

	@Override
	public List<Payroll> getPayrolls() {
		// TODO Auto-generated method stub
		return payrollRepository.findAll();
	}

}
