package fun_house.appbar_demo1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList();

    public MyAdapter(Context context, List<Information> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    //delete the item in the recyclerView.
    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;

        MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           //can test use this Toast. in our app will click to go to another activity.
           // Toast.makeText(v.getContext(), "Item clicked at " + getPosition(), Toast.LENGTH_SHORT).show();

            //click on icon and delete the single row view. mabye can use in vendor listView.
            delete(getPosition());
        }
    }

}
