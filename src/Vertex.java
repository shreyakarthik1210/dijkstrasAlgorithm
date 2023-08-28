import java.util.*;
public class Vertex implements Comparable<Vertex>{
    private String name;
    private boolean visited;
    private List<Edge> edgeList;
    private int distance;
    private Vertex previous;

    public Vertex(String name)
    {
        this.name = name;
        edgeList = new ArrayList<>();
        distance = Integer.MAX_VALUE;
        previous = null;
        visited = false;
    }

    public int compareTo(Vertex vertex)
    {
        if (this.distance >= vertex.distance)
        {
            return 1;
        }
        return -1;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }
    public int getDistance()
    {
        return distance;
    }
    public boolean isVisited()
    {
        return visited;
    }
    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }
    public List<Edge> getEdgeList()
    {
        return edgeList;
    }
    public void addEdgeList(Edge edge)
    {
        edgeList.add(edge);
    }
    public Vertex getPrevious()
    {
        return previous;
    }
    public void setPrevious(Vertex previous)
    {
        this.previous = previous;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
