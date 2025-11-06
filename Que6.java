class Polynomials {
    String polynomial = ""; // Initialize here

    Polynomials(int ...args) {
        int degree = args.length-1;
        StringBuilder sb = new StringBuilder();
        boolean onlyZero=true;
        for(int i=degree; i>=0; i--) {
            int coeff=args[degree-i];

            if(coeff==0) {
                onlyZero=false;
                continue;
            }
            onlyZero=true;
            if(i>1){
                sb.append(coeff).append("x^").append(i);
            }else if(i==1){
                sb.append(coeff).append("x");
            }else{
                sb.append(coeff);
            }

            if(i>0)sb.append("+");
        }
        if(!onlyZero){
            sb.append("0");
        }

        this.polynomial = sb.toString();
    }
}

public class Que6 {
    public static void main(String[] args) {
        Polynomials p1 = new Polynomials(3, 2, 1);
        System.out.println("polynomial3 " + p1.polynomial);

        Polynomials p2 = new Polynomials(5, 0, 3, 1);
        System.out.println("polynomial3 " + p2.polynomial);

        Polynomials p3 = new Polynomials(0);
        System.out.println("polynomial3 " + p3.polynomial);
    }
}
