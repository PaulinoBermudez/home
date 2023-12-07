public class MatrizUnidadApp {
  public static void main (String[] args) {
    int[][] mUnidad= new int[4][4];
  
    for (int i=0; i < mUnidad.length; i++) {
        for (int j=0; j < mUnidad[i].length; j++) {
            if (i == j) {
                mUnidad[i][j]=1;
            }else {
                mUnidad[i][j] = 0;
            }
        }
    }

    for (int i=0; i < mUnidad.length; i++) {
        for (int j=0; j < mUnidad[i].length; j++) {
            System.out.print(mUnidad[i][j]+"\t");
        }
        System.out.println("");
    }
  }
}
