package fr.jaroddeveloppement.mareu.adapteur;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.util.List;
import fr.jaroddeveloppement.mareu.R;
import fr.jaroddeveloppement.mareu.model.Room;


public class MySpinnerAdapter extends ArrayAdapter<Room> {



    public MySpinnerAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner, parent, false
            );
        }
        View viewRoomColor = convertView.findViewById(R.id.chooseRoom);


         Room mRoom = getItem(position);

        if (mRoom != null) {
            viewRoomColor.setBackgroundResource(R.drawable.circle);
            GradientDrawable drawable = (GradientDrawable) viewRoomColor.getBackground();
            drawable.setColor(ContextCompat.getColor(viewRoomColor.getContext(), mRoom.getColorRoom()));



        }
        return convertView;
    }


}


