package com.example.jdarestaurant_mvvm.ui.ver_reservas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jdarestaurant_mvvm.Model.Reserva;
import com.example.jdarestaurant_mvvm.SQLite;

import java.util.ArrayList;

public class VerReservasViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Reserva>> listaReservas;

    public VerReservasViewModel() {
        listaReservas = new MutableLiveData<>();
    }

    public LiveData<ArrayList<Reserva>> getListReservas() {
        return listaReservas;
    }

    public void getReservas(Context context) {
        ArrayList<Reserva> getlistaReservas = new ArrayList<>();
        SQLite sqLite = new SQLite(context, "reservas",null, 1);
        SQLiteDatabase db = sqLite.getWritableDatabase();
        Cursor fila = db.rawQuery("select fecha, npersonas, nombre, telefono, comentarios from reservas", null);
        while (fila.moveToNext()) {
            Reserva reserva = new Reserva(fila.getString(0),fila.getInt(1), fila.getString(2),
                    fila.getString(3),fila.getString(4));
            getlistaReservas.add(reserva);
        }
        listaReservas.postValue(getlistaReservas);
    }
}
