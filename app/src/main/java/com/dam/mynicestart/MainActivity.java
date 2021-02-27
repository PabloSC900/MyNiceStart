package com.dam.mynicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

/**
 * Ventana
 *@author pablo
 * @see MainActivity
 */

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    ImageView imgMain;
    ImageView imgEV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMain = findViewById(R.id.bgMain);
        imgEV = findViewById(R.id.imgEV);

        Glide.with(this)
                .load(R.drawable.foto_main)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .circleCrop()
                .into(imgMain);

        registerForContextMenu(imgMain);

        Glide.with(this)
                .load(R.drawable.fcview)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .circleCrop()
                .into(imgEV);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        // *** EXPANDABLE CARD ***
        ExpandableCardView card = findViewById(R.id.lExpandView);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
           @Override
           public void onExpandChanged(View v, boolean isExpanded) {
               Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" :
                       "Collapsed!", Toast.LENGTH_SHORT).show();
           }
        });

    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //    opción TOAST
            //
            //          Toast toast0 = Toast.makeText(MainContextActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
            //          toast0.show();

            //   opción SNACKBAR
//           SUSTITUIR POR CONSTRAINT EN SU CASO
//           final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);
            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main_context);
            Snackbar snackbar = Snackbar
                    .make(mLayout, "Refrescado!", Snackbar.LENGTH_LONG)
                    .setAction("Deshacer", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);

        }
    };

    // *** DIALOGO MODAL ***
    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo
        //por un XML a medida
        builder.setTitle("Bienvenido!");
        builder.setMessage("Una foto?");
        builder.setIcon(R.drawable.ic_baseline_camera_alt_24);
        // un XML a medida para el diálogo

//            builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,
//                    null));
//
        // add the buttons
//        builder.setPositiveButton("Glide", new DialogInterface().OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // do something like...
//                dialog.dismiss();
//            }
//        });
//        builder.setNegativeButton("ChatBot", new
//                DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // do something like...
//                        dialog.dismiss();
//                    }
//                });
//
//        builder.setNeutralButton("MotionLayout", new
//                DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // do something like...
//                        dialog.dismiss();
//                    }
//                });
//        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            Toast toast = Toast.makeText(this, "Search!", Toast.LENGTH_LONG);
            toast.show();

        } else if (id == R.id.icono2) {
            Toast toast = Toast.makeText(this, "Camera!", Toast.LENGTH_LONG);
            showAlertDialogButtonClicked(MainActivity.this);
            toast.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Toast toast = Toast.makeText(this, "Editado!", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.delete:
                Toast toast2 = Toast.makeText(this, "Borrado!", Toast.LENGTH_LONG);
                toast2.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void abrirMain2(View view) {

        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}