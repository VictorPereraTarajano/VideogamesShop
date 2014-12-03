package discount;

public abstract class Discount {
    private String imagename; 
    private String name;
    
    public Discount (String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
    
    public int getRated () {
        return 0;
    }
    
    public abstract boolean isRated ();
}
