package workwithconcurrent;

public class ThreadsManager implements Runnable{
private int multResalt;
private int[] numbersInArr;

public ThreadsManager(int[] numbers){
    this.numbersInArr =  numbers;
}
@Override
public void run(){
    multResalt = 1;
    for(int i =0; i<numbersInArr.length; i++){
    multResalt*=numbersInArr[i];
}
}
public int getMultiplyResult(){
    return multResalt;
}
}
