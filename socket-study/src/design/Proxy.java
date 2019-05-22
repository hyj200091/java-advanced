package design;

public class Proxy implements Subjet {
    @Override
    public void buyMac() {
        //引用并创建真实对象实列  即我
        RealSubject realSubject = new RealSubject();

        //调用真实对象的方法  进行代理购买
        realSubject.buyMac();
        //代理对象额外做的条件
        this.WrapMac();

    }
    public void WrapMac(){
        System.out.println("用盒子包装好Mac");
    }
}
