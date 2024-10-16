/*
Add a dial() method to the CellPhone class that accepts a phone number
parameter and displays the message "owner's phone is calling phone-parameter"
Example
cellPhone1.dial("855-555-2222");
 */

package com.pluralsight;

public class CellPhone {

        int serialNumber;
        String model,carrier,phoneNumber,owner; ;

        public CellPhone(){

        }
        public void dial(String phoneNumber){
            System.out.println(this.owner+"'s"+ " phone is calling "+phoneNumber);
        }

        public int getSerialNumber(){
            return this.serialNumber;
        }
        public void setSerialNumber(int serialNumber){
            this.serialNumber = serialNumber;
        }

        public String getModel(){
            return this.model;
        }
        public void setModel(String model){
            this.model = model;
        }

        public String getCarrier(){
            return this.carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public String getPhoneNumber(){
            return this.phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
        }

        public String getOwner(){
            return this.owner;
        }
        public void setOwner(String owner){
            this.owner = owner;
        }

}
