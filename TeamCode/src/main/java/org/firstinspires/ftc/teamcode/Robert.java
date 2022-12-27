package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Drivebase.Mecanum;

@TeleOp(name="Mecanum", group="Linear Opmode")
@Disabled
public class Robert extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        Mecanum drive = new Mecanum(
                new Motor(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_223),
                new Motor(hardwareMap, "frontRight", Motor.GoBILDA.RPM_223),
                new Motor(hardwareMap, "backLeft", Motor.GoBILDA.RPM_223),
                new Motor(hardwareMap, "backRight", Motor.GoBILDA.RPM_223)
        );

        RevIMU REV_IMU = new RevIMU(hardwareMap);
        REV_IMU.init();

        GamepadEx Control = new GamepadEx(gamepad1);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        boolean RobotCentric = true;

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
                double FORWARD_VEL = Control.getLeftY();
                double STRAFE_VEL  = Control.getLeftX();
                double ROTATE_VEL  = Control.getRightX();
                double GYRO        = REV_IMU.getAbsoluteHeading();

           if(RobotCentric){
               drive.moveRobotCentric(FORWARD_VEL, STRAFE_VEL, ROTATE_VEL);
           }

           else if(!RobotCentric){
                drive.moveFieldCentric(FORWARD_VEL, STRAFE_VEL, ROTATE_VEL, GYRO);
            }



           RobotCentric = Control.wasJustPressed(GamepadKeys.Button.LEFT_BUMPER) ^ RobotCentric;

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("F/S/W", "%4.2f, %4.2f %4.2f", FORWARD_VEL, STRAFE_VEL, ROTATE_VEL);
            telemetry.update();
        }
    }}
