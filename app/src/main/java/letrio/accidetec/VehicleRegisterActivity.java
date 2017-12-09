package letrio.accidetec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VehicleRegisterActivity extends AppCompatActivity {


    private String vName;
    private String vNo;
    private String vBrand;
    private String vModel;
    private String vDriver;

    private TextView vehicleName;
    private TextView vehicleNo;
    private TextView vehicleDriver;
    private TextView vehicleBrand;
    private TextView vehicleModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_register);


        Button registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUserVehicle();

            }
        });






    }





    // User vehicle registration basic details
    //Do database mapping in this fumction or create a separate ONE PRASHANT=====================

    private void registerUserVehicle() {


        vehicleBrand = (TextView) findViewById(R.id.vehicle_brand);
        vehicleDriver = (TextView) findViewById(R.id.vehicle_driver);
        vehicleModel = (TextView) findViewById(R.id.vehicle_model);
        vehicleName = (TextView) findViewById(R.id.vehicle_name);
        vehicleNo = (TextView) findViewById(R.id.vehicle_no);

        vBrand = vehicleBrand.getText().toString();
        vDriver = vehicleDriver.getText().toString();
        vNo = vehicleNo.getText().toString();
        vName = vehicleName.getText().toString();
        vModel = vehicleModel.getText().toString();



        boolean cancel = true;
        View focusView = null;

        if(vName == null){

            cancel = false;
            vehicleName.setError(getString(R.string.no_name));
            focusView = vehicleName;
            focusView.requestFocus();
        }


        if(vBrand == null){

            cancel = false;
            vehicleBrand.setError(getString(R.string.vehicle_brand));
            focusView = vehicleBrand;
            focusView.requestFocus();
        }

        if(vehicleNo.getText().toString().length() < 5){

            cancel = false;
            vehicleNo.setError(getString(R.string.vehicle_no));
            focusView = vehicleNo;
            focusView.requestFocus();
        }


        if(vDriver == null){

            cancel = false;
            vehicleDriver.setError(getString(R.string.vehicle_driver_name));
            focusView = vehicleDriver;
            focusView.requestFocus();
        }


        if(vModel == null){

            cancel = false;
            vehicleModel.setError(getString(R.string.vehicle_model));
            focusView = vehicleModel;
            focusView.requestFocus();
        }



        if(cancel){


            //////////TBD=============================================
            // NEXT WEE WILL PROCEED THE USER TO DASHBOARD


        }





    }
}
