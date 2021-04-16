package com.example.contactview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class SelectContact extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Stan Andrei", "Visnevschi Vladislav", "Ionescu Paul", "Avramescu Andrei", "Constantinescu George", "Bogatu Daniel", "Ivan Corton da Silva", "Tache Radu"};
    String mDescription[] = {" Them : Salutare\n 11:02pm | 16.04.2020", " Them : Hey\n 12:45pm | 15.04.2020", " Me : lmao\n 1:21am | 15.04.2020", " Them : nah, dude\n 4:38am | 15.04.2020", " Me : Why?\n 3:43pm | 15.04.2020", " Me : Hmmm...\n 12:58am | 14.04.2020", " Them : Sure, no worries!\n 1:07pm | 16.04.2020", " Them : Idk\n 8:35pm | 12.04.2020"};
    int images[] = {R.drawable.stan, R.drawable.visnevschi, R.drawable.ionescu, R.drawable.avramescu, R.drawable.constantinescu, R.drawable.bogatu, R.drawable.ivan, R.drawable.tache};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(SelectContact.this, "You have selected the first contact!\n" + mTitle[0], Toast.LENGTH_SHORT).show();
                }
                if (position ==  1) {
                    Toast.makeText(SelectContact.this, "You have selected the second contact!\n" +  mTitle[1] , Toast.LENGTH_SHORT).show();
                }
                if (position ==  2) {
                    Toast.makeText(SelectContact.this, "You have selected the third contact!\n" + mTitle[2], Toast.LENGTH_SHORT).show();
                }
                if (position ==  3) {
                    Toast.makeText(SelectContact.this, "You have selected the fourth contact!\n" + mTitle[3], Toast.LENGTH_SHORT).show();
                }
                if (position ==  4) {
                    Toast.makeText(SelectContact.this, "You have selected the fifth contact!\n" +  mTitle[4] , Toast.LENGTH_SHORT).show();
                }
                if (position ==  5) {
                    Toast.makeText(SelectContact.this, "You have selected the sixth contact!\n" + mTitle[5], Toast.LENGTH_SHORT).show();
                }
                if (position ==  6) {
                    Toast.makeText(SelectContact.this, "You have selected the seventh contact!\n" + mTitle[6], Toast.LENGTH_SHORT).show();
                }
                if (position ==  7) {
                    Toast.makeText(SelectContact.this, "You have selected the eighth contact!\n" +  mTitle[7] , Toast.LENGTH_SHORT).show();
                }
                if (position ==  8) {
                    Toast.makeText(SelectContact.this, "You have selected the ninth contact!\n" + mTitle[8], Toast.LENGTH_SHORT).show();
                }
                if (position ==  9) {
                    Toast.makeText(SelectContact.this, "You have selected the tenth contact!\n" + mTitle[9], Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}