package com.example.mohitsaini.fragmentexample.android.bluetooth;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by mohitsaini on 28/4/17.
 */

public class Bluetoothjavatpoint extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVERABLE_BT = 0;
    final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    ListView lv;
    ArrayList list;
    Button scan, bList;
    String deviceName, onDevices[];
    ProgressDialog progressDialog;

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                //discovery starts, we can show progress dialog or perform other tasks
                progressDialog = new ProgressDialog(Bluetoothjavatpoint.this);
                progressDialog.setTitle("Scanning Devices");
                progressDialog.setMessage("Scanning............");
                progressDialog.show();
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                //discovery finishes, dismis progress dialog
                progressDialog.dismiss();
            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                //bluetooth device found
                BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                list.add(device.getName());
                Toast.makeText(Bluetoothjavatpoint.this, "Found device " + device.getName(),
                        Toast.LENGTH_SHORT).show();

                final ArrayAdapter adapter = new ArrayAdapter(Bluetoothjavatpoint.this, android.R.layout.simple_list_item_1, list);
                lv.setAdapter(adapter);
            }
        }
    };
    BluetoothDevice result = null;
    Set<BluetoothDevice> devices = mBluetoothAdapter.getBondedDevices();

    private Set<BluetoothDevice> pairedDevices;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ble_java_t_point);

        final TextView out = (TextView) findViewById(R.id.out);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        bList = (Button) findViewById(R.id.list);
        scan = (Button) findViewById(R.id.scan);
        lv = (ListView) findViewById(R.id.bluetooth_list);

        list = new ArrayList();

        if (mBluetoothAdapter == null) {
            out.append("device not supported");
        }
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (!mBluetoothAdapter.isDiscovering()) {
                    //out.append("MAKING YOUR DEVICE DISCOVERABLE");
                    Toast.makeText(getApplicationContext(), "MAKING YOUR DEVICE DISCOVERABLE",
                            Toast.LENGTH_LONG);

                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(enableBtIntent, REQUEST_DISCOVERABLE_BT);

                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBluetoothAdapter.disable();
                //out.append("TURN_OFF BLUETOOTH");
                Toast.makeText(getApplicationContext(), "TURNING_OFF BLUETOOTH", Toast.LENGTH_LONG);

            }
        });
        bList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                setList();
            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                IntentFilter filter = new IntentFilter();

                filter.addAction(BluetoothDevice.ACTION_FOUND);
                filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
                filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);

                registerReceiver(mReceiver, filter);
                mBluetoothAdapter.startDiscovery();

            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Bluetoothjavatpoint.this, ""+list.get(i), Toast.LENGTH_SHORT).show();
                deviceName = (String) list.get(i);
                connectBlueTooth();
            }
        });
    }

    public void setList() {
        pairedDevices = mBluetoothAdapter.getBondedDevices();

        for (BluetoothDevice bt : pairedDevices) list.add(bt.getName());
        Toast.makeText(getApplicationContext(), "Showing Paired Devices", Toast.LENGTH_SHORT).show();

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);
    }

    private void connectBlueTooth() {
        if (devices != null) {
            for (BluetoothDevice device : devices) {
                if (deviceName.equals(device.getName())) {
                    result = device;
                    break;
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);

        super.onDestroy();
    }
}

