public class SeasonalOffer implements IOffer{
    
    @Override
    public boolean isApplicable(){
        return true;
    }

    @Override
    public double applyOffer(Product product){
        return product.getPrice() * 0.10; //10% seasonal discount
    }
}
