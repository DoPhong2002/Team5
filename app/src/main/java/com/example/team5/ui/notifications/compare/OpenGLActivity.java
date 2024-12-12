package com.example.team5.ui.notifications.compare;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.team5.R;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        // Thêm OpenGLView vào FrameLayout
        FrameLayout container = findViewById(R.id.drawing_container);
        OpenGLView openGLView = new OpenGLView(this);
        container.addView(openGLView);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}

class OpenGLView extends GLSurfaceView {

    public OpenGLView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        OpenGLRenderer renderer = new OpenGLRenderer();
        setRenderer(renderer);
    }
}

class OpenGLRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        drawRectangle();
    }

    private void drawRectangle() {
        float left = -0.5f;
        float right = 0.5f;
        float top = 0.2f;
        float bottom = -0.2f;

        float[] vertices = {
                left, top, 0.0f,  // Góc trái trên
                right, top, 0.0f,  // Góc phải trên
                left, bottom, 0.0f,  // Góc trái dưới
                right, bottom, 0.0f   // Góc phải dưới
        };

        FloatBuffer vertexBuffer = ByteBuffer.allocateDirect(vertices.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vertexBuffer.put(vertices).position(0);

        // Shader code
        String vertexShaderCode =
                "attribute vec4 vPosition;" +
                        "void main() {" +
                        "  gl_Position = vPosition;" +
                        "}";
        String fragmentShaderCode =
                "precision mediump float;" +
                        "uniform vec4 vColor;" +
                        "void main() {" +
                        "  gl_FragColor = vColor;" +
                        "}";

        // Compile shaders and link program
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
        int program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vertexShader);
        GLES20.glAttachShader(program, fragmentShader);
        GLES20.glLinkProgram(program);
        GLES20.glUseProgram(program);

        // Gắn dữ liệu vertex
        int positionHandle = GLES20.glGetAttribLocation(program, "vPosition");
        GLES20.glEnableVertexAttribArray(positionHandle);
        GLES20.glVertexAttribPointer(positionHandle, 3, GLES20.GL_FLOAT, false, 0, vertexBuffer);

        // Gắn màu xanh lá
        int colorHandle = GLES20.glGetUniformLocation(program, "vColor");
        GLES20.glUniform4f(colorHandle, 0.0f, 1.0f, 0.0f, 1.0f); // Màu xanh lá

        // Vẽ hình chữ nhật
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
        GLES20.glDisableVertexAttribArray(positionHandle);
    }


    private int loadShader(int type, String shaderCode) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

}
