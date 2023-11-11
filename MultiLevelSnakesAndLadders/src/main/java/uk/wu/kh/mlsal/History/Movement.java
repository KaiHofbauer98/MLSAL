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
package uk.wu.kh.mlsal.History;

import uk.wu.kh.mlsal.Ball.Ball;
import uk.wu.kh.mlsal.Dice.Dice;
import uk.wu.kh.mlsal.Fields.DropField;
import uk.wu.kh.mlsal.Fields.Field;
import uk.wu.kh.mlsal.Fields.LadderField;
import uk.wu.kh.mlsal.Maps.Map;

/**
 * This is the Implementation of AbstractMovement.
 *
 * @see AbstractMovement
 * @author Kai Hofbauer
 */
public class Movement implements AbstractMovement {

    /**
     * @see AbstractMovement
     */
    private Object start;

    /**
     * @see AbstractMovement
     */
    private Object end;

    /**
     * @see AbstractMovement
     */
    private boolean ball_moved = false;

    /**
     * @see AbstractMovement
     */
    private int dice_upper_eye;

    /**
     * @see AbstractMovement
     */
    private Class mvmtClass;

    /**
     * Everyting that happens in a movement can be stored directly while object
     * construction. The Movements will create a histroy wich contains the whole
     * broadgame movement histroy.
     *
     * @param dice
     * @param ball
     * @param map
     */
    public Movement(Dice dice, Ball ball, Map map) {
        //Stores the diced value in this movement.
        this.dice_upper_eye = dice.getUpperEye();

        if (ball.getPosition() == 0) {
            //First draw! There cannot be a Field so it is null.
            this.start = null;
        } else {
            //Stores the start Field object refernce in the start variable.
            this.start = map.getField_array().get(ball.getPosition() - 1);
        }

        int temporaryNextFieldNumber = ball.getPosition() + dice.getUpperEye();
        while (temporaryNextFieldNumber > map.getNumber_of_fields()) {
            //In this loop we try to continue moving the Ball over the boardgame map without
            //breaking the games boundaries with substracting the max number of fields from 
            //the value if it is over the max vaule.
            temporaryNextFieldNumber = temporaryNextFieldNumber - map.getNumber_of_fields();
        }

        /**
         * This very inefficient program structure is written in the false
         * belief that we cannot get the className from the object directly.
         *
         * @see uk.wu.kh.mlsal.alternateFields.Field
         * @deprecated
         */
        //        for (Object field : map.getField_array()) {
        //            if (((Field) field).getFiledNumber() == temporaryNextFieldNumber) {
        //                if (field.getClass().equals(Field.class)) {
        //                    //STANDARD FIELD!
        //                    mvmtClass = Field.class;
        //                    end = field;
        //                    break;
        //                } else {
        //                    if (field.getClass().equals(LadderField.class)) {
        //                        //CLIMB!
        //                        mvmtClass = LadderField.class;
        //                        end = map.getField_array().get(((LadderField) field).getLadderFieldNumber() - 1);
        //                        break;
        //                    } else {
        //                        if (field.getClass().equals(DropField.class)) {
        //                            //DROP!
        //                            mvmtClass = DropField.class;
        //                            end = map.getField_array().get(((DropField) field).getDropFieldNumber() - 1);
        //                            break;
        //                        } else {
        //                            end = null;
        //                            break;
        //                        }
        //                    }
        //                }
        //            }
        //        }
        
        
        //The Logic behind the Ladder- and Drop-Fields is taking action here.
        //The three Field types properties will be triggered after the temporaryNextFieldNumbers
        //connected Field returns its class. After this for each loop the Ball is placed on its designated
        //practical next Field.
        
        //The class can be retrieved directly form the onject!
        mvmtClass = map.getField_array().get(temporaryNextFieldNumber - 1).getClass();
        if (mvmtClass.equals(Field.class)) {
            //STANDARD FIELD!
            end = map.getField_array().get(temporaryNextFieldNumber - 1);
        } else {
            if (mvmtClass.equals(LadderField.class)) {
                //CLIMB!
                //What we want here is the connected field object!
                end = map.getField_array().get(
                        ((LadderField) map.getField_array().get(
                                temporaryNextFieldNumber - 1
                        )).getLadderFieldNumber() - 1
                );
            } else {
                if (mvmtClass.equals(DropField.class)) {
                    //DROP!
                    //What we want here is the connected field object!
                    end = map.getField_array().get(
                            ((DropField) map.getField_array().get(
                                    temporaryNextFieldNumber - 1
                            )).getDropFieldNumber() - 1
                    );
                }
            }
        }
    }

    @Override
    public Object getStart() {
        return start;
    }

    @Override
    public Object getEnd() {
        return end;
    }

    @Override
    public boolean isBall_moved() {
        return ball_moved;
    }

    @Override
    public void setBall_moved(boolean ball_moved) {
        this.ball_moved = ball_moved;
    }

    @Override
    public int getDice_upper_eye() {
        return dice_upper_eye;
    }

    @Override
    public Class getMvmtClass() {
        return mvmtClass;
    }

}
