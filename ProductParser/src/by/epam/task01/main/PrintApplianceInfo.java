package by.epam.task01.main;

import by.epam.task01.entity.Appliance;

public class PrintApplianceInfo {
    public static void print(Appliance appliance){
        System.out.println(appliance.toStringInfo());
    }
}
