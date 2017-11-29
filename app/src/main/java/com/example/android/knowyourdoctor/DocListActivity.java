package com.example.android.knowyourdoctor;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static com.example.android.knowyourdoctor.R.layout.activity_doc_list;
import static com.example.android.knowyourdoctor.R.layout.popup;

public class DocListActivity extends AppCompatActivity {


    private PopupWindow popupWindow;
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_list);

        /*
        --------------------------------------------------
        METHOD 1
        // Create a ArrayList of String and display in root Linearlayout by adding textview to rootlayout.
        final ArrayList<String> dList = new ArrayList<String>();

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);


        dList.add("Doctor1");
        dList.add("Doctor2");

        for(int i=0;i<dList.size();i++){

        TextView txtView = new TextView(this);
        txtView.setText(dList.get(i));
        rootView.addView(txtView);
        }
        */

        /*METHOD 2
        //Display list of Strings using array adapter which will use scrap view to swap unused view
        //drawback is it will accept only 1 textview layout
        final ArrayList<String> dList = new ArrayList<String>();

        dList.add("Doctor1");
        dList.add("Doctor2");

        ArrayAdapter<String> dListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dList);

        ListView dListView = (ListView) findViewById(R.id.listView);
        dListView.setAdapter(dListAdapter);
        ---------------------------------------------------------------
        */

        //Method 3

        //Create a array list with set of Doctors name,specialization and image to  display
        final ArrayList<DDetails> dList = new ArrayList<DDetails>();

        dList.add(new DDetails("SHERK","M","10 Years","M.B.B.S","8431234350", "General Physician", R.drawable.male_dr));
        dList.add(new DDetails("BABY BOSS ","F","1 Years","BTECH","8431234351", "Ayurvedha", R.drawable.female_dr));
        dList.add(new DDetails("SHIN CHAN", "M","20 Years","BSC","8431234352","Siddha", R.drawable.male_dr));
        dList.add(new DDetails("NEMO", "M","3 Years","MBA","8431234353","Cardiac Surgeon", R.drawable.male_dr));
        dList.add(new DDetails("DORY","F","","","", "Family Practitioner", R.drawable.female_dr));
        dList.add(new DDetails("MOANA", "M","40 Years","MBBS","8431234355","Diabetics", R.drawable.male_dr));
        dList.add(new DDetails("SNOW WHITE","F","22 Years","BDS","8431234356", "Ortho", R.drawable.female_dr));
        dList.add(new DDetails("DUCK DONALD", "M","7 Years","PSCHYCOLOGY","8431234357","Dermatology", R.drawable.male_dr));
        dList.add(new DDetails("TIMON", "F","25 Years","LKG","8431234358","Gynocology", R.drawable.female_dr));
        dList.add(new DDetails("TOM", "F","11 Years","XII","8431234359","Family Practitioner", R.drawable.female_dr));
        dList.add(new DDetails("PUMBA", "M","1.5 Years","DIPLOMALA","8431234360","Opthomologist", R.drawable.male_dr));
        dList.add(new DDetails("JERRY","F","","UKG FAIL","", "ENT", R.drawable.female_dr));

        // Create an  instance of Adapter(dListAdapter) and pass the list of doctors details created in arraylist(dList) and the current context.
        //get the layout with listview xml(R.id.listView) detail and set the layout with dListAdapter adapter details holding arraylist of doctors dList
        DAdapter dListAdapter = new DAdapter(this, dList);

        final ListView dListView = (ListView) findViewById(R.id.listView);
        dListView.setAdapter(dListAdapter);

        //whenever the single list in listview (R.id.listView is clicked onItemClickListerner will be called
        //inside OnItenClickListerner we need to  display a popup holding the detailed information about that doctor.
        dListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (popupWindow != null) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }

                DDetails dListTemp = dList.get(position);

                //Toast.makeText(DocListActivity.this, "Hello", Toast.LENGTH_LONG).show();

                //create a PopupWindow
                popupWindow = new PopupWindow(DocListActivity.this);

                popupWindow.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);

                //Inflate the already created popup window layoyt xml
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupLayout = layoutInflater.inflate(R.layout.popup, null);

                //fill the values inside the popup window layout and set the content of popupwindow.
                TextView txtMsg = (TextView) popupLayout.findViewById(R.id.TVPop_Dname);
                txtMsg.setText(dListTemp.getDName());
                popupWindow.setContentView(popupLayout);

                txtMsg = (TextView) popupLayout.findViewById(R.id.TVPop_Speciality);
                txtMsg.setText("Speciality : " + dListTemp.getDSpeciality());
                popupWindow.setContentView(popupLayout);

                txtMsg = (TextView) popupLayout.findViewById(R.id.TVPop_Gender);
                txtMsg.setText(dListTemp.getdGender());
                popupWindow.setContentView(popupLayout);

                txtMsg = (TextView) popupLayout.findViewById(R.id.TVPop_Qualification);
                txtMsg.setText(dListTemp.getdQualification());
                popupWindow.setContentView(popupLayout);

                txtMsg = (TextView) popupLayout.findViewById(R.id.TVPop_Experience);
                txtMsg.setText(dListTemp.getdExperience());
                popupWindow.setContentView(popupLayout);

                txtMsg = (TextView) popupLayout.findViewById(R.id.TVPop_Contact);
                txtMsg.setText(dListTemp.getdPhone());
                popupWindow.setContentView(popupLayout);

                popupWindow.showAtLocation(dListView, Gravity.CENTER_HORIZONTAL, 0, 0);
                //popupWindow.update(0, 0, 1200, 800);

            }
        });


    }


    public void CloseButtonCalled(View view) {
        if (popupWindow != null) {
            popupWindow.dismiss();
            popupWindow = null;
        }
    }



    @Override
    protected void onStop() {
        super.onStop();
        if (popupWindow != null) {
            popupWindow.dismiss();
            popupWindow = null;
        }
    }
}
