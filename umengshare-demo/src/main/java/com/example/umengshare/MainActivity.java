package com.example.umengshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMSSOHandler;

public class MainActivity extends AppCompatActivity {
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShare = (Button) findViewById(R.id.share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShareDialog();
            }
        });
    }

    private void openShareDialog() {
        new ShareDialog(MainActivity.this, new ShareDialog.onClickback() {
            @Override
            public void onShare(int id) {
                switch (id) {
                    case 1: // 微信
                      //  shareToMedia(SHARE_MEDIA.WEIXIN);
                        ShareUtils.shareWeb(MainActivity.this, Defaultcontent.url, Defaultcontent.title
                                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.WEIXIN
                        );
                        break;
                    case 2: // 朋友圈
                        ShareUtils.shareWeb(MainActivity.this, Defaultcontent.url, Defaultcontent.title
                                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.WEIXIN_CIRCLE
                        );
                        break;
                    case 3: // 微博
                        ShareUtils.shareWeb(MainActivity.this, Defaultcontent.url, Defaultcontent.title
                                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.SINA
                        );
                        break;
                    case 4: // qq
                        ShareUtils.shareWeb(MainActivity.this, Defaultcontent.url, Defaultcontent.title
                                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.QQ
                        );
                        break;
                    case 5: // qq空间
                        ShareUtils.shareWeb(MainActivity.this, Defaultcontent.url, Defaultcontent.title
                                , Defaultcontent.text, Defaultcontent.imageurl, R.mipmap.icon_logo_share, SHARE_MEDIA.QZONE
                        );
                        break;
                }
            }
        }).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //UMSSOHandler
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
