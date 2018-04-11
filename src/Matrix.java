/**
 * The Matrix program implements an application that
 * simply do two  matrixes caculations include :
 * sum , subtraction and multiplication two matrixes
 * @since 2018
 * @author Azhdari Muhammad
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List ;

public class Matrix {
    private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>() ;

    public Matrix ( ArrayList<ArrayList<Integer>> matrix ){
        this.matrix = matrix ;
    }

    public Matrix sum ( Matrix matrix2 ) {
        if ( this.matrix.size() != matrix2.getMatrix().size() || this.matrix.get(0).size() != matrix2.getMatrix().get(0).size() ) {
            System.err.println("can not sum these matrixes . ");
            System.exit(1);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>() ;
        for (int i = 0 ; i < matrix2.getMatrix().size() ; i++ ) {
            result.add(new ArrayList<Integer>()) ;
            for ( int j = 0 ; j < matrix2.getMatrix().get(0).size() ; j++ ) {
                result.get(i).add(matrix.get(i).get(j) + matrix2.getMatrix().get(i).get(j)) ;
            }
        }
        return new Matrix(result) ;
    }

    public Matrix sub ( Matrix matrix2 ) {
        if ( this.matrix.size() != matrix2.getMatrix().size() || this.matrix.get(0).size() != matrix2.getMatrix().get(0).size() ) {
            System.err.println("can not sum these matrixes . ");
            System.exit(1);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>() ;
        for (int i = 0 ; i < matrix2.getMatrix().size() ; i++ ) {
            result.add(new ArrayList<Integer>()) ;
            for ( int j = 0 ; j < matrix2.getMatrix().get(0).size() ; j++ ) {
                result.get(i).add(matrix.get(i).get(j) - matrix2.getMatrix().get(i).get(j)) ;
            }
        }
        return new Matrix(result) ;
    }

    public Matrix numberMuti ( int factor ) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>() ;

        for ( int i = 0 ; i < matrix.size() ; i ++ ) {
            result.add(new ArrayList<Integer>()) ;
            for ( int j = 0 ; j < matrix.get(0).size() ; j++ ) {
                result.get(i).add(factor * matrix.get(i).get(j)) ;
            }
        }
        return new Matrix(result) ;
    }

    public Matrix multiplication ( Matrix matrix2 ) {

        if (matrix.get(0).size() != matrix2.getMatrix().size() ){
            System.err.println("can not multiplication .");
            System.exit(1);
        }
        int temp = 0;

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>() ;
        for ( int i = 0 ; i < matrix.size() ; i++ ) {
            result.add( new ArrayList<Integer>()) ;
            for ( int j = 0 ; j < matrix.size() ; j++ ) {
                temp = 0 ;
                for ( int k = 0 ; k < matrix.get(0).size() ; k++ ) {
                    temp = temp + (matrix.get(i).get(k) * matrix2.getMatrix().get(k).get(j)) ;

                }
                result.get(i).add(temp) ;
            }
        }
        return new Matrix(result) ;
    }

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }
    public void printMatrix () {
        for (ArrayList<Integer> a : matrix ) {
            for (Integer i : a ) {
                System.out.print(i+" ");
            }
            System.out.printf("\n");
        }
    }
}
