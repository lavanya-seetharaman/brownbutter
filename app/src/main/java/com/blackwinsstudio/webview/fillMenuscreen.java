package com.blackwinsstudio.webview;

import static android.app.ProgressDialog.show;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fillMenuscreen extends AppCompatActivity {
    String myResponse;
    ListView lv;
    ArrayList<String> productNameList = new ArrayList<String>();
    ArrayList<Integer> productStockQtyList = new ArrayList<Integer>();
    ArrayList<Integer> productIDList = new ArrayList<Integer>();
    String[] stockQty;
    HashMap<String,String> data;
    List<ProductInformation> productList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_fill_menuscreen);
        //arrayList=new ArrayList<>();
        lv = (ListView)findViewById(R.id.listview);


        AttributeMethods methods = RetrofitClient.getRetrofitInstance ().create (AttributeMethods.class);
        Call<List<ProductInformation>> call = methods.getProduct (Helper.getAuthToken());
        call.enqueue(new Callback<List<ProductInformation>>() {
            @Override
            public void onResponse(Call<List<ProductInformation>> call, Response<List<ProductInformation>> response) {
                if(response.code() == 200){
                    Log.i (ApplicationConstant.TAG, "OnResponse Code"+ response.code ());
                     productList = response.body ();
                    fillMenuscreen.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                for (ProductInformation product : productList
                                ) {
                                    int id = product.id;
                                    String name = product.name;
                                    int qty = product.stock_quantity;
                                    productIDList.add(id);
                                    productNameList.add(name);
                                    productStockQtyList.add(qty);
                                }

                                CustomListAdapter customAdapater = new CustomListAdapter();
                                lv.setAdapter(customAdapater);
                                lv.setItemsCanFocus(false);
                                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        Toast.makeText(fillMenuscreen.this, productNameList.get(i), Toast.LENGTH_LONG).show();
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }




            }

            @Override
            public void onFailure(Call<List<ProductInformation>> call, Throwable t) {
                Log.e (ApplicationConstant.TAG,"onfailure"+ t.getMessage ());
            }
        });



    }

    public void Opensastaamart(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra ("page", "fillmenuscreen");
        startActivity(intent);

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }


    private class CustomListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return productNameList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View viewl = getLayoutInflater().inflate(R.layout.product_listview, null);
            TextView productName = (TextView) viewl.findViewById(R.id.productName);
            TextView productID = (TextView) viewl.findViewById(R.id.productID);
            TextView editStockQty = (TextView) viewl.findViewById(R.id.stockQty);
            Button minusBtn = (Button) viewl.findViewById(R.id.minusBtn);
            Button addBtn = (Button) viewl.findViewById(R.id.addBtn);
            Button saveBtn = (Button) viewl.findViewById(R.id.saveBtn);

            productID.setText(productIDList.get(i).toString());
            productName.setText(productNameList.get(i));
            editStockQty.setText(productStockQtyList.get(i).toString());
            minusBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String qtyInString = editStockQty.getText().toString();
                    int updatedQty = Integer.parseInt(qtyInString) - 1;
                    Toast.makeText(fillMenuscreen.this,String.valueOf(updatedQty), Toast.LENGTH_SHORT).show();
                    editStockQty.setText(String.valueOf(updatedQty));
                    Toast.makeText(fillMenuscreen.this,editStockQty.getText(), Toast.LENGTH_SHORT).show();

                }
            });
            addBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String qtyInString = editStockQty.getText().toString();
                    int updatedQty = Integer.parseInt(qtyInString) + 1;
                    Toast.makeText(fillMenuscreen.this,String.valueOf(updatedQty), Toast.LENGTH_SHORT).show();
                    editStockQty.setText(String.valueOf(updatedQty));

                }
            });

            saveBtn.setOnClickListener(new View.OnClickListener() {

                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onClick(View view) {
                    String product_id = productID.getText().toString();
                    int product_qty = Integer.parseInt(editStockQty.getText().toString());
                    AttributeMethods methods = RetrofitClient.getRetrofitInstance ().create (AttributeMethods.class);
                    Call<ProductInformation> call = methods.postProductQty (Helper.getAuthToken(),product_id, product_qty);
                    call.enqueue(new Callback<ProductInformation>() {
                        @Override
                        public void onResponse(Call<ProductInformation> call, Response<ProductInformation> response) {
                            //Toast.makeText(fillMenuscreen.this,response.code(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ProductInformation> call, Throwable t) {
                            //Toast.makeText(fillMenuscreen.this,t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });
            return viewl;
        }
    }
}

