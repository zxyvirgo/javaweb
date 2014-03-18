package com.demo.hibernate.service;

import java.util.List;

import com.demo.hibernate.*;
public interface AdminService {
	 
	public List<Item>  getAll();
	List<Item> getPart(int i, int j);
	public void insert(Item item);
	public void delete(int i);
	public void update(Item item);
	public int getTotalNum();

}
