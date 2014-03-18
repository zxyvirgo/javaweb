package com.demo.hibernate;

import java.util.List;
public interface CartService {

  public Item getItem(String  sid);
  public int getTotalNum();
  public List<Item>  getAll();
  public List<Item>  getPart(int i, int j);
  public void deleteCartItem(String sid, Cart cart);
  public void clearCart(Cart cart);
  public void changeQuantity(String sid, String quantity, Cart cart);
  
}
