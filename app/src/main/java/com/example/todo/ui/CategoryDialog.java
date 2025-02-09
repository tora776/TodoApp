package com.example.todo.ui;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.todo.R;

public class CategoryDialog extends BaseDialog {
    private EditText mEditCategoryView;

    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // レイアウトをインフレートしてダイアログに設定
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_add_category, null))
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                        // TODO: カテゴリーをDBに登録する
                        Intent replyIntent = new Intent();
                        if(TextUtils.isEmpty(mEditCategoryView.getText())){
                            // ダイアログの入力値が空の場合
                            setResult(RESULT_CANCELED, replyIntent);
                        } else {
                            // ダイアログが入力されている場合
                            String category_text = mEditCategoryView.getText().toString();
                            replyIntent.putExtra(EXTRA_REPLY, category_text);
                            setResult(RESULT_OK, replyIntent);
                        }
                        finish();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        // User cancels the dialog.
                        dialog.dismiss();
                    }
                });
    return builder.create();
    }
}
