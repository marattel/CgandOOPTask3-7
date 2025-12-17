package LinearAlgebra;

import java.util.Arrays;

public abstract class Matrix<T extends Matrix<T>> extends LinearAlgebraObject{
    private final float[][] data;


    public Matrix(float[][] data, int dimension){
        this.data = data;
        super(dimension);
    }


    public float[][] getData() {
        return data.clone();
    }

    protected abstract T createNew(float[][] data);
    public abstract T zeroMatrix();
    public abstract T oneMatrix();


    public T sum(T m2) {
        float[][] m2Data = m2.getData();
        float[][] resultData = new float[this.data.length][this.data.length];
        for (int i = 0; i < this.data.length; i++){
            for (int j = 0; j < this.data[i].length; j++) {
                resultData[i][j] = this.data[i][j] + m2Data[i][j];
            }
        }
        return createNew(resultData);
    }


    public T subtract(T m2) {
        float[][] m2Data = m2.getData();
        float[][] resultData = new float[this.data.length][this.data.length];
        for (int i = 0; i < this.data.length; i++){
            for (int j = 0; j < this.data[i].length; j++) {
                resultData[i][j] = this.data[i][j] + m2Data[i][j];
            }
        }
        return createNew(resultData);
    }


    public T multiply(T m2) {
        float[][] m2Data = m2.getData();
        float[][] resultData = new float[this.data.length][this.data.length];
        for (int i = 0; i < this.data.length; i++){
            for (int j = 0; j < this.data[i].length; j++) {
                float sum = 0;
                for (int k = 0; k < this.data.length; k++){
                    sum += this.data[i][j] + m2Data[i][j];
                }
                resultData[i][j] = sum;
            }
        }
        return createNew(resultData);
    }


    public T transpose() {
        float[][] resultData = new float[this.data.length][this.data.length];
        for (int i = 0; i < this.data.length; i++){
            for (int j = 0; j < this.data[i].length; j++) {
                resultData[i][j] = this.data[j][i];
            }
        }
        return createNew(resultData);
    }


    /*
    public Vector multiplyByVector(Vector v2) {
        float[] v2Data = v2.getData();
        float[] resultData = new float[this.data.length];
        for (int i = 0; i < this.data.length; i++){
            float sum = 0;
            for (int j = 0; j < this.data[i].length; j++) {
                sum += this.data[i][j] * v2Data[j];
            }
            resultData[i] = sum;
        }
        return new Vector(resultData);
    }
 */


    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }else {
            Matrix<?> other = (Matrix<?>) obj;
            if (Arrays.equals(other.getData(), this.getData())){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString(){
        return Arrays.toString(this.data);
    }
}
