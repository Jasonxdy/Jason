package com.kh.run;

import com.kh.operator.A_LogicalNegation;
import com.kh.operator.B_InDecrease;
import com.kh.operator.C_Arithmetic;
import com.kh.operator.D_Comparison;
import com.kh.operator.E_Logical;
import com.kh.operator.F_Compound;
import com.kh.operator.G_Triple;

public class Run {
	
	public static void main(String[] args) {
		
		// �� ���� ������
		A_LogicalNegation ln = new A_LogicalNegation();
		//ln.method1();
		
		// ���� ������
		B_InDecrease id = new B_InDecrease();
		//id.method1();
		//id.method2();
		//id.method3();
		
		// ���������
		C_Arithmetic at = new C_Arithmetic();
		//at.method1();
		//at.method2();
		//at.method3();
		
		//�񱳿�����
		D_Comparison cp = new D_Comparison();
		//cp.method1();
		//cp.method2();
		
		E_Logical lc = new E_Logical();
		//lc.method1();
		//lc.method2();
		//lc.method3();

		F_Compound comp = new F_Compound();
		//comp.method1();
		
		G_Triple tr = new G_Triple();
		//tr.method1();
		//tr.method2();
		tr.method3();
		
	}

}
