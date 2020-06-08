package com.example.jdarestaurant_mvvm.ui.nueva_reserva;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import androidx.lifecycle.ViewModel;

import com.example.jdarestaurant_mvvm.Model.Reserva;
import com.example.jdarestaurant_mvvm.SQLite;

public class NuevaReservaViewModel extends ViewModel {

    public void reservar(Context context, String fecha, int comensales, String nombre, String telefono, String comentarios) {
        SQLite sqLite = new SQLite(context, "bdreservas",null, 1);
        SQLiteDatabase db = sqLite.getWritableDatabase();
        ContentValues reserva = new ContentValues();
        reserva.put("fecha", fecha);
        reserva.put("npersonas", comensales);
        reserva.put("nombre", nombre);
        reserva.put("telefono", telefono);
        reserva.put("comentarios", comentarios);
        db.insert("reservas", null, reserva);
        db.close();
    }
    // TODO: Implement the ViewModel
}
