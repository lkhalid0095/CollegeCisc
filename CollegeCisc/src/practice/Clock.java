package practice;

public class Clock{
    private int hours; 
    private boolean isTicking;
    private Integer diff;
    
    public Clock(int hour, boolean ticking, Integer dif){
        
        hours = hour;
        ticking = isTicking;
        diff = new Integer(dif);
    }
}