package Lab5;

class ComplexNumberDesign{

    String complexNumber="";

    ComplexNumberDesign(int real,int imaginary){
        this.complexNumber+=real;

        if(imaginary<0){
            this.complexNumber+=(imaginary)+"i";
        }else if(imaginary>0){
            this.complexNumber+="+"+(imaginary)+"i";
        }
    }

    public String getComplexNumber(){
        return this.complexNumber;
    }
}
public class ComplexNumbers {
    public static void main(String[] args) {
        ComplexNumberDesign number=new ComplexNumberDesign(1,0);
        System.out.println(number.getComplexNumber());


    }
}
