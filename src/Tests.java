public class Tests {
    public static void main(String[] args) throws Exception{
        test_exp();
        test_multiply();
        test_devide();
    }
    private static void m_assertIsEqual(float a, float b) throws Exception{
        m_assert(Math.abs(a - b) < Math.abs(Math.min(Math.abs(a), Math.abs(b)) * 1e-3), a + " != " + b + "| diff: " + Math.abs(a-b));
    }
    private static void m_assertIsEqual(Complex a, Complex b) throws Exception{
        m_assertIsEqual(a.real, b.real);
        m_assertIsEqual(a.imaginary, b.imaginary);
    }
    private static void m_assert(boolean condition, String message) throws Exception{
        if (!condition) {
            throw new Exception(message);
        }
        else {
            return;
        }
    }
    private static void m_assert(boolean condition, float message) throws Exception{
        if (!condition) {
            throw new Exception(Float.toString(message));
        }
        else {
            return;
        }
    }
    private static void m_assert(boolean condition) throws Exception{
        if (!condition) {
            throw new Exception();
        }
        else {
            return;
        }
    }
    private static void test_exp() throws Exception{
        Complex c = new Complex(0, (float)-2 * Constants.pi);
        m_assert(c.real == 0 && c.imaginary == (float)-2 * Constants.pi);
        Complex d = c.exp();
        m_assert(d.real - 1 < 1e-5 && d.imaginary < 1e-5, d.toString());
        c = d.exp();
        m_assert(c.real - Constants.e < 1e-5 && c.imaginary - 0 < 1e-5, c.toString());
        Complex e = new Complex(0, Constants.pi);
        e = e.exp();
        m_assert(Math.abs(e.real - (-1)) < 1e-5 && Math.abs(e.imaginary) < 1e-5, "Eulers formula");
        Complex a = new Complex((float)22.5, (float)3);
        a = a.exp();
        m_assertIsEqual(a.real, (float)(-5.85137e9));
        m_assertIsEqual(a.imaginary, (float)(8.34093e8));
    }
    private static void test_multiply() throws Exception {
        Complex c = new Complex(1, 2);
        Complex d = new Complex(-3, -4);
        Complex result = c.multiply(d);
        m_assertIsEqual(result, new Complex(5, -10));
        c = new Complex(12, 13);
        d = new Complex(2, 3);
        result = c.multiply(d);
        m_assertIsEqual(result, new Complex(-15, 62));
        m_assertIsEqual(c.multiply(2), new Complex(24, 26));
    }
    private static void test_devide() throws Exception {
        Complex c = new Complex(1, 2);
        Complex d = new Complex(-3, -4);
        Complex result = c.devide(d);
        m_assertIsEqual(result, new Complex(11, 2).multiply((float)-1/25));
    }
}
