package com.example.appoctect;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    ArrayList<Items> items;



    public ItemsAdapter(ArrayList<Items> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        ItemViewHolder itemViewHolder=new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Items item=items.get(position);
        holder.itemImageView.setImageResource(item.getImageResource());
        holder.titleTextView.setText(item.getTitle());
        holder.quantinkgTextView.setText(item.getQuantinkg());
        holder.kgTextView.setText(item.getKg());
        holder.rupeeTextView.setText(item.getRupee());
        holder.amountTextView.setText(item.getAmount());
        holder.rupee1TextView.setText(item.getRupee1());
//        System.out.println("price"+item.getAmount());
//        holder.price= Integer.parseInt(item.getAmount());
        holder.amount1TextView.setText(item.getAmount1());
        holder.quantityTextView.setText((item.getQuantity()));
        holder.buyButton.setTag("BUY");
        if(position==0){
            holder.header.setText("Chocolate");
        }else if(position==4) {
            holder.header.setText("Drinks");
        }else if(position==8){
                holder.header.setText("Eatables");
        }else{
            holder.header.setText("");
        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        int quantity=0;
        public ImageView itemImageView;
        public  TextView titleTextView,quantinkgTextView,kgTextView,rupeeTextView,amountTextView,rupee1TextView,amount1TextView,quantityTextView;
        public  RelativeLayout  relativeLayout2,relativeLayout3;
        public Button  buyButton,addButton,minusButton;
        int price;
        public TextView header;



        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);


            itemImageView=itemView.findViewById(R.id.itemImageView);
            titleTextView=itemView.findViewById(R.id.titleTextView);
            quantinkgTextView=itemView.findViewById(R.id.quantinkgTextView);
            kgTextView=itemView.findViewById(R.id.kgTextView);
            rupeeTextView=itemView.findViewById(R.id.rupeeTextView);
            amountTextView=itemView.findViewById(R.id.amountTextView);
            rupee1TextView=itemView.findViewById(R.id.rupee1TextView);
            amount1TextView=itemView.findViewById(R.id.amount1TextView);
            quantityTextView=itemView.findViewById(R.id.quantityTextView);

            relativeLayout2=itemView.findViewById(R.id.relativelayout2);
            relativeLayout3=itemView.findViewById(R.id.relativelayout3);
            header=itemView.findViewById(R.id.header);


            addButton=itemView.findViewById(R.id.addButton);
            minusButton=itemView.findViewById(R.id.minusButton);

            rupee1TextView.setPaintFlags(rupee1TextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            amount1TextView.setPaintFlags(amount1TextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);



            buyButton=itemView.findViewById(R.id.buyButton);
            buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    relativeLayout2.setVisibility(View.VISIBLE);
                }
            });

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quantity=quantity+1;
                    if(quantity > 0)
                    {
                        quantityTextView.setText(""+quantity);
                        amountTextView.setText(""+quantity * Integer.parseInt(amountTextView.getText().toString().trim()));
                    }
                }
            });


            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quantity=quantity-1;
                    if(quantity <= 0 )
                    {
                        quantity=1;
                        relativeLayout2.setVisibility(View.GONE);
                    }
                    quantityTextView.setText(""+quantity);
                    amountTextView.setText(""+ quantity * Integer.parseInt(amountTextView.getText().toString().trim()));
                }
            });



        }
    }
}
