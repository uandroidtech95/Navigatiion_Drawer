package adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.navigatiion_drawer.R;
import com.squareup.picasso.Picasso;

import org.joda.time.LocalDate;

import java.util.ArrayList;

import model.Flipkart;

/**
 * Created by utsav on 08-04-2017.
 */

public class FlipkartAdapter extends RecyclerView.Adapter<FlipkartAdapter.FlipkartViewHolder> {
    private ArrayList<Flipkart> flipkartArrayList = new ArrayList<>();
    private Context context;

    public FlipkartAdapter(ArrayList<Flipkart> flipkartArrayList, Context context) {
        this.flipkartArrayList = flipkartArrayList;
        this.context = context;

    }

    @Override
    public FlipkartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_flipkart, parent, false);
        return new FlipkartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlipkartViewHolder holder, int position) {

        Flipkart flipkart = flipkartArrayList.get(position);
        holder.tvMobileName.setText(flipkart.getMobileName());
        holder.tvMobilePrice.setText(flipkart.getMobilePrice());
        holder.tvMobileOffer.setText(flipkart.getMobileOffer());
        Picasso.with(context).load(flipkart.getMobileUrl()).into(holder.ivMobile);
        Log.d("position",""+position);

    }

    @Override
    public int getItemCount() {
        return flipkartArrayList.size();
    }

    static class FlipkartViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView ivMobile;
        private AppCompatTextView tvMobileName, tvMobileOffer, tvMobilePrice;

        public FlipkartViewHolder(View itemView) {
            super(itemView);
            tvMobileName = (AppCompatTextView) itemView.findViewById(R.id.tv_mobile_name);
            tvMobileOffer = (AppCompatTextView) itemView.findViewById(R.id.tv_mobile_offer);
            tvMobilePrice = (AppCompatTextView) itemView.findViewById(R.id.tv_mobile_price);
            ivMobile = (AppCompatImageView) itemView.findViewById(R.id.iv_mobile);
        }
    }
}
