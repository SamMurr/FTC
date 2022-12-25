package org.firstinspires.ftc.teamcode.Lifts;



import com.arcrobotics.ftclib.hardware.motors.Motor;


public class ContinousLinearExtension {

    Motor extension;
    double MAX_SPEED = 1.0;
    double DIRECTION = 1.0;

    public ContinousLinearExtension(Motor extension){
        this.extension = extension;
    }

    public void setMAX_SPEED(double MAX_SPEED){ this.MAX_SPEED = MAX_SPEED;}

    public void stop() {extension.stopMotor();}

    public void setINVERTED(Boolean setInverted) {if (setInverted) {this.DIRECTION = -1.0;}}

    public void  move(double power) {extension.set(power * DIRECTION);}

}





