package Main;

import model.entities.Department;
import model.entities.Seller;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department dp = new Department(1,"Eletronics");
        Seller seller = new Seller(
                21,"ygor","ygor@gmail.com", new Date(),3000.00, dp);
        System.out.println(seller);
    }
}