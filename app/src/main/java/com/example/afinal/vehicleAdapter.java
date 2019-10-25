package com.example.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class vehicleAdapter extends ArrayAdapter<Travel> {
    private Context context;
    private List<Travel>vehicles;

    public vehicleAdapter(Context context,List<Travel>list)
    {
        super(context,R.layout.display,list);
        this.context=context;
        this.vehicles=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.display,parent,false);

        TextView disp1=convertView.findViewById(R.id.disp1);
        TextView disp2=convertView.findViewById(R.id.disp2);
        TextView disp3=convertView.findViewById(R.id.disp3);
        TextView disp4=convertView.findViewById(R.id.disp4);
        TextView disp5=convertView.findViewById(R.id.disp5);
        TextView disp6=convertView.findViewById(R.id.disp6);
        TextView disp7=convertView.findViewById(R.id.disp7);

        disp1.setText(vehicles.get(position).getVehicle_name());
        disp2.setText(vehicles.get(position).getName());
        disp3.setText(vehicles.get(position).getLocation());
        disp4.setText(vehicles.get(position).getDestination());
        disp5.setText(vehicles.get(position).getPhone_no());
        disp6.setText(vehicles.get(position).getCurrentdate());
        disp7.setText(vehicles.get(position).getTime());





        return convertView;
    }
}
