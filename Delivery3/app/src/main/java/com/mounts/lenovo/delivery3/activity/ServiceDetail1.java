package com.mounts.lenovo.delivery3.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.mounts.lenovo.delivery3.R;

public class ServiceDetail1 extends AppCompatActivity {

    private ImageView backarrow;
    private FragmentManager fragmentManager;
    private RelativeLayout relativeLayoutofReview;
    AlertDialog.Builder builder;
    private RatingBar ratingBar;
    private TextView tvRatingScale;
    private EditText etFeedback;


    @SuppressLint("WrongConstant")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Arrive", "ServiceDetail.java");
        setContentView(R.layout.service_detail);
        backarrow = findViewById(R.id.backarrow_service_detail);
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("clicked", "backarrow");
                finish();
            }
        });
        relativeLayoutofReview = findViewById(R.id.relativeLayoutofReview);
        builder = new AlertDialog.Builder(this);
        relativeLayoutofReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(ServiceDetail1.this);
//                final RatingBar rating = new RatingBar(this);
//                rating.setMax(5);
//                builder.setTitle("Rate Me!");
//                builder.setView(rating);
//                View customView = getLayoutInflater().inflate(R.layout.ratingfordetailservice, null);
//                ratingBar = findViewById(R.id.ratingbar);
//                tvRatingScale = findViewById(R.id.tvRatingScale);
//                etFeedback = findViewById(R.id.etFeedback);
//                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//                    @Override
//                    public void onRatingChanged(RatingBar rateBar, float rating, boolean fromUser) {
//                        tvRatingScale.setText(String.valueOf(rating));
//                        switch ((int) rateBar.getRating()) {
//                            case 1:
//                                tvRatingScale.setText("Very bad");
//                                break;
//                            case 2:
//                                tvRatingScale.setText("Need some improvement");
//                                break;
//                            case 3:
//                                tvRatingScale.setText("Good");
//                                break;
//                            case 4:
//                                tvRatingScale.setText("Great");
//                                break;
//                            case 5:
//                                tvRatingScale.setText("Awesome. I love it");
//                                break;
//                            default:
//                                tvRatingScale.setText("");
//                        }
//                    }
//                });
//              TODO: run and check rating bar and alert dialog box,linn...
                etFeedback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (etFeedback.getText().toString().isEmpty()) {
                            Toast.makeText(ServiceDetail1.this, "Please fill in feedback text box", Toast.LENGTH_LONG).show();
                        } else {
                            etFeedback.setText("");
                            ratingBar.setRating(0);
                            Toast.makeText(ServiceDetail1.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
//                builder.setView(customView);
//                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
//                builder.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(), "You clicked Yes", Toast.LENGTH_LONG).show();
//
//                    }
//                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                        Toast.makeText(getApplicationContext(), "You clicked Cancel", Toast.LENGTH_LONG).show();
//                    }
//                });
//                AlertDialog alert = builder.create();
//                alert.setTitle("Rate Me!");// set the title of alert box
//                alert.show();
            }
        });
    }

}
