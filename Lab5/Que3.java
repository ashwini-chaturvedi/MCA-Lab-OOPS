package Lab5;

class ComplexNumber{
    int realNumber;
    int imaginaryNumber;
    String complexNumber;
    ComplexNumber(int realNumber, int imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
        if(imaginaryNumber < 0 ) {
            this.complexNumber=realNumber+""+imaginaryNumber+'i';
        }else{
            this.complexNumber=realNumber+"+"+imaginaryNumber+'i';
        }
    }

    ComplexNumber(ComplexNumber complexNumber) {
        this(complexNumber.realNumber, complexNumber.imaginaryNumber);
    }
}
public class Que3 {
    public static void main(String[] args) {

    }
}
