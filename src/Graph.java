import java.util.*;
public interface Graph <T>{
	
	public boolean areConnected(Node v, Node w);
	
	public boolean areConnected(T s1, T s2);
	
	public void printPath(T v, T w);
	
	public T[] getNodesData();
	
	public List<Node> getNodes();
	
	public void connect(Node v, Node w) throws CannotConnectException;
	
	public void addNewNode(T data);
	
	public void addManyNewNodes(T[] data);
	
	public boolean areInEdge(Node v, Node w);
	
	public void printGraph();
}
