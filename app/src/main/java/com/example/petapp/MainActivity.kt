package com.example.petapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar los fragmentos al inicio
        supportFragmentManager.beginTransaction()
            .replace(R.id.menuFragmentContainer, MenuFragment())
            .replace(R.id.contentFragmentContainer, ContentFragment())
            .commit()
    }
}
