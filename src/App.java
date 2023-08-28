import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        String filename = "data.txt";
        List<String> data = readData(filename);
        Map<String, Vertex> graph = getGraph(data);

        Vertex start = graph.get("A"); //assigned start vertex
        Vertex end = graph.get("G"); //assigned end vertex

        //DijkstrasAlgorithm da = new DijkstrasAlgorithm(); 
        DijkstrasAlgorithm.computePath(start);
        List<Vertex> path = DijkstrasAlgorithm.getPath(end);
        System.out.println("\nPath from " + start + " to " + end + " = " + path);
        System.out.println("Distance from " + start + " to " + end + " = " + end.getDistance());

    }

    public static Map<String, Vertex> getGraph(List<String> data) //returns map where key is vertex name and value is vertex
    {
        Map<String, Vertex> map = new HashMap<>();
        String[] array = data.get(0).split(" ");
        for (String name: array)
        {
            Vertex current = new Vertex(name);
            map.put(name, current);
        }
        for (int i = 1; i < data.size(); i++)
        {
            String[] arr = data.get(i).split(" ");
            Vertex v = map.get(arr[0]);
            Edge edge = new Edge(map.get(arr[1]), Integer.parseInt(arr[2]));
            v.addEdgeList(edge);
        }
        return map;
    }

    public static List<String> readData(String filename)
    {
        List<String> list = new ArrayList<>();
        try{
            Scanner input = new Scanner (new File(filename));
            while(input.hasNextLine())
            {
                list.add(input.nextLine());
            }
        }   catch (FileNotFoundException ex)
        {
            System.err.println("Find not found");
        }
        return list;
    }
}
