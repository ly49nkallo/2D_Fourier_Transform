import processing.core.PApplet;

public class App extends PApplet{
    public static final int N = 128;
    public static final int GRID = 3; //width of a grid space in pixels
    public static PApplet ctx;
    public float[] wave;
    public float[] transform;
    public float lambda = 21; //wavelength in pixels
    int IX(int x, int y) {x = constrain(x, 0, N-1); y = constrain(y, 0, N-1); return x + (y * N);}
    int x, y;

    public static void main(String[] args) {
        PApplet.main(App.class);
    }

    public void setup() {
        ctx = this;
        //calculate wave
        wave = new float[N*N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                wave[IX(i, j)] = -(float)(255/2) * (float)Math.sin((double)i / lambda * (3.141592654 * 2)) + (255/2);
            }
        }
    //     F(u,v) = SUM{ f(x,y)*exp(-j*2*pi*(u*x+v*y)/N) }
    //      and
	//      f(x,y) = SUM{ F(u,v)*exp(+j*2*pi*(u*x+v*y)/N) }

    //      where u = 0,1,2,...,N-1 and v = 0,1,2,...,N-1
	//   x = 0,1,2,...,N-1 and y = 0,1,2,...,N-1
	//   and SUM means double summation  over proper
	//   x,y or u,v ranges

        //calculate transform
        transform = new float[N*N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // transform[IX(i, j)] = 
            }
        }
        background(0);
        render_wave();
        render_transform();
        
    }
    public void settings() {
        size(N*GRID, 2*N*GRID);
    }
    public void render_wave() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                float x = i * GRID;
                float y = j * GRID;
                float d = wave[IX(i, j)];
                fill(d);
                noStroke();
                square(x, y, GRID);
            }
        }
    }
    public void render_transform() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                float x = i * GRID;
                float y = (j + N) * GRID; //offset
                Complex d = F(i - (N/2), j-(N/2));
                System.out.println(d.magnitude());
                fill(d.magnitude());
                noStroke();
                square(x, y, GRID);
            }
        }
    }
    Complex F(int u, int v){
        //2D forier transform
        float r = 0;
        float i = 0;
        for (int x = 0; x < N; x++){
            for (int y = 0; y < N; y++){
                Complex c = new Complex((float)0, (float)-2*Constants.pi*((u*x)+(v*y))).exp().multiply(wave[IX(x,y)]).devide(N);
                r += c.real;
                i += c.imaginary;
            }
        }
        return new Complex(r, i);
    }

}



