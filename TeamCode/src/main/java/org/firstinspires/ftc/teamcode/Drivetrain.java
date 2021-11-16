package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Drivetrain extends OpMode {

    DcMotor FRMotor;
    DcMotor FLMotor;
    DcMotor BRMotor;
    DcMotor BLMotor;

    public void moveDriveTrain()
    {
        double vertical;
        double horizontal;
        double pivot;

        vertical = -gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;

        FRMotor.setPower(pivot + (-vertical + horizontal));
        BRMotor.setPower(pivot + (-vertical - horizontal));
        FLMotor.setPower(pivot + (-vertical - horizontal));
        FRMotor.setPower(pivot + (-vertical + horizontal));


    }

    @Override
    public void init()
    {
        FRMotor = hardwareMap.get(DcMotor.class, "fr");
        FLMotor = hardwareMap.get(DcMotor.class, "fl");
        BRMotor = hardwareMap.get(DcMotor.class, "br");
        BLMotor = hardwareMap.get(DcMotor.class, "bl");

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
