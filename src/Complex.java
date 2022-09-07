
public class Complex{
    float real, imaginary;
    Complex(float r, float i){
        real = r; imaginary = i;
    }
    Complex conjugate() {
        // (a + bi) -> (a - bi)
        return new Complex(this.real, -1 * this.imaginary);
    }
    Complex multiply(Complex other){
        // (a + bi) * (c + di) = ac - bd + (bc + ad)i
        return new Complex((this.real * other.real) - (this.imaginary * other.imaginary), 
                            (this.imaginary * other.real) + (this.real * other.imaginary));
    }
    Complex multiply(int c){
        // (a + bi) * c = ac + bci
        return new Complex(this.real * c, this.imaginary * c);
    }
    Complex multiply(float c){
        // (a + bi) * c = ac + bci
        return new Complex(this.real * c, this.imaginary * c);
    }
    Complex devide(Complex other){
        // (a + bi) / (c + di) = (a + bi)(c - di) / (c^2 + d^2)
        return this.multiply(other.conjugate()).devide(
                (other.real * other.real) + (other.imaginary * other.imaginary));
    }
    Complex devide(int c){
        // (a + bi) / c = (a/c) + (b/c)i
        return new Complex(this.real / c, this.imaginary / c);
    }
    Complex devide(float c){
        // (a + bi) / c = (a/c) + (b/c)i
        return new Complex(this.real / c, this.imaginary / c);
    }
    Complex add(Complex other){
        //(a + bi) + (c + di) = (a + c) + (b + d)i
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }
    Complex add(int c){
        //(a + bi) + c = (a + c) + bi
        return new Complex(this.real + c, this.imaginary);
    }
    Complex add(float c){
        //(a + bi) + c = (a + c) + bi
        return new Complex(this.real + c, this.imaginary);
    }
    Complex exp(){
        //e^(a + bi) = e^a * e^bi = e^a * cos(b) + isin(b)
        return new Complex((float)Math.exp(this.real) * (float)Math.cos(this.imaginary), 
        (float)Math.exp(this.real) * (float)Math.sin(this.imaginary));
    }
    float magnitude(){
        return (float)Math.sqrt((this.real * this.real) + (this.imaginary * this.imaginary));
    }
    float phase(){
        return (float)Math.atan(this.imaginary/this.real);
    }
    @Override
    public String toString(){
        return "[" + this.real + " + " + this.imaginary + "i]";
    }
}
