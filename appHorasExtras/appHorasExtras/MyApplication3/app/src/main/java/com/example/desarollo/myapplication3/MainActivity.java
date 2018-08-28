package com.example.desarollo.myapplication3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.evrencoskun.tableview.TableView;
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DatePickerListener{

    ArrayList<Empleado> listaEmpleados;
    RecyclerView recyclerEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearTabla();
        construirRecycler();

    }
    @Override
    public void onDateSelected(DateTime dateSelected) {
        Log.i("HorizontalPicker","Fecha seleccionada="+dateSelected.toString());
    }


    public void crearTabla(){
       boolean estado;
        TableView tableView = new TableView(getApplicationContext());
        HorizontalPicker picker= (HorizontalPicker) findViewById(R.id.datePicker);
        picker.setListener(this)
            .setDays(100)
            .setOffset(50) //dias anteriores a la fecha actual
            .setDateSelectedColor(Color.DKGRAY)
            .setDateSelectedTextColor(Color.WHITE)
            .setMonthAndYearTextColor(Color.DKGRAY)
            .setTodayButtonTextColor(getResources().getColor(R.color.colorPrimary))
            .setTodayDateTextColor(getResources().getColor(R.color.colorPrimary))
            .setTodayDateBackgroundColor(Color.GRAY)
            .setUnselectedDayTextColor(Color.DKGRAY)
            .setDayOfWeekTextColor(Color.DKGRAY)
            .setUnselectedDayTextColor(getResources().getColor(R.color.primaryTextColor))
            .showTodayButton(true)
            .init();
        picker.setBackgroundColor(Color.LTGRAY);
        picker.setDate(new DateTime());
    }

    public int calcularHorasExtras(){
     return 0;
    }

    private void construirRecycler() {
        listaEmpleados=new ArrayList<>();
        recyclerEmpleados= (RecyclerView) findViewById(R.id.RecyclerId);

            recyclerEmpleados.setLayoutManager(new LinearLayoutManager(this));

        Toast.makeText(getApplicationContext(),"recycler",Toast.LENGTH_SHORT).show();
        llenarEmpleados();

        AdaptadorEmpleados adapter=new AdaptadorEmpleados(listaEmpleados);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+listaEmpleados.get
                                (recyclerEmpleados.getChildAdapterPosition(v))
                                .getNombre(),Toast.LENGTH_SHORT).show();
            }
        });


        recyclerEmpleados.setAdapter(adapter);
    }
    private void llenarEmpleados() {

        listaEmpleados.add(new Empleado("Mario Tobar", "PHTD: 7-5"));
        listaEmpleados.add(new Empleado("Freddy ", "PHTD: 7-6"));
        listaEmpleados.add(new Empleado("Gerardo Valle", "PHTD: 7-7"));
        listaEmpleados.add(new Empleado("Vilma Herrera", "PHTD: 7-5"));
        listaEmpleados.add(new Empleado("Brendy Ramirez ", "PHTD: 7-5"));
        listaEmpleados.add(new Empleado("Marvin Mendez", "PHTD: 7-8"));

        listaEmpleados.add(new Empleado("Mario T", "PHTD: 7-5"));
        listaEmpleados.add(new Empleado("Fred ", "PHTD: 7-6"));
        listaEmpleados.add(new Empleado("Gerardo V", "PHTD: 7-7"));
        listaEmpleados.add(new Empleado("Vilma H", "PHTD: 7-5"));
        listaEmpleados.add(new Empleado("Brendy R ", "PHTD: 7-5"));
        listaEmpleados.add(new Empleado("Marvin M", "PHTD: 7-8"));



    }




}
