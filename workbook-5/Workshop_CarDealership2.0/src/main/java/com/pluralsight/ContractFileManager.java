package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager {

    private ContractFileManager(){}

    public static void addContract(Contract contract){

        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/contracts.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(contract+"\n");
            bufferedWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
