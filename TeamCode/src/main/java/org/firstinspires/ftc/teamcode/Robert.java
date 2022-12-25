package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Drivebase.Mecanum;

@TeleOp(name="Mecanum", group="Linear Opmode")
@Disabled
public class Robert extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        Mecanum drive = new Mecanum(
                new Motor(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_223),
                new Motor(hardwareMap, "frontRight", Motor.GoBILDA.RPM_223),
                new Motor(hardwareMap, "backLeft", Motor.GoBILDA.RPM_223),
                new Motor(hardwareMap, "backRight", Motor.GoBILDA.RPM_223)
        );

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double FORWARD_VEL = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double STRAFE_VEL  =  gamepad1.left_stick_x;
            double ROTATE_VEL  =  gamepad1.right_stick_x;

            drive.moveRobotCentric(FORWARD_VEL, STRAFE_VEL, ROTATE_VEL);


            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("F/S/W", "%4.2f, %4.2f %4.2f", FORWARD_VEL, STRAFE_VEL, ROTATE_VEL);
            telemetry.update();
        }
    }}
