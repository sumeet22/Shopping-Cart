package com.example.appoctect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.carteasy.v1.lib.Carteasy;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private BluetoothAdapter BTAdapter;
    private String TAG = "BTSender";
    private final int REQUEST_ENABLE_BT = 2;


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Button addtocartbtn;
    Toolbar toolbar;
    String productIdOne = "e400";
    String productIdTwo= "e401";

    @Override
    public void onStart() {
        // Check if Bluetooth is enabled, otherwise request user to enable it
        super.onStart();
        Carteasy cs = new Carteasy();
        Map<String, String> data = cs.ViewData(String.valueOf(1), getApplicationContext());
        for (Map.Entry<String, String> entry : data.entrySet()) {
            //get the Id
            Log.d("Key: ",entry.getKey());
            Log.d("Value: ",entry.getValue());
        }
        if (!BTAdapter.isEnabled()) {
            // IT NEEDS BLUETOOTH PERMISSION
            // Intent to enable bluetooth, it will show the enable bluetooth
            // dialog
            Intent enableIntent = new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            // this is to get a result if bluetooth was enabled or not
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
            // It will call onActivityResult method to determine if Bluetooth
            // was enabled or not
        } else {
            // Bluetooth is enabled
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "**Window created");
        // Get the bluetooth adapter
        BTAdapter = BluetoothAdapter.getDefaultAdapter();
        // If null, that means bluetooth is not supported on the device
        if (BTAdapter == null) {
            Toast.makeText(this, "Bluetooth not supported",
                    Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();

        ArrayList<Items> itemsArrayList = new ArrayList<>();
        itemsArrayList.add(new Items(R.drawable.chocolate1, "Snickers", Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
        itemsArrayList.add(new Items(R.drawable.chocolate2, "Cadbury DairyMilk", Utils.QUANTITY_IN_KG2, Utils.KG2, Utils.RUPEE2, Utils.AMOUNT2, Utils.RUPEE2_2, Utils.AMOUNT2_2, Utils.QUANTITY2));
        itemsArrayList.add(new Items(R.drawable.chocolate3, "Bernique", Utils.QUANTITY_IN_KG3, Utils.KG3, Utils.RUPEE3, Utils.AMOUNT3, Utils.RUPEE3_3, Utils.AMOUNT3_3, Utils.QUANTITY3));
        itemsArrayList.add(new Items(R.drawable.chocolate4, "Seed and Bean", Utils.QUANTITY_IN_KG4, Utils.KG4, Utils.RUPEE4, Utils.AMOUNT4, Utils.RUPEE4_4, Utils.AMOUNT4_4, Utils.QUANTITY4));

        itemsArrayList.add(new Items(R.drawable.drinks1, "Sunkist", Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, "1.2", Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
        itemsArrayList.add(new Items(R.drawable.drinks2, "Fanta", Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, "1.5", Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
        itemsArrayList.add(new Items(R.drawable.drinks3, "Sprite", Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, "1.8", Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
        itemsArrayList.add(new Items(R.drawable.drinks4, "Coca-Cola", Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, "2", Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));

        itemsArrayList.add(new Items(R.drawable.eatables1, "Jack'nJill Potato Chips", Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, "0.9", Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
        itemsArrayList.add(new Items(R.drawable.eatables2,"Calbee Hot &Spicy", Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, "1.1", Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
        itemsArrayList.add(new Items(R.drawable.eatables3,"Irvin's Potato Chips" , Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, "1", Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
        itemsArrayList.add(new Items(R.drawable.eatables4, "Jamon Iberico" , Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, "4", Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));






        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new ItemsAdapter(itemsArrayList);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        addtocartbtn = findViewById(R.id.addtocartbtn);
        addtocartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Items> itemsArrayList = new ArrayList<>();
                itemsArrayList.add(new Items(R.drawable.chocolate1, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
                itemsArrayList.add(new Items(R.drawable.chocolate2, Utils.TITLE2, Utils.QUANTITY_IN_KG2, Utils.KG2, Utils.RUPEE2, Utils.AMOUNT2, Utils.RUPEE2_2, Utils.AMOUNT2_2, Utils.QUANTITY2));
                itemsArrayList.add(new Items(R.drawable.chocolate3, Utils.TITLE3, Utils.QUANTITY_IN_KG3, Utils.KG3, Utils.RUPEE3, Utils.AMOUNT3, Utils.RUPEE3_3, Utils.AMOUNT3_3, Utils.QUANTITY3));
                itemsArrayList.add(new Items(R.drawable.chocolate4, Utils.TITLE4, Utils.QUANTITY_IN_KG4, Utils.KG4, Utils.RUPEE4, Utils.AMOUNT4, Utils.RUPEE4_4, Utils.AMOUNT4_4, Utils.QUANTITY4));

                itemsArrayList.add(new Items(R.drawable.drinks1, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
                itemsArrayList.add(new Items(R.drawable.drinks2, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
                itemsArrayList.add(new Items(R.drawable.drinks3, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
                itemsArrayList.add(new Items(R.drawable.drinks4, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));

                itemsArrayList.add(new Items(R.drawable.eatables1, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
                itemsArrayList.add(new Items(R.drawable.eatables2, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
                itemsArrayList.add(new Items(R.drawable.eatables3, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));
                itemsArrayList.add(new Items(R.drawable.eatables4, Utils.TITLE1, Utils.QUANTITY_IN_KG1, Utils.KG1, Utils.RUPEE1, Utils.AMOUNT1, Utils.RUPEE1_1, Utils.AMOUNT1_1, Utils.QUANTITY1));

                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                adapter = new ItemsAdapter(itemsArrayList);
                layoutManager = new LinearLayoutManager(getApplicationContext());

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(layoutManager);

                Toast.makeText(getApplicationContext(), "Item Dispensed", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_filter:
                Toast.makeText(this, "Filter", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this, "No Option Selected", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }


    // this will be called when in onStart method startActivityForResult is
    // executed
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(TAG, "** onActivityResult **");
        // determine from which activity
        switch (requestCode) {
            // if it was the request to enable Bluetooth:
            case REQUEST_ENABLE_BT:
                if (resultCode == Activity.RESULT_OK) {
                    // Bluetooth is enabled now
                    Log.v(TAG, "** Bluetooth is now enabled**");
                } else {
                    // user decided not to enable Bluetooth so exit application
                    Log.v(TAG, "** Bluetooth is NOT enabled**");
                    Toast.makeText(this, "Bluetooth not enabled",
                            Toast.LENGTH_LONG).show();
                    finish();
                }
        }
    }
}