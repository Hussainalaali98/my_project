package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    RadioGroup rgcategory, rgcondition;
    RadioButton radioButtonCondition, radioButtonCategory;
    Button btnnext;
    String condition, category;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); // Enable options menu
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnnext = root.findViewById(R.id.btnnext);
        rgcategory = root.findViewById(R.id.rgcategory);
        rgcondition = root.findViewById(R.id.rgcondition);

        btnnext.setVisibility(View.INVISIBLE);
        btnnext.setEnabled(false);

        rgcategory.setOnCheckedChangeListener((group, checkedId) -> btnnext.setEnabled(true));
        rgcondition.setOnCheckedChangeListener((group, checkedId) -> btnnext.setVisibility(View.VISIBLE));

        btnnext.setOnClickListener(v -> {
            int selectedCondition = rgcondition.getCheckedRadioButtonId();
            int selectedCategory = rgcategory.getCheckedRadioButtonId();

            // Find the RadioButton by returned id
            radioButtonCondition = root.findViewById(selectedCondition);
            condition = (String) radioButtonCondition.getText();

            radioButtonCategory = root.findViewById(selectedCategory);
            category = (String) radioButtonCategory.getText();

            Intent intent = new Intent(getContext(), HospitalActivity.class);
            intent.putExtra("Condition", condition);
            intent.putExtra("Category", category);
            Toast.makeText(getContext(), condition + "\n" + category, Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu); // Ensure you have this menu resource
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings: // Replace with your actual menu item ID
                Toast.makeText(getContext(), "Settings selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
