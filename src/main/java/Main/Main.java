package Main;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department dp = new Department(1,"Eletronics");
        Seller seller = new Seller(
                21,"ygor","ygor@gmail.com", new Date(),3000.00, dp);
        
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }
}