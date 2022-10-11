package com.jsfcourse.calc;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	
	private String x;
	private String y;
	private String z;
	private Double result;

	
	public String getX() {
		return x;
	}


	public void setX(String x) {
		this.x = x;
	}


	public String getY() {
		return y;
	}


	public void setY(String y) {
		this.y = y;
	}


	public String getZ() {
		return z;
	}


	public void setZ(String z) {
		this.z = z;
	}


	public Double getResult() {
		return result;
	}


	public void setResult(Double result) {
		this.result = result;
	}

	@Inject
	FacesContext ctx;



	
	
	public boolean doTheMath() {

		try {
			double lata = Double.parseDouble(this.x);		//lata
			double kwota = Double.parseDouble(this.y);		//kwota
			double procent = Double.parseDouble(this.z);	//procent
			
			System.out.println(lata);
			System.out.println(kwota);
			System.out.println(procent);
			
			double miesiące = lata * 12;
			result = kwota + (kwota*procent/100);
			result = result/miesiące;
			
			

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	
	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + result, null));
			
			
		}
		return null;
	}

	public String info() {
		return "info";
	}
}
