package cs2114.ninjaassassin.graph;

import java.util.*;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Elliott
 * @version Nov 29, 2014
 */

public class ListGraph
    extends AbstractGraph
    implements Graph
{
    // Data Field
    /**
     * An array of Lists to contain the edges that originate with each vertex.
     */
    private List<Edge>[] edges;


    // ----------------------------------------------------------
    /**
     * Construct a graph with the specified number of vertices and
     * directionality.
     *
     * @param numV
     *            The number of vertices
     * @param directed
     *            The directionality flag
     */
    @SuppressWarnings("unchecked")
    public ListGraph(int numV, boolean directed)
    {
        super(numV, directed);
        edges = new List[numV];
        for (int i = 0; i < numV; i++)
        {
            edges[i] = new LinkedList<Edge>();
        }
    }


    // ----------------------------------------------------------
    /**
     * Insert a new edge into the graph.
     *
     * @param edge
     *            The new edge
     */
    public void insert(Edge edge)
    {
        edges[edge.getSource()].add(edge);
        if (!isDirected())
        {
            edges[edge.getDest()].add(new Edge(
                edge.getDest(),
                edge.getSource(),
                edge.getWeight()));
        }
    }


    // ----------------------------------------------------------
    /**
     * Determine whether an edge exists.
     *
     * @param source
     *            The source vertex
     * @param dest
     *            The destination vertex
     * @return true if there is an edge from source to dest
     */
    public boolean isEdge(int source, int dest)
    {
        return edges[source].contains(new Edge(source, dest));
    }


    // ----------------------------------------------------------
    /**
     * Get the edge between two vertices. If an edge does not exist, and Edge
     * with a weight of Double.POSITIVE_INFINITY is returned.
     *
     * @param source
     *            The source
     * @param dest
     *            The destination
     * @return the edge between these two vertices
     */
    public Edge getEdge(int source, int dest)
    {
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
        for (Edge edge : edges[source])
        {
            if (edge.equals(target))
            {
                return edge; // Desired edge found; return it.
            }
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }


    // ----------------------------------------------------------
    /**
     * Gets an iterator for an edge.
     */
    public Iterator<Edge> edgeIterator(int source)
    {
        return edges[source].iterator();
    }
}
