package Main;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: Seller findByDepartment ===");
        Department department = new Department(1,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }
        System.out.println("=== TEST 3: Seller findByAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: Seller findByAll ===");
        Seller newseller = new Seller(null,"hugo","hugo@gmail.com",new Date(),4000.0,department);
        sellerDao.insert(newseller);
        System.out.println("Inserted! New id = " + newseller.getId());
    }
}