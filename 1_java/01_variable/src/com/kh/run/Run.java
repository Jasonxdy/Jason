package com.kh.run;

import com.kh.variable.A_Variable;
import com.kh.variable.B_KeyboardInput;
import com.kh.variable.C_Constant;
import com.kh.variable.D_Cast;
import com.kh.variable.E_OverFlow;
import com.kh.variable.F_Print;

public class Run {
	
	public static void main(String[] args) {
		
		// �ٸ� Ŭ������ �ۼ��Ǿ� �ִ� �޼��� ���� (ȣ��)
		A_Variable var = new A_Variable(); // Ŭ���� ����
		/*
		var.noVariable(); //�޼��� ȣ��
		var.usingVariable(); //�޼��� ȣ��
		var.declareVariable();
		*/
		
		B_KeyboardInput ki = new B_KeyboardInput();
		
		//ki.inputScanner1();
		//ki.inputScanner2();
		
		C_Constant cs = new C_Constant();
		
		//cs.finalKeyword();
		
		D_Cast cast = new D_Cast();
		//cast.rule1();
		//cast.rule2();
		//cast.dataloss();
		
		E_OverFlow of = new E_OverFlow();
		of.overflow();
		
		F_Print print = new F_Print();
		//print.printMethod();
		
	}
}
