package com.example.ruburger.adapter;
//Muhammad Abbasi moa55 Aaman Gafur atg80
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ruburger.R;
import com.example.ruburger.model.Flavor;
import java.util.HashMap;
import java.util.Map;

public class FlavorAdapter extends RecyclerView.Adapter<FlavorAdapter.VH> {
    private final Flavor[] flavors;
    // track selected quantity per flavor
    public final Map<Flavor, Integer> selectedQuantities = new HashMap<>();

    public FlavorAdapter(Flavor[] flavors) {
        this.flavors = flavors;
        for (Flavor f : flavors) {
            selectedQuantities.put(f, 0);
        }
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_flavor, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Flavor flavor = flavors[position];
        holder.name.setText(flavor.name());
        holder.image.setImageResource(flavor.getDrawableId());
        // array of ["0","1","2",…] in arrays.xml
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(
                holder.itemView.getContext(),
                R.array.qty_with_zero,
                android.R.layout.simple_spinner_item
        );
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.qtySpinner.setAdapter(a);
        holder.qtySpinner.setSelection(selectedQuantities.get(flavor));
        holder.qtySpinner.setOnItemSelectedListener(new android.widget.AdapterView
                .OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> p,
                                       View v, int pos, long id) {
                selectedQuantities.put(flavor, pos);
            }
            @Override public void onNothingSelected(android.widget.AdapterView<?> p) {}
        });
    }

    @Override public int getItemCount() { return flavors.length; }

    static class VH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        Spinner qtySpinner;
        VH(View v) {
            super(v);
            image = v.findViewById(R.id.flavorImage);
            name = v.findViewById(R.id.flavorName);
            qtySpinner = v.findViewById(R.id.flavorQty);
        }
    }
}
