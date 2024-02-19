package com.api.custom;

import java.util.Comparator;

public class BrandSort implements Comparator<Mobile>{

	@Override
	public int compare(Mobile o1, Mobile o2) {
		int result = o1.getBrand().compareTo(o2.getBrand());
		return result;
		
	}

	

}
