package com.example.team5.ui.notifications.compare;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.team5.R;

public class CanvasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        FrameLayout container = findViewById(R.id.drawing_container);
        CanvasView canvasView = new CanvasView(this);
        container.addView(canvasView);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}

class CanvasView extends View {
    private final Paint paint;

    public CanvasView(Context context) {
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        float left = getWidth() / 4f;
        float top = getHeight() / 2f - 250;
        float right = getWidth() * 3 / 4f;
        float bottom = getHeight() / 2f + 200;

        canvas.drawRect(left, top, right, bottom, paint);

    }
}
