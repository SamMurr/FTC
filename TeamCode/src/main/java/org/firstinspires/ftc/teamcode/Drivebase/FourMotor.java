package org.firstinspires.ftc.teamcode.Drivebase;


public abstract class FourMotor {

        public static double MAX_SPEED = 1.0;
        public static double[] DIRECTION = {1.0, 1.0, 1.0, 1.0};

        public FourMotor() {}

        public void setMAX_SPEED(double MAX_SPEED){
                FourMotor.MAX_SPEED = MAX_SPEED;} //Set Max Speed

        public void setINVERTED(double[] DIRECTION) {
                FourMotor.DIRECTION = DIRECTION;} //set the direction of motor rotation


}
