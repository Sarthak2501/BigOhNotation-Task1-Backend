import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Employee kunal = new Employee();
        kunal.setEmployeeName("Kunal singh");
        kunal.setEmployeePost("Clerk");

        VegBuilder vegBillBuilder = new VegBuilder();
        vegetableBills greenvegBill = vegBillBuilder.prepareGreenVegetable();

        //System.out.println("Green Veg Bill");
        //greenvegBill.vegetableBills(kunal);
        //System.out.println("Total Cost : " + greenvegBill.addBill());

        vegetableBills nongreenvegBill = vegBillBuilder.prepareNonGreenVegetable();

        System.out.println();

        System.out.println("Vegetable Bill");
        nongreenvegBill.vegetableBills(kunal);
        System.out.println("Bill Amount : " + nongreenvegBill.addBill());
        System.out.println("Discount Amount : " + discountBills.getDiscountAmount());
        System.out.println("Discount Percentage : " + (int) discountBills.getDiscountPercent() + "%");
        System.out.println("Total Amount : " + (nongreenvegBill.addBill() - discountBills.getDiscountAmount()));

        //discountBills ds1 = new discountBills();
        //ds1.getDiscountAmount();

    }
}


class Employee{

    private String employeeName;
    private String employeePost;


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePost() {
        return employeePost;
    }

    public void setEmployeePost(String employeePost) {
        this.employeePost = employeePost;
    }


}

class vegetableBills {

    private static int billId;
    public int billAmount = 0;
    public static List<items> itemsInaList = new ArrayList<items>();


    public static int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void addItem(items item){
        itemsInaList.add(item);
    }

    public void vegetableBills(Employee Clerk) {
        // a VegetableBill object for the given clerk
        System.out.println("Please Provide the bill to the customer : " + Clerk.getEmployeeName());
        for (items item : itemsInaList) {
            System.out.println("Bill ID :" + billId);
            System.out.println("Item : " + item.name());
            System.out.println("Price :" + item.getPrice());
            System.out.println("Discount price :  " + item.getDiscount());
        }
    }

    public static float addBill() {
        float cost = 0.0f;

        for (items item : itemsInaList) {
            cost += item.getPrice();
            //cost -= item.getDiscount();
        }

        return cost;
    }
}

interface items{

    public String name();
    public double getPrice();

    double getDiscount();


}

abstract class greenVeggies implements items{

    @Override
    public abstract double getPrice();

    @Override
    public abstract double getDiscount();
}

class Broccoli extends greenVeggies{

    @Override
    public String name() {
        return "Broccoli";
    }

    @Override
    public double getPrice() {
        return 20.0f;
    }

    @Override
    public double getDiscount() {
        if(discountBills.preffered){
            return 5.0f;
        }
        return 0;
    }
}

class Spinach extends greenVeggies{

    @Override
    public String name() {
        return "Spinach";
    }

    @Override
    public double getPrice() {
        return 40.0f;
    }

    @Override
    public double getDiscount() {
        if(discountBills.preffered){
            return 8.0f;
        }
        return 0;
    }
}



abstract class nonGreenVeggies implements items{

    @Override
    public abstract double getPrice();

    @Override
    public abstract double getDiscount();
}

class Potatoes extends nonGreenVeggies{

    @Override
    public String name() {
        return "Potatoes";
    }

    @Override
    public double getPrice() {
        return 10.0f;
    }

    @Override
    public double getDiscount() {
        if(discountBills.preffered){
            return 2.0f;
        }
        return 0;
    }
}

class Tomato extends greenVeggies{

    @Override
    public String name() {
        return "Tomato";
    }

    @Override
    public double getPrice() {
        return 20.0f;
    }

    @Override
    public double getDiscount() {
        if(discountBills.preffered){
            return 5.0f;
        }
        return 0;
    }
}



class discountBills extends vegetableBills{

    public static boolean preffered = true;


    public static float getDiscountAmount(){
        //return the total discount for the list of items
        float DiscountCost = 0.0f;
        for(items items:itemsInaList){
            DiscountCost += items.getDiscount();
        }
        //System.out.println("Discount Cost : " + DiscountCost);

        return DiscountCost;
    }

    public static double getDiscountPercent(){
        //return the percent of total discount
        float totalBill = vegetableBills.addBill();
        float discountBill = getDiscountAmount();

        float discountPercent = discountBill/totalBill * 100;

        return discountPercent;
    }
}

class VegBuilder {

    public vegetableBills prepareGreenVegetable(){
        vegetableBills vegetableBills = new vegetableBills();
        vegetableBills.setBillId(1121);
        vegetableBills.addItem(new Broccoli());
        vegetableBills.addItem(new Spinach());
        //vegetableBills.

        return vegetableBills;
    }


    public vegetableBills prepareNonGreenVegetable(){
        vegetableBills vegetableBills = new vegetableBills();
        vegetableBills.setBillId(1122);
        vegetableBills.addItem(new Potatoes());
        vegetableBills.addItem(new Tomato());

        return vegetableBills;
    }

}
