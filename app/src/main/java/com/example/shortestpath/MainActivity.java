package com.example.shortestpath;


import android.graphics.PointF;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphBuilder;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterGraph;
import es.usc.citius.hipster.model.problem.SearchProblem;

public class MainActivity extends AppCompatActivity {



    //Vertex
   // Point pointA = new Point(430, 310); //ST. Pauls General Hospital, Iloilo
   // Point pointB = new Point(920, 310); // Iloilo Provincial Capitol
   // Point pointC = new Point(800, 800); // Marymart Center, Iloilo City
   // Point pointD = new Point(400, 1200); // Mabini St. Robinson's Place, Iloilo City
   // Point pointE = new Point(950, 1050); // Soccorro Drugs
   //Draw points
    PointF drawpointA = new  PointF(430, 310); //ST. Pauls General Hospital, Iloilo
    PointF drawpointB = new  PointF(920, 310); // Iloilo Provincial Capitol
    PointF drawpointC = new  PointF(800, 800); // Marymart Center, Iloilo City
    PointF drawpointD = new  PointF(400, 1200); // Mabini St. Robinson's Place, Iloilo City
    PointF drawpointE = new  PointF(950, 1050); // Soccorro Drugs
    private LineView mLineView;
    //weight in meters based on the haversine app that we made
    double weight_A_B = 265; // St. Pauls <-> Capitol
    double weight_A_C = 499;// St. Pauls <-> Marymart
    double weight_A_D = 845;//St Pauls <-> Robinson
    double weight_B_C= 576;// Capitol <-> Marymart
    double weight_B_E= 704;// Capitol <-> Soccorro
    double weight_C_E= 201;// Marymart <->Soccorro
    double weight_C_D= 434;//Marymart <-> Robinson
    double weight_D_E= 448;//Robinson <-> Soccorro
    //Vertices




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gui initialize
        //output
        TextView shortestpath = (TextView)findViewById(R.id.output);
        Button run = (Button) findViewById(R.id.btn_run);
        EditText init = (EditText)findViewById(R.id.txtfield_initial);
        EditText dest = (EditText)findViewById(R.id.txtfield_destination);
        mLineView = findViewById(R.id.lineView);
        //draw
        mLineView.setPointA(drawpointA);
        mLineView.setPointB(drawpointB);
        mLineView.setPointC(drawpointC);
        mLineView.setPointD(drawpointD);
        mLineView.setPointE(drawpointE);
        mLineView.draw();
        //graph
        HipsterGraph<String,Double> graph =
                GraphBuilder.<String,Double>create()
                        .connect("A").to("B").withEdge(weight_A_B)
                        .connect("A").to("C").withEdge(weight_A_C )
                        .connect("A").to("D").withEdge(weight_A_D)
                        .connect("B").to("C").withEdge(weight_B_C)
                        .connect("B").to("E").withEdge(weight_B_E)
                        .connect("D").to("C").withEdge(weight_C_D)
                        .connect("D").to("E").withEdge(weight_D_E)
                        .connect("C").to("E").withEdge(weight_C_E)
                        /*.connect("A").to("B").withEdge(2d)
                        .connect("A").to("C").withEdge(2d)
                        .connect("A").to("D").withEdge(2d)
                        .connect("B").to("E").withEdge(5d)
                        .connect("B").to("F").withEdge(10d)
                        .connect("B").to("G").withEdge(5d)
                        .connect("B").to("H").withEdge(10d)
                        .connect("C").to("I").withEdge(5d)
                        .connect("C").to("J").withEdge(10d)
                        .connect("C").to("K").withEdge(5d)
                        .connect("K").to("L").withEdge(5d)*/

                        .createUndirectedGraph();
        SearchProblem p = GraphSearchProblem
                .startingFrom("A")
                .in(graph)
                .takeCostsFromEdges()
                .build();
        String results = Hipster.createDijkstra(p).search("E").getOptimalPaths().toString();
        shortestpath.setText(results);



        run.setOnClickListener(v ->{
            String getinit = init.toString();
            String getdest = dest.toString();

        });

    }
    //methods


    //end code

}

