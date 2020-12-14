package graph;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import org.junit.Test;

/**
 * Created by anjunli on  2020/12/14
 **/
public class GoogleGuava {
    @Test
    public void testGraph(){
        //构造一个图
        MutableGraph<Object> graph = GraphBuilder.directed().build();
        //添加节点
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        //添加边
        graph.putEdge("a","b");
        graph.putEdge("a","c");
        graph.putEdge("b","d");
        graph.putEdge("c","e");
        graph.putEdge("e","f");

        //
        System.out.println(graph.toString());
        System.out.println("图所有的节点： "+graph.nodes());
        System.out.println("图所有的边： "+graph.edges());

        System.out.println("节点c有关的边： "+graph.incidentEdges("c"));
        System.out.println("节点c临近的节点： "+graph.adjacentNodes("c"));
        System.out.println("节点c先前的节点： "+graph.predecessors("c"));
        System.out.println("节点c的后续节点： "+graph.successors("c"));

        System.out.println("从a节点可到达的所有节点： "+Graphs.reachableNodes(graph,"a"));
        System.out.println("从c节点可到达的所有节点： "+Graphs.reachableNodes(graph,"c"));


    }

}
