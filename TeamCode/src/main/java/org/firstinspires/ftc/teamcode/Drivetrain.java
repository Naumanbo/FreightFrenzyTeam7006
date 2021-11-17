package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp

public class Drivetrain extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DcMotor FRMotor = null;
    DcMotor FLMotor = null;
    DcMotor BRMotor = null;
    DcMotor BLMotor = null;
    DcMotor RCMotor = null;
    DcMotor LCMotor = null;
    DcMotor CMotor  = null;

    @Override
    public void init()
    {
        telemetry.addData("Status", "Initialized");
        //Naming the motors (names must be the same for code to work)
        FRMotor = hardwareMap.get(DcMotor.class, "fr");
        FLMotor = hardwareMap.get(DcMotor.class, "fl");
        BRMotor = hardwareMap.get(DcMotor.class, "br");
        BLMotor = hardwareMap.get(DcMotor.class, "bl");
        RCMotor = hardwareMap.get(DcMotor.class, "rc");
        LCMotor = hardwareMap.get(DcMotor.class, "lc");
        CMotor  = hardwareMap.get(DcMotor.class, "cm");

        FRMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BRMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");

    }

    @Override
    public void init_loop()
    {

    }

    @Override
    public void start()
    {
        runtime.reset();
    }

    @Override
    public void loop()
    {
        double vertical;
        double horizontal;
        double pivot;
        double collect;
        double carousel = 300;


        vertical = -gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;
        collect = gamepad1.right_stick_y;


        //setPower according to how much a value on the controller changes through stick input
        FRMotor.setPower(pivot + (-vertical + horizontal));
        BRMotor.setPower(pivot + (-vertical - horizontal));
        FLMotor.setPower(pivot + (-vertical - horizontal));
        BLMotor.setPower(pivot + (-vertical + horizontal));
        RCMotor.setPower(collect);
        LCMotor.setPower(-collect);
        if (gamepad1.a)
        {
            CMotor.setPower(carousel);
        }
        else
            {
            CMotor.setPower(0);
            }


        telemetry.addData("Status", "Run Time: " + runtime.toString());

    }

    @Override
    public void stop()
    {

    }
}
