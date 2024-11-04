package pluralsight.finance.assets;

import pluralsight.finance.interfaces.Valuable;

public abstract class FixedAsset implements Valuable {

    protected String name;
    double marketValue;

    public FixedAsset(String name, double marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    public abstract double getValue();

    public String getName() {
        return name;
    }
}
