package pluralsight.finance.assets;

import pluralsight.finance.interfaces.Valuable;

import java.util.ArrayList;

public class Portfolio {

    String name, owner;
    ArrayList<Valuable> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    public double getValue(){
        double sum = 0;
        for( Valuable asset : assets){
            sum+=asset.getValue();
        }
        return sum;
    }

    public double getMostValuable(){
        if (assets.isEmpty())
            return 0;

        double mostValuable = assets.get(0).getValue();
        for (Valuable asset : assets)
            mostValuable = Math.max(mostValuable, asset.getValue());
        return mostValuable;
    }

    public double getLeastValuable(){
        if (assets.isEmpty())
            return 0;

        double leastValuable = assets.get(0).getValue();
        for (Valuable asset : assets)
            leastValuable = Math.min(leastValuable, asset.getValue());
        return leastValuable;
    }
}
