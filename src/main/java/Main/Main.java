package Main;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
        System.out.println("=== TEST 3: Seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: Seller insert ===");
        Seller newseller = new Seller(null,"hugo","hugo@gmail.com",new Date(),4000.0,department);
        sellerDao.insert(newseller);
        System.out.println("Inserted! New id = " + newseller.getId());

       System.out.println("=== TEST 5: Seller update ===");
       seller = sellerDao.findById(1);
       seller.setName("Vinicius");
       sellerDao.update(seller);
       System.out.println("Update Completed");

       System.out.println("=== TEST 6: Seller delete ===");
        System.out.println("Enter id for delete test");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        // Department Implementation code below

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: Department insert ===");
        Department newDepartment = new Department(null,"Film");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("=== TEST 2: Department update ===");
        Department department = departmentDao.findById(1);
        department.setName("Games");
        departmentDao.update(department);
        System.out.println("Update Completed");

        System.out.println("=== TEST 3: Department delete ===");
        System.out.println("Enter id for delete test");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        System.out.println("=== TEST 4: Department findByID ===");
        department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("=== TEST 5: Department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list){
            System.out.println(obj);
        }

        sc.close();
    }
}