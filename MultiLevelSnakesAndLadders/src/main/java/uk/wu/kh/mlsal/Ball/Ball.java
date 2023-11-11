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
package uk.wu.kh.mlsal.Ball;

import uk.wu.kh.mlsal.Maps.Map;
import uk.wu.kh.mlsal.GUIs.Visualizer.GraphicFiledView;

/**
 * This class displays a simple wooden ball for a boardgame that will be moved
 * with the hand over the boardgame fields. I could have linked the field
 * objects to the ball class but I simplified it with a number within the field
 * range.
 *
 * @author Kai Hofbauer
 */
public class Ball {

    /**
     * The actual position of the ball, wich stands for a field number the ball
     * is placed on.
     */
    private int position = 0;

    /**
     * The reference on the map object is needed to determine the maps number of
     * fields for the ball placement.
     */
    private static Map map;

    /**
     * The constructor needs the map to determine the maps number of fields for
     * the ball placement.
     *
     * @param map
     */
    public Ball(Map map) {
        Ball.map = map;
    }

    /**
     * @return The actual position of the ball, wich stands for a field number
     * the ball is placed on.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set the balls position after rolling the dice, this void symbolizes the
     * placement of the ball on the field wich was diced.
     *
     * @param position
     * @throws Exception The ball cannot be placed on a field out of the map
     * field range
     */
    public final void setPosition(int position) throws Exception {
        if (position <= map.getNumber_of_fields()) {
            this.position = position;
            GraphicFiledView.actualize(this);
        } else {
            throw new Exception(
                    "The ball cannot be placed on a field out of the map field range: "
                    + map.getNumber_of_fields()
            );
        }

    }

}
