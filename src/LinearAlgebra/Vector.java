package LinearAlgebra;

import java.util.Arrays;

public abstract class Vector<T extends Vector<T>> extends LinearAlgebraObject{
    private final float [] data;


    protected Vector(float[] data, int dimension){
        super(dimension);
        this.data = data;
    }


    /*public float [][] getData() {
        return new float[][]{data.clone()};
    }*/


    public float [] getData() {
        return data.clone();
    }


    public float getDataByIndex(int index){
        return data[index];
    }


    public float getX(){
        return getDataByIndex(0);
    }


    public float getY(){
        return getDataByIndex(1);
    }


    protected abstract T createNew(float[] data);


    public T sum(T v2) {
        float[] v2Data = v2.getData();
        float[] resultData = new float[this.data.length];
        for (int i = 0; i < this.data.length; i++){
            resultData[i] = this.data[i] + v2Data[i];
        }
        return createNew(resultData);
    }


    public T subtract(T v2) {
        float[] v2Data = v2.getData();
        float[] resultData = new float[this.data.length];
        for (int i = 0; i < this.data.length; i++){
            resultData[i] = this.data[i] - v2Data[i];
        }
        return createNew(resultData);
    }


    public T multiplyByScalar(float scalar) {
        float[] resultData = new float[this.data.length];
        for (int i = 0; i < this.data.length; i++){
            resultData[i] = this.data[i] * scalar;
        }
        return createNew(resultData);
    }


    public T divisionByScalar(float scalar) {
        if (LinearAlgebraObject.floatIsNotZero(scalar)) {
            return multiplyByScalar(1 / scalar);
        }else {
            throw new IllegalArgumentException("Скаляр равен нулю, а вы на него делите!");
        }
    }


    public T normalization() {
        float lengthVector = this.getLength();
        if (LinearAlgebraObject.floatIsNotZero(lengthVector)) {
            return divisionByScalar(lengthVector);
        } else {
            throw new IllegalArgumentException("Длина вектора равена нулю, а мы на нее делим!");
        }
    }


    public float dotProduct(T v2) {
        float result = 0;
        float[] v2Data = v2.getData();
        for (int i = 0; i < this.data.length; i++) {
            result += this.data[i] * v2Data[i];
        }
        return result;
    }


    public float getLength() {
        float result = 0;
        for (int i = 0; i < this.data.length; i++){
            result += this.data[i] * this.data[i];
        }
        return (float) Math.sqrt(result);
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }else {
            Vector<?> other = (Vector<?>) obj;
            return Arrays.equals(other.getData(), this.getData());
        }
    }


    @Override
    public String toString(){
        return Arrays.toString(this.data);
    }


    public T multiplyByVectorColumn(Matrix m2) {
        if (this.getDimension() == m2.getDimension()) {
            float[][] m2Data = m2.getData();
            float[] resultData = new float[this.data.length];
            for (int i = 0; i < this.data.length; i++) {
                float sum = 0;
                for (int j = 0; j < this.data.length; j++) {
                    sum += this.data[j] * m2Data[i][j];
                }
                resultData[i] = sum;
            }
            return createNew(resultData);
        }else {
            throw new IllegalArgumentException("Размерности не совпадают!");
        }
    }
}