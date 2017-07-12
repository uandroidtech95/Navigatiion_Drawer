package adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.navigatiion_drawer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Whatsapp;

/**
 * Created by utsav on 07-04-2017.
 */

public class WhatsappAdapter extends RecyclerView.Adapter<WhatsappAdapter.WhatsappViewHolder> {
    private Context context;
    private ArrayList<Whatsapp> whatsappArrayList = new ArrayList<>();

    public WhatsappAdapter(Context context, ArrayList<Whatsapp> whatsappArrayList) {
        this.context = context;
        this.whatsappArrayList = whatsappArrayList;
    }

    @Override
    public WhatsappViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_whatsapp, parent, false);
        return new WhatsappViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WhatsappViewHolder holder, int position) {
        Whatsapp whatsapp = whatsappArrayList.get(position);
        holder.tvName.setText(whatsapp.getName());
        holder.tvMessage.setText(whatsapp.getMessage());
        holder.tvMessageCounter.setText(whatsapp.getMessagecounter());
        holder.tvTime.setText(whatsapp.getTime());
        Picasso.with(context).load(whatsapp.getProfileUrl()).into(holder.ivprofile);


    }

    @Override
    public int getItemCount() {
        return whatsappArrayList.size();
    }

    static class WhatsappViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView ivprofile;
        private AppCompatTextView tvName, tvMessage, tvTime, tvMessageCounter;

        public WhatsappViewHolder(View itemView) {
            super(itemView);
            ivprofile = (CircleImageView) itemView.findViewById(R.id.iv_whatsapp_profile);
            tvName = (AppCompatTextView) itemView.findViewById(R.id.tv_name);
            tvMessage = (AppCompatTextView) itemView.findViewById(R.id.tv_message);
            tvTime = (AppCompatTextView) itemView.findViewById(R.id.tv_time);
            tvMessageCounter = (AppCompatTextView) itemView.findViewById(R.id.tv_message_counter);
        }
    }
}
