public class MainProgram {

    public static void main(String[] args) {
        Moped slowRide = new Moped();
        slowRide.setColor("Red");
        slowRide.setFuelCapacity(5);

        Car corvetteStringray = new Car();
        corvetteStringray.setTopSpeed(233);
        corvetteStringray.setColor("dark blue");
        corvetteStringray.setAccelerationRate(20.8);
        corvetteStringray.setName("Corvette Stringray");

        Semitruck bigHauler = new Semitruck();
        bigHauler.setMass(8000);
        bigHauler.setCargoCapacity(24000);

        Hovercraft myHovercraft = new Hovercraft();
        myHovercraft.setColor("Black");
        myHovercraft.setName("Amphibious Assault Vehicle");
        myHovercraft.setColor("Green");

        System.out.printf("%s  %.2f mph/s %n",corvetteStringray.getName(),corvetteStringray.getAccelerationRate());
        System.out.println("Top speed: "+ corvetteStringray.getTopSpeed());

    }

}
