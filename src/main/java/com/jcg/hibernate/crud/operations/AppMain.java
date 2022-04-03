package com.jcg.hibernate.crud.operations;

import java.util.List;

import com.jcg.hibernate.crud.operations.View.TelaCrime;
import org.apache.log4j.Logger;

public class AppMain {

	public final static Logger logger = Logger.getLogger(AppMain.class);

	public static void main(String[] args) {
		TelaCrime telaCrime = new TelaCrime();
		telaCrime.setVisible(true);
	} 
}