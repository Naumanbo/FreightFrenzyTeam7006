package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TeleOpNauman",
        group="Pushbot")



public class MechanumDrive extends LinearOpMode {
    Hardware robot = new Hardware();

    double drive;
    double strafe;
    double spin;
    double intake;
    double lift;
    double push;

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




