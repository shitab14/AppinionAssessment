package com.mr_mir.appinionassessment;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final Spinner ProductGroupSpinner=findViewById(R.id.spinner_productgroup);
        final Spinner LiteratureSpinner=findViewById(R.id.spinner_literature);
        final Spinner PhysicianSampleSpinner=findViewById(R.id.spinner_physiciansample);
        final Spinner GiftSpinner=findViewById(R.id.spinner_gift);

        TextView LiteratureTextView=findViewById(R.id.editText_literature);
        TextView PhysicianTextView=findViewById(R.id.editText_physiciansample);
        TextView GiftTextView=findViewById(R.id.editText_gift);

        TextInputEditText AccompaniedWithEditText=findViewById(R.id.field_accompaniedwith);
        TextInputEditText RemarksEditText=findViewById(R.id.edittext_remarks);


        //Creating a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        //creating the api interface
        Api api = retrofit.create(Api.class);

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<Data> call = api.getTheData();


        //then finally we are making the call using enqueue()
        //it takes callback interface as an argument
        //and callback is having two methods onRespnose() and onFailure
        //if the request is successful we will get the correct response and onResponse will be executed
        //if there is some error we will get inside the onFailure() method
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                //In this point we got our hero list
                //thats damn easy right ;)

                Data SampleList = response.body();

                //PRODUCTGROUP
                List<ProductGroupList> ProductGroupLists=  SampleList.getProductGroupList();
                List<String> ProductGroupString= new ArrayList<String>();
                List<Integer> ProductGroupId= new ArrayList<Integer>();
                //1st Item
                ProductGroupString.add("Choose ");
                ProductGroupId.add(00);
                for (ProductGroupList pgdata : ProductGroupLists) {
                    ProductGroupString.add(pgdata.getProductGroup());
                    ProductGroupId.add(pgdata.getId());
                    //Log.e("tag", gdata.getId().toString()+"  "+gdata.getGift());
                }

                ArrayAdapter<String> ProductGroupAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, ProductGroupString );
                ProductGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ProductGroupSpinner.setAdapter(ProductGroupAdapter);


                //LITERATURE
                List<LiteratureList> literatureLists=  SampleList.getLiteratureList();
                List<String> LiteratureString= new ArrayList<String>();
                List<Integer> LiteratureId= new ArrayList<Integer>();
                //1st Item
                LiteratureString.add("Choose ");
                LiteratureId.add(00);
                for (LiteratureList ldata : literatureLists) {
                    LiteratureString.add(ldata.getLiterature());
                    LiteratureId.add(ldata.getId());
                    //Log.e("tag", gdata.getId().toString()+"  "+gdata.getGift());
                }

                ArrayAdapter<String> LiteratureAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, LiteratureString );
                LiteratureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                LiteratureSpinner.setAdapter(LiteratureAdapter);

                //PHYSICIANSAMPLE
                List<PhysicianSampleList> PhysicianSampleLists=  SampleList.getPhysicianSampleList();
                List<String> PhysicianSampleString= new ArrayList<String>();
                List<Integer> PhysicianSampleId= new ArrayList<Integer>();
                //1st Item
                PhysicianSampleString.add("Choose ");
                PhysicianSampleId.add(00);
                for (PhysicianSampleList psdata : PhysicianSampleLists) {
                    PhysicianSampleString.add(psdata.getSample());
                    PhysicianSampleId.add(psdata.getId());
                    //Log.e("tag", gdata.getId().toString()+"  "+gdata.getGift());
                }

                ArrayAdapter<String> PhysicianSampleAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, PhysicianSampleString );
                PhysicianSampleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                PhysicianSampleSpinner.setAdapter(PhysicianSampleAdapter);


                //GIFT
                List<GiftList> giftLists=  SampleList.getGiftList();
                List<String> GiftString= new ArrayList<String>();
                List<Integer> GiftId= new ArrayList<Integer>();
                //1st Item
                GiftString.add("Choose ");
                GiftId.add(00);
                for (GiftList gdata : giftLists) {
                    GiftString.add(gdata.getGift());
                    GiftId.add(gdata.getId());
                    //Log.e("tag", gdata.getId().toString()+"  "+gdata.getGift());
                }

                ArrayAdapter<String> GiftAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item,GiftString );
                GiftAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                GiftSpinner.setAdapter(GiftAdapter);



                Log.e("tag ", SampleList.getPhysicianSampleList().toString());
                Log.e("tag",SampleList.getProductGroupList().toString());
                Log.e("tag",SampleList.getGiftList().toString());
                //now we can do whatever we want with this list
                Toast.makeText(getApplicationContext(),"WORKS FINE",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Tag", t.getMessage());
                //Toast.makeText(getApplicationContext(),"NOT FINE",Toast.LENGTH_LONG).show();

            }

        });


    }
}
