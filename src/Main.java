import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        String filePath = getPathToFile("testGraph.txt");
        g.readGraphFromFile(filePath);

        ArrayList<String> pathFromAToD = g.dijkstrasShortestPath("A","D");
        System.out.print("Path from A To D: ");
        for (String vtx : pathFromAToD) {
            System.out.print(vtx + ", ");
        }
    }


    public static String getPathToFile(String fileName) {
        String path = System.getProperty("user.dir");
        path += "\\src\\" + fileName;
        return path;
    }
}