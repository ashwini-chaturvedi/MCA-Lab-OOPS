package Lab2;

class WebsiteVisitor{
    public static int counter=0;

    WebsiteVisitor(){
        counter++;

    }
}

public class Que1 {
    public static void main(String[] args) {
        WebsiteVisitor visitor1=new WebsiteVisitor();
        WebsiteVisitor visitor2=new WebsiteVisitor();
        WebsiteVisitor visitor3=new WebsiteVisitor();
        WebsiteVisitor visitor4=new WebsiteVisitor();
        WebsiteVisitor visitor5=new WebsiteVisitor();
        WebsiteVisitor visitor6=new WebsiteVisitor();
        System.out.println("Total Number of Visitors:"+WebsiteVisitor.counter);
    }
}
