
public class ConEdgs {
    private int start;			// Edge start point
    private int end;			// Edge end point
   
    public ConEdgs(int _st, int _e){
        start = _st;
        end = _e; 
    }
    
    public int GetStart() {	return start;  }
    
    public int GetEnd() { return end; }
    
	public String toString() {
		return "Edge(" + start + "," + end + ")";
	}
	
	// Check whether Edge "_edge" is the same as the current one
	public boolean isSameEdge(ConEdgs _edge) {	
		return (start == _edge.GetStart() && end == _edge.GetEnd());
	}
}
