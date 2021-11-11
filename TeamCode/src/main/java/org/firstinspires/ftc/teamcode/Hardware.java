package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware {
    // Create Motors
    public DcMotor frontRightMotor  = null;
    public DcMotor backRightMotor   = null;
    public DcMotor frontLeftMotor   = null;
    public DcMotor backLeftMotor    = null;
    public DcMotor rightCollect     = null;
    public DcMotor leftCollect      = null;
    public DcMotor carouselMotor    = null;
    public DcMotor cascadingMotor   = null;

    // Create Servos

    public Servo conveyorServo     = null;

    // Additional Variables
    HardwareMap hardwareMap        = null;

    public ElapsedTime runtime     = new ElapsedTime();

    public Hardware(HardwareMap hwMap) {
        initialize(hwMap);
    }

    private void initialize(HardwareMap hwMap) {
        hardwareMap     = hwMap;
        // Connect motors NOTE: The name of the motors on FTC APP must be the same as this to identify the motors correctly.
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        frontLeftMotor  = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        backRightMotor  = hardwareMap.get(DcMotor.class, "backRightMotor");
        backLeftMotor   = hardwareMap.get(DcMotor.class, "backLeftMotor");

        conveyorServo   = hardwareMap.get(Servo.class, "conveyorServo");

        //Set up Motor Directions

        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftCollect.setDirection(DcMotor.Direction.REVERSE);
        rightCollect.setDirection(DcMotor.Direction.FORWARD);

        //Set Motor Mode
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        carouselMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        cascadingMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightCollect.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftCollect.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        carouselMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        cascadingMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightCollect.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftCollect.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Set ZERO POWER BEHAVIOR
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        carouselMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        cascadingMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightCollect.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftCollect.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //Set motors to use No power.
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        carouselMotor.setPower(0);
        cascadingMotor.setPower(0);
        rightCollect.setPower(0);
        leftCollect.setPower(0);

    }
}
