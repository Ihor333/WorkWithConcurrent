package workwithconcurrent;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkWithConcurrent {

    public static void main(String[] args) {
        long multiplyResult;
        int[][] matrix ={
                {3,5,3,8},
                {6,2,1,3},
                {3,7,8,6},
                {4,7,1,9},
        };
        Semaphore semaphore = new Semaphore(1);
        try {
            multiplyResult = 1;
           for(int i = 0;i<matrix.length;i++){
               semaphore.acquire();
               ThreadsManager multiplyThread = new ThreadsManager(matrix[i]);
               multiplyThread.run();
               multiplyResult *= multiplyThread.getMultiplyResult();
               semaphore.release();
           } 
           System.out.println(multiplyResult);
            semaphore.acquire();
            semaphore.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkWithConcurrent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
