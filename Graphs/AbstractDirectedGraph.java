import com.sun.jdi.request.DuplicateRequestException;

import java.lang.reflect.Array;
import java.util.*;

public class AbstractDirectedGraph {
    private int size;
    private Map<Integer, List<Integer>> graph;

    AbstractDirectedGraph() {
        size = 0;
        graph = new TreeMap<>();
    }

    AbstractDirectedGraph(int size) {
        this.size = size;
        graph = new TreeMap<>();
    }

    public List<Integer> getNodes() {
        return new ArrayList<>(graph.keySet());
    }

    public Map<Integer, List<Integer>> getGraph() {
        return graph;
    }

    public boolean addNode(int node) {
        if (graph.containsKey(node))
            throw new DuplicateRequestException("Node is already present");
        graph.put(node, new ArrayList<>());
        return true;
    }

    public boolean addEdge(int u, int v, int dir) {
        try {
            List<Integer> liU = graph.getOrDefault(u, new ArrayList<>());
            List<Integer> liV = graph.getOrDefault(v, new ArrayList<>());
            liU.add(v);
            if (dir == 2)
                liV.add(u);

            graph.put(u,liU);
            graph.put(v,liV);
            return true;
        } catch (Exception ex) {
            throw new IllegalStateException("This is not valid");
        }
    }

    private void getDfs(List<Integer> dfs , Set<Integer> vis , int node){
        if(vis.contains(node))
            return;

        List<Integer> temp = graph.get(node);
        dfs.add(node);
        vis.add(node);
        for(int i : temp)
            getDfs(dfs,vis,i);
    }

    public List<Integer> dfs(){
        List<Integer> dfs = new ArrayList<>();
        Set<Integer> visited = new TreeSet<>();

        Iterator<Integer> itr = graph.keySet().iterator();
        while(visited.size()<graph.size()&& itr.hasNext()){
            getDfs(dfs,visited,itr.next());
        }

        return dfs;
    }

    public List<Integer> bfs(){
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new TreeSet<>();
        List<Integer> bfs = new ArrayList<>();
        if(!graph.isEmpty()) {
            int firstNode = graph.keySet().iterator().next();
            que.add(firstNode);

            while(!que.isEmpty()){
                int node = que.poll();
                if(!visited.contains(node)){
                    bfs.add(node);
                    visited.add(node);
                    que.addAll(graph.get(node));
                }
            }

            return bfs;
        }
        throw new RuntimeException("Graph is not yet created");
    }
}
