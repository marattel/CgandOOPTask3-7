package LinearAlgebra;

public class Matrix4x4 extends Matrix<Matrix4x4>{
    public Matrix4x4(float [][] data){
        if (data.length != 4 || data[0].length != 4){
            throw new IllegalArgumentException("Вы пытаетесь создать матрицу 4x4, но передаете массив неправильной длины!");
        }
        super(data, 4);
    }


    @Override
    protected Matrix4x4 createNew(float[][] data) {
        return new  Matrix4x4(data);
    }


    @Override
    public Matrix4x4 oneMatrix() {
        float [][] resultData = new float[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (i == j) {
                    resultData[i][j] = 1;
                }else {
                    resultData[i][j] = 0;
                }
            }
        }
        return new Matrix4x4(resultData);
    }


    @Override
    public Matrix4x4 zeroMatrix() {
        float [][] resultData = new float[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                resultData[i][j] = 0;
            }
        }
        return new Matrix4x4(resultData);
    }
}
