import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
public class SocketEvent extends java.net.Socket implements java.io.Serializable {
    private int eventNo;
    private String text;
    private int Lamport;
    private Vector<Integer> vectorClock;
    private Map<Integer,Vector<Integer>> history;
    public SocketEvent(int eventNo,String text, int Lamport, Vector<Integer> vectorClock){
        this.eventNo = eventNo;
        this.text = text;
        this.Lamport = Lamport;
        this.vectorClock = vectorClock;
        this.history = new HashMap<>();
        this.history.put(this.eventNo,this.vectorClock);
    }
    public SocketEvent withNewText(String text, int Lamport, Vector<Integer> vectorClock){
        return new SocketEvent((int)Math.random()*100+this.eventNo+1,text,Lamport,vectorClock);
    }
}