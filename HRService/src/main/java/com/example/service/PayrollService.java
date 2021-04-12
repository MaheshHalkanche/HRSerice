package com.example.service;

import java.util.List;

import com.example.model.Payroll;

public interface PayrollService {
	public Payroll addPayroll(Payroll tasks);
	public Payroll getPayroll(int id);
	public Payroll updatePayroll(Payroll tasks);
	public void deletePayroll(int id);
	public List<Payroll> getPayrolls();
}
