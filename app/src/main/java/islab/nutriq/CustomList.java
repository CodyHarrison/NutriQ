package islab.nutriq;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] avatarNames;
    private final Integer[] imageId;
    public CustomList(Activity context,
                      String[] avatarNames, Integer[] imageId) {
        super(context, R.layout.avatar, avatarNames);
        this.context = context;
        this.avatarNames = avatarNames;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.avatar, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.name_avatar);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img_avatar);
        txtTitle.setText(avatarNames[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
