package com.example.umengshare;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/21.
 */

public class ShareDialog extends Dialog {
    private onClickback callback;

    public ShareDialog(Context context, onClickback callback) {
        this(context, R.layout.share_dialog, R.style.my_dialog_style,
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        this.callback = callback;
    }

    public ShareDialog(final Context context, int layout, int style, int width,
                       int height) {
        super(context, style);
        setContentView(layout);
        setCanceledOnTouchOutside(true);
        // 设置属性值
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = width;
        lp.height = height;
        getWindow().setAttributes(lp);
        setListener();
    }

    // 设置点击事件
    private void setListener() {
        findViewById(R.id.iv_wechat).setOnClickListener(
                new android.view.View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(1);
                        dismiss();
                    }
                });
        findViewById(R.id.iv_wxcircle).setOnClickListener(
                new android.view.View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(2);
                        dismiss();
                    }
                });
        findViewById(R.id.iv_sina).setOnClickListener(
                new android.view.View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(3);
                        dismiss();
                    }
                });
        findViewById(R.id.iv_qq).setOnClickListener(
                new android.view.View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        callback.onShare(4);
                        dismiss();
                    }
                });

        findViewById(R.id.cancel).setOnClickListener(
                new android.view.View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
    }

    @Override
    public void show() {
        super.show();
        getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getWindow().setGravity(Gravity.BOTTOM);

    }

    public interface onClickback {
         void onShare(int id);
    }
}
