package mn.tulga.temuujin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import carbon.widget.ImageView;

public class Dialog extends AppCompatDialogFragment {

    private ImageView img;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;


    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.activity_dialog,null );
        builder.setView(view);
           img = view.findViewById(R.id.andro);
           img1 = view.findViewById(R.id.air);
        img2 = view.findViewById(R.id.audi);
        img3 = view.findViewById(R.id.checker);
          
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast();
            }
        });
        return builder.create();
    }


public void Toast(){
    Toast.makeText(getActivity(),"google", Toast.LENGTH_LONG).show();
}
}
