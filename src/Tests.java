public class Tests {
    public static void main(String[] args) throws Exception{
        m_assert(true, "assert is broken");
        m_assert(true);
        test_exp();
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
        m_assert(Math.abs(a.real - (float)(-5.85137e9)) < 1e5 && Math.abs(a.imaginary - (float)(8.34093e8)) < 1e5);
    }
}
