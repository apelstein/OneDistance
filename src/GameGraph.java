import java.util.*;
import java.util.stream.Collectors;
public class GameGraph implements Graph<String>{
	
	Map<Node, Set<Node>> nodes;
	int k;
	Map<Node, Node> parents;
	
	public GameGraph(int k){
		this.k = k;
		nodes = new HashMap<>();
	}
	
	private Node getNode(String data){
		for(Node node: nodes.keySet()){
			if(node.data.equals(data)){
				return node;
			}
		}
		return null;
	}
	
	public boolean areConnected(String s1, String s2){
		return areConnected(getNode(s1), getNode(s2));
	}
	
	public void printPath(String v, String w){
		printPath(getNode(v), getNode(w));
	}
	
	private void printPath(Node v, Node w){
		if(v == null || w == null){
			System.out.println("nodes are not exist");
			return;
		}
		if(!areConnected(v, w)){
			System.out.println("Nodes Are not connected");
			return;
		}
		ArrayList<Node> path = new ArrayList<>();
		path.add(w);
		Node parent = parents.get(w);
		while(parent != null){
			path.add(0, parent);
			if(parent == v){
				path.forEach(node-> {
					System.out.print(node.data + " -> ");
				});
				System.out.println("[X]");
				return;
			}
			parent = parents.get(parent);
		}
		System.out.println("Nodes are not connected");
		return;
	}
	
	public boolean areConnected(Node v, Node w){
		parents = new HashMap<>();
		if(v.equals(w)){
			return true;
		}
		Map<Node, Boolean> colors = new HashMap<>();
		nodes.keySet().forEach(node -> {
			colors.put(node, false);
		});
		LinkedList<Node> q = new LinkedList<>();
		q.add(v);
		while(!q.isEmpty()){
			Node node = q.pollFirst();
			colors.put(node, true);
			boolean[] canReturn = new boolean[1];
			nodes.get(node).forEach(nei -> {
				if(!colors.get(nei)){
					colors.put(nei, true);
					parents.put(nei, node);
					if(nei.equals(w)){
						canReturn[0] = true;
					}
					q.addLast(nei);
				}
			});
			if(canReturn[0]){
				return true;
			}
		}
		return false;
	}
	
	public String[] getNodesData(){
		return getNodes().stream().map(node -> node.data)
				.collect(Collectors.toList()).toArray(new String[0]);
	}
	
	public List<Node> getNodes(){
		return nodes.keySet().stream().collect(Collectors.toList());
	}
	
	public void connect(Node v, Node w) throws CannotConnectException{
		if(StringUtils.isDistanceOne(v.data, w.data, k)){
			nodes.get(v).add(w);
			nodes.get(w).add(v);
		} else {
			throw new CannotConnectException();
		}
	}
	
	public void addNewNode(String data){
		Node newNode = new Node(data);
		nodes.put(newNode, new HashSet<Node>());
		int[] connected = new int[1];
		int[] notConected = new int[1];
		nodes.keySet().forEach(v -> {
			try {
				connect(newNode, v);
				connected[0]++;
			} catch (CannotConnectException e){
				notConected[0]++;
			}
		});
		System.out.println(data + " was conneected: " + connected[0] 
				+ " wasnt connected: " + notConected[0] 
						+ "\ntotal nodes: " + nodes.size());
		
	}
	
	public void addManyNewNodes(String[] data){
		for(String w: data){
			addNewNode(w);
		}
	}
	
	public boolean areInEdge(Node v, Node w){
		return nodes.get(v).contains(w);
	}
	
	public void printGraph(){
		nodes.keySet().forEach(node -> {
			System.out.print(node.data + ": [");
			nodes.get(node).forEach(neigh -> {
				System.out.print(neigh.data + ", ");
			});
			System.out.println("]");
		});
	}
	

}
