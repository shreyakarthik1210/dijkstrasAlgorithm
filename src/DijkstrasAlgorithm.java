import java.util.*;
public class DijkstrasAlgorithm {
    //Given the start vertex, minimum distance to each vertex is found
    //This method sets the distance and previous fields for each visited vertex
    public static void computePath(Vertex start)
    {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(start);
        start.setDistance(0);
        start.setVisited(true);
        while(!pq.isEmpty())
        {
            Vertex vertex = pq.poll();
            for (Edge edge: vertex.getEdgeList())
            {
                Vertex target = edge.getTarget();
                if (target.getDistance() > vertex.getDistance() + edge.getWeight())
                {
                    target.setDistance(vertex.getDistance() + edge.getWeight());
                    target.setPrevious(vertex);
                    pq.add(target);
                }
            }
        }
    }

    //Given the ending vertex, returns a list of vertices that make up the shortest path
    public static List<Vertex> getPath(Vertex end)
    {
        List<Vertex> list = new ArrayList<>();
        while(end != null)
        {
            list.add(0, end);
            end = end.getPrevious();
        }
        return list;
    }
}
