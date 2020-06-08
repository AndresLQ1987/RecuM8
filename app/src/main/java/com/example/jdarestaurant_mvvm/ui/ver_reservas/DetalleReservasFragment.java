package com.example.jdarestaurant_mvvm.ui.ver_reservas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.jdarestaurant_mvvm.R;

public class DetalleReservasFragment extends Fragment {

    private VerReservasViewModel verReservasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        verReservasViewModel =
                ViewModelProviders.of(requireActivity()).get(VerReservasViewModel.class);
        View view = inflater.inflate(R.layout.fragment_detalle_reserva, container, false);


        return view;
    }
}
