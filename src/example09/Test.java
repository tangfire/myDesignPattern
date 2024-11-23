package example09;

public class Test {
    public static void main(String[] args) {
        // 顺丰快递的送快递过程
        DeliveryService sfExpress = new SFExpress();
        System.out.println("顺丰快递服务流程：");
        sfExpress.deliverPackage();  // 调用模板方法

        System.out.println("\n-------------------\n");

        // 中通快递的送快递过程
        DeliveryService ztoExpress = new ZTOExpress();
        System.out.println("中通快递服务流程：");
        ztoExpress.deliverPackage();  // 调用模板方法
    }
}

// 快递服务的模板类
abstract class DeliveryService {

    // 模板方法，定义了快递的整体流程
    public final void deliverPackage() {
        takePackage();   // 取件
        transport();     // 运输
        deliver();       // 派送
    }

    // 具体步骤由子类实现
    protected abstract void takePackage(); // 取件
    protected abstract void transport();   // 运输
    protected abstract void deliver();     // 派送

}

// 顺丰快递公司
class SFExpress extends DeliveryService {

    @Override
    protected void takePackage() {
        System.out.println("顺丰快递：上门取件");
    }

    @Override
    protected void transport() {
        System.out.println("顺丰快递：通过空运进行运输");
    }

    @Override
    protected void deliver() {
        System.out.println("顺丰快递：快递员上门派送");
    }
}

// 中通快递公司
class ZTOExpress extends DeliveryService {

    @Override
    protected void takePackage() {
        System.out.println("中通快递：客户送件到门店");
    }

    @Override
    protected void transport() {
        System.out.println("中通快递：通过铁路运输");
    }

    @Override
    protected void deliver() {
        System.out.println("中通快递：快递员派送至指定地址");
    }
}




