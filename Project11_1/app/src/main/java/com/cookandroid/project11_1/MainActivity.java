package com.cookandroid.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MygirdAdapter gAdapter = new MygirdAdapter(this);
        gv.setAdapter(gAdapter);

    }

    public class MygirdAdapter extends BaseAdapter {
        Context context;

        public MygirdAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int arg0) {
            return 0;
        }

        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

        String[] posterName = {"토이스토리", "호빗", "제이슨 본", "반지의 제왕", "정직한 후보", "나쁜 녀셕들", "겨울왕국", "알라딘", "극한직업", "스파이더맨",
                                "토이스토리", "호빗", "제이슨 본", "반지의 제왕", "정직한 후보", "나쁜 녀셕들", "겨울왕국", "알라딘", "극한직업", "스파이더맨",
                                "토이스토리", "호빗", "제이슨 본", "반지의 제왕", "정직한 후보", "나쁜 녀셕들", "겨울왕국", "알라딘", "극한직업", "스파이더맨",
                                "토이스토리", "호빗", "제이슨 본", "반지의 제왕", "정직한 후보", "나쁜 녀셕들", "겨울왕국", "알라딘", "극한직업", "스파이더맨"};

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5 , 5, 5, 5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.ic_launcher_foreground);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });

            return imageview;
        }
    }


}
