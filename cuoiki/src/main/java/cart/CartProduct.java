package cart;

import dao.ProductDAO;
import database.DBConnect;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartProduct {

    Map<Integer, Cart> data = new HashMap<>();
    ProductDAO dao = new ProductDAO(DBConnect.getConnection());

    public boolean add(int id){
        return this.add(id,1);
    }

    public boolean add(int id, int quantity) {
        Product product = dao.getProductById(id);
        if(product == null) return false;
        Cart cart = null;
        if(data.containsKey(id)){
            cart = data.get(id);
            cart.increaseQuantity(quantity);
        } else {
            cart = new Cart(product,quantity);
        }
        data.put(id,cart);
        return true;
    }

    public int getTotal() {
        return data.size();
    }

    public Map<Integer, Cart> getData() {
        return data;
    }

    public void setData(Map<Integer, Cart> data) {
        this.data = data;
    }
}
