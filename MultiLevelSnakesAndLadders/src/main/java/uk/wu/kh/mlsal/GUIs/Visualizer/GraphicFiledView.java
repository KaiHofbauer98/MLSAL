/*
* Copyright © Kai Hofbauer – All Rights Reserved
*
* EN
* Unauthorized copying of this software, via any medium is strictly prohibited
* Proprietary and confidential
* Written by Kai Hofbauer kaihofbauer@icloud.com, October 2023
* All components of this software that have not been newly developed (compilers, package sources and archives), as well as the development environment, have been expressly released by the manufacturers for commercial use.
* The newly designed source code and its compilations, however, are newly created intellectual property of Kai Hofbauer for commercial use.
*
* DE
* Unerlaubtes Kopieren dieser Software, egal mit welchem Medium, ist strengstens verboten.
* Proprietär und vertraulich
* Geschrieben von Kai Hofbauer kaihofbauer@icloud.com, Oktober 2023
* Alle nicht neu entwickelten Bestandteile (Compiler, Paketquellen und Archive) dieser Software, sowie die Entwicklungsumgebung sind von den Herstellern für die kommerzielle Nutzung ausdrücklich freigegeben.
* Der neu entworfene Quellcode und seine Kompilierungen sind hingegen für den kommerziellen Gebrauch neu erschaffenes, geistiges Eigentum von Kai Hofbauer.
*
*
* Verwendete Software:
* •	Entwicklungsumgebung:		Apache NetBeans IDE 19	https://netbeans.apache.org/
* •	Programmiersprache:		JAVA
* •	JDK:				21			https://adoptium.net
*
*
* © Kai Hofbauer – 2023
 */
package uk.wu.kh.mlsal.GUIs.Visualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import uk.wu.kh.mlsal.Ball.Ball;
import uk.wu.kh.mlsal.Fields.Field;
import uk.wu.kh.mlsal.Maps.Map;

/**
 * In this class a new JFrame is created and filled up with all a Jpanel for
 * every existing field contained in the map ArrayList. We can use this to make
 * the broadgame information visible to the user. Every JPanel is square and
 * contains its own Field number as Text. The standard color for unused fields
 * is transparent so the gui Look and Feel can still be cahnged. When the ball
 * is moved to a field it turns red.
 *
 * @author Kai Hofbauer
 */
public class GraphicFiledView {

    private static ArrayList<GraphicField> graphicFiledArrayList = new ArrayList<>();
    private static JFrame GraphicFiledViewFrame;
    private static int lastGraphicField = 0;
    private static Map map;

    /**
     * The initialize void generates the JLabels connected to the Fields and
     * stores them into a ArrayList. The ArrayIndexes match thus there are a
     * equal amount.
     *
     * @param mapE
     */
    public static void initialize(Map mapE) {
        map = mapE;
        GraphicFiledViewFrame = new JFrame();
        //We want a square boardgame Map and therefore we need a cube map.
        //120 Fields will be a 12x12 map. 10x10 are 100 Fields.
        GraphicFiledViewFrame.setLayout(new GridLayout(map.getNumber_of_fields() / 10, map.getNumber_of_fields() / 10));

        //Fill up our ArrayList
        for (Field field : map.getField_array()) {
            graphicFiledArrayList.add(new GraphicField(
                    field,
                    new JPanel()
            )
            );
            //We want the JPanels to become opaque.
            graphicFiledArrayList.getLast().getJpanel().setOpaque(true);
            //This creates the JPanels as they are seen on in the GUI.
            graphicFiledArrayList.getLast().getJpanel().setBorder(
                    javax.swing.BorderFactory.createTitledBorder(
                            null,
                            "Field: " + ((Field) field).getFiledNumber(),
                            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                            javax.swing.border.TitledBorder.BELOW_TOP,
                            new java.awt.Font("Helvetica Neue", 0, 18),
                            new java.awt.Color(0, 0, 0)
                    )
            );
        }
        //We need to add the JPanels recurse to match the original broadgame in
        //its order.
        for (int i = graphicFiledArrayList.size() - 1; i >= 0; i--) {
            GraphicFiledViewFrame.add(graphicFiledArrayList.get(i).getJpanel());
        }
        GraphicFiledViewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        GraphicFiledViewFrame.setMinimumSize(new Dimension(900, 900));
        GraphicFiledViewFrame.setTitle("Visualizer");
    }

    /**
     * Everytime the ball gets moved to a new Field, this void is called.
     * @param ball
     */
    public static void actualize(Ball ball) {

        //The Game has ended
        //When the last Field was the maximum of Fields on map, the maximum red
        //Field will be cleaned and the lastField will be resetted to 0.
        if (lastGraphicField == map.getNumber_of_fields()) {
            draw(null);
            lastGraphicField = 0;
        } else {
            //The game has not ended.

            //If the last field is not zero, it will be cleared here.
            if (lastGraphicField != 0) {
                //Resets the old Field
                draw(null);
            } else {
                //No last Field wich draw() could be called on!
            }

            //This is the only time, the balls position will be stored during a
            //actualization.
            lastGraphicField = ball.getPosition();

            //If the game is running, the actual field will be drawed red,
            //in the next move this field will be the old field so we use only
            //one variable - but at this certain point of time it is our actual 
            //Field!
            if (lastGraphicField != 0) {
                draw(Color.red);
            }
        }

        /**
         * @see uk.wu.kh.mlsal.alternateFields.Field
         * @deprecated
         */
        //This old Implementation of the drawing wasted system resources - 
        //It actualizes all 100 jLabels in the jFrame every time the ball is moved!
        //        for (GraphicField graphicField : graphicFiledArrayList) {
        //            if (ball.getPosition() == ((Field) graphicField.getField()).getFiledNumber()) {
        //                graphicField.getJpanel().setBackground(Color.red);
        //            } else {
        //                graphicField.getJpanel().setBackground(null);
        //            }
        //        }
    }

    /**
     * Sets the Jpanel color as it should look like. It is called in actualize().
     * @param color The color of the field, where the ball is on.
     */
    private static void draw(Color color) {
        graphicFiledArrayList.get(lastGraphicField - 1).getJpanel().setBackground(color);
    }

    /**
     * 
     * @return The JFrame for displaying it to the user. (setVisible)
     */
    public static JFrame getGraphicFiledViewFrame() {
        return GraphicFiledViewFrame;
    }

}
