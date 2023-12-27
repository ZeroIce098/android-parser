package com.example.app;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String userName = System.getProperty("user.name");
        String deviceLanguage = Locale.getDefault().getDisplayLanguage();
        String availableApiVersions = getAvailableApiVersions();

        TextView osNameTextView = findViewById(R.id.osNameTextView);
        TextView osVersionTextView = findViewById(R.id.osVersionTextView);
        TextView javaVersionTextView = findViewById(R.id.javaVersionTextView);
        TextView userNameTextView = findViewById(R.id.userNameTextView);
        TextView deviceLanguageTextView = findViewById(R.id.deviceLanguageTextView);
        TextView apiVersionsTextView = findViewById(R.id.apiVersionsTextView);

        osNameTextView.setText("OS Name: " + (osName != null ? osName : ""));
        osVersionTextView.setText("OS Version: " + (osVersion != null ? osVersion : ""));
        javaVersionTextView.setText("Java Version: " + (javaVersion != null ? javaVersion : ""));
        userNameTextView.setText("User Name: " + (userName != null ? userName : ""));
        deviceLanguageTextView.setText("Device Language: " + deviceLanguage);
        apiVersionsTextView.setText("Available API Versions: " + availableApiVersions);
    }

    private String getAvailableApiVersions() {
        StringBuilder apiVersions = new StringBuilder();
        int currentApi = Build.VERSION.SDK_INT;

        // Добавление списока доступных версий Android
        for (int i = Build.VERSION_CODES.BASE; i <= currentApi; i++) {
            apiVersions.append("API ").append(i).append(": ").append(Build.VERSION.RELEASE).append("\n");
        }

        return apiVersions.toString();
    }
}


