package com.example.mohitsaini.fragmentexample.part_3;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 23/2/17.
 */

public class BlurImage extends AppCompatActivity {
    private static final float BITMAP_SCALE = 0.4f;
    ImageView imageView;
    private float BLUR_RADIUS = 0.1f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blur_image);

        SeekBar s1 = (SeekBar) findViewById(R.id.seekBar1);
        s1.setProgress(1);
        s1.incrementProgressBy(1);
        s1.setMax(10);
        final TextView textView = (TextView) findViewById(R.id.seektv);

        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                BLUR_RADIUS = progress;
                textView.setText("" + BLUR_RADIUS);
                if (BLUR_RADIUS > 0)
                    setEffectOnImage();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        imageView = (ImageView) findViewById(R.id.originalImageView);
        setEffectOnImage();

    }

    public void setEffectOnImage() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pc);
        BlurBuilder blurBuilder = new BlurBuilder();

        Bitmap blurredBitmap = blurBuilder.blur(this, bitmap, BITMAP_SCALE, BLUR_RADIUS);
        imageView.setImageBitmap(blurredBitmap);
    }

}

class BlurBuilder {
    public static Bitmap blur(Context context, Bitmap image, float BITMAP_SCALE, float BLUR_RADIUS) {
        int mWidth = Math.round(image.getWidth() * BITMAP_SCALE);
        int mHeight = Math.round(image.getHeight() * BITMAP_SCALE);
        Bitmap givenBitmap = Bitmap.createScaledBitmap(image, mWidth, mHeight, false);
        Bitmap takenBitmap = Bitmap.createBitmap(givenBitmap);
        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation tmpIn = Allocation.createFromBitmap(rs, givenBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(rs, takenBitmap);
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(takenBitmap);
        return takenBitmap;
    }
}