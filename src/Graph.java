import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    //================================= Public Methods ===============================


    //================================= Private Methods ==============================


    //================================= Internal Classes =============================
    private class Edge {
        String destVertex;
        int weight;
    }

    private class Vertex {
        String name;
        int degree;
        ArrayList<Edge> neighbors;
    }

    //=================================== Member Data ================================
    HashMap<String,Vertex> vertices;        // 

}

//--------------------------------------------------------------------------------
//================================================================================