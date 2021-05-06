package com.khanghappybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Music extends AppCompatActivity {

    TextView txtLoiNhan;
    ListView lvBaiHat;
    RelativeLayout mh;

    MediaPlayer song;

    ArrayList<String> mangTenBH, mangLoiNhan;
    ArrayList<Integer> mangMp3;

    public void AnhXa() {
        txtLoiNhan = (TextView) findViewById(R.id.textViewLoiNhan);
        lvBaiHat = (ListView) findViewById(R.id.listViewBaiHat);
        mh = (RelativeLayout) findViewById(R.id.manHinh);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        AnhXa();

        // Hình nền
        mh.setBackgroundResource(R.drawable.bg2);

        // play bài hát

        song = MediaPlayer.create(getApplicationContext(), R.raw.duchomaivesau);
        song.start();

        //lời nhắn
        txtLoiNhan.setText("Happy birthday Khang nhé !!?");

        TaoMang();

        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(), android.R.layout.simple_list_item_1, mangTenBH
        );

        lvBaiHat.setAdapter(adapter);

        lvBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                song.stop();
                song = MediaPlayer.create(getApplicationContext(), mangMp3.get(position));
                song.start();
            }
        });
    }

    public  void TaoMang() {
        mangTenBH = new ArrayList<String>();
        mangLoiNhan = new ArrayList<String>();
        mangMp3 = new ArrayList<Integer>();

        mangMp3.add(R.raw.duchomaivesau);
        mangTenBH.add("Dù cho mai về sau");
        mangLoiNhan.add("Dù cho mai về sau minh không bên cạnh nhau, anh vẫn yêu mình em thôi đấy yêu em chẳng một lời thở than");

        mangMp3.add(R.raw.muonroimasaocon);
        mangTenBH.add("Muộn rồi mà sao còn");
        mangLoiNhan.add("Dù cho mai về sau minh không bên cạnh nhau, anh vẫn yêu mình em thôi đấy yêu em chẳng một lời thở than");

        mangMp3.add(R.raw.saigondaulongqua);
        mangTenBH.add("Sài gòn đau lòng quá");
        mangLoiNhan.add("Cầm tấm vé trên tay anh đi đến xa nơi này sài gòn đau lòng quá chỉ còn kỉ niệm chúng ta!!?");

    }
}