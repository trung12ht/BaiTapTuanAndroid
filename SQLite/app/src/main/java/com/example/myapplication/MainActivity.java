package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText edmssv, edhoten, edemail, eddiachi;
    Button add, update, view, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        edmssv = (EditText) findViewById(R.id.edmssv);
        edhoten = (EditText) findViewById(R.id.edhovaten);
        edemail = (EditText) findViewById(R.id.edemail);
        eddiachi = (EditText) findViewById(R.id.eddiachi);

        add = (Button) findViewById(R.id.add);
        update = (Button) findViewById(R.id.update);
        view = (Button) findViewById(R.id.viewall);
        delete = (Button) findViewById(R.id.delete);
        AddData();
        ViewAll();
        UpdateData();
//        DeleteData();
        deleteData();
    }

    public void UpdateData() {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(edmssv.getText().toString(), edhoten.getText().toString(), edemail.getText().toString(), eddiachi.getText().toString());
                    if (isUpdate== true) {
                        Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(MainActivity.this, "Data not Update", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void AddData() {
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    boolean isInserted =    myDb.insertData(edmssv.getText().toString(), edhoten.getText().toString(), edemail.getText().toString(), eddiachi.getText().toString());
                    if (isInserted)
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void ViewAll() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount()==0) {
                    showMessage("Error", "Không có bản ghi nào");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("MSSV: " + res.getString(0) + "\n");
                    buffer.append("Họ và tên: " + res.getString(1) + "\n");
                    buffer.append("Địa chỉ: " + res.getString(2) + "\n");
                    buffer.append("Email: " + res.getString(3) + "\n");
                    buffer.append("_______________________\n");
                }
                showMessage("Data", buffer.toString());

            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void deleteData() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDb.deleteData(edmssv.getText().toString());
                if (deleteRows >0)
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data not deleted", Toast.LENGTH_LONG).show();
            }
        });
    }
}