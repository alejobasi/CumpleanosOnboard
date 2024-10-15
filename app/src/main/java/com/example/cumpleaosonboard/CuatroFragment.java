package com.example.cumpleaosonboard;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.cumpleaosonboard.databinding.FragmentCuatroBinding;
import com.example.cumpleaosonboard.databinding.FragmentTresBinding;

import java.time.LocalDate;
import java.time.Period;


public class CuatroFragment extends Fragment {
    NavController navController;
    FragmentCuatroBinding binding;

    public CuatroFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentCuatroBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);

        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                binding.fechaNacimiento.setText((dia + " / " + (mes + 1) + " / " + anio));

                LocalDate hoy = LocalDate.now();
                LocalDate nacimiento = LocalDate.of(anio, mes, dia);
                MainActivity.edad= Period.between(nacimiento,hoy).getYears();
            }
        };

        binding.fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog calendario = new DatePickerDialog(requireContext(),dateSetListener,2024,9,30);
                calendario.show();

            }
        });
        binding.calcula.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_cuatroFragment_to_cincoFragment);
            }
        });
    }
}