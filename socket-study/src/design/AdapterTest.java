package design;

public class AdapterTest {

    public static void main(String[] args) {
        System.out.println("大家好");
        Student student = new Student(){
            @Override
            public void javaStudy() {
                System.out.println("我是一名来自湖南郴州的小伙子");
            }
        };
        student.javaStudy();
        Student student1 = new Student(){
            @Override
            public void playBasketball() {
                System.out.print("阳光，开朗");
            }

            @Override
            public void playFootball() {
                System.out.print("乐观，积极向上");
            }
        };
        student1.playBasketball();
        student1.playFootball();
    }
}
