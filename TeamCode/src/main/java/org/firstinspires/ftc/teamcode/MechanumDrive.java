package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp

public class MechanumDrive extends LinearOpMode {


    public double drive;
    public double strafe;
    public double spin;
    public double intake;
    public double lift;
    public double push;

    HardwareMap robot = new HardwareMap(hardwareMap);

    @Override
    public void runOpMode() throws InterruptedException {

        robot.initialize(hardwareMap);

        // Send message that the robot is ready

        telemetry.addData("Say", "Hello");
        telemetry.update();

        // Waiting to start (Hit play)
        waitForStart();
        // Run until the end of TeleOP (hit STOP)
        while (opModeIsActive()) {

            drive = gamepad1.right_stick_y;
            strafe = -gamepad1.right_stick_x;
            spin = gamepad1.left_stick_x;
            intake = gamepad2.right_stick_y;
            lift = gamepad2.left_stick_y;
            push = gamepad1.left_stick_y;
            //Driver Controlled

            robot.frontRightMotor.setPower(drive - strafe);
            robot.backRightMotor.setPower(drive + strafe);
            robot.frontRightMotor.setPower(-drive - strafe);
            robot.backLeftMotor.setPower(-drive + strafe);

            if (spin > 0.5 || spin < -0.5) {
                robot.frontRightMotor.setPower(spin);
                robot.backRightMotor.setPower(spin);
                robot.frontLeftMotor.setPower(spin);
                robot.backLeftMotor.setPower(spin);
            }


        }


    }
}




