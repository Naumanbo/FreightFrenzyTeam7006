package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Drivetrain extends OpMode {

    //Declare variables for motors being used in TeleOp
    DcMotor FRMotor;
    DcMotor FLMotor;
    DcMotor BRMotor;
    DcMotor BLMotor;
    DcMotor RCMotor;
    DcMotor LCMotor;


    public void moveDriveTrain()
    {
        //Establish variables to move motors
        double vertical = 0;
        double horizontal = 0;
        double pivot = 0;
        double collect = 0;

        //Establish Controls for function
        vertical = -gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;
        collect = gamepad1.right_stick_y;

        //setPower according to how much a value on the controller changes through stick input
        FRMotor.setPower(pivot + (-vertical + horizontal));
        BRMotor.setPower(pivot + (-vertical - horizontal));
        FLMotor.setPower(pivot + (-vertical - horizontal));
        FRMotor.setPower(pivot + (-vertical + horizontal));
        RCMotor.setPower(collect);
        LCMotor.setPower(-collect);

    }

    @Override
    public void init()
    {
        //Naming the motors (names must be the same for code to work)
        FRMotor = hardwareMap.get(DcMotor.class, "fr");
        FLMotor = hardwareMap.get(DcMotor.class, "fl");
        BRMotor = hardwareMap.get(DcMotor.class, "br");
        BLMotor = hardwareMap.get(DcMotor.class, "bl");
        RCMotor = hardwareMap.get(DcMotor.class, "rc");
        LCMotor = hardwareMap.get(DcMotor.class, "lc");

        FRMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BRMotor.setDirection(DcMotorSimple.Direction.REVERSE);



    }

    @Override
    public void init_loop()
    {

    }

    @Override
    public void loop()
    {

    }
}
