public class Polynomial {
    //Properties 
    private double[] coefficients;
    private String poly = "";
    private int degree;
    


    //Conctructors
    //Creates a poylnomial of the type cx^d
    public Polynomial(int d, double c) {
        coefficients = new double[d + 1];
        degree = d;
        coefficients[d] = c;
        

    }
    //Creates a zero polynomial
    public Polynomial() {
        coefficients = new double[1];
        coefficients[0] = 0;
        degree = 0;
    }
    //Creates a polynomial by the coefficiantt input of the user.
    public Polynomial(double[] coef) {
        coefficients = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefficients[i] = coef[i];
            if(i != 0) {
                degree = i;
            }
        }

        
    }
    
    //Methods
    /**
     * Returns the degree of the term at the şnput index.
     * @param i as i being the nth term in the polynomial.Terms with 0 coefficiat excluded.
     * @return the degree of the nth term.
     */
    public double getCoef(int i) {
        return coefficients[i];
        
    }
    /**
     * @return the string version of the polynomial
     */
    public String toString(){
    //For each elemnt entered by the user check if it is zero. If it is zero dont't add it to the polynomial.
    for (int i = 0; i < coefficients.length; i++) {
        //If the coefficiant n is not zero then check if n is the first term of the array.
        if (!(coefficients[i] == 0)) {
            //If it is the first term of the coefficients array, its degree is 0, therefore just write the coefficiant at 0.
                if (i == 0) {
                    poly += coefficients[i];
                }
                //If n is other than zero, add ax^b to the polynomial as a being the nth term of the coefficients array and b being its index in the array.
                if(!(i == 0)) {
                        
                    poly += " + " + coefficients[i] + "x^" + i;
                            
        
                }
            }
        
        }
    return poly;
    }
    /**
     * Gets the highest degree in the polynomial
     * @return the highest degree of a non-zero term.
     */
    public int getDegree() {

        return degree;
    }
    /**
     * evaluates the polynomial at x by doing simple calculations as getting the power and adding.
     * @param x input number from the user where the polynomial should be evaluated
     * @return result of the sum
     */
    public double eval(double x) {
        double result = 0;
        int deg = 0;
        for (double d : coefficients) {
            result += d * Math.pow(x, deg );
            deg++;
        }

        return result;
    }
    /**
     * evaluates the polynomial at x by horner's method.
     * @param x input number from the user where the polynomial should be evaluated
     * @return result of the sum
     */
    public double eval2(double x) {
        double result = 0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            result = coefficients[i] + (x * result);
        }
        return result;
    }

    public Polynomial add(Polynomial polynomial) {
        int degP1 = getDegree();
        int degP2 = polynomial.getDegree();
        Polynomial poly = new Polynomial(Math.max(degP1, degP2), 0);
        if (degP1 >= degP2) {
            for (int i = 0; i <= degP2; i++) {
                poly.setCoef(i, this.getCoef(i) + polynomial.getCoef(i));
            }
            for (int j = degP2 + 1; j <= degP1; j++) {
                poly.setCoef(j, this.getCoef(j));
            }
            return poly;
        } 
        else {
            for (int i = 0; i <= degP1; i++) {
                poly.setCoef(i, this.coefficients[i] + polynomial.getCoef(i));
            }
            for (int j = degP1 + 1; j <= degP2; j++) {
                poly.setCoef(j, polynomial.getCoef(j));
            }
            return poly;
        }
    }

    /**
     * @param p2
     * @return
     */
    public Polynomial sub(Polynomial polynomial) {
        int degP1 = getDegree();
        int degP2 = polynomial.getDegree();
        Polynomial poly = new Polynomial(Math.max(degP1, degP2), 0);
        if (degP1 >= degP2) {
            for (int i = 0; i <= degP2; i++) {
                poly.setCoef(i, this.getCoef(i) - polynomial.getCoef(i));
            }
            for (int j = degP2 + 1; j <= degP1; j++) {
                poly.setCoef(j, this.getCoef(j));
            }
            return poly;
        } 
        else {
            for (int i = 0; i <= degP1; i++) {
                poly.setCoef(i, this.getCoef(i) - polynomial.getCoef(i));
            }
            for (int j = degP1 + 1; j <= degP2; j++) {
                poly.setCoef(j, -1 * polynomial.getCoef(j));
            }
            return poly;
        }
    }

    public Polynomial mul(Polynomial polynomial) {
        int degP1 = getDegree();
        int degP2 = polynomial.getDegree();
        Polynomial poly = new Polynomial(degP1 + degP2, 0);

        for (int i = 0; i <= degP1; i++) {
            for (int j = 0; j <= degP2; j++) {
                poly.setCoef(i + j, polynomial.getCoef(j) * this.getCoef(i) + poly.getCoef(i + j));
            }
        }
        return poly;
    }

    private void setCoef(int i, double d) {
        coefficients[i] = d;
    }

    public Polynomial compose(Polynomial polynomial) {
        int degP1 = this.getDegree();
        int degP2 = polynomial.getDegree();
        Polynomial poly = new Polynomial(degP1 * degP2, 0);
        Polynomial poly2;

        poly = poly.add(new Polynomial(0, this.getCoef(0)));

        for (int i = 1; i <= degP1; i++) {
            poly2 = new Polynomial(0, 1);
            for (int j = 0; j < i; j++) {
                poly2 = poly2.mul(polynomial);
            }
            
            poly = poly.add(poly2.mul(new Polynomial(0, this.getCoef(i))));
        }
        return poly;
    }

    public Polynomial div(Polynomial polynomial) {
        int degP1 = this.getDegree();
        int degP2 = polynomial.getDegree();
        Polynomial tx = new Polynomial(Math.max(degP1, degP2), 0);

        Polynomial Px = new Polynomial(this.coefficients);
        Polynomial Qx = polynomial;
        Polynomial temp = new Polynomial();

        if (degP1 < degP2) {
            Polynomial poly = new Polynomial(0, 0);
            return poly;
        }

        do {
            temp = new Polynomial(degP1 - degP2,Px.getCoef(degP1) / Qx.getCoef(degP2));

            Px = Px.sub(Qx.mul(temp));

            tx = tx.add(temp);
            degP1 -= 1;

            if (temp.getDegree() == 0) {
                break;
            }

        } while (true);

        return tx;

    }
    



    




}
