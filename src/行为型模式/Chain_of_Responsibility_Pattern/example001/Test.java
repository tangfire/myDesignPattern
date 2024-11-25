package 行为型模式.Chain_of_Responsibility_Pattern.example001;

public class Test {
    public static void main(String[] args) {
        Postman beijingPostman = new BeijingPostman();
        Postman guangzhouPostman = new GuangZhouPostman();
        beijingPostman.nextPostman = guangzhouPostman;
        beijingPostman.handleCourier("Guangzhou");
    }

}


abstract class Postman{
    protected Postman nextPostman;
    public abstract void handleCourier(String address);

}

class BeijingPostman extends Postman{
    @Override
    public void handleCourier(String address) {
        if(address.equals("Beijing")){
            System.out.println("派送到北京");
            return;
        }else{
            nextPostman.handleCourier(address);
        }
    }
}

class GuangZhouPostman extends Postman{
    @Override
    public void handleCourier(String address) {
        if(address.equals("Guangzhou")){
            System.out.println("派送到广州");
            return;
        }else{
            if(nextPostman != null){
                nextPostman.handleCourier(address);
            }
        }
    }
}

