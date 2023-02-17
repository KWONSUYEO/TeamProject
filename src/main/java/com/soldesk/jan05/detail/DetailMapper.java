package com.soldesk.jan05.detail;

import java.util.List;

import com.soldesk.jan05.restaurants.Restaurants;

public interface DetailMapper {
	public abstract int getMaxNo(Restaurants r);
	public abstract Restaurants getRest(Restaurants r);
	public abstract List<Restaurants> getDibs(Restaurants r);
	public abstract int regDibs(Restaurants r);
}
