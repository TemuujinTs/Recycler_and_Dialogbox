package mn.tulga.temuujin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import carbon.widget.Button;
import mn.tulga.temuujin.model.Category;

public class MainActivity extends AppCompatActivity {

    private Button btn_payful;

    RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_payful = (Button)findViewById(R.id.pay_btn);
        btn_payful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendialog();
            }
        });


        categoryRecyclerView = (RecyclerView) findViewById(R.id.categoryRecyclerView);



//        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, loadData());


        categoryRecyclerView.setAdapter(recyclerViewAdapter);



    }
    public void opendialog(){
        Dialog dialogboxi = new Dialog();
        dialogboxi.show(getSupportFragmentManager(),"example dialog");

    }

    ArrayList<Category> loadData(){

        ArrayList<Category> categories = new ArrayList<>();

        Category category = new Category();
        category.setImg("ic_hospital");
        category.setName("Hospital");
        categories.add(category);

        Category category1 = new Category();
        category1.setImg("ic_restaurant");
        category1.setName("Restaurant");
        categories.add(category1);

        Category category2 = new Category();
        category2.setImg("ic_shop");
        category2.setName("Shop");
        categories.add(category2);

        Category category3 = new Category();
        category3.setImg("ic_urgence");
        category3.setName("Urgence");
        categories.add(category3);


        return categories;

    }



    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

        private Context context;
        private ArrayList<Category> categories;

        public RecyclerViewAdapter(Context context, ArrayList<Category> categories) {
            this.categories = categories;
            this.context = context;
        }

        @Override
        public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_category, parent, false);
            RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolders holder, int position) {

            final Category data = categories.get(position);



            if (data != null) {

                holder.textView.setText(data.getName());
                holder.imageView.setImageDrawable(Util.getDrawable(data.getImg(),MainActivity.this));

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this,SplashActivity.class));
                    }
                });

            }
        }

        @Override
        public int getItemCount() {

            return categories.size();
        }


    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;


        public RecyclerViewHolders(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);

        }

        @Override
        public void onClick(View view) {

            Log.e("click", "click");
        }
    }

}
