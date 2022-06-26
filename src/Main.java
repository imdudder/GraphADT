public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        String filePath = getPathToFile("testGraph.txt");
        g.readGraphFromFile(filePath);
        System.out.println("Test");
    }


    public static String getPathToFile(String fileName) {
        String path = System.getProperty("user.dir");
        path += "\\src\\" + fileName;
        return path;
    }
}