import LinearAlgebra.Vector2D;

public class Main {
    public static void main(String[] args) {
        float[] vData = {1,2};
        float[] v1Data = {3,4};
        Vector2D v = new Vector2D(vData);
        Vector2D v1 = new Vector2D(v1Data);
        System.out.println(v.subtract(v1).toString());
    }
}