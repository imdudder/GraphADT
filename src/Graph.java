import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    //================================= Public Methods ===============================

    //---------------------------------- Constructor ---------------------------------
    public Graph() {
        vertices = new HashMap<String,Vertex>();
    }


    // Read Graph From File
    public boolean readGraphFromFile(String filename) {
        try {
            File graphFile = new File(filename);
            Scanner reader = new Scanner(graphFile);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] tokens = {"", "", ""};
                int curTok = 0;

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ',') {
                        curTok++;
                        continue;
                    }
                    else {
                        tokens[curTok] += line.charAt(i);
                    }
                }

                String sourceVertex = tokens[0];
                String destVertex = tokens[1];
                int edgeWeight = Integer.parseInt(tokens[2]);

                addVertex(sourceVertex);
                addVertex(destVertex);
                addEdge(sourceVertex, destVertex, edgeWeight);
            }
            return true;
        }
        catch (FileNotFoundException err) {
            return false;
        }
    }

    // Add Vertex
    public boolean addVertex(String vertexName) {
        boolean alreadyExists = vertices.containsKey(vertexName);
        if (!alreadyExists) {
            Vertex v = new Vertex(vertexName);
            vertices.put(vertexName, v);
        }
        return alreadyExists;
    }

    // Add Edge
    public boolean addEdge(String source, String dest, int weight) {
        boolean insertedEdge = false;
        if (vertices.containsKey(source) && vertices.containsKey(dest)) {
            if (!vertices.get(source).hasNeighbor(dest) && !vertices.get(dest).hasNeighbor(source)) {
                vertices.get(source).addNeighbor(dest, weight);
                vertices.get(dest).addNeighbor(source, weight);
                insertedEdge = true;
            }
        }
        return insertedEdge;
    }

    // Dijkstra's Algorithm

    // Breadth-First Search

    // Depth-First Search

    //================================= Private Methods ==============================


    //================================= Internal Classes =============================
    private class Edge {
        public Edge(String dest, int weight) {
            this.destVertex = dest;
            this.weight = weight;
        }
        String destVertex;
        int weight;
    }

    private class Vertex {
        public Vertex() {
            name = "";
            degree = 0;
            neighbors = new ArrayList<Edge>();
            distFromSource = Integer.MAX_VALUE;
            prevVertexInPath = "";
        }

        public Vertex(String name) {
            this.name = name;
            degree = 0;
            neighbors = new ArrayList<Edge>();
            distFromSource = Integer.MAX_VALUE;
            prevVertexInPath = "";
        }

        public boolean hasNeighbor(String destVertex) {
            boolean foundNeighbor = false;
            for (int i = 0; i < neighbors.size(); i++) {
                if (destVertex.equals(neighbors.get(i).destVertex)) {
                    foundNeighbor = true;
                    break;
                }
            }
            return foundNeighbor;
        }

        public boolean addNeighbor(String destVertex, int weight) {
            boolean addedNeighbor = false;
            if (!hasNeighbor(destVertex)) {
                Edge e = new Edge(destVertex, weight);
                neighbors.add(e);
                addedNeighbor = true;
            }
            return addedNeighbor;
        }

        String name;
        int degree;
        ArrayList<Edge> neighbors;

        // Dijkstra's data
        int distFromSource;
        String prevVertexInPath;
    }

    //=================================== Member Data ================================
    private HashMap<String,Vertex> vertices;    // Adjacency list of vertices and edges
}

//--------------------------------------------------------------------------------
//================================================================================