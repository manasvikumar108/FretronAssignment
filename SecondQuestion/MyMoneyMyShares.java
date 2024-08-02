import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class MyMoneyMyShares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total amount of money: ");
        int totalAmount = sc.nextInt();
        System.out.print("Enter money paid by Ram: ");
        int ramAmount = sc.nextInt();
        System.out.print("Enter money paid by Sham: ");
        int shamAmount = sc.nextInt();
        System.out.print("Enter money paid by Rahim: ");
        int rahimAmount = sc.nextInt();

        int ramPercentage = percentageCalc(totalAmount, ramAmount);
        int shamPercentage = percentageCalc(totalAmount, shamAmount);
        int rahimPercentage = percentageCalc(totalAmount, rahimAmount);

//        System.out.println(ramPercentage + " " + shamPercentage + " " + rahimPercentage);

        ArrayList<Integer> appleList = new ArrayList<Integer>();
        int appleWeight = 0, totalAppleWeight=0;
        do {
            System.out.print("Enter apple weight in gram (-1 to stop ) : ");
            appleWeight = sc.nextInt();
            if(appleWeight!=-1) {
                appleList.add(appleWeight);
            }
        }while(appleWeight!=-1);

        Iterator itr = appleList.iterator();
        while(itr.hasNext()){
//            System.out.println(itr.next());
            totalAppleWeight = totalAppleWeight + (int)itr.next();
        }

        int ramAppleWeight = appleWeightCalc(ramPercentage,totalAppleWeight);
        int shamAppleWeight = appleWeightCalc(shamPercentage,totalAppleWeight);
        int rahimAppleWeight = appleWeightCalc(rahimPercentage,totalAppleWeight);

//        System.out.println(ramAppleWeight + " " + shamAppleWeight + " " + rahimAppleWeight);

        Collections.sort(appleList, Collections.reverseOrder());
        result(ramAppleWeight, shamAppleWeight, rahimAppleWeight, appleList);


    }

    static int percentageCalc(int total,int amount){
        return ((amount*100)/total);
    }

    static int appleWeightCalc(int percentage, int totalWeight){
        return ((percentage*totalWeight)/100);
    }

    static void result(int ramAppleWeight, int shamAppleWeight, int rahimAppleWeight, ArrayList<Integer> appleList) {
        ArrayList<Integer> ramApples = new ArrayList<>();
        ArrayList<Integer> shamApples = new ArrayList<>();
        ArrayList<Integer> rahimApples = new ArrayList<>();

        int ramCurrentWeight = 0;
        int shamCurrentWeight = 0;
        int rahimCurrentWeight = 0;

        for (int weight : appleList) {
            if (ramCurrentWeight + weight <= ramAppleWeight) {
                ramApples.add(weight);
                ramCurrentWeight += weight;
            } else if (shamCurrentWeight + weight <= shamAppleWeight) {
                shamApples.add(weight);
                shamCurrentWeight += weight;
            } else {
                rahimApples.add(weight);
                rahimCurrentWeight += weight;
            }
        }

        System.out.println("Distribution Result:");
        System.out.println("Ram : " + ramApples.toString());
        System.out.println("Sham : " + shamApples.toString());
        System.out.println("Rahim : " + rahimApples.toString());
    }


}

