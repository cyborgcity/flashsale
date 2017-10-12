package com.sale.assignment;

import com.sale.assignment.exception.WrongInputException;
import com.sale.assignment.service.impl.Service;
import com.sale.assignment.util.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Ravi on 01-10-2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        InputStream inputStream = null;
        if(args.length > 0 && args[0] != null){
            try {
                inputStream = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            try {
                inputStream = new Utility().getFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            Scanner scanner = new Scanner(inputStream);
            Integer num = Integer.parseInt(scanner.nextLine());
            String[] line = new String[num];
            for(int i = 0; i < num; i++){
                line[i] = scanner.nextLine();
            }
            service.calculateDiscount(line);
            scanner.nextLine();
            num = Integer.parseInt(scanner.nextLine());
            for(int i = 0; i < num; i++){
                System.out.println(service.getResult(scanner.nextLine()));
            }
        } catch (WrongInputException e){
            System.out.println(e.getLocalizedMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
