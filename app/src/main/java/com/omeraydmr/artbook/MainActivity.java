package com.omeraydmr.artbook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.omeraydmr.artbook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<Art> artArrayList;
    ArtAdapter artAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        artArrayList = new ArrayList<>();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        artAdapter = new ArtAdapter(artArrayList);
        binding.recyclerView.setAdapter(artAdapter);

        getData();


    }

    private void getData() {
        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Arts", MODE_PRIVATE, null);

            Cursor cursor = database.rawQuery("SELECT * FROM arts", null);
            int nameIndex = cursor.getColumnIndex("artname");
            int IdIndex = cursor.getColumnIndex("id");

            while(cursor.moveToNext()) {
                String name = cursor.getString(nameIndex);
                int id = cursor.getInt(IdIndex);
                Art art = new Art(id, name);
                artArrayList.add(art);
            }

            artAdapter.notifyDataSetChanged();
            cursor.close();

        }catch(Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.art_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item .getItemId() == R.id.add_art) {
            Intent intent = new Intent(this, ArtActivity.class);
            intent.putExtra("info", "new");
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}