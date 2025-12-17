package LinearAlgebra;

public class Matrix3x3 extends Matrix<Matrix3x3>{
    public Matrix3x3(float [][] data){
        if (data.length != 3 || data[0].length != 3){
            throw new IllegalArgumentException("Вы пытаетесь создать матрицу 3x3, но передаете массив неправильной длины!");
        }
        super(data, 3);
    }


    @Override
    protected Matrix3x3 createNew(float[][] data) {
        return new  Matrix3x3(data);
    }


    @Override
    public Matrix3x3 oneMatrix() {
        float [][] resultData = new float[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (i == j) {
                    resultData[i][j] = 1;
                }else {
                    resultData[i][j] = 0;
                }
            }
        }
        return new Matrix3x3(resultData);
    }


    @Override
    public Matrix3x3 zeroMatrix() {
        float [][] resultData = new float[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                resultData[i][j] = 0;
            }
        }
        return new Matrix3x3(resultData);
    }
}
