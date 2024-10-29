package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    private Map<N, Set<N>> edgeList;

    public GraphImpl() {
        edgeList = new TreeMap<>();
    }

    @Override
    public void addNode(final N node) {
        if (node != null) {
            edgeList.putIfAbsent(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(final N source, final N target) {
        if(source != null && target != null){
            edgeList.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return edgeList.keySet();
    }
    @Override
    public Set<N> linkedNodes(final N node) {
        return edgeList.get(node);
    }

    @Override
    public List<N> getPath(final N source, final N target) {
        List<N> path = new LinkedList<>();
        path.addFirst(source);
        for(N node : edgeList.get(source)){
            if(edgeList.containsKey(node)){
                if(edgeList.get(node).contains(target)){
                    path.add(node);
                }
            }
        }
        path.addLast(target);
        return path;
    }

}
